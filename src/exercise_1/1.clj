; Задан набор (алфавит) символов в виде списка и число n.
; Опишите функцию, которая возвращает список всех строк
; длины n, состоящих из этих символов и не содержащих
; двух одинаковых символов, идущих подряд.
;
; Для решения использовать рекурсию и базовые операции
; над константами и списками (str, cons, .concat и т.п.)
;
; Пример:
; для алфавита (("а" "b" "c" и n=2 результат должен
; быть ("ab" "ac" "ba" "bc" "ca" "cb") с точностью до перестановки.


(defn print_n
    ([alphabet n]
     (if (= n 0)
         (println "")
         (if (not (= (first alphabet) nil))
             (print_n alphabet alphabet n nil)))
     )


  ([alphabet cycle_alphabet n current]
   (if (not (= current nil))
       (if (not (= (first cycle_alphabet) (.substring current 0 1)))
           (print_n alphabet (dec n) (.concat (first cycle_alphabet) current)))
       (print_n alphabet (dec n) (first cycle_alphabet)))

   (if (not (= (first (rest cycle_alphabet)) nil))
       (print_n alphabet (rest cycle_alphabet) n current))
   )


  ([alphabet n current]
   (if (= n 0)
       (println current)
       (print_n alphabet alphabet n current))
   )
  )


(print_n (list "a" "b" "c") 0)
(println "\n\n")
(print_n (list "a" "b" "c") 1)
(println "\n\n")
(print_n (list "a" "b" "c") 2)
(println "\n\n")
(print_n (list "a" "b" "c") 3)