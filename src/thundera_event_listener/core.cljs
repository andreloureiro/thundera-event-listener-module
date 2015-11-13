(ns thundera-event-listener.core
  "A Node module to listen and register events created on Resolve
  applications

  This module has only one public method, the `registerEvent`.

  It receives an event type and the payload data for the event. Then, it
  validates against the events schemas registered in this module. If it's
  all ok, the event data is sent to the Events API.

  Author: Andre Loureiro"
  (:require [cljs.nodejs :as node]
            [schema.core :as s :include-macros true]
            [thundera-event-listener.events :as events]
            [thundera-event-listener.model :as model]
            [thundera-event-listener.api :as api]))

(node/enable-util-print!)

(defn ^:export register-event
  "Receives the type of the event and the payload, converts the payload to
  EDN then validates it. If it passes validation, posts to the Events API
  to register it.

  This method is public on the Node module and should be used like this:

  ```
  var eventListenerModule = require('thundera-event-listener-module');

  eventListenerModule.registerEvent('CHANNEL_STATUS_CHANGE', {...});
  ```
  "
  [event-type data]
  (let [event (keyword event-type)
        cljs-data (js->clj data :keywordize-keys true)]
    (when (events/validate-incoming-event event cljs-data)
      (api/post-event
        (model/make-event-register event-type data)))))

(set! (.-exports js/module)
      #js {:registerEvent
           (fn [event-type data] (register-event event-type data))})

;; Returns nil, so nothing is executed when module is required
(set! *main-cli-fn* (fn [_] nil))
