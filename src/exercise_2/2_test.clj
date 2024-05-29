(ns exercise_2.2_test
    (:use clojure.test)
    (:use exercise_2.2))


(deftest test-odd-numbers
    (testing "Testing odd-numbers"
        (is (= 3
               (nth odd-numbers 0)))
        (is (= 5
               (nth odd-numbers 1)))
        (is (= 13
               (nth odd-numbers 5)))
        )
    )


(deftest test-primes
    (testing "Testing primes"
        (is (= 2
               (nth primes 0)))
        (is (= 3
               (nth primes 1)))
        (is (= 17
               (nth primes 6)))
        (is (= 7927
               (nth primes 1000)))
        )
    )


(run-tests 'exercise_2.2_test)