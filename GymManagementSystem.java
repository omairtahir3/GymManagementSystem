import java.util.Scanner;
import java.io.*;
public class GymManagementSystem{
    public static void main(String[] args){ 
        //Comment out once to create a file and comment it again
        /*File F1= new File("MemberRegistration.txt");
        try{
            F1.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }
        File F2= new File("Attendance.txt");
        try{
            F2.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }*/
        /*File F2= new File("Schedules.txt");
        try{
            F2.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }*/
        /*File F2= new File("Trainers.txt");
        try{
            F2.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }*/
        /*File F2= new File("TrainerNames.txt");
        try{
            F2.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }*/
        /*File F2= new File("Payments.txt");
        try{
            F2.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }*/
        /*File F2= new File("SuggestionBox.txt");
        try{
            F2.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }*/
        /*File F2= new File("InventoryDetails.txt");
        try{
            F2.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }*/
        MainMenu();
    }
    public static void MainMenu(){
        Scanner input=new Scanner(System.in);
        String option;
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                                GYM MANAGEMENT SYSTEM");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                                     1. MEMBER");
        System.out.println("                                     2. STAFF");
        System.out.println("                                     3. ADMIN");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("YOUR OPTION (1 TO 3): ");
        option=input.nextLine();
        switch (option){
            case "1":
               MemberMenu();
               break;
            case "2":
               StaffLogin();
               break;
            case "3":
               AdminLogin();
               break;
            default: 
               while (!option.equals("1") && !option.equals("2") && !option.equals("3")){
                  System.out.println();
                  System.out.println("----------------------------------------------------------------------------");
                  System.out.println("                        YOU HAVE SELECTED AN INVALID OPTION");
                  System.out.println("----------------------------------------------------------------------------");
                  System.out.print("PLEASE SELECT A VALID OPTION (1 TO 3): ");
                  option=input.nextLine();
                  switch (option){
                     case "1":
                         MemberMenu();
                          break;
                     case "2":
                         StaffLogin();
                         break;
                     case "3":
                         AdminLogin();
                  }
                }
        }
    }
    public static void MemberMenu(){
        Scanner input=new Scanner(System.in);
        String MemberOption;
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                            1. MEMBER REGISTRATIONS");
        System.out.println("                            2. MEMBER LOGIN PORTAL");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("YOUR OPTION (1 OR 2): ");
        MemberOption=input.nextLine();
        switch (MemberOption){
            case "1":
              MemberRegisteration();
              break;
            case "2":
              MemberLogin();
              break;
            default: 
               while (!MemberOption.equals("1") || !MemberOption.equals("2")){
                 System.out.println();
                  System.out.println("----------------------------------------------------------------------------");
                  System.out.println("                        YOU HAVE SELECTED AN INVALID OPTION");
                  System.out.println("----------------------------------------------------------------------------");
                  System.out.print("PLEASE SELECT A VALID OPTION (1 OR 2): ");
                  MemberOption=input.nextLine();
                  switch (MemberOption){
                      case "1":
                          MemberRegisteration();
                          break;
                      case "2":
                          MemberLogin();
                          break;
                    }
                }
        }
    }
    public static void MemberRegisteration(){
        Scanner input=new Scanner(System.in);
        String Name;
        String Age;
        String PhoneNum;
        String Email;
        String MemberPassword;
        String JoiningDate;
        String JoiningMonth;
        String JoiningYear;
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                              MEMBER REGISTRATIONS PORTAL");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("NAME: ");
        Name=input.nextLine();
        System.out.print("AGE: ");
        Age=input.nextLine();
        System.out.print("CONTACT NO: ");
        PhoneNum=input.nextLine();
        System.out.print("EMAIL: ");
        Email=input.nextLine();
        System.out.print("JOINING DATE:");
        JoiningDate=input.nextLine();
        System.out.print("JOINING MONTH:");
        JoiningMonth=input.nextLine();
        System.out.print("JOINING YEAR:");
        JoiningYear=input.nextLine();
        boolean CheckLine=false;
        String []elements;
        File R1= new File("MemberRegistration.txt");
        try{
            Scanner read = new Scanner(R1);
            while(read.hasNextLine()){
                String line=read.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.trim().equals(Email)){
                        System.out.println("Sorry, " + Name);
                        System.out.println("THIS EMAIL HAS ALREADY BEEN REGISTERED!");
                        CheckLine=true;
                        MemberMenu();
                        break;
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
          }
        if (CheckLine==false){
            try{
                System.out.print("PORTAL PASSWORD:");
                MemberPassword=input.nextLine();
                String [] MemberInfo= {Name,Age,PhoneNum,Email,MemberPassword,JoiningDate,JoiningMonth,JoiningYear};
                FileWriter F1 = new FileWriter("MemberRegistration.txt", true);
                BufferedWriter F2= new BufferedWriter(F1);
                F2.write(Name);
                for(int i=1;i<=7;i++){
                    F2.append(",");
                    F2.append(MemberInfo[i]);
                }
                F2.newLine();
                F2.close();
                System.out.print(Name + ", YOU HAVE REGISTERED SUCCESSFULLY!");
            }catch (IOException e){
                    e.printStackTrace();
                }
            }
    }
    public static void MemberLogin(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                              MEMBER LOGIN PORTAL");
        System.out.println("----------------------------------------------------------------------------");
        Scanner input=new Scanner(System.in);
        String Email;
        String Password;
        System.out.print("EMAIL: ");
        Email=input.nextLine();
        String []elements;
        boolean CheckLine=false;
        boolean CheckPass=false;
        File R1= new File("MemberRegistration.txt");
        try{
            Scanner read = new Scanner(R1);
            while(read.hasNextLine()){
                String line=read.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.trim().equals(Email)){
                        CheckLine=true;
                        break;
                    }
                }
            }
            if (CheckLine==true){
                System.out.print("PASSWORD: ");
                Password=input.nextLine();
                try{
                    Scanner reads = new Scanner(R1);
                    while(reads.hasNextLine()){
                        String line=reads.nextLine();
                        elements=line.split(",");
                        for (String element:elements){
                            if (element.trim().equals(Password)){
                                CheckPass=true;
                                break;
                            }
                        }
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                if (CheckPass==true){
                    MemberLoginMenu(Email);

                }
                else{
                    System.out.println("INCORRECT PASSWORD!");
                    MemberLogin();
                }
            }
            else{
                System.out.println("INCORRECT EMAIL!");
                MemberLogin();
            }
        }catch (IOException e){
            e.printStackTrace();
          }
    }
    public static void MemberLoginMenu(String Email){
        Scanner input=new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                      WELCOME");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                   1. ATTENDANCE");
        System.out.println("                                   2. SCHEDULES");
        System.out.println("                                   3. PAYMENTS");
        System.out.println("                                   4. SUGGESTION BOX");
        System.out.println("                                   5. LOG OUT");
        System.out.print("YOUR OPTION (1 TO 5): ");
        String Option=input.nextLine();
        while(!Option.equals("1")&&!Option.equals("2")&&!Option.equals("3")&&!Option.equals("4")&&!Option.equals("5")){
            System.out.println();
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                        YOU HAVE SELECTED AN INVALID OPTION");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                                   1. ATTENDANCE");
            System.out.println("                                   2. SCHEDULES");
            System.out.println("                                   3. PAYMENTS");
            System.out.println("                                   4. SUGGESTION BOX");
            System.out.println("                                   5. LOG OUT");
            System.out.print("PLEASE SELECT A VALID OPTION (1 TO 5): ");
            Option=input.nextLine();
        }
        switch(Option){
            case "1":
             Attendance(Email);
             break;
            case "2":
             Trainers(Email);
             break;
            case "3":
             MemberPayments(Email);
             break;
            case "4":
             MemberSuggestionBox(Email);
             break;
            case "5":
             MemberLogOut(Email);
             break;
        }
    }
    public static void Attendance(String Email){
        String []elements;
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                      ATTENDANCE");
        System.out.println("----------------------------------------------------------------------------");
        File R1= new File("Attendance.txt");
        try{
            Scanner read = new Scanner(R1);
            System.out.println("  DATE\t\tATTENDANCE");
            while(read.hasNextLine()){
                String line=read.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.trim().equals(Email)){
                        String date=elements[1];
                        String date1=elements[2];
                        String date2=elements[3];
                        String attendance=elements[4];
                        System.out.println(date+"/"+date1+"/"+date2+ "\t "+ attendance);

                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
          }
        MemberLoginMenu(Email);
    }
    public static void Trainers(String Email){
        boolean CheckEmail=false;
        Scanner input =new Scanner(System.in);
        String []elements;
        File R2= new File("Trainers.txt");
        try{
            Scanner read = new Scanner(R2);
            while(read.hasNextLine()){
                String line=read.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.trim().equals(Email)){
                        CheckEmail=true;
                        break;
                    }
                }
            }
            if (CheckEmail==false){
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("                                  OUR TRAINERS");
                System.out.println("----------------------------------------------------------------------------");
                File R3= new File("TrainerNames.txt");
                int count=1;
                String []elements1;
                try{
                    Scanner read1 = new Scanner(R3);
                    while(read1.hasNextLine()){
                        String line=read1.nextLine();
                        elements=line.split(",");
                        System.out.println("                                  "+count+".MR "+elements[1]);
                        count=count+1;
                    }
                    System.out.print("SELECT YOUR TRAINER (ENTER NAME): ");
                    String Trainer=input.nextLine();
                    boolean CheckTrainer=false;
                    File R4= new File("TrainerNames.txt");
                    try{
                        Scanner read2 = new Scanner(R4);
                        while(read2.hasNextLine()){
                            String line=read2.nextLine();
                            elements1=line.split(",");
                            if (Trainer.toUpperCase().equals(elements1[2])){
                                CheckTrainer=true;
                                break;
                            }
                        }               
                        if (CheckTrainer==true){
                            try{
                              FileWriter F1 = new FileWriter("Trainers.txt", true);
                              BufferedWriter F2= new BufferedWriter(F1);
                              F2.write(Email);
                              F2.append(",");
                              F2.append(Trainer.toUpperCase());
                              F2.newLine();
                              F2.close();
                            }catch(IOException e){
                               e.printStackTrace();
                            }
                            System.out.println("TRAINER SUCCESSFULLY UPDATED!");
                            MemberLoginMenu(Email);
                        }
                        else{
                           System.out.println("INVALID TRAINER SELECTED!");
                           Trainers(Email);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            else{
                String[]elements1;
                String Trainer;
                File R4= new File("Trainers.txt");
                try{
                    Scanner read2 = new Scanner(R4);
                    while(read2.hasNextLine()){
                        String line=read2.nextLine();
                        elements1=line.split(",");
                        for (String element:elements1){
                            if (element.trim().equals(Email)){
                                Trainer=elements1[1];
                                Schedules(Email,Trainer);
                                break;
                            }
                        }
                    } 
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void Schedules(String Email,String Trainer){
        boolean Booked=false;
        String []elements;
        Scanner input=new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                      SCHEDULES");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                1. AVAILIBLE TIME SLOTS");
        System.out.println("                                2. BOOKINGS");
        System.out.print("YOUR OPTION (1 OR 2): ");
        String option=input.nextLine();
        while (!option.equals("1")&&!option.equals("2")){
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                                      SCHEDULES");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                                1. AVAILIBLE TIME SLOTS");
            System.out.println("                                2. BOOKINGS");
            System.out.print("YOUR OPTION (1 OR 2): ");
            option=input.nextLine();
        }
        switch (option){
            case "1":
              System.out.println("----------------------------------------------------------------------------");
              System.out.println("                                      GYM TIMINGS");
              System.out.println("----------------------------------------------------------------------------");
              System.out.println("                                     9:00 TO 22:00");
              System.out.println("                             YOU CAN BOOK FOR 1 HOURS ONLY");
              System.out.print("SELECT YOUR TIME SLOT: ");
              String TimeSlot=input.nextLine();
              System.out.print("DATE (DD/MM/YY): ");
              String []Date=input.nextLine().split("/");
              while ((Integer.valueOf(TimeSlot)<900&&Integer.valueOf(TimeSlot)>2200)||(Integer.valueOf(TimeSlot)!=900&&Integer.valueOf(TimeSlot)!=1000&&Integer.valueOf(TimeSlot)!=1100&&Integer.valueOf(TimeSlot)!=1200&&Integer.valueOf(TimeSlot)!=1300&&Integer.valueOf(TimeSlot)!=1400&&Integer.valueOf(TimeSlot)!=1500&&Integer.valueOf(TimeSlot)!=1600&&Integer.valueOf(TimeSlot)!=1700&&Integer.valueOf(TimeSlot)!=1800&&Integer.valueOf(TimeSlot)!=1900&&Integer.valueOf(TimeSlot)!=2000&&Integer.valueOf(TimeSlot)!=2100&&Integer.valueOf(TimeSlot)!=2200)){
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("                        YOU HAVE SELECTED AN INVALID OPTION");
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("                             PLEASE SELECT A VALID OPTION");
                System.out.print("SELECT YOUR TIME SLOT: ");
                TimeSlot=input.nextLine();
                System.out.print("DATE (DD/MM/YY): ");
                Date=input.nextLine().split("/");
              }
              File R1= new File("Schedules.txt");
              try{
                Scanner read1 = new Scanner(R1);
                while(read1.hasNextLine()){
                    String line=read1.nextLine();
                    elements=line.split(",");
                    for (String element:elements){
                        if (element.trim().equals(Date[0])){
                            for (String element1:elements){
                                if (element1.trim().equals(Date[1])){
                                    for (String element2:elements){
                                        if (element2.trim().equals(Date[2])){
                                            for (String element3:elements){
                                              if (element3.trim().equals(TimeSlot)){
                                                  for (String element4:elements){
                                                      if(element4.trim().equals(Trainer)){
                                                         Booked=true;
                                                         break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (Booked==true){
                    System.out.println("THIS TIME SLOT IS ALREADY BOOKED WITH MR. " +Trainer);
                    System.out.println("                              LOADING BACK TO SCHEDULES...");
                    Schedules(Email, Trainer);
                }
                else{
                    try{
                        int End=Integer.valueOf(TimeSlot)+59;
                        String EndTime=String.valueOf(End);
                        FileWriter F1 = new FileWriter("Schedules.txt", true);
                        BufferedWriter F2= new BufferedWriter(F1);
                        F2.write(Email);
                        F2.append(",");
                        F2.append(Date[0]);
                        F2.append(",");
                        F2.append(Date[1]);
                        F2.append(",");
                        F2.append(Date[2]);
                        F2.append(",");
                        F2.append(TimeSlot);
                        F2.append(",");
                        F2.append(EndTime);
                        F2.append(",");
                        F2.append(Trainer.toUpperCase());
                        F2.newLine();
                        F2.close();
                        System.out.println("BOOKING ADDED SUCCESSFULLY!");
                        MemberLoginMenu(Email);
                      }catch(IOException e){
                         e.printStackTrace();
                      }

                }
               }catch (IOException e){
                   e.printStackTrace();
               }
            case "2":
             File R2= new File("Schedules.txt");
             try{
                 Scanner read = new Scanner(R2);
                 System.out.println("   DATE"+"\t\t"+"  TIME"+"\t\t"+"TRAINER");
                 while(read.hasNextLine()){
                     String line=read.nextLine();
                     elements=line.split(",");
                     for (String element:elements){
                         if (element.trim().equals(Email)){
                             String date=elements[1];
                             String date1=elements[2];
                             String date2=elements[3];
                             String start=elements[4];
                             String end=elements[5];
                             String trainer=elements[6];
                             System.out.println(date + "/"+ date1+"/"+date2+"\t"+start+" to "+end+"\t"+trainer);
    
                        }
                    }
                }
              }catch (IOException e){
                e.printStackTrace();
              }
              MemberLoginMenu(Email);
              break;
        }
    }
    public static void MemberPayments(String Email){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                     PAYMENTS");
        System.out.println("----------------------------------------------------------------------------");
        String []elements;
        String []Date;
        boolean PaidCheck=false;
        File R4= new File("MemberRegistration.txt");
        try{
            Scanner read1 = new Scanner(R4);
            while(read1.hasNextLine()){
                String line=read1.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.equals(Email)){
                        System.out.println("                           YOUR JOINING DATE IS: "+elements[5]+"/"+elements[6]+"/"+elements[7]);
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        Scanner input=new Scanner(System.in);
        System.out.println("                       CHECK YOUR MONTHLY PAYMENTS ACCORDINGLY!");
        System.out.print("DATE (DD/MM/YYYY): ");
        Date=input.nextLine().split("/");
        File R1= new File("Payments.txt");
        try{
            Scanner read1 = new Scanner(R1);
            while(read1.hasNextLine()){
                String line=read1.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.trim().equals(Email)){
                        for (String element1:elements){
                            if (element1.trim().equals(Date[0])){
                                for (String element2:elements){
                                    if (element2.trim().equals(Date[1])){
                                        for (String element3:elements){
                                          if (element3.trim().equals(Date[2])){
                                                PaidCheck=true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (PaidCheck==true){
                System.out.println("YOUR FEES FOR THE MONTH "+Date[0]+"/"+Date[1]+"/"+Date[2]+" IS PAID!");
                MemberLoginMenu(Email);
            }
            else{
                System.out.println("YOUR FEES IS UNPAID FOR THE MONTH "+Date[0]+"/"+Date[1]+"/"+Date[2]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void MemberSuggestionBox(String Email){
        Scanner input=new Scanner(System.in);
        String Suggestion;
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                  SUGGESTION BOX");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("ENTER YOUR SUGGESTION: ");
        Suggestion=input.nextLine();
        try{
            FileWriter F1 = new FileWriter("SuggestionBox.txt", true);
            BufferedWriter F2= new BufferedWriter(F1);
            F2.write(Email);
            F2.write(",");
            F2.write(Suggestion);
            F2.newLine();
            F2.close();
          }catch(IOException e){
             e.printStackTrace();
          }
        System.out.println("THANKYOU FOR ADDING YOUR VALUEABLE SUGGESTION!");
        MemberLoginMenu(Email);
    }
    public static void MemberLogOut(String Email){
        System.out.println("LOGGED OUT SUCCESSFULLY!");
        MemberLogin();
    }
    public static void AdminLogin(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                              ADMIN LOGIN PORTAL");
        System.out.println("----------------------------------------------------------------------------");
        Scanner input=new Scanner(System.in);
        String Email;
        String Password;
        System.out.print("EMAIL: ");
        Email=input.nextLine();
        String AdminEmail="gymadmin@gmail.com";
        String AdminPass="gymadmin123*";
        if (Email.equals(AdminEmail)){
            System.out.print("PASSWORD:");
            Password=input.nextLine();
            if (Password.equals(AdminPass)){
                AdminMenu();
            }
            else{
                System.out.println("INVALID PASSWORD!");
                AdminLogin();
            }
        }
        else{
            System.out.println("INVALID EMAIL!");
            AdminLogin();
        }

    }
    public static void AdminMenu(){
        Scanner input=new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                      WELCOME");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                   1. STAFF REGISTRATIONS");
        System.out.println("                                   2. GYM REPORTS");
        System.out.println("                                   3. LOG OUT");
        System.out.print("YOUR OPTION (1 TO 3): ");
        String Option=input.nextLine();
        while(!Option.equals("1")&&!Option.equals("2")&&!Option.equals("3")){
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                        YOU HAVE SELECTED AN INVALID OPTION");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                                   1. STAFF REGISTRATIONS");
            System.out.println("                                   2. GYM REPORTS");
            System.out.println("                                   3. LOG OUT");
            System.out.print("PLEASE SELECT A VALID OPTION (1 TO 3): ");
            Option=input.nextLine();
        }
        switch(Option){
            case "1":
             StaffRegisteration();
             break;
            case "2":
             GymReports();
             break;
            case "3":
             AdminLogOut();
             break;
        }
    }
    public static void GymReports(){
        Scanner input=new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                       REPORTS");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                   1. MEMBER REPORTS");
        System.out.println("                                   2. STAFF REPORTS");
        System.out.println("                                   3. ATTENDANCE REPORTS");
        System.out.println("                                   4. SCHEDULES REPORTS");
        System.out.println("                                   5. PAYMENT REPORTS");
        System.out.println("                                   6. INVENTORY REPORTS");
        System.out.print("PLEASE SELECT A OPTION (1 TO 6): ");
        String Option=input.nextLine();
        while(!Option.equals("1")&&!Option.equals("2")&&!Option.equals("3")&&!Option.equals("4")&&!Option.equals("5")&&!Option.equals("6")){
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                        YOU HAVE SELECTED AN INVALID OPTION");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                                   1. MEMBER REPORTS");
            System.out.println("                                   2. STAFF REPORTS");
            System.out.println("                                   3. ATTENDANCE REPORTS");
            System.out.println("                                   4. SCHEDULES REPORTS");
            System.out.println("                                   5. PAYMENT REPORTS");
            System.out.println("                                   6. INVENTORY REPORTS");
            System.out.print("PLEASE SELECT A OPTION (1 TO 6): ");
            Option=input.nextLine();
        }
        switch(Option){
            case "1":
             MemberReports();
             break;
            case "2":
             StaffReports();
             break;
            case "3":
             AttendanceReports();
             break;
            case "4":
             ScheduleReports();
             break;
            case "5":
             PaymentReports();
             break;
            case "6":
             InventoryReports();
             break;
        }

    }
    public static void MemberReports(){
        String []elements;
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("                                            MEMBER REPORTS");
        System.out.println("------------------------------------------------------------------------------------------------");
        File R1= new File("MemberRegistration.txt");
        try{
            Scanner read = new Scanner(R1);
            System.out.println("   NAME\t\tMEMBER AGE\tMEMBER PHONE NUMBER\t   MEMBER EMAIL\t\tJOINING DATE");
            while(read.hasNextLine()){
                String line=read.nextLine();
                elements=line.split(",");
                String Name=elements[0];
                String Age=elements[1];
                String PhoneNo=elements[2];
                String Email=elements[3];
                String JoiningDate1=elements[5];
                String JoiningDate2=elements[6];
                String JoiningDate3=elements[7];
                System.out.println(Name+"\t"+"    "+Age+"\t\t    "+PhoneNo+ "\t        "+Email+"\t "+JoiningDate1+"/"+JoiningDate2+"/"+JoiningDate3);
            }
        
        }catch (IOException e){
            e.printStackTrace();
        }
        AdminMenu();
    }
    public static void StaffReports(){
        String []elements;
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("                                            STAFF REPORTS");
        System.out.println("------------------------------------------------------------------------------------------------");
        File R1= new File("TrainerNames.txt");
        try{
            Scanner read = new Scanner(R1);
            System.out.println("\t\t\t\t    NAME\t\t           STAFF EMAIL");
            while(read.hasNextLine()){
                String line=read.nextLine();
                elements=line.split(",");
                String Name=elements[2];
                String Email=elements[0];
                System.out.println("\t\t\t\t"+Name+"\t\t\t"+Email);
            }
        
        }catch (IOException e){
            e.printStackTrace();
        }
        AdminMenu();
    }
    public static void AttendanceReports(){
        String []elements;
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("                                            ATTENDANCE REPORTS");
        System.out.println("------------------------------------------------------------------------------------------------");
        File R1= new File("Attendance.txt");
        try{
            Scanner read = new Scanner(R1);
            System.out.println("\t\t\t  MEMBER EMAIL\t\t   DATE\t\tATTENDANCE");
            while(read.hasNextLine()){
                String line=read.nextLine();
                elements=line.split(",");
                String Attendance=elements[4];
                String Email=elements[0];
                String Date1=elements[1];
                String Date2=elements[2];
                String Date3=elements[3];
                System.out.println("\t\t\t"+Email+"\t"+Date1+"/"+Date2+"/"+Date3+"\t "+Attendance);
            }
        
        }catch (IOException e){
            e.printStackTrace();
        }
        AdminMenu();
    }
    public static void ScheduleReports(){
        String []elements;
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("                                            SCHEDULE REPORTS");
        System.out.println("------------------------------------------------------------------------------------------------");
        File R1= new File("Schedules.txt");
        try{
            Scanner read = new Scanner(R1);
            System.out.println("                     EMAIL\t\t  DATE\t\tSLOT TIME\tTRAINER NAME");
            while(read.hasNextLine()){
                String line=read.nextLine();
                elements=line.split(",");
                String Email=elements[0];
                String Date1=elements[1];
                String Date2=elements[2];
                String Date3=elements[3];
                String Slot1=elements[4];
                String Slot2=elements[5];
                String Trainer=elements[6];
                System.out.println("\t\t"+Email+"\t"+Date1+"/"+Date2+"/"+Date3+"\t"+Slot1+" to "+Slot2+ "\t  "+Trainer);
            }
        
        }catch (IOException e){
            e.printStackTrace();
        }
        AdminMenu();
    }
    public static void PaymentReports(){
        String []elements;
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("                                            PAYMENT REPORTS");
        System.out.println("------------------------------------------------------------------------------------------------");
        File R1= new File("Payments.txt");
        try{
            Scanner read = new Scanner(R1);
            System.out.println("\t\t\t  MEMBER EMAIL\t\t   DATE\t\tPAYMENT STATUS");
            while(read.hasNextLine()){
                String line=read.nextLine();
                elements=line.split(",");
                String Payment=elements[4];
                String Email=elements[0];
                String Date1=elements[1];
                String Date2=elements[2];
                String Date3=elements[3];
                System.out.println("\t\t\t"+Email+"\t"+Date1+"/"+Date2+"/"+Date3+"\t     "+Payment);
            }
        
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void InventoryReports(){
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("                                           INVENTORY REPORTS");
        System.out.println("------------------------------------------------------------------------------------------------");
        File R1= new File("InventoryDetails.txt");
        Scanner input=new Scanner(System.in);
        System.out.println("                                            PRESENT RECORD ");
        System.out.println("    TRAINER\t     TREADMILLS\t    DUMBELLS\t BENCHES\tBARBELLS\tRESISTANCE BANDS");
        try{
            Scanner read1 = new Scanner(R1);
            String []elements;
            String Latest="";
            String line="";
            while (read1.hasNextLine())
            {
                line=read1.nextLine();
                Latest=line;
            }
            elements=Latest.split(","); 
            System.out.println(elements[0]+"       "+elements[1]+"             "+elements[2]+"            "+elements[3]+"              "+elements[4]+"                   "+elements[5]);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("                            THIS IS THE LASTEST REPORT ON INVENTORY! ");
        AdminMenu();
    }
    public static void AdminLogOut(){
        System.out.println("LOGGED OUT SUCCESSFULLY!");
        AdminLogin();
    }
    public static void StaffRegisteration(){
        Scanner input=new Scanner(System.in);
        String StaffName;
        String StaffEmail;
        String StaffPassword;
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                              STAFF REGISTRATIONS PORTAL");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("NAME: ");
        StaffName=input.nextLine().toUpperCase();
        System.out.print("EMAIL: ");
        StaffEmail=input.nextLine();
        boolean CheckLine=false;
        String []elements;
        File R1= new File("TrainerNames.txt");
        try{
            Scanner read = new Scanner(R1);
            while(read.hasNextLine()){
                String line=read.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.trim().equals(StaffEmail)){
                        System.out.println("THIS EMAIL HAS ALREADY BEEN REGISTERED!");
                        CheckLine=true;
                        AdminMenu();
                        break;
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
          }
        if (CheckLine==false){
            try{
                System.out.print("PORTAL PASSWORD:");
                StaffPassword=input.nextLine();
                String [] StaffInfo= {StaffEmail,StaffPassword,StaffName};
                FileWriter F1 = new FileWriter("TrainerNames.txt", true);
                BufferedWriter F2= new BufferedWriter(F1);
                F2.write(StaffEmail);
                for(int i=1;i<=2;i++){
                    F2.append(",");
                    F2.append(StaffInfo[i]);
                }
                F2.newLine();
                F2.close();
                System.out.print(StaffName + " REGISTERED SUCCESSFULLY!");
            }catch (IOException e){
                    e.printStackTrace();
                }
            }
    }
    public static void StaffLogin(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                              STAFF LOGIN PORTAL");
        System.out.println("----------------------------------------------------------------------------");
        Scanner input=new Scanner(System.in);
        String TrainerEmail;
        String Password;
        System.out.print("EMAIL: ");
        TrainerEmail=input.nextLine();
        String []elements;
        boolean CheckLine=false;
        boolean CheckPass=false;
        File R1= new File("TrainerNames.txt");
        try{
            Scanner read = new Scanner(R1);
            while(read.hasNextLine()){
                String line=read.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.trim().equals(TrainerEmail)){
                        CheckLine=true;
                        break;
                    }
                }
            }
            if (CheckLine==true){
                System.out.print("PASSWORD: ");
                Password=input.nextLine();
                try{
                    Scanner reads = new Scanner(R1);
                    while(reads.hasNextLine()){
                        String line=reads.nextLine();
                        elements=line.split(",");
                        for (String element:elements){
                            if (element.trim().equals(Password)){
                                CheckPass=true;
                                break;
                            }
                        }
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                if (CheckPass==true){
                    System.out.print("NAME (FOR VERIFICATION):");
                    String StaffName=input.nextLine().toUpperCase();
                    boolean CheckName=false;
                    try{
                        Scanner read1 = new Scanner(R1);
                        while(read1.hasNextLine()){
                            String line=read1.nextLine();
                            elements=line.split(",");
                            for (String element:elements){
                                if (element.trim().equals(StaffName)){
                                    CheckName=true;
                                    break;
                                }
                            }
                        }
                        if (CheckName==false){
                            System.out.println("INVALID NAME ENTERED!");
                            StaffLogin();
                        }
                        else{
                            StaffLoginMenu(TrainerEmail,StaffName);
                        }
                    }catch(IOException e){
                        e.printStackTrace();  
                    }

                }
                else{
                    System.out.println("INCORRECT PASSWORD!");
                    StaffLogin();
                }
            }
            else{
                System.out.println("INCORRECT EMAIL!");
                StaffLogin();
            }
        }catch (IOException e){
            e.printStackTrace();
          }
    }
    public static void StaffLoginMenu(String TrainerEmail,String StaffName){
        Scanner input=new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                      WELCOME");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                   1. ATTENDANCE");
        System.out.println("                                   2. SCHEDULES");
        System.out.println("                                   3. PAYMENTS");
        System.out.println("                                   4. INVENTORY");
        System.out.println("                                   5. SUGGESTION BOX");
        System.out.println("                                   6. LOG OUT");
        System.out.print("YOUR OPTION (1 TO 6): ");
        String Option=input.nextLine();
        while(!Option.equals("1")&&!Option.equals("2")&&!Option.equals("3")&&!Option.equals("4")&&!Option.equals("5")&&!Option.equals("6")){
            System.out.println();
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                        YOU HAVE SELECTED AN INVALID OPTION");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                                   1. ATTENDANCE");
            System.out.println("                                   2. SCHEDULES");
            System.out.println("                                   3. PAYMENTS");
            System.out.println("                                   4. INVENTORY");
            System.out.println("                                   5. REPORTS");
            System.out.println("                                   6. LOG OUT");
            System.out.print("PLEASE SELECT A VALID OPTION (1 TO 6): ");
            Option=input.nextLine();
        }
        switch(Option){
            case "1":
             StaffAttendance(TrainerEmail,StaffName);
             break;
            case "2":
             StaffSchedules(TrainerEmail, StaffName);
             break;
            case "3":
             StaffPayments(TrainerEmail,StaffName);
             break;
            case "4":
             Inventory(TrainerEmail,StaffName);
             break;
            case "5":
             StaffSuggestionBox(TrainerEmail, StaffName);
             break;
            case "6":
             StaffLogOut();
             break;
        }
    }
    public static void StaffAttendance(String TrainerEmail,String StaffName){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                      YOUR MEMBERS");
        System.out.println("----------------------------------------------------------------------------");
        File R3= new File("Trainers.txt");
        int count=1;
        String []elements;
        String Email;
        String []Date;
        String Attendance;
        boolean AttendanceMarked=false;
        try{
            Scanner read1 = new Scanner(R3);
            while(read1.hasNextLine()){
                String line=read1.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.equals(StaffName)){
                        System.out.println("                                  "+count+". "+elements[0]);
                        count=count+1;
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();  
        }
        Scanner input =new Scanner(System.in);
        System.out.print("ATTENDANCE OF (EMAIL): ");
        Email=input.nextLine();
        System.out.print("DATE (DD/MM/YYYY): ");
        Date=input.nextLine().split("/");
        System.out.print("MARK ATTENDANCE (Present/Absent):");
        Attendance=input.nextLine();
        File R1= new File("Attendance.txt");
        try{
            Scanner read1 = new Scanner(R1);
            while(read1.hasNextLine()){
                String line=read1.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.trim().equals(Email)){
                        for (String element1:elements){
                            if (element1.trim().equals(Date[0])){
                                for (String element2:elements){
                                    if (element2.trim().equals(Date[1])){
                                        for (String element3:elements){
                                          if (element3.trim().equals(Date[2])){
                                                AttendanceMarked=true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (AttendanceMarked==true){
                System.out.println("THIS ATTENDANCE IS ALREADY MARKED!");
                System.out.println("                              LOADING BACK...");
                StaffLoginMenu(TrainerEmail, StaffName);
            }
            else{
                try{
                    FileWriter F1 = new FileWriter("Attendance.txt", true);
                    BufferedWriter F2= new BufferedWriter(F1);
                    F2.write(Email);
                    F2.append(",");
                    F2.append(Date[0]);
                    F2.append(",");
                    F2.append(Date[1]);
                    F2.append(",");
                    F2.append(Date[2]);
                    F2.append(",");
                    F2.append(Attendance);
                    F2.newLine();
                    F2.close();
                    System.out.println("ATTENDANCE ADDED SUCCESSFULLY!");
                    StaffLoginMenu(TrainerEmail,StaffName);
                  }catch(IOException e){
                     e.printStackTrace();
                  }

            }
           }catch (IOException e){
               e.printStackTrace();
           }
    }
    public static void StaffSchedules(String TrainerEmail,String StaffName){
        String []elements;
        String Email;
        String Date;
        String Date1;
        String Date2;
        String StartTime;
        String EndTime;
        File R1= new File("Schedules.txt");
        try{
            System.out.println("     MEMBER\t\t   DATE\t\tSTART TIME\tEND TIME");
            Scanner read1 = new Scanner(R1);
            while(read1.hasNextLine()){
                String line=read1.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.trim().equals(StaffName)){
                       Email=elements[0];
                       Date=elements[1];
                       Date1=elements[2];
                       Date2=elements[3];
                       StartTime=elements[4];
                       EndTime=elements[5];
                       System.out.println(Email+"\t"+Date+"/"+Date1+"/"+Date2+"\t"+"   "+StartTime+"\t"+"          "+EndTime);
                    }
                }
            }
            StaffLoginMenu(TrainerEmail, StaffName);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void StaffPayments(String TrainerEmail,String StaffName){
        Scanner input= new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                                      YOUR MEMBERS");
        System.out.println("----------------------------------------------------------------------------");
        File R3= new File("Trainers.txt");
        int count=1;
        String []elements;
        String Email;
        String []Date;
        String Paid="Paid";
        boolean paymentcheck=false;
        try{
            Scanner read1 = new Scanner(R3);
            while(read1.hasNextLine()){
                String line=read1.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.equals(StaffName)){
                        System.out.println("                                  "+count+". "+elements[0]);
                        count=count+1;
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();  
        }
        System.out.print("PAYMENT OF (EMAIL): ");
        Email=input.nextLine();
        File R4= new File("MemberRegistration.txt");
        try{
            Scanner read1 = new Scanner(R4);
            while(read1.hasNextLine()){
                String line=read1.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.equals(Email)){
                        System.out.println("               JOINING DATE OF "+Email+" IS: "+elements[5]+"/"+elements[6]+"/"+elements[7]);
                    }
                }
            }
            System.out.println("                       ENTER THE MONTHLY PAID PAYMENTS ACCORDINGLY!");
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.print("DATE (DD/MM/YYYY): ");
        Date=input.nextLine().split("/");
        File R1= new File("Payments.txt");
        try{
            Scanner read1 = new Scanner(R1);
            while(read1.hasNextLine()){
                String line=read1.nextLine();
                elements=line.split(",");
                for (String element:elements){
                    if (element.trim().equals(Email)){
                        for (String element1:elements){
                            if (element1.trim().equals(Date[0])){
                                for (String element2:elements){
                                    if (element2.trim().equals(Date[1])){
                                        for (String element3:elements){
                                          if (element3.trim().equals(Date[2])){
                                                paymentcheck=true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (paymentcheck==true){
                System.out.println("THIS PAYMENT IS ALREADY UPDATED!");
                System.out.println("                              LOADING BACK...");
                StaffLoginMenu(TrainerEmail, StaffName);
            }
            else{
                try{
                    FileWriter F1 = new FileWriter("Payments.txt", true);
                    BufferedWriter F2= new BufferedWriter(F1);
                    F2.write(Email);
                    F2.append(",");
                    F2.append(Date[0]);
                    F2.append(",");
                    F2.append(Date[1]);
                    F2.append(",");
                    F2.append(Date[2]);
                    F2.append(",");
                    F2.append(Paid);
                    F2.newLine();
                    F2.close();
                    System.out.println("PAYMENT ADDED SUCCESSFULLY!");
                    StaffLoginMenu(TrainerEmail,StaffName);
                  }catch(IOException e){
                     e.printStackTrace();
                  }

            }
           }catch (IOException e){
               e.printStackTrace();
           }
    }
    public static void Inventory(String TrainerEmail,String StaffName){
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("                                           INVENTORY");
        System.out.println("------------------------------------------------------------------------------------------------");
        File R1= new File("InventoryDetails.txt");
        Scanner input=new Scanner(System.in);
        System.out.println("                                            PRESENT RECORD ");
        System.out.println("    TRAINER\t     TREADMILLS\t    DUMBELLS\t BENCHES\tBARBELLS\tRESISTANCE BANDS");
        try{
            Scanner read1 = new Scanner(R1);
            String []elements;
            String Latest="";
            String line="";
            while (read1.hasNextLine())
            {
                line=read1.nextLine();
                Latest=line;
            }
            elements=Latest.split(","); 
            System.out.println(elements[0]+"       "+elements[1]+"             "+elements[2]+"            "+elements[3]+"              "+elements[4]+"                   "+elements[5]);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("ENTER THE CURRENT INVENTORY STATUS(P/A)");
        System.out.print("TREADMILLS:");
        String TreadMill=input.nextLine();
        System.out.print("DUMBBELLS:");
        String DumbBell =input.nextLine();
        System.out.print("BENCHES: ");
        String Bench=input.nextLine();
        System.out.print("BARBELLS: ");
        String Barbell=input.nextLine();
        System.out.print("RESISTANCE BANDS: ");
        String Band=input.nextLine();
        try{
            FileWriter F1 = new FileWriter("InventoryDetails.txt");
            BufferedWriter F2= new BufferedWriter(F1);
            F2.append(TrainerEmail);
            F2.append(",");
            F2.write(TreadMill);
            F2.append(",");
            F2.append(DumbBell);
            F2.append(",");
            F2.append(Bench);
            F2.append(",");
            F2.append(Barbell);
            F2.append(",");
            F2.append(Band);
            F2.newLine();
            F2.close();
            System.out.println("INVENTORY UPDATED SUCCESSFULLY!");
            StaffLoginMenu(TrainerEmail,StaffName);
          }
          catch(IOException e){
             e.printStackTrace();
          }

    }
    public static void StaffSuggestionBox(String TrainerEmail,String StaffName){
        String []elements;
        File R3= new File("SuggestionBox.txt");
        try{
            Scanner read1 = new Scanner(R3);
            while(read1.hasNextLine()){
                String line=read1.nextLine();
                elements=line.split(",");
                System.out.println(elements[0]+" has suggested "+elements[1]);
            }
        }catch(IOException e){
            e.printStackTrace();  
        }
        StaffLoginMenu(TrainerEmail,StaffName);
    }
    public static void StaffLogOut(){
        System.out.println("LOGGED OUT SUCCESSFULLY!");
        StaffLogin();
    }
}