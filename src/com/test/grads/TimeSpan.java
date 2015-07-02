package com.test.grads;

import java.util.Date;
import java.text.MessageFormat;


public class TimeSpan
{
    private long hours;

    private long minutes;

    private long seconds;

    public TimeSpan()
    {
        Date now = new Date();
        long l = now.getTime() / 1000;
        setClock(l);
    } // end ctor TimeSpan

    public TimeSpan(
        Date startDate,
        Date endDate)
    {
        long l = (endDate.getTime() - startDate.getTime()) / 1000;
        setClock(l);
    } // end ctor TimeSpan

    public void setClock(long l)
    {
        hours = l / 60 / 60;
        minutes = (l / 60) - (hours * 60);
        seconds = l - (hours * 60 * 60) - (minutes * 60);
    } // end method setClock

    public String toString()
    {
        Object[] o = {
                new Long(hours),
                new Long(minutes),
                new Long(seconds)
            };

        return new MessageFormat("{0,number,00}:{1,number,00}: {2,number,00}")
                .format(o);
    } // end method toString
} // end class TimeSpan
