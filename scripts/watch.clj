(require '[cljs.build.api :as b])

(println "-> Watching Thundera...")

(b/watch "src"
         {:main 'thundera-event-register.core
          :output-to "out/thundera-event-register.js"
          :output-dir "out"
          :source-map "out/thundera-event-register.js.map"
          :optimizations :simple
          :cache-analysis true
          :target :nodejs
          :hashbang false})