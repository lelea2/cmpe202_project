package Report;

import java.util.*;

/**
 * Created by kdao on 8/14/16.
 */
public abstract class ServiceCompositeReport<T extends Report> extends Report {
    protected Vector<T> reports;

    public ServiceCompositeReport(Vector<T> reports) {
        this.reports = reports;
    }

    public void printReports() {
        for (T t: reports) {
            t.printReport();
        }
    }

    public void addReport(T report) {
        reports.add(report);
    }

    public void removeReport(T report) {
        reports.remove(report);
    }

    public void printReport() {
        System.out.println("=====================================================================");
        for (int index = 0; index < reports.size(); ++index) {
            System.out.println("#" + (index+1));
            reports.get(index).printReport();
            System.out.println("=====================================================================\n");
        }
    }
}
