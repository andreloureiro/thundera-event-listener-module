(ns thundera-event-listener.core-test
  (:require [cljs.test :refer-macros [deftest is testing run-tests use-fixtures]]
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

  (testing "keyword->string"
    (is (= (util/symbol->string :CHANNEL_STATUS_CHANGE)
           "CHANNEL_STATUS_CHANGE")))

  (testing "validate-incoming-event"
    (is (= (events/validate-incoming-event type-mock data-mock)
           true))))


;;- Model

(deftest model-ns

  (testing "make-event-register"
    (let [
          json-mock (clj->js {:type type-mock :payload data-mock})
          event-register-mock (model/make-event-register type-mock data-mock)]
      (is (= event-register-mock json-mock)))))


;;- Util

(deftest util-ns

  (testing "keyword->string"
    (is (= (util/symbol->string :CHANNEL_STATUS_CHANGE) "CHANNEL_STATUS_CHANGE")))

  (testing "key-not-found")

  (testing "payload-schema-invalid"))


(run-tests)
