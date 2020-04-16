package org.csystem.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public final class TimerUtil {
    public static void show(int count, char ch, long delay, long period, TimeUnit timeUnit)
    {
        long delayInMs = TimeUnit.MILLISECONDS.convert(delay, timeUnit);
        long periodInMs = TimeUnit.MILLISECONDS.convert(period, timeUnit);

        Timer t = new Timer();

        t.schedule(new TimerTask() {
            private int m_count;

            public void run()
            {
                if (m_count == count) {
                    t.cancel();
                    return;
                }

                System.out.print(ch);
                ++m_count;
            }
        }, delayInMs, periodInMs);
    }
}
