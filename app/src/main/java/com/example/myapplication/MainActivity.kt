package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nameNumberList = mutableListOf<DataClass>()
        nameNumberList.add(DataClass(1, "a", "w"))
        nameNumberList.add(DataClass(2, "b", "x"))
        nameNumberList.add(DataClass(3, "c", "y"))
        nameNumberList.add(DataClass(4, "d", "z"))
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//        binding.recyclerView.layoutManager = GridLayoutManager
        val adapter = MyAdapter(this, nameNumberList)
        binding.recyclerView.adapter = adapter

        var i = 4
        binding.addButton.setOnClickListener {
            nameNumberList.add(DataClass(i, "i", "A"))
            i++
            adapter.notifyDataSetChanged();
        }

    }
}