/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

import java.util.Timer;

/**
 * @author 2NowakK
 */
public class Clock {
    private Timer timer;
    long startTime;
    long endTime;
    long totalTime;

    public Clock() {
        timer = new Timer();
        startTime = endTime = totalTime = 0;
    }

    public boolean startClock() {
        startTime = System.currentTimeMillis();
        return startTime != 0;
    }


    public boolean stopClock() {
        endTime = System.currentTimeMillis();
        return endTime != 0;
    }

    public long getOperationTime() {
        totalTime = endTime - startTime;
        if (totalTime > 2000)
            throw new OutOfTimeException();
        return totalTime;
    }
}
