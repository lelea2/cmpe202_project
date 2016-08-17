package Base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public String getCurrentDate(){
        return simpleDateFormat.format(new Date());
    }
}