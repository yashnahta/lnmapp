package com.example.lnmapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity  {
    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String string=getString(R.string.navuser);
        getString(R.string.navuser)=" " ;

                dl = (DrawerLayout)findViewById(R.id.activity_main);
                t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

                dl.addDrawerListener(t);
                t.syncState();

                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                nv = (NavigationView)findViewById(R.id.nv);
                nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        switch(id)
                        {
                            case R.id.mess:
                                Toast.makeText(HomeActivity.this, "Mess Menu",Toast.LENGTH_SHORT).show();
                               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessActivity()).commit();
//                                Intent intent=new Intent(getApplicationContext(),MessActivity.class);
//
//                                startActivity(intent);
                                break;
                            case R.id.class1:
                                Toast.makeText(HomeActivity.this, "Class Time Table",Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ClassTime()).commit();
                                break;
                            case R.id.plc:
                                Toast.makeText(HomeActivity.this, "Placement Activities",Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PlacementActivity()).commit();
                                break;
                            case R.id.calender:
                                Toast.makeText(HomeActivity.this, "Calender",Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CalenderFrag()).commit();
                                dl.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.map1:
                                Toast.makeText(HomeActivity.this, "Map",Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Mapfrag()).commit();
                               // dl.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.bus:
                                Toast.makeText(HomeActivity.this, " Bus",Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BusTime()).commit();
                                dl.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.settings:
                                Toast.makeText(HomeActivity.this, " Bus",Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Settings()).commit();
                                dl.closeDrawer(GravityCompat.START);
                                break;

                            default:
                                return true;
                        }


                        dl.closeDrawer(GravityCompat.START);
                        return true;

                    }
                });


            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {

                if(t.onOptionsItemSelected(item))
                    return true;

                return super.onOptionsItemSelected(item);

    }
    public void signout(View view){
        mAuth.signOut();

        Toast.makeText(getApplicationContext(),"Successfully Signed out",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
