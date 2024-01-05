package day.m12;

/**
 * @Author CuiChengLong
 * @Date 2023/12/31 12:29
 * @Description
 */

public class D_12_31_一年中的第几天 {

    public int dayOfYear(String date) {
        int[] month = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int m = 0;
        if (dates[1].charAt(0) == '0') {
            m = Integer.parseInt(dates[1].substring(1,2));
        } else {
            m = Integer.parseInt(dates[1]);
        }
        int d = 0;
        if (dates[2].charAt(0) == '0') {
            d = Integer.parseInt(dates[2].substring(1,2));
        } else {
            d = Integer.parseInt(dates[2]);
        }
        int res = 0;
        for (int i = 0; i < m - 1; i++) {
            res += month[i];
        }
        res += d;
        if (m > 2 && isLeapYear(year)) {
            res++;
        }
        return res;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        return year % 4 == 0 && year % 100 != 0;
    }

}
