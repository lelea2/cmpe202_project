package Report;

import java.util.ArrayList;

/**
 * Created by kdao on 8/7/16.
 */

public class CompositeReport<T extends Report> extends Report {
    protected ArrayList<T> reports;

    public CompositeReport(ArrayList<T> v) {
        reports = v;
    }

    public void add(T report) {
        reports.add(report);
    }

    public void remove(T report) {
        reports.remove(report);
    }

    public void printReports()  {
        for (T t: reports) {
            t.printReport();
        }
    }

    public void printReport() {
        System.out.println(_description);
        System.out.println("---------------------------------------------------");
        for (int index = 0; index < reports.size(); ++index) {
            System.out.println("#" + (index+1));
            reports.get(index).printReport();
            System.out.println("---------------------------------------------------");
        }
    }
}
