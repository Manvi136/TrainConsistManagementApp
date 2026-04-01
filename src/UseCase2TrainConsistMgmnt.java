import java.util.ArrayList;
import java.util.List;

/**
 * MAIN CLASS - UseCase2TrainConsistMgmnt
 *
 * Use Case 2: Add Passenger Bogies to Train
 *
 * Description:
 * This class demonstrates how passenger bogies can be managed dynamically
 * using ArrayList operations.
 *
 * @author Developer
 * @version 2.0
 */

public class UseCase2TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("======");
        System.out.println("UC2 Add Passenger Bogies to Train");
        System.out.println("======");
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        System.out.println("\nAfter Adding Bogies:");
        System.out.println("Passenger Bogies: " + passengerBogies);
        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter Removing 'AC Chair':");
        System.out.println("Passenger Bogies: " + passengerBogies);
        System.out.println("\nChecking if 'Sleeper' exists:");
        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("Contains Sleeper?: " + exists);
        System.out.println("\nFinal Train Passenger Consist: " + passengerBogies);
        System.out.println("\nUC2 operations completed successfully...");
    }
}