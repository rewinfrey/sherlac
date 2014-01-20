(ns sherlac.utilities.render
  (:require [clostache.parser :as parser]))

; TODO REW absolutely no error-checking yay!
(defn render 
  ([template]          (render template {} {}))
  ([template attr-map] (render template attr-map {}))
  ([template attr-map partials]
   (parser/render (slurp template) attr-map partials)))
