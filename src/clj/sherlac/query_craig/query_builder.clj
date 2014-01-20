(ns sherlac.query-craig.query-builder
  (:require [sherlac.query-craig.category :refer :all])
  (import [java.net URLEncoder]))

(defn default-sub-category [cat-options]
  (:default (:sub-categories cat-options)))

(defn sub-category? [search-attribute]
  (= search-attribute "catAbb="))

(defn construct-query-string [cat-options param-options query-option query-string]
  (let [search-attribute (get (:search-options cat-options) query-option)
        param-value      (or (get param-options query-option) "")]
    (if (and (empty? param-value) (sub-category? search-attribute))
      (str search-attribute (default-sub-category cat-options))
      (str search-attribute (URLEncoder/encode param-value)))))

(defn build-query [{category :category param-options :options :as params-map}]
  (let [cat-options           (find-category category)
        search-attribute-keys (keys (get cat-options :search-options))]
    (reduce (fn [query-string search-attribute]
              (if (= "" query-string)
                (str query-string "?" (construct-query-string cat-options param-options search-attribute query-string))
                (str query-string "&" (construct-query-string cat-options param-options search-attribute query-string))))
            ""
            search-attribute-keys)))
