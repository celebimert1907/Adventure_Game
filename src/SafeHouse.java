public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, 1,"Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz!\n" + "Canınız yenilendi!");
        System.out.println("-----------------------------------------------------------------------------");
        this.getPlayer().setHealth(this.getPlayer().getPlayerOrjinalHealth());
        return true;
    }


}