package utils;

import model.SaleModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvReader {

    public static List<SaleModel> readSales(String path) {
        List<SaleModel> sales = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {

            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();

            String line = br.readLine();
            do {
                String[] data = line.split(";");
                int id = Integer.parseInt(data[0]);
                Date date = formatter.parse(data[1]);
                String seller = data[2];
                String product = data[3];
                String category = data[4];
                double price = Double.parseDouble(data[5]);

                sales.add(new SaleModel(id, date, seller, product, category, price));
                line = br.readLine();
            } while (line != null);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (ParseException e) {
            System.out.println("Erro ao converter data!");
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter valor!");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo!");
        }

        return sales;
    }
}
