package com.example.qrcode_ex

import android.widget.TextView
import org.w3c.dom.Text
import java.sql.*
import java.util.Properties

/**
 * Program to list databases in MySQL using Kotlin
 */
object MySQLDatabaseExampleKotlin {

    internal var conn: Connection? = null
    internal var username = "leekr" // provide the username
    internal var password = "g1234" // provide the corresponding password

    @JvmStatic fun main(args: Array<String>) {
        // make a connection to MySQL Server
        getConnection()
        // execute the query via connection object
        executeMySQLQuery()
    }


    fun executeMySQLQuery() {
        var stmt: Statement? = null
        var resultset: ResultSet? = null

        try {
            stmt = conn!!.createStatement()
            resultset = stmt!!.executeQuery("SHOW DATABASES;")

            if (stmt.execute("SHOW DATABASES;")) {
                resultset = stmt.resultSet
            }

            while (resultset!!.next()) {
                println(resultset.getString("Database"))
            }
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            if (resultset != null) {
                try {
                    resultset.close()
                } catch (sqlEx: SQLException) {
                }

                resultset = null
            }

            if (stmt != null) {
                try {
                    stmt.close()
                } catch (sqlEx: SQLException) {
                }

                stmt = null
            }

            if (conn != null) {
                try {
                    conn!!.close()
                } catch (sqlEx: SQLException) {
                }

                conn = null
            }
        }
    }

    /**
     * This method makes a connection to MySQL Server
     * In this example, MySQL Server is running in the local host (so 127.0.0.1)
     * at the standard port 3306
     */
    fun getConnection():String {
        val connectionProps = Properties()
        var msg_1:String = ""
        var chk:String = ""
        connectionProps.put("leekr", username)
        connectionProps.put("g1234", password)
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "10.50.3.163" +
                        ":" + "3306" + "/" +
                        "testDB",
                connectionProps)
            chk = "CHK OK"
            msg_1 = "Succeed"
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
            msg_1 = "SQL Exception"
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
            msg_1 = "Exception"
        }

        return chk
    }

}