/*
5.	Создать программу, которая в последовательности от 0 до N,
находит все числа-палиндромы (зеркальное значение равно оригинальному).
Длина последовательности N вводится вручную и не должна превышать 100.

*/

package by.dima.senla.task5;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        palindrom();
    }

    public static void palindrom() {
        int number = scanInt();

        int [] numberArray = new int [number];

        //формируем  последовательность случайных чисел от 1 до 1000
        System.out.print("Исходный массив: ");
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i]= (int)(Math.random()*1000)+1;
            System.out.print(numberArray[i]+" ");
        }
        System.out.println();

        printPalindrom (numberArray);


    }

    /**метод определяет является ли число палиндромом
     *
     * @param num - исходное целое число
     * @return - true если палиндром
     */
    public static boolean isPalindrom(int num) {
        String number = Integer.toString (num); //преобразовываем число в строку
        String rev = new StringBuffer(number).reverse().toString(); //формируем обратную строку
        return Objects.equals(number, rev); //сравниваем прямую и обратную
    }

    /**метод выводит палиндромы из массива
     *
     * @param array - массив целых чисел
     */
    public static void printPalindrom (int array[]) {
        System.out.print("Палиндромы: ");
        boolean flag = false;
        for (int i : array) {
            if (isPalindrom(i)) {
                System.out.print(i + " ");
                flag = true;
            }
        }
        if (!flag) {
            System.out.print("нет");
        }
    }


    /** Вводим число и проверяем его на корректност
     *
     * @return - возвращает целое число, введенное пользователем
     */
    public static int scanInt() {
        Scanner in = new Scanner(System.in);
        int userInput;
        while (true) {
            System.out.println("Введите целое число элементов в диапазоне [1..100]: ");
            String s = in.nextLine();
            try {
                userInput = Integer.parseInt(s);
                if (userInput < 1 || userInput > 100)
                    System.err.println("Не соответствует условиям ввода!");
                else
                    break;
            } catch (NumberFormatException e) {
                System.err.println("Не соответствует условиям ввода!");
            }
        }
        //in.close();
        return userInput;
    }




}
