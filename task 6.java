/*
6.	Имеется набор вещей, которые необходимо поместить в рюкзак.
Рюкзак обладает заданной грузоподъемностью.
Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
Цель задачи заполнить рюкзак не превысив его грузоподъемность и
максимизировать суммарную ценность груза.

*/

package by.dima.senla.task6;



//класс рюкзака
    public class Backpack {
        static final int MAX_WEIGHT = 100; //максимальный вес рюкзака

        static Goods[] goods = {
                new Goods(15, 30),  //вещь - вес и стоимость
                new Goods(30, 20),
                new Goods(50, 50),
                new Goods(4, 10),
                new Goods(10, 20),
                new Goods(40, 50)
        };

        public static void main(String[] args) {
            System.out.println("максимальая стоимость рюкзака="+ maxValue(goods.length - 1, MAX_WEIGHT));
            System.out.println("при весе="+ MAX_WEIGHT);
        }


    /** метод находит лучшее решение путем полного перебора
     *
     * @param i - порядковый номер вещи
     * @param weigth - вес вещи
     * @return - максимальная стоимость вещей
     */
        private static int maxValue(int i, int weigth) {
            if (i < 0) {
                return 0;
            }
            if (goods[i].getWeight() > weigth) {
                return maxValue(i-1, weigth);
            }
            else {
                return Math.max(maxValue(i-1, weigth), maxValue(i-1, weigth - goods[i].getWeight()) + goods[i].getValue());            }
        }
    }

//класс вещей
class Goods {
    private int weight;
    private int value;

    //конструктор вещей - вес и стоимость
    public Goods(int weight, int value){
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }


}

