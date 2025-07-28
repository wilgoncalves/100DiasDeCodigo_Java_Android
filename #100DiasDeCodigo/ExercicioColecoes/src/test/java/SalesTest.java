import business.SaleBusiness;
import model.SaleModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SalesTest {

    Calendar c = Calendar.getInstance();

    @Test
    @DisplayName("Valor total vendido por vendedor.")
    void testTotalSalesBySeller() {
        List<SaleModel> list = new ArrayList<>();

        list.add(new SaleModel(1, c.getTime(), "X", "Iphone", "Eletronico", 5000));
        list.add(new SaleModel(2, c.getTime(), "X", "Iphone", "Eletronico", 2500));
        list.add(new SaleModel(3, c.getTime(), "Y", "Android", "Eletronico", 4500));
        Map<String, Double> expectedMap = new HashMap<>();
        expectedMap.put("X", 7500D);
        expectedMap.put("Y", 4500D);

        Map<String, Double> map = SaleBusiness.getTotalSalePerSeller(list);

        Assertions.assertEquals(expectedMap, map);
    }

    @Test
    @DisplayName("Valor total vendido por categoria.")
    void testTotalSalesByCategory() {
        List<SaleModel> list = new ArrayList<>();

        list.add(new SaleModel(1, c.getTime(), "X", "Iphone", "Eletronico", 5000));
        list.add(new SaleModel(2, c.getTime(), "X", "Iphone", "Eletronico", 2500));
        list.add(new SaleModel(3, c.getTime(), "Y", "Teclado", "Perifericos", 2100.99));
        Map<String, Double> expectedMap = new HashMap<>();
        expectedMap.put("Eletronico", 7500D);
        expectedMap.put("Perifericos", 2100.99);

        Map<String, Double> map = SaleBusiness.getTotalSalePerCategory(list);

        Assertions.assertEquals(expectedMap, map);
    }
}
