/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freereport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author miro_
 */
public class Acc extends Studen {
    
    private Connection MyCon=null;
    private Statement MyStm=null;
    private ResultSet MyRs=null;
    private PreparedStatement MyPStm=null;
    private String Namo;
    
    public Acc(){
        super();
        try{
            MyCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/freereport", "root", "root");
            MyStm=MyCon.createStatement();
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
    
    public boolean CK(String user,String pass){
        try{
            MyRs=MyStm.executeQuery("select * from accountants");
            while(MyRs.next())
                if(MyRs.getString("User").equals(user)&&MyRs.getString("Pass").equals(pass)){
                    Namo=MyRs.getString("FName")+" "+MyRs.getString("LName");
                    return true;
                }
            return false;
        }
        catch (Exception exc){
            exc.printStackTrace();
            return false;
        }
    }
    
    public String nameo(){
        return Namo;
    }

    public int chick(int id){
        try{
            MyRs=MyStm.executeQuery("select * from accountants");
            while(MyRs.next()){
                if(MyRs.getInt("idAccountants")==id){
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
    
    public String edit(int id,String fname,String lname){
        try{
            String a="FName = '"+fname+"',LName = '"+lname+"'";
            MyPStm=MyCon.prepareStatement("update accountants set "+a+
                    " where idAccountants = "+id);
            MyPStm.executeUpdate();
            return "Accountant "+fname+" was Edited";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
        /**
     *
     * @param user
     * @return
     */
    @Override
    public String delete(int id){
        try{
            MyStm.executeUpdate("delete from accountants where idAccountants = "+id);
            return "Accountant was Deleted";
        }
        catch(Exception E){
            E.printStackTrace();
            return "Error";
        }
    }
        /**
     *
     * @param user
     * @return
     */
    @Override
    public String GetInfo(int id){
        try{
            int a=chick(id);
            if(a==1){
                String st="Accountant ID: "+MyRs.getInt("idAccountants")+
                            "\nAccountant Name: "+MyRs.getString("FName")+" "+
                            MyRs.getString("LName");
                return st;
            }
            return "Accountant Not Excest";
        }
        catch (Exception exc){
            exc.printStackTrace();
            return "Error";
        }
    }
    
    /**
     *
     * @param user
     * @return
     */
    @Override
    public String GetInfo(String user){
        try{
            String st="";
            MyRs=MyStm.executeQuery("select * from accountants");
            while(MyRs.next())
                if(MyRs.getString("FName").equals(user)){
                    st=st+"Accountant ID: "+MyRs.getInt("idAccountants")+
                        "\nAccountant Name: "+MyRs.getString("FName")+" "+
                        MyRs.getString("LName")+"\n";
            }
            if(st.equals(""))
                return "Accountant Not Excest";
            return st;
            
        }
        catch (Exception exc){
            exc.printStackTrace();
            return "Error";
        }
    }
    
    @Override
    public String ViewAll(){
        try{
            String st="ID\tAccountant Name\n";
            MyRs=MyStm.executeQuery("select * from accountants");
            while(MyRs.next())
                st=st+MyRs.getInt("idAccountants")+"\t"+MyRs.getString("FName")+" "
                        +MyRs.getString("LName")+"\n";
            return st;
        }
        catch(Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
    
    public ArrayList<GetAc> showac(){
        ArrayList<GetAc> acuser=new ArrayList<>();
        try{
            MyRs=MyStm.executeQuery("select * from accountants");
            GetAc gt;
            while(MyRs.next()){
                gt=new GetAc(MyRs.getInt("idAccountants"),MyRs.getString("FName"),
                        MyRs.getString("LName"));
                acuser.add(gt);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return acuser;
    }
    
    
    
    public String StInfo(int id){
        return super.GetInfo(id);
    }
    
    public String StInfo(String user){
        return super.GetInfo(user);
    }
    
    public int chickst(int id){
        return super.chickx(id);
    }
    
    public String editst(int id,String fname,String lname,double grade){
        return super.edit(id,fname,lname,grade);
    }
    
    public void stChangeDueFee(int id, int Due){
        super.cahngeDueFee(id, Due);
    }
    
    public int newst(String fname, String lname, double grade, int duefee){
    return super.setnew(fname, lname, grade, duefee);
    }

    public int setnew(String fname,String lname,String user,String pass){
        try{
            String a="('"+fname+"','"+lname+"','"+user+"','"+pass+"')";
            MyPStm=MyCon.prepareStatement("insert into accountants (FName, LName, "
                    + "User, Pass) values "+a);
            MyPStm.executeUpdate();
            MyRs=MyStm.executeQuery("select * from accountants");
            while (MyRs.next())
                if(MyRs.getString("FName").equals(fname))
                    return MyRs.getInt("idAccountants");
            return -1;
        }
        catch (Exception e){
            e.printStackTrace();
            return -2;
        }
    }
    
    public String deletest(int id){
        return super.delete(id);
    }
    
    public String stDueFee(int id){
        return super.DueFee(id);
    }
    
    public String stViewAll(){
        return super.ViewAll();
    }
    
    
    
    /**
     *
     */
    @Override
    public void close(){
        super.close();
        try{
            super.close();
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

    public ArrayList shows(){
        return super.showst();
    }
}
