(ns sherlac.query-craig.category)

(def housing
  {:sub-categories {:default            "hhh"
                    :apartments-housing "apa"
                    :rooms-shared       "roo"
                    :sublets-temporary  "sub"
                    :housing-wanted     "hsw"
                    :vacation-rentals   "vac"
                    :parking-storage    "prk"
                    :office-commercial  "off"
                    :real-estate        "rea"}

   :housing-types  {:any-housing         0
                    :apartment           1
                    :condo               2
                    :cottage-cabin       3
                    :duplex              4
                    :flat                5
                    :house               6
                    :in-law              7
                    :loft                8
                    :townhouse           9
                    :manufactured       10
                    :assisted-living    11
                    :land               12}

   :search-options {"zoomToPosting"     "zoomToPosting="
                    "sub-category"      "catAbb="
                    "query"             "query="
                    "min-rent"          "minAsk="
                    "max-rent"          "maxAsk="
                    "bedrooms"          "bedrooms="
                    "housing-type"      "housing_type="
                    "excats"            "excats="
                    "picture"           "hasPic="
                    "title"             "srchType="}})

(def all-categories
  {"housing" housing})

(defn find-category [category]
  (get all-categories category))
