(ns getting-clojure.let)

(defn compute-discount-amount
  [amount discount-percent min-charge]
  (let [discounted-amount (* amount (- 1.0 discount-percent))]
    (if (> discounted-amount min-charge)
      discounted-amount
      min-charge)))

(compute-discount-amount 2.0 0.15 1.5)

(def user-discount-chart {"andiyappan" 0.1
                          "richie" 0.2})

(defn make-discount-calculater-f
  [user-name user-discount-chart min-amount]
  (let [discount-percent (user-discount-chart user-name)]
    (fn [amount]
      (let [discounted-amount (* amount (- 1.0 discount-percent))]
        (if (> discounted-amount min-amount)
          discounted-amount
          min-amount)))))

(def discount-for-andie
  (make-discount-calculater-f "andiyappan" user-discount-chart 1.5))

(def discount-for-richie
  (make-discount-calculater-f "richie" user-discount-chart 1.5))

(discount-for-andie 10)
(discount-for-richie 10)

(def anonymous-book {:title "margarita"})
(def with-author {:title "dog days" :author "bulgakow"})

(defn uppercase-author [book]
  (if-let [author (:author book)]
    (.toUpperCase author)))

(uppercase-author with-author)
(uppercase-author anonymous-book)

(def ^:dynamic *a* "b")

(defn mangoes [n]
  (binding [*a* "c"]
    (if (= *a* "c")
      (str n " mangoes"))))

(mangoes 10)
(def team ["germany" "Portugal" "france" "hungary"])
team
*1
