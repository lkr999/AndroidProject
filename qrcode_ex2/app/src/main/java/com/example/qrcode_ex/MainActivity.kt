package com.example.qrcode_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.qrcode_ex.MySQLDatabaseExampleKotlin.conn
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

data class User(val name: String, val email: String, val num: String)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startQRcode(view: View) {
        setContentView(R.layout.sign_up)
    }

    fun return_to_main(view: View) {
        setContentView(R.layout.activity_main)
    }
    fun register(view: View) {

        val conn:Connection? = connectToDatabase()
//        var data_val = getAllUsers(connection=conn)


        Toast.makeText(this,conn.toString(), Toast.LENGTH_LONG).show()
    }



    fun connectToDatabase(): Connection? {
        val url = "jdbc:mysql://10.50.3.163:3306/testDB"
        val user = "leekr"
        val password = "g1234"

//        Class.forName("com.mysql.jdbc.Driver"   Toast.makeText(this,"Call CHK OK ", Toast.LENGTH_LONG).show()
        return DriverManager.getConnection("jdbc:mysql://10.50.3.163:3306/testDB", "leekr", "g1234")
    }

    private fun getAllUsers(connection: Connection): List<User> {
        val sql = "SELECT * FROM exam;"

        return try {
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery(sql)

            val users = ArrayList<User>()

            while (resultSet.next()) {
                val num = resultSet.getString("id")
                val name = resultSet.getString("name")
                val email = resultSet.getString("email")

                val user = User(num, name, email)
                users.add(user)
            }

            users
        } catch (e: SQLException) {
            println("An error occurred while executing the SQL query: $sql")
            println(e.message)

            ArrayList()
        }
    }

}