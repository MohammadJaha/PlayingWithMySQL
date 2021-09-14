/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freereport;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author miro_
 */
public class FreeReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LogIns logo=new LogIns();
        logo.setVisible(true);
       
        
        /*
        
        
        Testing The Program Without Frames
        
        
        Admin ad=new Admin();
        Acc ac=new Acc();
        Scanner sc=new Scanner(System.in);
        sc.useLocale(Locale.UK);
        // TODO code application logic here
        for( ; ; ){
            try{
                System.out.println("Enter 1 to LogIn or 0 to Close: ");
                sc=new Scanner(System.in);
                sc.useLocale(Locale.UK);
                int login=sc.nextInt();
                if (login==1){
                    for( ; ; ){
                        System.out.println("Enter User Name:");
                        String name=sc.next();
                        System.out.println("Enter User Password:");
                        String Pass=sc.next();
                        if (ad.CK(name, Pass)){
                            //يمكن كتابة جميع الأكواد في الداخل
                            System.out.println("Entered As Admin");
                            System.out.println("Welcome "+ad.nameo());
                            for( ; ; ){
                                try{
                                    System.out.println("Enter:\n1 to Search Accountants,\n"
                                            + "2 to Add New Accountant,\n"
                                            + "3 to Edit an Accountant,\n"
                                            + "4 to Delete an Accountant,\n"
                                            + "5 to View All Accountants"
                                            + "\nor 0 to logout");
                                    sc=new Scanner(System.in);
                                    sc.useLocale(Locale.UK);
                                    int a=sc.nextInt();
                                    if (a==1){
                                        System.out.println("Enter 1 to Search by Accountant ID"
                                                + " or 2 to Search by Accountant Name");
                                        int c=sc.nextInt();
                                        if(c==1){
                                            System.out.println("Enter Accountant ID");
                                            int AcUser=sc.nextInt();
                                            System.out.println(ad.AcInfo(AcUser));
                                        }
                                        else if(c==2){
                                            System.out.println("Enter Accountant First Name");
                                            String AcUser=sc.next();
                                            System.out.println(ad.AcInfo(AcUser));
                                        }
                                        else
                                            System.out.println("Wrong Input");
                                    }
                                    else if (a==2){
                                        System.out.println("Enter Accountant First Name:");
                                        String N1=sc.next();
                                        System.out.println("Enter Accountant Last Name:");
                                        String N2=sc.next();
                                        System.out.println("Enter Accountant UserName:");
                                        String N3=sc.next();
                                        System.out.println("Enter Acountant Password:");
                                        String N4=sc.next();
                                        System.out.println("Accountant ID: "+ad.newac(N1, N2, N3, N4)
                                                +"\nName: "+N1+
                                                " "+N2+"\n"
                                                        + " Was Added");
                                    }
                                    else if(a==3){
                                        System.out.println("Enter Accountant ID");
                                        int id=sc.nextInt();
                                        int ck=ad.chickac(id);
                                        if (ck==1){
                                            System.out.println("You Will Edit This Accountant Information:\n"
                                                + ad.AcInfo(id));
                                            System.out.println("Enter Accoutant First Name:");
                                            String N1=sc.next();
                                            System.out.println("Enter Accountant Last Name:");
                                            String N2=sc.next();
                                            System.out.println(ad.editac(id,N1, N2));
                                        }
                                        else
                                            System.out.println("Accountatn is not Excest");
                                    }
                                    else if(a==4){
                                        System.out.println("Enter Accountant ID");
                                        int id=sc.nextInt();
                                        int ck=ad.chickac(id);
                                        if(ck==1){
                                            System.out.println("You Will Delete This Accountant Information:\n"
                                                + ad.AcInfo(id));
                                            System.out.println("Enter 1 to Confirm or 0 to Cancle:");
                                            int ok=sc.nextInt();
                                            if (ok==1)
                                                System.out.println(ad.deleteac(id));
                                            else
                                                System.out.println("Deleting Was Cancled");
                                        }
                                        else
                                            System.out.println("Accountatn is not Excest");
                                    }
                                    else if (a==5)
                                        System.out.println(ad.acViewAll());
                                    else if (a==0){
                                        //طريقة الخروج من البرنامج
                                        System.out.println("You Logged Out");
                                        break;                        
                                    }
                                    else
                                        System.out.println("Wrong InPut");
                                }
                                catch (Exception ea){
                                    System.out.println("Please Inter a Number");
                                }
                            }
                            // طريقة عمل لوق أوت
                            break;
                        }
                        else if (ac.CK(name, Pass)){
                            //يمكن كتابة جميع الأكواد في الداخل
                            System.out.println("Entered As Accountant");
                            System.out.println("Welcome "+ac.nameo());
                            for( ; ; ){
                                try{
                                    System.out.println("Enter:\n1 to Search Students,\n"
                                            + "2 to Add New Student,\n"
                                            + "3 to Edit a Student,\n"
                                            + "4 to Delete a Student,"
                                            + "\n5 to Check DueFee for a Student,\n"
                                            + "6 to View All Students\n"
                                            + "or 0 to logout");
                                    sc=new Scanner(System.in);
                                    sc.useLocale(Locale.UK);
                                    int a=sc.nextInt();
                                    if (a==1){
                                        System.out.println("Enter 1 to Search by Student ID"
                                                + " or 2 to Search by Student Name");
                                        int c=sc.nextInt();
                                        if(c==1){
                                            System.out.println("Enter Student ID");
                                            int AcUser=sc.nextInt();
                                            System.out.println(ac.StInfo(AcUser));
                                        }
                                        else if(c==2){
                                            System.out.println("Enter Student First Name");
                                            String AcUser=sc.next();
                                            System.out.println(ac.StInfo(AcUser));
                                        }
                                        else
                                            System.out.println("Wrong Input");
                                    }
                                    else if (a==2){
                                        System.out.println("Enter Student First Name:");
                                        String N1=sc.next();
                                        System.out.println("Enter Student Last Name:");
                                        String N2=sc.next();
                                        System.out.println("Enter Student Grade:");
                                        double g1=sc.nextDouble();
                                        System.out.println("Enter Student DueFee:");
                                        int df1=sc.nextInt();
                                        System.out.println("Student ID: "+ac.newst(N1, N2, g1, df1)
                                                +"\nName: "+N1+
                                                " "+N2+"\n"
                                                        + " Was Added");
                                    }
                                    else if(a==3){
                                        System.out.println("Enter Student ID");
                                        int id=sc.nextInt();
                                        int ck=ac.chickst(id);
                                        if (ck==1){
                                            System.out.println("You Will Edit This Student Information:\n"
                                                + ac.StInfo(id));
                                            System.out.println("Enter Student First Name:");
                                            String N1=sc.next();
                                            System.out.println("Enter Student Last Name:");
                                            String N2=sc.next();
                                            System.out.println("Enter Student Grade:");
                                            double g1=sc.nextDouble();
                                            System.out.println(ac.editst(id,N1, N2, g1));
                                        }
                                        else
                                            System.out.println("Student is not Excest");
                                        }
                                    else if(a==4){
                                        System.out.println("Enter Student ID");
                                        int id=sc.nextInt();
                                        int ck=ac.chickst(id);
                                        if(ck==1){
                                            System.out.println("You Will Delete This Student Information:\n"
                                                + ac.StInfo(id));
                                            System.out.println("Enter 1 to Confirm or 0 to Cancle:");
                                            int ok=sc.nextInt();
                                            if (ok==1)
                                                System.out.println(ac.deletest(id));
                                            else
                                                System.out.println("Deleting Was Cancled");
                                        }
                                        else
                                            System.out.println("Student is not Excest");
                                    }
                                    else if(a==5){
                                        System.out.println("Enter Student ID");
                                        int id=sc.nextInt();
                                        int ck=ac.chickst(id);
                                        if(ck==1){
                                            System.out.println(ac.stDueFee(id));
                                        }
                                        else
                                            System.out.println("Student is not Excest");
                                    }
                                    else if(a==6){
                                        System.out.println(ac.stViewAll());
                                    }
                                    else if (a==0){
                                        //طريقة الخروج من البرنامج
                                        System.out.println("You Logged Out");
                                        break;                        
                                    }
                                    else
                                        System.out.println("Wrong InPut");
                                }
                                catch (Exception eb){
                                    System.out.println("Please Enter a Number");
                                }
                            }
                            // طريقة عمل لوق أوت
                            break;
                        }
                        else
                            System.out.println("Wrong User/Password");
                    }  
                }
                else if(login==0)
                    break;
                else
                    System.out.println("Wrong Number");
            }
            catch (Exception e){
                System.out.println("Wrong Input");
            }
        }
        ad.close();
        ac.close();
        System.out.println("Good Bye");*/
    }
    
}
