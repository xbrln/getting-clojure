(defproject getting-clojure "0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
                      :url "https://www.eclipse.org/legal/epl-2.0/"}
            :dependencies [[org.clojure/clojure "1.10.1"]
                           [org.clojure/java.jdbc "0.4.2"]
                           [mysql/mysql-connector-java "5.1.38"]
                           [simple/email-address "1.0.1"]
                           [clanhr/work-days "0.11.0"]
                           [iso-country-codes "1.0"]
                           [org.clojars.xbrln/tower-of-hanoi "0.1.0"]
                           [org.clojars.xbrln/strom-cost "0.1.0"]
                           [org.clojars.xbrln/days-on-earth "0.1.2"]
                           [clj-gatling "0.16.0"]]
            :main ^:skip-aot getting-clojure.core
            :target-path "target/%s"
            :profiles {:uberjar {:aot :all
                                 :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
