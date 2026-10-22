package gamecollecting.main;

import java.io.BufferedReader;

import gamecollecting.commands.*;

public class CommandParser {

    public static Command parse(String line) throws Exception {
        String[] parts = line.trim().split("\\s+");
        String cmd = parts[0].toLowerCase();

        switch (cmd) {
            case "addgame":
                return new AddGame();

            case "addconsole":
                return new AddConsole();

            case "addpurchase":
                return new AddPurchase();

            case "listgames":
                return new ListGames();

            case "listconsoles":
                return new ListConsoles();

            case "listpurchases":
                return new ListPurchases();

            case "showgame":
                if (parts.length < 2) {
                    throw new Exception("Usage: showgame <id>");
                }
                int gameId = Integer.parseInt(parts[1]);
                return new ShowGame(gameId);

            case "showconsole":
                if (parts.length < 2) {
                    throw new Exception("Usage: showconsole <id>");
                }
                int consoleId = Integer.parseInt(parts[1]);
                return new ShowConsole(consoleId);

            case "deletegame":
                if (parts.length < 2) {
                    throw new Exception("Usage: deletegame <id>");
                }
                int deleteGameId = Integer.parseInt(parts[1]);
                return new DeleteGame(deleteGameId);

            case "help":
                return () -> {
                    System.out.println("Commands:");
                    System.out.println("  addgame");
                    System.out.println("  addconsole");
                    System.out.println("  addpurchase");
                    System.out.println("  listgames");
                    System.out.println("  listconsoles");
                    System.out.println("  listpurchases");
                    System.out.println("  showgame <id>");
                    System.out.println("  showconsole <id>");
                    System.out.println("  deletegame <id>");
                    System.out.println("  help");
                    System.out.println("  exit");
                };

            default:
                throw new Exception("Unknown command: " + cmd);
        }
    }
}