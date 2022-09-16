public abstract class GameChar {
    private int iD;
    private String charName;
    private int damage;
    private int health;
    private int money;

    public GameChar(int iD, String charName, int damage, int health, int money) {
        this.iD = iD;
        this.charName = charName;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getCharName() {
        return charName;
    }

    public void setName(String name) {
        this.charName = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
