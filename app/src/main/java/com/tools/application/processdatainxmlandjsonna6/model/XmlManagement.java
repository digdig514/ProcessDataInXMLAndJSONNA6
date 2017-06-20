package com.tools.application.processdatainxmlandjsonna6.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Created by moh on 19/06/2017.
 */

public class XmlManagement {

    private static final String ID_TAG="id",
                        NAME_TAG="name",
                        AGE_TAG="age",
                        BURSARY_TAG="bursary";


    private static int id,age;
    private static String name;
    private static float bursary;

    private static boolean parsingId,parsingName,parsingAge,parsingBursary;

    public static void processXMLData(Context context,String xmlData){
        XmlPullParserFactory factory =null;

        try {
            factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            StringReader sr = new StringReader(xmlData);
            xpp.setInput(sr);

            while (xpp.getEventType()!=XmlPullParser.END_DOCUMENT){

                switch (xpp.getEventType()){

                    case XmlPullParser.START_TAG :
                        processStartTag(xpp.getName());
                        break;
                    case XmlPullParser.END_TAG :
                        processEndTag(xpp.getName());
                        break;
                    case XmlPullParser.TEXT :
                        processText(xpp.getText());
                        break;
                }

                xpp.next();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void processXMLFile(Context context,String fileName){
        XmlPullParserFactory factory;
        AssetManager assetManager = context.getResources().getAssets();

        try {
            factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));
            xpp.setInput(isr);

            while (xpp.getEventType()!=XmlPullParser.END_DOCUMENT){

                switch (xpp.getEventType()){

                    case XmlPullParser.START_TAG :
                        processStartTag(xpp.getName());
                        break;
                    case XmlPullParser.END_TAG :
                        processEndTag(xpp.getName());
                        break;
                    case XmlPullParser.TEXT :
                        processText(xpp.getText());
                        break;


                }
                xpp.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static void processStartTag(String name) {
        if (name.equals(ID_TAG))
            parsingId=true;
        if (name.equals(NAME_TAG))
            parsingName=true;
        if (name.equals(AGE_TAG))
            parsingAge=true;
        if (name.equals(BURSARY_TAG))
            parsingBursary=true;
    }

    private static void processEndTag(String nameParam) {

        if (nameParam.equals(ID_TAG))
            parsingId=false;
        if (nameParam.equals(NAME_TAG))
            parsingName=false;
        if (nameParam.equals(AGE_TAG))
            parsingAge=false;
        if (nameParam.equals(BURSARY_TAG)) {
            parsingBursary = false;
            Student student = new Student(id, name, age, bursary);
            Log.d("XML", student.toString());
        }

    }

    private static void processText(String text) {

        if (parsingId)
            id=Integer.valueOf(text);
        if (parsingName)
            name=text;
        if (parsingAge)
            age=Integer.valueOf(text);
        if (parsingBursary)
            bursary=Float.valueOf(text);

    }


}
