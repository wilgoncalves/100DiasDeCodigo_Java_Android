package business;

import model.SaleModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleBusiness {

    public static Map<String, Double> getTotalSalePerSeller(List<SaleModel> list) {
        Map<String, Double> totalBySeller = new HashMap<>();

        for (SaleModel sale : list) {
            String seller = sale.getSeller();
            Double price = sale.getPrice();

            if (totalBySeller.containsKey(seller)) {
                totalBySeller.put(seller, price + totalBySeller.get(seller));
            } else {
                totalBySeller.put(seller, price);
            }
        }
        return totalBySeller;
    }

    public static Map<String, Double> getTotalSalePerCategory(List<SaleModel> list) {
        Map<String, Double> totalBySeller = new HashMap<>();

        for (SaleModel sale : list) {
            String category = sale.getCategory();
            Double price = sale.getPrice();

            if (totalBySeller.containsKey(category)) {
                totalBySeller.put(category, price + totalBySeller.get(category));
            } else {
                totalBySeller.put(category, price);
            }
        }
        return totalBySeller;
    }
}
