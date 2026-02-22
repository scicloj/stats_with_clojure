^:kindly/hide-code
(ns index
  (:require [scicloj.kindly.v4.kind :as kind]
            [clojure.string :as str]))


^:kindly/hide-code
(kind/image {:src "notebooks/images/stats_with_clojure.png" :width 400})

^:kindly/hide-code
(kind/md (slurp "./writeup/index.md"))
