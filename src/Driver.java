public abstract class Driver {

    private String driver_Name;
    private String driver_Location;
    private String driver_Team;

    public Driver(String driver_Name, String driver_Location, String driver_Team){
        this.setDriver_Name(driver_Name);
        this.setDriver_Location(driver_Location);
        this.setDriver_Team(driver_Team);
    }

    public String getDriver_Name() {
        return driver_Name;
    }

    public void setDriver_Name(String driver_Name) {
        this.driver_Name = driver_Name;
    }

    public String getDriver_Location() {
        return driver_Location;
    }

    public void setDriver_Location(String driver_Location) {
        this.driver_Location = driver_Location;
    }

    public String getDriver_Team() {
        return driver_Team;
    }

    public void setDriver_Team(String driver_Team) {
        this.driver_Team = driver_Team;
    }
}
