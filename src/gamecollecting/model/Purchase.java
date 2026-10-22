package gamecollecting.model;

import java.sql.Date;

    public class Purchase{
    private final int id;
    private final String item_type;
    private final int item_id;
    private final double price;
    private final String purchased_from;
    private final Date purchase_date;

    public Purchase(int id, String item_type, int item_id, double price, String purchased_from, Date purchase_date) {

    this.id = id;
    this.item_type = item_type;
    this.item_id = item_id;
    this.price = price;
    this.purchased_from = purchased_from;
    this.purchase_date = purchase_date;
    }



public Purchase( int item_id, String item_type, double price, String purchased_from, Date purchase_date) {
    this(0, item_type, item_id, price, purchased_from, purchase_date);
    }

    public int getID() {
        return id;
    }

    public String getItemType() {
        return item_type;
    }

    public int getItemID() {
        return item_id;
    }

    public double getPrice() {
        return price;
    }

    public String getPurchasedFrom() {
        return purchased_from;
    }

    public Date getPurchaseDate() {
        return purchase_date;
    }

}