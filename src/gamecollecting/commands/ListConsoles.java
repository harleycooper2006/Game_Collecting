package gamecollecting.commands;

import gamecollecting.data.CollectionsData;
import gamecollecting.model.Console;
import java.util.List;

public class ListConsoles implements Command {

     @Override
    public void execute() throws Exception {
        List<Console> consoles = CollectionsData.ListConsoles();

        for (Console c : consoles) {
            System.out.println(c.getID() + ": " + c.getModel());
        }

        System.out.println(consoles.size() + " consoles(s)");
    }
}