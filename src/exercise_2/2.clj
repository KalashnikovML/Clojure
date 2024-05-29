; Реализуйте бесконечную последовательность простых чисел

(ns exercise_2.2)


(def odd-numbers
    (lazy-seq
        (cons 3 (map inc (map inc odd-numbers))))
    )


(def primes
    (lazy-seq
        (remove
            (fn [x]
                (some (fn [y] (= 0 (mod x y))) primes))
            (cons 2 odd-numbers)))
    )


(println (nth primes 0))
(println (nth primes 1))
(println (nth primes 2))
(println (nth primes 3))
(println (nth primes 10))
(println (nth primes 100))
(println (nth primes 1000))