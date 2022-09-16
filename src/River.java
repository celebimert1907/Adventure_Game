public class River extends BattleLoc{
    public River(Player player, Location location) {
        super(player, 3, "NEHİR", new Bear(), "SU",2,location);
    }

    @Override
    public boolean onLocation() {
        warLoc(randomObstacleNumber());
        return true;
    }
}
