package gamecollecting.main;

import gamecollecting.commands.Command;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Game collecting Inventory");
        System.out.println("Type 'help' for commands");

        while(true) {
            System.out.println("> ");
            String line = br.readLine();
            if (line==null) break;

            line = line.trim();
            if (line.equalsIgnoreCase("exit")) break;
            if (line.isEmpty()) continue;

            try {
                Command command = CommandParser.parse(line);
                command.execute();
            } catch (Exception ex) { 
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("Goodbye!");
    }
}