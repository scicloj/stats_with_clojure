(ns build
  (:require [scicloj.clay.v2.api :as clay]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.edn :as edn]
            [clojure.java.shell :as sh]))

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
      ;; We use Clay to generate the .qmd files.
      ;; Clay currently renders them individually, but we'll re-render the whole site
      ;; at the end to ensure the searchable index and sidebar are correctly built.
      (clay/make! (merge config {:source-path f
                                 :browse false})))

    (println "Finalizing searchable index and sidebar...")
    (let [{:keys [exit out err]} (sh/with-sh-dir "docs" (sh/sh "quarto" "render" "."))]
      (if (zero? exit)
        (println "Documentation built successfully with searchable index.")
        (do
          (println "Error during final Quarto render:")
          (println err)
          (System/exit exit))))))

(defn -main [& _args]
  (build-all)
  (System/exit 0))
