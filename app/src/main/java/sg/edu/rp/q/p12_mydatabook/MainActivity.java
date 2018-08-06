package sg.edu.rp.q.p12_mydatabook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] drawerItems;
    private DrawerLayout drawerLayout;

    private ListView drawerList;
    MenuItemAdapter ma;
    private ArrayList<Integer> imageIDs;
    private ArrayList<String> nameList;
    ArrayAdapter<String> aa;

    String currentTitle;
    ActionBar ab;
    private ActionBarDrawerToggle drawerToggle;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        imageIDs = new ArrayList<>();
        nameList = new ArrayList<>();
        imageIDs = getList();
        nameList = getNameList();

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
//                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });

        currentTitle = this.getTitle().toString();

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_open){
            @Override
            public void onDrawerClosed(View view){
                super.onDrawerClosed(view);
                ab.setTitle(currentTitle);
            }
            @Override
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                ab.setTitle("Make a selection");
            }
        };

        drawerLayout.addDrawerListener(drawerToggle);


        drawerItems = new String[]{"Bio", "Vaccination", "Anniversary", "About Us"};
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        ma = new MenuItemAdapter(this, imageIDs, nameList);
        drawerList.setAdapter(ma);

        // Set the list's click listener
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int
                    position, long arg3) {

                Fragment fragment = null;
                if (position == 0) {
                    fragment = new BioFragment();

                }
                else if (position == 1) {
                    fragment = new VaccinationFragment();
                } else if (position == 2) {
                    fragment = new AnniversaryFragment();
                } else if (position == 3) {
                    Intent i = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(i);
                    return;
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction trans = fm.beginTransaction();
                trans.replace(R.id.content_frame, fragment);
                trans.commit();

                // Highlight the selected item,
                //  update the title, and close the drawer
                drawerList.setItemChecked(position, true);
                currentTitle = drawerItems[position];
                ab.setTitle(currentTitle);
                drawerLayout.closeDrawer(drawerList);
            }
        });
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync toggle state so the indicator is shown properly.
        //  Have to call in onPostCreate()
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (drawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
    public ArrayList<Integer>getList(){
        imageIDs = new ArrayList<>();
        imageIDs.add(R.drawable.bio);
        imageIDs.add(R.drawable.vaccine);
        imageIDs.add(R.drawable.anniversary);
        imageIDs.add(R.drawable.star);
        return imageIDs;
    }
    public ArrayList<String> getNameList() {
        nameList = new ArrayList<>();
        nameList.add("Bio");
        nameList.add("Vaccination");
        nameList.add("Anniversary");
        nameList.add("About Us");
        return nameList;
    }
}
