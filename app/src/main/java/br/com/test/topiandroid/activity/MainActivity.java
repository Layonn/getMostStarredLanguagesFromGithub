package br.com.test.topiandroid.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.test.topiandroid.R;

public class MainActivity extends BaseActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private final int REQUEST_PERMISSION_INTERNET = 101;

    private ProgressDialog pDialog;
    protected ListView repositoriesListView;
    private String appendUrl;
    private static String url = "";
    private static String urlFinal = "https://api.github.com/search/repositories?q=language:Java&sort=stars&page=1";

    ArrayList<HashMap<String, String>> repositoryList;
    protected DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpDrawerNavigation();
    }


}
