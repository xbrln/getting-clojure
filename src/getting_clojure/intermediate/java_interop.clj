(ns getting-clojure.intermediate.java-interop
  (:require [iso-country-codes.core :as cc]))


(cc/country-translate :alpha-2 :name "GE")
