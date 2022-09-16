public class Forest extends BattleLoc{
    public Forest(Player player, Location location) {
        super(player,2,"ORMAN",new Vampire(),"ODUN",3,location);
    }

    @Override
    public boolean onLocation() {
        warLoc(randomObstacleNumber());
        return true;
    }
}
