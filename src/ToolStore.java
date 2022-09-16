public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, 2,"Mağaza");
    }
    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Mağazaya Hosgeldiniz!");
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zirhlar");
            System.out.println("3 - Çıkış");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.print("İşlem yapmak istediğiniz kategoriyi seçiniz: ");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Geçersiz !!! Tekrar deneyiniz: ");
                selectCase = input.nextInt();
            }

            switch (selectCase) {
                case 1 -> {
                    printWeapon();
                    buyWeapon();
                }
                case 2 -> {
                    printArmor();
                    buyArmor();
                }
                case 3 -> {
                    System.out.println("Çıkış yaptiniz!");
                    showMenu = false;
                }
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
        return true;
    }

    public void printWeapon (){
        System.out.println("---------------------------------- SİLAHLAR ---------------------------------");
        for (Weapon w : Weapon.weapons()){
            System.out.println("No: " + w.getWeaponID() +
                    " ==> Silah: " + w.getWeaponName() +
                    "\tHasar: " + w.getWeaponDamage() +
                    "\tPara: " + w.getWeaponPrice());
        }
        System.out.println("0 - CIKIS");
        System.out.println("-----------------------------------------------------------------------------");
    }

    public void buyWeapon(){
        System.out.print("Silahını seç: ");
        int selectWeapon = input.nextInt();
        System.out.println("-----------------------------------------------------------------------------");
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length ){
            System.out.print("Geçersiz !!! Tekrar deneyiniz: ");
            selectWeapon = input.nextInt();
            System.out.println("-----------------------------------------------------------------------------");

        }

        if (selectWeapon != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);
            if (selectedWeapon != null){
                if (selectedWeapon.getWeaponPrice() > this.getPlayer().getMoney()){
                    System.out.println("Canavarlarla savaşarak biraz daha paranı çoğaltmalısın dostum!\n" +
                            "Paran yetersiz !");

                } else {
                    System.out.println(selectedWeapon.getWeaponName() + "silahını satın aldın!");
                    int balanceWeapon = this.getPlayer().getMoney() - selectedWeapon.getWeaponPrice();
                    this.getPlayer().setMoney(balanceWeapon);
                    System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahın: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahın: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
                    System.out.println("-----------------------------------------------------------------------------");
                    getPlayer().printInfo();
                    System.out.println("-----------------------------------------------------------------------------");
                }
            }

        }
    }
    public void printArmor (){
        System.out.println("---------------------------------- ZIRHLAR ---------------------------------");
        for (Armor a : Armor.armors()){
            System.out.println("No: " + a.getArmorID() +
                    " ==> Silah: " + a.getArmorName() +
                    "\tDefans: " + a.getArmorBlock() +
                    "\tFiyat: " + a.getArmorPrice());
        }
        System.out.println("0 - Çıkış");
    }

    public void buyArmor (){
        System.out.println("-----------------------------------------------------------------------------");
        System.out.print("Zırhını seç: ");
        int selectArmor = input.nextInt();
        System.out.println("-----------------------------------------------------------------------------");
        while (selectArmor < 0 || selectArmor > Armor.armors().length ){
            System.out.print("Geçersiz !!! Tekrar deneyiniz: ");
            selectArmor = input.nextInt();
            System.out.println("-----------------------------------------------------------------------------");

        }

        if (selectArmor != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmor);
            if (selectedArmor != null){
                if (selectedArmor.getArmorPrice() > this.getPlayer().getMoney()){
                    System.out.println("Canavarlarla savaşarak biraz daha paranı çoğaltmalısın dostum!\n" +
                            "Paran yetersiz !");

                } else {
                    System.out.println(selectedArmor.getArmorName() + " zırhını satın aldın!");
                    int balanceArmor = this.getPlayer().getMoney() - selectedArmor.getArmorPrice();
                    this.getPlayer().setMoney(balanceArmor);
                    System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki zırhın: " + this.getPlayer().getInventory().getArmor().getArmorName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni zırhın: " + this.getPlayer().getInventory().getArmor().getArmorName());
                    System.out.println("-----------------------------------------------------------------------------");
                    getPlayer().printInfo();
                    System.out.println("-----------------------------------------------------------------------------");
                }
            }
        }
    }
}
