package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RecyclerLayoutBinding

class MyAdapter(private val context : Context, private val listNameNumber : MutableList<DataClass>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    // without ViewBinding :
//    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
//        var textView = itemView.findViewById<TextView>(R.id.textView)
//        var textView2 = itemView.findViewById<TextView>(R.id.textView2)
//        var textview3 = itemView.findViewById<TextView>(R.id.textView3)
//    }
    inner class MyViewHolder(val binding: RecyclerLayoutBinding) : RecyclerView.ViewHolder(binding.root){}

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view : View = LayoutInflater.from(context).inflate(R.layout.recycler_layout , parent , false)
//        return MyViewHolder(view)
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view : RecyclerLayoutBinding = RecyclerLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNameNumber.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.textView.text = listNameNumber[position].numberList.toString()
        holder.binding.textView2.text = listNameNumber[position].nameList
        holder.binding.textView3.text = listNameNumber[position].nameList2
        holder.binding.deleteButton.setOnClickListener {
            listNameNumber.removeAt(position)
            notifyDataSetChanged()
        }
    }
}