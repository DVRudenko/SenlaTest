/*
1.	Создать программу, которая будет сообщать, является ли целое число,
        введенное пользователем, чётным или нечётным, простым или составным.
        Если пользователь введёт не целое число, то сообщать ему об ошибке.
*/

package by.dima.senla.task1;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        numberAnalyse();
    }


    public static void numberAnalyse() {
        int number = scanInt(0, Integer.MAX_VALUE);
        String result = "Число " + number;
        if (isPrime(number)) {
            result += " простое и";
        } else if (number >= 2) {
            result += " составное и";
        }
        if (isEven(number)) {
            result += " четное";
        } else result += " нечетное";

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
        in.close();
        return userInput;
    }

    /**
     * Описание метода, параметров и возворащаемого значение
     * @param num - целое число
     * @return - true если число четное
     */
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }


    /**
     * Описание метода, параметров и возвращаемого значение
     * @param num - целое число
     * @return - true если число простое
     */
    public static boolean isPrime(int num) {
        if (num < 3) {
            return num == 2;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = num / 3; i >= 3; i -= 2) {
            if (isEven(i)) {
                i--;
            }
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
