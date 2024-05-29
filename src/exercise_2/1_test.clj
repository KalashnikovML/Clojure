(ns exercise_2.1_test
    (:use clojure.test)
    (:use exercise_2.1))


(deftest test-n-prime
    (testing "Testing n-prime"
        (is (= 2 (n-prime 1)))
        (is (= 3 (n-prime 2)))
        (is (= 5 (n-prime 3)))
        (is (= 7 (n-prime 4)))
        (is (= 11 (n-prime 5)))
        (is (thrown? Exception (n-prime -1)))
        (is (thrown? Exception (n-prime 0)))
        )
    )


(run-tests 'exercise_2.1_test)