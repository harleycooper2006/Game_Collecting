package gamecollecting.commands;

import gamecollecting.data.CollectionsData;
import gamecollecting.model.Game;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddGame implements Command {

    @Override
    public void execute() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Title: ");
        String title = br.readLine();

        System.out.print("Platform: ");
        String platform = br.readLine();

        System.out.print("Region: ");
        String region = br.readLine();

        System.out.print("Condition: ");
        String condition = br.readLine();

        System.out.print("Boxed? (y/n): ");
        String boxedInput = br.readLine();
        boolean boxed = boxedInput != null && boxedInput.trim().toLowerCase().startsWith("y");

        if (title == null || title.trim().isEmpty()) {
            throw new Exception("Title cannot be empty.");
        }
        if (platform == null || platform.trim().isEmpty()) {
            throw new Exception("Platform cannot be empty.");
        }

        Game game = new Game(
                title.trim(),
                platform.trim(),
                region == null ? "" : region.trim(),
                condition == null ? "" : condition.trim(),
                boxed
        );

        CollectionsData.addGame(game);
        System.out.println("Game added: " + game.getTitle() + " (" + game.getPlatform() + ")");
    }
}