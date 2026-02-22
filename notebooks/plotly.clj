(ns plotly
  (:require [scicloj.tableplot.v1.plotly :as plotly]))

;; # Scatter Plot
(plotly/plot
 {:data [{:x [1 2 3]
          :y [4 5 6]
          :type "scatter"
          :mode "markers"}]})

;; ## Without markers
(plotly/plot
 {:data [{:x [1 2 3]
          :y [4 5 6]
          :type "scatter"}]})

;; ## A plot without any configuration
(plotly/plot
 {:data [{:x [1 2 3]
          :y [4 5 6]}]})

;; ## Bar Chart
(plotly/plot
 {:data [{:x [1 2 3]
          :y [4 5 6]
          :type "bar"}]})


;; 

;; a pie chart needs labels and values, not x and y
(plotly/plot
 {:data [{:labels ["A" "B" "C"]
          :values [10 20 30]
          :type "pie"}]})

;; # Customizing the plot

;; ## Specifying color
(plotly/plot
 {:data [{:x [1 2 3]
          :y [4 5 6]
          :type "bar"
          :marker {:color "red"}}]})

;; ## Add title
(plotly/plot
 {:data [{:x [1 2 3]
          :y [4 5 6]
          :type "bar"
          :marker {:color "red"}}]
  :layout {:title "My Bar Chart"}})


;; ## x and y labels
(plotly/plot
 {:data [{:x [1 2 3]
          :y [4 5 6]
          :type "bar"
          :marker {:color "red"}}]
  :layout {:title "My Bar Chart"
           :xaxis {:title "X Axis"}
           :yaxis {:title "Y Axis"}}})

;; # Mult bar chart

(plotly/plot
 {:data [{:x [1 2 3]
          :y [4 5 6]
          :type "bar"
          :marker {:color "red"}}
         {:x [1 2 3]
          :y [6 5 4]
          :type "bar"
          :marker {:color "blue"}}]
  :layout {:title "My Bar Chart"
           :xaxis {:title "X Axis"}
           :yaxis {:title "Y Axis"}}})

;; Multi bar chart without markers
(plotly/plot
 {:data [{:x [1 2 3]
          :y [4 5 6]
          :type "bar"}
         {:x [1 2 3]
          :y [6 5 4]
          :type "bar"}]
  :layout {:title "My Bar Chart"
           :xaxis {:title "X Axis"}
           :yaxis {:title "Y Axis"}}})

;; # Stacked bar chart
(plotly/plot
 {:data [{:x [1 2 3]
          :y [4 5 6]
          :type "bar"
          :marker {:color "red"}}
         {:x [1 2 3]
          :y [6 5 4]
          :type "bar"
          :marker {:color "blue"}}]
  :layout {:title "My Bar Chart"
           :xaxis {:title "X Axis"}
           :yaxis {:title "Y Axis"}
           :barmode "stack"}})

;; # Horizontal bar chart
(plotly/plot
 {:data [{:x [4 5 6]
          :y [1 2 3]
          :type "bar"
          :orientation "h"  ;; <-- this makes it horizontal
          :marker {:color "red"}}]
  :layout {:title "My Bar Chart"
           :xaxis {:title "X Axis"}
           :yaxis {:title "Y Axis"}}})

;; # Line charts with different dash styles

(def trace1
  {:x [1 2 3 4 5] :y [6 8 7 8 6]
   :mode "lines" :name "dashdot"
   :line {:dash "dashdot" :width 4}})

(def trace2
  {:x [1 2 3 4 5] :y [11 13 12 13 11]
   :mode "lines" :name "Solid"
   :line {:dash "solid" :width 4}})

(def trace3
  {:x [1 2 3 4 5] :y [16 18 17 18 16]
   :mode "lines" :name "dot"
   :line {:dash "dot" :width 4}})

(def layout
  {:title "Line Dash Styles"
   :xaxis {:range [0.75 5.25] :autorange false}
   :yaxis {:range [0 18.5] :autorange false}
   :legend {:y 0.5 :traceorder "reversed" :font {:size 16}}
   :margin {:t 50}})

(plotly/plot
 {:data [trace1 trace2 trace3]
  :layout layout})

;; # Area chart
(plotly/plot
 {:data [{:x [1 2 3 4 5]
          :y [6 8 7 8 6]
          :mode "lines"
          :fill "tozeroy"
          :line {:color "blue" :width 0.5}}]
  :layout {:title "Area Chart"}})

;; # Stacked area chart
(plotly/plot
 {:data [{:x [1 2 3 4 5]
          :y [6 8 7 8 6]
          :mode "lines"
          :fill "tonexty"
          :line {:color "blue" :width 0.5}}
         {:x [1 2 3 4 5]
          :y [11 13 12 13 11]
          :mode "lines"
          :fill "tonexty"
          :line {:color "red" :width 0.5}}]
  :layout {:title "Stacked Area Chart"}})

;; ## Stacked area chart with multiple traces
(def traces
  [{:x [1 2 3] :y [2 1 4] :stackgroup "one"}
   {:x [1 2 3] :y [1 1 2] :stackgroup "one"}
   {:x [1 2 3] :y [3 0 2] :stackgroup "one"}])

(plotly/plot
 {:data traces
  :layout {:title "My Awesome Stacked Chart"
           :margin {:t 50 :l 50}}})

;; # Scatter plot with different marker colors
(plotly/plot
 {:data [{:x [1 2 3 4 5]
          :y [6 8 7 8 6]
          :mode "markers"
          :marker {:color ["red" "green" "blue" "orange" "purple"]
                   :size 10}}]
  :layout {:title "Scatter Plot with Different Marker Colors"}})

;; # Scatter plot with different marker sizes
(plotly/plot
 {:data [{:x [1 2 3 4 5]
          :y [6 8 7 8 6]
          :mode "markers"
          :marker {:size [10 20 30 40 50]}}]
  :layout {:title "Scatter Plot with Different Marker Sizes"}})



;; # Scatter plot with lines and markers
(plotly/plot
 {:data [{:x [1 2 3 4 5]
          :y [6 8 7 8 6]
          :mode "markers+lines"
          :marker {:color "red" :size 10}
          :line {:color "red" :width 2}}]
  :layout {:title "Scatter Plot with Lines"}})

;; # Box plot
(plotly/plot
 {:data [{:y [1 2 3 4 5]
          :type "box"}]
  :layout {:title "Box Plot"
           :xaxis {:title "X Axis"}
           :yaxis {:title "Y Axis"}}})

;; # Histogram
(plotly/plot
 {:data [{:x [6 1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 6 6 7]
          :type "histogram"}]
  :layout {:title "Histogram"
           :xaxis {:title "X Axis"}
           :yaxis {:title "Y Axis"}}})

;; # Heatmap
(plotly/plot
 {:data [{:z [[1 20 30]
              [20 1 60]
              [30 60 1]]
          :type "heatmap"}]
  :layout {:title "Heatmap"
           :xaxis {:title "X Axis"}
           :yaxis {:title "Y Axis"}}})


;; 3D scatter plot
;; not working as expected
(plotly/plot
 {:data [{:x [1 2 3 4 5]
          :y [6 8 7 8 6]
          :z [1 2 3 4 5]
          :mode "markers"
          :marker {:color "red" :size 10}}]
  :layout {:title "3D Scatter Plot"
           :scene {:xaxis {:title "X Axis"}
                   :yaxis {:title "Y Axis"}
                   :zaxis {:title "Z Axis"}}}})