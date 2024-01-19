package com.example.qrcode_ex

import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import java.sql.DriverManager

public class InfoAsyncTask: AsyncTask<Void, Void, Map<String, String>>() {
    override fun doInBackground(vararg p0: Void?): Map<String, String> {
        val info = mutableMapOf<String, String>()
        val user:String = "leekr"
        val pass:String = "g1234"
        val jdbc_url:String = "jdbc:mysql://10.50.3.163:3306/testDB"
        val sql:String = "select * from exam;"

        try{
            val connection = DriverManager.getConnection(jdbc_url, user, pass)
            val statement = connection.prepareStatement(sql)
            val resultSet = statement.executeQuery()
            if(resultSet.next()){
                info["name"] = resultSet.getString("name")
                info["passwd"] = resultSet.getString("passwd")
            }
        }catch (e:Exception){
            Log.e("InfoAsyncTask", "Error reading school information", e)
        }
        return info
    }

    override fun onPostExecute(result: Map<String, String>?) {
        val myLoginPass: String = ""

    }

    private fun finish() {
        TODO("Not yet implemented")
    }
}


