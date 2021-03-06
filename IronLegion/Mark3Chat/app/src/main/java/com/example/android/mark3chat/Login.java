package com.example.android.mark3chat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.mark3chat.model.ChatUser;
import com.example.android.mark3chat.utils.Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends CustomActivity {
    /**
     * The username edittext.
     */
    private TextInputLayout userWrapper;
    private EditText user;

    /**
     * The password edittext.
     */
    private TextInputLayout pwdWrapper;
    private EditText pwd;

    /**
     * Login progress dialog
     */
    private ProgressDialog loginProgressDlg;

    /* (non-Javadoc)
     * @see com.chatt.custom.CustomActivity#onCreate(android.os.Bundle)
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        setTouchNClick(R.id.btnLogin);
        setTouchNClick(R.id.btnReg);

        userWrapper = (TextInputLayout) findViewById(R.id.user_wrapper);
        user = (EditText) findViewById(R.id.user);
        pwdWrapper = (TextInputLayout) findViewById(R.id.pwd_wrapper);
        pwd = (EditText) findViewById(R.id.pwd);

    }

    /* (non-Javadoc)
     * @see com.chatt.custom.CustomActivity#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.btnReg) {
            startActivityForResult(new Intent(this, Register.class), 10);
        } else {
            // Extract form fields
            String user = this.user.getText().toString();
            String password = pwd.getText().toString();
            if (user.length() == 0 || password.length() == 0) {
                Utils.showDialog(this, R.string.err_fields_empty);
                return;
            }

            // Do the user authentication
            FirebaseAuth.getInstance().signInWithEmailAndPassword(user, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Logger.getLogger(Login.class.getName()).log(Level.ALL, "signInWithEmail:onComplete:" + task.isSuccessful());
                            loginProgressDlg.dismiss();
                            if (!task.isSuccessful()) {

                                Logger.getLogger(Login.class.getName()).log(Level.ALL, "signInWithEmail", task.getException());
                                Toast.makeText(Login.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                ArrayList<String> defaultRoom = new ArrayList<String>();
                                defaultRoom.add("home");
                                UserList.user = new ChatUser(task.getResult().getUser().getUid(), task.getResult().getUser().getDisplayName(), task.getResult().getUser().getEmail(), true, defaultRoom);
                                startActivity(new Intent(Login.this, UserList.class));
                                finish();
                            }

                        }
                    });

            loginProgressDlg = ProgressDialog.show(this, null,
                    getString(R.string.alert_wait));

        }
    }

    /* (non-Javadoc)
     * @see android.support.v4.app.FragmentActivity#onActivityResult(int, int, android.content.Intent)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK)
            finish();

    }
}
