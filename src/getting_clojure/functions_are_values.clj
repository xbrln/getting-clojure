(ns getting-clojure.functions-are-values
  (:require [getting-clojure.multi-method :as mm]))

(def q {:title "Q"
        :author "Luther blissett"
        :price 25
        :genre :history})
getting-clojure.multi-method/customer
(defn cheap? [book]
  (when (<= (:price book) 20)
    book))

(defn pricey? [book]
  (when (> (:price book) 20)
    book))

(defn history? [book]
  (when (= (:genre book) :history)
    book))

(defn adventure? [book]
  (when (= (:genre book) :adventure)
    book))

(cheap? q)
(pricey? q)
(history? q)
(adventure? q)

(def not-pricey? (complement pricey?))
(not-pricey? q)

(defn both? [arity-f1 arity-f2 book]
  (when (and (arity-f1 book)
             (arity-f2 book))
    book))

(both? pricey? adventure? q)

(defn both-f [arity-f1 arity-f2]
  (fn [book]
    (when (and (arity-f1 book) (arity-f2 book))
      book)))

(def cheap-history? (both-f cheap? history?))
(def pricey-history? (both-f pricey? history?))

(cheap-history? q)

(pricey-history? q)

(def my-vect ["the" "cat" "got" "out"])

(apply str (range 4))

((partial + 1) 33 32 34)

(def add-100 (partial + 100))

(add-100 200 300)

(def foo (vector 0 1 2 3 4 5 6 7 8 9))

(def bar (cons (quote vector) (range 10)))

(eval foo)
(eval bar)

(quote (1 2 3))
'(1 2 3)

(def book {:title "The Stranger"
           :author "Albert Camus"
           :copies-sold 534})
(def book-2 (update book :copies-sold dec))

(:copies-sold book)

(:copies-sold book-2)
