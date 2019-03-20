(ns ilucky.views
  (:require
    [ilucky.pages.home :refer [home]]
    [ilucky.pages.enjoy :refer [enjoy]]
    [ilucky.db :refer [app-state]]))


(defmulti current-page #(@app-state :page))

(defmethod current-page :home []
  [home])

(defmethod current-page :enjoy []
  [enjoy])

(defmethod current-page :default []
  [:div "default"])