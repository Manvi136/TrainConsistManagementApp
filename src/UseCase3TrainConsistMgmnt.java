import java.util.HashSet;
import java.util.Set;

/**
 * MAIN CLASS - UseCase3TrainConsistMgmnt
 *
 * Use Case 3: Track Unique Bogie IDs
 *
 * Description:
 * This class ensures that duplicate bogie IDs are not
 * added into the train formation using HashSet.
 *
 * @author Developer
 * @version 3.0
 */

public class UseCase3TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("======");
        System.out.println("UC3 Track Unique Bogie IDs");
        System.out.println("======");
        Set<String> bogies = new HashSet<>();
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");
        bogies.add("BG101");
        bogies.add("BG102");
        System.out.println("\nBogie IDs After Insertion:");
        System.out.println(bogies);
        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");
        System.out.println("\nUC3 uniqueness validation completed....");
    }
}