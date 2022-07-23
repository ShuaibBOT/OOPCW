
import javax.swing.*;
import java.util.Scanner;

public class ChampionshipMain {



    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);

        Formula1ChampionshipManager championshipFunctions = new Formula1ChampionshipManager();
        System.out.println("Do you want to load the earlier contents of the program?(yes/YES or no/NO)");
        String loadBack= scanner.nextLine();
        if(loadBack.equals("yes") || loadBack.equals("YES")) {
            championshipFunctions.reloadFile();
            System.out.println("Successfully loaded earlier contents");
        }

        new Formula1TableAndFrame(championshipFunctions);

        boolean exit= false;

        while(!exit){
            System.out.println();
            System.out.println("\t\t\tMenu");
            System.out.println("-------------------------------------");
            System.out.println("\t1: Create a New Driver ");
            System.out.println("\t2: Delete a New Driver ");
            System.out.println("\t3: Change Driver ");
            System.out.println("\t4: Display Driver Statistics ");
            System.out.println("\t5: Display Formula 1 Driver Table");
            System.out.println("\t6: Add Race Completed ");
            System.out.println("\t7: Save Data ");
            System.out.println("\t8: Load Data ");
            System.out.println("\t9: Delete All Contents Stored");
            System.out.println("\t10: Exit The Program");
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println("Option: ");
            int optionSelect= scanner.nextInt();

            switch(optionSelect){
                case 1:
                    championshipFunctions.createNewDriver();
                    break;
                case 2:
                    championshipFunctions.deleteDriverAndConstructorFromChampionship();
                    break;
                case 3:
                    championshipFunctions.changeDriverForExistingConstructor();
                    break;
                case 4:
                    championshipFunctions.displayDriverStats();
                    break;
                case 5:
                    championshipFunctions.displayFormula1DriverTable();
                    break;
                case 6:
                    championshipFunctions.raceCompleted();
                    break;
                case 7:
                    championshipFunctions.saveInFile();
                    break;
                case 8:
                    championshipFunctions.loadToFile();
                    break;
                case 9:
                    championshipFunctions.DeleteFormula1TableAndRace();
                    System.out.println("Successfully Deleted All contents Stored");
                    break;
                case 10:
                    System.out.println("Successfully exited the program");
                    exit=true;
                    break;

            }

        }
    }
}
