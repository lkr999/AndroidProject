package com.example.mysql_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.mysql_ex1.R.layout.activity_main
import java.sql.DriverManager
import java.time.LocalDate


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
    }

    fun db_conn(view: View) {
        var txt1: TextView = findViewById(R.id.txt_1)
        txt1.text = "Hello Lee kwangryeol very nice "

        val url = "jdbc:mysql://127.0.0.1:3306/android_db"
//        val url = "jdbc:mysql://localhost:3306/musthave?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC"
        val user = "root"
        val pass = "tncjf5180"
        Class.forName("com.mysql.cj.jdbc.Driver")
        Toast.makeText(this, "Connection Ready", Toast.LENGTH_LONG).show()
        var conn = DriverManager.getConnection(url, user, pass)
        Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show()

//        var stmt = conn.createStatement();
//        var rs = stmt.executeQuery("SELECT * from scanner;")
        Toast.makeText(this, pass, Toast.LENGTH_LONG).show()

    }

    fun db_sharedP(view: View) {

        lateinit var dbHelper: DBHelper
        dbHelper=DBHelper.getInstance(this)

        val date1 = LocalDate.parse("2023-01-01")
        val date2 = LocalDate.parse("2023-03-01")
        val date3 = LocalDate.parse("2023-04-04")
        dbHelper.insertReservation(date1)
        dbHelper.insertReservation(100,date2)
        dbHelper.insertReservation(date3)
        dbHelper.insertReservation(111, LocalDate.parse("2023-05-05"))
        dbHelper.updateReservationDate(2, LocalDate.parse("2020-03-01"))



    }
}


