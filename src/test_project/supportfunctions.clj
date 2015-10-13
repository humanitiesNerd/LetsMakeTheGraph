(ns test-project.supportfunctions
  (:require
   [clj-time.format :as f]
   [clj-time.core :as t]))

(def multiparser (f/formatter-local "MM/dd/YYYY HH:mm"))
(def custom-formatter (f/formatter-local "ddMMYYYYHHmmss"))

(defn parsed-datetime [datetime]
  (f/parse-local multiparser datetime))

(defn unparsed-datetime [datetime]
  (f/unparse-local custom-formatter datetime))

(defn observation-id [datetime substance station-name]
  (str station-name substance 
       (unparsed-datetime datetime)
       ))

(defn year [datetime]
  (t/year datetime))

(defn month [datetime]
  (t/month datetime))

(defn day [datetime]
  (t/day datetime))
