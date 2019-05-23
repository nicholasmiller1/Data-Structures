stringTest :: String -> Int -> String
stringTest xs y
  | even y = xs
  | otherwise = reverse xs

stringTestList :: [String] -> [String]
stringTestList xs = map (stringTest) xs

splitString :: String -> [String]
splitString xs
  | (length xs) >= 20 = (take 20 xs):(splitString (drop 20 xs))
  | (length xs) == 0 = []
  | otherwise = [xs]