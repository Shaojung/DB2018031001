package com.example.student.db2018031001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    File p;
    File myFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p = getFilesDir();
        myFile = new File(p, "myfile.txt");
        Log.d("MyFile", myFile.toString());
    }
    public void clickRead(View v)
    {
        try {
            FileReader fr = new FileReader(myFile);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Log.d("DATA", str);
            Gson gson = new Gson();
            Student mystu = gson.fromJson(str, Student.class);
            Toast.makeText(MainActivity.this, mystu.name, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void clickWrite(View v)
    {
        try {
            Student stu = new Student();
            stu.ID = 1;
            stu.name = "Bob";
            stu.score = 95;
            FileWriter fw = new FileWriter(myFile);
            Gson gson = new Gson();

            String str = gson.toJson(stu);
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
