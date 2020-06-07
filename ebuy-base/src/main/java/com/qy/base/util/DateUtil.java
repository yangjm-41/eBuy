//package com.qy.base.util;
//
//import com.qy.base.exception.ParamException;
//import org.apache.commons.lang3.StringUtils;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.*;
//import java.time.temporal.TemporalField;
//import java.time.temporal.TemporalUnit;
//import java.util.Calendar;
//import java.util.Date;
//
//public class DateUtil {
//
//    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    static DateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    static SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd ");
//
//    public static String parse(Date date) {
//        if (date == null) {
//            return null;
//        }
//        return dateFormat.format(date);
//    }
//
//
//    public static String dayParse(Date date) {
//        if (date == null) {
//            return null;
//        }
//        return dayFormat.format(date);
//    }
//
//
//    public static Date parse(String date) {
//        try {
//            if (!StringUtils.isNotBlank(date)) {
//                return null;
//            }
//            return stringFormat.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            throw new ParamException("时间格式出错");
//        }
//
//    }
//
//
//    /**
//     * 格式化日期
//     */
//    public static String formatDate(Date date, String dateFormat) {
//        if (date == null) return "";
//        String str = dateFormat == null ? "yyyy-MM-dd HH:mm:ss" : dateFormat;
//        SimpleDateFormat format = new SimpleDateFormat(str);
//        String curdate = format.format(date);
//        return curdate;
//    }
//
//    /**
//     * 格式化日期
//     */
//    public static String formatDate(Date date) {
//        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
//    }
//
//    /**
//     * 格式化日期
//     */
//    public static String formatDate(Long timestamp) {
//        if (timestamp == null) {
//            return "0";
//        }
//        Date date = new Date(timestamp);
//        return formatDate(date, "yyyy-MM-dd");
//    }
//
//
//    /**
//     * 获取前一天时间
//     */
//    public static Date getSpecifiedDayBefore(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.add(Calendar.DATE, -1);
//        return cal.getTime();
//    }
//
//    /**
//     * 获取后一天时间
//     */
//    public static Date getSpecifiedDayAfter(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.add(Calendar.DATE, +1);
//        return cal.getTime();
//    }
//
////    public static void main(String[] args) {
////        String s = getToDayEnd().toString();
////        System.out.println(s);
////    }
//
//
//    /**
//     * 获取今日开始时间 即0点
//     */
//    public static LocalDateTime getToDayBegin() {
//        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
//    }
//
//    /**
//     * 获取指定日期的开始时间 即0点
//     */
//    public static LocalDateTime getToDayBegin(Date date) {
//        LocalDate localDate = dateToLocalDate(date);
//        return LocalDateTime.of(localDate, LocalTime.MIN);
//    }
//
//    /**
//     * 获取指定日期的结束时间 即23点59分59秒
//     */
//    public static LocalDateTime getToDayEnd(Date date) {
//        LocalDate localDate = dateToLocalDate(date);
//        return LocalDateTime.of(localDate, LocalTime.MAX);
//    }
//
//
//    /**
//     * 获取今日结束时间 即23点59分59秒
//     */
//    public static LocalDateTime getToDayEnd() {
//        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
//    }
//
//    /**
//     * 将日期转换成  xxxx-xx-xx 00:00:00  的格式
//     */
//    public static Date transformation(Date date) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        String format = sdf.format(date);
//        String format2 = format + " 00:00:00";
//        //当前时间：xxxx-xx-xx 00:00:00
//        return sdf2.parse(format2);
//    }
//
//    /**
//     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
//     *
//     * @param nowTime   当前时间
//     * @param startTime 开始时间
//     * @param endTime   结束时间
//     */
//    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
//        if (nowTime.getTime() == startTime.getTime()
//                || nowTime.getTime() == endTime.getTime()) {
//            return true;
//        }
//
//        Calendar date = Calendar.getInstance();
//        date.setTime(nowTime);
//
//        Calendar begin = Calendar.getInstance();
//        begin.setTime(startTime);
//
//        Calendar end = Calendar.getInstance();
//        end.setTime(endTime);
//
//        if (date.after(begin) && date.before(end)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /**
//     * 获取过去第几天的日期
//     */
//    public static String getPastDate(Date date, int past) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - past);
//        Date today = calendar.getTime();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String result = format.format(today);
//        return result;
//    }
//
//
//    public static LocalDate dateToLocalDate(Date date) {
//        Instant instant = date.toInstant();
//        ZoneId zoneId = ZoneId.systemDefault();
//        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
//        return localDate;
//    }
//
//    public static Date localDateToDate(LocalDate localDate) {
//        ZoneId zoneId = ZoneId.systemDefault();
//        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
//        Date date = Date.from(zdt.toInstant());
//        return date;
//    }
//
//    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
//        if (localDateTime == null) {
//            return null;
//        }
//        ZoneId zoneId = ZoneId.systemDefault();
//        ZonedDateTime zdt = localDateTime.atZone(zoneId);
//        Date date = Date.from(zdt.toInstant());
//        return date;
//    }
//
//    public static LocalDateTime dateToLocalDateTime(Date date) {
//        Instant instant = date.toInstant();
//        ZoneId zoneId = ZoneId.systemDefault();
//        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
//        return localDateTime;
//    }
//
//    public static LocalTime dateToLocalTime(Date date) {
//        Instant instant = date.toInstant();
//        ZoneId zoneId = ZoneId.systemDefault();
//        LocalTime localTime = instant.atZone(zoneId).toLocalTime();
//        return localTime;
//    }
//
//
//    public static Date getLastWeekMonday(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(getThisWeekMonday(date));
//        cal.add(Calendar.DATE, -7);
//        return cal.getTime();
//    }
//
//    public static Date getThisWeekMonday(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        // 获得当前日期是一个星期的第几天
//        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
//        if (1 == dayWeek) {
//            cal.add(Calendar.DAY_OF_MONTH, -1);
//        }
//        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
//        cal.setFirstDayOfWeek(Calendar.MONDAY);
//        // 获得当前日期是一个星期的第几天
//        int day = cal.get(Calendar.DAY_OF_WEEK);
//        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
//        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
//        return cal.getTime();
//    }
//
//    public static Date getNextWeekMonday(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(getThisWeekMonday(date));
//        cal.add(Calendar.DATE, 7);
//        return cal.getTime();
//    }
//
//    public static Date getPrevWeekMonday(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(getThisWeekMonday(date));
//        cal.add(Calendar.DATE, -7);
//        return cal.getTime();
//    }
//
//    /**
//     * 获取上个月最后一天
//     */
//    public static Date getPrevMonthLastDay() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MONDAY, -1);
//        calendar.set(Calendar.DAY_OF_MONTH,
//                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//        return calendar.getTime();
//    }
//
//    /**
//     * 获取上个月第一天
//     */
//    public static Date getPrevMonthFirstDay() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MONDAY, -1);
//        calendar.set(Calendar.DAY_OF_MONTH,
//                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
//        return calendar.getTime();
//    }
//
//    /**
//     * 获取这个月最后一天
//     */
//    public static Date getThisMonthLastDay() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DAY_OF_MONTH,
//                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//        return calendar.getTime();
//    }
//
//    /**
//     * 获取这个月第一天
//     */
//    public static Date getThisMonthFirstDay() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DAY_OF_MONTH,
//                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
//        return calendar.getTime();
//    }
//
//    /**
//     * 判断日期是否是今天
//     */
//    public static boolean isToDay(Date date) {
//        Instant instant = date.toInstant();
//        ZoneId zoneId = ZoneId.systemDefault();
//
//        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
//        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
//
//        LocalDate now = LocalDate.now();
//
//        return now.isEqual(localDate);
//    }
//
//    public static Long getTimeStampSecond() {
//        return Instant.now().getEpochSecond();
//    }
//
//    public static LocalDateTime timestampSecondToLocalDateTime(Long timestamp) {
//        if (timestamp == null) {
//            return null;
//        }
//        Instant instant = Instant.ofEpochSecond(timestamp);
//        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//    }
//
//    public static LocalDate timestampSecondToLocalDate(Long timestamp) {
//        if (timestamp == null) {
//            return null;
//        }
//        if (timestamp == 0) {
//            return null;
//        }
//        Instant instant = Instant.ofEpochSecond(timestamp);
//        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
//    }
//
//    public static long locaDateToTimeStampSecond(LocalDate localDate) {
//        if (localDate == null) {
//            return 0;
//        }
//        return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().getEpochSecond();
//    }
//
//    public static long locaDateTimeToTimeStampSecond(LocalDateTime localDateTime) {
//        if (localDateTime == null) {
//            return 0;
//        }
//        return localDateTime.toInstant(ZoneOffset.ofHours(8)).getEpochSecond();
//    }
//
//
//
//}
