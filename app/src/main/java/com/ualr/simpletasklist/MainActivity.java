package com.ualr.simpletasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ualr.simpletasklist.databinding.ActivityMainBinding;
import com.ualr.simpletasklist.model.TaskList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String TAG = MainActivity.class.getSimpleName();

    // TODO 05. Add a TaskList member to the MainActivity. Initialize the new member.

    private TaskList toDoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toDoList = new TaskList();

        //TODO 06.02 Bind the onAddBtnClicked method to the add button, so the onAddBtnClicked is
        // triggered whenever the user clicks on that button
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddBtnCLicked();
            }
        });

        //TODO 07.02 Bind the onDeleteBtnClicked method to the delete button, so that method is
        // triggered whenever the user clicks on that button
        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteBtnClicked();
            }
        });

        //TODO 08.02 Bind the onDoneBtnClicked method to the done button, so the onDoneBtnClicked method is
        // triggered whenever the user clicks on that button
        binding.clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDoneBtnClicked();
            }
        });
    }


    private void cleanFields()
    {
        binding.editTextTaskId.setText("");
        binding.editTextTextPersonName.setText("");
    }

    // TODO 06. Create a new functionality to add a new task using the description provided
    //  through the text field on the top of the screen by tapping the "+" on the right

    // TODO 06.01. Create a new method called onAddBtnClicked.
    public void onAddBtnCLicked()
    {
        String desc = binding.editTextTextPersonName.getText().toString();
        toDoList.addTask(desc);

        String tasks = toDoList.toString();
        binding.taskList.setText(tasks);

        cleanFields();
    }

    // TODO 06.05. Invoke TaskList class' add method to ask the TaskList to
    //  add a new Task with the description provided through the text field.

    // TODO 06.06. Use TaskList class' toString method to get a string with the formatted task list
    //  and display it on screen in the TextView with the id "textView"


    // TODO 07. Create a new functionality to delete a task from the task list

    // TODO 07.01. Create a new method called onDeleteBtnClicked.

    public void onDeleteBtnClicked()
    {
        Integer id = Integer.parseInt(binding.editTextTaskId.getText().toString());
        toDoList.deleteTask(id);

        String tasks = toDoList.toString();
        binding.taskList.setText(tasks);

        cleanFields();
    }

    // TODO 07.04. Invoke TaskList class' delete method to ask the TaskList to
    //  delete a Task given the id provided through the text field on the bottom.

    // TODO 07.05. Use TaskList class' toString method to get a string with the formatted task list
    //  and display it on screen in the TextView with the id "textView"


    // TODO 08. Create a new functionality to mark a task as done.

    // TODO 08.01. Create a new method called onDoneBtnClicked

    public void onDoneBtnClicked()
    {
        Integer id = Integer.parseInt(binding.editTextTaskId.getText().toString());
        toDoList.markDone(id);

        String tasks = toDoList.toString();
        binding.taskList.setText(tasks);

        cleanFields();
    }

    // TODO 08.04. Invoke TaskList class' markDone method to ask the TaskList to
    //  mark a Task given the id provided through the text field on the bottom.

    // TODO 08.05. Use TaskList class' toString method to get a string with the formatted task list
    //  and display it on screen in the TextView with the id "textView"
}