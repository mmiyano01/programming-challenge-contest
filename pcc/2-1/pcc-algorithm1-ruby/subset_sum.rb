class SubsetSum
  def initialize
    @n = 4
    @a = [1,2,4,7]
    @k = 13
  end

  def subset_sum
    puts calc_sum
  end

  def calc_sum
    for i in 0..@n-1
      sum = 0
      for j in i..@n-1
        sum = sum + @a[j]
        return "YES" if sum == @k
      end
    end
    "NO"
  end
end

SubsetSum.new.subset_sum
