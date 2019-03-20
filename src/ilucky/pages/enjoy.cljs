(ns ilucky.pages.enjoy
  (:require
    [antizer.reagent :as ant]
    [ilucky.db :refer [app-state]]))

(defn random-generate []
  (let [items (-> @app-state :items)]
    (swap! app-state assoc :random (get (vec items) (rand-int (count items))))))

(defn add-item []
  (swap! app-state update :items conj (-> @app-state :item))
  (swap! app-state assoc :item ""))

(defn enjoy []
  [:div.enjoy-box
   [:div.left-box
    [ant/input {:type "text"
                :class ["enjoy-input"]
                :value (-> @app-state :item)
                :placeholder "Data input"
                :on-change #(swap! app-state assoc :item
                                   (-> % .-target .-value))}]

    [ant/button {:type "primary"
                 :class ["enjoy-button"]
                 :on-click #(add-item)} "Add"]

    [ant/button {:class ["random-button" "enjoy-button"]
                 :on-click #(random-generate)} "Random"]

    [ant/button {:class ["clear-button" "enjoy-button"]
                 :on-click #((swap! app-state assoc :item "")
                              (swap! app-state assoc :items [])
                              (swap! app-state assoc :random ""))} "Clear"]]
   [:div.right-box
    [:ul
     (for [item (-> @app-state :items)]
       ;^{:key item}
       ^{:key (str (random-uuid))} [:li.list-text item])]
    (if-not (clojure.string/blank? (-> @app-state :random))
      [:p.random-text.nostalgic-box-1  (-> @app-state :random)])]])