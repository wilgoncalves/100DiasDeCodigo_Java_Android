package model;

import java.util.Date;

public class SaleModel {

    public int idVenda;
    public Date date;
    public String seller;
    public String product;
    public String category;
    public double price;

    public String getSeller() {
        return seller;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public SaleModel(int idVenda, Date date, String seller, String product,
                     String category, double price) {
        this.idVenda = idVenda;
        this.date = date;
        this.seller = seller;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
