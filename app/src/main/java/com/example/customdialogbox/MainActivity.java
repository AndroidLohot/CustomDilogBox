package com.example.customdialogbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExammpleDialogListner {

    private TextView tvFirstN,tvLastN;
    private Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFirstN=(TextView)findViewById(R.id.tvFirsName);
        tvLastN=(TextView)findViewById(R.id.tvShowLastName);
        btnShow=(Button)findViewById(R.id.button);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {

        ExampleDialog exampleDialog=new ExampleDialog();

        exampleDialog.show(getSupportFragmentManager(),"Example dialog box");
    }

    @Override
    public void applyText(String fName, String lName) {
        tvFirstN.setText(fName);
        tvLastN.setText(lName);
    }
}
