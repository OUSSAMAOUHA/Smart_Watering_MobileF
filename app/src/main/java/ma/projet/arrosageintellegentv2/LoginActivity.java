package ma.projet.arrosageintellegentv2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import ma.projet.arrosageintellegentv2.beans.AppUser;
import ma.projet.arrosageintellegentv2.networking.ApiClient;
import ma.projet.arrosageintellegentv2.networking.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText username;
    private EditText password;
  public static  SharedPreferences sharref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        sharref = getSharedPreferences("access_token", Context.MODE_PRIVATE);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        //CheckBox remember = findViewById(R.id.checkBox);
        Button loginBtn = findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(LoginActivity.this, MainActivity.class );
                //startActivity(intent);

                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Username / Password Required", Toast.LENGTH_LONG).show();
                } else {
                    login();
                }
            }
        });

    }
    public void login() {
        Map<String, String> userdata = new HashMap<>();
        userdata.put("username", username.getText().toString());
        userdata.put("password", password.getText().toString());
        AppUser user = new AppUser();
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<AppUser> loginResponseCall = ApiClient.getUserService().Authentifcate(user);
            loginResponseCall.enqueue(new Callback<AppUser>() {
                @Override
                public void onResponse(Call<AppUser> call, Response<AppUser> response) {
                    Log.d(TAG, "onResponse: " + response.body());
                    if (response.isSuccessful()) {
                        AppUser appUser = response.body();
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(LoginActivity.this, StatisticActivity.class));
                                //Toast.makeText(LoginActivity.this, response.body().getToken(), Toast.LENGTH_SHORT).show();
                                //token = response.body().getToken();
                            }
                        }, 700);

                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed ", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<AppUser> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }
}