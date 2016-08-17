package TestSuite;

/**
 * Created by kdao on 8/9/16.
 */
import Payment.*;
import Schedule.*;
import Vehicle.*;
import Membership.*;
import Request.*;
import Report.*;
import Dispatch.*;

import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        /**************************/
        //Define temp data store for registration
        ArrayList<Customer> customersList = new ArrayList<>();
        ArrayList<Driver> driversList = new ArrayList<>();
        ArrayList<Vehicle> vehiclesList = new ArrayList<>();
        ArrayList<Request> requestsList = new ArrayList<>();
        ArrayList<Schedule> schedulesList = new ArrayList<>();
        ArrayList<PaymentAndCustomer> paymentAndCustomers = new ArrayList<>();
        //End definition for data store registration
        /************************/
        Scanner input = new Scanner(System.in);

        System.out.println("/***********************************************************************************************/");
        System.out.println("/***************************** CARPOOL & PARKING SERVICE ***************************************/");
        System.out.println("/***********************************************************************************************/");
        String[] mainOptions = {"Register member in the system", "Create Vehicle", "Loading data", "Add ride request", "Process request queue",
                "Start a ride", "Finish a ride", "Cancel a ride", "Add feedback", "Delete User"};
        while(true) {
            int choice = getOption("==== Please pick one of the following option for testing ====", mainOptions);
            switch(choice) {
                case 1: //Register member in the system
                    String[] memberOptions = {"Create Customer", "Create Driver"};
                    int userChoice = getOption("User Menu", memberOptions);
                    switch (userChoice) {
                        case 1: // Create Customer
                        {
                            System.out.println(">>>>>>>>>>>>>>>>>>> Register as a customer <<<<<<<<<<<<<<<<<<");
                            System.out.println("Please enter Name:");
                            String name = input.next();
                            System.out.println("Please enter Phone Number:");
                            String phone = input.next();
                            System.out.println("Please enter email:");
                            String email = input.next();
                            System.out.println("Choose membership: 1 - Basic, 2 - Silver, 3 - Gold:");
                            int loyal_type = Integer.parseInt(input.next());
                            Customer member = new BasicMembership(name, phone, email);
                            if (loyal_type == 1) {
                                customersList.add(member);
                            } else if (loyal_type == 2) { //add silver membership
                                member = new SilverMembershipDecorator(member);
                                CreditCardPayment creditCardPayment = payMembership(name);
                                paymentAndCustomers.add(new PaymentAndCustomer(creditCardPayment, member));
                                customersList.add(member);
                            } else if (loyal_type == 3) {
                                member = new GoldMembershipDecorator(member);
                                CreditCardPayment creditCardPayment = payMembership(name);
                                paymentAndCustomers.add(new PaymentAndCustomer(creditCardPayment, member));
                                customersList.add(member);
                            } else {
                                inValidateRequest();
                                break;
                            }
                            //Printing Customer Report
                            System.out.println("-------------------------------------------------------------");
                            break;
                        }
                        case 2: // Create Driver
                        {
                            System.out.println(">>>>>>>>>>>>>>>>>>> Register as a driver <<<<<<<<<<<<<<<<<<");
                            System.out.println("Please enter Name:");
                            String name = input.next();
                            System.out.println("Please enter Phone Number:");
                            String phone = input.next();
                            System.out.println("Please enter email:");
                            String email = input.next();
                            System.out.println("Please enter license#:");
                            String license = input.next();
                            System.out.println("Please enter insurance#:");
                            String insurance = input.next();
                            Driver driver = new Driver(name, phone, email, license, insurance);
                            driversList.add(driver);
                            //Printing Driver Report
                            System.out.println("-------------------------------------------------------------");
                            break;
                        }
                        default: {
                            inValidateRequest();
                            break;
                        }
                    }
                    break; //End case 1
                case 2: // Create Vehicle
                {
                    System.out.println("Enter 1 - personal owned, 2 - company owned");
                    int owner_type = Integer.parseInt(input.next());
                    System.out.println("Vehicle Type: 1 - Compact, 2- Van");
                    int vehicle_type = Integer.parseInt(input.next());
                    System.out.println("Enter vin number");
                    String vin = input.next();
                    System.out.println("What is the Vehicle Make?");
                    String make = input.next();
                    System.out.println("What is the Vehicle Model?");
                    String model = input.next();
                    System.out.println("What year the Vehicle is made?");
                    int year = Integer.parseInt(input.next());
                    VehicleOwnership ownership;
                    if (owner_type == 1) {
                        ownership = new CompanyOwnedVehicle("company");
                    } else {
                        ownership = new PersonalOwnedVehicle("personal");
                    }
                    Random rand = new Random();
                    Vehicle v;
                    if (vehicle_type == 1) { //Compact car
                        v = new CompactVehicle(vin, make, model, year, ownership);
                    } else { //Van car
                        v = new VanVehicle(vin, make, model, year, ownership);
                    }
                    v.setLocation((new Point(rand.nextInt(100), rand.nextInt(100))));
                    vehiclesList.add(v);
                    //Printing Vehicle Report
                    System.out.println("-------------------------------------------------------------");
                }
                case 3: //Loading mock data, need this if you want to generate multiple request
                {
                    System.out.print(">>>>>>>>>>>>>>> Loading mock data <<<<<<<<<<<<<<<<");
                    if (vehiclesList.size() == 0 && driversList.size() == 0) {
                        System.out.println("No Vehicles & Drive. Auto-generate data? (Y/N)");
                        String genAnswer = input.next();
                        if (genAnswer.equalsIgnoreCase("y")) {
                            System.out.println("How many vehicle you want?");
                            int num = input.nextInt();
                            DataTest.getTest().loadMockData(num);
                        } else {
                            System.out.println("... Return to main menu");
                        }
                        break;
                    } else {
                        int size = 0;
                        if (vehiclesList.size() < driversList.size()) {
                            size = vehiclesList.size();
                        } else {
                            size = driversList.size();
                        }
                        for (int i = 0; i < size; i++) {
                            VehicleAndDriver vd = new VehicleAndDriver();
                            vd.setDriver(driversList.get(i));
                            vd.setVehicle(vehiclesList.get(i));
                            DataTest.getTest().addVehicleAndDriver(vd);
                            if (vd.getVehicle().getOwnership().getOwnerName().equalsIgnoreCase("company")) {
                                DataTest.getTest().addVehicle(vd.getVehicle());
                                DataTest.getTest().printAddCompanyOwnedInventory(vd);
                            } else {
                                DataTest.getTest().printAddPersonalOwnedInventory(vd);
                            }
                        }
                    }
                    break;
                }
                case 4: //Add request for a ride
                {
                    if (customersList.size() == 0 || driversList.size() == 0) {
                        System.out.println("The system do not have any existing customer or driver. Create customer and driver first!");
                        break;
                    }
                    String[] userList = new String[customersList.size()];
                    for (int i = 0; i < customersList.size(); i++) {
                        userList[i] = customersList.get(i).get_name();
                    }
                    int memberIndex = getOption("Which Customer will make this request?", userList);
                    System.out.println("Start point - X coordinate:");
                    int fromX = input.nextInt();
                    System.out.println("Start point - Y coordinate:");
                    int fromY = input.nextInt();
                    System.out.println("Destination point - X coordinate:");
                    int toX = input.nextInt();
                    System.out.println("Destination point - Y coordinate:");
                    int toY = input.nextInt();
                    Request request = new Request(customersList.get(memberIndex - 1), new Point(fromX, fromY), new Point(toX, toY));
                    requestsList.add(request);
                    //Printing Request Report
                    System.out.println("-------------------------------------------------------------");
                    break; //End case 3
                }
                case 5: //Process request queue
                {
                    System.out.println(">>>>> Processing request into schedule list <<<<<<");
                    for (Request r : requestsList) {
                        if (r.getSchedule() != null) { //Adding request to schedule
                            schedulesList.add(r.getSchedule());
                        }
                    }
                    ScheduleQueue.getQueue().processSchedule();
                    //Print schedule list
                    for (Schedule schedule : schedulesList) {
                        Report report = new ScheduleReport(schedule);
                        report.printReport();
                    }
                    break; //End case 4
                }
                case 6: //Start a ride
                {
                    for (VehicleAndDriver vd : DataTest.getTest().getActiveVehicleList()) {
                        vd.getDriver().startSchedule();
                    }
                    break;
                }
                case 7: //Finish a ride
                {
                    for (VehicleAndDriver vd : DataTest.getTest().getActiveVehicleList()) {
                        vd.getDriver().compeleteSchedule();
                    }
                    break;
                }
                case 8: //Cancel a ride
                {
                    for (VehicleAndDriver vd : DataTest.getTest().getActiveVehicleList()) {
                        vd.getDriver().cancelSchedule();
                    }
                    break;
                }
                case 9: //Add Feedback
                {
                    break;
                }
                case 10: //Delete user
                {
                    if (customersList != null && customersList.size() > 0){
                        System.out.println("Enter name of user to delete");
                        String name = input.next();
                        boolean deleted = false;
                        for (int i=0; i <customersList.size(); i++){
                            if (customersList.get(i).get_name().equalsIgnoreCase(name)){
                                System.out.println("Customer with name=" + name + " is deleted.");
                                customersList.remove(i);
                                deleted = true;
                                break;
                            }
                        }
                        if (!deleted){
                            System.out.println("Customer with name=" + name + " is not found.");
                        }
                    } else {
                        System.out.println("Systems have no customer to delete!");
                    }
                    break; //End case 9
                }
                default: {
                    inValidateRequest();
                    break;
                }
            }
            printOverallReport(customersList, driversList, vehiclesList, schedulesList);
        }
    }

    /**
     * Helper function to print overall report
     * This is to keep track of the overall request and how we generate user
     */
    private static void printOverallReport(ArrayList<Customer> customersList, ArrayList<Driver> driversList, ArrayList<Vehicle> vehiclesList, ArrayList<Schedule> schedulesList) {
        Report rep;
        for (Customer customer : customersList) {
            rep = new CustomerReport(customer);
            rep.printReport();
        }
        for (Driver driver : driversList) {
            rep = new DriverReport(driver);
            rep.printReport();
        }
        for (Vehicle vehicle : vehiclesList) {
            rep = new VehicleReport(vehicle);
            rep.printReport();
        }
        for (Schedule schedule : schedulesList) {
            rep = new ScheduleReport(schedule);
            rep.printReport();
        }
    }

    //Helper function for membership payment registration
    private static CreditCardPayment payMembership(String name) {
        System.out.println("------- Loyalty Program: Register payment method ----------");
        CreditCardPayment creditPayment = new CreditCardPayment(name);
        creditPayment.setupPayment();
        return creditPayment;
    }

    private static int getOption(String text, String[] options) {
        System.out.println("\n" + text);
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + 1 + ") " + options[i]);
        }
        System.out.println();
        Scanner input = new Scanner(System.in);
        int choice = Integer.parseInt(input.next());
        return choice;
    }

    private static void inValidateRequest() {
        System.out.println("Not a valid choice, please choose again");
        System.out.println("---------------------------------------------------");
    }
}
