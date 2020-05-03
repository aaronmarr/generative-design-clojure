(ns p-1-1-1.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/background 0))


(defn update-state [state])


(defn draw-state [state]
  (q/color-mode :hsb (q/width) (q/height) 100)
  
  (doseq [grid-y (into [] (range 0 (q/height) (+ (q/mouse-y) 2)))
          grid-x (into [] (range 0 (q/width) (+ (q/mouse-x) 2)))]

    (q/fill grid-x (- (q/height) grid-y) 100)
    (q/rect grid-x grid-y (+ (q/mouse-x) 2) (+ (q/mouse-y) 2))))


(defn -main [& args]
  (q/defsketch p-1-1-1
    :title "Color spectrum in a grid"
    :size [800 400]
    :setup setup
    :update update-state
    :draw draw-state
    :features [:keep-on-top]
    :middleware [m/fun-mode]))
