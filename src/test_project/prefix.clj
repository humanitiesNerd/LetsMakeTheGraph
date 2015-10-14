(ns test-project.prefix
  (:require [grafter.rdf :refer [prefixer]]))

;; Defines what will be useful for our next data transformations

(def base-domain (prefixer "http://openpuglia.org"))

(def base-graph (prefixer (base-domain "/lod/")))

(def base-id (prefixer (base-graph "/observation/")))

(def base-sensor (prefixer (base-graph "/sensor/")))

(def base-vocab (prefixer (base-domain "/def/")))

(def base-data (prefixer (base-domain "/data/")))
