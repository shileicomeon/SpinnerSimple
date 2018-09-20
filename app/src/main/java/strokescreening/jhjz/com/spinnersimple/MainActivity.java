package strokescreening.jhjz.com.spinnersimple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import strokescreening.jhjz.com.spinnersimple.spinner.NiceSpinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NiceSpinner spinner = findViewById(R.id.spinner);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("onItemSelected",position+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("onNothingSelected",parent.getCount()+"");

            }
        });
    }
}
