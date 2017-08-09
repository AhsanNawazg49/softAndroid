package com.grimreaper.userapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtEmail, edtTxtPass;
    String Email, Pass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtEmail = (EditText) findViewById(R.id.edt_txt_email);
        edtTxtPass = (EditText) findViewById(R.id.edt_txt_pass);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email = edtTxtEmail.getText().toString();
                Pass = edtTxtPass.getText().toString();

                if (Email.isEmpty() || Pass.isEmpty()) {
//                    if user has done soemthing wrong with the form
                    edtTxtEmail.setError("Please fill bboth");
                    edtTxtPass.setError("Please fill bboth");
                } else {

                    boolean userIsthere = CheckUserIsLogedinOrNot(Email, Pass);

                }
            }
        });
    }

    public boolean CheckUserIsLogedinOrNot(final String Email, final String Pass) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.0.2.2:8080/voley/CheckUserLogedin.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Sorry you are havinG trouble with connecting to the serrver", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("incomingEmail", Email);
                params.put("incomingPass", Pass);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);

        return true;
    }

}
