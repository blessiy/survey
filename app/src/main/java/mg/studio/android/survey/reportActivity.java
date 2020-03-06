package mg.studio.android.survey;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

public class reportActivity extends AppCompatActivity {
    private TextView mques1;
    private TextView manswer1;
    private TextView mques2;
    private TextView manswer2;
    private TextView mques3;
    private TextView manswer3;
    private TextView mques4;
    private TextView manswer4;
    private TextView mques5;
    private TextView manswer5;
    private TextView mques6;
    private TextView manswer6;
    private TextView mques7;
    private TextView manswer7;
    private TextView mques8;
    private TextView manswer8;
    private TextView mques9;
    private TextView manswer9;
    private TextView mques10;
    private TextView manswer10;
    private TextView mques11;
    private TextView manswer11;
    private TextView mques12;
    private TextView manswer12;
    private Button finishbutton;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

        mques1=findViewById(R.id.question1);
        manswer1 = findViewById(R.id.answer1);
        mques2=findViewById(R.id.question2);
        manswer2 = findViewById(R.id.answer2);
        mques3=findViewById(R.id.question3);
        manswer3 = findViewById(R.id.answer3);
        mques4=findViewById(R.id.question4);
        manswer4 = findViewById(R.id.answer4);
        mques5=findViewById(R.id.question5);
        manswer5 = findViewById(R.id.answer5);
        mques6=findViewById(R.id.question6);
        manswer6 = findViewById(R.id.answer6);
        mques7=findViewById(R.id.question7);
        manswer7 = findViewById(R.id.answer7);
        mques8=findViewById(R.id.question8);
        manswer8 = findViewById(R.id.answer8);
        mques9=findViewById(R.id.question9);
        manswer9 = findViewById(R.id.answer9);
        mques10=findViewById(R.id.question10);
        manswer10 = findViewById(R.id.answer10);
        mques11=findViewById(R.id.question11);
        manswer11 = findViewById(R.id.answer11);
        mques12=findViewById(R.id.question12);
        manswer12 = findViewById(R.id.answer12);
        //获取SharedPreferences对象
        SharedPreferences sp = getSharedPreferences("SP", MODE_PRIVATE);
        //读取数据
        manswer1.setText(sp.getString("answer1", ""));
        manswer2.setText(sp.getString("answer2", ""));
        manswer3.setText(sp.getString("answer3", ""));
        manswer4.setText(sp.getString("answer4", ""));
        manswer5.setText(sp.getString("answer5", ""));
        manswer6.setText(sp.getString("answer6", ""));
        manswer7.setText(sp.getString("answer7", ""));
        manswer8.setText(sp.getString("answer8", ""));
        manswer9.setText(sp.getString("answer9", ""));
        manswer10.setText(sp.getString("answer10", ""));
        manswer11.setText(sp.getString("answer11", ""));
        manswer12.setText(sp.getString("answer12", ""));

        String [] mans=new String [12];
        mans[0]=manswer1.getText().toString();
        mans[1]=manswer2.getText().toString();
        mans[2]=manswer3.getText().toString();
        mans[3]=manswer4.getText().toString();
        mans[4]=manswer5.getText().toString();
        mans[5]=manswer6.getText().toString();
        mans[6]=manswer7.getText().toString();
        mans[7]=manswer8.getText().toString();
        mans[8]=manswer9.getText().toString();
        mans[9]=manswer10.getText().toString();
        mans[10]=manswer11.getText().toString();
        mans[11]=manswer12.getText().toString();

        String [] mqs = new String [12];
        mqs[0]=mques1.getText().toString();
        mqs[1]=mques2.getText().toString();
        mqs[2]=mques3.getText().toString();
        mqs[3]=mques4.getText().toString();
        mqs[4]=mques5.getText().toString();
        mqs[5]=mques6.getText().toString();
        mqs[6]=mques7.getText().toString();
        mqs[7]=mques8.getText().toString();
        mqs[8]=mques9.getText().toString();
        mqs[9]=mques10.getText().toString();
        mqs[10]=mques11.getText().toString();
        mqs[11]=mques12.getText().toString();

        //转换为Json数据
        JSONArray array =new JSONArray();
        for(int i=0; i<12; i++) {
            JSONObject object =new JSONObject(new LinkedHashMap());
                object.put("Question",mqs[i]);
                object.put("Answer",mans[i]);
                array.add(object);
            }
        JSONObject obj =new JSONObject(new LinkedHashMap());
        obj.put("SurveyData",array);

        verifyStoragePermissions(reportActivity.this);

        try {
            //存储saveData到sd卡上
            new saveFileInEx().saveFile(obj);
            //存储saveData到内部存储
            new saveFileInEx().saveFileInner(obj);
            Toast.makeText(reportActivity.this,"成功存入SD卡和App中！",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //跳转到MainActivity
        finishbutton = findViewById(R.id.button);
        finishbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(reportActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("code", 0);
                startActivity(intent);
                finish();
            }
        });

    }

    public class saveFileInEx{

        public void saveFile(JSONObject jsonObject)
                throws IOException {

            File path =Environment.getExternalStorageDirectory();
            File saveData = new File(path, "saveData.json");
            FileOutputStream fout=new FileOutputStream(saveData,true);
            fout.write(jsonObject.toJSONString().getBytes());
            fout.write("\r\n".getBytes());
            fout.flush();
            fout.close();

        }

        //存储文件到内部存储
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void saveFileInner(JSONObject jsonObject)
                throws IOException {
            File pathInner=getApplicationContext().getDataDir();
            File saveDataInner=new File(pathInner, "saveDataInner.json");
            FileOutputStream foutcode=new FileOutputStream(saveDataInner,true);
            foutcode.write(jsonObject.toJSONString().getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.flush();
            foutcode.close();

        }
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };

    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



