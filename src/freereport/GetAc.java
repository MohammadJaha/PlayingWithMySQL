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
public class GetAc {
    
    private int id;
    private String Fname;
    private String Lname;
    
    public GetAc(int id,String Fname,String Lname){
        this.id=id;
        this.Fname=Fname;
        this.Lname=Lname;

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
    
}
