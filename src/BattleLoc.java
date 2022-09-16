import java.util.Random;
import java.util.Scanner;

public class BattleLoc extends Battle {
    private int battleFieldID;
    private String battleFieldName;
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private BattleLoc battleLoc;
    Scanner input = new Scanner(System.in);

    public BattleLoc(Player player, int battleFieldID, String battleFieldName, Obstacle obstacle, String award, int maxObstacle, Location location) {
        super(player);
        this.battleFieldID = battleFieldID;
        this.battleFieldName = battleFieldName;
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.location = location;
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt((getMaxObstacle()) + 1);
    }

    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("Şuan buradasınız: " + this.getBattleFieldName());
        System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + this.getObstacle().getObsName() + " yaşıyor !");
        System.out.print("<S>avaş veya <K>aç: ");
        String selectWarOrRun = input.nextLine().toUpperCase();
        while(!selectWarOrRun.equals("S") && !selectWarOrRun.equals("K")){
            System.out.println("Hatalı tercih tekrar dene !");
            selectWarOrRun = input.nextLine().toUpperCase();
        }
        if (selectWarOrRun.equals("S") && warLoc(obsNumber)) {
            if (warLoc(obsNumber)){
                System.out.println(getBattleFieldName() + " alanındaki tüm canavarları yendiniz !");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0 ) {
            System.out.println("Öldünüz !!!");
            return false;
        } else {
            System.out.println("Canavarladan kaçmak tam senin işin dostum !!!");
        }
        return true;
    }

    public boolean warLoc(int obsNumber) {
        int finishMonster = 0;
        System.out.println("Şuan buradasınız: " + this.getBattleFieldName());
        System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + this.getObstacle().getObsName() + " yaşıyor !");
        for (int i = 1; i <= obsNumber; i++) {
            int firstHit = firstHit();
            this.getObstacle().setObsHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getObsHealth() > 0) {
                System.out.print("<S>avaş veya <K>aç: ");
                String selectWar = input.nextLine().toUpperCase();
                if (selectWar.equals("S")) {
                    if (firstHit == 0) {
                        System.out.print("Siz Vurdunuz: ");
                        this.getObstacle().setObsHealth(this.getObstacle().getObsHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        System.out.println("-----------------------------------------------------------------------------");
                        if (this.getObstacle().getObsHealth() > 0) {
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage = this.getObstacle().getObsDamage() - this.getPlayer().getInventory().getArmor().getArmorBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                            System.out.println("-----------------------------------------------------------------------------");
                        }
                    }
                    if (firstHit == 1) {
                        if (this.getPlayer().getHealth() > 0) {
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage = this.getObstacle().getObsDamage() - this.getPlayer().getInventory().getArmor().getArmorBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                            System.out.println("-----------------------------------------------------------------------------");
                        }
                        System.out.print("Siz Vurdunuz: ");
                        this.getObstacle().setObsHealth(this.getObstacle().getObsHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        System.out.println("-----------------------------------------------------------------------------");
                    }
                } else {
                    System.out.println("Kaçarak korkaklık yaptın !!!");
                    location = new SafeHouse(player);
                    return false;
                }

                if (this.getPlayer().getHealth() <= 0) {
                    System.out.println("Öldün !!!");
                    return false;
                }
                if (this.getObstacle().getObsHealth() <=0) {
                    if (this.getBattleFieldName().equals("Maden")) {
                        Random snake = new Random();
                        snakeAward();
                    } else {
                        this.getPlayer().setMoney(this.getObstacle().getObsAward() + this.getPlayer().getMoney());
                        System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
                    }
                    finishMonster++;
                }
                if (finishMonster == (obsNumber) && this.getObstacle().getObsHealth() <= 0) {
                    System.out.println(finishMonster);
                    System.out.println("Tebrikler " + this.getBattleFieldName() + " vadisindeki tüm canavarları öldürdün !!!");
                    locationAward();
                    return true;
                }
                if (this.location.getClass().getName().equals(new SafeHouse(player))) {
                    if (this.player.getInventory().isFirewood() && this.player.getInventory().isFood() && this.player.getInventory().isWater()) {
                        System.out.println("Tebrikler Oyunu Kazandınız !");
                        break;
                    }
                }
            }
        }
        return true;
    }

    public void snakeAward(){
        Random a = new Random();
        int percentage = a.nextInt(100);
        int gun = a.nextInt(100);
        int shield = a.nextInt(100);
        int money = a.nextInt(100);
        if (percentage <15) {
            if (gun < 50) {
                if (isWantWeapon("TABANCA")){
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
                }
            }
            if (gun >= 50 && gun < 80) {
                if (isWantWeapon("KILIÇ")) {
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
                }
            }
            if (gun >= 80) {
                if (isWantWeapon("TÜFEK")) {
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
                }
            }
        } else if (percentage >= 15 && percentage < 30) {
            if (shield < 50) {
                if (isWantArmor("HAFIF")) {
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
                }
            }
            if (shield >= 50 && shield < 80) {
                if (isWantArmor("ORTA")) {
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
                }
            }
            if (shield >= 80) {
                if (isWantArmor("AĞIR")) {
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
                }
            }
        } else  if (percentage >=30 && percentage <55) {
            awardMoney(money);
        } else {
            System.out.println("Kutu boş açıldı ! Hiç birşey Kazanamadın ;)");
        }
    }

    public void awardMoney (int money){
        if (money < 50) {
            this.getPlayer().setMoney(1 + this.getPlayer().getMoney());
            System.out.println("1 Altın Kazandın !");
        } else if (money >= 50 && money < 80) {
            this.getPlayer().setMoney(5 + this.getPlayer().getMoney());
            System.out.println("5 altın Kazandın !");
        } else {
            this.getPlayer().setMoney(10 + this.getPlayer().getMoney());
            System.out.println("10 altın Kazandın !");
        }
    }

    public boolean isWantWeapon(String name) {
        System.out.println("Tebrikler kutudan" + name + " çıktı. Almak istermisin ?");
        System.out.println("Kullandığın silah: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
        System.out.println("1\tEvet");
        System.out.println("2\tHayir");
        System.out.println();
        int isYes = input.nextInt();
        input.nextLine();
        while (isYes < 1 || isYes > 2) {
            System.out.println("Dostum şu tuşlara doğru bas !");
            isYes = input.nextInt();
            input.nextLine();
        }
        if (isYes == 2) {
            return false;
        }
        return true;
    }
    public boolean isWantArmor(String name) {
        System.out.println("Tebrikler kutudan" + name + " çıktı. Almak istermisin ?");
        System.out.println("Kullandığın zırh: " + this.getPlayer().getInventory().getArmor().getArmorName());
        System.out.println("1\tEvet");
        System.out.println("2\tHayir");
        System.out.println();
        int isYes = input.nextInt();
        input.nextLine();
        while (isYes < 1 || isYes > 2) {
            System.out.println("Dostum şu tuşlara doğru bas !");
            isYes = input.nextInt();
            input.nextLine();
        }
        if (isYes == 2) {
            return false;
        }
        return true;
    }

    public void locationAward() {
        if (this.getBattleFieldName().equals("MAĞARA")) {
            this.getPlayer().getInventory().setFood(this.player.getInventory().isFood());
        }
        if (this.getBattleFieldName().equals("ORMAN")) {
            this.getPlayer().getInventory().setFirewood(this.player.getInventory().isFirewood());
        }
        if (this.getBattleFieldName().equals("NEHİR")) {
            this.getPlayer().getInventory().setWater(this.player.getInventory().isWater());
        }
        if (this.getBattleFieldName().equals("MADEN")) {
            this.getPlayer().getInventory().setSnake(this.award);
        }
    }

    public int firstHit() {
        Random r = new Random();
        return r.nextInt(2);
    }


    public void afterHit(){
        System.out.println("Canınız: " + this.player.getHealth());
        System.out.println(this.obstacle.getObsName() + " Canı: " + this.obstacle.getObsHealth());
    }

    public void playerStats(){
        System.out.println("------------------------------ Oyuncu Bilgileri -----------------------------");

        System.out.println("Sağlığınız: ==> " + this.player.getHealth());
        System.out.println("Silahınız: ==> " + this.player.getInventory().getWeapon().getWeaponName());
        System.out.println("Hasarınız: ==> " + this.player.getTotalDamage());
        System.out.println("Zırhınız: ==> " + this.player.getInventory().getArmor().getArmorName());
        System.out.println("Bloklama: ==> " + this.player.getInventory().getArmor().getArmorBlock());
        System.out.println("Paranız: ==> " + this.player.getMoney());
        System.out.println("-----------------------------------------------------------------------------");
    }
    public void obstacleStats(int i){
        System.out.println("------------------------------" + i + "." + this.obstacle.getObsName() + " Bilgileri" + "------------------------------");
        System.out.println("Sağlık: ==> " + this.obstacle.getObsHealth());
        System.out.println("Hasar: ==> " + this.obstacle.getObsDamage());
        System.out.println("Ödül: " +
                "==> " + this.obstacle.getObsAward());
        System.out.println("-----------------------------------------------------------------------------");
    }

    public int getBattleFieldID() {
        return battleFieldID;
    }

    public void setBattleFieldID(int battleFieldID) {
        this.battleFieldID = battleFieldID;
    }

    public String getBattleFieldName() {
        return battleFieldName;
    }

    public void setBattleFieldName(String battleFieldName) {
        this.battleFieldName = battleFieldName;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public BattleLoc getBattleLoc() {
        return battleLoc;
    }

    public void setBattleLoc(BattleLoc battleLoc) {
        this.battleLoc = battleLoc;
    }
}
