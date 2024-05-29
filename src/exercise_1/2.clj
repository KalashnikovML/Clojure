; Задан набор (алфавит) символов в виде списка и число n.
; Опишите функцию, которая возвращает список всех строк
; длины n, состоящих из этих символов и не содержащих
; двух одинаковых символов, идущих подряд.

; Изменить решение задачи 1.1 таким образом, чтобы все
; рекурсивные вызовы были хвостовыми.


(defn append-list [alphabet string result]
    (if (not (= (first alphabet) nil))
        (if (not (= (first alphabet) (.substring string 0 1)))
            (recur (rest alphabet) string (conj result (.concat (first alphabet) string)))
            (recur (rest alphabet) string result))
        result)
    )


(defn new-list [alphabet old new]
    (if (= (first old) nil)
        new
        (recur alphabet (rest old) (append-list alphabet (first old) new)))
    )


(defn list-creation
    ([alphabet n]
     (if (not (= n 0))
         (list-creation alphabet (dec n) alphabet)
         '()))


    ([alphabet n result]
     (if (not (= n 0))
         (recur alphabet (dec n) (new-list alphabet result '()))
         result))
    )


(println (list-creation (list "a" "b" "c") 0))
(println (list-creation (list "a" "b" "c") 1))
(println (list-creation (list "a" "b" "c") 2))
(println (list-creation (list "a" "b" "c") 3))