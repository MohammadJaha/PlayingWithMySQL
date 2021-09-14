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
import java.util.ArrayList;

/**
 *
 * @author miro_
 */
public class Admin extends Acc{
    
    private Connection MyCon=null;
    private Statement MyStm=null;
    private ResultSet MyRs=null;
    private String Namo;
   
    public Admin(){
        super();
        try{
            MyCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/freereport", "root", "root");
            MyStm=MyCon.createStatement();
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
    
    public String AcInfo(int id){
        return super.GetInfo(id);
    }
    
    public String AcInfo(String user){
        return super.GetInfo(user);
    }
    
    public int chickac(int id){
        return super.chick(id);
    }
    
    public String editac(int id,String fname,String lname){
        return super.edit(id,fname,lname);
    }
    
    public int newac(String fname, String lname, String user, String pass){
    return super.setnew(fname, lname, user, pass);
    }
    
    public String deleteac(int id){
        return super.delete(id);
    }
    
    public String acViewAll(){
        return super.ViewAll();
    }
    
    
    
    /**
     *
     * @param user
     * @param pass
     * @return
     */
    @Override
    public boolean CK(String user,String pass){
        try{
            MyRs=MyStm.executeQuery("select * from admins");
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
    
    @Override
    public String nameo(){
        return Namo;
    }
    
    @Override
    public void close(){
        super.close();
        try{
            super.close();
            if(MyRs != null)
                MyRs.close();
            if(MyStm != null)
                MyStm.close();
            if(MyCon != null)
                MyCon.close();
        }
        catch (Exception e){
            
        }
    }
    
    public ArrayList showc(){
        return super.showac();
    }
}
