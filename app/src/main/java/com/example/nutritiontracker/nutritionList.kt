package com.example.nutritiontracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mainlanguagesupport.R

class nutritionList  (
    //Making the Primary Constructor -> basically to INITIALIZE the properties of the OBJECT/COMPONENT
    // nutritionAmount doesn't need to be intialized because by default is "0"
    var nutritionAddName: ArrayList<String> ,
    var nutritionAddImage: ArrayList<Int>,
    var context: Context


): BaseAdapter() {

    override fun getCount(): Int {
        // return how many Item will be represented
        return nutritionAddName.size
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        // to return the design View we created
        val view : View = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.card_design_show_carbprofat, parent,false)

        // to define the nutritionAmount, nutritionName and nutritionImage of the components
        var nutritionText : TextView = view.findViewById(R.id.typeNutrition)
        var nutritionImage : ImageView = view.findViewById(R.id.nutritionImage)

        // to set the text and image from the arraylist
        nutritionText.text = nutritionAddName[position]
       nutritionImage.setImageResource(nutritionAddImage.get(position))

        return view
    }

}