package com.qy.base.util;

import com.qy.base.exception.ParamException;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    public static String parse(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String parse(Date date, String format) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }


    public static String dayParse(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static Date MonthParse(String date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date parse(String date) {
        try {
            if (!StringUtils.isNotBlank(date)) {
                return null;
            }
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ParamException("时间格式出错");
        }

    }

    public static Date parse(String date, String format) {
        try {
            if (!StringUtils.isNotBlank(date)) {
                return null;
            }
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ParamException("时间格式出错");
        }

    }

    public static Date parseDay(String date) {
        try {
            if (!StringUtils.isNotBlank(date)) {
                return null;
            }
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ParamException("时间格式出错");
        }

    }

    /**
     * 获取这个月的最后一天 yyyy-MM-dd 00:00:00
     *
     * @param yearMonth yyyy-MM
     * @return
     */
    public static Date getLastDayOfMonth(String yearMonth) {
        int year = Integer.parseInt(yearMonth.split("-")[0]);  //年
        int month = Integer.parseInt(yearMonth.split("-")[1]); //月
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        // cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.MONTH, month); //设置当前月的上一个月
        // 获取某月最大天数
        //int lastDay = cal.getActualMaximum(Calendar.DATE);
        int lastDay = cal.getMinimum(Calendar.DATE); //获取月份中的最小值，即第一天
        // 设置日历中月份的最大天数
        //cal.set(Calendar.DAY_OF_MONTH, lastDay);
        cal.set(Calendar.DAY_OF_MONTH, lastDay - 1); //上月的第一天减去1就是当月的最后一天
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(cal.getTime());
        return parseDay(format);
    }

    /**
     * 格式化日期
     */
    public static String formatDate(Date date, String dateFormat) {
        if (date == null) {
            return "";
        }
        String str = dateFormat == null ? "yyyy-MM-dd日" : dateFormat;
        SimpleDateFormat format = new SimpleDateFormat(str);
        return formatDate(date, format);
    }

    /**
     * 格式化日期
     */
    public static String formatDate(Date date, SimpleDateFormat simpleDateFormat) {
        if (date == null) {
            return "";
        }
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化日期
     */
    public static String formatDate(Date date) {
        return formatDate(date, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }


    /**
     * 格式化日期
     */
    public static String formatDate(Long timestamp) {
        if (timestamp == null) {
            return "0";
        }
        Date date = new Date(timestamp);
        return formatDate(date, new SimpleDateFormat("yyyy-MM-dd"));
    }


    /**
     * 获取前一天时间
     */
    public static Date getSpecifiedDayBefore(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * 获取后一天时间
     */
    public static Date getSpecifiedDayAfter(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, +1);
        return cal.getTime();
    }


    /**
     * 获取今日开始时间 即0点
     */
    public static LocalDateTime getToDayBegin() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    }

    /**
     * 获取指定日期的开始时间 即0点
     */
    public static LocalDateTime getToDayBegin(Date date) {
        LocalDate localDate = dateToLocalDate(date);
        return LocalDateTime.of(localDate, LocalTime.MIN);
    }

    /**
     * 获取指定日期的结束时间 即23点59分59秒
     */
    public static LocalDateTime getToDayEnd(Date date) {
        LocalDate localDate = dateToLocalDate(date);
        return LocalDateTime.of(localDate, LocalTime.MAX);
    }


    /**
     * 获取今日结束时间 即23点59分59秒
     */
    public static LocalDateTime getToDayEnd() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }

    /**
     * 将日期转换成  xxxx-xx-xx 00:00:00  的格式
     */
    public static Date transformation(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String format = sdf.format(date);
        String format2 = format + " 00:00:00";
        //当前时间：xxxx-xx-xx 00:00:00
        return sdf2.parse(format2);
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime   当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取过去第几天的日期
     */
    public static String getPastDate(Date date, int past) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = format.format(today);
        return result;
    }


    public static LocalDate dateToLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }

    public static Date localDateToDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    public static LocalTime dateToLocalTime(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalTime localTime = instant.atZone(zoneId).toLocalTime();
        return localTime;
    }


    public static Date getLastWeekMonday(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    public static Date getThisWeekMonday(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    public static Date getNextWeekMonday(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, 7);
        return cal.getTime();
    }

    public static Date getPrevWeekMonday(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    /**
     * 获取上个月最后一天
     */
    public static Date getPrevMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONDAY, -1);
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取上个月第一天
     */
    public static Date getPrevMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONDAY, -1);
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }


    /**
     * 获取这个月最后一天
     */
    public static Date getThisMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取这个月第一天
     */
    public static Date getThisMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 判断日期是否是今天
     */
    public static boolean isToDay(Date date) {
        if (date == null) {
            return false;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();

        LocalDate now = LocalDate.now();

        return now.isEqual(localDate);
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static Long getTimeStampSecond() {
        return Instant.now().getEpochSecond();
    }


    public static String timestampSecondToLocalDateTime(Long timestamp) {
        if (timestamp == null) {
            return "0";
        }
        Instant instant = Instant.ofEpochSecond(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toString();
    }

    public static String timestampSecondToLocalDate(Long timestamp) {
        if (timestamp == null) {
            return "0";
        }
        if (timestamp == 0) {
            return "0";
        }
        Instant instant = Instant.ofEpochSecond(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate().toString();
    }

    /**
     * 获取月的第一天
     *
     * @param offsetMonth 当月month=0，上个月month=-1，上上个月month=-2，下个月month=1，下下个月month=2
     * @return
     */
    public static Date getMonthFirstDay(int offsetMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONDAY, offsetMonth);
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    //判断时间是否在24小时之内
    public static boolean isToday(Date inputJudgeDate) {
        boolean flag = false;
        //获取当前系统时间
        long longDate = System.currentTimeMillis();
        Date nowDate = new Date(longDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(nowDate);
        String subDate = format.substring(0, 10);
        //定义每天的24h时间范围
        String beginTime = subDate + " 00:00:00";
        String endTime = subDate + " 23:59:59";
        Date paseBeginTime = null;
        Date paseEndTime = null;
        try {
            paseBeginTime = dateFormat.parse(beginTime);
            paseEndTime = dateFormat.parse(endTime);

        } catch (ParseException e) {
            e.getMessage();
        }
        if (inputJudgeDate.after(paseBeginTime) && inputJudgeDate.before(paseEndTime)) {
            flag = true;
        }
        return flag;
    }

    //相差多少小时
    public static String DifferenceHours(Date nowDate, Date createDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = nowDate.getTime() - createDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        if (hour < 1) {
            return min + "分钟前";
        }
        if (day < 1) {
            return hour + "小时前";
        }
        return day + "天前";
    }

    public static void main(String[] args) throws ParseException {
        String nowDay = getNowDay();
        System.out.println(nowDay);

    }


    /**
     * 根据当前时间获取还有多久结束一天
     *
     * @param currentDate 当前时间
     * @param unit        单位，如，还剩多少秒结束一天
     * @return
     */
    public static long getRemainOneDay(Date currentDate, ChronoUnit unit) {
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        long min = unit.between(currentDateTime, midnight);
        return min;
    }

    /**
     * 根据当前时间获取还有多久结束一天
     *
     * @param now  当前时间
     * @param unit 单位，如，还剩多少秒结束一天
     * @return
     */
    public static long getRemainOneDay(LocalDateTime now, ChronoUnit unit) {
        Date date = localDateTimeToDate(now);
        return getRemainOneDay(date, unit);
    }


    /**
     * 根据日期计算年龄 工具类
     *
     * @param birthDay
     * @return
     * @throws ParseException
     */
    public static int getAgeByBirth(Date birthDay) throws ParseException {
        int age = 0;
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }//当前日期在生日之前，年龄减一
            } else {
                age--;//当前月份在生日之前，年龄减一
            }
        }
        return age;
    }

    /**
     * 获取今年
     *
     * @return
     */
    public static int getYear() {
        return LocalDateTime.now().getYear();
    }

    /**
     * 转换时间戳，单位秒
     *
     * @param beginDateTime
     * @return
     */
    public static Long localDateTimeToTimeStampSecond(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.of("+8"));
    }

    public static String getFrist() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //当月第一天
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        return df.format(gcLast.getTime());
    }

    public static String getFive() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //当月第五天
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 5);
        return df.format(gcLast.getTime());
    }

    public static String getLast() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //当月最后一天
        Calendar calendar1 = Calendar.getInstance();
        Date theDate1 = calendar1.getTime();
        String s = df.format(theDate1);
        calendar1.add(Calendar.MONTH, 1);    //加一个月
        calendar1.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar1.add(Calendar.DATE, -1);
        return df.format(calendar1.getTime());
    }

    public static String getFristDay(String startTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //前端传过来的日期 的当月第一天
        Date parseStartTime = df.parse(startTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseStartTime);
        int actualMinimum = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, actualMinimum);
        Date theDate = calendar.getTime();
        return df.format(theDate);
    }

    public static String getLastDay(String endTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //前端传过来的日期 的当月最后一天
        Calendar calendar1 = Calendar.getInstance();
        Date parseEndTime = df.parse(endTime);
        calendar1.setTime(parseEndTime);
        int actualMaximum = calendar1.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar1.set(Calendar.DAY_OF_MONTH, actualMaximum);
        Date theDate1 = calendar1.getTime();
        return df.format(theDate1);
    }

    public static String getFristDayLastMonth(String startTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //前端传过来的日期 的上个月第一天
        Date parseStartTime = df.parse(startTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseStartTime);
        int actualMinimum = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, actualMinimum);
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();
        return df.format(theDate);
    }

    public static String getLastDayLastMonth(String endTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //前端传过来的日期 的上月最后一天
        Calendar calendar1 = Calendar.getInstance();
        Date parseEndTime = df.parse(endTime);
        calendar1.setTime(parseEndTime);
        int actualMaximum = calendar1.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar1.set(Calendar.DAY_OF_MONTH, actualMaximum);
        calendar1.add(Calendar.MONTH, -1);
        Date theDate1 = calendar1.getTime();
        return df.format(theDate1);
    }

    public static String getYesterDay(String startTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //得到昨天的日期
        Calendar calendar1 = Calendar.getInstance();
        Date date = df.parse(startTime);
        calendar1.setTime(date);
        calendar1.add(Calendar.DATE, -1);
        String yesterDay = df.format(calendar1.getTime());
        return yesterDay;
    }

    public static String getLastNDay(String startTime, int amount) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //从前端传过来的时间的前 n 天
        Calendar calendar1 = Calendar.getInstance();
        Date date = df.parse(startTime);
        calendar1.setTime(date);
        calendar1.add(Calendar.DATE, -amount);
        String lastSenvenDay = df.format(calendar1.getTime());
        return lastSenvenDay;
    }

    public static String getNowDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //得到今天的日期
        Calendar calendar1 = Calendar.getInstance();
        //得到当前时间
        return df.format(calendar1.getTime());
    }


    public static String getThreeMonthsLaterDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //得到昨天的日期
        Calendar calendar1 = Calendar.getInstance();
        //得到三个月以后的时间
        calendar1.add(Calendar.MONTH, 3);
        return df.format(calendar1.getTime());
    }

    public static String getDaysApart(String startTime, String endTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //相隔多少天
        Date start = df.parse(startTime);
        Date end = df.parse(endTime);
        long startGetTime = start.getTime();
        long endGetTime = end.getTime();
        long l = (endGetTime - startGetTime) / 1000;
        Date date = new Date(start.getTime() - l);

        return df.format(date);
    }

    //得到两个时间之间的时长
    public static Double getDuration(String startTime, String endTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //相隔多少天
        Date start = df.parse(startTime);
        Date end = df.parse(endTime);
        long startGetTime = start.getTime();
        long endGetTime = end.getTime();
        long l1 = (endGetTime - startGetTime) / 1000;
        Double l = Double.valueOf(l1);
        return l;
    }


}
