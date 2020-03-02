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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
    private String mqs1;
    private String mans1;
    private String mqs2;
    private String mans2;
    private String mqs3;
    private String mans3;
    private String mqs4;
    private String mans4;
    private String mqs5;
    private String mans5;
    private String mqs6;
    private String mans6;
    private String mqs7;
    private String mans7;
    private String mqs8;
    private String mans8;
    private String mqs9;
    private String mans9;
    private String mqs10;
    private String mans10;
    private String mqs11;
    private String mans11;
    private String mqs12;
    private String mans12;

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

        mans1=manswer1.getText().toString();
        mans2=manswer2.getText().toString();
        mans3=manswer3.getText().toString();
        mans4=manswer4.getText().toString();
        mans5=manswer5.getText().toString();
        mans6=manswer6.getText().toString();
        mans7=manswer7.getText().toString();
        mans8=manswer8.getText().toString();
        mans9=manswer9.getText().toString();
        mans10=manswer10.getText().toString();
        mans11=manswer11.getText().toString();
        mans12=manswer12.getText().toString();

        mqs1=mques1.getText().toString();
        mqs2=mques2.getText().toString();
        mqs3=mques3.getText().toString();
        mqs4=mques4.getText().toString();
        mqs5=mques5.getText().toString();
        mqs6=mques6.getText().toString();
        mqs7=mques7.getText().toString();
        mqs8=mques8.getText().toString();
        mqs9=mques9.getText().toString();
        mqs10=mques10.getText().toString();
        mqs11=mques11.getText().toString();
        mqs12=mques12.getText().toString();

        verifyStoragePermissions(reportActivity.this);

        try {
            //存储saveData到sd卡上
              new saveFileInEx().saveFile(mqs1,mans1,
                     mqs2,mans2,
                     mqs3,mans3,
                     mqs4,mans4,
                     mqs5,mans5,
                     mqs6,mans6,
                     mqs7,mans7,
                     mqs8,mans8,
                     mqs9,mans9,
                     mqs10,mans10,
                     mqs11,mans11,
                     mqs12,mans12
                    );
            //存储saveData到内部存储
            new saveFileInEx().saveFileInner(mqs1,mans1,
                    mqs2,mans2,
                    mqs3,mans3,
                    mqs4,mans4,
                    mqs5,mans5,
                    mqs6,mans6,
                    mqs7,mans7,
                    mqs8,mans8,
                    mqs9,mans9,
                    mqs10,mans10,
                    mqs11,mans11,
                    mqs12,mans12
            );
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

        public void saveFile
        (String message1,
         String message2,
         String message3,
         String message4,
         String message5,
         String message6,
         String message7,
         String message8,
         String message9,
         String message10,
         String message11,
         String message12,
         String message13,
         String message14,
         String message15,
         String message16,
         String message17,
         String message18,
         String message19,
         String message20,
         String message21,
         String message22,
         String message23,
         String message24
        )
                throws IOException {

            File path =Environment.getExternalStorageDirectory();
            File saveData = new File(path, "saveData.json");
            FileOutputStream fout=new FileOutputStream(saveData);
            fout.write(message1.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message2.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message3.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message4.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message5.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message6.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message7.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message8.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message9.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message10.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message11.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message12.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message13.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message14.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message15.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message16.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message17.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message18.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message19.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message20.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message21.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message22.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message23.getBytes());
            fout.write("\r\n".getBytes());
            fout.write(message24.getBytes());
            fout.write("\r\n".getBytes());
            fout.write("\r\n".getBytes());
            fout.write("\r\n".getBytes());
            fout.flush();
            fout.close();

        }

        //存储文件到内部存储
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void saveFileInner
        (String message1,
         String message2,
         String message3,
         String message4,
         String message5,
         String message6,
         String message7,
         String message8,
         String message9,
         String message10,
         String message11,
         String message12,
         String message13,
         String message14,
         String message15,
         String message16,
         String message17,
         String message18,
         String message19,
         String message20,
         String message21,
         String message22,
         String message23,
         String message24
        )
                throws IOException {
            File pathInner=getApplicationContext().getDataDir();
            File saveDataInner=new File(pathInner, "saveDataInner.json");
            FileOutputStream foutcode=new FileOutputStream(saveDataInner);

            foutcode.write(message1.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message2.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message3.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message4.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message5.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message6.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message7.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message8.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message9.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message10.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message11.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message12.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message13.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message14.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message15.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message16.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message17.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message18.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message19.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message20.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message21.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message22.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message23.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write(message24.getBytes());
            foutcode.write("\r\n".getBytes());
            foutcode.write("\r\n".getBytes());
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



