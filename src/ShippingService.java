import java.util.*;

public class ShippingService {
    public static void ship(ArrayList<Shippable> items) {
        if (items.isEmpty()) return;

        // each distinct item is mapped to its number pf occurences and its weight
        HashMap<String, Integer> counts = new HashMap<>();
        HashMap<String,Double> weights = new HashMap<>();

        double TotalWeight = 0;
        String name;

        for (Shippable item : items) {
            name = item.getName();
            counts.put(name, counts.getOrDefault(name, 0) + 1);
            weights.put(name, item.getWeight());
            TotalWeight += item.getWeight();
        }
        //printing out each distinct item
        System.out.println("** Shipment notice **");
        for(String item: counts.keySet()) {
            System.out.printf("%dx %s %.0f\n", counts.get(item), item, weights.get(item));
        }

        System.out.printf("Total package weight %.1fkg\n", TotalWeight);


    }
}