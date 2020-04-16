package org.csystem.samples.countdowntimer;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CountDownTimerApp {

    public static final Scanner MS_KB = new Scanner(System.in);

    private static CountDownTimer createCountDownTimer(long totalTime, long period)
    {
        return new CountDownTimer(totalTime, period) {
            public void onTick(long remainMs)
            {
                System.out.printf("%d\r",TimeUnit.SECONDS.convert(remainMs, TimeUnit.MILLISECONDS));
            }

            public void onComplete()
            {
                super.cancel();
            }
        };
    }

    private static CountDownTimer createCountDownTimer(int hour, int minute, int second, long period)
    {
        return new CountDownTimer(hour,minute,second, period) {

            public void onTick(long remainMs)
            {
                long totalSecond = TimeUnit.SECONDS.convert(remainMs,TimeUnit.MILLISECONDS);

                System.out.printf("%02d:%02d:%02d\r", totalSecond / 3600, totalSecond / 60 % 60, totalSecond % 60);
            }

            public void onComplete()
            {
                System.out.println("completed");
                cancel();
            }
        };
    }

    private static CountDownTimer getTimer(int hour, int minute, int second, long period)
    {
        return createCountDownTimer(hour,minute,second,period);
    }
    private static CountDownTimer getTimer(long totalTime, long period)
    {
        return createCountDownTimer(totalTime, period);
    }

    public static void run()
    {
        long totalTime = Long.parseLong(MS_KB.nextLine());
        long period = Long.parseLong(MS_KB.nextLine());

        var downCounter = getTimer(totalTime, period);

        downCounter.start();
    }
}
