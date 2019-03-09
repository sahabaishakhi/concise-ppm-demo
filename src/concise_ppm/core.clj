(ns concise-ppm.core)

(def head (str "P3\n" 255 " " 255 " " 255 "\n"))

(def image-data
  (str
   head (clojure.string/join
         "\n"
         (map str
              (map mod (range (* 255 255)) (repeat 255))
              (repeat " ")
              (reduce concat (map repeat (repeat 255) (range 255)))
              (repeat " ")
              (map mod (map *
                   (map mod (range (* 255 255)) (repeat 255))
                   (reduce concat (map repeat (repeat 255) (range 255)))) (repeat 255))))))

(def ppm-content image-data)

(spit "nonloopdemo.ppm" ppm-content)
