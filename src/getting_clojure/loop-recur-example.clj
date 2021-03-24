(ns test-clj)

(defn add-till [end-number]
  (loop [total 0 count 0 end-number end-number]
    (if (= count end-number)
      total
      (recur (+ total (+ count 1)) (+ count 1) end-number))))

(add-till 4123)
