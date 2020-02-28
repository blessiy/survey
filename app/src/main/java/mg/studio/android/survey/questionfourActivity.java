package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;


public class questionfourActivity extends AppCompatActivity {
    private Button mbutton;
    private CheckBox mcheckbox1;
    private CheckBox mcheckbox2;
    private CheckBox mcheckbox3;
    private CheckBox mcheckbox4;
    private CheckBox mcheckbox5;
    private CheckBox mcheckbox6;
    private CheckBox mcheckbox7;
    private String manswer4;
    private LinearLayout mlinearlayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_four);

        mcheckbox1=findViewById(R.id.checkbox1);
        mcheckbox2=findViewById(R.id.checkbox2);
        mcheckbox3=findViewById(R.id.checkbox3);
        mcheckbox4=findViewById(R.id.checkbox4);
        mcheckbox5=findViewById(R.id.checkbox5);
        mcheckbox6=findViewById(R.id.checkbox6);
        mcheckbox7=findViewById(R.id.checkbox7);
        mlinearlayout=findViewById(R.id.linearlayout);


        mbutton=findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder as4 = new StringBuilder();
                //检查checkbox
                int count = mlinearlayout.getChildCount();
                for(int i = 0;i < count;i++){
//					获得子控件对象
                    View child = mlinearlayout.getChildAt(i);
//					判断是否是CheckBox
                    if(child instanceof CheckBox){
//						转为CheckBox对象
                        CheckBox checkbox = (CheckBox)child;
                        if(checkbox.isChecked()){
                            as4.append(checkbox.getText()+",");
                        }
                    }
                }
                if(as4.length()!= 0)
                    manswer4=String.valueOf(as4);

                //获取SharedPreferences对象
                SharedPreferences sp = getSharedPreferences("SP", MODE_PRIVATE);
                //存入数据
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("answer4", manswer4);
                editor.commit();


                //跳转到question_two
                Intent intent=new Intent(questionfourActivity.this, questionfiveActivity.class);
                startActivity(intent);

            }
        });
    }
}
