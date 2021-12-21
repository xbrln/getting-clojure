(ns getting-clojure.intermediate.records-protocols)

(defrecord user [firebase-id email])

(def user-1 (->user "123ASD" "asdsa@asds.com"))

(def user-2 (map->user {:firebase-id "1234WER"
                        :email "erew@sdgfer.cde"}))

(def user-3 {:firebase-id "12UER"
             :email "ewr@ret.wer"})

(class user-3)

(instance? user user-3)

(defprotocol User
  (id [this])
  (email [this]))

(defrecord BrazeUser [braze-id email]
  User
  (id [this] (:braze-id this))
  (email [this] (:email this)))

(defrecord IterableUser [iterable-id email-address]
  User
  (id [this] (:iterable-id this))
  (email [this] (:email-address this)))

(def jake (->BrazeUser "123" "email@mail.com"))

(def jam (->IterableUser "12321431" "jam@jammy.jam"))

(id jam)
(email jake)

(defprotocol Greetings
  (greet [this]))

(extend-protocol Greetings
  BrazeUser
  (greet [this] (str "hello user with email " (email this)))
  IterableUser
  (greet [this] (str "hello user with email " (email this))))

(greet jam)


(comment)
