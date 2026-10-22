package gamecollecting.commands;

import gamecollecting.data.CollectionsData;
import gamecollecting.model.Console;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddConsole implements Command {

    @Override
    public void execute() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Model: ");
        String model = br.readLine();

        System.out.print("Region: ");
        String region = br.readLine();

        System.out.print("Condition: ");
        String condition = br.readLine();

        System.out.print("Boxed? (y/n): ");
        String boxedInput = br.readLine();
        boolean boxed = boxedInput != null && boxedInput.trim().toLowerCase().startsWith("y");

        if (model == null || model.trim().isEmpty()) {
            throw new Exception("Model cannot be empty.");
        }

        Console console = new Console(
                model.trim(),
                region == null ? "" : region.trim(),
                condition == null ? "" : condition.trim(),
                boxed
        );

        CollectionsData.addConsole(console);
        System.out.println("Console added: " + console.getModel());
    }
}