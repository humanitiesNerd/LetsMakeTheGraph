(ns test-project.vocabularies
  (:require [grafter.vocabularies.core :refer :all]
            [grafter.vocabularies.xsd :refer [xsd]]))


(def ssn (prefixer "http://purl.oclc.org/NET/ssnx/ssn#"))
(def ssn:Observation (ssn "Observation"))
(def ssn:observationResultTime (ssn "observationResultTime"))
(def ssn:isProducedBy (ssn "isProducedBy"))
(def ssn:observedProperty (ssn "observedProperty"))
(def ssn:hasValue (ssn "hasValue"))
(def ssn:hasOutput (ssn "hasOutput"))
(def ssn:observes (ssn "observes"))



(def openarpa-obs (prefixer "http://openpuglia.org/lod/observation/"))
(def openarpa-sens (prefixer "http://openpuglia.org/lod/sensor/"))

(def xsd:dateTime (xsd "dateTime"))
(def xsd:gYear (xsd "gYear"))
(def xsd:gMonth (xsd "gMonth"))
(def xsd:gDay (xsd "gDay"))
(def xsd:time (xsd "time"))

(def time (prefixer "http://www.w3.org/2006/time#"))
(def time:year (time "year"))
(def time:month (time "month"))
(def time:day (time "day"))
(def time:inDateTime (time "inDateTime"))

(def basic (prefixer "http://def.seegrid.csiro.au/isotc211/iso19103/2005/basic#"))
(def basic:uom (basic "uom"))
