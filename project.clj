(defproject findfn "0.1.3"
  :url "https://github.com/Raynes/findfn"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [clojail "1.0.3"]]
  :aliases {"testall" ["with-profile" "dev,1.3,default:dev,1.4,default:dev,1.5,default:dev,1.7,default:dev,1.8,default:dev,1.9,default" "test"]}
  :profiles {
             :1.3 {:dependencies [[org.clojure/clojure "1.3.0"]]}
             :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0"]]}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0"]]}
             :1.9 {:dependencies [[org.clojure/clojure "1.9.0"]]}
             }
  :jvm-opts ["-Djava.security.policy=example.policy"])
