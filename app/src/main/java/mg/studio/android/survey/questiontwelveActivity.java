package mg.studio.android.survey;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
public class questiontwelveActivity extends AppCompatActivity {

    private Button mbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_twelve);
        mbutton=findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到finish_survey
                Intent intent=new Intent(questiontwelveActivity.this, finishsurveyActivity.class);
                startActivity(intent);

            }
        });

    }
}
