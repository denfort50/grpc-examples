package ru.dkalchenko.client.util;

public class PerformanceUtils {

    public static Long startMeasuring() {
        return System.currentTimeMillis();
    }

    public static String finishMeasuring(Long start) {
        var finish = System.currentTimeMillis();
        var time = (finish - start) / 1000;
        var minutes = time / 60;
        var seconds = time % 60;
        return minutes + " мин. " + seconds + " сек.";
    }
}
