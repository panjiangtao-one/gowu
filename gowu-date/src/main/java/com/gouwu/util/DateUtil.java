package com.gouwu.util;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    /**
     * 年月日时分秒(无下划线) yyyyMMddHHmmss
     */
    public static final String dtLong = "yyyyMMddHHmmss";
    /**
     * 完整时间 yyyy-MM-dd HH:mm:ss
     */
    public static final String simple = "yyyy-MM-dd HH:mm:ss";
    /**
     * 年月日(无下划线) yyyyMMdd
     */
    public static final String dtShort = "yyyyMMdd";
    /**
     * 年月日(无下划线) yyyy-MM-dd
     */
    public static final String dtShortTwo = "yyyy-MM-dd";
    /**
     * 年月日(无下划线) yyyyMM
     */
    public static final String dmShort = "yyyyMM";

    /**
     * 构造函数
     */
    private DateUtil() {
    }

    /**
     * 获取Calendar
     *
     * @param time
     * @return
     */
    public static Calendar getCalendar(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        return calendar;
    }

    /**
     * 获取指定时间的结束时间 00:00:00
     *
     * @return
     */
    public static Date getStartTime(Date time) {
        Calendar c = getCalendar(time);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 时间类型转字符串
     *
     * @param date 时间
     * @param type 时间格式字符串
     * @return 指定格式的字符串
     */
    public static String getDate2String(Date date,String type) {
        if(date == null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        return sdf.format(date);
    }

    /**
     * 获取指定时间当天天的结束时间 23:59:59
     *
     * @return
     */
    public static Date getEndTime(Date time) {
        Calendar c = getCalendar(time);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 获取时间索引
     *
     * @param time
     * @param flag
     * @return
     */
    public static int getTimeIndex(Date time, int flag) {
        Calendar c = getCalendar(time);
        return c.get(flag);
    }

    /**
     * 设置时间
     *
     * @param time
     * @param flag
     * @param value
     * @return
     */
    public static Date setTime(Date time, int flag, int value) {
        Calendar c = getCalendar(time);
        c.set(flag, value);
        return c.getTime();
    }

    /**
     * 设置时间
     *
     * @param time
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date setTime(Date time, int year, int month, int day) {
        Calendar c = getCalendar(time);
        c.set(year, month, day);
        return c.getTime();
    }

    public static Date addTime(Date time, int flag, int value) {
        Calendar c = getCalendar(time);
        c.add(flag, value);
        return c.getTime();
    }

    /**
     * 返回当前时间长整型
     *
     * @return
     */
    public static long getLongTime() {
        return System.currentTimeMillis();
    }

    /**
     * 返回当前时间字符型
     *
     * @return
     */
    public static String getLongDate() {
        long d = System.currentTimeMillis();
        return String.valueOf(d);
    }

    /**
     * 格式化日期,格式化后可直接insert into [DB]
     *
     * @return
     */
    public static String dateToStr(Date date) {

        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm", Locale.getDefault());
            String strDate = sdFormat.format(date);
            return strDate;
        }
    }

    public static String dateToStr2(Date date) {

        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdFormat = new SimpleDateFormat(
                    "yyyy/MM/dd HH:mm:ss", Locale.getDefault());
            String str_Date = sdFormat.format(date);
            return str_Date;
        }
    }

    public static String dateToStrYyyyMMdd(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd",
                    Locale.getDefault());
            String strDate = sdFormat.format(date);
            return strDate;
        }
    }

    public static String dateToStrMMdd(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdFormat = new SimpleDateFormat("MM-dd",
                    Locale.getDefault());
            String strDate = sdFormat.format(date);
            return strDate;
        }
    }

    public static String dateToStrHHmmss(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdFormat = new SimpleDateFormat("HHmmss",
                    Locale.getDefault());
            String strDate = sdFormat.format(date);
            return strDate;
        }
    }

    public static String dateToStr(Date date, String format) {

        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdFormat = new SimpleDateFormat(format,
                    Locale.getDefault());
            String strDate = sdFormat.format(date);
            return strDate;
        }
    }

    public static String getLocalStartDate() {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd",
                Locale.getDefault());
        String strDate = sdFormat.format(new Date());
        return strDate + " 00:00:00";

    }

    public static Date getStartDate() {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd",
                Locale.getDefault());
        String strDate = sdFormat.format(new Date());
        return strToDate(strDate + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getEndDate() {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd",
                Locale.getDefault());
        String strDate = sdFormat.format(new Date());
        return strToDate(strDate + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
    }

    public static String getLocalEndDate() {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd",
                Locale.getDefault());
        String strDate = sdFormat.format(new Date());
        return strDate + " 23:59:59";

    }

    /**
     * 反向格式化日期
     *
     * @return
     */
    public static Date strToDate(String str) {
        if (str == null) {
            return null;
        }
        // DateFormat defaultDate = DateFormat.getDateInstance();
        // 细化日期的格式
        SimpleDateFormat defaultDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date date = null;
        try {
            date = defaultDate.parse(str);
        } catch (ParseException pe) {
        }
        return date;
    }

    /**
     * 反向格式化日期
     *
     * @param str       要格式化字符串
     * @param formatStr 字符串的日期格式
     * @return
     */
    public static Date strToDate(String str, String formatStr) {
        try {
            if (str == null) {
                return null;
            }
            if (formatStr == null) {
                formatStr = "yyyy-MM-dd hh:mm";
            }

            SimpleDateFormat defaultDate = new SimpleDateFormat(formatStr);

            Date date = null;
            try {
                date = defaultDate.parse(str);
            } catch (ParseException pe) {
            }
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期计算
     *
     * @param date     起始日期
     * @param yearNum  年增减数
     * @param monthNum 月增减数
     * @param dateNum  日增减数
     */
    public static String calDate(String date, int yearNum, int monthNum,
                                 int dateNum) {
        String result = "";
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sd.parse(date));
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            result = sd.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Date calDate(Date date, int yearNum, int monthNum, int dateNum) {
        Date result = null;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            result = cal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 日期计算
     *
     * @param date      起始日期
     * @param yearNum   年增减数
     * @param monthNum  月增减数
     * @param dateNum   日增减数
     * @param hourNum   小时增减数
     * @param minuteNum 分钟增减数
     * @param secondNum 秒增减数
     * @return
     */
    public static Date calDate(Date date, int yearNum, int monthNum,
                               int dateNum, int hourNum, int minuteNum, int secondNum) {
        Date result = null;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            cal.add(Calendar.HOUR_OF_DAY, hourNum);
            cal.add(Calendar.MINUTE, minuteNum);
            cal.add(Calendar.SECOND, secondNum);
            result = cal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 返回当前时间，格式'yyyy-mm-dd HH:mm:ss' 可为插入当前时间
     *
     * @return
     */
    public static String getLocalDate() {
        Date dt = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getDefault());
        return df.format(dt);
    }

    /**
     * @return
     */
    public static String getLocalDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        df.setTimeZone(TimeZone.getDefault());
        return df.format(date);
    }

    public static String getLocalDate(String f) {
        Date dt = new Date();
        SimpleDateFormat df = new SimpleDateFormat(f);
        df.setTimeZone(TimeZone.getDefault());
        return df.format(dt);
    }

    /**
     * 返回当前时间，格式'yyyyMMddHHmmss' 可为插入当前时间
     *
     * @return
     */
    public static String getSimpleDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dt = new Date();
        return df.format(dt);
    }

    /**
     * 格式化时间为 yyyyMMddHHmmss
     * @param dt
     * @return
     */
    public static String getDateStr(Date dt){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(dt);
    }

    /**
     * 返回当前时间，格式'f' 可为插入当前时间
     *
     * @return
     */
    public static String getFormatDate(String f) {
        //
        SimpleDateFormat df = new SimpleDateFormat(f);
        Date dt = new Date();
        return df.format(dt);
    }

    public static String getFormatDate(String f, Date dt) {
        //
        SimpleDateFormat df = new SimpleDateFormat(f);
        return df.format(dt);

    }

    /**
     * 得到当天凌晨的6点，包括明天凌晨6点前的
     *
     * @return
     */
    public static String getTodaySixStr() {
        Date date = new Date();
        Date toDaySix = strToDate(dateToStr(date, "yyyy-MM-dd") + " 06:00");
        if (date.getTime() - toDaySix.getTime() > 0) {
            // //大于6点
            return dateToStr(date, "yyyy-MM-dd");
        } else {
            return dateToStr(calDate(date, 0, 0, -1), "yyyy-MM-dd");
        }
    }

    /**
     * 得到当天日期和之前日期列表
     *
     * @return
     */
    public static List<String> getSixList() {
        Date date = new Date();
        Date toDaySix = strToDate(dateToStr(date, "yyyy-MM-dd") + " 06:00");
        Date daySix = null;
        if (date.getTime() - toDaySix.getTime() > 0) {
            // //大于6点
            daySix = date;
        } else {
            daySix = calDate(date, 0, 0, -1);
        }
        List<String> l = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            l.add(dateToStr(calDate(daySix, 0, 0, -i), "yyyy-MM-dd"));
        }
        return l;
    }

    /**
     * 得到当天凌晨的6点
     *
     * @return
     */
    public static Date getTodaySixDate(String dateStr) {
        Date toDaySix = strToDate(dateStr + " 06:00");
        return toDaySix;
    }

    /**
     * 得到明天凌晨的6点
     *
     * @param todaysix 今天6点
     * @return
     */
    public static Date getNextdaySixDate(Date todaysix) {
        return calDate(todaysix, 0, 0, 1);
    }

    /**
     * 格式化日期为“2004年9月13日”
     *
     * @param orlTime
     * @return
     */
    public static String parseCnDate(String orlTime) {
        if (orlTime == null || orlTime.length() <= 0) {
            return "";
        }

        if (orlTime.length() < 10) {
            return "";
        }
        String sYear = orlTime.substring(0, 4);
        String sMonth = delFrontZero(orlTime.substring(5, 7));
        String sDay = delFrontZero(orlTime.substring(8, 10));
        return sYear + "年" + sMonth + "月" + sDay + "日";
    }

    /**
     * 格式化日期为"9.13"
     *
     * @param orlTime
     * @return
     */
    public static String parsePointDate(String orlTime) {
        if (orlTime == null || orlTime.length() <= 0) {
            return "";
        }
        String sMonth = delFrontZero(orlTime.substring(5, 7));
        String sDay = delFrontZero(orlTime.substring(8, 10));
        return sMonth + "." + sDay;
    }

    /**
     * 取整函数
     *
     * @param mord
     * @return
     */
    public static String delFrontZero(String mord) {
        int im = -1;
        try {
            im = Integer.parseInt(mord);
            return String.valueOf(im);
        } catch (Exception e) {
            return mord;
        }
    }

    public static String getWeekStr(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        return getWeekStr(c, "星期");
    }

    public static String getWeekZHOU(Date time) {
        //赛事时间减去11:30时间.
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.add(Calendar.MINUTE, -30);
        c.add(Calendar.HOUR, -11);
        return getWeekStr(c, "周");
    }

    public static String getWeekStr(Calendar c, String z) {
        int a = c.get(Calendar.DAY_OF_WEEK);
        switch (a) {
            case 1:
                return z + "日";
            case 2:
                return z + "一";
            case 3:
                return z + "二";
            case 4:
                return z + "三";
            case 5:
                return z + "四";
            case 6:
                return z + "五";
            case 7:
                return z + "六";
            default:
                return null;
        }
    }

    public static Integer getWeek(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    public static Integer getYear(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        return c.get(Calendar.YEAR);
    }

    public static Integer getMonth(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        return c.get(Calendar.MONTH) + 1;
    }

    public static Integer getQuarter(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        int month = c.get(Calendar.MONTH);
        if (month < 3) {
            return 1;
        } else if (month >= 3 && month < 6) {
            return 2;
        } else if (month >= 6 && month < 9) {
            return 3;
        } else if (month >= 9 && month < 12) {
            return 4;
        } else {
            return null;
        }
    }

    public static Date getdecDateOfMinute(Date time, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.add(Calendar.MINUTE, -minute);
        return c.getTime();
    }

    public static Date getdecDateOfDate(Date time, int date) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.add(Calendar.DATE, -date);
        return c.getTime();
    }

    public static String getStringMonday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.HOUR, 23);
        c.set(Calendar.SECOND, 59);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }

    public static Date getTodayDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date getTommorrowDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date getYesterDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    // 获取本周 第一天
    public static Date getFirstDateOfWeek(Date date) {

        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);

        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        return c.getTime();
    }

    // 获取本周 第一天
    public static Date getFirstDateOfWeekUS() {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }


    /**
     * 获取月的第一天
     *
     * @param date
     * @return
     */
    public static Date getMonthFirstDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 判断是否是本月第一天
     *
     * @param date
     * @return
     */
    public static boolean isMonthFirstDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH) == 1;
    }

    /**
     * 获取月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getMonthEndDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }


    /**
     * 得到两个日期相隔天数
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return 相隔天数
     */
    public static int daysBetween(Date firstDate, Date secondDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            firstDate = sdf.parse(sdf.format(firstDate));
            secondDate = sdf.parse(sdf.format(secondDate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(firstDate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(secondDate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            return 0;
        }
    }

    /**
     * 按照指定格式格式化时间
     *
     * @param time
     * @param fmt
     * @return
     */
    public static String format(Date time, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(time);
    }

    /**
     * 按照指定格式格式化时间
     *
     * @param time
     * @param fmt
     * @return
     */
    public static Date parse(String time, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        try {
            return sdf.parse(time);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 时间格式转换
     *
     * @param time
     * @param fmt
     * @param tagret
     * @return
     */
    public static Date conver(Date time, String fmt, String tagret) {
        return DateUtil.parse(DateUtil.format(time, fmt), tagret);
    }

    /**
     * 获取当天的开始时间 00:00:00
     *
     * @return
     */
    public static Date getToday00() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取当天的开始时间 21:50:00
     *
     * @return
     */
    public static Date getToday2150() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 21);
        c.set(Calendar.MINUTE, 50);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定时间当天天的结束时间 00:00:00
     *
     * @return
     */
    public static Date getDate00(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定时间当天天的结束时间 23:59:59
     *
     * @return
     */
    public static Date getDate24(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 获取昨天的开始时间 21:50:00
     *
     * @return
     */
    public static Date getYesterDay2150() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -1);
        c.set(Calendar.HOUR_OF_DAY, 21);
        c.set(Calendar.MINUTE, 50);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }


    /**
     * 获取当天的时间 09:00:00
     *
     * @return
     */
    public static Date getToday09() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 9);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取第二天凌晨2点的时间 02:00:00
     *
     * @return
     */
    public static Date getTomorrow02() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 2);
        c.set(Calendar.MINUTE, 00);
        c.set(Calendar.SECOND, 00);
        return c.getTime();
    }

    /**
     * 获取当天的结束时间 23:59:59
     *
     * @return
     */
    public static Date getToday24() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }


    /**
     * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
     *
     * @return 以yyyyMMddHHmmss为格式的当前系统时间
     */
    public static String getOrderNum() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtLong);
        return df.format(date);
    }

    /**
     * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getDateFormatter() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(simple);
        return df.format(date);
    }

    /**
     * 自定义当前时间加3秒
     * @return
     */
    public static String getMyTime(){
        Date currentDate = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.SECOND,3);
        DateFormat df = new SimpleDateFormat(simple);
        return df.format(cal.getTime());
    }
    /**
     * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
     *
     * @return
     */
    public static String getDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtShort);
        return df.format(date);
    }


    /**
     * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
     *
     * @return
     */
    public static String getDate(Date date) {
        DateFormat df = new SimpleDateFormat(dtShort);
        return df.format(date);
    }

    /**
     * 获取系统当期年月日(精确到天)，格式：yyyy-MM-dd
     *
     * @return
     */
    public static String getDateTwo(Date date) {
        DateFormat df = new SimpleDateFormat(dtShortTwo);
        return df.format(date);
    }

    /**
     * 获取系统当期年月(精确到月)，格式：yyyyMM
     *
     * @return
     */
    public static String getMonth() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dmShort);
        return df.format(date);
    }

    /**
     * 获取系统当期年月(精确到月)，格式：yyyyMM
     *
     * @return
     */
    public static String getMonthString(Date date) {
        DateFormat df = new SimpleDateFormat(dmShort);
        return df.format(date);
    }

    /**
     * 产生随机的三位数
     *
     * @return
     */
    public static String getThree() {
        Random rad = new Random();
        return rad.nextInt(1000) + "";
    }

    /**
     * 比较两个时间的大小
     *
     * @param d1
     * @param d2
     * @return 0 表示相等 -1表示d1小于d2 , 1表示d1大于d2
     */
    public static int compareTime(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        return c1.compareTo(c2);
    }

    public static Date getEndMatchTime(Date endTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(endTime);
        int week = c.get(Calendar.DAY_OF_WEEK);
        int todayhour = 0;
        boolean isSunday = false;
        if (week == 1 || week == 7) {
            isSunday = true;
            todayhour = 1;
        }
        Long curTime = c.getTimeInMillis();
        //设置今天的0点或者1点
        c.set(Calendar.HOUR_OF_DAY, todayhour);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Long zeroTime = c.getTimeInMillis();
        //设置今天的9点
        c.set(Calendar.HOUR_OF_DAY, 9);
        c.set(Calendar.MINUTE, 3);
        c.set(Calendar.SECOND, 0);
        Long nineTime = c.getTimeInMillis();
        if (curTime >= zeroTime && curTime <= nineTime) {
            if (isSunday) {
                c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
                c.set(Calendar.HOUR_OF_DAY, 0);
                c.set(Calendar.MINUTE, 57);
                c.set(Calendar.SECOND, 0);
            } else {
                c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 1);
                c.set(Calendar.HOUR_OF_DAY, 23);
                c.set(Calendar.MINUTE, 57);
                c.set(Calendar.SECOND, 0);
            }

            return c.getTime();
        } else {
            return calDate(endTime, 0, 0, 0, 0, -3, 0);
        }
    }

    /**
     * 得到固定时分秒日期
     *
     * @param date 日期
     * @param str  比如 ： 00:00:00
     * @return
     */
    public static Date getDaydDawn(Date date, String str) {
        str = " " + str;
        return strToDate(dateToStr(date, "yyyy-MM-dd") + str);
    }

    /**
     * 比较日期大小
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return 比较结果
     * 返回0 表示时间日期相同
     * 返回1  表示日期2>日期1
     * 返回-1  表示日期2<日期1
     */
    public static int compareToDate(Date firstDate, Date secondDate) {
        return secondDate.compareTo(firstDate);
    }

    /**
     * 格式化日期为“2014-02-03”
     *
     * @param orlTime 比如 20140203
     * @return 2014-02-03 00:00:00
     */
    public static Date parseDate(String orlTime) {
        if (orlTime == null || orlTime.length() <= 0) {
            return null;
        }
        if (orlTime.length() < 8) {
            return null;
        }
        String sYear = orlTime.substring(0, 4);
        String sMonth = orlTime.substring(4, 6);
        String sDay = orlTime.substring(6, 8);
        return strToDate((sYear + "-" + sMonth + "-" + sDay), "yyyy-MM-dd");
    }

    /**
     * 格式化日期为“2014-02”
     *
     * @param orlTime 比如 201402
     * @return 2014-02-01 00:00:00
     */
    public static Date parsemonthDate(String orlTime) {
        if (orlTime == null || orlTime.length() <= 0) {
            return null;
        }
        if (orlTime.length() < 6) {
            return null;
        }
        String sYear = orlTime.substring(0, 4);
        String sMonth = orlTime.substring(4, 6);
        return strToDate((sYear + "-" + sMonth), "yyyy-MM");
    }

    public static int getDay4Week(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取过去 任意天内的日期数组
     *
     * @param intervals intervals天内
     * @return 日期数组
     */
    public static ArrayList<String> getDateLong(int intervals) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        for (int i = 0; i < intervals; i++) {
            pastDaysList.add(getPastDate(i));
        }
        return pastDaysList;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static Date getPastDate2(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        return today;
    }

    /**
     * 获取未来第几天的日期
     *
     * @param past
     * @return
     */
    public static Date getFutureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        return today;
    }


    /**
     * 获取过去第几天的DateMap
     *
     * @param past
     * @return
     */
    public static Map getPastDateMap(int past) {
        Map<String, String> dateStrMap = new TreeMap<>();
        List<String> lists = DateUtil.getDateLong(past);
        for (String s : lists) {
            dateStrMap.put(s, "");
        }
        return dateStrMap;
    }

    /**
     * 计算两个时间相差的小时
     * @param eTime 结束时间
     * @param sTime 开始时间
     * @return
     */
    public static int getTimeDifferenceHour(Date eTime,Date sTime){
        int hour;
        try {
            long nd = 1000 * 24 * 60 * 60;//每天毫秒数
            long nh = 1000 * 60 * 60;//每小时毫秒数
            long nm = 1000 * 60;//每分钟毫秒数
            long diff = eTime.getTime() - sTime.getTime(); // 获得两个时间的毫秒时间差异
            /*long day = diff / nd;   // 计算差多少天
            long hour = diff % nd / nh; // 计算差多少小时
            long min = diff % nd % nh / nm;  // 计算差多少分钟*/

            hour = (int) (diff / nh);
            long min = diff % nd % nh / nm;
            if (min>0){
                hour += 1;
            }
        } catch (Exception e){
            return 0;
        }
        return hour;
    }

    /**
     * 计算两个时间相差的分钟
     * @param eTime 结束时间
     * @param sTime 开始时间
     * @return
     */
    public static int getTimeDifferenceSecond(Date eTime,Date sTime){
        int ss;
        try {
            long nd = 1000 * 24 * 60 * 60;//每天毫秒数
            long nh = 1000 * 60 * 60;//每小时毫秒数
            long nm = 1000 * 60;//每分钟毫秒数
            long diff = eTime.getTime() - sTime.getTime(); // 获得两个时间的毫秒时间差异
            /*long day = diff / nd;   // 计算差多少天
            long hour = diff % nd / nh; // 计算差多少小时
            long min = diff % nd % nh / nm;  // 计算差多少分钟*/

            ss = (int) (diff / nm);
        } catch (Exception e){
            return 0;
        }
        return ss;
    }

    /**
     * 判断时间是否在时间段内
     * @param patter 时间比较的模式 "HH:mm:ss" || "HH:mm" 等，根据使用自己设置
     * @param nowTime 系统当前时间
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public static boolean belongCalendar(String patter,Date nowTime, String beginTime, String endTime) {
        boolean b ;
        try {
            SimpleDateFormat sdFormat = new SimpleDateFormat(patter);
            Date nowDate = sdFormat.parse(sdFormat.format(nowTime));
            Date beginDate = sdFormat.parse(beginTime);
            Date endDate = sdFormat.parse(endTime);
            //设置当前时间
            Calendar date = Calendar.getInstance();
            date.setTime(nowDate);
            //设置开始时间
            Calendar begin = Calendar.getInstance();
            begin.setTime(beginDate);
            //设置结束时间
            Calendar end = Calendar.getInstance();
            end.setTime(endDate);
            //处于开始时间之后，和结束时间之前的判断
            if (date.after(begin) && date.before(end)) {
                b = true;
            } else {
                b = false;
            }
        } catch (Exception e){
            b = false;
        }
        return b;
    }

}
