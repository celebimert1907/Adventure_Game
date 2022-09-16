import java.util.Scanner;
public class Game {
    Player player;
    Location location;
    Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Macera oyununa hoşgeldiniz!");
        System.out.println("Lütfen isiminizi giriniz: ");
        //*String playerName = input.nextLine();
        System.out.println("-----------------------------------------------------------------------------");
        Player player = new Player("Mert");
        System.out.println(player.getName() + " Bu sisli ve karanlık dünyaya hoşgeldin!\n" +
                "Burada yaşanan herşey tamamen gerçektir!");
        System.out.println("Bu karanlık dünyada yoluna devam edebilmen için bir karakter seçmelisin!");
        player.selectChar();

        Location location;
        while (true){
            player.printInfo();
            NormalLoc[] locList = {new SafeHouse(player),new ToolStore(player), new Battle(player)};
            System.out.println("-------------------------------- LOKASYONLAR --------------------------------");
            for (NormalLoc normalLoc :locList){
                System.out.println("No: " + normalLoc.getLocID() +
                        " ==> Lokasyon: " + normalLoc.getLocName());
            }
            System.out.println("No: 0 ==> Cıkış Yap");
            System.out.println("-----------------------------------------------------------------------------");

            System.out.print("Lütfen gitmek istediğiniz lokasyonu seçiniz: ");
            int selectLoc = input.nextInt();
            System.out.println("-----------------------------------------------------------------------------");
            switch (selectLoc) {
                case 0 -> location = null;
                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new ToolStore(player);
                case 3 -> location = new Battle(player);
                default -> {
                    System.out.println("Demek korktun ha !!!\n" +
                            "Eve gönderiliyorsun!");
                    location = new SafeHouse(player);
                }
            }

            if (location == null){
                System.out.println("Oyundan cıkış yaptınız!\n" +
                        "Sakın unutma bu karanlık ve sisli vadiden kurtulmak kolay değildir !!!");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Oyun Bitti !!!");
                break;
            }

        }
    }
}
