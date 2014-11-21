package date;

import java.util.Calendar;

public class DateTime {

    public Calendar getDate(Long timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp);
        return cal;
    }

    public String getDateString(Calendar cal) {
        StringBuffer sb = new StringBuffer();

        sb.append(cal.get(Calendar.YEAR) +"-")
                .append(cal.get(Calendar.MONTH)+1 +"-")
                .append(cal.get(Calendar.DAY_OF_MONTH) +" ")
                .append(cal.get(Calendar.HOUR_OF_DAY) +":")
                .append(cal.get(Calendar.MINUTE) +":")
                .append(cal.get(Calendar.SECOND));
        return sb.toString();
    }


    public static void main(String[] args) {

        DateTime dateTime = new DateTime();

        Calendar cal1 = dateTime.getDate(1416458643452L);

        System.out.println(dateTime.getDateString(cal1));

        Calendar cal2 = dateTime.getDate(1416458396149L);

        System.out.println(dateTime.getDateString(cal2));
    }
}
