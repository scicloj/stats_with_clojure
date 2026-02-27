(ns stats-range
  (:require [random :as r]))

(def numbers (r/random-numbers 10 1 100))

numbers

(defn stats-range [numbers]
  (- (apply max numbers) (apply min numbers)))

(stats-range numbers)
