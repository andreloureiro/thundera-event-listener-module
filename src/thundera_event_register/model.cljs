(ns thundera-event-register.model
  (:require [schema.core :as s :include-macros true]))

(def channel-status-change
  {:id s/Str
   :status s/Str
   :attendant s/Str
   :channelCreatedAt s/Str})

(defn make-event-register
  "Takes the event name and payload, returns a data structure representing
  the event to register"
  [event data]
  {:type event :payload data})