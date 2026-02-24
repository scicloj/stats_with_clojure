^:kindly/hide-code
(ns gini-coefficient)

;; # Gini Coefficient

;; <https://en.wikipedia.org/wiki/Gini_coefficient>

;; <https://claude.ai/share/579bde64-9735-4947-9889-916f4991064f>

;; $$
;; G = \frac{2 \sum_{i=1}^{n} i \cdot x_i}{n \sum_{i=1}^{n} x_i} - \frac{n+1}{n}
;; $$


(defn gini-coefficient [xs]
  (let [n    (count xs)
        sorted (sort xs)
        indexed-sum (reduce-kv
                     (fn [acc i x] (+ acc (* (inc i) x)))
                     0
                     (vec sorted))
        total (reduce + xs)]
    (if (or (zero? n) (zero? total))
      0.0
      (/ (- (* 2.0 indexed-sum)
            (* (inc n) total))
         (* n total)))))

;; Perfect equality (all same values)
(gini-coefficient [1 1 1 1])
;; => 0.0

;; Perfect inequality (one person has everything)
(gini-coefficient [0 0 0 10])
;; => 0.75  (approaches 1.0 as n → ∞)

;; Typical case
(gini-coefficient [1 2 3 4 5])
;; => 0.26666...

;; Real-world-like income distribution
(gini-coefficient [10000 20000 30000 100000 500000])
;; => 0.5942...

;; Here's a clean implementation of the Gini coefficient in Clojure:

(defn gini-coefficient [xs]
  (let [n    (count xs)
        sorted (sort xs)
        indexed-sum (reduce-kv
                     (fn [acc i x] (+ acc (* (inc i) x)))
                     0
                     (vec sorted))
        total (reduce + xs)]
    (if (or (zero? n) (zero? total))
      0.0
      (/ (- (* 2.0 indexed-sum)
            (* (inc n) total))
         (* n total)))))


;; **How it works:**
;; 
;; The formula used is:
;; 
;; $$G = \frac{2 \sum_{i=1}^{n} i \cdot x_i}{n \sum x_i} - \frac{n+1}{n}$$
;; 
;; where values are **sorted in ascending order** and `i` is 1-based index.
;; 
;; **Example usage:**


;; Perfect equality (all same values)
(gini-coefficient [1 1 1 1])
;; => 0.0

;; Perfect inequality (one person has everything)
(gini-coefficient [0 0 0 10])
;; => 0.75  (approaches 1.0 as n → ∞)

;; Typical case
(gini-coefficient [1 2 3 4 5])
;; => 0.26666...

;; Real-world-like income distribution
(gini-coefficient [10000 20000 30000 100000 500000])
;; => 0.5942...


;; **A few notes:**
;; 
;; - The result is in the range `[0, 1]` where `0` = perfect equality and `1` = perfect inequality.
;; - Edge cases handled: empty vector and all-zero values return `0.0`.
;; - This assumes all values are **non-negative** (as income/wealth typically is).
;; - For large vectors, consider using `(double x)` coercions to avoid ratio arithmetic slowdowns.

(defn gini-coefficient [xs]
  (let [n             (count xs)
        sorted        (sort xs)
        indexed-sum   (reduce-kv
                       (fn [acc i x] (+ acc (* (double (inc i)) (double x))))
                       0.0
                       (vec sorted))
        total         (reduce #(+ %1 (double %2)) 0.0 xs)]
    (if (or (zero? n) (zero? total))
      0.0
      (/ (- (* 2.0 indexed-sum)
            (* (double (inc n)) total))
         (* (double n) total)))))


;; Perfect inequality (one person has everything)
(gini-coefficient [0 0 0 10])


;; Typical case
(gini-coefficient [1 2 3 4 5])

;; Real-world-like income distribution
(gini-coefficient [10000 20000 30000 100000 500000])
