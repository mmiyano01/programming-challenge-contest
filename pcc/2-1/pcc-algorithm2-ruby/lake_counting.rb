class LakeCounting
  def initialize
    @n = 10
    @m = 12
    @garden = [
      ['W','.','.','.','.','.','.','.','.','W','W','.'],
      ['.','W','W','W','.','.','.','.','.','W','W','W'],
      ['.','.','.','.','W','W','.','.','.','W','W','.'],
      ['.','.','.','.','.','.','.','.','.','W','W','.'],
      ['.','.','.','.','.','.','.','.','.','W','.','.'],
      ['.','.','W','.','.','.','.','.','.','W','.','.'],
      ['.','W','.','W','.','.','.','.','.','W','W','.'],
      ['W','.','W','.','W','.','.','.','.','.','W','.'],
      ['.','W','.','W','.','.','.','.','.','.','W','.'],
      ['.','.','W','.','.','.','.','.','.','.','W','.']
    ]
  end

  #walk through garden to find 'W'
  def walk_through
    count = 0
    for i in 0..@n-1
      for j in 0..@m-1
        if @garden[i][j] == 'W'
          @garden[i][j] = 'C'
          count += 1
          check_around(i,j)
        end
      end
    end
    puts count
  end
  #check around the target which had 'W'
  #recursively loop if neighbor has 'W' and change to 'C'
  def check_around(x,y)
    for i in x-1..x+1 do
      for j in y-1..y+1 do
        if i >= 0 && i < @n && j >= 0 && j < @m && @garden[i][j] == 'W'
          @garden[i][j] = 'C'
          check_around(i,j)
        end
      end
    end
  end
end

LakeCounting.new.walk_through
