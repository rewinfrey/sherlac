(ns sherlac.utilities.render-spec
  (:require [speclj.core :refer :all]
            [sherlac.utilities.render :refer :all]
            [clojure.java.io :as io]))

(def test-file-path "src/clj/sherlac/test-file")
(def test-file-dynamic-path "src/clj/sherlac/test-dynamic-file")
(def test-file-partials-path "src/clj/sherlac/test-partials-file")

(def html-test-fixture
  "<html><head></head><body><h1>Test</h1></body></html>")

(def html-dynamic-test-fixture
  "<html><head></head><body><h1>{{name}}</h1></body></html>")

(def html-partials-test-fixture
  "<html><body>{{title}}<hr />{{>page-content}}</body></html>")

(def html-partials-valid-fixture
  "<html><body>Title<hr />Test Body</body></html>")

(describe "render"
  (around [it]
          (let [test-file          (spit test-file-path html-test-fixture)
                test-dynamic-file  (spit test-file-dynamic-path html-dynamic-test-fixture)
                test-partials-file (spit test-file-partials-path html-partials-test-fixture)]
          (it)
            (io/delete-file test-file-path)
            (io/delete-file test-file-dynamic-path)
            (io/delete-file test-file-partials-path)))

  (context "render"
    (it "renders a specified template with no attr-map or partials"
      (should= html-test-fixture (render test-file-path)))
   
    (it "renders a specified template with attr-map" 
      (should= html-test-fixture (render test-file-dynamic-path {:name "Test"})))

    (it "renders a specified template with attr-map and partials"
      (should= html-partials-valid-fixture (render test-file-partials-path {:title "Title"} {:page-content "Test Body"})
    ))))

