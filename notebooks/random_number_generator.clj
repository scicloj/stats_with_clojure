^:kindly/hide-code
(ns random-number-generator)

(rand)

(rand-int 10)

(take 10 (repeatedly #(rand-int 10)))

(mod 10 3)

(defn random-number [min max]
  (+ (rand-int (- (inc max) min)) min))

(random-number 32 42)

(random-number 32 42)

(take 5 (repeatedly #(random-number 32 42)))


(defn random-number
  ([min max]
   (+ (rand-int (- (inc max) min)) min))
  ([max]
   (random-number 0 max))
  ([]
   (random-number 0 1)))

(random-number 10)

(random-number)

(random-number 10 20)

(defn random-numbers [n min max]
  (take n (repeatedly #(random-number min max))))

(random-numbers 10 32 42)

(defn random-numbers
  ([n min max]
   (take n (repeatedly #(random-number min max))))
  ([n max]
   (random-numbers n 0 max))
  ([n]
   (random-numbers n 0 1)))

(random-numbers 10)

(random-numbers 10 42)

(random-numbers 10 32 42)
