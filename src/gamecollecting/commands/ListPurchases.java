package gamecollecting.commands;

import gamecollecting.data.CollectionsData;
import gamecollecting.model.Purchase;
import java.util.List;

public class ListPurchases implements Command {

    @Override
    public void execute() throws Exception {
        List<Purchase> purchases = CollectionsData.ListPurchases();

        for (Purchase p : purchases) {
            System.out.println(p.getID() + ": " + p.getItemType() + " (" + p.getItemID() + ")" + " (" + p.getPrice() + ")" + " (" + p.getPurchasedFrom() + ")" + " (" + p.getPurchaseDate() + ")");
        }

        System.out.println(purchases.size() + " purchase(s)");
    }
}
