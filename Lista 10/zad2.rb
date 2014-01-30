class Kolekcja
  def initialize
    @dlugosc = 0
    @pierwszy = nil
    @ostatni = nil
  end

  def insert(elem)
    elem = Element.new(elem)
    @dlugosc += 1

    if @pierwszy.nil?
      @pierwszy = @ostatni = elem
      return self
    end

    temp = @pierwszy
    while not temp.nil?
      if elem < temp
        elem.setNext(temp.next)
        elem.setPrev(temp)
        temp.setNext(elem)
        if not elem.next.nil?
          (elem.next).setPrev(elem)
        else
          @pierwszy = elem
        end
        return self
      end
      temp = temp.prev
    end
    @ostatni.setPrev(elem)
    elem.setNext(@ostatni)
    @ostatni = elem
    return self
  end

  def to_s
    temp = @pierwszy
    zwracana = '{ '
    while not temp.nil?
      zwracana += temp.value.to_s + ' '
      temp = temp.prev
    end
    return zwracana + '}'
  end

  def length
    @dlugosc
  end

  def first
    @pierwszy
  end

  def last
    @ostatni
  end
end

class Element

  include Comparable

  def initialize(elem)
    @value = elem
    @next = nil
    @prev = nil
  end

  def <=>(drugi)
    @value <=> drugi.value
  end

  def value
    @value
  end

  def setNext(elem)
    @next = elem
  end

  def setPrev(elem)
    @prev = elem
  end

  def next
    @next
  end

  def prev
    @prev
  end
end

class Wyszukiwanie

  def binarySearch(kolekcja, elem, l, r)
    dlugosc = r - l
    return nil if dlugosc < 0

    temp = kolekcja.first
    pivot = l + dlugosc/2
    pivot.times do
      temp = temp.prev
    end

    return pivot if temp.value == elem

    if temp.value > elem
      return binarySearch(kolekcja, elem, l, pivot-1)
    else
      return binarySearch(kolekcja, elem, pivot + 1, r)
    end
  end

  def bruteForceSearch(kolekcja, elem)
    dlugosc = kolekcja.length
    temp = kolekcja.first
    dlugosc.times do |i|
      return i if temp.value == elem
      return nil if temp.value > elem
      temp = temp.prev
    end
    return nil
  end

end

test = Kolekcja.new
test.insert(5)
test.insert(10)
test.insert(12)
test.insert(3)
test.insert(6)
test.insert(5)
test.insert(11)
test.insert(5)
test.insert(8)
puts test.to_s
search = Wyszukiwanie.new
puts search.bruteForceSearch(test,5)
puts search.binarySearch(test,5,0,test.length-1)