package gamecollecting.data;

import gamecollecting.model.Console;
import gamecollecting.model.Game;
import gamecollecting.model.Purchase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CollectionsData {

    
    public static int addGame(Game game) throws SQLException {
        String sql = "INSERT INTO game (title, platform, region, game_condition, boxed) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
             ))
              {

            ps.setString(1, game.getTitle());
            ps.setString(2, game.getPlatform());
            ps.setString(3, game.getRegion());
            ps.setString(4, game.getCondition());
            ps.setBoolean(5, game.isBoxed());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }

        throw new SQLException("Could not retrieve genereated game ID.");
    }

    public static int addConsole(gamecollecting.model.Console c) throws java.sql.SQLException {
    String sql = "INSERT INTO console (model, region, console_condition, boxed) VALUES (?, ?, ?, ?)";

    try (java.sql.Connection conn = Database.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, c.getModel());
        ps.setString(2, c.getRegion());
        ps.setString(3, c.getConsole_Condition());
        ps.setBoolean(4, c.isBoxed());

        ps.executeUpdate();

        try (java.sql.ResultSet keys = ps.getGeneratedKeys()) {
            if (keys.next()) {
                return keys.getInt(1);
            }
        }
    }

    return -1; 
}

public static int addPurchase(gamecollecting.model.Purchase p) throws java.sql.SQLException {
    String sql = "INSERT INTO purchase (item_type, item_id, price, purchased_from, purchase_date) VALUES (?, ?, ?, ?, ?)";

    try (java.sql.Connection conn = Database.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, p.getItemType());
        ps.setInt(2, p.getItemID());
        ps.setDouble(3, p.getPrice());
        ps.setString(4, p.getPurchasedFrom());
        ps.setDate(5, p.getPurchaseDate());

        ps.executeUpdate();

        try (java.sql.ResultSet keys = ps.getGeneratedKeys()) {
            if (keys.next()) {
                return keys.getInt(1);
            }
        }
    }

    return -1;
}

    
    public static List<Game> listGames() throws SQLException {
        String sql = "SELECT id, title, platform, region, game_condition, boxed FROM game ORDER BY id";

        List<Game> games = new ArrayList<>();

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Game game = new Game(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("platform"),
                        rs.getString("region"),
                        rs.getString("game_condition"),
                        rs.getBoolean("boxed")
                );
                games.add(game);
            }
        }

        return games;
    }

    public static List<Purchase> ListPurchases() throws SQLException {
        String sql = "SELECT id, item_type, item_ID, price, purchased_from, purchase_date FROM purchase order by id";

        List<Purchase> purchases = new ArrayList<>();

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Purchase purchase = new Purchase(
                        rs.getInt("id"),
                        rs.getString("item_type"),
                        rs.getInt("item_id"),
                        rs.getDouble("price"),
                        rs.getString("purchased_from"),
                        rs.getDate("purchase_date")
                );
                purchases.add(purchase);
            }
        }

        return purchases;
    }

     public static List<Console> ListConsoles() throws SQLException {
        String sql = "SELECT id, model, region, console_condition, boxed FROM console ORDER BY id";

        List<Console> consoles = new ArrayList<>();

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Console console = new Console(
                        rs.getInt("id"),
                        rs.getString("model"),
                        rs.getString("region"),
                        rs.getString("console_condition"),
                        rs.getBoolean("boxed")
                );
                consoles.add(console);
            }
        }

        return consoles;
    }

   
    public static List<Purchase> getPurchasesForGame(int gameId) throws SQLException {
    List<Purchase> purchases = new ArrayList<>();

    String sql = "SELECT * FROM purchase WHERE item_type = ? AND item_id = ?";

    try (Connection conn = Database.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, "game");
        ps.setInt(2, gameId);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Purchase purchase = new Purchase(
                        rs.getInt("id"),
                        rs.getString("item_type"),
                        rs.getInt("item_id"),
                        rs.getDouble("price"),
                        rs.getString("purchased_from"),
                        rs.getDate("purchase_date")
                );
                purchases.add(purchase);
            }
        }
    }

    return purchases;
    }

    public static List<Purchase> getPurchasesForConsole(int consoleId) throws SQLException {
    List<Purchase> purchases = new ArrayList<>();

    String sql = "SELECT * FROM purchase WHERE item_type = ? AND item_id = ?";

    try (Connection conn = Database.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, "console");
        ps.setInt(2, consoleId);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Purchase purchase = new Purchase(
                        rs.getInt("id"),
                        rs.getString("item_type"),
                        rs.getInt("item_id"),
                        rs.getDouble("price"),
                        rs.getString("purchased_from"),
                        rs.getDate("purchase_date")
                );
                purchases.add(purchase);
            }
        }
    }

    return purchases;
}


public static Game getGameById(int id) throws SQLException {
    String sql = "SELECT id, title, platform, region, game_condition, boxed FROM game WHERE id = ?";

    try (Connection conn = Database.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, id);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return new Game(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("platform"),
                    rs.getString("region"),
                    rs.getString("game_condition"),
                    rs.getBoolean("boxed")
                );
            }
        }
    }

    return null;
}

public static Console getConsoleById(int id) throws SQLException {
    String sql = "SELECT id, model, region, console_condition, boxed FROM console WHERE id = ?";

    try (Connection conn = Database.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, id);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return new Console(
                    rs.getInt("id"),
                    rs.getString("model"),
                    rs.getString("region"),
                    rs.getString("console_condition"),
                    rs.getBoolean("boxed")
                );
            }
        }
    }

    return null;
}

public static void deleteGame(int gameId) throws SQLException {
    String sql = "DELETE FROM game WHERE game_id = ?";

    try (Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, gameId);

                int rowsDeleted = ps.executeUpdate();

                if (rowsDeleted == 0) {
                    throw new SQLException("No game found with ID: " + gameId);
                }
            }
}


}
