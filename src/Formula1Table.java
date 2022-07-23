import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


class Formula1TableAndFrame extends JFrame implements ActionListener {
    JFrame frame;
    JPanel driverTabelPanel;
    JPanel raceTablePanel;
    JTable raceTable;
    JPanel searchTablePanel;
    JTable searchTable;
    DefaultTableModel searchTableModel;
    JPanel label1Panel;
    JPanel label2Panel;
    JPanel label3Panel;
    JTable driverTable;
    JButton ascending;
    JButton descending;
    JButton randomRace;
    JButton randomRaceGenerator;
    JButton searchDriver;
    JButton displayRaceStats;
    Formula1ChampionshipManager TempF1Options;
    DefaultTableModel driverTableModel;
    DefaultTableModel raceTableModel;
    JTextField searchTextField;

    // Constructor
    Formula1TableAndFrame( Formula1ChampionshipManager F1Options)
    {
        this.TempF1Options=F1Options;
        driverTabelPanel= new JPanel();
        driverTable= new JTable(driverTableModel);
        driverTableModel =(DefaultTableModel) driverTable.getModel();
        String[] columnNames = { "Driver Name", "Driver Location", "Driver's Team","No. of 1st Place", "No. of 2nd Place", "No. of 3rd Place","No. of Race Participated", "Points earned" };
        driverTableModel.setColumnIdentifiers(columnNames);
        for (int index=0;index<8;index++) {
            driverTable.getColumnModel().getColumn(index).setPreferredWidth(130);
        }
        //Prevent auto resizing
        driverTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for(int i=0;i< F1Options.driversParticipating.size();i++){
            String[] data= new String[8];
            data[0]= F1Options.driversParticipating.get(i).getDriver_Name();
            data[1]=F1Options.driversParticipating.get(i).getDriver_Location();
            data[2]=F1Options.driversParticipating.get(i).getDriver_Team();
            data[3]=Integer.toString(F1Options.driversParticipating.get(i).getNumberOf1stPlace());
            data[4]=Integer.toString(F1Options.driversParticipating.get(i).getNumberOf2ndPlace());
            data[5]=Integer.toString(F1Options.driversParticipating.get(i).getNumberOf3rdPlace());
            data[6]=Integer.toString(F1Options.driversParticipating.get(i).getRacesParticipated());
            data[7]=Integer.toString(F1Options.driversParticipating.get(i).getPointsEarned());
            driverTableModel.addRow(data);
        }
        //Prevent auto resizing
        raceTablePanel= new JPanel();
        raceTable= new JTable(raceTableModel);
        raceTableModel= (DefaultTableModel) raceTable.getModel();
        String[] raceColumnNames={"Race Title","Race Date","Participants","Position"};
        raceTableModel.setColumnIdentifiers(raceColumnNames);
        for (int index=0;index<4;index++) {
            raceTable.getColumnModel().getColumn(index).setPreferredWidth(130);
        }
        raceTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        raceTablePanel.setLayout(new BorderLayout());
        raceTablePanel.setBounds(10,350,510,200);
        raceTablePanel.add(new JScrollPane(raceTable));


        searchTablePanel= new JPanel();
        searchTable=new JTable(searchTableModel);
        searchTableModel=(DefaultTableModel) searchTable.getModel();
        String[] searchColumnNames={"Driver Name","Race Title","Race Date","Driver Position"};
        searchTableModel.setColumnIdentifiers(searchColumnNames);
        for (int i=0;i<4;i++) {
            searchTable.getColumnModel().getColumn(i).setPreferredWidth(130);
        }
        searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        searchTablePanel.setLayout(new BorderLayout());
        searchTablePanel.setBounds(10,650,510,200);
        searchTablePanel.add(new JScrollPane(searchTable));

        label1Panel= new JPanel();
        label2Panel= new JPanel();
        label3Panel= new JPanel();
        JLabel searchLabel= new JLabel("Driver Name");
        JLabel  raceLabel = new JLabel("Race Table");
        JLabel driverLabel = new JLabel("Driver Table");
        frame = new JFrame("Frame");


        label1Panel.add(driverLabel);
        label2Panel.add(raceLabel);
        label3Panel.add(searchLabel);

        searchTextField= new JTextField("Search Driver");
        searchTextField.setBounds(50,600,100,30);



        driverTable.setModel(driverTableModel);
        frame = new JFrame("Frame");
        frame.setLayout(new BorderLayout());
        driverTabelPanel.setLayout(new BorderLayout());
        driverTabelPanel.setBounds(10,50,1000,200);
        driverTabelPanel.add(new JScrollPane(driverTable));

        label2Panel.setBounds(20,300,100,50);
        label1Panel.setBounds(20,200,100,50);
        label3Panel.setBounds(80,600,100,50);

        ascending= new JButton("Ascending");
        ascending.setBounds(1100,50,200,50);
        frame.add(ascending);
        ascending.addActionListener(this);

        descending= new JButton("Descending");
        frame.add(descending);
        descending.setBounds(1100,150,200,50);
        descending.addActionListener(this);

        randomRace= new JButton("Random Race");
        frame.add(randomRace);
        randomRace.setBounds(1100,250,200,50);
        randomRace.addActionListener(this);

        randomRaceGenerator= new JButton("Generate Race");
        frame.add(randomRaceGenerator);
        randomRaceGenerator.setBounds(1100,350,200,50);
        randomRaceGenerator.addActionListener(this);

        displayRaceStats = new JButton("Display Race");
        frame.add(displayRaceStats);
        displayRaceStats.setBounds(1100,450,200,50);
        displayRaceStats.addActionListener(this);

        searchDriver= new JButton("Search Driver");
        frame.add(searchDriver);
        searchDriver.setBounds(1100,550,200,50);
        searchDriver.addActionListener(this);

        frame.add(searchTablePanel);
        frame.add(searchTextField);
        frame.add(driverTabelPanel);
        frame.add(raceTablePanel);
        frame.add(label2Panel);
        frame.add(label1Panel);
        frame.add(label3Panel);
        frame.setSize(1500, 900);
        frame.setVisible(true);
    }


