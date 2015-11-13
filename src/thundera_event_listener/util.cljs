(ns thundera-event-listener.util
  (:require [clojure.string :as string]))

(defn symbol->string
  "Converts a symbol to a string"
  [kw]
  (-> kw
      (str)
      (string/replace ":" "")))

(defn key-not-found
  "Raises an error indicating that the key wasn't found"
  [event]
  (let [event-error (symbol->string event)]
    (throw (js/Error. (str "Event type not found - " event-error)))))

(defn payload-schema-invalid
  "Raises an error indicating that the payload schema wasn't valid"
  [event data]
  (let [event-error (symbol->string event)
        payload-error (str data)]
    (throw
      (js/Error.
        (str
          "Payload schema invalid for event type "
          event-error " - " payload-error)))))

(defn json-stringify
  "Wrapper for JSON.stringify"
  [json]
  (.stringify js/JSON json))

(defn log
  "Logging helper function. Receives a symbol with the type of the log
  and a message"
  [event-type message]
  (condp = event-type
    :info (.log js/console (str "[THUNDERA-EVENT-LISTENER] : INFO : " message))
    :error
    (.log js/console (str "[THUNDERA-EVENT-LISTENER] : ERROR : " message))
    :success
    (.log js/console (str "[THUNDERA-EVENT-LISTENER] : SUCCESS : " message))
    nil))