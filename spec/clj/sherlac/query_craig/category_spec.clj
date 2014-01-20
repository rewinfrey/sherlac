(ns sherlac.query-craig.category-spec
  (:require [speclj.core :refer :all]
            [sherlac.query-craig.category :refer :all]))

(describe "find-category"
  (it "returns a map of housing category attributes"
    (should= housing (find-category "housing"))))
