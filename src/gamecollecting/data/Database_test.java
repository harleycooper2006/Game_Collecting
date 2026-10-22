package gamecollecting.data;

import java.sql.Connection;

public class Database_test {
    public static void main(String[] args) {
        try (Connection conn = Database.getConnection()) {
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
    }
}