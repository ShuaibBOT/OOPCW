
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Formula1Driver> driversParticipating = new ArrayList<>();
    ArrayList<Race> raceParticipation = new ArrayList<>();

    @Override
    public void createNewDriver() {
        System.out.println("Driver's Name: ");
        String name = this.scanner.next();
        System.out.println("Driver's Location: ");
        String location = this.scanner.next();
        System.out.println("Driver's Team: ");
        String team = this.scanner.next();
        driversParticipating.add(new Formula1Driver(name, location, team));
    }

    @Override
    public void deleteDriverAndConstructorFromChampionship() {
        System.out.println("Non-participating Driver's name: ");
        String bufferName = this.scanner.next();
        for (int i = 0; i < driversParticipating.size(); i++) {
            if (driversParticipating.get(i).getDriver_Name().equals(bufferName)) {
                driversParticipating.remove(i);
            } else {
                System.out.println("Driver by that name does not exist");
            }
        }
    }

    @Override
    public void changeDriverForExistingConstructor() {
        System.out.println("Name of new Driver for the team: ");
        String newDriverName = this.scanner.next();
        System.out.println("Location of new Driver for the team: ");
        String newDriverLocation = this.scanner.next();
        System.out.println("Name of Constructor: ");
        String bufferConstructor = this.scanner.next();
        for (int i = 0; i < driversParticipating.size(); i++) {
            if (driversParticipating.get(i).getDriver_Team().equals(bufferConstructor)) {
                driversParticipating.get(i).setDriver_Name(newDriverName);
                driversParticipating.get(i).setDriver_Location(newDriverLocation);
                driversParticipating.get(i).setNumberOf1stPlace(0);
                driversParticipating.get(i).setNumberOf2ndPlace(0);
                driversParticipating.get(i).setNumberOf3rdPlace(0);
                driversParticipating.get(i).setPointsEarned(0);
                driversParticipating.get(i).setRacesParticipated(0);
            }
        }
    }

    @Override
    public void displayDriverStats() {
        System.out.println("Name of driver to check Statistics: ");
        String bufferName = this.scanner.next();
        for (int i = 0; i < driversParticipating.size(); i++) {
            if (driversParticipating.get(i).getDriver_Name().equals(bufferName)) {
                System.out.println();
                System.out.println("Statistics of " + driversParticipating.get(i).getDriver_Name());
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("Name of driver: " + driversParticipating.get(i).getDriver_Name());
                System.out.println("Driver's Location: " + driversParticipating.get(i).getDriver_Location());
                System.out.println("Driver's Team: " + driversParticipating.get(i).getDriver_Team());
                System.out.println("Number of 1st place achieved by driver: " + driversParticipating.get(i).getNumberOf1stPlace());
                System.out.println("Number of 2nd place achieved by driver: " + driversParticipating.get(i).getNumberOf2ndPlace());
                System.out.println("Number of 3rd place achieved by driver" + driversParticipating.get(i).getNumberOf3rdPlace());
                System.out.println("Points earned by driver: " + driversParticipating.get(i).getPointsEarned());
                System.out.println("Races participated by the driver: " + driversParticipating.get(i).getRacesParticipated());
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------------------");
            }
        }
    }

    @Override
    public void displayFormula1DriverTable() {
        bubbleSortDescending(driversParticipating);

        System.out.printf("%-19s%-20s%-20s%-20s%-22s%-22s%-22s%-29s%9s\n", "Points Placement", "Name", "Location", "Team", "Number of 1st place", "Number of 2nd place", "Number of 3rd place", "Number of Participated Race", "Points");
        for (int i = 0; i < driversParticipating.size(); i++) {
            System.out.printf("%-19s%-20s%-20s%-20s%-22s%-22s%-22s%-29s%9s\n", i + 1, driversParticipating.get(i).getDriver_Name(),
                    driversParticipating.get(i).getDriver_Location(),
                    driversParticipating.get(i).getDriver_Team(),
                    driversParticipating.get(i).getNumberOf1stPlace(),
                    driversParticipating.get(i).getNumberOf2ndPlace(),
                    driversParticipating.get(i).getNumberOf3rdPlace(),
                    driversParticipating.get(i).getRacesParticipated(),
                    driversParticipating.get(i).getPointsEarned());

        }

    }

    public void bubbleSortDescending(ArrayList<Formula1Driver> transferArraylist) {
        int n = transferArraylist.size();
        Formula1Driver tempF1DriverObject;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (transferArraylist.get(j - 1).getPointsEarned() < transferArraylist.get(j).getPointsEarned() &&
                        transferArraylist.get(j - 1).getPointsEarned() != transferArraylist.get(j).getPointsEarned()) {
                    //swap elements

                    tempF1DriverObject = transferArraylist.get(j - 1);
                    transferArraylist.set(j - 1, transferArraylist.get(j));
                    transferArraylist.set(j, tempF1DriverObject);

                } else if (transferArraylist.get(j - 1).getNumberOf1stPlace() < transferArraylist.get(j).getNumberOf1stPlace()) {

                    tempF1DriverObject = transferArraylist.get(j - 1);
                    transferArraylist.set(j - 1, transferArraylist.get(j));
                    transferArraylist.set(j, tempF1DriverObject);

                }

            }
        }
        System.out.println("<Sorted>");

    }

    @Override
    public void raceCompleted() {
        ArrayList<String> bufferParticipants = new ArrayList<>();
        ArrayList<Integer> bufferPositions = new ArrayList<>();
        System.out.println("Title of the Race: ");
        String bufferRaceName = this.scanner.next();
        System.out.println("Date the race took place: ");
        String bufferRaceDate = this.scanner.next();

        for (int i = 0; i < driversParticipating.size(); i++) {
            String isParticipating;
            System.out.println("Is " + driversParticipating.get(i).getDriver_Name() + " participating in " + bufferRaceName + " ? (yes/Yes or no/No)");
            isParticipating = this.scanner.next();
            if (isParticipating.equals("Yes") || isParticipating.equals("yes")) {
                bufferParticipants.add(driversParticipating.get(i).getDriver_Name());
                driversParticipating.get(i).participatedInRace();
                System.out.println("Which position did " + driversParticipating.get(i).getDriver_Name() + " achieve?");
                int placement = this.scanner.nextInt();
                bufferPositions.add(placement);
                driversParticipating.get(i).pointsCollected(placement);
                if (placement == 1) {
                    driversParticipating.get(i).placed1st();
                } else if (placement == 2) {
                    driversParticipating.get(i).placed2nd();
                } else if (placement == 3) {
                    driversParticipating.get(i).placed3rd();
                }

            }
        }
        raceParticipation.add(new Race(bufferRaceName, bufferRaceDate, bufferParticipants, bufferPositions));
    }

    @Override
    public void saveInFile() {
        try {
            FileWriter writeInfo = new FileWriter("C:\\Users\\Shuaib\\Documents\\GitHub\\OOPCW\\out\\production\\OopVivaCw\\Savefile");
            writeInfo.write(driversParticipating.size() + "\n");
            for (int i = 0; i < driversParticipating.size(); i++) {
                writeInfo.write(driversParticipating.get(i).getDriver_Name() + "\n");
                writeInfo.write(driversParticipating.get(i).getDriver_Location() + "\n");
                writeInfo.write(driversParticipating.get(i).getDriver_Team() + "\n");
                writeInfo.write(driversParticipating.get(i).getNumberOf1stPlace() + "\n");
                writeInfo.write(driversParticipating.get(i).getNumberOf2ndPlace() + "\n");
                writeInfo.write(driversParticipating.get(i).getNumberOf3rdPlace() + "\n");
                writeInfo.write(driversParticipating.get(i).getRacesParticipated() + "\n");
                writeInfo.write(driversParticipating.get(i).getPointsEarned() + "\n");
            }
            writeInfo.write(raceParticipation.size() + "\n");
            for (int count = 0; count < raceParticipation.size(); count++) {
                writeInfo.write(raceParticipation.get(count).getNameOfRace() + "\n");
                writeInfo.write(raceParticipation.get(count).getDateOfRace() + "\n");
                writeInfo.write(raceParticipation.get(count).getParticipants().size() + "\n");
                for (int count1 = 0; count1 < raceParticipation.get(count).getParticipants().size(); count1++) {
                    writeInfo.write(raceParticipation.get(count).getParticipants().get(count1) + "\n");
                    writeInfo.write(raceParticipation.get(count).getPosition().get(count1) + "\n");
                }
            }
            writeInfo.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    @Override
    public void loadToFile() {
        try {
            File fileInfoReader = new File("C:\\Users\\Shuaib\\Documents\\GitHub\\OOPCW\\out\\production\\OopVivaCw\\Savefile");
            Scanner readInfo = new Scanner(fileInfoReader);
            while (readInfo.hasNextLine()) {
                int driversParticipatingSize = Integer.parseInt(readInfo.nextLine());
                for (int i = 0; i < driversParticipatingSize; i++) {
                    driversParticipating.get(i).setDriver_Name(readInfo.nextLine());
                    driversParticipating.get(i).setDriver_Location(readInfo.nextLine());
                    driversParticipating.get(i).setDriver_Team(readInfo.nextLine());
                    driversParticipating.get(i).setNumberOf1stPlace(Integer.parseInt(readInfo.nextLine()));
                    driversParticipating.get(i).setNumberOf2ndPlace(Integer.parseInt(readInfo.nextLine()));
                    driversParticipating.get(i).setNumberOf3rdPlace(Integer.parseInt(readInfo.nextLine()));
                    driversParticipating.get(i).setRacesParticipated(Integer.parseInt(readInfo.nextLine()));
                    driversParticipating.get(i).setPointsEarned(Integer.parseInt(readInfo.nextLine()));
                }
                int raceParticipantsSize = Integer.parseInt(readInfo.nextLine());
                for (int count = 0; count < raceParticipantsSize; count++) {
                    raceParticipation.get(count).setNameOfRace(readInfo.nextLine());
                    raceParticipation.get(count).setDateOfRace(readInfo.nextLine());
                    int participantsSize = Integer.parseInt(readInfo.nextLine());
                    for (int count1 = 0; count1 < participantsSize; count1++) {
                        raceParticipation.get(count).getParticipants().set(count1, readInfo.nextLine());
                        raceParticipation.get(count).getPosition().set(count1, Integer.parseInt(readInfo.nextLine()));
                    }
                }

            }
            readInfo.close();
            System.out.println(" Successfully loaded from file ");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        bubbleSortDescending(driversParticipating);

    }

    public void reloadFile() {
        try {
            File fileInfoReader = new File("C:\\Users\\Shuaib\\Documents\\GitHub\\OOPCW\\out\\production\\OopVivaCw\\Savefile");
            Scanner readInfo = new Scanner(fileInfoReader);
            while (readInfo.hasNextLine()) {
                int driversParticipatingSize = Integer.parseInt(readInfo.nextLine());
                for (int i = 0; i < driversParticipatingSize; i++) {
                    driversParticipating.add(new Formula1Driver(readInfo.nextLine(), readInfo.nextLine(), readInfo.nextLine()));
                    driversParticipating.get(i).setNumberOf1stPlace(Integer.parseInt(readInfo.nextLine()));
                    driversParticipating.get(i).setNumberOf2ndPlace(Integer.parseInt(readInfo.nextLine()));
                    driversParticipating.get(i).setNumberOf3rdPlace(Integer.parseInt(readInfo.nextLine()));
                    driversParticipating.get(i).setRacesParticipated(Integer.parseInt(readInfo.nextLine()));
                    driversParticipating.get(i).setPointsEarned(Integer.parseInt(readInfo.nextLine()));
                }
                ArrayList<String> bufferParticipants = new ArrayList<>();
                ArrayList<Integer> bufferPosition = new ArrayList<>();
                int raceParticipantsSize = Integer.parseInt(readInfo.nextLine());
                for (int count = 0; count < raceParticipantsSize; count++) {
                    String bufferRaceName = readInfo.nextLine();
                    String bufferDateOfRace = readInfo.nextLine();
                    int participantsSize = Integer.parseInt(readInfo.nextLine());
                    for (int count1 = 0; count1 < participantsSize; count1++) {
                        bufferParticipants.add(readInfo.nextLine());
                        bufferPosition.add(Integer.parseInt(readInfo.nextLine()));
                    }
                    raceParticipation.add(new Race(bufferRaceName, bufferDateOfRace, bufferParticipants, bufferPosition));
                }

            }
            readInfo.close();
            System.out.println(" Successfully loaded from file ");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        bubbleSortDescending(driversParticipating);

    }

    public int getNumberofDriversParticipating() {
        return driversParticipating.size();
    }

    public void DeleteFormula1TableAndRace() {
        for (int i = 0; i < driversParticipating.size(); i++) {
            driversParticipating.remove(i);
        }
        for (int count = 0; count < raceParticipation.size(); count++) {
            raceParticipation.remove(count);
        }
        saveInFile();
    }

    public void randomRaceCompleted() {
        ArrayList<Integer> repeatingPosition = new ArrayList<>();
        ArrayList<String> randomBufferParticipants = new ArrayList<>();
        ArrayList<Integer> randomBufferPositions = new ArrayList<>();

        String randomBufferRaceName = "RandomRace" + (raceParticipation.size() + 1);
        String randomBufferRaceDate = "No Specific Date";
        Random rand = new Random();

        for (int i=0;i<driversParticipating.size();i++){
            int placement;
            boolean notSame = false;
            randomBufferParticipants.add(driversParticipating.get(i).getDriver_Name());
            while(!notSame){
                placement = rand.nextInt(driversParticipating.size());
                placement+=1;
                if (repeatingPosition.isEmpty()){
                    randomBufferPositions.add(placement);
                    repeatingPosition.add(placement);
                    driversParticipating.get(i).pointsCollected(placement);
                    driversParticipating.get(i).participatedInRace();
                    if (placement == 1) {
                        driversParticipating.get(i).placed1st();
                    } else if (placement == 2) {
                        driversParticipating.get(i).placed2nd();
                    } else if (placement == 3) {
                        driversParticipating.get(i).placed3rd();
                    }
                    notSame=true;
                }
                if(!repeatingPosition.contains(placement)) {
                    randomBufferPositions.add(placement);
                    repeatingPosition.add(placement);
                    driversParticipating.get(i).pointsCollected(placement);
                    driversParticipating.get(i).participatedInRace();
                    if (placement == 1) {
                        driversParticipating.get(i).placed1st();
                    } else if (placement == 2) {
                        driversParticipating.get(i).placed2nd();
                    } else if (placement == 3) {
                        driversParticipating.get(i).placed3rd();
                    }
                    notSame=true;
                }
            }
        }
        raceParticipation.add(new Race(randomBufferRaceName, randomBufferRaceDate, randomBufferParticipants, randomBufferPositions));
    }

    public void generateRaceOnProbability() {
        ArrayList<Integer> repeatingPosition = new ArrayList<>();
        ArrayList<String> randomBufferParticipants = new ArrayList<>();
        ArrayList<Integer> randomBufferPositions = new ArrayList<>();
        String randomBufferRaceName = "RandomRace" + (raceParticipation.size() + 1);
        String randomBufferRaceDate = "No Specific Date";
        String firstPlacementName;
        int firstPositionIndex;
        Random rand = new Random();
        //Randomizes Race but does not affect driver stats
        for (int i = 0; i < driversParticipating.size(); i++) {
            int placement;
            boolean notSame = false;
            randomBufferParticipants.add(driversParticipating.get(i).getDriver_Name());
            while (!notSame) {
                placement = rand.nextInt(driversParticipating.size());
                placement += 1;
                if (repeatingPosition.isEmpty()) {
                    randomBufferPositions.add(placement);
                    repeatingPosition.add(placement);
                    notSame = true;
                }
                if (!repeatingPosition.contains(placement)) {
                    randomBufferPositions.add(placement);
                    repeatingPosition.add(placement);

                    notSame = true;
                }
            }
        }

        //Index of player who certainly won
        // calls method to check which driver is mosty probable to win
        firstPositionIndex= find1stPlaceFromRandom(randomBufferPositions);
        System.out.println(firstPositionIndex);

            randomBufferPositions.clear();
            driversParticipating.get(firstPositionIndex).pointsCollected(1);
            driversParticipating.get(firstPositionIndex).participatedInRace();
            driversParticipating.get(firstPositionIndex).placed1st();
            firstPlacementName=randomBufferParticipants.get(firstPositionIndex);
            repeatingPosition.clear();
            randomBufferParticipants.clear();
            repeatingPosition.add(firstPositionIndex);

        //finalizes and updates race with driver stats
        for (int i=0;i<driversParticipating.size();i++) {
            int placement;
            boolean notSame = false;
            if (i==firstPositionIndex) {
                randomBufferPositions.add(1);
                randomBufferParticipants.add(firstPlacementName);
            }else{
                randomBufferParticipants.add(driversParticipating.get(i).getDriver_Name());
                driversParticipating.get(i).participatedInRace();
                while (!notSame) {
                    placement = rand.nextInt(driversParticipating.size());
                    placement += 1;
                    if (repeatingPosition.isEmpty()) {
                        randomBufferPositions.add(placement);
                        repeatingPosition.add(placement);
                        driversParticipating.get(i).pointsCollected(placement);
                        if (placement == 1) {
                            driversParticipating.get(i).placed1st();
                        } else if (placement == 2) {
                            driversParticipating.get(i).placed2nd();
                        } else if (placement == 3) {
                            driversParticipating.get(i).placed3rd();
                        }
                        notSame = true;
                    }
                    if (!repeatingPosition.contains(placement)) {
                        randomBufferPositions.add(placement);
                        repeatingPosition.add(placement);
                        driversParticipating.get(i).pointsCollected(placement);
                        if (placement == 1) {
                            driversParticipating.get(i).placed1st();
                        } else if (placement == 2) {
                            driversParticipating.get(i).placed2nd();
                        } else if (placement == 3) {
                            driversParticipating.get(i).placed3rd();
                        }
                        notSame = true;
                    }
                }
            }
        }
        raceParticipation.add(new Race(randomBufferRaceName, randomBufferRaceDate, randomBufferParticipants, randomBufferPositions));
    }
    //method to decide which driver won based off probability
    public int find1stPlaceFromRandom(ArrayList<Integer> randomBufferPositions){
        int sendIndex=0;
        boolean found1= true;
        boolean found2=true;
        boolean found3= true;
        boolean found4= true;
        Random rand= new Random();
        for (int count = 0; count < randomBufferPositions.size(); count++) {

            double randProbability;
            if (randomBufferPositions.get(count)==1){
                randProbability= rand.nextDouble();
                if(randProbability>0.6){
                    sendIndex=count;
                    break;
                }else{
                    found1=false;
                }
            }
            if (randomBufferPositions.get(count) == 2) {
                randProbability = rand.nextDouble();
                if (randProbability > 0.7) {
                    sendIndex= count;
                    break;
                }else{
                    found2=false;
                }
            }
            if(randomBufferPositions.get(count)==3 || randomBufferPositions.get(count)==4){
                randProbability=rand.nextDouble();
                if(randProbability>0.9){
                    sendIndex= count;
                    break;
                }else{
                    found3=false;
                }
            }
            if (randomBufferPositions.get(count)>=5){
                randProbability=rand.nextDouble();
                if(randProbability>0.98){
                    sendIndex=count;
                    break;
                }else{
                    found4=false;
                }
            }
            if(!found1&&!found2&&!found3&&!found4){
                for(int count1=0;count1<randomBufferPositions.size();count1++){
                    if(randomBufferPositions.get(count1)==1){
                        sendIndex=count;
                        break;
                    }
                }
            }
        }
        return sendIndex;
    }

}
