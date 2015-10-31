(ns test-project.supportfunctions
  (:require
   [clj-time.format :as f]
   [clj-time.core :as t]
   ))

(def multiparser (f/formatter-local "dd/MM/YYYY HH:mm"))
(def id-formatter (f/formatter-local "ddMMYYYYHHmmss"))
(def rdf-formatter (f/formatter-local "dd/MM/YYYY HH:mm:ss"))
(def daytime-formatter (f/formatter-local "HH:mm:ss"))

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


(defn daytime [datetime]
  (unparsed-datetime daytime-formatter datetime))

(def reconciliated-values
  {"NO2" {:denomination "NO2"
          :dbpedia "Nitrogen_dioxide"
          :dbpedia-it "Diossido_di_azoto"}
   "CO" {:denomination "CO"
         :dbpedia "Carbon_monoxide"
         :dbpedia-it "Monossido_di_carbonio"}
   "HC" {:denomination "HC"
         :dbpedia "Hydrocarbon"
         :dbpedia-it "Idrocarburi"}
   "NO" {:denomination "NO"
         :dbpedia "Nitric_oxide"
         :dbpedia-it "Monossido_di_azoto" }
   "NOx" {:denomination "NOx"
          :dbpedia "NOx"
          :dbpedia-it "NOx"}
   "O3" {:denomination "O3"
         :dbpedia "Ozone"
         :dbpedia-it "Ozono" }
   "PM10" {:denomination "PM10"
           :dbpedia "Particulates"
           :dbpedia-it "PM10" }
   "SO2" {:denomination "SO2"
          :dbpedia "Sulfur_dioxide"
          :dbpedia-it "Diossido_di_zolfo"}
   "CH4" {:denomination "CH4"
          :openarpa "CH4"}
   "H2S" {:denomination "H2S"
          :openarpa "H2S"}
   "NMHC" {:denomination "NMHC"
           :openarpa "NMHC"}
   })



