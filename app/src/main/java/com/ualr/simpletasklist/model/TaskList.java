package com.ualr.simpletasklist.model;

import android.widget.EditText;

import java.util.HashMap;

public class TaskList {

    // TODO 03. Define TaskList's attributes. The class will have just one attribute to store all
    //  the tasks created by the user.

    private HashMap<Integer, Task> taskList = new HashMap<Integer, Task>();
    private Integer idLocation = 0;

    // TIP. We need a data structure able to dynamically grow and shrink. That's why we'll use a HashMap.
    // where keys will be integer values and the mapped values will be a task object

    // TODO 04. Define the class constructor and the corresponding getters and setters.

    public String getDone(Integer id)
    {
        String isDone = taskList.get(id).taskIsDone();
        return isDone;
    }

    public String getTaskDescription(Integer id)
    {
        String desc = taskList.get(id).getTaskDesc();
        return desc;
    }

    // TODO 06.03. Define a new method called "add" that, given a task description, will create a
    //  new task and add it to the task list.

    public void addTask(String description)
    {
        Task newTask = new Task(description);
        taskList.put(idLocation, newTask);
        idLocation++;
    }

    // TODO 06.04. Define a new "toString" method that provides a formatted string with all the tasks in the task list.
    // Format: 1 line per task. Each line should start with the id number of the task, then a dash, and the task description right after that.
    // If the task is marked as done, "Done" should be included at the end of the line

    @Override
    public String toString()
    {
        String results = "";
        for (Integer i : taskList.keySet())
        {
            results += i + "    -    "  + getTaskDescription(i) + getDone(i) + "\n";
        }
        return results;
    }

    // TODO 07.03. Define a new method called "delete" that, given a task id, will delete the
    //  corresponding task from the task list.

    public void deleteTask(Integer id)
    {
        taskList.remove(id);

    }

    // TODO 08.03. Define a new method called "markDone" that, given a task id, will mark the
    //  corresponding task as done.

    public void markDone(Integer id)
    {
        taskList.get(id).setDone(true);
    }

}
