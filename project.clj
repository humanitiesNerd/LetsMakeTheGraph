(defproject test-project "0.1.0-SNAPSHOT"
  :description "FIXME: this part is for you!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [grafter "0.5.0"]
                 [grafter/vocabularies "0.1.2"]
                 [org.slf4j/slf4j-jdk14 "1.7.5"]
                 [clj-time "0.11.0"]]

  :repl-options {:init (set! *print-length* 200)
                 :init-ns test-project.pipeline }

  :jvm-opts ^:replace ["-server"
                       ;;"-XX:+AggressiveOpts"
                       ;;"-XX:+UseFastAccessorMethods"
                       ;;"-XX:+UseCompressedOops"
                       ;;"-Xmx4g"
                       ]

  :plugins [[lein-grafter "0.5.0"]]
  :min-lein-version "2.5.1"

  )
