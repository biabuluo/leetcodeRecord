package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{21}:{12:20}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 一周的第几天
 */
public class t1185 {
    static String []week = {
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };
    static int[] monthDays = {
      31,28,31,30,31,30,31,31,30,31,30,31
    };
    //思路1：模拟
    public String dayOfTheWeek(int day, int month, int year) {
        int days = 4;
        boolean isLeapYear = false;
        for(int i=1971;i<year;i++){
            isLeapYear = ((i%4==0 && i%100!=0) || i%400==0);
            days += isLeapYear? 366 : 365;
        }
        for(int i=1;i<month;i++){
            days+=monthDays[i-1];
        }
        isLeapYear = (year%4==0&&year%100!=0)||year%400==0;
        days+=(isLeapYear && month>2)?1:0;
        days+=day;
        return week[days%7];
    }
}
