(defproject com.yetanalytics/multipart "0.1.0-SNAPSHOT"
  :description "Ring middleware for parsing multipart/mixed requests"

  :url "https://github.com/yetanalytics/compojure-multipart"

  :dependencies [[org.clojure/clojure "1.7.0-alpha1"]
                 [midje "1.6.3"]
                 [org.apache.commons/commons-email "1.3.3"]
                 [commons-fileupload/commons-fileupload "1.3.1"]
                 [bultitude "0.2.6"]]
  :profiles {:dev {:plugins [[lein-midje "2.0.4"]]}}

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :plugins [[lein-release "1.0.5"]]

  :lein-release {:release-tasks [:clean :uberjar :pom]
                 :clojars-url "clojars@clojars.org:"}

  :uberjar-name "multipart.jar"

  :aot [ring.TooMuchContent])
