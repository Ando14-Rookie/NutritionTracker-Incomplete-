package com.example.nutritiontracker

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mainlanguagesupport.R


class MainActivity : AppCompatActivity() {

    lateinit var nutrtionGridView: GridView
    lateinit var historyView: RecyclerView
    lateinit var addButton: Button
    //lateinit var userData: ArrayList<DataInputUser>
    lateinit var HistoryViewList: HistoryViewList

    var nutritionAddName = ArrayList<String>()
    var nutritionAddImage = ArrayList<Int>()
    // Accessing the class
    var FileSave = fileSaving()

    var name = ArrayList<String>()
    var type = ArrayList<String>()
    var amount = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Forcing to be only PORTRAIT
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main)

        nutrtionGridView = findViewById(R.id.nutritionView)
        historyView = findViewById(R.id.historyView)
        addButton = findViewById(R.id.addButton)

        // Defining the var
        //userData = ArrayList()

        // This will read data and send it to the array list
        name = FileSave.readDataName1(this)
        type = FileSave.readDataName2(this)
        amount = FileSave.readDataName3(this)

        // TO write the data
        FileSave.writeDataName1(name, applicationContext)
        FileSave.writeDataName2(type, applicationContext)
        FileSave.writeDataName3(amount, applicationContext)

        // Setting Logo
        supportActionBar!!.setIcon(R.mipmap.health_logo_icon)
        // Enable Logo
        supportActionBar!!.setDisplayUseLogoEnabled(true)
        // set Home
        supportActionBar!!.setDisplayShowHomeEnabled(true) //

        // Making the Adapter for the GridView
        var adapter1 = nutritionList(nutritionAddName, nutritionAddImage, this@MainActivity)
        nutrtionGridView.adapter = adapter1

        // Making the Adapter for the Recycler View
       HistoryViewList = HistoryViewList(name, type, amount,this@MainActivity)
        // Setting the layout for the Recycler View
        historyView.layoutManager = LinearLayoutManager(this@MainActivity)
        historyView.adapter = HistoryViewList
        // To refresh data everytime it adds
        adapter1.notifyDataSetChanged()
        HistoryViewList.notifyDataSetChanged()

        //Add Title to Recycler View
        addArrayList1()

        // Add Button
        addButton.setOnClickListener {
            addAlert()
        }

    }

    fun addArrayList1() {

        // Setting the name
        // You d
        nutritionAddName.add("Carbs")
        nutritionAddName.add("Protein")
        nutritionAddName.add("Fat")

        //Setting the amount by default
        nutritionAddImage.add(R.mipmap.carbs_logo)
        nutritionAddImage.add(R.mipmap.protein_logo)
        nutritionAddImage.add(R.mipmap.fats_logo)

    }

    fun addAlert(){
        // Inflate the Card Design
        var inflater = LayoutInflater.from(this)
        var view = inflater.inflate(R.layout.card_addalert_design,null)
        var alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setView(view)
        //Getting id from card
        var mealName = view.findViewById<EditText>(R.id.nameFoodInput)
        var mealType = view.findViewById<Spinner>(R.id.itemName)
        var mealAmount = view.findViewById<EditText>(R.id.foodAmountInput)

        //Set Spinner
        // Accessing the type of Food Array-List
        var typeArrayList = resources.getStringArray(R.array.Nutrition_Type)
        // Making the Adapter
        var spinnerAdapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_spinner_dropdown_item,
            typeArrayList
        )

        //to specify the dropdown layout
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mealType.adapter = spinnerAdapter

        //Set Custom View
        alertDialog.setView(view)
            .setPositiveButton("Confirm") { dialog, which ->
                val nameInput = mealName.text.toString()
                val typeInput = mealType.selectedItem.toString()
                val amountInput = mealAmount.text.toString()
                // Identify what to add to ArrayList
                //userData.add(DataInputUser(nameInput, typeInput, amountInput))

                Toast.makeText(this, "You just added to the list.", Toast.LENGTH_SHORT).show()
                // to close your dialog
                dialog.dismiss()
            }
            .setNegativeButton("Back") { dialog, which ->
                dialog.cancel()
                Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show()
                // to close your dialog
                dialog.dismiss()
            }
            .setCancelable(false)
            //Showing the Alert Dialog
            .create().show()


    }




}