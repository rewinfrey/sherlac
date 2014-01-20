(ns sherlac.query-craig.query-builder-spec
 (:require [speclj.core :refer :all]
           [sherlac.query-craig.query-builder :refer :all]))

(describe "query builder"
  (context "housing query string"
    (it "returns a formatted query string for housing query options without a specified sub-category"
      (should= "?maxAsk=&query=&housing_type=&catAbb=hhh&excats=&zoomToPosting=&minAsk=&bedrooms=&srchType=&hasPic="
               (build-query {:category "housing" :options {}})))

    (it "returns query string with non-default sub-category when specified"
      (should= "?maxAsk=&query=&housing_type=&catAbb=apa&excats=&zoomToPosting=&minAsk=&bedrooms=&srchType=&hasPic="
               (build-query {:category "housing" :options {"sub-category" "apa"}})))

    (it "returns query string with query parameter specified"
      (should= "?maxAsk=&query=1br+Lincoln+Park&housing_type=&catAbb=hhh&excats=&zoomToPosting=&minAsk=&bedrooms=&srchType=&hasPic="
               (build-query {:category "housing" :options {"query" "1br Lincoln Park"}})))

    (it "returns query string with housing type specified"
      (should= "?maxAsk=&query=&housing_type=1&catAbb=hhh&excats=&zoomToPosting=&minAsk=&bedrooms=&srchType=&hasPic="
               (build-query {:category "housing" :options {"housing-type" "1"}})))

    (it "returns query string with minimum rent specified"
      (should= "?maxAsk=&query=&housing_type=&catAbb=hhh&excats=&zoomToPosting=&minAsk=100&bedrooms=&srchType=&hasPic="
               (build-query {:category "housing" :options {"min-rent" "100"}})))

    (it "returns query string with maximum rent specified as float"
      (should= "?maxAsk=100.00&query=&housing_type=&catAbb=hhh&excats=&zoomToPosting=&minAsk=&bedrooms=&srchType=&hasPic="
               (build-query {:category "housing" :options {"max-rent" "100.00"}})))

    (it "returns query string with number of bedrooms specified"
      (should= "?maxAsk=&query=&housing_type=&catAbb=hhh&excats=&zoomToPosting=&minAsk=&bedrooms=1&srchType=&hasPic="
               (build-query {:category "housing" :options {"bedrooms" "1"}})))

    (it "returns query string with pictures only specified"
      (should= "?maxAsk=&query=&housing_type=&catAbb=hhh&excats=&zoomToPosting=&minAsk=&bedrooms=&srchType=&hasPic=1"
               (build-query {:category "housing" :options {"picture" "1"}})))
  )
)
