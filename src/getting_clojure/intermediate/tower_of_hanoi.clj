(ns getting-clojure.intermediate.tower-of-hanoi)

(defn toh-moves
  "Calculate the number of moves for the given number of disks.
  n is the total number of disks.
  Formula: (2 pow n) - 1"
  [n]
  (- (reduce * (repeat n 2)) 1))

(toh-moves 3)

(defn toh-stepsw
  "Print all the moves for solving the puzzle.
  n is the total number of disks.
  from, to and aux are the names for the rods."
  [n from to aux]
  (if (= n 1)
    (println "Move disk 1 from " from " to " to)
    (do
      (tower (dec n) from aux to)
      (println "Move disk " n " from " from " to " to)
      (tower (dec n) aux to from))))

(toh-steps 3 "A" "C" "B")
