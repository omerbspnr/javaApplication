package org.csystem.samples.countdowntimer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public abstract class CountDownTimer {
    private Timer m_timer;
    protected long m_totalTime;
    protected long m_period;

    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1);
    }

    private static void controlForTimer(long totalTime, long period)
    {
        if (period > totalTime)
            doWorkForException("Invalid period");
    }

    private static long getTotalTime(long val, TimeUnit timeUnit)
    {
        return TimeUnit.MILLISECONDS.convert(val,timeUnit);
    }

    private  static long getTotalTime(int hour, int minute, int second)
    {
        return  getTotalTime(hour,TimeUnit.HOURS) +
                getTotalTime(minute,TimeUnit.MINUTES) +
                getTotalTime(second,TimeUnit.SECONDS);
    }


    {
        m_timer = new Timer();
    }

    protected CountDownTimer (long totalTime, long period, TimeUnit timeUnit)
    {

        m_totalTime = getTotalTime(totalTime, timeUnit);
        m_period = getTotalTime(period, timeUnit);
    }

    protected CountDownTimer(int hour, int minute, int second, long period)
    {
        m_totalTime = getTotalTime(hour, minute, second);
    }

    protected CountDownTimer(long totalTime, long period)
    {
        this(totalTime, period, TimeUnit.MILLISECONDS);
    }

    public final void start()
    {
        m_timer.schedule(new TimerTask()
        {
            public void run()
            {

                CountDownTimer.this.onTick(m_totalTime);

                if (m_totalTime - m_period < 0)
                    CountDownTimer.this.onComplete();

                m_totalTime -= m_period;


            }
        }, 0, m_period);
    }


    public abstract void onTick(long remainMs);
    public abstract void onComplete();

    public void cancel()
    {
        m_timer.cancel();
    }
}
