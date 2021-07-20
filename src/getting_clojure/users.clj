(ns getting-clojure.users
  (:require [clojure.java.jdbc :as db]
            [clojure.string :as str]))

(def con {:subprotocol "mysql"
          :subname "//localhost:3311/urlaubspiraten_local?autoReconnect=true&useSSL=false"
          :user "pslocaldbuser"
          :password "pslocaldbpassword"})

(def users (db/query con ["SELECT * FROM pirate_users LIMIT 10"]))

(defn gmail? [user]
  (str/ends-with? (:email user) "gmail.com"))

(sort (map :email (filter gmail? users)))

(def comments (db/query con ["SELECT * FROM pirate_comments LIMIT 10"]))

(count comments)

(first comments)

(defn long-comment-len
  "Return the length of the longest comment"
  [s c]
  (let [com-count (count (:content c))]
    (if (> com-count s)
      com-count
      s)))

(reduce long-comment-len 0 comments)

(defn longest-comment
  "Return the longest comment"
  [s c]
  (let [com (:content c)
        com-count (count com)]
    (if (> com-count (count s))
      com
      s)))

(reduce longest-comment "" comments)

(def latest-users
  (apply str
   (interpose ","
    (map :email
     (take 3
      (reverse
       (sort-by :created_at comments)))))))

(def latest-users-2
  (->>
   comments
   (sort-by :created_at)
   reverse
   (take 3)
   (map :email)
   (interpose ", ")
   (apply str)))

latest-users

latest-users-2
