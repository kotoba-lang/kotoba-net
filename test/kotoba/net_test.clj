(ns kotoba.net-test
  "Tests for kotoba.net"
  (:require [clojure.test :as t]
            [kotoba.net :as net]))

(t/deftest uri-create-basic
  (t/is (some? (net/uri-create "https://example.com/path"))))

(t/deftest uri-string-roundtrip
  (let [uri (net/uri-create "https://example.com/path")]
    (t/is (= uri (net/uri-string uri)))))

(t/deftest url-encode-decode
  (let [original "hello world"
        encoded (net/url-encode original "UTF-8")
        decoded (net/url-decode encoded "UTF-8")]
    (t/is (= original decoded))))

(t/deftest http-client-get-placeholder
  (t/is (some? (net/http-client-get "https://example.com"))))
