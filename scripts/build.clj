(ns build
  (:require [scicloj.clay.v2.api :as clay]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn build-all []
  (let [notebooks-dir (io/file "notebooks")
        files (->> (file-seq notebooks-dir)
                   (filter #(and (.isFile %)
                                 (str/ends-with? (.getName %) ".clj")
                                 (not (str/includes? (.getName %) "index_bak"))))
                   (map #(.getPath %)))]
    (doseq [f files]
      (println "Building" f "...")
      (clay/make! {:source-path f
                   :format [:quarto]
                   :browse false}))))

(defn -main [& _args]
  (build-all)
  (System/exit 0))
