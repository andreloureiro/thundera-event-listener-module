(ns thundera-event-register.events
  (:require [thundera-event-register.model :as model]
            [thundera-event-register.util :as util]
            [schema.core :as s]))

(defn validate-schema
  "Validate the provided Schema model against the payload data received."
  [schema data]
  (when (= (s/validate schema data) data)
    true))

(defmulti validate-incoming-event
          "Implements multimethods for each event type that this module will
           send to the Events API.

           When a new type of event is created, a new validate-incoming-event
           must be created, otherwise there'll be no routing to the schema
           validation.

           Must receive an event type symbol and data object
           representing the payload data. If no key is found, raises an error."
  (fn [data] (:type data)))

(defmethod validate-incoming-event :CHANNEL_STATUS_CHANGE
  [data]
  (validate-schema model/channel-status-change (:payload data)))

(defmethod validate-incoming-event :default
  [data]
  (util/key-not-found (:payload data)))