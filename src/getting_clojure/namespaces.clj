(ns getting-clojure.namespaces
  (:require [getting-clojure.loop-recur :as recursion]))

recursion/books

(defn greeting
  ([] (greeting "World"))
  ([x] (greeting "Hello" x))
  ([x y] (str x ", " y "!")))

(defn do-nothing [x]
  x)

(defn always-thing [& a]
  100)

(defn make-thingy [x]
  (fn [& xs] x))

(def new-f (make-thingy 123))

(new-f 1234 "DF")

(defn triplicate [f]
  (f) (f) (f))

(defn opposite [f]
  (fn [& args] (not (apply f args))))

(defn triplicate2 [f & args]
  (triplicate (fn [] (apply f args))))

(triplicate2 + 1 2 3)

(Math/cos Math/PI)

(defn math-f [x]
  (+
   (Math/pow (Math/sin x) 2)
   (Math/pow (Math/cos x) 2)))

(math-f 2)

(slurp "https://www.sportschau.de/fussball/uefaeuro2020/live/index.html")

(defn one-less-arg [f x]
  (fn [& args] (apply f x args)))

(def five-times (partial * 5))

(five-times 5)

(def add-3 (partial + 3))

(add-3 4)
