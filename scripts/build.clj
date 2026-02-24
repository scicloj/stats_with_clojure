(ns build
  (:require [scicloj.clay.v2.api :as clay]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.edn :as edn]))

(defn build-all []
  (let [config (edn/read-string (slurp "clay.edn"))
        notebooks-dir (io/file "notebooks")
        files (->> (file-seq notebooks-dir)
                   (filter #(and (.isFile %)
                                 (str/ends-with? (.getName %) ".clj")
                                 (not (str/includes? (.getName %) "index_bak"))))
                   (map #(.getPath %)))]
    (doseq [f files]
      (println "Building" f "...")
      (clay/make! (merge config {:source-path f
                                 :browse false})))))

(defn -main [& _args]
  (build-all)
  (System/exit 0))
