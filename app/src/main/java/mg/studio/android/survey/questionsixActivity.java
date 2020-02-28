package mg.studio.android.survey;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class questionsixActivity extends AppCompatActivity {

    private Button mbutton;
    private String manswer6;
    private EditText medittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_six);

        mbutton=findViewById(R.id.button);
        medittext=findViewById(R.id.edittext);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //edittext传值
                manswer6=String.valueOf(medittext.getText());
                //获取SharedPreferences对象
                SharedPreferences sp = getSharedPreferences("SP", MODE_PRIVATE);
                //存入数据
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("answer6", manswer6);
                editor.commit();

                //跳转到question_seven
                Intent intent=new Intent(questionsixActivity.this, questionsevenActivity.class);
                startActivity(intent);

            }
        });
    }
}
