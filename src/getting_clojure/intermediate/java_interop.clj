(ns getting-clojure.intermediate.java-interop
  (:require [iso-country-codes.core :as cc]
            [tower-of-hanoi.core :as toh]))

(cc/country-translate :alpha-2 :name "GE")
(toh/print-moves 3 "A" "C" "B")
