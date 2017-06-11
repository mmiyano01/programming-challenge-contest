module SubsetSum
    ( subsetSum
    ) where

recCheck :: (Ord a, Num a) => a -> [a] ->[[a]]
recCheck sum numList
  |totalNum > 0 = do
    t <- numList
    if x == sum
      then return [x]
    else
      map (x:)(recCheck(delete x numList)(sum-x))
  |otherwise =[]

subsetSum :: IO ()
subsetSum = do
  let n = 5
  let a = [1,2,3,4,5]
  let k = 1

  print n
  print a
  print k
  print (recCheck k a)
