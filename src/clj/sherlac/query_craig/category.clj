(ns sherlac.query-craig.category)

(defn find-category [category]
   {:housing {:sub-categories {:apartments-housing "apa"
                               :rooms-shared       "roo"
                               :sublets-temporary  "sub"
                               :housing-wanted     "hsw"
                               :vacation-rentals   "vac"
                               :parking-storage    "prk"
                               :office-commercial  "off"
                               :real-estate        "rea"}
              :housing-types {:any-housing 0
                              :apartment 1
                              :condo 2
                              :cottage-cabin 3
                              :duplex 4
                              :flat 5
                              :house 6
                              :in-law 7
                              :loft 8
                              :townhouse 9
                              :manufactured 10
                              :assisted-living 11
                              :land 12}}})
