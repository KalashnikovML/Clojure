; Реализовать функцию (оператор), принимающую аргументом функцию
; от одной переменной f и возвращающую функцию одной переменной,
; вычисляющую (численно) выражение \int_{0}^{x} f(t) dt.

; Использовать метод трапеций с постоянным шагом.
; Показать прирост производительности с помощью time.

; Модифицировать решение задачи 3.1 таким образом,
; чтобы вместо мемоизации использовались потоки.


(ns exercise_3.2)

(def h 0.05)


(defn trapezoid [func x h]
    (* 0.5 h (+ (func x) (func (- x h))))
    )


(defn antiderivative-seq [func h]
    (letfn [(antiderivative-seq-rec [idx prev-val]
                (lazy-seq
                    (let [next-val (+ prev-val (trapezoid func (* h idx) h))]
                        (cons next-val (antiderivative-seq-rec (inc idx) next-val)))))]
        (antiderivative-seq-rec 0 0))
    )


(defn get-antiderivative-no-seq [func h]
    (fn [x]
        (reduce + (map (fn [idx] (trapezoid func (* h idx) h))
                       (range 1 (int (/ x h))))))
    )


(defn get-antiderivative [func h]
    (let [antiderivative-values (antiderivative-seq func h)]
        (fn [x]
            (nth antiderivative-values (int (/ x h)))))
    )


(defn sqr [x] (* x x))


(def antiderivative-sqr-no-seq (get-antiderivative-no-seq sqr h))
(def antiderivative-sqr (get-antiderivative sqr h))


(println "Без ленивых последовательностей:")
(println (time (antiderivative-sqr-no-seq 11)))
(println (time (antiderivative-sqr-no-seq 12.07)))
(println (time (antiderivative-sqr-no-seq 13.03)))

(println "С ленивыми последовательностями:")
(println (time (antiderivative-sqr 11)))
(println (time (antiderivative-sqr 12.07)))
(println (time (antiderivative-sqr 13.03)))