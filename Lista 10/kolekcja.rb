class Kolekcja
  def initialize
    @kolekcja = Array.new
  end

  def add (element)
    if element.kind_of?(Array)
      element.each { |el| @kolekcja << el }
    else
      @kolekcja << element
    end
    self
  end

  def << (element)
    add element
    self
  end

  def length
    @kolekcja.length
  end

  def swap (pierwszy, drugi)
    pierwszy, drugi = pierwszy - 1, drugi - 1
    temp = @kolekcja[pierwszy]
    @kolekcja[pierwszy] = @kolekcja[drugi]
    @kolekcja[drugi] = temp
    true
  end

  def get (i)
    @kolekcja[i-1]
  end

  def to_s
    @kolekcja.join(',').to_s
  end
end

class Sortowanie

  def sort1 (kolekcja)

   return kolekcja if kolekcja.length <= 1

    swapped = true
    while swapped do
      swapped = false
      1.upto(kolekcja.length-1) do |i|
        if kolekcja.get(i) > kolekcja.get(i+1)
          kolekcja.swap(i, i+1)
          swapped = true
        end
      end    
    end

    kolekcja
  end

  def sort2 (kolekcja)
    1.upto(kolekcja.length-1) do |i|
      min = i
      (i+1).upto(kolekcja.length) do |j|
        min = j if kolekcja.get(j) < kolekcja.get(min)
      end
      kolekcja.swap(i, min)
    end

    kolekcja
  end
end

kol = Kolekcja.new
kol << 7
kol << 4
kol << 3
kol << 8
kol << [6,34,54]
kol << [6,34,54]

puts kol

sort = Sortowanie.new
puts "BubbleSort"
puts sort.sort1(kol)

kol = Kolekcja.new
kol << 7
kol << 4
kol << 3
kol << 8
kol << [6,34,54]
kol << [6,34,54]

puts "QucikSort"
puts sort.sort2(kol)