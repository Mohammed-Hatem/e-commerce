import java.util.*;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        if (items.isEmpty()) return;

        Map<String, Integer> counts = new TreeMap<>();
        Map<String, Double> weights = new HashMap<>();
        double totalWeight = 0.0;

        for (Shippable item : items) {
            String name = item.getName();
            counts.put(name, counts.getOrDefault(name, 0) + 1);
            weights.put(name, item.getWeight());
            totalWeight += item.getWeight();
        }

        System.out.println("** Shipment notice **");
        for (String name : counts.keySet()) {
            int count = counts.get(name);
            double weight = weights.get(name);
            System.out.printf("%dx %s %.0fg\n", count, name, weight);
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}