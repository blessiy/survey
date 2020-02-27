package mg.studio.android.survey;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class questionfiveActivity extends AppCompatActivity {
    private Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_five);
        mbutton=findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到question_six
                Intent intent=new Intent(questionfiveActivity.this, questionsixActivity.class);
                startActivity(intent);

            }
        });
    }
}
