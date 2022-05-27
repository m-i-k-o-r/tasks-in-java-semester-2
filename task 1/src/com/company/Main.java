package com.company;

import static com.company.Time.comparison;
import static com.company.Time.dateSearchInTheText;

public class Main {

    /**
     * ЗАДАЧА №3 из файла, который загружен на мудл
     *
     * Реализовать класс Время (операции - аналогичные дате(операции +/- n дней/месяцев/лет, сравнение дат,
     * форматирование даты по шаблону, разбор даты из строки и т.п.)). Время внутри хранится в виде
     * целого числа – кол-ва секунд с 00:00
     */

    public static void main(String[] args) {

        Time time1 = new Time (4, 30, 3);
        Time time2 = new Time (3, 59, 3);

        comparison(time1, time2); //сравнение времени

        time2.addSec(24*60*60 + 360); //добавление времени в секундах, минутах или часах

        /*time2.addMin();
        time2.addHour();*/

        time2.print(); //"печать" (вывод) времени

        time1.removeSec(2000); //вычитание времени в секундах, минутах или часах

        /*time1.removeMin();
        time1.removeHour();*/

        time1.print();
        comparison(time1, time2);

        dateSearchInTheText("Привет! Ты свободен сегодня после 18:35 ?"); //вывод даты из строки
    }
}
