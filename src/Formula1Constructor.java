public class Formula1Constructor {
    private String constructorName;
    private String constructorDriver;


    public Formula1Constructor(String constructorName,String constructorDriver){
        this.setConstructorName(constructorName);
        this.setConstructorDriver(constructorDriver);
    }

    public String getConstructorName() {
        return constructorName;
    }

    public void setConstructorName(String constructorName) {
        this.constructorName = constructorName;
    }

    public String getConstructorDriver() {
        return constructorDriver;
    }

    public void setConstructorDriver(String constructorDriver) {
        this.constructorDriver = constructorDriver;
    }

}
