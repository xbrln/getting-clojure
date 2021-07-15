(ns getting-clojure.multi-method)

; Multimethod example to decide vaccination center based on customer profile

(defn dispatch-customer-profile [customer]
  (cond
    (< (:age customer) 18) :not-eligible
    (< (:age customer) 60) :general-vaccination
    :else :special-vaccination))

(defmulti vaccine-invitation dispatch-customer-profile)

(defmethod vaccine-invitation :not-eligible [customer]
  "Unfortunately you have to wiat till you are 18 to get vaccinated")

(defmethod vaccine-invitation :general-vaccination [customer]
  "Your vaccination center is Arena")

(defmethod vaccine-invitation :special-vaccination [customer]
  "Your vaccination center is Cosmos")

(def customer {:name "James" :age 26})
(def customer2 {:name "Antho" :age 6})
(def customer3 {:name "velama" :age 62})

(vaccine-invitation customer3)

(defn mangoes [data]
  (nth data (- (count data) 1)))
