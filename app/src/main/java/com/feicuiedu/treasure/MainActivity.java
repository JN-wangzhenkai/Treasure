package com.feicuiedu.treasure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.feicuiedu.treasure.commons.ActivityUtils;
import com.feicuiedu.treasure.user.LoginActivity;
import com.feicuiedu.treasure.user.RegisterActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/** 入口页面*/
public class MainActivity extends AppCompatActivity {

    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUtils = new ActivityUtils(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_Login,R.id.btn_Register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Login:
                activityUtils.startActivity(LoginActivity.class);
                break;
            case R.id.btn_Register:
                activityUtils.startActivity(RegisterActivity.class);
                break;
        }
    }
}