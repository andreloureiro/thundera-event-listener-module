(defproject thundera-event-register "0.1.0-SNAPSHOT"
  :description "Event listener for Resolve Events API"
  :main thundera-event-register.core
  :dependencies [[cljs-http "0.1.37"]
                 [org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [prismatic/schema "1.0.3"]]
  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-npm "0.6.1"]
            [lein-codox "0.9.0"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :npm {:dependencies [request "2.65.0"]}
  :source-paths ["src"]
  :clean-targets ["out" "release"]
  :target-path "target"
  :codox {:language :clojurescript
          :output-path "docs"
          :metadata {:doc/format :markdown}})
