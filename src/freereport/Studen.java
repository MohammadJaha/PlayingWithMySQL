/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freereport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author miro_
 */
public class Studen {
    private Connection MyCon=null;
    private Statement MyStm=null;
    private ResultSet MyRs=null;
    private PreparedStatement MyPStm=null;
    

    public Studen(){
        try{
            MyCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/freereport", "root", "root");
            MyStm=MyCon.createStatement();
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
    
    public int chickx(int id){
        try{
            MyRs=MyStm.executeQuery("select * from students");
            while(MyRs.next()){
                if(MyRs.getInt("idStudents")==id){
                    return 1;
                }
            }
            return 0;
        }
        catch (Exception e){
            e.printStackTrace();
            return-2;
        }
    }
    
    public String edit(int id,String fname,String lname,double grade){
        try{
            String a="FName = '"+fname+"',LName = '"+lname+"'"
                    + ",Grade = "+grade;
            MyPStm=MyCon.prepareStatement("update students set "+a+
                    " where idStudents = "+id);
            MyPStm.executeUpdate();
            return "Student "+fname+" was Edited";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
    
    public void cahngeDueFee(int id,int Due){
        try{
            String a="DueFee= "+Due;
            MyPStm=MyCon.prepareStatement("update students set "+a+
                    " where idStudents = "+id);
            MyPStm.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public int setnew(String fname, String lname, double grade, int duefee){
        try{
            String a="('"+fname+"','"+lname+"',"+grade+","+duefee+")";
            MyPStm=MyCon.prepareStatement("insert into students"
                    + " (FName,LName,Grade,DueFee)"
                    + " values "+a);
            MyPStm.executeUpdate();
            MyRs=MyStm.executeQuery("select * from students");
            while(MyRs.next())
                if(MyRs.getString("FName").equals(fname))
                    return MyRs.getInt("idStudents");
            return -1;
        }
        catch (Exception exc){
            exc.printStackTrace();
            return -2;
        }
    }
    
    public String delete(int id){
        try{
            MyPStm=MyCon.prepareStatement("delete from students where "
                    + "idStudents = "+id);
            MyPStm.executeUpdate();
            return "Student Was Deleted";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
    
    public String DueFee(int id){
        try{
            int a=chickx(id);
            String st="";
            if(a==1){
                st="Student ID: "+MyRs.getInt("idStudents")+
                        "\nStudent Name: "+MyRs.getString("FName")+" "+
                        MyRs.getString("LName")+"\nStudent DueFee: "+
                        MyRs.getInt("DueFee")+"\n";
                return st;
            }
            else
                return "Student not Excest";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
    
    public String GetInfo(int id){
        try{
            int a=chickx(id);
            if(a==1){
                String st="Student ID: "+MyRs.getInt("idStudents")+
                        "\nStudent Name: "+MyRs.getString("FName")+" "+
                        MyRs.getString("LName")+"\nStudent Grade: "+
                        MyRs.getDouble("Grade")+"\n";
                return st;
            }
            return "Student Not Excest";
        }
        catch (Exception exc){
            exc.printStackTrace();
            return "Error";
        }
    }
    
    public String GetInfo(String a){
        try{
            String st="";
            MyRs=MyStm.executeQuery("select * from students");
            while(MyRs.next())
                if(MyRs.getString("FName").equals(a)){
                    st=st+"Student ID: "+MyRs.getInt("idStudents")+
                        "\nStudent Name: "+MyRs.getString("FName")+" "+
                        MyRs.getString("LName")+"\nStudent Grade: "+
                        MyRs.getDouble("Grade")+"\n";
            }
            if (st.equals(""))
                return "Student Not Excest";
            return st;
        }
        catch (Exception exc){
            exc.printStackTrace();
            return "Error";
        }
    }
    
    public String ViewAll(){
        try{
            String st="ID\tStudent Name\tGrade\n";
            MyRs=MyStm.executeQuery("select * from students");
            while(MyRs.next())
                st=st+MyRs.getInt("idStudents")+"\t"+MyRs.getString("FName")+" "
                        +MyRs.getString("LName")+"\t\t"+MyRs.getDouble("Grade")+"\n";
            return st;
        }
        catch(Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
    
    public void close(){
        try{
            if(MyRs != null)
                MyRs.close();
            if(MyStm != null)
                MyStm.close();
            if(MyPStm != null)
                MyPStm.close();
            if(MyCon != null)
                MyCon.close();
        }
        catch (Exception e){
            
        }
    }
    
    public ArrayList<GetSt> showst(){
        ArrayList<GetSt> stuser=new ArrayList<>();
        try{
            MyRs=MyStm.executeQuery("select * from students");
            GetSt gt;
            while(MyRs.next()){
                gt=new GetSt(MyRs.getInt("idStudents"),MyRs.getString("FName"),
                        MyRs.getString("LName"),MyRs.getDouble("Grade"),MyRs.getInt("DueFee"));
                stuser.add(gt);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return stuser;
    }
}
