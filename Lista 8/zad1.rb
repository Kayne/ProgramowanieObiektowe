#encoding: utf-8
class Fixnum
  @@slowa = [:zero, :jeden, :dwa, :trzy, :cztery, :pięć, :sześć, :siedem, :osiem, :dziewięć]

  def prime?
    ("1" * self =~ /^1?$|^(11+?)\1+$/) != 0
  end

  def ack m
    raise ArgumentError if self < 0 or m < 0
    if self == 0
      m + 1
    elsif m == 0
      (self-1).ack(1)
    else
      (self-1).ack(ack(m -1))
    end
  end

  def doskonala?
    (1..self/2).inject {|a,x| (self % x == 0) ? a + x : a} == self
  end

  def slownie
    to_s.chars.collect {|c| @@slowa[ c.to_i ]}.join(' ')  
  end
end

puts 5.prime?
puts 6.prime?
puts 127.prime?
puts 2.ack(1)
puts 3.ack(2)
puts 976456.slownie
puts 6.doskonala?
puts 7.doskonala?
begin
  puts -1.ack 1
rescue ArgumentError
  puts "Użyto niewłaściwych argumentów dla funkcji Ackermanna"
end