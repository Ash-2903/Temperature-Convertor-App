package com.example.temperatureconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private EditText celVal, fahrVal;
    private TextView fahrResult, celResult;
    private Button celButton, fahrButton;
    private static final DecimalFormat decfor = new DecimalFormat("0.000");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.medium_brown));
        window.setNavigationBarColor(this.getResources().getColor(R.color.white));
        //This part of the code displays the statusbar icon color to black
        int flags = window.getDecorView().getSystemUiVisibility();
        flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        window.getDecorView().setSystemUiVisibility(flags);




        setContentView(R.layout.activity_main);
        fahrResult = findViewById(R.id.result1);
        celResult = findViewById(R.id.result2);
        celButton = findViewById(R.id.celsiusButton);
        fahrButton = findViewById(R.id.fahrenheitButton);
        celButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                celVal = findViewById(R.id.celsiusVal);
                System.out.println(celVal.getText().toString());
                String inputVal = celVal.getText().toString();
                System.out.println(inputVal);
                double celValue = Double.parseDouble(inputVal);
                double fahrRes = celValue*1.8+32;
                double kelvinRes = celValue + 273.15;
                String output1 = decfor.format(fahrRes) + " F\n" + decfor.format(kelvinRes) + " K";
                fahrResult.setText(output1);
            }
        });
        fahrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fahrVal = findViewById(R.id.fahrenheitVal);
                String inputVal = fahrVal.getText().toString();
                double fahrValue = Double.parseDouble(inputVal);
                double celRes = (fahrValue-32)*0.5555556;
                double kelvResult = celRes + 273.15;
                Log.d("check","code executed " + fahrValue + " " + celRes );
                String output2 = decfor.format(celRes) + " C\n" + decfor.format(kelvResult) + " K";
                celResult.setText(output2);
            }
        });
    }


}