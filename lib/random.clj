(ns random)

(defn random-number
  ([min max]
   (+ (rand-int (- (inc max) min)) min))
  ([max]
   (random-number 0 max))
  ([]
   (random-number 0 1)))

(defn random-numbers
  ([n min max]
   (take n (repeatedly #(random-number min max))))
  ([n max]
   (random-numbers n 0 max))
  ([n]
   (random-numbers n 0 1)))

