package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class questiontwoActivity extends AppCompatActivity {

    private Button mbutton;
    private RadioButton mradiobutton;
    private String manswer2;
    private RadioGroup mradiogroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_two);

        mradiogroup=findViewById(R.id.radiogroup);
        //radiogroup传值
        mradiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mradiobutton = findViewById(mradiogroup.getCheckedRadioButtonId());
                manswer2=String.valueOf(mradiobutton.getText());

                //获取SharedPreferences对象
                SharedPreferences sp = getSharedPreferences("SP", MODE_PRIVATE);
                //存入数据
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("answer2", manswer2);
                editor.commit();
            }
        });


        mbutton=findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到question_three
                Intent intent=new Intent(questiontwoActivity.this, questionthreeActivity.class);
                startActivity(intent);

            }
        });
    }
}
