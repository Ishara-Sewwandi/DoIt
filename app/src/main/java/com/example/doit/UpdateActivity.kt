package com.example.doit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.doit.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityUpdateBinding
    private lateinit var db: TaskDatabase
    private var taskId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDatabase(this)

        //receive data
        taskId = intent.getIntExtra("task_id",-1)
        if (taskId == -1){
            finish()
            return
        }

        val task = db.getTaskByID(taskId)
        binding.updateTitle.setText(task.title)
        binding.updateContent.setText(task.content)

        binding.updatesavebtn.setOnClickListener{
            val newTitle = binding.updateTitle.text.toString()
            val newContent = binding.updateContent.text.toString()
            val updatedTask = Task(taskId, newTitle,newContent)
            db.updateTask(updatedTask)
            finish()
            Toast.makeText(this, "changes Saved", Toast.LENGTH_SHORT).show()
        }
    }
}