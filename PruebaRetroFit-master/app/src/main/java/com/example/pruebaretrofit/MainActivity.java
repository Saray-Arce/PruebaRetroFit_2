package com.example.pruebaretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import classes.User;
import interfaces.UserInterface;
import retrofit.UserAPIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView txtViewUser;
    private EditText txtUser;

    private TextView txtViewPasswd;
    private EditText txtPasswd;

    private Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtViewUser = (TextView) findViewById( R.id.txtViewUser);
        txtViewUser.setText( R.string.user);
        txtUser = (EditText) findViewById( R.id.txtUser);

        txtViewPasswd = (TextView) findViewById( R.id.txtViewPasswd);
        txtViewPasswd.setText( R.string.password);
        txtPasswd = (EditText) findViewById( R.id.txtPasswd);

        btnSignIn = (Button) findViewById( R.id.button1);
        btnSignIn.setText( R.string.btnAccept);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                String login = txtUser.getText().toString();
                String pass = txtPasswd.getText().toString();

                UserInterface userInterface = UserAPIClient.findUserByLoginAndPasswd( login, pass);
                Call<User> call = userInterface.findUserByLoginAndPasswd(new String (login), new String(pass));

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.code() == 200) {
                            Intent intent  = new Intent (MainActivity.this, SignInActivity.class);
                        //    intent.putExtra("userName", R.string.txtUser);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Ha ocurrido un error de servidor!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Ha ocurrido un error GRAVE!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}