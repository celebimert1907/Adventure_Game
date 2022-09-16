public class Obstacle {
    private int obsID;
    private String obsName;
    private int obsDamage;
    private int obsHealth;
    private int obsAward;
    private int orjinalHealth;

    public Obstacle(int obsID, String obsName, int obsDamage, int obsHealth, int obsAward) {
        this.obsID = obsID;
        this.obsName = obsName;
        this.obsDamage = obsDamage;
        this.orjinalHealth = obsHealth;
        this.obsAward = obsAward;
    }

    public int getObsID() {
        return obsID;
    }

    public void setObsID(int obsID) {
        this.obsID = obsID;
    }

    public String getObsName() {
        return obsName;
    }

    public void setObsName(String obsName) {
        this.obsName = obsName;
    }

    public int getObsDamage() {
        return obsDamage;
    }

    public void setObsDamage(int obsDamage) {
        this.obsDamage = obsDamage;
    }

    public int getObsHealth() {
        return obsHealth;
    }

    public void setObsHealth(int obsHealth) {
        if(obsHealth < 0){
            obsHealth = 0;
        }
        this.obsHealth = obsHealth;
    }

    public int getObsAward() {
        return obsAward;
    }

    public void setObsAward(int obsAward) {
        this.obsAward = obsAward;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
