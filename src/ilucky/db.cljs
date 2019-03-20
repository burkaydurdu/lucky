(ns ilucky.db
  (:require
    [reagent.core :as r]))

(defonce app-state (r/atom {:items ["Konyali" "Muessese" "Lara"
                                    "Fistik" "Meshur Kuru" "BurgerKing"]}))

(defn set-item!
  "Set `key' in browser's localStorage to `val`."
  [key val]
  (.setItem (.-localStorage js/window) key (.stringify js/JSON (clj->js val))))

(defn get-item
  "Returns value of `key' from browser's localStorage."
  [key]
  (js->clj (.parse js/JSON (.getItem (.-localStorage js/window) key))))

(defn remove-item!
  "Remove the browser's localStorage value for the given `key`"
  [key]
  (.removeItem (.-localStorage js/window) key))