import java.util.*;

public class ShippingService {
    public static void ship(ArrayList<Shippable> items) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        Map<String, Double> weights = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            String name = item.getClass().getSimpleName();
            counts.put(name, counts.getOrDefault(name, 0) + 1);
            weights.put(name, item.getWeight());
            totalWeight += item.getWeight();
        }

        System.out.println("** Shipment notice **");
        for (String name : counts.keySet()) {
            int qty = counts.get(name);
            double weightKg = weights.get(name);
            System.out.printf("%dx %s %.0fg\n", qty, name, qty*weightKg * 1000);
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
