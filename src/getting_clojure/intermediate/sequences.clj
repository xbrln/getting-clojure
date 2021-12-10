(ns getting-clojure.intermediate.sequences
  "Learning sequences and lazy sequences"
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

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

(apply str
       (interpose " and "
                  (map str/capitalize
                       (map :title
                            (take 2
                                  (reverse
                                   (sort-by :rating films)))))))

(->>
 films
 (sort-by :rating)
 reverse
 (take 2)
 (map :title)
 (map str/capitalize)
 (interpose " and ")
 (apply str))

(map :title (reverse (sort-by :title films)))

(->>
 films
 (sort-by :title)
 reverse
 (map :title))

(defn transform [person]
  (update (assoc person :hair-color :gray) :age inc))

(defn transform2 [person]
  (->
   person
   (assoc :hair-color :red)
   (update :age inc)))

(transform2 {:name "Socrates", :age 39})
(macroexpand '(->
               person
               (assoc :hair-color :red)
               (update :age inc)))

(def repeated-text (repeat "jef"))

(nth repeated-text 10000000)

(take 2 repeated-text)

(first repeated-text)

(take 4 (cycle repeated-text))

(first repeated-text)

(take 3 (iterate #(/ (inc %) %) 4.0))

(->>
 4.0
 (iterate #(/ (inc %) %))
 (take 3))

(take 20 (map #(* 2 %) (iterate inc 0)))

(take 20 (filter even? (range)))
(take 20 (interleave (range) (filter odd? (range))))

(def titles
  (map #(str "Cool book " %)
    (iterate inc 1)))

(def first-name ["Thomman" "Chandi" "Kora" "Piley"])
(def last-name ["Morathil" "Kulathil" "Valappil" "Thenginmukalil"])

(defn combine-names [f-n l-n]
  (str f-n " " l-n))

(def authors
  (map combine-names
    (cycle first-name)
    (cycle last-name)))

(defn make-book [title author]
  {:author author :title title})

(def test-books (map make-book titles authors))

(rest test-books)

(take 5
  (map #(str %1 " - " %2)
    (cycle first-name)
    (cycle last-name)))

(seq [12 3])

(defn laz-seq []
  (println "abc")
  [1 2 3])

(def s (lazy-seq (laz-seq)))

(first s)

(defn my-repeat [x]
  (cons x (lazy-seq (my-repeat x))))

(take 20 (my-repeat "abc"))

(defn my-iterate [f x]
  (cons x (lazy-seq (my-iterate f (f x)))))

(def a (take 3 (my-iterate inc 1)))
(doall a)

(def foo (doall (map println [1 2 3])))



(def list-1 '(["abc" "123" ""]
              ["ytr" "4" ""]))

(def list-2 '(["" "" "" "abc"]
              ["" "" "" "def"]))
