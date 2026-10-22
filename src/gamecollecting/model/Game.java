package gamecollecting.model;

public class Game {
    private final int id;
    private final String title;
    private final String platform;
    private final String region;
    private final String condition;
    private final boolean boxed;

    public Game(int id, String title, String platform, String region, String condition, boolean boxed) {

    this.id = id;
    this.title = title;
    this.platform = platform;
    this.region = region;
    this.condition = condition;
    this.boxed = boxed;
    }

    // Constructor for NEW games (no ID yet)
public Game(String title, String platform, String region, String condition, boolean boxed) {
    this(0, title, platform, region, condition, boxed);
}

    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    public String getPlatform() {
        return platform;
    }

    public String getRegion() {
        return region;
    }

    public String getCondition() {
        return condition;
    }

    public boolean isBoxed() {
        return boxed;
    }
}