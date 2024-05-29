; Реализовать функцию (оператор), принимающую аргументом функцию
; от одной переменной f и возвращающую функцию одной переменной,
; вычисляющую (численно) выражение \int_{0}^{x} f(t) dt.

; Оптимизировать с использованием мемоизации для задач типа
; построения графиков (т.е. многократный вызов функции в разных точках).

; Использовать метод трапеций с постоянным шагом.
; Показать прирост производительности с помощью time.


(ns exercise_3.1)

(def h 0.05)


(defn trapezoid [func x h]
    (* 0.5 h (+ (func x) (func (- x h))))
    )


(defn get-antiderivative-value [func h self-memoized idx]
    (if (= idx 0)
        0
        (+ (self-memoized func h self-memoized (dec idx))
           (trapezoid func (* h idx) h)
           )
        )
    )


(defn get-antiderivative-no-memo [func h]
    (fn [x]
        (get-antiderivative-value func h get-antiderivative-value (int (/ x h))))
    )


(defn get-antiderivative [func h]
    (let [get-antiderivative-value-memoized (memoize get-antiderivative-value)]
        (fn [x]
            (get-antiderivative-value-memoized func h get-antiderivative-value-memoized (int (/ x h))))
        )
    )


(defn sqr [x] (* x x))


(def antiderivative-sqr-no-memo (get-antiderivative-no-memo sqr h))
(def antiderivative-sqr (get-antiderivative sqr h))


(println "Без мемоизации:")
(println (time (antiderivative-sqr-no-memo 11)))
(println (time (antiderivative-sqr-no-memo 12.07)))
(println (time (antiderivative-sqr-no-memo 13.03)))

(println "С мемоизацией:")
(println (time (antiderivative-sqr 11)))
(println (time (antiderivative-sqr 12.07)))
(println (time (antiderivative-sqr 13.03)))