(ns sherlac.query-craig.subdomain-spec
  (:require [speclj.core :refer :all]
            [sherlac.query-craig.subdomain :refer :all]))

(describe "find-subdomain"

  (it "finds a subdomain for a given city string"
    (should= {:chicago {:nearby-cities {} :slug "chicago"}}
             (find-subdomain "chicago"))))
