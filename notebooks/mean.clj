^:kindly/hide-code
(ns mean)

;; # Mean 

;; $$
;; \mu = \frac{\sum_{i=1}^{n} x_i}{n}
;; $$

(def numbers [1 17 4 -7 6 12 -15 4 10 12])

;; $$
;; \sum_{i=1}^{n} x_i
;; $$

(apply + numbers)

;; $$
;; n
;; $$

(count numbers)

;; $$
;; \frac{\sum_{i=1}^{n} x_i}{n}
;; $$

(/ (apply + numbers) (count numbers))

(float (/ (apply + numbers) (count numbers)))

(defn mean [numbers]
  (float (/ (apply + numbers) (count numbers))))

(mean numbers)

;; ## Visualizing the mean 


