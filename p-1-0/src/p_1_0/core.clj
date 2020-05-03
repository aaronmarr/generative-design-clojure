(ns p-1-0.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/frame-rate 30))


(defn update-state [state])


(defn draw-state [state]
  (q/color-mode :hsb 360 100 100)
  (q/rect-mode :center)
  (q/no-stroke)
  (q/background (/ (q/mouse-y) 2) 100 100)
  (q/fill (- 360 (/ (q/mouse-y) 2)) 100 100)
  (q/rect 360 360 (+ (q/mouse-x) 1) (+ (q/mouse-x) 1)))


(defn -main [& args]
  (q/defsketch p-1-0
    :title "Hello, color"
    :size [720 720]
    :setup setup
    :update update-state
    :draw draw-state
    :features [:keep-on-top]
    :middleware [m/fun-mode]))
