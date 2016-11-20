package mdzz.com.first_of_mdzz.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mdzz.com.first_of_mdzz.R;

public class MineReuseActivity extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_reuse);
        initView();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("1");
        tv.setText(stringExtra);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.mine_user_tv);
        iv = (ImageView) findViewById(R.id.mine_user_iv);
    }
}
