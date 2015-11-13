(require '[cljs.build.api :as b])

(println "-> Watching Thundera...")

(b/watch "src"
         {:main 'thundera-event-listener.core
          :output-to "out/thundera-event-listener.js"
          :output-dir "out"
          :source-map "out/thundera-event-listener.js.map"
          :optimizations :simple
          :cache-analysis true
          :target :nodejs
          :hashbang false})