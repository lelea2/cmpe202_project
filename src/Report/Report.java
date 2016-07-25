package Report;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by kdao on 7/22/16.
 */

public abstract class Report {
    protected String _description;
    protected String _title;
    private String _timestamp;

    /**
     *  Constructor
     */
    public Report() {
        _timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    public abstract void printReport();

    public String get_timestamp() {
        return _timestamp;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String description) {
        _description = description;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String title) {
        _title = title;
    }

}
