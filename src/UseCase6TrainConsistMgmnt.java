import java.util.HashMap;
import java.util.Map;

/**
 * MAIN CLASS - UseCase6TrainConsistMgmnt
 *
 * Use Case 6: Map Bogie to Capacity (HashMap)
 *
 * Description:
 * This class associates each bogie with its seating or load capacity
 * using a key-value mapping structure.
 *
 * @author Developer
 * @version 6.0
 */

public class UseCase6TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("======");
        System.out.println("UC6 Map Bogie to Capacity (HashMap)");
        System.out.println("======");
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        System.out.println("\nBogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}