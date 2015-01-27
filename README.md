# Ring middleware for multipart/mixed #

Clojure ring / compojure middleware that knows how to parse a multipart/mixed mime type message into the request map.

# Add to your project #

![Clojars latest version](https://clojars.org/com.yetanalytics/multipart/latest-version.svg "Clojars latest version")

Add `[com.floatbackwards/multipart "0.1.0-SNAPSHOT"]` to your project.clj

Clojars project page: [multipart](https://clojars.org/com.yetanalytics/multipart)

# Use with #

    (:use [ring.multipart-mixed-params])

then

    (defroutes main-routes (wrap-multipart-mixed
       (POST "/data" req "OK")))

or 

    (def app
      (handler/site
       wrap-multipart-mixed
       main-routes))

If the request `content-type` header contains the content type of `multipart/mixed` this will put a key of `:multiparts` into the request map. Otherwise does nothing.

This key will contain a sequence of maps with :content-type, :headers (all headers), and :input-stream for each part of the message.

For example a message containing three parts: 2 jpeg images and 1 text/plan would give us the following request map.

    {
    :body "some multipart/mixed message body - this is what we parse"
    ... 
      :multiparts ({:content-type "image/jpeg"
                    :headers {"Content-Type" "image/jpeg"
                              "X-Some-Header" "whatevs"}
                    :input-stream <stream1>}
                   {:content-type "text/plain"
                    :headers {"Content-Type" "text/plain"}
                    :input-stream <stream2>})
    ...
    }

Each of the parsed elements is available as a stream that can be split, slurped or whatever else you fancy.

# Building #

`lein jar`

# Testing #

`lein midje`

# Author #

Benjamin Griffiths (whostolebenfrog)

Inspiration from [multipart-params](https://github.com/mmcgrana/ring/blob/master/ring-core/src/ring/middleware/multipart_params.clj)
