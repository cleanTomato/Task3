package com.example.pr3;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout constraintLayout = new ConstraintLayout(this);
        setContentView(constraintLayout);

        TextView textView1 = new TextView(this);
        textView1.setId(View.generateViewId());
        textView1.setText("TextView 1");
        constraintLayout.addView(textView1);

        TextView textView2 = new TextView(this);
        textView2.setId(View.generateViewId());
        textView2.setText("TextView 2");
        constraintLayout.addView(textView2);

        Button button1 = new Button(this);
        button1.setId(View.generateViewId());
        button1.setText("Button 1");
        constraintLayout.addView(button1);

        Button button2 = new Button(this);
        button2.setId(View.generateViewId());
        button2.setText("Button 2");
        constraintLayout.addView(button2);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        // Установка вертикальной цепочки
        constraintSet.connect(textView1.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 16);
        constraintSet.connect(textView1.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 16);

        constraintSet.connect(textView2.getId(), ConstraintSet.TOP, textView1.getId(), ConstraintSet.BOTTOM, 16);
        constraintSet.connect(textView2.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 16);

        // Установка горизонтального ряда с весом
        constraintSet.createHorizontalChain(
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                new int[]{button1.getId(), button2.getId()},
                null,
                ConstraintSet.CHAIN_PACKED
        );

        constraintSet.constrainWidth(button1.getId(), 0);
        constraintSet.constrainWidth(button2.getId(), 0);
        
        constraintSet.applyTo(constraintLayout);
    }
}
