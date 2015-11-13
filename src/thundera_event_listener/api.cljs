(ns thundera-event-listener.api
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer []]
            [cljs.nodejs :as node]
            [thundera-event-listener.util :as util]))

;; If you're just testing using the simple Node server on ./node-test
;; then you should point the `endpoint` variable to http://localhost:9999
;; otherwise set it to the production URL
(def endpoint "http://localhost:9999")

(defn post-json
  "Wrapper for Node request"
  [url data cb]
  (let [request (node/require "request")]
    (.post request #js {:url url :json data} cb)))

(defn post-event [data]
  "Post the register event to the Events API endpoint"
  (let [json-data (clj->js data)]
    (post-json
      endpoint
      json-data
      (fn [err response body]
        (if err
          (util/log :error (str "Something went wrong!" err))
          (util/log :success
                    (str "Data sent! " (util/json-stringify json-data))))))))