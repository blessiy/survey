package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class reportActivity extends AppCompatActivity {

    private TextView manswer1;
    private TextView manswer2;
    private TextView manswer3;
    private TextView manswer4;
    private TextView manswer5;
    private TextView manswer6;
    private TextView manswer7;
    private TextView manswer8;
    private TextView manswer9;
    private TextView manswer10;
    private TextView manswer11;
    private TextView manswer12;

    private Button finishbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

        manswer1=findViewById(R.id.answer1);
        manswer2=findViewById(R.id.answer2);
        manswer3=findViewById(R.id.answer3);
        manswer4=findViewById(R.id.answer4);
        manswer5=findViewById(R.id.answer5);
        manswer6=findViewById(R.id.answer6);
        manswer7=findViewById(R.id.answer7);
        manswer8=findViewById(R.id.answer8);
        manswer9=findViewById(R.id.answer9);
        manswer10=findViewById(R.id.answer10);
        manswer11=findViewById(R.id.answer11);
        manswer12=findViewById(R.id.answer12);
        //获取SharedPreferences对象
        SharedPreferences sp=getSharedPreferences("SP", MODE_PRIVATE);
        //读取数据
        manswer1.setText(sp.getString("answer1",""));
        manswer2.setText(sp.getString("answer2",""));
        manswer3.setText(sp.getString("answer3",""));
        manswer4.setText(sp.getString("answer4",""));
        manswer5.setText(sp.getString("answer5",""));
        manswer6.setText(sp.getString("answer6",""));
        manswer7.setText(sp.getString("answer7",""));
        manswer8.setText(sp.getString("answer8",""));
        manswer9.setText(sp.getString("answer9",""));
        manswer10.setText(sp.getString("answer10",""));
        manswer11.setText(sp.getString("answer11",""));
        manswer12.setText(sp.getString("answer12",""));


        //跳转到MainActivity
        finishbutton=findViewById(R.id.button);
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
}
