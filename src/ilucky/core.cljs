(ns ilucky.core
    (:require
      [reagent.core :as r]
      [ilucky.routes :refer [app-routes]]
      [ilucky.views :refer [current-page]]))


;; -------------------------
;; Initialize app
;; -------------------------

(defn mount-root []
  (app-routes)
  (r/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
