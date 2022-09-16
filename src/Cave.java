public class Cave extends BattleLoc{

    public Cave(Player player, Location location) {
        super(player, 1, "MAĞARA", new Zombie(), "YEMEK",3,location);
    }

    @Override
    public boolean onLocation() {
        warLoc(randomObstacleNumber());
        return true;
    }
}
