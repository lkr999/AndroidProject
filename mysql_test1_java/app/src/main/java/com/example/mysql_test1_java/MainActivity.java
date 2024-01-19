package com.example.mysql_test1_java;

import static com.example.mysql_test1_java.R.layout.activity_main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
    }

    public void db_connect(View view) throws SQLException {
        String url = "jdbc:mysql://10.50.3.163:3306/testDB";
        String user = "leekr";
        String pass = "g1234";

        Connection conn = null;

        conn = DriverManager.getConnection(url, user, pass);
        System.out.println("CHK OK ");

    }
}