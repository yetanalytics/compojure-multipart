(defproject com.yetanalytics/multipart "0.1.1"
  :description "Ring middleware for parsing multipart/mixed requests"

  :url "https://github.com/yetanalytics/compojure-multipart"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.apache.commons/commons-email "1.4"]
                 [commons-fileupload/commons-fileupload "1.3.2"]
                 [bultitude "0.2.8"]]
  :profiles {:dev {:dependencies [[midje "1.8.3"]]
                   :plugins [[lein-midje "2.0.4"]]}}

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :uberjar-name "multipart.jar"

  :aot [ring.TooMuchContent])
