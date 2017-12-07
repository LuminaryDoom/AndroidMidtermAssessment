package nyc.c4q.practicalmidtermassessment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EdgeEffect;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {


    private static final String SHARED_PREFS_KEY = "sharedPrefsKey";
    private EditText email;
    private EditText password;
    private CheckBox saveDetails;
    private Button submitButton;
    private SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.editText1);
        password = findViewById(R.id.editText2);
        saveDetails = findViewById(R.id.checkbox);
        submitButton = findViewById(R.id.button);

        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = login.edit();

                if (saveDetails.isChecked()) {
                    String username = email.getText().toString();
                    String pass = password.getText().toString();
                    editor.putString("user", username);
                    editor.putString("pass", pass);
                    editor.putBoolean("isChecked", saveDetails.isChecked());
                    editor.commit();
                } else {
                    editor.putBoolean("isChecked", saveDetails.isChecked());
                    editor.commit();
                }

                if (email.getText().toString() == "user@aol.com" && password.getText().toString() == "password1234") {
                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("UserEmail", email.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }


}
