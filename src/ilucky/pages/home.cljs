(ns ilucky.pages.home
  (:require
    [antizer.reagent :as ant]))

(defn home []
  [:div
   [:div.home-header.nostalgic-box-1
    [:a.home-start.nostalgic-button-box-1 {:href "/#/enjoy"} "Let's Start"]
    [:p.home-text "How are you guys :)"]]])