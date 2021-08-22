(ns getting-clojure.intermediate.fibonacci)

; If n=0, then fib(n) = 0
; If n=1, then fib(n) = 1
; Otherwise, fib(n) = fib(n-1) + fib(n-2))

(defn recursive-fibonacci
  "Fibonacci series using recursion"
  [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (recursive-fibonacci (- n 1))
             (recursive-fibonacci (- n 2)))))

(map recursive-fibonacci (range 20))

(def lazy-seq-fibonacci
  "Fibonacci series using lazy sequence"
  (
    (fn fib
      [a b]
      (cons a (lazy-seq (fib b (+ a b)))))
    0 1))


(take 20 lazy-seq-fibonacci)
