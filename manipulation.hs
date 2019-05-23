stringTest :: String -> Int -> String
stringTest xs y
  | even y = xs
  | otherwise = reverse xs

stringTestList :: [String] -> [String]
stringTestList xs = map (stringTest) xs