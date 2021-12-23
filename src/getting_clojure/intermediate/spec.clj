(ns getting-clojure.intermediate.spec
  (:require
   [clojure.spec.alpha :as spec]
   [clojure.spec.test.alpha :as spec-test]))

(def book {:title "getting clojure" :author "Olsen" :copies 20000})

(defn book?
  [b]
  (and
   (map? b)
   (string? (:title b))
   (string? (:author b))
   (pos-int? (:copies b))))

(book? book)

(even? 100)

(spec/valid? even? 100)

(def n-gt-10? (spec/and number? #(> % 10)))

(spec/valid? n-gt-10? 11)

(def n-or-s? (spec/or :a-number number? :a-string string?))

(spec/conform n-or-s? 23)

(def coll-of-maps? (spec/coll-of map?))

(spec/valid? coll-of-maps? ({} {} []))

; collection of strings
(def coll-of-strings? (spec/coll-of string?))
(spec/valid? coll-of-strings? ["F" "d" "q" 4])

; collection od string or numbers
(def coll-of-s-or-n? (spec/coll-of n-or-s?))
(spec/valid? coll-of-s-or-n? [1 2 3 "h"])

; string string number
(def s-s-n? (spec/cat :s1 string? :s2 string? :n1 number?))
(spec/valid? s-s-n? ["fdsf" 34 123])

(spec/def
  ::post-s?
  (spec/keys :req-un [::tags ::destinations]))

(spec/def ::tags string?)

(spec/valid? ::post-s? {:tags 2 :destinations "berlin"})

(spec/explain ::post-s? {:tags 2 :destinations "berlin"})

(spec/conform ::post-s? {:tags 2 :destinations "berlin"})

(defn dob
  [i u]
  (:dob (get u i)))

(spec/fdef dob
  :args (spec/cat :name string?
                  :dob pos-int?))

(spec-test/instrument 'getting-clojure.intermediate.spec/dob)

; (dob 0 [{:dob 82 :name "jack"}
;         {:dob 21 :name "mack"}])










(comment)
