package mdzz.com.first_of_mdzz.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.utils.ToastHelper;

public class MainActivity extends AppCompatActivity  implements  MainContract.IMainView{
  private int INTERVAL_OF_TWO_CLICK_TO_QUIT =1000;
    private  long mLastPressBackTime ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - mLastPressBackTime < INTERVAL_OF_TWO_CLICK_TO_QUIT) {

            finish();
        } else {
            ToastHelper.showToast(this,"再次按下返回键将退出应用!", Toast.LENGTH_SHORT);

            //Toast.makeText(this, "再次按下返回键将退出应用！", Toast.LENGTH_SHORT).show();
            mLastPressBackTime = System.currentTimeMillis();
        }
    }

}
