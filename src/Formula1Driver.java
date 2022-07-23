public class Formula1Driver extends Driver{
    private int numberOf1stPlace;
    private int numberOf2ndPlace;
    private int numberOf3rdPlace;
    private int racesParticipated;
    private int pointsEarned;

    public Formula1Driver(String driver_Name,String driver_Location,String driver_Team){
        super(driver_Name,driver_Location,driver_Team);
    }

    public void placed1st(){
        this.setNumberOf1stPlace(this.getNumberOf1stPlace() + 1);
    }
    public void placed2nd(){
        this.setNumberOf2ndPlace(this.getNumberOf2ndPlace() + 1);
    }
    public void placed3rd(){
        this.setNumberOf3rdPlace(this.getNumberOf3rdPlace() + 1);
    }
    public void participatedInRace(){
        this.setRacesParticipated(this.getRacesParticipated() + 1);
    }
    public void pointsCollected(int position){
        switch(position){
            case 1:
                this.setPointsEarned(this.getPointsEarned() + 25);
                break;
            case 2:
                this.setPointsEarned(this.getPointsEarned() + 18);
                break;
            case 3:
                this.setPointsEarned(this.getPointsEarned() + 15);
                break;
            case 4:
                this.setPointsEarned(this.getPointsEarned() + 12);
                break;
            case 5:
                this.setPointsEarned(this.getPointsEarned() + 10);
                break;
            case 6:
                this.setPointsEarned(this.getPointsEarned() + 8);
                break;
            case 7:
                this.setPointsEarned(this.getPointsEarned() + 6);
                break;
            case 8:
                this.setPointsEarned(this.getPointsEarned() + 4);
                break;
            case 9:
                this.setPointsEarned(this.getPointsEarned() + 2);
                break;
            case 10:
                this.setPointsEarned(this.getPointsEarned() + 1);
                break;
        }
    }

    public int getNumberOf1stPlace() {
        return numberOf1stPlace;
    }

    public void setNumberOf1stPlace(int numberOf1stPlace) {
        this.numberOf1stPlace = numberOf1stPlace;
    }

    public int getNumberOf2ndPlace() {
        return numberOf2ndPlace;
    }

    public void setNumberOf2ndPlace(int numberOf2ndPlace) {
        this.numberOf2ndPlace = numberOf2ndPlace;
    }

    public int getNumberOf3rdPlace() {
        return numberOf3rdPlace;
    }

    public void setNumberOf3rdPlace(int numberOf3rdPlace) {
        this.numberOf3rdPlace = numberOf3rdPlace;
    }

    public int getRacesParticipated() {
        return racesParticipated;
    }

    public void setRacesParticipated(int racesParticipated) {
        this.racesParticipated = racesParticipated;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }
}