     @Override
     public void actionPerformed(ActionEvent e) {
          if(e.getSource()==ascending){
              AscendByPoints();
              driverTableModel.setRowCount(0);
              changeTableValue();

          }else if(e.getSource()==descending){
              DescendByPoints();
              driverTableModel.setRowCount(0);
              changeTableValue();
          }else if(e.getSource()==randomRace){
              TempF1Options.randomRaceCompleted();
              driverTableModel.setRowCount(0);
              changeTableValue();
          }else if (e.getSource()==randomRaceGenerator) {
              TempF1Options.generateRaceOnProbability();
              driverTableModel.setRowCount(0);
              changeTableValue();
          }else if(e.getSource()==displayRaceStats){
              raceTableModel.setRowCount(0);
              changeRaceTableValue();
          }else if(e.getSource()==searchDriver){
              searchTableModel.setRowCount(0);
              displayDriverInRace();
          }
     }

     public void AscendByPoints(){
         int n = this.TempF1Options.driversParticipating.size();
         Formula1Driver tempF1OptionTransfer;
         for (int i = 0; i < n; i++) {
             for (int j = 1; j < (n - i); j++) {
                 if (this.TempF1Options.driversParticipating.get(j-1).getPointsEarned() > this.TempF1Options.driversParticipating.get(j).getPointsEarned() &&
                         this.TempF1Options.driversParticipating.get(j-1).getPointsEarned() != this.TempF1Options.driversParticipating.get(j).getPointsEarned()){
                     //swap elements

                     tempF1OptionTransfer=this.TempF1Options.driversParticipating.get(j-1);
                     this.TempF1Options.driversParticipating.set(j-1,this.TempF1Options.driversParticipating.get(j));
                     this.TempF1Options.driversParticipating.set(j,tempF1OptionTransfer);

                 }else if (this.TempF1Options.driversParticipating.get(j-1).getNumberOf1stPlace()> this.TempF1Options.driversParticipating.get(j).getNumberOf1stPlace()){

                     tempF1OptionTransfer=this.TempF1Options.driversParticipating.get(j-1);
                     this.TempF1Options.driversParticipating.set(j-1,this.TempF1Options.driversParticipating.get(j));
                     this.TempF1Options.driversParticipating.set(j,tempF1OptionTransfer);

                 }

             }
         }
     }

