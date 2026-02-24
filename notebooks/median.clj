(ns median)

;; for odd number of elements

(def numbers [1 2 3])

numbers

(nth numbers (/ (count numbers) 2))

;; for even number of elements

(def numbers [1 2 3 4])

numbers

(count numbers)

(/ (count numbers) 2)

(nth numbers (/ (count numbers) 2))

(dec (/ (count numbers) 2))

(nth numbers (dec (/ (count numbers) 2)))

;; median

(defn median [numbers]
  (let [n (count numbers)
        sorted-numbers (sort numbers)]
    (if (odd? n)
      (nth sorted-numbers (/ n 2))
      (let [mid1 (nth sorted-numbers (/ n 2))
            mid2 (nth sorted-numbers (dec (/ n 2)))]
        (float (/ (+ mid1 mid2) 2))))))


(median [1 2 3])

(median [1 2 3 4])

(median [2 1 3])

(median [2 1 4 3])
