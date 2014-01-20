(ns sherlac.root.root-spec
  (:require [speclj.core :refer :all]
            [joodo.spec-helpers.controller :refer :all]
            [sherlac.root.root :refer :all]))

(describe "root"

  (with-mock-rendering)
  (with-routes app-handler)

  (around [it]
    (with-redefs [with-layout (fn [body] body)]))

  (context "/"
    (it "defaults to housing category by default"
      (with-redefs [search-form (fn [category] category)]
        (let [result (do-get "/")]
          (should= 200 (:status result))
          (should= "housing" (:body result)))))

    (it "accepts categories"
      (with-redefs [search-form (fn [category] category)]
        (let [result (do-get "/other-category")]
          (should= 200 (:status result))
          (should= "other-category" (:body result)))))
    
    ))

(run-specs)
