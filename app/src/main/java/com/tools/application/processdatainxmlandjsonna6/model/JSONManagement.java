package com.tools.application.processdatainxmlandjsonna6.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by moh on 20/06/2017.
 */

public class JSONManagement {


    public static void processJSONData(String data){

        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray listOfStudents = jsonObject.getJSONArray("students");

            for (int i=0;i<listOfStudents.length();i++){

                JSONObject oneStudent = listOfStudents.getJSONObject(i);
                int id = oneStudent.getInt("id");
                String name = oneStudent.getString("name");
                int age = oneStudent.getInt("age");
                float bursary =(float)oneStudent.getDouble("bursary");
                Student student = new Student(id,name,age,bursary);
                Log.d("JSON",student.toString());
            }
       } catch (Exception e) {
            Log.d("JSON",e.getMessage());
        }
    }

    public static void processJSONFile(Context context,String fileName){

        AssetManager assetManager = context.getResources().getAssets();

        try {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));
            BufferedReader br = new BufferedReader(isr);
            String oneLine=null;
            StringBuilder sb = new StringBuilder();
            while ((oneLine=br.readLine())!=null)
                sb.append(oneLine);

            br.close();
            isr.close();
            processJSONData(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
