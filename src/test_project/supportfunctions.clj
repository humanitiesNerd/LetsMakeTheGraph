(ns test-project.supportfunctions
  (:require
   [clj-time.format :as f]))

(defn parse-it [datetime]
  (let [multiparser (f/formatter-local "MM/dd/YYYY HH:mm")]
    (f/parse-local multiparser datetime)))

(defn produce-observation-id [datetime substance station-name]
  (let [parsed-datetime (parse-it datetime)]
    (let [custom-formatter (f/formatter-local "ddMMYYYYHHmmss")]
      (str station-name substance (f/unparse-local custom-formatter parsed-datetime)))))
