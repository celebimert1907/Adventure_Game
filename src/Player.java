import java.util.Scanner;

public  class Player {
    private int iD;
    private int damage;
    private int health;
    private int playerOrjinalHealth;
    private int money;
    private String charName;
    private String name;
    private  Inventory inventory;
    protected Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){

        System.out.println("-------------------------------- KARAKTERLER --------------------------------");
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameChar gameChar : charList) {
            System.out.println("No: " + gameChar.getiD() +
                    " ==> Karakter: " + gameChar.getCharName() +
                    "\tHasar: " + gameChar.getDamage() +
                    "\tSağlk: " + gameChar.getHealth() +
                    "\tPara: " + gameChar.getMoney());
        }

        System.out.println("-----------------------------------------------------------------------------");
        System.out.print("Bir karakter seçin: ");

        boolean isChoose = true;
        while (isChoose) {
            int selectChar = input.nextInt();
            switch (selectChar) {
                case 1 -> {
                    initPlayer(new Samurai());
                    isChoose = false;
                    break;
                }
                case 2 -> {
                    initPlayer(new Archer());
                    isChoose = false;
                    break;
                }
                case 3 -> {
                    initPlayer(new Knight());
                    isChoose = false;
                    break;
                }
                default -> System.out.println("Yanlis secim yaptiniz, tekrar seciniz!");
            }

        }
        System.out.println("No: " + this.getiD() +
                " ==> Karakter: " + this.getCharName() +
                "\tHasar: " + this.getDamage() +
                "\tSağlık: " + this.getHealth() +
                "\tPara: " + this.getMoney());
        System.out.println("-----------------------------------------------------------------------------");
    }
    public void initPlayer(GameChar gameChar){
        this.setiD(gameChar.getiD());
        this.setCharName(gameChar.getCharName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setPlayerOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }

    public void printInfo(){
        System.out.println("Güncel Zırhınız: " + this.getInventory().getArmor().getArmorName() + "\t\t" +
                "Güncel Silahınız: "	+ this.getInventory().getWeapon().getWeaponName() + "\t" +
                "Güncel Hasarınız: " + this.getTotalDamage()  + "\n" +
                "Güncel Bloklama: " + this.getInventory().getArmor().getArmorBlock() + "\t" +
                "\t\tGüncel Sağlığınız: " + this.getHealth() + "\t" +
                "\tGüncel Paranız: " + this.getMoney());
    }


    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getTotalDamage(){return damage + this.getInventory().getWeapon().getWeaponDamage();}

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
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }


    public int getPlayerOrjinalHealth() {
        return playerOrjinalHealth;
    }

    public void setPlayerOrjinalHealth(int playerOrjinalHealth) {
        this.playerOrjinalHealth = playerOrjinalHealth;
    }
}