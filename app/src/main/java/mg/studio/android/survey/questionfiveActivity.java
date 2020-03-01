package mg.studio.android.survey;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.content.SharedPreferences;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;


public class questionfiveActivity extends AppCompatActivity {
    private Button mbutton;
    private CheckBox mcheckbox1;
    private CheckBox mcheckbox2;
    private CheckBox mcheckbox3;
    private CheckBox mcheckbox4;
    private CheckBox mcheckbox5;
    private CheckBox mcheckbox6;
    private CheckBox mcheckbox7;
    private String manswer5;
    private ConstraintLayout mconstraintlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_five);

        mcheckbox1=findViewById(R.id.checkbox1);
        mcheckbox2=findViewById(R.id.checkbox2);
        mcheckbox3=findViewById(R.id.checkbox3);
        mcheckbox4=findViewById(R.id.checkbox4);
        mcheckbox5=findViewById(R.id.checkbox5);
        mcheckbox6=findViewById(R.id.checkbox6);
        mcheckbox7=findViewById(R.id.checkbox7);
        mconstraintlayout=findViewById(R.id.constraintlayout);

        mbutton=findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder as5 = new StringBuilder();
                //检查checkbox
                int count = mconstraintlayout.getChildCount();
                for(int i = 0;i < count;i++){
//					获得子控件对象
                    View child = mconstraintlayout.getChildAt(i);
//					判断是否是CheckBox
                    if(child instanceof CheckBox){
//						转为CheckBox对象
                        CheckBox checkbox = (CheckBox)child;
                        if(checkbox.isChecked()){
                            as5.append(checkbox.getText()+",");
                        }
                    }
                }
                if(as5.length()!= 0)
                    manswer5=String.valueOf(as5);

                //获取SharedPreferences对象
                SharedPreferences sp = getSharedPreferences("SP", MODE_PRIVATE);
                //存入数据
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("answer5", manswer5);
                editor.commit();

                //跳转到question_six
                Intent intent=new Intent(questionfiveActivity.this, questionsixActivity.class);
                startActivity(intent);

            }
        });
    }
}
