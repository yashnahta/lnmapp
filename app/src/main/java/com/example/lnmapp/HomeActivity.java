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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity  {
    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FeedFragment()).commit();

        String string=getString(R.string.navuser);
      //  getString(R.string.navuser)=" ";

                dl = (DrawerLayout)findViewById(R.id.activity_main);
                t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

                dl.addDrawerListener(t);
                t.syncState();

                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nv = (NavigationView) findViewById(R.id.nv);
        View headerView = nv.getHeaderView(0);
        nv.getMenu().getItem(0).setChecked(true);
//
//        TextView roll = (TextView) headerView.findViewById(R.id.rollid);
//        roll.setText("Your Text Here");
       // Toast.makeText(this, mAuth.getCurrentUser().getUid(), Toast.LENGTH_SHORT).show();
        if(mAuth.getCurrentUser()!=null) {
            mDatabase = database.getReference().child("users").child(mAuth.getCurrentUser().getUid().toString()).child("name");
            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String s = dataSnapshot.getValue(String.class);
                    Toast.makeText(HomeActivity.this, s, Toast.LENGTH_SHORT).show();
                    NavigationView nv = (NavigationView) findViewById(R.id.nv);
                    View headerView = nv.getHeaderView(0);
                    TextView navUsername = (TextView) headerView.findViewById(R.id.navuserid);
                    navUsername.setText("Hello, "+s);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            mDatabase = database.getReference().child("users").child(mAuth.getCurrentUser().getUid().toString()).child("roll");
            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String s = dataSnapshot.getValue(String.class);
                    Toast.makeText(HomeActivity.this, s, Toast.LENGTH_SHORT).show();
                    NavigationView nv = (NavigationView) findViewById(R.id.nv);
                    View headerView = nv.getHeaderView(0);
                    TextView navUsername = (TextView) headerView.findViewById(R.id.rollid);
                    navUsername.setText("Roll Number - "+s);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        else
        {
            nv = (NavigationView) findViewById(R.id.nv);
            headerView = nv.getHeaderView(0);
            TextView navUsername = (TextView) headerView.findViewById(R.id.navuserid);
            navUsername.setText("Hello, Guest");

        }
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
                                Toast.makeText(HomeActivity.this, "Calendar",Toast.LENGTH_SHORT).show();
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
                                Intent intent=new Intent(getApplicationContext(),Bustimes.class);
                                startActivity(intent);
//                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BusTime()).commit();
                                dl.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.settings:
                                Toast.makeText(HomeActivity.this, "Sign Out",Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Settings()).commit();
                                dl.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.feed:
                                Toast.makeText(HomeActivity.this, "Feed",Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FeedFragment()).commit();
                                dl.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.quick:
                                Toast.makeText(HomeActivity.this, "Quick Links",Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new QuickLinksFragment()).commit();
                                dl.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.complaint:
                                Toast.makeText(HomeActivity.this, "Make Complaints",Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Complaint()).commit();
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
