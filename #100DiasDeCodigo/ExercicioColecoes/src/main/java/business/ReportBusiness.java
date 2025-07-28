package business;

import java.util.Map;

public class ReportBusiness {

    public static void print(Map<String, Double> map) {
        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}
