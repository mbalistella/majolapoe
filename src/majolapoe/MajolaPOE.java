/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package majolapoe;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class MajolaPOE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
      
        // Create the task object = instantiation/instantiate
        task objtask = new task();
        
        // Create the JDialog object
        JDialog window = new JDialog();
        
        // This is the final part of the POE
        // Displaying part 2
        window.setAlwaysOnTop(true);
        
        // Declarations, the variables have to be declared and initialized here first or else the if statements cannot access them
        String choice;
        String[] taskName = new String[100];
        String[] taskDesc = new String[100];
        String[] developerNames = new String[100];
        String[] taskDur = new String[100];
        int[] status = new int[100];
        String[] taskID = new String[100];
        int size = 0;
        int count = 0;
        int total = 0;
        String[] del = {"Delete", "Cancel"};
        String[] options = {"To do", "Done", "Doing"};
        int taskDuration = 0;
        
      choice = JOptionPane.showInputDialog(null, 
                 "Please select an action to proceed with:"
                 + "\n1. Add tasks"
                 + "\n2. show report"
                 + "\n3. view all completed tasks"
                 + "\n4. Display task with longest duration"
                 + "\n5. Search for task"
                 + "\n6. Search tasks by developer"
                 + "\n7. Delete a task"
                 + "\n8. Quit",
                 "Welcome to EasyKanban", JOptionPane.PLAIN_MESSAGE);
         objtask.setChoice(choice);
         //Verifying that the input is valid
         choice = objtask.verifyChoice();

        // Beginning of loop after selecting an option
         while (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5") || choice.equals("6") || choice.equals("7"))
              {
              //adding tasks
              if (choice.equals("1")){
                 // Adding tasks
                    size = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks would you like to add?"));
                    objtask.setSize(size);
                     //Declaring the size of arrays
                  taskName = new String[size];
                  developerNames = new String[size];
                  taskDur = new String[size];
                  taskID = new String[size];
                  taskDesc = new String[size];
                  
                    for (count = 0; count < size; count++) {
                        objtask.setCount(count);
                        taskName[count] = JOptionPane.showInputDialog(null, "Enter a name for task: " + count , "TASK NAME", JOptionPane.PLAIN_MESSAGE);
                        taskDesc[count] = JOptionPane.showInputDialog(null, "Please enter task description that is 50 characters or less", "PROVIDE A DESCRIPTION FOR THE TASK", JOptionPane.PLAIN_MESSAGE);
                        developerNames[count] = JOptionPane.showInputDialog(null, "Please enter your first and last name.");
                        taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter task duration (in hours)"));
                        taskDur[count] = String.valueOf(taskDuration);
                         total = total + Integer.parseInt(taskDur[count]);
                   objtask.setTotal(total);
                   
                   //Prompting for task status
                   status[count] = JOptionPane.showOptionDialog(null, "Please specify the status of this task", "Task Status",
                           JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, objtask.getOptions(), null);
                   
                    objtask.setStatus(status);
                   
                   //Display task details
                   JOptionPane.showMessageDialog(null, objtask.printTaskDetails(), "Task Details", JOptionPane.PLAIN_MESSAGE);
                   
                   taskID[count] = objtask.createTaskID();
               
              

                      
                        
                       
                     
              
                       
                    }
                   
           }
                 //Displaying report 
              if(choice.equals("2")){
              StringBuilder report = new StringBuilder();
               
              for(int i = 0; i> size; i++){
              if (taskName[i] != null){
              
              report.append("Task name").append(taskName[i])
                      .append("\nDeveloper: ").append(developerNames[i])
                      .append("\nDuration: ").append(taskDur[i] = "hours")
                      .append("\nTask ID:").append(taskID[i])
                      .append("\nstatus:").append(options[status[i]] + "\n\n");
              
              }
              }
              //if the user has not yet entered any tasks
              if(size == 0){
              JOptionPane.showMessageDialog(null, "Please add tasks to view report", "Report", JOptionPane.PLAIN_MESSAGE);
              
              }
              else{
              JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.PLAIN_MESSAGE);
              }
              
                  
              }
              //displaying completed tasks
              if (choice.equals("3")){
               StringBuilder completedTasks = new StringBuilder();
               int found = 0;
               if (status != null && developerNames != null && taskName != null && taskDur != null){
               for (int i = 0; i < size; i++){
               if (status[i] == 1)
                   completedTasks.append("Task name: ").append(taskName[i])
                           .append("\nDeveloper: ").append(developerNames[i])
                           .append("\nTsk duration: ").append("hours\n\n");
               found++;
               }
               
               }
               
                if (found > 0){  
                    JOptionPane.showMessageDialog(null, completedTasks.toString(), "Completed tasks", JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No tasks have been completed yet", "Completed tasks", JOptionPane.PLAIN_MESSAGE);
                }
              }
              //Displaying task with longest duration
              if (choice.equals("4")){
              if (size == 0){
              JOptionPane.showMessageDialog(null, "Please add tasks to proceed with this action", "No tasks to display",
                      JOptionPane.PLAIN_MESSAGE);}
              }
              else {
              int longestDur = 0;
              String longestDurDeveloper = null;
              
              for(int i = 0; i < size; i++){
              if (Integer.parseInt(taskDur[i])> longestDur){
                  longestDur = Integer.parseInt(taskDur[i]);
                  longestDurDeveloper = developerNames[i];
              }
                  
                  }
                  JOptionPane.showMessageDialog(null, "Developer: " + longestDurDeveloper 
                          + "\nDuration" + longestDur + "hours", "Task with longest duration", JOptionPane.PLAIN_MESSAGE);
                  
                  }
              }
              //Searching for a task
              if(choice.equals("5")){
              String search = "";
              boolean matchFound = false;
              
              search = JOptionPane.showInputDialog(null, "Enter a task name", "Search by name", JOptionPane.PLAIN_MESSAGE);
              for (int i = 0; i < size; i++){
              if (search.equalsIgnoreCase(taskName[i])){
                  JOptionPane.showMessageDialog(null, "Task name: " + taskName[i]
                          + "\nDeveloper: " + developerNames[i]
                          + "\nStatus: " + options[status[i]], "Task found", JOptionPane.PLAIN_MESSAGE);
                  matchFound = true;
              }
              }
              if (matchFound){
              JOptionPane.showMessageDialog(null, "Sorry that task does not exist", "No match found", JOptionPane.PLAIN_MESSAGE);
              }
              }
              //searching tasks by developer
              if (choice.equals("6")){
              String search = "";
              boolean matchFound = false;
              StringBuilder searchFound = new StringBuilder();
              
              search = JOptionPane.showInputDialog(null, "Enter a developer's name", "Search by developer", JOptionPane.PLAIN_MESSAGE);
               
              for (int i = 0; i < size; i++){
              if(search.equalsIgnoreCase(developerNames[i])) {
              searchFound.append("Name: ").append(taskName[i])
                      .append("\nStatus: ").append(options[status[i]]).append("\n\n");
              
              matchFound = true;
              }
              }
              if (matchFound){
              JOptionPane.showMessageDialog(null, searchFound.toString(), "Tasks assigned to" + search, JOptionPane.PLAIN_MESSAGE);
              }
              else{
              JOptionPane.showMessageDialog(null, "That developer is not assigned to an tasks", "No match found", JOptionPane.PLAIN_MESSAGE);
              
              }
              }
              //Option to delete tasks
              if(choice.equals("7")){
              String delete = "";
              boolean taskDeleted = false;
              int confirm;
              
              delete = JOptionPane.showInputDialog(null, "Enter a task name. \n All tasks with this name will be deleted", "Delete tasks", JOptionPane.WARNING_MESSAGE);
              
              for (int i = 0; i < size; i++){
              if (delete.equalsIgnoreCase(taskName[i])){
              
                  confirm = JOptionPane.showOptionDialog(null, "Are you sure you want to delete" + delete, "Confirm task deletion",
                          JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE , null, del, null);
                  if(confirm == 0){
                  total = total - Integer.parseInt(taskDur[i]);
                  objtask.setTotal(total);
                  //Deleting all information from arrays
                  taskName[i] = null;
                  developerNames[i] = null;
                  taskDesc[i] = null;
                  taskDur[i] = null;
                  status[i] = -1;
                  taskID[i] = null;
                  
                  taskDeleted = true;
                  }
              }
              }
              if (taskDeleted){
              JOptionPane.showMessageDialog(null, "The task wa successfully deleted", "Task deleted", JOptionPane.PLAIN_MESSAGE);
              
              }
              else{
              JOptionPane.showMessageDialog(null, "No tasks were found", "Task not found", JOptionPane.PLAIN_MESSAGE);
              }
               
                }
                 //Updating the variable
              choice = JOptionPane.showInputDialog(null, 
                 "Please select an action to proceed with:"
                 + "\n1. Add tasks"
                 + "\n2. show report"
                 + "\n3. view all completed tasks"
                 + "\n4. Display task with longest duration"
                 + "\n5. Search for task"
                 + "\n6. Search tasks by developer"
                 + "\n7. Delete a task"
                 + "\n8. Quit",
                 "Welcome to EasyKanban", JOptionPane.PLAIN_MESSAGE);
         objtask.setChoice(choice);
         //Verifying that the input is valid
         choice = objtask.verifyChoice();
    }//end of loop
    }   
                        
        
    

            


    
    
    

