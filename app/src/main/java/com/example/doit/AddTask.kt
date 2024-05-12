package com.example.doit

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.Toast
import com.example.doit.databinding.ActivityAddTaskBinding
import com.example.doit.databinding.ActivityMainBinding

class AddTask : AppCompatActivity() {

    private  lateinit var binding: ActivityAddTaskBinding
    private lateinit var db: TaskDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDatabase(this)

//        getting user inputs
        binding.addsavebtn.setOnClickListener{
            val title = binding.editTitle.text.toString()
            val content = binding.editContent.text.toString()
            val task = Task(0,title,content)
            db.insertTask(task)
            finish()
            Toast.makeText(this,"Task saved",Toast.LENGTH_SHORT).show()

        }

        val pSkip = findViewById<ImageView>(R.id.pSkip);
        pSkip.setOnClickListener{

            val intent = Intent(this,MainActivity::class.java);
            startActivity(intent);
        }

    }
}