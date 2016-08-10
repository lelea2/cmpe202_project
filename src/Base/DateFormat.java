package Base;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class DateFormat {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm-dd-yyyy");

    public String getCurrentDate(){
        return simpleDateFormat.format(new Date());
    }
}
