package gamecollecting.commands;

import gamecollecting.data.CollectionsData;
import gamecollecting.model.Purchase;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;


public class AddPurchase implements Command {

    @Override
    public void execute() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Item Type: ");
        String item_type = br.readLine();

        System.out.print("Item ID: ");
        int item_id = Integer.parseInt(br.readLine().trim());

        System.out.print("Price: ");
        String priceInput = br.readLine();
        double price = Double.parseDouble(priceInput.trim());

        System.out.print("Purchased from: ");
        String purchased_from = br.readLine();

        System.out.print("Purchase date (yyyy-mm-dd): ");
        String dateInput = br.readLine();
        Date purchase_date = java.sql.Date.valueOf(dateInput.trim());
        

    
        Purchase purchase = new Purchase(
            0,
            item_type.trim(),
            item_id,
            price,
            purchased_from.trim(),
            purchase_date
        );

        CollectionsData.addPurchase(purchase);
        System.out.println("Purchase added: " + purchase.getItemType());
    }
}