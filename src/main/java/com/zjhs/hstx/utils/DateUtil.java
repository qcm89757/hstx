package com.zjhs.hstx.utils;

import com.zjhs.hstx.exception.OperationFailedException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>Title: 日期工具</p>
 */
@SuppressWarnings("Duplicates")
public class DateUtil {

    /**
     * yyyy-MM-dd HH:mm:ss 线程
     */
    private static ThreadLocal<DateFormat> Date_Time_ThreadLocal = new ThreadLocal<DateFormat>() {
        protected synchronized DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    /**
     * yyyyMMddHHmmss 线程
     */
    private static ThreadLocal<DateFormat> DateTimeThreadLocal = new ThreadLocal<DateFormat>() {
        protected synchronized DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmssSSS");
        }
    };

    /**
     * yyyy-MM-dd 线程
     */
    private static ThreadLocal<DateFormat> Date_ThreadLocal = new ThreadLocal<DateFormat>() {
        protected synchronized DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * yyyy年MM月dd日 线程
     */
    private static ThreadLocal<DateFormat> Date_Cn_ThreadLocal = new ThreadLocal<DateFormat>() {
        protected synchronized DateFormat initialValue() {
            return new SimpleDateFormat("yyyy年MM月dd日");
        }
    };

    /**
     * yyyyMM/dd/ 线程
     */
    private static ThreadLocal<DateFormat> Date_CreateFile_ThreadLocal = new ThreadLocal<DateFormat>() {
        protected synchronized DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMM/dd/");
        }
    };

