package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ToggleButton;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<String,Integer> items = new HashMap<String,Integer>();
    private Spinner spinner;
    private ImageButton imageButton;
    private ImageView imageView;
    private EditText editText;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner  = (Spinner) findViewById(R.id.spinner2);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        editText = (EditText) findViewById(R.id.editTextTextMultiLine);
        imageView = (ImageView) findViewById(R.id.imageView);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        items.put("Select Item",0);
        items.put("Shirt",1);
        items.put("Pants",2);
        items.put("Socks",3);

    }

    public void onImageButtonClick(View v) {
        //SOME EVENT...
        editText.setText("");
        spinner.setSelection(0);
        toggleButtonClick(toggleButton);
    }
    public void toggleButtonClick(View v) {
        if (toggleButton.isSelected()){
            toggleButton.setSelected(false);
            imageView.setVisibility(View.GONE);
        }
        else{
            toggleButton.setSelected(true);
            imageView.setVisibility(View.VISIBLE);
        }

    }

    public void onSpinnerClick(View v) {
            String spinnerText = spinner.getSelectedItem().toString();
            editText.setText(spinnerText + " :" + items.get(spinnerText));

    }
}