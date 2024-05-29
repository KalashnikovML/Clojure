(ns exercise_3.1_test
    (:use clojure.test)
    (:use exercise_3.1))


(defn equal [x y]
    (< (Math/abs (- x y)) h))


(deftest test-get-antiderivative
    (testing "Testing get-antiderivative")
    ;Integrate zero
    (is (= 0.0 ((get-antiderivative (fn [x] 0.0) h) 1)))
    ;3x^2 func, value 10
    (is (equal 1000.0 ((get-antiderivative (fn [x] (* 3 (* x x))) h) 10)))
    ;2x func, value 1
    (is (equal 1 ((get-antiderivative (fn [x] (* 2 x)) h) 1)))
    ;2x func, value 0.1
    (is (equal 0.01 ((get-antiderivative (fn [x] (* 2 x)) h) 0.1)))
    )


(run-tests 'exercise_3.1_test)