package com.example.assignmentfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.assignmentfirst.extras.Constants;
import com.example.assignmentfirst.fragment.Splash;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction()
                .add(R.id.container,new Splash(), Constants.SplashFragment)
                .commit();
    }
}
