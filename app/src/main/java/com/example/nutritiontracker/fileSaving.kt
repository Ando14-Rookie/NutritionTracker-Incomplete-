package com.example.nutritiontracker

import android.content.Context
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class fileSaving {

    //to Define the name of the File
    val FILENAME1 = "nutritionData.dat"
    val FILENAME2 = "nutritionData.dat"
    val FILENAME3 = "nutritionData.dat"

    fun writeDataName1(item: ArrayList<String>, context: Context)
    {

        //Class to write data in a file
        //Create & Open a private file in the Device Memory to write Data
        var fos : FileOutputStream = context.openFileOutput(FILENAME1,Context.MODE_PRIVATE)

        // writes primitive data types and graphs of Java objects to an OutputStream.
        var oas = ObjectOutputStream(fos)

        // The Object to be Written
        oas.writeObject(item)
        // Close the file
        oas.close()
    }

    fun writeDataName2(item: ArrayList<String>, context: Context)
    {

        //Class to write data in a file
        //Create & Open a private file in the Device Memory to write Data
        var fos : FileOutputStream = context.openFileOutput(FILENAME2,Context.MODE_PRIVATE)

        // writes primitive data types and graphs of Java objects to an OutputStream.
        var oas = ObjectOutputStream(fos)

        // The Object to be Written
        oas.writeObject(item)
        // Close the file
        oas.close()
    }

    fun writeDataName3(item: ArrayList<Int>, context: Context)
    {

        //Class to write data in a file
        //Create & Open a private file in the Device Memory to write Data
        var fos : FileOutputStream = context.openFileOutput(FILENAME3,Context.MODE_PRIVATE)

        // writes primitive data types and graphs of Java objects to an OutputStream.
        var oas = ObjectOutputStream(fos)

        // The Object to be Written
        oas.writeObject(item)
        // Close the file
        oas.close()
    }

    fun readDataName1(context: Context) : ArrayList<String>
    {

        // Creating Array List which will be shown in the Recycler View
        var itemName: ArrayList<String>

        try {
            //Open a private file in the Device Memory to read Data
            var fis: FileInputStream = context.openFileInput(FILENAME1)

            // used to read data written by the ObjectOutputStream
            var ois = ObjectInputStream(fis)

            // Add data to the Array List
            itemName = ois.readObject() as ArrayList<String>
        } catch (e : FileNotFoundException) {
            // to define what happen if it got an error
            itemName = ArrayList()}

        return itemName
    }

    fun readDataName2(context: Context) : ArrayList<String>
    {

        // Creating Array List which will be shown in the Recycler View
        var itemName: ArrayList<String>

        try {
            //Open a private file in the Device Memory to read Data
            var fis: FileInputStream = context.openFileInput(FILENAME1)

            // used to read data written by the ObjectOutputStream
            var ois = ObjectInputStream(fis)

            // Add data to the Array List
            itemName = ois.readObject() as ArrayList<String>
        } catch (e : FileNotFoundException) {
            // to define what happen if it got an error
            itemName = ArrayList()}

        return itemName
    }

    fun readDataName3(context: Context) : ArrayList<Int>
    {

        // Creating Array List which will be shown in the Recycler View
        var itemName: ArrayList<Int>

        try {
            //Open a private file in the Device Memory to read Data
            var fis: FileInputStream = context.openFileInput(FILENAME3)

            // used to read data written by the ObjectOutputStream
            var ois = ObjectInputStream(fis)

            // Add data to the Array List
            itemName = ois.readObject() as ArrayList<Int>
        } catch (e : FileNotFoundException) {
            // to define what happen if it got an error
            itemName = ArrayList()}

        return itemName
    }


/*
    fun writeDataType(item: ArrayList<String>, context: Context)
    {

        //Class to write data in a file
        //Create & Open a private file in the Device Memory to write Data
        var fos : FileOutputStream = context.openFileOutput("FILEDATA", Context.MODE_PRIVATE)

        // writes primitive data types and graphs of Java objects to an OutputStream.
        var oas = ObjectOutputStream(fos)

        // The Object to be Written
        oas.writeObject(item)
        // Close the file
        oas.close()
    }

    fun writeDataAmount(item: ArrayList<String>, context: Context)
    {

        //Class to write data in a file
        //Create & Open a private file in the Device Memory to write Data
        var fos : FileOutputStream = context.openFileOutput("FILEDATA", Context.MODE_PRIVATE)

        // writes primitive data types and graphs of Java objects to an OutputStream.
        var oas = ObjectOutputStream(fos)

        // The Object to be Written
        oas.writeObject(item)
        // Close the file
        oas.close()
    }

    // Returning Values
    fun readDataType(context: Context) : ArrayList<String>
    {

        // Creating Array List which will be shown in the Recycler View
        var itemType: ArrayList<String>

        try {
            //Open a private file in the Device Memory to read Data
            var fis: FileInputStream = context.openFileInput("FILEDATA")

            // used to read data written by the ObjectOutputStream
            var ois = ObjectInputStream(fis)

            // Add data to the Array List
            itemType = ois.readObject() as ArrayList<String>
        } catch (e : FileNotFoundException) {
            // to define what happen if it got an error
            itemType = ArrayList()}

        return itemType
    }

    fun readDataAmount(context: Context) : ArrayList<String>
    {

        // Creating Array List which will be shown in the Recycler View
        var itemAmount: ArrayList<String>

        try {
            //Open a private file in the Device Memory to read Data
            var fis: FileInputStream = context.openFileInput("FILEDATA")

            // used to read data written by the ObjectOutputStream
            var ois = ObjectInputStream(fis)

            // Add data to the Array List
            itemAmount = ois.readObject() as ArrayList<String>
        } catch (e : FileNotFoundException) {
            // to define what happen if it got an error
            itemAmount = ArrayList()}

        return itemAmount
    }
    */

}