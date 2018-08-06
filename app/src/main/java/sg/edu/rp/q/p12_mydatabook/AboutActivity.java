package sg.edu.rp.q.p12_mydatabook;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class AboutActivity extends AppCompatActivity {

    TextView tvAbout;
    ActionBar ab;
    ImageView ivRP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        tvAbout = findViewById(R.id.tvAbout);
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        ivRP = findViewById(R.id.ivRP);
        Picasso.with(getApplicationContext()).load("https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg").into(ivRP);
        Picasso.with(getApplicationContext())
                .load("https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg")
                .error(R.drawable.error)
                .placeholder(R.drawable.progress_animation)
                .into(ivRP);
    }
}
