package geotalent.xogame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BoardActivity extends AppCompatActivity {
    BoardViewHolder view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        view = new BoardViewHolder(this);
    }
}
