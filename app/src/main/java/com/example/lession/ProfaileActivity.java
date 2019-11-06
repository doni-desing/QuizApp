package com.example.lession;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.lession1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfaileActivity extends AppCompatActivity {

    private String  email;
    private EditText name, pasword;
    private CoordinatorLayout coordinatorLayout;
    private ActionCodeSettings actionCodeSettings;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profaile);

        name = findViewById(R.id.username);
        pasword = findViewById(R.id.password);
        if (name == null){
            name.setError("write");
        }

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.getEmail();
        }
    }

    public void onClick(View view) {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.sendSignInLinkToEmail( email, actionCodeSettings)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Snackbar snackbar = Snackbar
                                    .make(coordinatorLayout,"Успешно сохранено", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    }
                });

        startActivity(new Intent(this, MainActivity.class));
    }
}
