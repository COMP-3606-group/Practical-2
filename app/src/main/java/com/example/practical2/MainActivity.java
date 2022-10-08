package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    private String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner  = (Spinner) findViewById(R.id.spinner2);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        editText = (EditText) findViewById(R.id.editTextTextMultiLine);
        imageView = (ImageView) findViewById(R.id.imageView);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
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
        if (toggleButton.isChecked()){
            imageView.setVisibility(View.GONE);
        }
        else{
            imageView.setVisibility(View.VISIBLE);
        }

    }

    class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
                if(item.compareTo("Select Item") != 0){
                    editText.setText("ITEM: " + item+ "\n" + "QUANTITY: " + items.get(item));
                    if(item.compareTo("Socks") == 0){
                        imageView.setImageResource(R.drawable.socks);
                        imageButton.setImageResource(R.drawable.socks);
                    }
                    if(item.compareTo("Shirt") == 0){
                        imageView.setImageResource(R.drawable.shirt);
                        imageButton.setImageResource(R.drawable.shirt);

                    }
                    if(item.compareTo("Pants") == 0){
                        imageView.setImageResource(R.drawable.pants);
                        imageButton.setImageResource(R.drawable.pants);
                    }
                }
                else{
                    imageView.setImageResource(R.drawable.ic_launcher_background);
                    imageButton.setImageResource(R.drawable.ic_launcher_background);
                }


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}