     public void DescendByPoints(){
         int n = this.TempF1Options.driversParticipating.size();
         Formula1Driver tempF1OptionTransfer;
         for (int i = 0; i < n; i++) {
             for (int j = 1; j < (n - i); j++) {
                 if (this.TempF1Options.driversParticipating.get(j-1).getPointsEarned() < this.TempF1Options.driversParticipating.get(j).getPointsEarned() &&
                         this.TempF1Options.driversParticipating.get(j-1).getPointsEarned() != this.TempF1Options.driversParticipating.get(j).getPointsEarned()){
                     //swap elements
                     tempF1OptionTransfer=this.TempF1Options.driversParticipating.get(j-1);
                     this.TempF1Options.driversParticipating.set(j-1,this.TempF1Options.driversParticipating.get(j));
                     this.TempF1Options.driversParticipating.set(j,tempF1OptionTransfer);

                 }else if (this.TempF1Options.driversParticipating.get(j-1).getNumberOf1stPlace() < this.TempF1Options.driversParticipating.get(j).getNumberOf1stPlace()){

                     tempF1OptionTransfer=this.TempF1Options.driversParticipating.get(j-1);
                     this.TempF1Options.driversParticipating.set(j-1,this.TempF1Options.driversParticipating.get(j));
                     this.TempF1Options.driversParticipating.set(j,tempF1OptionTransfer);


                 }

             }
         }
     }

     public void changeTableValue(){
         for(int i=0;i< TempF1Options.driversParticipating.size();i++){
             String[] data= new String[8];
             data[0]= TempF1Options.driversParticipating.get(i).getDriver_Name();
             data[1]=TempF1Options.driversParticipating.get(i).getDriver_Location();
             data[2]=TempF1Options.driversParticipating.get(i).getDriver_Team();
             data[3]=Integer.toString(TempF1Options.driversParticipating.get(i).getNumberOf1stPlace());
             data[4]=Integer.toString(TempF1Options.driversParticipating.get(i).getNumberOf2ndPlace());
             data[5]=Integer.toString(TempF1Options.driversParticipating.get(i).getNumberOf3rdPlace());
             data[6]=Integer.toString(TempF1Options.driversParticipating.get(i).getRacesParticipated());
             data[7]=Integer.toString(TempF1Options.driversParticipating.get(i).getPointsEarned());
             driverTableModel.addRow(data);
         }
     }
     public void changeRaceTableValue(){
        for(int i=0;i<TempF1Options.raceParticipation.size();i++){
            ArrayList<String> convertString= new ArrayList<>();
            String[] data= new String[4];
            data[0]= TempF1Options.raceParticipation.get(i).getNameOfRace();
            data[1]=TempF1Options.raceParticipation.get(i).getDateOfRace();
            data[2]=String.join(",",TempF1Options.raceParticipation.get(i).getParticipants());
            for(int count=0;count<TempF1Options.raceParticipation.get(i).getPosition().size();count++){
                convertString.add(Integer.toString(TempF1Options.raceParticipation.get(i).getPosition().get(count)));
            }
            data[3]=String.join(",",convertString);
            raceTableModel.addRow(data);
        }
     }
     public void displayDriverInRace(){
        String driverNameToSearch=searchTextField.getText();
        for(int i=0;i<TempF1Options.raceParticipation.size();i++){
            for(int count=0;count<TempF1Options.raceParticipation.get(i).getParticipants().size();count++){
                if(driverNameToSearch.equals(TempF1Options.raceParticipation.get(i).getParticipants().get(count))){
                    String[] data= new String[4];
                    data[0]=TempF1Options.raceParticipation.get(i).getParticipants().get(count);
                    data[1]=TempF1Options.raceParticipation.get(i).getNameOfRace();
                    data[2]=TempF1Options.raceParticipation.get(i).getDateOfRace();
                    data[3]=Integer.toString(TempF1Options.raceParticipation.get(i).getPosition().get(count));
                    searchTableModel.addRow(data);
                }
            }
        }
     }
 }
