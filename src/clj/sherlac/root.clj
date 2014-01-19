(ns sherlac.root
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [joodo.middleware.asset-fingerprint :refer [wrap-asset-fingerprint]]
            [joodo.middleware.favicon :refer [wrap-favicon-bouncer]]
            [joodo.middleware.keyword-cookies :refer [wrap-keyword-cookies]]
            [joodo.middleware.request :refer [wrap-bind-request]]
            [joodo.middleware.util :refer [wrap-development-maybe]]
            [joodo.middleware.view-context :refer [wrap-view-context]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [ring.middleware.flash :refer [wrap-flash]]
            [ring.middleware.head :refer [wrap-head]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.multipart-params :refer [wrap-multipart-params]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.session :refer [wrap-session]]
            [sherlac.query-craig.category :refer [find-category]]
            [sherlac.render :refer :all]
            ))

(defmacro with-layout [& body]
  `(render "src/clj/sherlac/layout.html" {:page-content ~@body}))

(defn search-form [category]
  (let [category-options (find-category category)]
    (render "src/clj/sherlac/search_form.html")))

(defn display-results [results]
  (render "src/clj/sherlac/results.html" {:results results}))

(defroutes app-routes
  (GET "/" [] (with-layout (search-form "housing")))
  (GET "/results" [] (with-layout (display-results "")))
  (GET "/:category" [category] (with-layout (search-form category))))

(def app-handler
  (->
    app-routes))

(def app
  (-> app-handler
    wrap-development-maybe
    wrap-bind-request
    wrap-keyword-params
    wrap-params
    wrap-multipart-params
    wrap-flash
    wrap-keyword-cookies
    wrap-session
    wrap-favicon-bouncer
    (wrap-resource "public")
    wrap-asset-fingerprint
    wrap-file-info
    wrap-head))
