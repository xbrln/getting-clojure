(ns getting-clojure.ka
  "Function to calculate kurzarbeit.")

(defn average-work-hours-per-day
  "Calculate average work hours per day based on kurzarbeit"
  [employee-profile]
  (/
   (*
    (:hours-per-day employee-profile)
    (:work-percentage employee-profile))
   100))

(defn holiday-hours
  "Calculate the number of hours which are holiday"
  [employee-profile]
  (*
   (average-work-hours-per-day employee-profile)
   (:holiday employee-profile)))

(defn work-hours
  "Calculate the number of hours the employee has to work"
  [employee-profile]
  (/
   (*
    (:weekdays employee-profile)
    (:hours-per-day employee-profile)
    (:work-percentage employee-profile))
   100))

(defn ka-work-hours
  "Calculate work hours during KA"
  [employee-profile]
  (-
   (work-hours employee-profile)
   (* (:vacation employee-profile) 8)
   (* (:sick-day employee-profile) 8)
   (holiday-hours employee-profile)))

(def employee-profile
  "An example of an employees work profile"
  {:work-percentage 45.0
   :weekdays 22
   :hours-per-day 8
   :holiday 0
   :vacation 3
   :sick-day 1})

(ka-work-hours employee-profile)
