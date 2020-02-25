package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import static id.ac.polinema.intentexercise.RegisterActivity.ABOUT_KEY;
import static id.ac.polinema.intentexercise.RegisterActivity.EMAIL_KEY;
import static id.ac.polinema.intentexercise.RegisterActivity.FULLNAME_KEY;
import static id.ac.polinema.intentexercise.RegisterActivity.HOME_KEY;

public class ProfileActivity extends AppCompatActivity {

    private TextView fullname;
    private TextView email;
    private TextView home;
    private TextView about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullname = findViewById(R.id.label_fullname);
        email = findViewById(R.id.label_email);
        home = findViewById(R.id.label_homepage);
        about = findViewById(R.id.label_about);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // TODO: display value here
            String fullnameText = extras.getString(FULLNAME_KEY );
            String emailText = extras.getString(EMAIL_KEY);
            String homeText= extras.getString(HOME_KEY);
            String aboutText = extras.getString(ABOUT_KEY);

            fullname.setText(fullnameText);
            email.setText(emailText);
            home.setText(homeText);
            about.setText(aboutText);
        }
    }
    public void handleOpenHomepage(View view) {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String homepageText = bundle.getString("HOMEPAGE_KEY");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+homepageText));
            startActivity(intent);
        }
    }

}
