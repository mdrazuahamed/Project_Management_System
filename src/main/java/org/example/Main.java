package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      int selectAddOrShow;
      Project project = new Project();
      project = project.projectBuild();
      System.out.println(" Press 1 for See the Project Information\n Press 2 for add member on project ");
      selectAddOrShow = userInput.nextInt();

      if(selectAddOrShow==1){
        project.showProjectDetail(project);
      }
      else if (selectAddOrShow==2) {
        project.addMemberInProject(project);
        System.out.println("Project Detail after add New member");
        project.showProjectDetail(project);
      }
    }

}