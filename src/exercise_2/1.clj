; Напишите функцию, которая ищет n-ое простое число
; c помощью решета Эратосфена.

(ns exercise_2.1)


(defn iter-sieve [prime-k result]
    (filter (fn [x] (or (= x prime-k) (not (= 0 (mod x prime-k)))))
                   result)
    )


(defn sieve [k n result]
    (if (< k (inc n))
        (recur (inc k) n (iter-sieve (nth result k) result))
        result)
    )


(defn n-prime [n]
    (if (< 0 n)
        (nth (sieve 0 n (range 2 (* (inc n) (inc n))))
             (dec n))
        (throw (Exception. (str "n < 0")))))


(println (n-prime 1))
(println (n-prime 2))
(println (n-prime 3))
(println (n-prime 10))
(println (n-prime 100))
(println (n-prime 1000))