package TestSuite;

/**
 * Created by kdao on 8/9/16.
 */
import Schedule.*;
import Vehicle.*;
import Membership.*;
import Request.*;

import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        /**************************/
        //Define temp data store for registration
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Driver> drivers = new ArrayList<>();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Request> requests = new ArrayList<>();
        ArrayList<Schedule> schedules = new ArrayList<>();
        //End definition for data store registration
        /************************/
        Scanner input = new Scanner(System.in);

        System.out.println("/***********************************************************************************************/");
        System.out.println("/***************************** CARPOOL & PARKING SERVICE ***************************************/");
        System.out.println("/***********************************************************************************************/");
        System.out.println();
        String[] mainOptions = {"Register member in the system", "Create Vehicle", "Add ride request", "Process request queue",
                "Start a ride", "Finish a ride", "Add feedback", "Delete User"};
        while(true) {
            int choice = getOption("==== Please pick one of the following option for testing ====", mainOptions);
            switch(choice) {
                case 1: //Register member in the system
                    String[] memberOptions = {"Create Customer", "Create Driver"};
                    int userChoice = getOption("User Menu", memberOptions);
                    switch (userChoice) {
                        case 1: // Create Customer
                        {
                            System.out.println("Please type the Customer Name");
                            String name = input.next();
                            System.out.println("Please type the Customer Phone Number");
                            String number = input.next();

                            break;
                        }
                        case 2: // Create Driver
                        {
                            System.out.println("Please type the Driver Name");
                            String name = input.next();
                            System.out.println("Please type the Driver Phone Number");
                            String number = input.next();
                            System.out.println("Please type the Driver License Number");
                            String license = input.next();
                            System.out.println("Please type the Driver Insurance Number");
                            String insurance = input.next();

                            break;
                        }
                        default: {
                            System.out.println("Not a valid choice, please choose again");
                            System.out.println("---------------------------------------------------");
                            break;
                        }
                    }
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
                    vehicles.add(v);
                    break;
                }
                case 3: //Add request for a ride
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default: {
                    System.out.println("Not a valid choice, please choose again");
                    System.out.println("---------------------------------------------------");
                    break;
                }
            }
        }
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
}
