package com.example.nutritiontracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.mainlanguagesupport.R

open class SecondPage : AppCompatActivity()  {

    lateinit var foodText: EditText
    lateinit var foodList: Spinner
    lateinit var foodAmount: EditText
    lateinit var confirm: Button

    // Accessing the class
    var FileSave = fileSaving()

    // To store the name of the food
    //open var name : ArrayList<String> = ArrayList()
    // To store the type of food
    //open var type : ArrayList<String> = ArrayList()
    // To store the amount of the food
   // open var amount : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_addalert_design)

        //Name
        foodText = findViewById(R.id.nameFoodInput)
        //Spinner
        foodList = findViewById(R.id.itemName)
        //Amount
        foodAmount = findViewById(R.id.foodAmountInput)



        // This will read data and send it to the array list
        //name = FileSave.readDataName(this)
        //type = FileSave.readDataType(this)
        //amount = FileSave.readDataAmount(this)

        // Accessing the type of Food Array-List
        var typeArrayList = resources.getStringArray(R.array.Nutrition_Type)
        // Making the Adapter
        var spinnerAdapter = ArrayAdapter(
            this@SecondPage,
            android.R.layout.simple_spinner_dropdown_item,
            typeArrayList
        )

        //to specify the dropdown layout
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        foodList.adapter = spinnerAdapter

        confirm.setOnClickListener {
            //Define the variable to store data
            var mealEaten: String = foodText.text.toString()
            var typeMeal: String = foodList.selectedItem.toString()
            var calories: String = foodAmount.text.toString()

            // to add the name of the food to the Array list
            //name.add(mealEaten)
            //type.add(typeMeal)
            //amount.add(calories)
            // Clear the foodText, foodList & foodAmount
            foodText.setText("")
            foodList.selectedItemPosition
            foodAmount.setText("")

            //Sending data to other class
            //1st parameter -->Activity name that will start the intent
            //2nd parameter --> activity that will be opene
            //to open the activity

            //openOtherActivity.putStringArrayListExtra("foodName",name)
            //openOtherActivity.putStringArrayListExtra("foodType",type)
            //openOtherActivity.putStringArrayListExtra("foodAmount",amount)

            // To make the toast that you just added to the file
            Toast.makeText(applicationContext, "You just added to the list.", Toast.LENGTH_SHORT)
                .show()
        }
    }


}