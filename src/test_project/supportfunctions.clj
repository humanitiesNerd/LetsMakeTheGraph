(ns test-project.supportfunctions
  (:require
   [clj-time.format :as f]
   [clj-time.core :as t]))

(def multiparser (f/formatter-local "MM/dd/YYYY HH:mm"))
(def id-formatter (f/formatter-local "ddMMYYYYHHmmss"))
(def rdf-formatter (f/formatter-local "MM/dd/YYYY HH:mm:ss"))

(defn parsed-datetime [datetime]
  (f/parse-local multiparser datetime))

(defn unparsed-datetime [formatter datetime]
  (f/unparse-local formatter datetime))

(defn observation-id [datetime substance station-name]
  (str station-name substance 
       (unparsed-datetime id-formatter datetime)
       ))

(defn rdf-datetime [datetime]
  (unparsed-datetime rdf-formatter datetime))

(defn year [datetime]
  (t/year datetime))

(defn month [datetime]
  (t/month datetime))

(defn day [datetime]
  (t/day datetime))
