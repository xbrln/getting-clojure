(ns getting-clojure.intermediate.fizzbuzz
  (:require [clojure.string :as s]))

; Print numbers from 1 to 100
; For multiples of 3, print Fizz
; For multiples of 5, print Buzz
; For multiples of both 3 & 5, print FizzBuzz

(defn multiple-of? [d n]
  (zero? (mod n d)))

(defn fizzbuzz [n]
  (cond
    (multiple-of? (* 3 5) n) "FizzBuzz"
    (multiple-of? 5 n) "Buzz"
    (multiple-of? 3 n) "Fizz"
    :else n))

(take 100 (map fizzbuzz (rest (range))))

(comment
  ; With condp
  (for [n (range 1 101)]
    (condp multiple-of? n
      (* 3 5) "FizzBuzz"
      5 "Buzz"
      3 "Fizz"
      n))

  ; Without cond, using cycle
  (defn fb
    [a b]
    (if (s/blank? a)
      b
      a))

  (take 100
    (map fb
      (map str
        (cycle [nil nil "Fizz"])
        (cycle [nil nil nil nil "Buzz"]))
      (rest (range))))

  ; with cycle and or
  (map
    (fn [a b c d] (or a b c d))
    (cycle [nil nil nil nil nil
            nil nil nil nil nil
            nil nil nil nil "FizzBuzz"])
    (cycle [nil nil "Fizz"])
    (cycle [nil nil nil nil "Buzz"])
    (range 1 101)))
