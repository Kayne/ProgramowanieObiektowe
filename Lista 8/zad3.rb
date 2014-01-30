#encoding: utf-8
module Cezar

  @@alfabet = "aąbcćdeęfghijklłmnńoóprsśtuwyzźż".split("")

  def initialize t
    @tekst = t.to_s.downcase
  end

  def to_s
    @tekst
  end

  def znajdz_element x, y
    count = 0
    x.each do |z|
      return count if y == z
      count += 1
    end
    0
  end

  class Jawna

    def zaszyfruj klucz
      wynik = ""
      @tekst.each_char do |z|
        if z == " "
          wynik << "#"
        else
          wynik << @@alfabet[(znajdz_element(@@alfabet,z)+(klucz.to_i+1))%32]
        end
      end
      Zaszyfrowane.new(wynik)
    end
  end

  class Zaszyfrowane

    def odszyfruj klucz
      wynik = ""
      @tekst.each_char do |z|
        if z == "#"
          wynik << " "
        else
          wynik << @@alfabet[(znajdz_element(@@alfabet,z)-(klucz.to_i+1))%32]
        end
      end
      Jawna.new(wynik)
    end
  end
end

## Program testujący ##
include Cezar

puts "Tekst do szyfrowania: Ala ma kota"
test = Jawna.new("Ala ma kota")
puts test.zaszyfruj(35)

test2 = Jawna.new("Ala nie ma kota")
puts test2.zaszyfruj(5)

test = Zaszyfrowane.new(test.zaszyfruj(3))
puts test.odszyfruj(3)

test2 = Zaszyfrowane.new(test2.zaszyfruj(5))
puts test2.odszyfruj(5)