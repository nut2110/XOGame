package geotalent.xogame;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dhero on 10/16/2017.
 */

public class BoardViewHolder implements View.OnClickListener {

    @BindView(R.id.mark1)
    ImageView mark1;

    @BindView(R.id.mark2)
    ImageView mark2;

    @BindView(R.id.mark3)
    ImageView mark3;

    @BindView(R.id.mark4)
    ImageView mark4;

    @BindView(R.id.mark5)
    ImageView mark5;

    @BindView(R.id.mark6)
    ImageView mark6;

    @BindView(R.id.mark7)
    ImageView mark7;

    @BindView(R.id.mark8)
    ImageView mark8;

    @BindView(R.id.mark9)
    ImageView mark9;

    @BindDrawable(R.drawable.cross)
    Drawable cross;

    @BindDrawable(R.drawable.circle)
    Drawable circle;

    private int player;

    private Integer[][] winChk = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 5}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};

    private Integer[] boardPlay = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    private Dialog dialog;

    private YoYo.YoYoString animation;

    public BoardViewHolder(AppCompatActivity activity) {
        super();
        ButterKnife.bind(this, activity);
        setGame();
    }

    @Override
    public void onClick(View view) {
        ImageView mark = (ImageView) view;
        int markPosition = Integer.parseInt(mark.getTag().toString());
        if (mark.getDrawable() == null) {
            if (player == 1) {
                setPlayTurn(mark, cross);
                boardPlay[markPosition] = 1;
                player = 2;
            } else if (player == 2) {
                setPlayTurn(mark, circle);
                boardPlay[markPosition] = 2;
                player = 1;
            }
            if (winCheck() > 0) {
                showDialog(view);
            }
        }
    }

    private void showDialog(View view){
        dialog = new Dialog(view.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_winner);
        dialog.setCanceledOnTouchOutside(false);
        ((TextView)dialog.findViewById(R.id.dialogMessage)).setText(String.format("Player %d is Winner",winCheck()));
        (dialog.findViewById(R.id.resetBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setGame();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void setPlayTurn(ImageView mark, Drawable drawable) {
        mark.setImageDrawable(drawable);
        animation = YoYo.with(Techniques.BounceIn).playOn(mark);
    }

    private int winCheck() {
        for (Integer[] winchk : winChk) {
            if (boardPlay[winchk[0]] == 1 &&
                    boardPlay[winchk[1]] == 1&&
                    boardPlay[winchk[2]] == 1){
                return 1;
            }else if (boardPlay[winchk[0]] == 2&&
                    boardPlay[winchk[1]] == 2&&
                    boardPlay[winchk[2]] == 2){
                return 2;
            }
        }
        return 0;
    }

    private void setGame() {
        player = 1;
        winChk = new Integer[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 4}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        boardPlay = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        mark1.setOnClickListener(this);
        mark2.setOnClickListener(this);
        mark3.setOnClickListener(this);
        mark4.setOnClickListener(this);
        mark5.setOnClickListener(this);
        mark6.setOnClickListener(this);
        mark7.setOnClickListener(this);
        mark8.setOnClickListener(this);
        mark9.setOnClickListener(this);
        mark1.setImageDrawable(null);
        mark2.setImageDrawable(null);
        mark3.setImageDrawable(null);
        mark4.setImageDrawable(null);
        mark5.setImageDrawable(null);
        mark6.setImageDrawable(null);
        mark7.setImageDrawable(null);
        mark8.setImageDrawable(null);
        mark9.setImageDrawable(null);
    }
}
