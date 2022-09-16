import java.util.Scanner;

public class Battle extends NormalLoc{
    Scanner input = new Scanner(System.in);

    public Battle(Player player) {
        super(player, 3, "Savaş Alanı");
    }
    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        while (showMenu) {
            BattleLoc[] battleLocList = {new Cave(player, location), new Forest(player, location), new River(player, location)};
            System.out.println("------------------------------- SAVAŞ ALANLARI ------------------------------");
            for (BattleLoc battleLocs : battleLocList){
                System.out.println("No: " + battleLocs.getBattleFieldID()+
                        "\tKonum: " + battleLocs.getBattleFieldName());
            }
            System.out.println("No: 0 ==> Geri Gel");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.print("Savaşmak istediğiniz vadiyi seçin: ");
            int selectBattleLoc = input.nextInt();
            System.out.println("-----------------------------------------------------------------------------");
            while (selectBattleLoc < 0 || selectBattleLoc > battleLocList.length) {
                System.out.print("Geçersiz !!! Tekrar deneyiniz: ");
                selectBattleLoc = input.nextInt();
                System.out.println("-----------------------------------------------------------------------------");
            }
            boolean isPassLocation = true;
            switch (selectBattleLoc) {
                case 1:
                    if (player.getInventory().isFood()) {
                        System.out.println("Siz zaten bu bolumu gecerek " + player.getInventory().isFood() + " isimli odulun sahibi oldunuz. Bir daha giremezsiniz!!!");
                        isPassLocation = false;
                        break;
                    }
                    location = new Cave(player, location);
                    break;
                case 2:
                    if (player.getInventory().isFirewood()) {
                        System.out.println("Siz zaten bu bolumu gecerek " + player.getInventory().isFood() + " isimli odulun sahibi oldunuz. Bir daha giremezsiniz!!!");
                        isPassLocation = false;
                        break;
                    }
                    location = new Forest(player, location);
                    break;
                case 3:
                    if (player.getInventory().isWater()) {
                        System.out.println("Siz zaten bu bolumu gecerek " + player.getInventory().isWater() + " isimli odulun sahibi oldunuz. Bir daha giremezsiniz!!!");
                        isPassLocation = false;
                        break;
                    }
                    location = new River(player, location);
                    break;
                case 0:
                    System.out.println("Çıkış yaptın !\n" +
                            "Güvenli eve gönderiliyorsun!");
                    System.out.println("-----------------------------------------------------------------------------");
                    location = new SafeHouse(player);
                    showMenu = false;
                default:
                    location = null;
                    showMenu = false;
                    break;
            }
            if (location == null){
                System.out.println("Hatalı tercih yaptın !\n" +
                        "Güvenli eve gönderiliyorsun!");
                location = new SafeHouse(player);
                break;
            }

            if(!location. onLocation()){
                System.out.println("Oyun Bitti !!!");
                break;
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
        return true;
    }
}
