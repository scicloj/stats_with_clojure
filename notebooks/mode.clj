^:kindly/hide-code
(ns mode)

;; # Mode

(def numbers [1 2 2 3 3 3 4 4 4 4 5 5 5 5 5])

numbers

(frequencies numbers)

(sort-by second (frequencies numbers))

(last (sort-by second (frequencies numbers)))

(first (last (sort-by second (frequencies numbers))))

(defn mode [numbers]
  (first (last (sort-by second (frequencies numbers)))))

(mode numbers)

(mode [1 2 3 4 5 6])

;; Fixing the mode function

(defn mode [numbers]
  (let [freqs (frequencies numbers)
        max-freq (apply max (vals freqs))]
    (filter #(= (second %) max-freq) freqs)))

(mode numbers)

(mode [1 2 3 4 5 6])


;; Extracting values from the mode function

(map first (mode numbers))

(map first (mode [1 2 3 4 5 6]))


(defn mode [numbers]
  (let [freqs (frequencies numbers)
        max-freq (apply max (vals freqs))]
    (map first (filter #(= (second %) max-freq) freqs))))

(mode numbers)

(mode [1 2 3 4 5 6])

(mode [1 1 2 2 3 3])

;; Return number if only single mode is present

(defn mode [numbers]
  (let [freqs (frequencies numbers)
        max-freq (apply max (vals freqs))]
    (if (= (count (filter #(= (second %) max-freq) freqs)) 1)
      (first (first (filter #(= (second %) max-freq) freqs)))
      (map first (filter #(= (second %) max-freq) freqs)))))

(mode [1 2 3 4 5 6])

(mode [3 1 1 2 2 3 3])
