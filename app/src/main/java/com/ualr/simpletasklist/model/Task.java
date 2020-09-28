package com.ualr.simpletasklist.model;

public class Task {

    // TODO 01. Define two attributes for the Task class: one to store the task description and a second one that
    //  indicates whether the task is done or not

    public Task(String task)
    {
        isDone = false;
        this.task = task;
    }


    // TODO 02. Define the class constructor and the corresponding getters and setters.
    // getters and setters

    public String getTaskDesc()
    {
        return task;
    }
    public void setTaskDesc(String taskDesc)
    {
        task = taskDesc;
    }

    public String taskIsDone()
    {
        if(isDone)
        {
            return "    Done";
        }
        else return "";
    }
    public void setDone(boolean isDone)
    {
        this.isDone = isDone;
    }


    // Private Variables
    private boolean isDone;
    private String task;


}
