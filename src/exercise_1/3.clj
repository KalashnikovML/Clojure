; Определить функции my map и my filter, аналогичные
; map (для одного списка) и filter, выразив их через reduce
; и базовые операции над списками (cons, first, concat и т.п.)


(defn my-map [f coll]
    (reduce (fn [value element]
                (concat value (list (f element))))
            '() coll)
    )


(defn my-filter [predicate coll]
    (reduce (fn [value element]
                (if (predicate element)
                    (concat value (list element))
                    value))
            '() coll)
    )


(println (my-map dec (list 1 2 3 4 5 6)))
(println (my-map inc (list 1 2 3 4 5 6)))
(println (my-map (fn [x] (* x x)) (list 1 2 3 4 5 6)))

(println (my-filter (fn [x] (= 0 (mod x 2))) (list 1 2 3 4 5 6)))
(println (my-filter (fn [x] (not (= 0 (mod x 2)))) (list 1 2 3 4 5 6)))