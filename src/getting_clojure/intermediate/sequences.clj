(ns getting-clojure.intermediate.sequences
  "Learning sequences and lazy sequences"
  (:require [clojure.java.io :as io]))

(defn my-count [collection]
  (loop [count 0 collection collection]
    (if (seq collection)
      (recur (inc count) (rest collection))
      count)))

(def a [1 2 3 4])

(my-count a)

(def films [{:title "shawshank redemption" :rating 9}
            {:title "Druk" :rating 9}
            {:title "Withnail and I" :rating 8}
            {:title "Kajillionaire" :rating 7}])

(defn must-see? [film]
  (when (= (:rating film) 9)
    film))

(filter must-see? films)
(some must-see? films)

(for [f films]
  (count (:title f)))

(map (comp count :title) films)

(defn sum-up-ratings [s f]
  (+ s (:rating f)))

(reduce sum-up-ratings 0 films)

(reduce (fn [s f] (+ s (:rating f))) 0 films)

(reduce #(+ %1 (:rating %2)) 0 films)

(defn high-rated [h f]
  (if (> (:rating f) h)
    (:rating f)
    h))

(reduce high-rated 0 films)

(reverse (sort-by :rating films))

(def f (line-seq (io/reader "LICENSE")))
(pr-str ["books" "blacls"])
