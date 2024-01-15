package org.example;

import java.util.*;

public class Project {
    private String projectName;
    private List<Team> teamList = new ArrayList<>();

    public Project(){
    }
    public Project(String projectName){
        this.projectName = projectName;
    }

    public Project(String projectName, List<Team> teamList) {
        this.projectName = projectName;
        this.teamList = teamList;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public void addTeam(Team team){
        teamList.add(team);
    }

    public void showProjectDetail(Project project){
        for (Team team : project.getTeamList()){
            System.out.println("\n");
            System.out.println("Team name: "+team.getTeamName());
            for(Task task : team.getTaskList()){
                System.out.println("  Task name: "+task.getTaskName());
                for (Member member: task.getMemberList()){
                    System.out.println("    Member Name: "+member.getMemberName());
                }
            }
        }
    }

    public Project projectBuild(){
        Project project = new Project("Hydra Tile");

        Team dv = new Team(TeamName.designVerification);
        Team rtl = new Team(TeamName.rtlDesign);
        Team packaging = new Team(TeamName.packaging);
        Team pd = new Team(TeamName.physicalDesign);

        Task fixBugOnVerilog = new Task("Fix Bug From verilog");
        Task fixErrorFromTestBench = new Task("Fix Error From Testbench");
        Task removeLvsAfterRouting = new Task("Remove Lvs After Routing");
        Task bga = new Task("Ball Grid Array Design");

        Member akash = new Member("Akash Rahman");
        Member reyad = new Member("Reyad Ahamed");
        Member nakib = new Member("Nakibur Rahman");
        Member foez = new Member("Foez Ahamed");
        Member safi = new Member("Ataus Safi");
        Member khadiza = new Member("Khadiza Fariha");
        Member babul = new Member("Muntasir babul");
        Member rafi = new Member("Rubait Rafi");
        Member rifa = new Member("Rifa Mist");
        Member sohid = new Member("Sohid Ahamed");

        fixBugOnVerilog.addMember(nakib);
        fixBugOnVerilog.addMember(akash);

        fixErrorFromTestBench.addMember(foez);
        fixErrorFromTestBench.addMember(reyad);

        removeLvsAfterRouting.addMember(khadiza);
        removeLvsAfterRouting.addMember(babul);
        removeLvsAfterRouting.addMember(safi);

        bga.addMember(rafi);
        bga.addMember(sohid);
        bga.addMember(rifa);

        dv.addTask(fixErrorFromTestBench);
        rtl.addTask(fixBugOnVerilog);
        packaging.addTask(bga);
        pd.addTask(removeLvsAfterRouting);

        project.addTeam(dv);
        project.addTeam(rtl);
        project.addTeam(packaging);
        project.addTeam(pd);

        return project;

    }

    public void addMemberInProject(Project project){
        System.out.println("Please Type New Member Name:");
        Scanner memberNameUserInput = new Scanner(System.in);
        String memberName;
        memberName = memberNameUserInput.nextLine();
        System.out.println("Available Task with Team name and corresponding Number. Please press a number to select a Task");

        int taskNumber=1;
        Scanner userInput = new Scanner(System.in);
        for (Team team : project.getTeamList()) {
            System.out.println("\n");
            System.out.println("Team name: "+team.getTeamName());
            for (Task task : team.getTaskList()) {
                System.out.println(taskNumber + ")Task name: " + task.getTaskName());
                taskNumber++;
            }
        }

        System.out.println(">>>>>>>>>>>Please Choose the number<<<<<<<<<<<<");
        int numberToTask = userInput.nextInt();
        Member newMember = new Member(memberName);
        int taskSelect=0;
        for (Team team : project.getTeamList()) {
            for (Task task : team.getTaskList()) {
                taskSelect++;
                if(Objects.equals(numberToTask,taskSelect)){
                    task.addMember(newMember);
                }
            }
        }
    }
    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", teamList=" + teamList +
                '}';
    }
}
