/*
2.	Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное)
 и НОД (наибольший общий делитель) двух целых чисел, введенных пользователем.
Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.
*/

package by.dima.senla.task2;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        nodAndNok();
    }

    /**
     * основной метод задачи
     */
    public static void nodAndNok() {
        int num1 = scanInt(0, Integer.MAX_VALUE);
        int num2 = scanInt(0, Integer.MAX_VALUE);
        String result = "НОК=" + lcm(num1, num2) +
                " НОД=" + gcd(num1, num2);
        System.out.println(result);
    }

    /**
     * Вводим число и проверяем его на корректность
     * @param a - минимальное значение
     * @param b - макисмальное значение
     * @return - возвращаемое число
     */
    public static int scanInt(int a, int b) {
        Scanner in = new Scanner(System.in);
        int userInput;
        while (true) {
            System.out.println("Введите целое " +
                    "число в диапазоне [" + a + " .. " + b + "]: ");
            String s = in.nextLine();
            try {
                userInput = Integer.parseInt(s);
                if (userInput < a || userInput > b)
                    System.err.println("Не соответствует условиям ввода!");
                else
                    break;
            } catch (NumberFormatException e) {
                System.err.println("Не соответствует условиям ввода!");
            }
        }
        return userInput;
    }

    /**метод вычисляющий НОД
     *
     * @param a - первое целое число
     * @param b - второе целое число
     * @return - НОД двух чисел
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    /**метод вычисляющий НОК
     *
     * @param a - первое целое число
     * @param b - второе целое число
     * @return - НОК двух чисел
     */
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }


}
