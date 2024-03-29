package org.example;

import java.util.*;

public class Project {
    private String projectName;
    private List<Team> teamList = new ArrayList<>();

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

    public Project projectBuild(int number){
        Project project = new Project("Hydra Tile");
        Team dv = new Team(TeamName.designVerification);
        Team rtl = new Team(TeamName.rtlDesign);
        Team packaging = new Team(TeamName.packaging);
        Team pd = new Team(TeamName.physicalDesign);

        Task fixBugOnVerilog = new Task("Fix Bug From verilog");
        Task fixErrorFromTestBench = new Task("Fix Error From Testbench");
        Task removeLvsAfterRouting = new Task("Remove Lvs After Routing");
        Task bga = new Task("Ball Grid Array Design");

        Member akash = new Member("Akash Rahman",rtl,project);
        Member nakib = new Member("Nakibur Rahman",rtl,project);
        Member reyad = new Member("Reyad Ahamed",dv,project);
        Member foez = new Member("Foez Ahamed",dv,project);

        Member safi = new Member("Ataus Safi");
        safi.setTeam(pd);
        safi.setProject(project);

        Member khadiza = new Member("Khadiza Fariha",pd,project);

        Member babul = new Member("Muntasir babul");
        babul.setTeam(pd);
        babul.setProject(project);

        Member rafi = new Member("Rubait Rafi",packaging,project);
        Member rifa = new Member("Rifa Mist",packaging,project);
        Member sohid = new Member("Sohid Ahamed",packaging,project);

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
        if(number == 1){
            showProjectDetail(project);
        }
        if (number==2){
            project.addMemberInProject(project);
        }
        if(number == 3){
            project.showMemberList(project);
        }
        return project;
    }

    public void showMemberList(Project project){
        for(Team team : project.getTeamList()){
            for(Task task: team.getTaskList()){
                for(Member member : task.getMemberList()){
                    System.out.println("Member Name: "+member.getMemberName());
                }
            }
        }
        System.out.println("Write a name to see detail");
        Scanner memberNameInput = new Scanner(System.in);
        String selectMemberName = memberNameInput.nextLine();
        for(Team team : project.getTeamList()){
            for(Task task: team.getTaskList()){
                for(Member member : task.getMemberList()){
                    if(Objects.equals(selectMemberName.toLowerCase(),member.getMemberName().toLowerCase())){
                        member.memberDetail(member);
                    }
                }

            }
        }
    }

    public void addMemberInProject(Project project) {
        //memberDetail(memberList);
        System.out.println("Please Type New Member Name:");
        Scanner memberNameUserInput = new Scanner(System.in);
        String memberName;
        memberName = memberNameUserInput.nextLine();
        System.out.println("Available Task with Team name and corresponding Number. Please press a number to select a Task");

        int taskNumber = 1;
        Scanner userInput = new Scanner(System.in);
        for (Team team : project.getTeamList()) {
            System.out.println("\n");
            System.out.println("Team name: " + team.getTeamName());
            for (Task task : team.getTaskList()) {
                System.out.println(taskNumber + ")Task name: " + task.getTaskName());
                taskNumber++;
            }
        }

        System.out.println(">>>>>>>>>>>Please Choose the number<<<<<<<<<<<<");
        int numberToTask = userInput.nextInt();
        Member newMember = new Member(memberName);
        int taskSelect = 0;
        for (Team team : project.getTeamList()) {
            for (Task task : team.getTaskList()) {
                taskSelect++;
                if (Objects.equals(numberToTask, taskSelect)) {
                    newMember.setTask(task);
                    newMember.setTeam(team);
                    newMember.setProject(project);
                    task.addMember(newMember);

                }
            }
        }
        System.out.println(" Press 1 for see Project Detail after add New member\n Press other key to see Member Name List");
        int showProjectOrMember = userInput.nextInt();

        if (showProjectOrMember == 1)
            project.showProjectDetail(project);
        else if (showProjectOrMember == 2) {
            project.showMemberList(project);


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
