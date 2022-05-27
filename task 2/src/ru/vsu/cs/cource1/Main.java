package ru.vsu.cs.cource1;

public class Main {

    /**
     *ЗАДАЧА №7 из файла, который загружен на мудл
     *
     * Удалить из списка все элементы, индекс которых (отсчет начинаем с 0) соответствует
     * какому-либо числу Фибоначчи.
     */
    // Числа Фибоначи => 0, 1, 1, 2, 3, 5, 8, 13 ...
    public static void main(String[] args) throws Exception {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addFirst(110); //Написаны такие значения, чтобы было легче проверять индексы
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);
        list.addLast(80);
        list.addLast(90);

        for (int i = 0; i < list.size(); i++) {
            System.out.print((i > 0 ? ", " : "") + list.get(i));
        }
        System.out.println();

        int[] fibonacciNumbers = new int[list.size()];
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;
        for (int i = 2; i < fibonacciNumbers.length; ++i) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        for(int i = list.size() - 1; i >= 0; i--) {
            for(int k = 0; k < fibonacciNumbers.length; k++) {
                if(i == fibonacciNumbers[k]){
                    list.remove(i);
                    break;
                }
            }
        }

        int i = 0;
        for (Integer v : list) {
            System.out.print((i > 0 ? ", " : "") + v);
            i++;
        }
    }
}
