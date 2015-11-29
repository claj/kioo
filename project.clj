(defproject claj/kioo "0.4.2-SNAPSHOT"
  :description "enlive/enfocus style templating for Facebook's React. Forked from ckirkendall/kioo"
  :url "http://github.com/claj/kioo"
  :author "Creighton Kirkendall"
  :min-lein-version "2.0.0"
  :lein-release {:deploy-via :clojars}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[enlive "1.1.6"]
                 [cljsjs/react "0.14.3-0"]
                 [org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [com.googlecode.htmlcompressor/htmlcompressor "1.5.2"]
                 [sablono "0.4.0"]
                 [hickory "0.5.4"]
                 [org.omcljs/om "0.9.0" :exclusions [cljsjs/react]]
                 [reagent "0.5.1" :exclusions [cljsjs/react]]
                 [enlive-ws  "0.1.1"]]
  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-doo "0.1.5-SNAPSHOT"]
            [lein-shell "0.4.0"]
            [lein-ancient "0.5.4"]
            [lein-marginalia "0.8.0"]]
  :aliases
  {"auto-test"
   ["do" "clean"
    ["doo" "phantom" "test"]]}

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "target/dev/kioo.js"
                                   :optimizations :none
                                   :pretty-print true
                                   :source-map true}}
                       {:id "test"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "target/test/kioo.js"
                                   :optimizations :none
                                   :main kioo.test-runner
                                   :pretty-print true
                                   }}]}
  :resource-paths ["test-resources"]
  :source-paths ["src"]
  :test-paths ["test"])
