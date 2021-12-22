(ns getting-clojure.intermediate.tests-test
  (:require
   [clojure.test :refer :all]
   [clojure.test.check :as tc]
   [clojure.test.check.clojure-test :as ctest]
   [clojure.test.check.generators :as gen]
   [clojure.test.check.properties :as prop]
   [getting-clojure.intermediate.tests :as t]))

(def books
  [{:title "2001" :author "Clarke" :copies 21}
   {:title "Emma" :author "Austen" :copies 10}
   {:title "Misery" :author "King" :copies 101}])

(deftest find-by-title-test
  (testing "If a book can be found with an existing title or not"
    (is (not (nil? (t/find-by-title "Emma" books))))
    (is (nil? (t/find-by-title "Emmaaa" books)))))

(deftest number-of-copies-of-test
  (testing "Copies in inventory"
    (is (= 10 (t/number-of-copies-of "Emma" books)))))

(def title-gen (gen/such-that not-empty gen/string-alphanumeric))
(def author-gen (gen/such-that not-empty gen/string-alphanumeric))
(def copies-gen (gen/such-that (complement zero?) gen/pos-int))

(def book-gen
  (gen/hash-map :title title-gen :author author-gen :copies copies-gen))

(def inventory-gen (gen/not-empty (gen/vector book-gen)))

(def inventory-and-book-gen
  (gen/let [inventory inventory-gen
            book (gen/elements inventory)]
    {:inventory inventory :book book}))

(gen/sample inventory-and-book-gen)

(ctest/defspec
 find-by-title-finds-books
 50
 (prop/for-all
  [i-and-b inventory-and-book-gen]
  (= (t/find-by-title
      (-> i-and-b :book :title)
      (:inventory i-and-b))
     (:book i-and-b))))

(tc/quick-check
 50
 (prop/for-all
  [i-and-b inventory-and-book-gen]
  (= (t/find-by-title
      (-> i-and-b :book :title)
      (:inventory i-and-b))
     (:book i-and-b))))

(comment)
