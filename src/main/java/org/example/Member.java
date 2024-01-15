package org.example;

import java.util.List;

public class Member {
    private String memberName;
    private Task task;
    private Team team;
    private Project project;

    public Member(String memberName) {
        this.memberName = memberName;
    }

    public Member(String memberName, Task task, Team team, Project project) {
        this.memberName = memberName;
        setTask(task);
        setTeam(team);
        setProject(project);
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void getMemberInformation(Member member){
        System.out.println(member);
    }
    @Override
    public String toString() {
        return "Member{" +
                "memberName='" + memberName + '\'' +
                ", task=" + task +
                ", team=" + team +
                ", project=" + project +
                '}';
    }
}
