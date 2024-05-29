; Решите задачу с помощью элементарных операций над последовательностями
; и функционалов map/reduce/filter.


(defn append-list [string alphabet]
    (map (fn [x] (.concat x string))
         alphabet)
    )


(defn new-list [alphabet result]
    (reduce concat (map (fn [x] (append-list x alphabet)) result))
    )


(defn list-creation [alphabet n]
    (reduce (fn [result iter]
                (if (= iter 0)
                    alphabet
                    (filter (fn [x] (not (= (.substring x 0 1) (.substring x 1 2))))
                            (new-list alphabet result))))
            '() (range 0 n))
    )


(println (list-creation (list "a" "b" "c") 0))
(println (list-creation (list "a" "b" "c") 1))
(println (list-creation (list "a" "b" "c") 2))
(println (list-creation (list "a" "b" "c") 3))