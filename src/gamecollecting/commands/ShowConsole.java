package gamecollecting.commands;

import gamecollecting.data.CollectionsData;
import gamecollecting.model.Console;
import gamecollecting.model.Purchase;
import java.util.List;

public class ShowConsole implements Command {

    private final int id;

    public ShowConsole(int id) {
        this.id = id;
    }

    @Override
    public void execute() throws Exception {
        Console console = CollectionsData.getConsoleById(id);

        if (console == null) {
            System.out.println("Console not found.");
            return;
        }

        System.out.println("Console Details");
        System.out.println("ID: " + console.getID());
        System.out.println("Model: " + console.getModel());
        System.out.println("Region: " + console.getRegion());
        System.out.println("Condition: " + console.getConsole_Condition());
        System.out.println("Boxed: " + (console.isBoxed() ? "Yes" : "No"));

        List<Purchase> purchases = CollectionsData.getPurchasesForConsole(id);

        System.out.println("Purchase Info:");
        if (purchases.isEmpty()) {
            System.out.println("No purchase record found.");
        } else {
            for (Purchase p : purchases) {
                System.out.println("Purchase ID: " + p.getID());
                System.out.println("Price: " + p.getPrice());
                System.out.println("Purchased from: " + p.getPurchasedFrom());
                System.out.println("Purchase date: " + p.getPurchaseDate());
                System.out.println("--------------------");
            }
        }
    }
}