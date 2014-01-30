#encoding: utf-8
require 'chunky_png'

class Funkcja

  def initialize(&blok)
    @self = blok
  end

  def value(x)
    @self.call(x)
  end

  def pole(a, b)
    val = 0
    while a <= b
      i = a + 0.001
      val += ((@self.call(i) + @self.call(a)) * 0.001) / 2
      a = i
    end

    return val
  end

  def pochodna(x)
    h = 0.01
    roznica = 1
    f1 = (@self.call(x+h) - @self.call(x))/h
    unless roznica < 0.001
      h /= 2
      f2 = (@self.call(x+h)-@self.call(x))/h
      roznica = (f1-f2).abs
      f1 = f2 
    end

    return f2
  end

  def zerowe(a, b, c = 1)
    dokladnosc = 1
    dokladnosc = (c.to_s.split('').index('.')-c.to_s.length).abs if not c % 1 == 0
    zerowe = Array.new
    sprawdzana = a
    while sprawdzana <= b
      zerowe.push(sprawdzana) if @self.call(sprawdzana) == 0
      sprawdzana = (sprawdzana + c).round(dokladnosc)
    end
    return zerowe if not zerowe.empty?
  end

 def max(a,b)
    maximum = @self.call(a)
    a.upto b do |i|
      maximum = @self.call(i) if @self.call(i) > maximum
      i += 0.001
    end
    return maximum
  end
 
  def min(a,b)
    minimum = @self.call(a)
    a.upto b do |i|
      minimum = @self.call(i) if @self.call(i) < minimum
      i += 0.001
    end
    return minimum
  end

  def wykres(a, b)
    raise ArgumentError, 'Drugi parametr musi być większy od pierwszego.' if b <= a

    szerokosc = (b-a) * 10
    minimum = min(a,b)
    dlugosc = (max(a,b).abs + minimum.abs + 10).ceil * 10
    obraz = ChunkyPNG::Image.new(szerokosc,dlugosc,ChunkyPNG::Color('white'))
    
    if minimum < 0
      wysokoscOX = dlugosc - ((minimum.abs).floor * 10)
    else
      wysokoscOX = dlugosc - 50
    end

    obraz.line(0, wysokoscOX, szerokosc - 1, wysokoscOX, 'black')
    (szerokosc/10).times { |i| obraz.line(i * 10, wysokoscOX - 5, i * 10, wysokoscOX + 5, 'black') }

    obraz.line(a.abs * 10, 0, a.abs * 10, dlugosc - 1, 'black')
    (dlugosc / 10).times { |i| obraz.line(a.abs * 10 - 5, i * 10, a.abs * 10 + 5, i * 10, 'black') }

    poprz = 0
    szerokosc.times do |i|
      punkt = -(@self.call(a + (i / 10.0)) * 10).floor + wysokoscOX
      obraz.line(i, punkt, i - 1, poprz, 'red') if i != 1
      poprz = punkt
      i += 1  
    end

    obraz.save('Wykres.png')
  end

end



#cos = Funkcja.new { | x | -x**2+25 }
cos = Funkcja.new { |x| x*x }
puts cos.value(3)
puts cos.pole(-5,5)
puts cos.pochodna(2)
puts cos.zerowe(-20, 20, 0.001)
puts cos.zerowe(-20, 20, 1)
puts cos.zerowe(-3, 3, 1)
puts cos.zerowe(5, 6)
cos.wykres(-10, 10)
cos.wykres(-10, -20)