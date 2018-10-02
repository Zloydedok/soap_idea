package data;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

public class DateHelper {
    public HashMap<String, String> format_date_to_magazine_form() {

        HashMap<String, String> tmpHashMap = new HashMap<String, String>();

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        String dayStr = Integer.toString(day);
        tmpHashMap.put("day", dayStr);
        String curmonth = "";

        for (int i = 1; i <= month; i++) {
            if(month == 1){
                 curmonth = "Jan";
            }
            else if (month == 2){
                 curmonth = "Feb";
            }
            else if (month == 3){
                 curmonth = "Mar";
            }
            else if (month == 4){
                 curmonth = "Apr";
            }
            else if (month == 5){
                 curmonth = "May";
            }
            else if (month == 6){
                curmonth = "Jun";
            }
            else if (month == 7){
                 curmonth = "Jul";
            }
            else if (month == 8){
                 curmonth = "Aug";
            }
            else if (month == 9){
                curmonth = "Sep";
            }
            else if (month == 10){
                curmonth = "Oct";
            }
            else if (month == 11){
                curmonth = "Nov";
            }
            else if (month == 12){
                curmonth = "Dec";
            }
        }
        tmpHashMap.put("month", curmonth);
        return tmpHashMap;
    }
    public static String currentMonthAndDay() {
        DateHelper myDateHelper = new DateHelper();
        HashMap<String, String> values = myDateHelper.format_date_to_magazine_form();
        String day = values.get("day");
        String month = values.get("month");
        String currentMagazineFormatDate = ""+month+ " "+day+"";
        return currentMagazineFormatDate;
    }
}
