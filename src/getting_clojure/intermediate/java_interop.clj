(ns getting-clojure.intermediate.java-interop
  (:require [iso-country-codes.core :as cc]
            [tower-of-hanoi.core :as toh]
            [strom-cost.core :as sc]
            [days-on-earth.core :as doe]))

(cc/country-translate :alpha-2 :name "GE")
(toh/print-moves 3 "A" "C" "B")
(sc/calculate {:appliance-wattage 19 :price-per-kWh 0.3055 :currency "Euro" :usage-in-hours 120})
(doe/calculate {:year 1947 :month 10 :day 26})
(doe/forecast {:year 1992 :month 10 :day 20} 1000 20)
