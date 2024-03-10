package com.example.pr3;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int dpValue = 45;
        float density = getResources().getDisplayMetrics().density;
        int pixelValue = (int) (dpValue * density + 0.5f);

        LinearLayout Layout = new LinearLayout(this);
        Layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(Layout);

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                pixelValue
        );

        for (int i = 0; i <= 13; i++){
            if (i % 2 == 0){
                View green_view = new View(this);
                green_view.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
                green_view.setLayoutParams(params1);
                Layout.addView(green_view);
            }
            else {
                View yellow_view = new View(this);
                yellow_view.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
                yellow_view.setLayoutParams(params1);
                Layout.addView(yellow_view);
            }
        }
    }
}
