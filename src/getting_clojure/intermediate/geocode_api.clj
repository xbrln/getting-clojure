(ns getting-clojure.intermediate.geocode-api
  (:require
   [clj-http.client :as client]
   [clojure.data.json :as json]))

(def sample-1
  {:en {:city "Alcúdia"
        :country "Spain"
        :state-region "Majorca"
        :touristic-region "Balearic Islands"}
   :de {:city "Alcúdia"
        :country "Spanien"
        :state-region "Mallorca"
        :touristic-region "Balearische Inseln"
        :touristic-region-2 "Balearen"}})

(def sample-2
  {:en {:city "Heraklion"
        :country "Greece"
        :state-region "Crete"
        :touristic-region "Southern Aegean Sea"
        :touristic-region-2 "Greek Islands"}
   :de {:city "Heraklion"
        :country "Griechenland"
        :state-region "Kreta"
        :touristic-region "Südliche Ägäis"
        :touristic-region-2 "Griechische Inseln"}})

(defn api-url
  [t]
  (str "https://api.geocode.earth/v1/search?api_key=ge-73dbccb059516037&text=" t))


"1d194d045e3a4746ab2a759264514e67"


(api-url (get-in sample-2 [:de :country]))

(def r (client/get (api-url (get-in sample-2 [:en :city]))))

(json/read-str (get r :body))

(comment)
