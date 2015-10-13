(ns test-project.pipeline
    (:require
     [grafter.tabular :refer [defpipe defgraft column-names columns rows
                              derive-column mapc swap drop-rows
                              read-dataset read-datasets make-dataset
                              move-first-row-to-header _ graph-fn melt
                              test-dataset]]
     [grafter.rdf :refer [s]]
     [grafter.rdf.protocols :refer [->Quad]]
     [grafter.rdf.templater :refer [graph]]
     [grafter.vocabularies.rdf :refer :all]
     [grafter.vocabularies.foaf :refer :all]
     [test-project.prefix :refer [base-id base-graph base-vocab base-data]]
     [test-project.transform :refer [->integer]]
     [test-project.supportfunctions :refer [observation-id parsed-datetime year month day]]
     ))

;; Declare our graph template which will destructure each row and
;; convert it into an RDF graph.  This will be the final step in our
;; pipeline definition.

(def make-graph
  (graph-fn [{:keys [name sex age person-uri gender]}]
            (graph (base-graph "example")
                   [person-uri
                    [rdf:a foaf:Person]
                    [foaf:gender sex]
                    [foaf:age age]
                    [foaf:name (s name)]])))


;; Declare a pipe so the plugin can find and run it.  It's just a
;; function from Datasetable -> Dataset.
(defpipe convert-persons-data
  "Pipeline to convert tabular persons data into a different tabular format."
  [data-file]
  (-> (read-dataset data-file)
      (drop-rows 1)
      (make-dataset [:name :sex :age])
      (derive-column :person-uri [:name] base-id)
      (mapc {:age ->integer
             :sex {"f" (s "female")
                   "m" (s "male")}})))

(defpipe deal-with-datetimes
  "Pipeline to prepare the data in the csv file to be expressed as an rdf file"
  [data-file]
  (-> (read-dataset data-file)
      (make-dataset [:datetime :substance :value :measurement-unit :station :lat :lon])
      (mapc {:datetime parsed-datetime})
      (derive-column :observation-id [:datetime :substance :station] observation-id)
      (derive-column :year [:datetime] year)
      (derive-column :month [:datetime] month)
      (derive-column :day [:datetime] day)
      )
  )

;; Declare a graft so the plugin can find and run it.  A graft is the
;; composition of a pipe with graph-fn graph template.
(defgraft convert-persons-data-to-graph
  "Pipeline to convert the tabular persons data sheet into graph data."
  convert-persons-data make-graph)
