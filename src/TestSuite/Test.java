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
import Feedback.*;

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
        ArrayList<Feedback> feedbackArrayList = new ArrayList<>();
        ArrayList<VehicleAndDriver> vehicleAndDriverArrayList = new ArrayList<>();
        //End definition for data store registration
        /************************/
        Scanner input = new Scanner(System.in);
        DataTest dataTest = new DataTest();

        //By default, generate some default customer and driver & vehicle
        Customer member1 = new BasicMembership("User1", "1234567", "user1@test.com");
        Customer member2 = new BasicMembership("User2", "123765", "user2@test.com");
        Driver driver1 = new Driver("Driver1", "7654321", "driver1@test.com", "license#", "insurance#");
        Vehicle vehicle1 = new VanVehicle("12345", "Toyota", "Corolla", 2000, new CompanyOwnedVehicle("UberLyftCorp"));
        customersList.add(member1);
        customersList.add(member2);
        vehiclesList.add(vehicle1);
        driversList.add(driver1);
        vehicleAndDriverArrayList.add(new VehicleAndDriver(driver1, vehicle1)); //vehicleanddriver array list
        //End adding mock data

        System.out.println("/***********************************************************************************************/");
        System.out.println("/***************************** CARPOOL & PARKING SERVICE ***************************************/");
        System.out.println("/***********************************************************************************************/");
        String[] mainOptions = {"Register member in the system", "Create Vehicle", "Add ride request", "Process request queue(Loading complete request to schedule)",
                "Start a ride", "Finish a ride", "Cancel a ride", "Add feedback", "Delete User", "Loading data"};
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
                            printOverallReport(customersList, driversList, vehiclesList, requestsList, schedulesList, feedbackArrayList);
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
                            printOverallReport(customersList, driversList, vehiclesList, requestsList, schedulesList, feedbackArrayList);
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
                    if (owner_type == 2) {
                        if (driversList.size() == 0) {
                            System.out.println("No driver to assign vehicle. Back to main menu");
                            break;
                        }
                        String[] dList = new String[driversList.size()];
                        for (int i = 0; i < driversList.size(); i++) {
                            dList[i] = driversList.get(i).get_name();
                        }
                        int dIndex = getOption("Which Driver will make this request?", dList);
                        ownership = new PersonalOwnedVehicle(driversList.get(dIndex).get_name());
                    } else {
                        ownership = new CompanyOwnedVehicle("UberLyftCorp");
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
                    printOverallReport(customersList, driversList, vehiclesList, requestsList, schedulesList, feedbackArrayList);
                    break; //end case2
                }
                case 3: //Add request for a ride
                {
                    if (customersList.size() == 0 || driversList.size() == 0) {
                        System.out.println("The system do not have any existing customer or driver. Create customer and driver first by option #3!");
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
                    //Process to validating request here
                    request.processRequest();
//                    System.out.println(request.getState());
                    requestsList.add(request);
                    //Printing Request Report
                    System.out.println("-------------------------------------------------------------");
                    printOverallReport(customersList, driversList, vehiclesList, requestsList, schedulesList, feedbackArrayList);
                    break; //End case 3
                }
                case 4: //Process request queue
                {
                    System.out.println(">>>>> Processing request into schedule list <<<<<<");
                    if (requestsList.size() == 0) {
                        System.out.println("No request available. Please generate one in #3");
                        break;
                    }
                    for (Request request : requestsList) {
                        System.out.println(request.getSchedule());
                        if (request.getSchedule() != null) { //Adding request to schedule
                            System.out.println("Adding schedule to schedule list after approval");
                            schedulesList.add(request.getSchedule());
                        }
                    }
                    ScheduleQueue.getQueue().processSchedule();
                    System.out.println("-------------------------------------------------------------");
                    printOverallReport(customersList, driversList, vehiclesList, requestsList, schedulesList, feedbackArrayList);
                    break; //End case 4
                }
                case 5: //Start a ride
                {
                    if (dataTest.getTest().getActiveVehicleList().size() == 0) {
                        System.out.println("No active vehicle available. Cannot start. Please try to load data to generate more vehicle");
                        break;
                    }
                    System.out.println("Available vehicle #: " + dataTest.getTest().getActiveVehicleList().size());
                    for (VehicleAndDriver vd : dataTest.getTest().getActiveVehicleList()) {
                        vd.getDriver().startSchedule();
                    }
                    printOverallReport(customersList, driversList, vehiclesList, requestsList, schedulesList, feedbackArrayList);
                    break;
                }
                case 6: //Finish a ride
                {
                    for (VehicleAndDriver vd : dataTest.getTest().getActiveVehicleList()) {
                        vd.getDriver().compeleteSchedule();
                    }
                    System.out.println("-------------------------------------------------------------");
                    printOverallReport(customersList, driversList, vehiclesList, requestsList, schedulesList, feedbackArrayList);
                    break;
                }
                case 7: //Cancel a ride
                {
                    for (VehicleAndDriver vd : dataTest.getTest().getActiveVehicleList()) {
                        vd.getDriver().cancelSchedule();
                    }
                    System.out.println("-------------------------------------------------------------");
                    printOverallReport(customersList, driversList, vehiclesList, requestsList, schedulesList, feedbackArrayList);
                    break;
                }
                case 8: //Add Feedback
                {
                    System.out.println("Feedback type: 1 - For Driver, 2 - For Pricing, 3 - For overall service");
                    int type = Integer.parseInt(input.next());
                    System.out.println("Feedback title:");
                    String title = input.next();
                    System.out.println("Feedback content:");
                    String content = input.next();
                    System.out.println("Rating:");
                    int rating = Integer.parseInt(input.next());
                    if (type == 1) { //
                        DriverFeedback fb = new DriverFeedback(title, content, rating);
                        feedbackArrayList.add(fb);
                    } else if (type == 2) {
                        PricingFeedback fb = new PricingFeedback(title, content, rating);
                        feedbackArrayList.add(fb);
                    } else if (type == 3) {
                        ServiceFeedback fb = new ServiceFeedback(title, content, rating);
                        feedbackArrayList.add(fb);
                    } else {
                        inValidateRequest();
                        break;
                    }
                    System.out.println("-------------------------------------------------------------");
                    printOverallReport(customersList, driversList, vehiclesList, requestsList, schedulesList, feedbackArrayList);
                    break;
                }
                case 9: //Delete user
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
                    System.out.println("-------------------------------------------------------------");
                    printOverallReport(customersList, driversList, vehiclesList, requestsList, schedulesList, feedbackArrayList);
                    break; //End case 9
                }
                case 10: //Loading mock data, need this if you want to generate multiple request
                {
                    System.out.print(">>>>>>>>>>>>>>> Loading mock data <<<<<<<<<<<<<<<<");
                    if (vehiclesList.size() == 0 && driversList.size() == 0) {
                        System.out.println("No Vehicles & Drivers. Auto-generate data? (Y/N)");
                        String genAnswer = input.next();
                        if (genAnswer.equalsIgnoreCase("y")) {
                            System.out.println("How many vehicle you want?");
                            int num = input.nextInt();
                            dataTest.getTest().loadMockData(num);
                            vehicleAndDriverArrayList = (ArrayList<VehicleAndDriver>)dataTest.getActiveVehicleList();
                        } else {
                            System.out.println("... Return to main menu");
                        }
                        break;
                    } else {
                        int size = 0;
                        if (vehiclesList.size() < driversList.size()) { //mock data, set vehicle for existing driver
                            size = vehiclesList.size();
                        } else { //mock data, set vehicle owned by company (no specific driver);
                            size = driversList.size();
                        }
                        for (int i = 0; i < size; i++) {
                            VehicleAndDriver vd = new VehicleAndDriver();
                            vd.setDriver(driversList.get(i));
                            vd.setVehicle(vehiclesList.get(i));
                            dataTest.getTest().addVehicleAndDriver(vd);
                            vehicleAndDriverArrayList = (ArrayList<VehicleAndDriver>)dataTest.getActiveVehicleList();
                            if (vd.getVehicle().getOwnership().getOwnerName().equalsIgnoreCase("company")) {
                                //add vehicle for company
                                dataTest.getTest().addVehicle(vd.getVehicle());
                            }
                        }
                    }
                    break; //end case 10
                }
                default: {
                    inValidateRequest();
                    break;
                }
            }
        }
    }

    /**
     * Helper function to print overall report
     * This is to keep track of the overall request and how we generate user
     */
    private static void printOverallReport(ArrayList<Customer> customersList, ArrayList<Driver> driversList, ArrayList<Vehicle> vehiclesList, ArrayList<Request> requestArrayList, ArrayList<Schedule> schedulesList, ArrayList<Feedback> feedbackList) {
        Report report;
        if (customersList.size() > 0) {
            System.out.println("***************************************************************\n");
            for (Customer customer : customersList) {
                report = new CustomerReport(customer);
                report.printReport();
            }
            System.out.println("***************************************************************\n");
            System.out.println();
        }
        if (driversList.size() > 0) {
            System.out.println("***************************************************************\n");
            for (Driver driver : driversList) {
                report = new DriverReport(driver);
                report.printReport();
            }
            System.out.println("***************************************************************\n");
            System.out.println();
        }
        if (vehiclesList.size() > 0) {
            System.out.println("***************************************************************\n");
            for (Vehicle vehicle : vehiclesList) {
                report = new VehicleReport(vehicle);
                report.printReport();
            }
            System.out.println("***************************************************************\n");
            System.out.println();
        }
        if (requestArrayList.size() > 0) {
            System.out.println("***************************************************************\n");
            for (Request request : requestArrayList) {
                report = new RequestReport(request);
                report.printReport();
            }
            System.out.println("***************************************************************\n");
            System.out.println();
        }
        if (schedulesList.size() > 0) {
            System.out.println("***************************************************************\n");
            for (Schedule schedule : schedulesList) {
                report = new ScheduleReport(schedule);
                report.printReport();
            }
            System.out.println("***************************************************************\n");
            System.out.println();
        }
        if (feedbackList.size() > 0) {
            System.out.println("***************************************************************\n");
            for (Feedback fb : feedbackList) {
                report = new FeedbackReport(fb);
                report.printReport();
            }
            System.out.println("***************************************************************\n");
            System.out.println();
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
