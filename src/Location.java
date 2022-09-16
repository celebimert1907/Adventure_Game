import java.util.Scanner;

public abstract class Location {
    protected Location location;
    protected Player player;
    private String locName;
    private int locID;
    public static Scanner input = new Scanner(System.in);

    public Location(Player player, int locID, String locName) {
        this.player = player;
        this.locID = locID;
        this.locName = locName;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getLocID() {
        return locID;
    }

    public void setLocID(int locID) {
        this.locID = locID;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }
}
