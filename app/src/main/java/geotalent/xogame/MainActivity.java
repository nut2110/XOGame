package geotalent.xogame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        title.setText(R.string.app_name);
        YoYo.with(Techniques.Pulse).repeat(YoYo.INFINITE).playOn(title);
    }

    @OnClick(R.id.btnXO)
    void onBtnXO(){
        startActivity(new Intent(MainActivity.this,BoardActivity.class));
    }

}
