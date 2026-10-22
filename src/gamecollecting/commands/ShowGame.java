package gamecollecting.commands;

import gamecollecting.data.CollectionsData;
import gamecollecting.model.Game;
import gamecollecting.model.Purchase;
import java.util.List;

public class ShowGame implements Command {

    private final int id;

    public ShowGame(int id) {
        this.id = id;
    }

    @Override
    public void execute() throws Exception {
        Game game = CollectionsData.getGameById(id);

        if (game == null) {
            System.out.println("Game not found.");
            return;
        }

        System.out.println("Game Details");
        System.out.println("ID: " + game.getID());
        System.out.println("Title: " + game.getTitle());
        System.out.println("Platform: " + game.getPlatform());
        System.out.println("Region: " + game.getRegion());
        System.out.println("Condition: " + game.getCondition());
        System.out.println("Boxed: " + (game.isBoxed() ? "Yes" : "No"));

        List<Purchase> purchases = CollectionsData.getPurchasesForGame(id);

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