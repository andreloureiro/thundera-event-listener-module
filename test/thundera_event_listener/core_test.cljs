(ns thundera-event-listener.core-test
  (:require [cljs.test :refer-macros [deftest is testing run-tests async]]
            [schema.core :as s :include-macros true]
            [thundera-event-listener.api :as api]
            [thundera-event-listener.core :as core]
            [thundera-event-listener.events :as events]
            [thundera-event-listener.model :as model]
            [thundera-event-listener.util :as util]))

(def schema-mock {:id s/Str
                  :status s/Str
                  :attendant s/Str
                  :channelCreatedAt s/Str})
(def type-mock :CHANNEL_STATUS_CHANGE)
(def data-mock {:id "channelId"
                :status "waiting"
                :attendant "sendy"
                :channelCreatedAt "Tue Nov 10 2015 09:51:24 GMT-0200 (BRST)"})
(def type-input-mock "CHANNEL_STATUS_CHANGE")
(def data-input-mock (clj->js data-mock))


;;- API

(deftest api-ns

  (testing "endpoint url"
    (is (= (exists? api/endpoint) true)))

  (testing "post-event"))


;;- Core

(deftest core-ns

  (testing "register-event"))


;;- Events

(deftest events-ns

  (testing "validate-schema"
    (is (= (events/validate-schema schema-mock data-mock) true)))

  (testing "validate-incoming-event"
    (let [event-mock {:type type-mock :payload data-mock}]
      (is (= (events/validate-incoming-event event-mock)
             true)))))


;;- Model

(deftest model-ns

  (testing "make-event-register"
    (let [event-register-mock (model/make-event-register type-mock data-mock)]
      (is (= event-register-mock {:type type-mock :payload data-mock})))))


;;- Util

(deftest util-ns

  (testing "symbol->string"
    (is (= (util/symbol->string :CHANNEL_STATUS_CHANGE)
           "CHANNEL_STATUS_CHANGE")))

  (testing "key-not-found")

  (testing "payload-schema-invalid"))


(run-tests)
