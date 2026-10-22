package gamecollecting.model;

public class Console {
    private final int id;
    private final String model;
    private final String region;
    private final String console_condition;
    private final boolean boxed;

    public Console(int id, String model, String region, String console_condition, boolean boxed) {

    this.id = id;
    this.model = model;
    this.region = region;
    this.console_condition = console_condition;
    this.boxed = boxed;
    }

    
public Console(String model, String region, String console_condition, boolean boxed) {
    this(0, model, region, console_condition, boxed);
}

    public int getID() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getRegion() {
        return region;
    }
    
    public String getConsole_Condition() {
        return console_condition;
    }

    public boolean isBoxed() {
        return boxed;
    }
}