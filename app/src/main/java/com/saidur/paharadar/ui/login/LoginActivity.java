package com.saidur.paharadar.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.saidur.paharadar.MainActivity;
import com.saidur.paharadar.R;
import com.saidur.paharadar.ui.other.Forgotpw;

public class LoginActivity extends AppCompatActivity {
    private EditText loginemail,loginpassword;
    private Button loginBtn;
    private ProgressBar progressBar;
    private TextView goto_forgot_password;
    private final static int login_permission=1000;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        initializeUI();
        functionOnclicks();

    }

    private void functionOnclicks() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });

    /*    goto_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
*/
        goto_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, Forgotpw.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            goToHome();
        }
    }

    private void loginUserAccount() {

       // progressBar.setVisibility(View.VISIBLE);

        String email, password;
        email = loginemail.getText().toString().trim();
        password = loginpassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                           // progressBar.setVisibility(View.GONE);
                            FirebaseDatabase.getInstance().getReference("online").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue("1");

                            goToHome();

                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

    private void goToHome()
    {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void initializeUI()
    {
        loginemail = findViewById(R.id.login_email_id);
        loginpassword = findViewById(R.id.login_password_id);
        loginBtn = findViewById(R.id.btnlogIn);
        goto_forgot_password=findViewById(R.id.login_gotoforgot_password);
    }

}