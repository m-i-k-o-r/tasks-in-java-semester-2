package com.company;

public class Time {

    private int sec;

    public int sec(){
        return sec;
    }

    public Time(int hour, int min, int sec) {
        this.sec = sec + min * 60 + hour * 60 * 60;
    }

    public Time(int hour, int min) {
        this.sec = min * 60 + hour * 60 * 60;
    }

    public Time(){
        this.sec = 0;
    }

    public String toString() {
        int hour = this.sec / 3600;
        int min = this.sec % 3600 / 60;
        int sec = this.sec % 60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

    public void print() {
        System.out.println(toString());
        System.out.println();
    }

    public void addTime(int sec){
        while(sec >= 24*60*60){
            sec -= 24*60*60;
        }
        this.sec += sec;
    }

    public void addSec(int sec) {
        addTime(sec);
    }

    public void addMin(int min) {
        addTime(min * 60);
    }

    public void addHour(int hour) {
        addTime(hour * 60 * 60);
    }


    public void removeTime(int sec){
        if(this.sec <= sec) {
            this.sec = 0;
        } else {
            this.sec -= sec;
        }
    }

    public void removeSec(int sec) {
        removeTime(sec);
    }

    public void removeMin(int min) {
        removeTime(min * 60);
    }

    public void removeHour(int hour) {
        removeTime(hour * 60 * 60);
    }

    public static void comparison (Time t1, Time t2){ // ( time1, time 2 )
        int s1 = t1.sec();
        int s2 = t2.sec();

        if (s1 < s2){
            System.out.println("Time1 (" + t1.toString() + ") раньше, чем Time2 (" + t2.toString() + ")");
        } else if (s1 > s2){
            System.out.println("Time2 (" + t2.toString() + ") раньше, чем Time1 (" + t1.toString() + ")");
        } else {
            System.out.println("Time1 (" + t1.toString() + ") равно Time2 (" + t2.toString() + ")");
        }
        System.out.println();
    }

    public static void dateSearchInTheText (String text){

        int i1 = text.indexOf(':');
        int i2 = text.indexOf(':', i1);

        if(i2 != -1){
            System.out.println("Время из текста: " + text.substring(i1 - 2, i2 + 3));
        } else {
            System.out.println("Время из текста: " + text.substring(i1 - 2, i1 + 3));
        }
        System.out.println();
    }
}

