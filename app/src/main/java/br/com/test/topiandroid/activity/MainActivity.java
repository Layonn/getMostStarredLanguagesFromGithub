package br.com.test.topiandroid.activity;

import android.os.Bundle;

import br.com.test.topiandroid.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpDrawerNavigation();
    }
}
