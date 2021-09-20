(ns getting-clojure.intermediate.stress-test
  (:require [clj-gatling.core :as clj-gatling]
            [org.httpkit.client :as http]))

(defn localhost-request [_]
  (let [{:keys [status]} @(http/get "https://comments.holidaypirates.group/")]
    (= status 200)))

(comment
  (clj-gatling/run
   {:name "Simulation"
    :scenarios [{:name "Localhost test scenario"
                 :steps [{:name "Root"
                          :request localhost-request}]}]}
   {:concurrency 200}))
