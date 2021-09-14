/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freereport;

/**
 *
 * @author miro_
 */
public class GetSt {
    
    private int id;
    private String Fname;
    private String Lname;
    private double Grade;
    private int DueFee;
    
    public GetSt(int id,String Fname,String Lname,double Grade,int DueFee){
        this.id=id;
        this.Fname=Fname;
        this.Lname=Lname;
        this.Grade=Grade;
        this.DueFee=DueFee;
    }
    
    public int getid(){
        return id;
    }
    public String getFname(){
        return Fname;
    }
    public String getLname(){
        return Lname;
    }
    public double getGrade(){
        return Grade;
    }
    public int getDueFee(){
        return DueFee;
    }
    
}
