package gamecollecting.commands;

import gamecollecting.data.CollectionsData;

public class DeleteGame implements Command {

    private final int gameId;

    public DeleteGame(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public void execute() throws Exception {
        CollectionsData.deleteGame(gameId);
        System.out.println("Game deleted successfully.");
    }
}