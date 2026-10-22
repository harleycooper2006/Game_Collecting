package gamecollecting.main;

import gamecollecting.data.CollectionsData;
import gamecollecting.model.Console;
import java.util.List;

public class TestConsoles {

    public static void main(String[] args) throws Exception {

        Console console = new Console(
                "Nintendo Switch 2",
                "Europe",
                "Excellent",
                false
        );

        CollectionsData.addConsole(console);
        System.out.println("Added console");

        List<Console> consoles = CollectionsData.ListConsoles();
        for (Console c : consoles) {
            System.out.println(c.getModel() + " (" + c.getConsole_Condition() + ")");
        }

        System.out.println(consoles.size() + " console(s)");
    }
}
