(ns p-1-1-2.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  {:segment-count 24})


(defn update-state [state]
  {:segment-count 24})


(defn draw-state [state]
  (def radius (/ (q/width) 2))

  (q/color-mode :hsb 360 radius radius)
  (q/background 360)
  
  (q/begin-shape :triangle-fan)
  (q/vertex radius radius)

  (def step (/ 360 (:segment-count state)))
  
  (doseq [angle (into [] (range 0 (+ 360 1) step))]
    (q/vertex
     (+ (* (q/cos (q/radians angle)) radius) radius)
     (+ (* (q/sin (q/radians angle)) radius) radius))
    
    (q/fill angle (q/mouse-x) (q/mouse-y)))
  
  (q/end-shape))


(defn -main [& args]
  (q/defsketch p-1-1-2
    :title "Color spectrum in a circle"
    :size [1000 1000]
    :setup setup
    :update update-state
    :draw draw-state
    :features [:keep-on-top]
    :middleware [m/fun-mode]))
