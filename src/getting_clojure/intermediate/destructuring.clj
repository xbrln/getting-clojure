(ns getting-clojure.intermediate.destructuring
  (:require
   [clojure.data.csv :as csv]
   [clojure.java.io :as io]))

(defn read-csv
  "Takes file name and reads data."
  [fname]
  (with-open [reader (io/reader fname)]
    (doall
     (csv/read-csv reader))))

(def artist [:monet :austen])

(let [painter (first artist)
      writer (second artist)]
  (list painter writer))

(let [[painter writer] artist]
  (list painter writer))

(def braze-users (read-csv "/Users/j.kurisingal/HolidayPirates/Data-export/Braze-users-with-custom-attributes.csv"))

(take 3 braze-users)

(comment)
