(ns sherlac.init
  (:require [joodo.env :as env]))

(defn init []
  (env/load-configurations))
