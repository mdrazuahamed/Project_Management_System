package org.example;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private TeamName teamName;
    private Project project;
    private List<Task> taskList = new ArrayList<>();

    public Team(TeamName teamName) {
        this.teamName = teamName;
    }

    public Team(TeamName teamName, Project project, List<Task> taskList) {
        this.teamName = teamName;
        this.project = project;
        this.taskList = taskList;
    }

    public TeamName getTeamName() {
        return teamName;
    }

    public void setTeamName(TeamName teamName) {
        this.teamName = teamName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName=" + teamName +
                ", project=" + project +
                ", taskList=" + taskList  +
                '}';
    }
}
