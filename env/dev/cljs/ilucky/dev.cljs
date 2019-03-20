(ns ^:figwheel-no-load ilucky.dev
  (:require
    [ilucky.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
