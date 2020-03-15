package week177;

import java.util.Arrays;

/**
 * @author Lam
 * @ClassName P1
 * @date 2020/2/23
 */
public class P1 {
    int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        int[] yymmdd1 = Arrays.stream(date1.split("-")).mapToInt(Integer::parseInt).toArray();
        int[] yymmdd2 = Arrays.stream(date2.split("-")).mapToInt(Integer::parseInt).toArray();

        int days1 = calcDays(yymmdd1);
        int days2 = calcDays(yymmdd2);


        System.out.println("days1:" + days1);
        System.out.println("days2:" + days2);
        return Math.abs(days2 - days1);

    }

    private int calcDays(int[] yymmdd) {
        int days = 0;
        int year = yymmdd[0] - 1;
        int month = yymmdd[1];
        int day = yymmdd[2];
        days += year * 365 + (year / 4 - year / 100 + year / 400);
        year++;
        for (int i = 0; i < month-1; i++) {
            if (i==1&&(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
                days += 1;
            }
            days += months[i];
        }
        days += day;
        return days;
    }

    public static void main(String[] args) {
        new P1().daysBetweenDates("2074-09-12", "1983-01-08");
    }
}
