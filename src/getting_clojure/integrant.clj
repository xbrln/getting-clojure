(ns getting-clojure.integrant
  (:require
   [integrant.core :as ig]
   [ring.adapter.jetty :as ring-jetty]))

(def config (ig/read-string (slurp "resources/config.edn")))

(defmethod ig/prep-key :ring/jetty [_ config]
  (merge {:port  3000
          :join? false}
         config))

(defmethod ig/init-key :handler/time [_ config]
  (fn [{:keys [request-method uri] :as req}]
    {:status  200
     :body    (str (:prefix config) (java.util.Date.) (:suffix config))
     :headers {"Content-Type" "text/plain"}}))

(defmethod ig/init-key :ring/jetty [_ {:keys [port join? handler]}]
  (ring-jetty/run-jetty handler {:port port :join? join?}))

(defmethod ig/halt-key! :ring/jetty [_ server]
  (.stop server))

(defmethod ig/suspend-key! :ring/jetty [_ server]
  (.stop server))

(defmethod ig/resume-key :ring/jetty [key config old-config server]
  (if (= config old-config)
    (.start server)
    (ig/init-key key config)))

(def system
  (ig/init (ig/prep config)))

(ig/suspend! system)

(ig/halt! system)

(comment

 (set! *print-namespace-maps* false)

 (slurp "http://localhost:3000")

 )
