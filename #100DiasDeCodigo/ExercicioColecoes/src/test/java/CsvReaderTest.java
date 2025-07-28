import model.SaleModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.CsvReader;

import java.util.List;

public class CsvReaderTest {

    private static final String FILE_PATH = "./src/test/resources/test-data.csv";
    private static final String FILE_PATH_WRONG = "./src/test/resources/test-data-wrong.csv";

    @Test
    @DisplayName("Leitura de quantidade de informações do arquivo .csv.")
    void testReadSales() {
        List<SaleModel> list = CsvReader.readSales(FILE_PATH);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Leitura de informações no formato incorreto. ")
    void testReadSalesIncorrectFormat() {
        List<SaleModel> list = CsvReader.readSales(FILE_PATH_WRONG);
        Assertions.assertEquals(0, list.size());
    }
}
