import business.ReportBusiness;
import business.SaleBusiness;
import model.SaleModel;
import utils.CsvReader;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String FILE_PATH = "./src/main/resources/data.csv";

    public static void main(String[] args) {

        // Fazendo o uso do arquivo "data.csv" presente na pasta resources:
        // Exercicio: Imprima o total de vendas por vendedor
        // Exercicio: Imprima o total de vendas por categoria

        List<SaleModel> sales = CsvReader.readSales(FILE_PATH);

        Map<String, Double> mapSeller = SaleBusiness.getTotalSalePerSeller(sales);
        Map<String, Double> mapCategory = SaleBusiness.getTotalSalePerCategory(sales);

        System.out.println("Total de vendas por vendedor: ");
        ReportBusiness.print(mapSeller);

        System.out.println("\nTotal de vendas por categoria: ");
        ReportBusiness.print(mapCategory);
    }
}
