(ns getting-clojure.intermediate.tests)

(def books
  [{:title "2001" :author "Clarke" :copies 21}
   {:title "Emma" :author "Austen" :copies 10}
   {:title "Misery" :author "King" :copies 101}])

(defn find-by-title
  [title books]
  (some #(when (= (:title %) title) %) books))

(defn number-of-copies-of
  [title books]
  (:copies (find-by-title title books)))

(number-of-copies-of "2001" books)

(find-by-title "Emma" books)



(comment)
