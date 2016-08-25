package jp.premama.weightmanage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jp.premama.weightmanage.R;
import jp.premama.weightmanage.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnNext = (Button)findViewById(R.id.btn_next);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManageWeightActivity.class);
                startActivity(intent);
            }
        });
    }
}
