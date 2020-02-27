package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Intent intent = getIntent();
        int code = intent.getIntExtra("code",-1);
        if (code == 0) {
            finish();
        }

        else{
            mbutton=findViewById(R.id.button);
            mbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到question_one
                    startActivity(new Intent(MainActivity.this,questiononeActivity.class));

                }
            });
        };
        }

    }

