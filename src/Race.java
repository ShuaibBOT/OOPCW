import java.util.ArrayList;

public class Race {
      private String nameOfRace;
      private String dateOfRace;
      private ArrayList<String> participants;
      private ArrayList<Integer> position;

      public Race(String nameOfRace,String dateOfRace, ArrayList<String> participants, ArrayList<Integer> position){
            this.setNameOfRace(nameOfRace);
            this.setDateOfRace(dateOfRace);
            this.setParticipants(participants);
            this.setPosition(position);
      }

    public String getNameOfRace() {
        return nameOfRace;
    }

    public void setNameOfRace(String nameOfRace) {
        this.nameOfRace = nameOfRace;
    }

    public String getDateOfRace() {
        return dateOfRace;
    }

    public void setDateOfRace(String dateOfRace) {
        this.dateOfRace = dateOfRace;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }

    public ArrayList<Integer> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<Integer> position) {
        this.position = position;
    }
}
