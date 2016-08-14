package Report;

import Request.*;
import Membership.*;

/**
 * Created by kdao on 8/14/16.
 */
public class RequestReport extends Report {

    private Request request;

    public RequestReport(Request request) {
        this.request = request;
        set_description("Request report");
    }

    public void printReport() {
        System.out.println("\n" + _description);
        System.out.println("=====================================================================");
        System.out.println("ID:          " + request.getRequestId());
        System.out.println("State:       " + request.getState().getDescription());
        System.out.println("Start Point: " + request.getStartPoint().x + "," + request.getStartPoint().y);
        System.out.println("End Point:   " + request.getEndPoint().x + "," + request.getEndPoint().y);
        System.out.println("Time:        " + request.getReqTime());

//        if (request.getUser() != null) {
//            if (request.getUser() instanceof Driver) {
//                DriverReport driverReport = new DriverReport((Driver)request.getUser());
//                driverReport.printDriver();
//            }
//            if (request.getUser() instanceof Customer) {
//                CustomerReport driverReport = new CustomerReport((Customer)request.getUser());
//                driverReport.printCustomer();
//            }
//        }
    }
}
