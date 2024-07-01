/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package majolapoe;

import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
class task {
    
      //Create attributes/instance variables
    public String taskName;
    public int taskNumber;
    public String taskDescription;
    public String developerDetails;
    public int taskDuration;
    public String taskID;
    public int count;
    public String taskStatus;
    public final String[] numericMenu;
    public String menu = "";
    public int total;
    
    //Create the constructors - to set the default values to the attributes
    public task(){
    this.taskName = "";
    this.taskNumber = 0;
    this.taskDescription = "";
    this.developerDetails = "";
    this.taskDuration = 0;
    this.total = 0;
    this.taskID ="";
    this.count = 0;
    this.taskStatus = "";
    this.numericMenu = new String[]{"Add tasks", "This feature is still in development(COMING SOON)", "Quit"};
    this.choice = choice;
    }
     // Create the getters/accessor methods
    public String gettaskName(){
    return taskName;
    }
    public int gettaskNumber(){
    return taskNumber;
    }
    public String gettaskDescription(){
    return taskDescription;
    }
    public String getdeveloperDetails (){
    return developerDetails;
    }
    public int gettaskDuration(){
    return taskDuration;
    }
    public String gettaskID(){
    return taskID;
    }
    public int getcount(){
    return count;    
    }    
    public String gettaskStatus(){
    return taskStatus;
    }
    public String getMenu(){
        return menu;
    }
    public int gettotal(){
        return total;
    }
     //create setters/mutator methods
     public void  settaskName(String taskName){
    this.taskName = taskName;
    }
    public void settaskNumber(int taskNumber){
    this.taskNumber = taskNumber;
    }
    public void settaskDescription(String taskDescription){
    this.taskDescription = taskDescription;
    }
    public void setdeveloperDetails (String developerDetails){
    this.developerDetails = developerDetails;
    }
    public void settaskDuration(int taskDuration){
    this.taskDuration = taskDuration;
    }
    public void settaskID(String taskID){
    this.taskID = taskID;
    }
    public void settaskStatus(String taskStatus){
    this.taskStatus = taskStatus;
    
    }
    public void setMenu(String menu){
        this.menu = menu;
    }
    public void settotal(int total){
        this.total = total;
    }
    public void setcount(int count){
        this.count = count;
    }
    //This method is for checking the task description
   public boolean checkTaskDescription() {
    for (int i = 0; i<2; i++)
          {
          if (taskDescription.length()<=50){
          JOptionPane.showMessageDialog(null, "Task successfully captured");
          break;
   }
   else{JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters ");
                                                         
   }
          
}
        return false;
   }
   
   //This method creates the task ID
    public String createTaskID (){
  taskID = (taskName.substring(0, 2) + ":" + count + ":" + developerDetails.substring(developerDetails.length() - 3));
  taskID = taskID.toUpperCase();
 return taskID;
 }
    
    //This method prints the task details
    public String printTaskDetails(){
     String output = 
                   "Task status:  "+ taskStatus 
                   +"\n Developer Details:  "+ developerDetails 
                   +"\n Task Number:   "+count 
                   +"\n Task Name:   "+ taskName
                   +" \n Task Description: " + taskDescription
                   +"\nTask ID:  "+taskID 
                   +"\n Task Duration: " + taskDuration;
            return output;
           
            }
    
    
    //This method returns the total hours combined for the total tasks
    public int returnTotalHours() {
         int count = 0;
         int numberOfTasks = 0;
        if (count < numberOfTasks){
        this.total += taskDuration;
        }
        
        return total;
}
 public void display(){
 JOptionPane.showMessageDialog(null, "Total hours for all tasks: " + this.total);
 }

//Beginning of part three
 //Create attributes/instance variables
    public int size;
    public String taskDesc[] = new String[size];
    public String taskNames[] = new String[size];
    public String developerNames[] = new String[size];
    public String taskDurations[] = new String[size];
    public int status[] = new int[size];
    public String[] options = {"To do", "Done", "Doing"};
     public String choice;
     
      
        
        
    //Create getters and setters
     public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String[] getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String[] taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String[] getTaskName() {
        return taskNames;
    }

    public void setTaskName(String[] taskName) {
        this.taskNames = taskNames;
    }

    public String[] getDeveloperName() {
        return developerNames;
    }

    public void setDeveloperName(String[] developerName) {
        this.developerNames = developerNames;
    }

    public String[] getTaskDuration() {
        return taskDurations;
    }

    public void setTaskDuration(String[] taskDuration) {
        this.taskDurations = taskDurations;
    }

    public int[] getStatus() {
        return status;
    }

    public void setStatus(int[] status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
    // method to verify the users input from part two
    public String verifyChoice(){
    while((choice == null)&&(choice.equals("1"))&&(choice.equals("2"))&&(choice.equals("3"))&&(choice.equals("4"))&&(choice.equals("5"))&&(choice.equals("6"))&&(choice.equals("7"))){
     choice = JOptionPane.showInputDialog(null, 
                 "Please select an action to proceed with:"
                 + "\n1. Add tasks"
                 + "\n2. show report"
                 + "\n3. view all completed tasks"
                 + "\n4. Display task with longest duration"
                 + "\n5. Search for task"
                 + "\n6. Search tasks by developer"
                 + "\n7. Delete a task"
                 + "\n8. Quit"
                 + "\n. Please enter only the number that corresponds to your choice action",
                 "Invalid entry", JOptionPane.ERROR_MESSAGE);
    
    }
        return choice;
   
    }
    public String verifyTaskName(){
        
        while (taskNames[getCount()].equals("") && taskNames[getCount()].length() < 2){
            taskNames[getCount()] = JOptionPane.showInputDialog(null, "Please ensure that atleast your task name is 2 characters long",
                    "Invalid entry", JOptionPane.ERROR_MESSAGE);
    
    
    
    
    }
        return taskNames[getCount()];
    
    
    } 
    public String verifyDeveloperName(){
        while (developerNames[getCount()].equals("") && developerNames[getCount()].length() < 3){
        developerNames[getCount()] = JOptionPane.showInputDialog(null, "Please ensure that your developer name is atleast 2 characters long",
                "Invalid entry", JOptionPane.ERROR_MESSAGE);
}
        return developerNames[getCount()];
}
}

    

