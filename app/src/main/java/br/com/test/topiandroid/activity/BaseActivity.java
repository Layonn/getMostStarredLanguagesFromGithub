package br.com.test.topiandroid.activity;

import android.Manifest;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import br.com.test.topiandroid.R;
import br.com.test.topiandroid.fragment.RepositoryFragment;


public class BaseActivity extends AppCompatActivity {
    private final String TAG = getClass().getName().toString();
    private final int REQUEST_PERMISSION_INTERNET = 101;
    protected DrawerLayout drawerLayout;

    protected void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    protected void setUpDrawerNavigation() {
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        if (navigationView != null &drawerLayout != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            item.setChecked(true);
                            drawerLayout.closeDrawers();
                            onNavDrawerItemSelected(item);
                            return true;
                        }
                    }
            );
        }
    }

    private void onNavDrawerItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_javascript: {
                // Request permission
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.javascript));
                }
                break;
            }
            case  R.id.nav_java: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.java));
                }
                break;
            }
            case R.id.nav_python: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.python));
                }
                break;
            }
            case R.id.nav_css: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.css));
                }
                break;
            }
            case R.id.nav_php: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.php));
                }
                break;
            }
            case R.id.nav_ruby: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.ruby));
                }
                break;
            }
            case R.id.nav_cpp: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.cpp));
                }
                break;
            }
            case R.id.nav_c: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.c));
                }
                break;
            }
            case R.id.nav_shell: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.shell));
                }
                break;
            }
            case R.id.nav_csharp: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.csharp));
                }
                break;
            }
            case R.id.nav_objectivec: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.objectivec));
                }
                break;
            }
            case R.id.nav_r: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.r));
                }
                break;
            }
            case R.id.nav_viml: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.viml));
                }
                break;
            }
            case R.id.nav_go: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.go));
                }
                break;
            }
            case R.id.nav_pearl: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.pearl));
                }
                break;
            }
            case R.id.nav_coffeescript: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.coffeescript));
                }
                break;
            }
            case R.id.nav_tex: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.tex));
                }
                break;
            }
            case R.id.nav_swift: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.swift));
                }
                break;
            }
            case R.id.nav_scala: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.scala));
                }
                break;
            }
            case R.id.nav_ecmas_list: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.ecmas_list));
                }
                break;
            }
            case R.id.nav_haskell: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.haskell));
                }
                break;
            }
            case R.id.nav_lua: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.lua));
                }
                break;
            }
            case R.id.nav_clojure: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.clojure));
                }
                break;
            }
            case R.id.nav_matlab: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.matlab));
                }
                break;
            }
            case R.id.nav_arduino: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.arduino));
                }
                break;
            }
            case R.id.nav_makefile: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.makefile));
                }
                break;
            }

            case R.id.nav_groovy: {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_PERMISSION_INTERNET);
                } else {
                    replaceFragment(RepositoryFragment.newInstance(R.string.groovy));
                }
                break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (drawerLayout != null) {
                    openDrawer();
                    return true;
                }
        }

        return super.onOptionsItemSelected(item);
    }


    protected void openDrawer() {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_INTERNET: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    replaceFragment(RepositoryFragment.newInstance(R.string.java));
                }
            }
        }
    }

    protected void replaceFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.main_container, fragment, "Replace fragment").commit();
    }

}
