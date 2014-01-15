(ns sherlac.main-spec
  (:require [speclj.core :refer :all]
            [joodo.spec-helpers.controller :refer :all]
            [sherlac.main :refer :all]))

(describe "sherlac"

  (with-mock-rendering)
  (with-routes app-handler)

  (it "handles root"
    (let [result (do-get "/")]
      (should= 200 (:status result))
      (should= "index" @rendered-template)))
  )

(run-specs)
