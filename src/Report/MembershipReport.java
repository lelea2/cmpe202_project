package Report;

import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by kdao on 7/26/16.
 * modify by LeonZhang on 8/10/16.
 */
public abstract class MembershipReport <T extends  Report>extends Report{
    protected ArrayList<T> reports;

    public  MembershipReport(ArrayList<T> v) {
        reports = v;
    };

    public void add(T report){
        reports.add(report);
    }

    public void remove(T report){
        reports.remove(report);
    }

    public void printReports() {
        for (T t : reports) {
            t.printReport();
        }
    }

    public void printRport(){
        System.out.println("");
        System.out.println(_description);
        System.out.println("---------------------------------------------------");
        for (int index = 0; index < reports.size(); ++index ) {
            System.out.println("#" + (index + 1));
            reports.get(index).printReport();
            System.out.println("---------------------------------------------------");
        }
        System.out.println("");
    }

}
