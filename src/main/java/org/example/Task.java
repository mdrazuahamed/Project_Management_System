package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String taskName;
    private List<Member> memberList = new ArrayList<>();

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public Task(String taskName, List<Member> memberList) {
        this.taskName = taskName;
        this.memberList = memberList;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public void addMember(Member member){
        memberList.add(member);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", memberList=" + memberList +
                '}';
    }
}
