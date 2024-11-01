package com.example.nutritiontracker

import android.content.Context
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mainlanguagesupport.R

//user Data is a Data Class
class HistoryViewList(
    val userData1 : ArrayList<String>,
    val userData2 : ArrayList<String>,
    val userData3 : ArrayList<Int>,
    val context: Context
) : RecyclerView.Adapter<HistoryViewList.HistoryViewCardDesign>() { // To obtain the HistoryViewList from the Adapter

    // To represent the card design & define the components
    class HistoryViewCardDesign(itemView: View) : RecyclerView.ViewHolder(itemView){
        var historyNameTextView : TextView = itemView.findViewById(R.id.foodNameText)
        var historyTypeTextView : TextView = itemView.findViewById(R.id.foodTypeText)
        var historyAmountTextView : TextView = itemView.findViewById(R.id.foodAmountText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewCardDesign {

        val view : View = LayoutInflater.from(parent.context).inflate(
            R.layout.card_design_historyview,
            parent,
            false
        )

        // To return the view
        return HistoryViewCardDesign(view)

    }

    override fun getItemCount(): Int {
        // to specify the amount of data in RecyclerView
        return userData1.size
    }

    override fun onBindViewHolder(holder: HistoryViewCardDesign, position: Int) {

        //val foodList = userData1[position]

        // Returning/Setting the element in a specific position in Recycler View
        holder.historyNameTextView.text = userData1.get(position)
        holder.historyTypeTextView.text = userData2[position]
        holder.historyAmountTextView.text = userData3[position].toString()
    }

}