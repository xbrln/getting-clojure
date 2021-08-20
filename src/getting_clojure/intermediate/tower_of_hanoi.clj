(ns getting-clojure.intermediate.tower-of-hanoi)

(defn toh
  "Calculate the number of moves for the given number of disks"
  [n]
  (- (reduce * (repeat n 2)) 1))

(toh 9)
