import java.util.Scanner;

public abstract class NormalLoc extends Location{
    public NormalLoc(Player player, int locID, String locName) {
        super(player, locID, locName);
    }
    Scanner input = new Scanner(System.in);
}
