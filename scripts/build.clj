(require '[cljs.build.api :as b])

(println "-> Building Thundera...")

b/build "src"
{:main 'thundera-event-listener.core
 :output-to "out/thundera-event-listener.js"
 :output-dir "out"
 :verbose true
 :optimizations :simple
 :cache-analysis true
 :target :nodejs
 :hashbang false}