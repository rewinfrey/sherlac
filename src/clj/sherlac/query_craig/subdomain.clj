(ns sherlac.query-craig.subdomain)

(defn find-subdomain [city]
  {(keyword city) {:nearby-cities {}
                   :slug city}})
