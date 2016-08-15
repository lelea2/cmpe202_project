package Report;

import java.util.*;
import Membership.*;

/**
 * Created by LeonZhang on 8/10/16.
 */
public class CustomerReport extends Report {
    private Customer customer;

    public CustomerReport(Customer customer) {
        this.customer = customer;
        set_description("Customer report");
    }

    public void printReport() {
        System.out.println("\n" + _description);
        System.out.println("=====================================================================");
        System.out.println("Name          : " + customer.get_name());
        System.out.println("Phone#        : " + customer.get_phoneNumber());
        System.out.println("Total Rides   : " + customer.get_rides());
        System.out.println("Total Mileages: " + customer.get_mileages());
        System.out.println("Benefit       : " + customer.getBenefits());
        System.out.println("=====================================================================");
    }
}
