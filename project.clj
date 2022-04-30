(defproject
 getting-clojure "0.1.0-SNAPSHOT"
 :description "FIXME: write description"
 :url "http://example.com/FIXME"
 :dependencies [[clanhr/work-days "0.11.0"]
                [clj-gatling "0.17.2"]
                [clj-http "3.12.3"]
                [iso-country-codes "1.0"]
                [mysql/mysql-connector-java "8.0.28"]
                [org.clojars.xbrln/days-on-earth "0.1.2"]
                [org.clojars.xbrln/tower-of-hanoi "0.1.0"]
                [org.clojars.xbrln/strom-cost "0.1.0"]
                [org.clojure/clojure "1.11.1"]
                [org.clojure/data.csv "1.0.1"]
                [org.clojure/data.json "2.4.0"]
                [org.clojure/java.jdbc "0.7.12"]
                [org.clojure/spec.alpha "0.3.218"]
                [org.clojure/test.check "1.1.1"]
                [simple/email-address "1.0.1"]
                [integrant "0.8.0"]
                [integrant/repl "0.3.2"]
                [ring/ring-jetty-adapter "1.9.5"]]

 :main ^:skip-aot getting-clojure.core
 :target-path "target/%s"
 :profiles
 {:uberjar
  {:aot :all
   :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
