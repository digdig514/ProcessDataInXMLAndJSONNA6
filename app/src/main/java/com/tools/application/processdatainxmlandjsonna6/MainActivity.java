package com.tools.application.processdatainxmlandjsonna6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tools.application.processdatainxmlandjsonna6.model.JSONManagement;
import com.tools.application.processdatainxmlandjsonna6.model.XmlManagement;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnProcessXmlData,btnProcessXmlFile;
    Button btnProcessJSONData,btnProcessJSONFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {

        btnProcessXmlData=(Button)findViewById(R.id.btnProcessXmlData);
        btnProcessXmlFile = (Button)findViewById(R.id.btnProcessXmlFile);
        btnProcessJSONData = (Button)findViewById(R.id.btnProcessJSONData);
        btnProcessJSONFile = (Button)findViewById(R.id.btnProcessJSONFile);

        btnProcessXmlData.setOnClickListener(this);
        btnProcessXmlFile.setOnClickListener(this);
        btnProcessJSONData.setOnClickListener(this);
        btnProcessJSONFile.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnProcessXmlData :
                String xmlData="<list>\n" +
                        "    <student>\n" +
                        "        <id>100</id>\n" +
                        "        <name>Marc</name>\n" +
                        "        <age>25</age>\n" +
                        "        <bursary>1245.45</bursary>\n" +
                        "    </student>\n" +
                        "    <student>\n" +
                        "        <id>200</id>\n" +
                        "        <name>Ahmad</name>\n" +
                        "        <age>37</age>\n" +
                        "        <bursary>1789.90</bursary>\n" +
                        "    </student>\n" +
                        "</list>";
                XmlManagement.processXMLData(this,xmlData);

            case R.id.btnProcessXmlFile :
                XmlManagement.processXMLFile(this,"student.xml");
                break;
            case R.id.btnProcessJSONData :
                String jsonData="{\"students\":[\n" +
                        "  {\"id\":100,\"name\":\"Marc\", \"age\":24,\"bursary\":1245.45},\n" +
                        "  {\"id\":200,\"name\":\"Ahmad\",\"age\":37,\"bursary\":1789.90}\n" +
                        "]\n" +
                        "}";
                JSONManagement.processJSONData(jsonData);
                break;
            case R.id.btnProcessJSONFile :
                JSONManagement.processJSONFile(this,"students.json");
                break;
        }
    }
}
