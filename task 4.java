/*
4.	Создать программу, которая подсчитывает сколько раз употребляется
слово в тексте (без учета регистра).
Текст и слово вводится вручную.

*/

package by.dima.senla.task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        wordFound();
    }

    /**
     * Основной метод задачи
     */
    public static void wordFound() {
        System.out.println("Введите текст: ");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //String line = "Опп Пп пре лоп кон";//отладка

        System.out.println("Введите искомое слово: ");
        String word = in.nextLine();
        System.out.println("Слово встречается "+wordCount(line, word)+" раз");
    }

    /**метод ищет слово в тексте и считает количество повторений
     *
     * @param line - исходный текст
     * @param word - искомое слово
     * @return - количество повторений
     */
    public static int wordCount(String line, String word) {
        line = line.toLowerCase(); // переодим в нижний регистр
        word = word.toLowerCase();
        int i = line.indexOf(word); // ищем слово в целом в тексте
        int count = 0;
        while (i >= 0) {
            count++;
            i = line.indexOf(word, i + 1); // ищем дальше после найденной позиции
        }
        return count;
    }

}
