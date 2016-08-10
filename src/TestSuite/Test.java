package TestSuite;

/**
 * Created by kdao on 8/9/16.
 */
import java.util.Scanner;

class Test {
    public static void main(String[] args) {
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
