(ns findfn.core-test
  (:use clojure.test
        [clojail.testers :only [secure-tester]]
        findfn.core))

(defn clj-version []
  ((juxt :major :minor) *clojure-version*))

(defn min-clj-version [min-version-vector]
  (>= (compare (clj-version) min-version-vector) 0))

(defn max-clj-version [min-version-vector]
  (<= (compare (clj-version) min-version-vector) 0))

(deftest find-fn-test
  (testing "that it works."
    (is (= (find-fn secure-tester "lolomg" "lol" "omg") '[clojure.core/str]))))

(deftest find-arg-test
  (testing "that it works"
    (is (= (set (find-arg secure-tester ["a" "b" "c"] 'map '% [\a \b \c]))
           (set (concat
                 ;; trim used to take characters and return strings in
                 ;; Clojure 1.5.1 and earlier (probably by accident,
                 ;; not design), but starting with Clojure 1.6.0 it
                 ;; only accepts strings as arguments.
                 (if (max-clj-version [1 5])
                   '[clojure.string/trim])
                 ;; re-quote-replacement was added in Clojure 1.5.0
                 (if (min-clj-version [1 5])
                   '[clojure.string/re-quote-replacement])
                 '[clojure.string/lower-case
                   clojure.core/munge clojure.core/print-str clojure.core/str
                   clojure.core/namespace-munge]))))))
