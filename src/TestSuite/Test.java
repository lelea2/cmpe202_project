package TestSuite;

/**
 * Created by kdao on 8/9/16.
 */
import Schedule.*;
import Vehicle.*;
import Membership.*;
import Request.*;
import Report.*;

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
        //End definition for data store registration
        /************************/
        Scanner input = new Scanner(System.in);

        System.out.println("/***********************************************************************************************/");
        System.out.println("/***************************** CARPOOL & PARKING SERVICE ***************************************/");
        System.out.println("/***********************************************************************************************/");
        System.out.println();
        String[] mainOptions = {"Register member in the system", "Create Vehicle", "Add ride request", "Process request queue",
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
                                customersList.add(member);
                            } else if (loyal_type == 3) {
                                member = new GoldMembershipDecorator(member);
                                customersList.add(member);
                            } else {
                                inValidateRequest();
                                break;
                            }
                            //Printing Customer Report
                            System.out.println(">>>>>>>>>>>>>>>>> Print customer report <<<<<<<<<<<<<<<<<<<<<<");
                            for (Customer c : customersList) {
                                Report report = new CustomerReport(c);
                                report.printReport();
                            }
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
                            System.out.println(">>>>>>>>>>>>>>>>> Print driver report <<<<<<<<<<<<<<<<<<<<<<");
                            for (Driver d : driversList) {
                                Report report = new DriverReport(d);
                                report.printReport();
                            }
                            break;
                        }
                        default: {
                            System.out.println("Not a valid choice, please choose again");
                            System.out.println("---------------------------------------------------");
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
                    System.out.println(">>>>>>>>>>>>>>>>> Print vehicle report <<<<<<<<<<<<<<<<<<<<<<");
                    for (Vehicle vehicle : vehiclesList) {
                        Report report = new VehicleReport(vehicle);
                        report.printReport();
                    }
                    break; //End case 2
                }
                case 3: //Add request for a ride
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
                    System.out.println(">>>>>>>>>>>>>>>>> Print request report <<<<<<<<<<<<<<<<<<<<<<");
                    for (Request req : requestsList) {
                        Report report = new RequestReport(req);
                        report.printReport();
                    }
                    break; //End case 3
                }
                case 4: //Process request queue
                {
                    System.out.println(">>>>> Processing request into schedule list <<<<<<");
                    for (Request r : requestsList) {
                        if (r.getSchedule() != null) { //Adding request to schedule
                            schedulesList.add(r.getSchedule());
                        }
                    }
                    break; //End case 4
                }
                case 5: //Start a ride
                {
                    break;
                }
                case 6: //Finish a ride
                {
                    break;
                }
                case 7: //Cancel a ride
                {
                    break;
                }
                case 8: //Add Feedback
                {
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
                    break; //End case 9
                }
                default: {
                    inValidateRequest();
                    break;
                }
            }
        }
    }

    //Helper function for membership payment registration
    private static void payMembership() {
        System.out.println("------- Loyalty Program: Register payment method ----------");

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
