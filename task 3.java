/*
3.	Создать программу, которая будет:
-	подсчитывать количество слов в предложении
-	выводить их в отсортированном виде
-	делать первую букву каждого слова заглавной.
Предложение вводится вручную. (Разделитель пробел (“ ”)).
*/

package by.dima.senla.task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        lineConvert();
    }

    /**
     * основоной метод задачи
     */
    public static void lineConvert() {
        System.out.println("Введите предложение, разделяя слова пробелами: ");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //String line = "Раз два Три Четыре пять вышел зайчик погулять";//отладка

        // преобразовываем строку в массив слов через пробел
        // и сразу делаем буквы большими
        //если  другие символы, то работать не будет :)
        String[] words = upperConvert(line.split(" "));

        sortArray (words); // сортируем массив по возрастанию

        System.out.println("В предложении "+words.length+" слов");
        System.out.println("Отсортированные по алфавиту слова с большой буквы:");
        for (String s:words) {
            System.out.print(s+" ");
        }
    }

    /**конвертирует все первые буквы слова в большие из массива
     *
     * @param s - массив слов
     * @return - преобразованный массив слов
     */
    public static String[]  upperConvert (String[] s){
        for (int i = 0; i < s.length; i++) {
            String first = s[i].substring(0,1).toUpperCase(); //преобразуем  первый символ в верхний регистр
            String all = s[i].substring(1); //формируем остальную часть слова
            s[i]=first+all; //делаем полное слово

        }
        return s;
    }

    /**сортирует строковый массив по возрастанию
     *
     * @param s - исходный массив
     */
    public static void sortArray (String[] s){
        String min, temp;
        int minIndex =0;
        for (int i = 0; i < s.length; i++) {
            min=s[i];
            temp =s[i];
            minIndex=i;
            for (int j = i+1; j < s.length; j++) {
                if (min.compareToIgnoreCase(s[j]) > 0) {// используем метод сравнения без учета регистра
                    min = s[j];
                    minIndex =j;
                }
            }
            s[i]= min;
            s[minIndex] = temp;
        }
    }

}
