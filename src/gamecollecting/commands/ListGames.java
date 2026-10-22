package gamecollecting.commands;

import gamecollecting.data.CollectionsData;
import gamecollecting.model.Game;

import java.util.List;

public class ListGames implements Command {

    @Override
    public void execute() throws Exception {
        List<Game> games = CollectionsData.listGames();

        for (Game g : games) {
            System.out.println(g.getID() + ": " + g.getTitle() + " (" + g.getPlatform() + ")");
        }

        System.out.println(games.size() + " game(s)");
    }
}
