public class Armor{
    private int armorID;
    private String armorName;
    private int armorBlock;
    private int armorPrice;

    public Armor(int armorID, String armorName, int armorBlock, int armorPrice) {
        this.armorID = armorID;
        this.armorName = armorName;
        this.armorBlock = armorBlock;
        this.armorPrice = armorPrice;
    }

    public static Armor[] armors (){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1,"HAFIF", 1,15);
        armorList[1] = new Armor(2,"ORTA",3,25);
        armorList[2] = new Armor(3,"AĞIR",5,40);
        return armorList;
    }

    public static Armor getArmorObjByID(int armorID) {
        for (Armor a : Armor.armors()){
            if (a.getArmorID() == armorID){
                return a;
            }
        }
        return null;
    }



    public int getArmorID() {
        return armorID;
    }

    public void setArmorID(int armorID) {
        this.armorID = armorID;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorBlock() {
        return armorBlock;
    }

    public void setArmorBlock(int armorBlock) {
        this.armorBlock = armorBlock;
    }

    public int getArmorPrice() {
        return armorPrice;
    }

    public void setArmorPrice(int armorPrice) {
        this.armorPrice = armorPrice;
    }
}
