(require '[cljs.build.api :as b])

(println "-> Releasing Thundera Event Listener Module...")

(let [start (System/nanoTime)]
  (b/build "src"
           {:output-to "release/thundera-event-listener.js"
            :output-dir "release"
            :optimizations :simple
            :target :nodejs
            :verbose true
            :hashbang false})
  (println "...done! Took " (/ (- (System/nanoTime) start) 1e9) "seconds"))