public class Mine extends BattleLoc{

    public Mine(Player player, Location location) {
        super(player,4,"MADEN", new Snake(),"HAZİNE", 5,location);
    }

    @Override
    public boolean onLocation() {
        warLoc(randomObstacleNumber());
        return true;
    }
}