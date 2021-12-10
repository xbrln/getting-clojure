(ns getting-clojure.loop-recur
  (:require [clojure.string :as s]))

(defn add-till [end-number]
  (loop [total 0 count 0 end-number end-number]
    (if (= count end-number)
      total
      (recur (+ total (+ count 1)) (+ count 1) end-number))))

(add-till 50)

(def books
  [{:title "Sapiens" :copies-sold 2000}
   {:title "Homo dius" :copies-sold 1000}
   {:title "21 Lessons for 21st century" :copies-sold 1500}])

; map reduce
(defn sum-copies [books]
  (reduce + 0 (map :copies-sold books)))

(sum-copies books)

; loop recur
(defn total-book-sales [books]
  (loop [books books total 0]
    (if (empty? books)
      total
      (recur
       (rest books)
       (+ total (:copies-sold (first books)))))))

(total-book-sales books)

; Maps
(map inc [1 2 3 4])

(map (fn pluralise-animals [animal-name]
       (str animal-name "s"))
     ["dog" "cat" "ant"])

; Filter
(filter even? (range 10))
(filter :a [{:a 1}
            {:a 2}
            {:b 3}
            {:a false}])
(filter (fn [x]
          (not (zero? (mod x 3)))
         (range 10)))
; Reduce
(reduce + [])

(into #{"a" "b"} (range 3))

(reduce conj #{"a" "b"} (range 3))

(apply str (into () "abcd"))
