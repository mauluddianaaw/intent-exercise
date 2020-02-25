package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    public static final String FULLNAME_KEY = "fullname";
    public static final String EMAIL_KEY = "email";
    public static final String PASS_KEY = "pass";
    public static final String CONFIRM_KEY = "confirm";
    public static final String HOME_KEY = "home";
    public static final String ABOUT_KEY = "about";

    private EditText fullnameInput;
    private EditText emailInput;
    private EditText passInput;
    private EditText confirmInput;
    private EditText homeInput;
    private EditText aboutInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullnameInput = findViewById(R.id.text_fullname);
        emailInput = findViewById(R.id.text_email);
        passInput = findViewById(R.id.text_password);
        confirmInput = findViewById(R.id.text_confirm_password);
        homeInput = findViewById(R.id.text_homepage);
        aboutInput = findViewById(R.id.text_about);
    }

    public void handleRegister(View view) {

        String name = fullnameInput.getText().toString();
        String email = emailInput.getText().toString();
        String pass = passInput.getText().toString();
        String confirm = confirmInput.getText().toString();
        String home = homeInput.getText().toString();
        String about = aboutInput.getText().toString();

        if(!(name).equals("") && !(email).equals("") && !(pass).equals("") && !(confirm).equals("") && !(home).equals("") && !(about).equals("")){
            if((pass).equals(confirm)){
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(FULLNAME_KEY,name);
        intent.putExtra(EMAIL_KEY,email);
        intent.putExtra(PASS_KEY,pass);
        intent.putExtra(CONFIRM_KEY,confirm);
        intent.putExtra(HOME_KEY,home);
        intent.putExtra(ABOUT_KEY,about);
        startActivity(intent);
            }else{
                Toast.makeText(this, "Password Tidak Valid!",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Isi Semua Data !",Toast.LENGTH_SHORT).show();
        }
    }
}
