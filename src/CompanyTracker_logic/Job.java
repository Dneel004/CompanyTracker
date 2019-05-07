/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompanyTracker_logic;

/**
 *
 * @author Daniel
 */
public class Job {
    private String name;
    private int price;
    private String type;
    private int costOfProps;
    private static int id;
    
    public Job(String jobName, String jobType, int jobPrice, int jobCostOfProps ){
        name = jobName;
        type = jobType;
        price = jobPrice;
        costOfProps = jobCostOfProps;
        id++;
    }
   
    public int grossIncome(){
        return price;
    }
    
    public int netIncome(){
        return (price - costOfProps)/2;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name = newName;
    }
    
    public int getPrice(){
        return price;
    }
    public void setPrice(int newPrice){
        this.price = newPrice;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String newType){
        this.type = newType;
    }
    
    public int getCostOfProps(){
        return costOfProps;
    }
    public void setCostOfProps(int newCostOfProps){
        this.costOfProps = newCostOfProps;
    }
    public static int getID(){
        return id;
    }
}
