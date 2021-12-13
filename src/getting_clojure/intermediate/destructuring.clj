(ns getting-clojure.intermediate.destructuring
  (:require
   [clojure.data.csv :as csv]
   [clojure.java.io :as io]
   [clojure.string :as str]))

(defn read-csv
  "Takes file name and reads data."
  [fname]
  (with-open [reader (io/reader fname)]
    (doall
     (csv/read-csv reader))))

   ; (def braze-users (read-csv "/Users/j.kurisingal/HolidayPirates/Data-export/Braze-users-with-custom-attributes.csv"))

   ; (def firebase-users (read-csv "/Users/j.kurisingal/HolidayPirates/Data-export/firebase-users-all.csv"))

   ; (take 3 firebase-users)

; Destructuring
(def artist [:monet :austen])

(let [painter (first artist)
      writer (second artist)]
  (list painter writer))

(let [[painter writer] artist]
  (list painter writer))

; Destructuring in function without let
(defn wish-list [shout [i1 i2 i3]]
  (let [msg (str "wish list items are " i1 ", " i2 ", " i3)]
    (if shout (str/upper-case msg) msg)))

(wish-list true [:advent :tea :chocolate])

; Destructuring maps

(def destruct-map [{:name :leo :job :actor}
                   {:name :matthai :job :accounts}
                   {:name :peetappan :job :sports-teacher}])

(defn list-name-and-jobs
  [{name :name job :job}]
  (str name " is working as " job))

(map list-name-and-jobs destruct-map)

(def bob {:job "singer"
          :albums [{:title "blowin in the wind" :year 1968}
                   {:title "highway 69" :year 1969}]})

(let [{job :job
       [{title :title}
        {year :year}]:albums}
      bob]
  (str "bob's job was " job " whose albums were " title))

(let [{:keys [job albums]} bob]
  (str job albums))

(defn add-greeting
  [character]
  (let [{:keys [name age]} character]
    (assoc character
           :greeting
           (str "hello " name " with age " age))))

(add-greeting {:name "jef" :age 40})

(defn add-greeting-2
  [{:keys [name age]:as character}]
  (assoc character
         :greeting
         (str "hello " name " with age " age)))

(add-greeting {:name "jef" :age 40})

(comment)
