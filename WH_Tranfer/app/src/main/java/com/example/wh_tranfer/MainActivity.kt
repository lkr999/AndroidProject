package com.example.wh_tranfer

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wh_tranfer.R.layout.activity_main
import java.sql.Connection
import java.sql.DriverManager

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
    }

    fun db_connect(view: View) {
        var txt1:TextView = findViewById(R.id.txt_1)
        txt1.text = "Hello Lee kwangryeol"

        val url = "jdbc:mysql://10.50.3.163:3306/testDB"
//        val url = "jdbc:mysql://localhost:3306/musthave?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC"
        val user = "leekr"
        val pass = "g1234"
        Class.forName("com.mysql.cj.jdbc.Driver")
        Toast.makeText(this, "Connection Ready", Toast.LENGTH_LONG).show()
        println("Connection Ready")

        var conn = DriverManager.getConnection(url, user, pass)
        println("Connection2 Ready")

//        Toast.makeText(this, "Connection2 Ready", Toast.LENGTH_LONG).show()

        var stmt = conn.createStatement();
        var rs = stmt.executeQuery("SELECT * from exam;")
        Toast.makeText(this, pass, Toast.LENGTH_LONG).show()
    }
}

