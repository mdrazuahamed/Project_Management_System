package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      int selectAddOrShow;
      Project project = new Project();
      System.out.println(" Press 1 for See the Project Information\n Press 2 for add member on project\n Press 3 to get existing member list ");
      selectAddOrShow = userInput.nextInt();

      if(selectAddOrShow==1){
        project = project.projectBuild(1);
      }

      else if(selectAddOrShow==2) {
        project = project.projectBuild(2);
      }

      else if(selectAddOrShow==3){
        project = project.projectBuild(3);
      }
    }

}