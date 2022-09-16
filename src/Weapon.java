public class Weapon{
    private int weaponID;
    private String weaponName;
    private int weaponDamage;
    private int weaponPrice;

    public Weapon(int weaponID, String weaponName, int weaponDamage, int weaponPrice) {
        this.weaponID = weaponID;
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
        this.weaponPrice = weaponPrice;
    }

    public static Weapon[] weapons (){
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon(1,"TABANCA", 2,25);
        weaponList[1] = new Weapon(2,"KILIÇ\t",3,35);
        weaponList[2] = new Weapon(3,"TÜFEK\t",7,45);
        return weaponList;
    }

    public static Weapon getWeaponObjByID(int weaponID) {
        for (Weapon w : Weapon.weapons()){
            if (w.getWeaponID() == weaponID){
                return w;
            }
        }
        return null;
    }

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponPrice() {
        return weaponPrice;
    }

    public void setWeaponPrice(int weaponPrice) {
        this.weaponPrice = weaponPrice;
    }
}
