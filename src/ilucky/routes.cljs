(ns ilucky.routes
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.history.Html5History)
  (:require [secretary.core :as secretary]
            [ilucky.db :refer [app-state get-item]]
            [goog.events :as events]
            [goog.history.EventType :as EventType]
            [reagent.core :as reagent]))

(defn hook-browser-navigation! []
  (doto (Html5History.)
    (events/listen
      EventType/NAVIGATE
      (fn [event]
        (secretary/dispatch! (.-token event))))
    (.setEnabled true)))


(defn app-routes []
  (secretary/set-config! :prefix "#")

  (defroute "/" []
            (swap! app-state assoc :page :home))
  (defroute "/enjoy" []
              (swap! app-state assoc :page :enjoy))

  (hook-browser-navigation!))