    /**
     * HH:mm:ss 线程
     */
    private static ThreadLocal<DateFormat> Time_ThreadLocal = new ThreadLocal<DateFormat>() {
        protected synchronized DateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss");
        }
    };


    /**
     * ddHHmmss 线程
     */
    private static ThreadLocal<DateFormat> DayTime_ThreadLocal = new ThreadLocal<DateFormat>() {
        protected synchronized DateFormat initialValue() {
            return new SimpleDateFormat("ddHHmmss");
        }
    };

    /**
     * ddHHmmss 线程
     */
    private static ThreadLocal<DateFormat> YearMonthDay_ThreadLocal = new ThreadLocal<DateFormat>() {
        protected synchronized DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    /**
     * protect
     */
    private DateUtil() {

    }

    /**
     * 日期转化成日历类
     *
     * @param date
     * @return
     */
    public static Calendar setCalendarByDate(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        return cal;
    }

    /**
     * String 格式日期转日历
     *
     * @param strDate 日期
     * @param pattern 格式
     * @return 日历
     */
    public static Calendar getCalenderByStrDate(String strDate, String pattern) {
        if (pattern == null || "".equals(pattern)) {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            throw new OperationFailedException("无效的日期格式");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }


    /**
     * YYYY-MM-DD 转化时间
     *
     * @param dateString
     * @return
     */
    public static Date parse(String dateString) {

        if (StringUtils.isBlank(dateString)) return null;
        Date now = null;
        try {
            now = Date_ThreadLocal.get().parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 简单日期格式化
     *
     * @param date Date 日期
     * @return String 日期格式串
     */
    public static String format(Date date) {
        if (null == date) {
            return "";
        }
        return Date_ThreadLocal.get().format(date);
    }


    public static String YMdformat(Date date) {
        if (null == date) {
            return "";
        }
        return YearMonthDay_ThreadLocal.get().format(date);
    }

    public static String DayTimeformat(Date date) {
        if (null == date) {
            return "";
        }
        return DayTime_ThreadLocal.get().format(date);
    }

    /**
     * 2012-03-07 kouyunhao edit 添加方法：YYYY-MM-DD HH:mm:ss 转化时间 2013-4-23 19:30:02 23:59:59
     */
    public static Date parseDateTime(String dateString) {

        if (StringUtils.isBlank(dateString)) return null;
        Date now = null;
        try {
            now = Date_Time_ThreadLocal.get().parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 2012-03-06 kouyunhao edit 添加方法：返回给定日期的日期和时间
     */
    public static String date_timeFormat(Date dateTime) {

        return Date_Time_ThreadLocal.get().format(dateTime);
        //return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    /**
     * 返回当前日期的字符串
     *
     * @return String yyyy-MM-dd 当前日期格式的字符串
     */
    public static String getCurrentDate() {
        //return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return Date_ThreadLocal.get().format(new Date());
    }

    public static String getBeforCurrentDate() {
        //return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return getCurrentYearMonth() + "-01";
    }

    /**
     * 获取昨日日期 String
     */
    public static String getYesterdayStr() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return format(calendar.getTime());
    }

    /**
     * 获取昨日 Y-M-D 日期
     */
    public static Date getYesterdayYmd() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        //将时分秒置0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 返回当前年和月
     *
     * @return
     */
    public static String getCurrentYearMonth() {

        String currentDate = getCurrentDate();
        String resultValue = "";
        int pos = currentDate.lastIndexOf("-");
        if (pos != -1) {
            resultValue = currentDate.substring(0, pos);
        }
        return resultValue;
    }

    /**
     * 返回指定模式的年月
     *
     * @param pattern 模式
     * @return
     */
    public static String getCurrentYearMonth(String pattern) {

        if (StringUtils.isBlank(pattern)) {

            getCurrentYearMonth();
        }
        return new SimpleDateFormat(pattern).format(new Date());
    }

    /**
     * 返回当前年份
     *
     * @return
     */
    public static String getCurrentYear() {

        String currentDate = getCurrentDate();
        String resultValue = "";
        int pos = currentDate.indexOf("-");
        if (pos != -1) {
            resultValue = currentDate.substring(0, pos);
        }
        return resultValue;
    }

    /**
     * 返回当前月份
     *
     * @return
     */
    public static String getCurrentMoney() {

        String currentDate = getCurrentDate();
        String resultValue = "";
        int startPos = currentDate.indexOf("-");
        int endPos = currentDate.lastIndexOf("-");
        if (startPos != -1 && endPos != -1) {
            resultValue = currentDate.substring(startPos + 1, endPos);
        }
        return resultValue;
    }

    /**
     * 返回当前日
     *
     * @return
     */
    public static String getCurrentDay() {

        String currentDate = getCurrentDate();
        String resultValue = "";
        int pos = currentDate.lastIndexOf("-");
        if (pos != -1) {
            resultValue = currentDate.substring(pos + 1, currentDate.length());
        }
        return resultValue;
    }

    /**
     * 返回当前日<一位数字日>
     *
     * @return
     */
    public static String getCurrentOneLocationDay() {

        String currentDay = getCurrentDay();
        return currentDay = currentDay.substring(1);
    }

    /**
     * 返回当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        return Time_ThreadLocal.get().format(new Date());
        //return new SimpleDateFormat("hh:mm:ss").format(new Date());
    }

    /**
     * 返回给定日期时间的时间str
     *
     * @return
     */
    public static String getTimeOfDate(Date date) {
        return Time_ThreadLocal.get().format(date);
    }

    /**
     * 返回给定日期时间的日期str
     *
     * @return
     */
    public static String getDateOfDate(Date date) {
        return Date_ThreadLocal.get().format(date);
    }

    /**
     * 返回当前的日期和时间str
     */
    public static String getCurrentDateTime() {
        return Date_Time_ThreadLocal.get().format(new Date());
        //return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    /**
     * 返回当前的日期和时间str yyyyMMddHHmmss
     */
    public static String getCurrentYMDHMS() {
        return DateTimeThreadLocal.get().format(new Date());

    }

    /**
     * 返回分钟
     *
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        return setCalendarByDate(date).get(Calendar.MINUTE);
    }

    /**
     * 返回小时   24小时制
     *
     * @return
     */
    public static int get24Hour(Date date) {
        return setCalendarByDate(date).get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回小时   12小时制
     *
     * @param date
     * @return
     */
    public static int get12Hour(Date date) {
        return setCalendarByDate(date).get(Calendar.HOUR);
    }

    /**
     * 返回天数,一个月当中的第几天
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        return setCalendarByDate(date).get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        return setCalendarByDate(date).get(Calendar.MONTH) + 1;
    }

    /**
     * 返回年份
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        return setCalendarByDate(date).get(Calendar.YEAR);
    }

    /**
     * ----------------------核心方法------------------------
     */

    /**
     * 取得某天相加(减)後的那一天
     *
     * @param date Date 当前日期
     * @param num  int  正数表示相加后的那一天,负数表示相减后的那一天
     * @return Date 计算后的日期类型
     */
    public static Date getAnotherDate(Date date, int num) {
        Calendar cal = setCalendarByDate(date);
        //一年当中的天
        cal.add(Calendar.DAY_OF_YEAR, num);
        return cal.getTime();
    }

    /**
     * 取得某月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month) {

        Calendar cal = Calendar.getInstance();
        //设置年
        cal.set(Calendar.YEAR, year);
        //设置月
        cal.set(Calendar.MONTH, month - 1);
        //设置日 一号
        cal.set(Calendar.DATE, 1);
        //月份+1 得到下个月一号
        cal.add(Calendar.MONDAY, 1);
        //下个月-1  为这个月的最后一天
        cal.add(Calendar.DATE, -1);

        return cal.getTime();
    }

    /**
     * 取得某月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static int getMaxDayOfMonth(int year, int month) {

        Calendar cal = Calendar.getInstance();
        //设置年
        cal.set(Calendar.YEAR, year);
        //设置月
        cal.set(Calendar.MONTH, month - 1);
        //设置日 一号
        cal.set(Calendar.DATE, 1);
        //月份+1 得到下个月一号
        cal.add(Calendar.MONDAY, 1);
        //下个月-1  为这个月的最后一天
        cal.add(Calendar.DATE, -1);

        return cal.get(Calendar.DATE);
    }

    /**
     * 取得某天是一年当中的多少周
     *
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {

        Calendar cal = setCalendarByDate(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(7);
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 取得某天所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {

        Calendar cal = setCalendarByDate(date);
        //设置周一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        return cal.getTime();
    }

    /**
     * 取得某天所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar cal = setCalendarByDate(date);
        //设置周一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 6);
        return cal.getTime();
    }

    /**
     * 取得一年共有多少周
     *
     * @param year
     * @return
     */
    public static int CountWeeksOfYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        return getWeekOfYear(cal.getTime());
    }

    /**
     * 取得某年某周的第一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfYearWeek(int year, int week) {

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, 0, 7);
        //得到某天所在周的第一天
        Date firstDate = DateUtil.getFirstDayOfWeek(cal.getTime());

        Calendar firstDateCal = Calendar.getInstance();
        firstDateCal.setTime(firstDate);

        Calendar c = new GregorianCalendar();
        //设置年
        c.set(Calendar.YEAR, year);
        //设置月
        c.set(Calendar.MONTH, Calendar.JANUARY);
        //设置日
        c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

        Calendar cal2 = (GregorianCalendar) c.clone();
        cal2.add(Calendar.DATE, (week - 1) * 7);
        firstDate = getFirstDayOfWeek(cal2.getTime());

        return firstDate;
    }

    /**
     * 取得某年某周最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfYearWeek(int year, int week) {

        Calendar calLast = Calendar.getInstance();
        calLast.set(year, 0, 7);
        Date firstDate = getLastDayOfWeek(calLast.getTime());

        Calendar firstDateCal = Calendar.getInstance();
        firstDateCal.setTime(firstDate);

        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, (week - 1) * 7);
        Date lastDate = getLastDayOfWeek(cal.getTime());

        return lastDate;
    }

    /**
     * 判断指定的年月日是星期几
     *
     * @param year  指定年
     * @param month 指定月
     * @param day   指定日
     */
    public static String showWeekDay(int year, int month, int day) {

        char[] ch = new char[]{'日', '一', '二', '三', '四', '五', '六'};

        int eclipseDays = 1; // 公元元年一月一日是星期一

        eclipseDays += year - 1;

        for (int i = 1; i < year; i++) {

            if (isBissextile(i))

                eclipseDays++;

        }

        switch (month) {

            case 1:
                break;

            case 2:
                eclipseDays += 3;
                break;

            case 3:
                eclipseDays += 3;
                break;

            case 4:
                eclipseDays += 6;
                break;

            case 5:
                eclipseDays += 8;
                break;

            case 6:
                eclipseDays += 11;
                break;

            case 7:
                eclipseDays += 13;
                break;

            case 8:
                eclipseDays += 16;
                break;

            case 9:
                eclipseDays += 19;
                break;

            case 10:
                eclipseDays += 21;
                break;

            case 11:
                eclipseDays += 24;
                break;

            case 12:
                eclipseDays += 26;

        }
        if (isBissextile(year) && month > 2)

            eclipseDays++;

        eclipseDays = (eclipseDays + day - 1) % 7;

        String dayOfWeek = "星期" + String.valueOf(ch[eclipseDays]);

        return dayOfWeek;
    }

    /**
     * 计算当前时间是一周中的星期几
     *
     * @return String 当前时间是一周中的星期几
     */
    public static String getNowDateOfWeekDay() {

        int year = Integer.parseInt(getCurrentYear());
        int month = Integer.parseInt(getCurrentMoney());
        int day = Integer.parseInt(getCurrentDay());

        char[] ch = new char[]{'日', '一', '二', '三', '四', '五', '六'};

        int eclipseDays = 1; // 公元元年一月一日是星期一

        eclipseDays += year - 1;
        for (int i = 1; i < year; i++) {
            if (isBissextile(i))
                eclipseDays++;
        }
        switch (month) {

            case 1:
                break;

            case 2:
                eclipseDays += 3;
                break;

            case 3:
                eclipseDays += 3;
                break;

            case 4:
                eclipseDays += 6;
                break;

            case 5:
                eclipseDays += 8;
                break;

            case 6:
                eclipseDays += 11;
                break;

            case 7:
                eclipseDays += 13;
                break;

            case 8:
                eclipseDays += 16;
                break;

            case 9:
                eclipseDays += 19;
                break;

            case 10:
                eclipseDays += 21;
                break;

            case 11:
                eclipseDays += 24;
                break;

            case 12:
                eclipseDays += 26;

        }

        if (isBissextile(year) && month > 2)

            eclipseDays++;

        eclipseDays = (eclipseDays + day - 1) % 7;

        String dayOfWeek = "星期" + String.valueOf(ch[eclipseDays]);

        return dayOfWeek;
    }

    /**
     * 是否为闰年
     *
     * @param year 指定年
     * @return
     */
    public static boolean isBissextile(int year) {
        boolean bissextileFlag = false;
        if (year % 4 == 0) {
            if (year % 100 != 0)
                bissextileFlag = true;
            else if (year % 400 == 0)
                bissextileFlag = true;
        }
        return bissextileFlag;
    }

    /**
     * 获得指定年月的当月天数
     *
     * @param year  指定年
     * @param month 指定月(传入的月份从1开始)
     * @return 当前年月的最大天数
     */
    public static int getYearMonthOfMaxDay(int year, int month) {
        if (year <= 0 || month <= 0) return 0;
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, 1);
        return cal.getActualMaximum(Calendar.DATE);
    }

    public static String getFullDate() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }

    public static String getFullDate(Date d) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(d);
    }


    /**
     * 计算2个日期相差的天数(严格计算,按照天)
     *
     * @param startDate    Date 开始时间
     * @param endDate      Date 结束时间
     * @param roundingMode 小数获取类别：进位，舍去，四舍五入 BigDecimal.ROUND_UP 等
     * @return int 2个日期相差的天数
     */
    public static int getIntervalDays(Date startDate, Date endDate, int roundingMode) {
        if (null == startDate || null == endDate) {
            return -1;
        }
        BigDecimal intervalMilli = BigDecimal.valueOf(endDate.getTime() - startDate.getTime());
        return intervalMilli.divide(new BigDecimal(24 * 60 * 60 * 1000), roundingMode).intValue();
    }

    /**
     * 计算2个日期相差的天数(跨年会出错)
     *
     * @param startDate Date 开始时间
     * @param endDate   Date 结束时间
     * @return int 2个日期相差的天数
     */
    public static int getIntervalDays2(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int day1 = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(endDate);
        int day2 = calendar.get(Calendar.DAY_OF_YEAR);
        return day2 - day1;
    }


    /**
     * 计算两个时间相差的时间，大于一天的显示剩余几天，小于一天的显示剩余几个小时
     */
    public static String getIntervalStr(Date startDate, Date endDate) {
        if (null == startDate || null == endDate) {
            return "";
        }
        long intervalMilli = endDate.getTime() - startDate.getTime();
        int intervalDay = (int) (intervalMilli / (24 * 60 * 60 * 1000));
        if (intervalDay >= 1) {
            return "剩余" + intervalDay + "天";
        } else if (intervalDay >= 0) {
            int intervalHour = (int) (intervalMilli / (60 * 60 * 1000));
            return "剩余" + intervalHour + "小时";
        } else {
            return "已超期";
        }
    }

    /**
     * 计算2个时间相差的毫秒数
     */
    public static long getIntervalMillis(Date startDate, Date endDate) {
        if (null == startDate || null == endDate) {
            return 0;
        }
        return endDate.getTime() - startDate.getTime();
    }

    /**
     * 计算两个时间相差的时间，显示几个小时
     */
    public static Integer getTwoDateInterval(Date startDate, Date endDate) {
        if (null == startDate || null == endDate) {
            return 0;
        }
        long intervalMilli = endDate.getTime() - startDate.getTime();
        return (int) (intervalMilli / (60 * 60 * 1000));
    }

    /**
     * 计算2个日期相差的天数(跨年会出错)
     *
     * @param startDateString String 开始时间
     * @param endDateString   String 结束时间
     * @return int 2个日期相差的天数
     */
    public static int getIntervalDays(String startDateString, String endDateString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(startDateString);
            Date endDate = dateFormat.parse(endDateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            int day1 = calendar.get(Calendar.DAY_OF_YEAR);
            calendar.setTime(endDate);
            int day2 = calendar.get(Calendar.DAY_OF_YEAR);
            return day2 - day1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 判断指定的年月日是星期几(数字)
     *
     * @param date 指定日期
     * @return int 数字星期几
     */
    public static int showWeekOfDay(Date date) {
        int year = getYear(date);
        int month = getMonth(date);
        int day = getDay(date);
        String dayOfWeek = DateUtil.showWeekDay(year, month, day);
        int pday;
        if ("星期一".equals(dayOfWeek)) {
            pday = 1;
        } else if ("星期二".equals(dayOfWeek)) {
            pday = 2;
        } else if ("星期三".equals(dayOfWeek)) {
            pday = 3;
        } else if ("星期四".equals(dayOfWeek)) {
            pday = 4;
        } else if ("星期五".equals(dayOfWeek)) {
            pday = 5;
        } else if ("星期六".equals(dayOfWeek)) {
            pday = 6;
        } else {
            pday = 7;
        }
        return pday;
    }

    /**
     * 把时间转换成String
     *
     * @param date    时间
     * @param pattern 格式 如 yyyy-MM-dd HH24:mm:ss
     * @return string
     */
    public static String DateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 把字符串转化成时间
     *
     * @param dateStr 字符串时间
     * @param pattern 格式 如 yyyy-MM-dd HH24:mm:ss
     * @return String
     */
    public static Date StringToDate(String dateStr, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
        }
        return date;
    }

    /**
     * 把字符串类型的时间转成pattern类型的字符串
     *
     * @param dateStr 字符串类型的时间
     * @param pattern 类型
     * @return
     */
    public static String DateStrToString(String dateStr, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        String dateString = null;
        try {
            date = format.parse(dateStr);
            dateString = format.format(date);
        } catch (ParseException e) {
            // e.printStackTrace();
        }
        return dateString;
    }

    /**
     * 判读第三参数时间在第一参数时间和第二参数时间中间
     *
     * @param begintime String 开始时间
     * @param endtime   String 结束时间
     * @param modtime   String 中间时间
     * @return boolean
     */
    public static boolean isBetweenDays(String begintime, String endtime, String modtime) {
        boolean flag = false;
        if ((parse(begintime).getTime() <= parse(modtime).getTime() && parse(modtime).getTime() < parse(endtime).getTime())
                || (parse(begintime).getTime() < parse(modtime).getTime() && parse(modtime).getTime() <= parse(endtime).getTime())) {
            flag = true;
        }
        return flag;
    }

    /**
     * 将date格式日期转换为 yyyy年MM月dd日
     *
     * @param date
     * @return
     */
    public static String dataToFomatString(Date date) {
        return Date_Cn_ThreadLocal.get().format(date);
    }

    /**
     * yyyyMM/dd/ 创建文件夹格式
     *
     * @return
     */
    public static String createFileDate() {
        return Date_CreateFile_ThreadLocal.get().format(new Date());
    }

    /**
     * 获取从开始日期到结束日期年月序列 201312,20141,20142
     */
    public static List<String> getYearMonth(Date minDate, Date maxDate) {
        List<String> rtn = new ArrayList<String>();
        int maxYear = getYear(maxDate);
        int maxMonth = getMonth(maxDate);
        int year = getYear(minDate);
        int month = getMonth(minDate);
        rtn.add(year + "" + month);
        while (month != maxMonth || year != maxYear) {
            month++;
            if (month == 13) {
                year++;
                month = 1;
            }
            rtn.add(year + "" + month);
        }
        return rtn;
    }

    /**
     * 获取当前输入时间所在月份的所有 天
     *
     * @return
     */
    public static List<String> getDaysOfNowMonth() {
        List<String> monthDayList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("d");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        //获取当月最后一天
        Integer last = Integer.parseInt(format.format(ca.getTime()));
        for (int i = 1; i <= last; i++) {
            monthDayList.add(i + "");
        }
        return monthDayList;
    }

    /**
     * 获取当前输入时间所在月份的所有日期
     *
     * @return
     */
    public static Map<String, Date> getDateOfNowMonth() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Map<String, Date> dateMap = new HashMap<>();
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        try {
            //第一天
            String firstDateStr = simpleDateFormat.format(c.getTime());
            Date firstDate = simpleDateFormat.parse(firstDateStr);
            //最后一天
            String lastDateStr = simpleDateFormat.format(ca.getTime());
            Date lastDate = simpleDateFormat.parse(lastDateStr);

            dateMap.put("firstDay", firstDate);
            dateMap.put("lastDay", lastDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateMap;
    }

    /**
     * 获取今日前number日的日期
     */
    public static Date getDayFromToday(Integer days) {
        return getDateFromDays(new Date(), -days, null);
    }

    /**
     * 指定天数前后的日期
     * 正数往后，负数往前
     */
    public static Date getDateFromDays(Date date, int days, String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd";
        }
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DAY_OF_YEAR, days);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String tagDate = simpleDateFormat.format(c.getTime());
            return simpleDateFormat.parse(tagDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 指定周前后的日期
     */
    public static Date getDateFromWeek(Date date, int week) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        cal.add(Calendar.WEEK_OF_YEAR, week);
        return cal.getTime();
    }

    /**
     * 日期上加上月份值
     * <p>
     * 整数往后推,负数往前移动
     */
    public static Date getDateFromMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        //把日期往后增加一个月.整数往后推,负数往前移动
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

    /**
     * 计算两个时间相差几分钟
     *
     * @param fDate 时间大的那个值
     * @param sDate 时间小的那个值
     */
    public static long getDatePoorMinutes(Date fDate, Date sDate) {
        // 获得两个时间的毫秒时间差异
        long diff = fDate.getTime() - sDate.getTime();
        // 计算差多少分钟
        return diff / (1000 * 60);
    }

    /**
     * 取得指定分钟数后的时间
     *
     * @param date   基准时间
     * @param minute 指定分钟数，允许为负数
     * @return 指定小时数后的时间
     */
    public static Date addMinute(Date date, int minute) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }


    /**
     * 取得指定小时数后的时间
     *
     * @param date       基准时间
     * @param hourAmount 指定小时数，允许为负数
     * @return 指定小时数后的时间
     */
    public static Date addHour(Date date, int hourAmount) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hourAmount);
        return calendar.getTime();
    }

    /**
     * 取得指定小时数后的时间
     *
     * @param date       基准时间
     * @param hourAmount 指定小时数，允许为负数
     * @return 指定小时数后的时间
     */
    public static String addHourToStr(Date date, int hourAmount) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hourAmount);
        return date_timeFormat(calendar.getTime());
    }

    public static String getCurrentMonthFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //获取前月的第一天
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return format.format(c.getTime());
    }

    public static String getCurrentMonthLastDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(ca.getTime());
    }

    /**
     * 根据calendar显示星期几
     *
     * @param calendar
     * @return
     */
    public static String showWeekDay(Calendar calendar) {
        if (calendar == null) {
            throw new IllegalArgumentException("The calendar must not be null");
        }
        char[] ch = new char[]{'日', '一', '二', '三', '四', '五', '六'};
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return "星期" + ch[dayOfWeek - 1];
    }

    /**
     * 获取指点日期相隔天数的日期
     *
     * @param sourceDay 指定日期
     * @param days      间隔天数
     * @param pattern   格式
     * @return String
     */
    public static String getSpecifiedDay(String sourceDay, int days, String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd";
        }
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(sourceDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + days);

        return new SimpleDateFormat(pattern).format(c.getTime());
    }

    /**
     * 获取指定相隔月份的年月
     *
     * @param months  相隔月数
     * @param pattern 返回日期格式
     * @return 年月
     */
    public static String getSpecifiedYearMonth(int months, String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM";
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, months);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(cal.getTime());
    }

    /**
     * 获取指定月的上一个月
     *
     * @param sourceMonth 目标年月 yyyy-MM 格式
     * @param pattern     日期格式
     * @return 上月日期
     */
    public static String getPreYearMonth(String sourceMonth, String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM";
        }
        int year = Integer.parseInt(sourceMonth.substring(0, 4));
        int month = Integer.parseInt(sourceMonth.substring(5, 7));
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 2);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(cal.getTime());
    }

    /**
     * 获取目标日期月的最后一天的日期
     *
     * @param sourceMonth 目标月份  yyyy-MM 格式
     * @param pattern     日期格式
     * @return yyyy-MM-dd
     */
    public static String getLastDayOfMonth(String sourceMonth, String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd";
        }
        int year = Integer.parseInt(sourceMonth.substring(0, 4));
        int month = Integer.parseInt(sourceMonth.substring(5, 7));
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(cal.getTime());
    }

    /**
     * 获取当天YMD格式的日期
     * yyyy-MM-dd
     * @return date
     */
    public static Date getCurYmdDate() {
        Calendar calendar = Calendar.getInstance();
        //将时分秒置0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 格式化指定日期YMD
     *
     * @param tagDate 目标日期
     * @return date
     */
    public static Date formatYmdDate(Date tagDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(tagDate);
        //将时分秒置0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当月的天数
     *
     * @return int
     */
    public static int getCurrentMonthDays() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, 1);//把日期设置为当月第一天  
        c.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
        return c.get(Calendar.DATE);
    }

    public static void main(String[] args) {

        // List<String> monthFullDay = getMonthFullDay("2019-08");
        // System.out.println(monthFullDay);
        List<String> dayList = getStrDayList(parse("2019-12-30"), parse("2020-01-03"));
        System.out.println(dayList);
    }


    /**
     * 获取指定年月的月份的所有天数的列表
     *
     * @param yearAndMonth
     * @return
     */
    public static List<String> getMonthFullDay(String yearAndMonth) {
        int year = Integer.parseInt(yearAndMonth.split("-")[0]);
        int month = Integer.parseInt(yearAndMonth.split("-")[1]);
        SimpleDateFormat dateFormatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
        List<String> fullDayList = new ArrayList<>(32);
        // 获得当前日期对象
        Calendar cal = Calendar.getInstance();
        cal.clear();// 清除信息
        cal.set(Calendar.YEAR, year);
        // 1月从0开始
        cal.set(Calendar.MONTH, month - 1);
        // 当月1号
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 1; j <= count; j++) {
            fullDayList.add(dateFormatYYYYMMDD.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return fullDayList;
    }

    /**
     * 获取2个日期间的所有日期列表
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return list
     */
    public static List<String> getStrDayList(Date startDate, Date endDate) {
        List<String> dayList = new ArrayList<>();
        // 格式化开始日期，去掉时分秒毫秒
        Date startDateYmd = formatYmdDate(startDate);
        Calendar calendar = Calendar.getInstance();
        while (startDateYmd.getTime() <= endDate.getTime()) {
            dayList.add(format(startDateYmd));
            // 设置日期
            calendar.setTime(startDateYmd);
            //把日期增加一天
            calendar.add(Calendar.DATE, 1);
            // 获取增加后的日期
            startDateYmd = calendar.getTime();
        }
        return dayList;
    }

}