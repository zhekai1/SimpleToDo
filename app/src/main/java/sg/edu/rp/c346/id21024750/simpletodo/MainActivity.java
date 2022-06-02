package sg.edu.rp.c346.id21024750.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTasks;
    Button btnAdd;
    Button btnClear;
    Button btnDelete;
    ListView lvTasks;
    Spinner spnTasks;
    ArrayList<String> alTasks;
    ArrayAdapter<String> aaTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTasks = findViewById(R.id.etTasks);
        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        btnDelete = findViewById(R.id.btnDelete);
        lvTasks = findViewById(R.id.lvTasks);
        spnTasks = findViewById(R.id.spinner);

        alTasks = new ArrayList<String>();
        aaTasks = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alTasks);

        lvTasks.setAdapter(aaTasks);

        spnTasks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        btnDelete.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tasks = etTasks.getText().toString();
                alTasks.add(tasks);
                aaTasks.notifyDataSetChanged();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tasks = etTasks.getText().toString();
                alTasks.removeAll(alTasks);
                aaTasks.notifyDataSetChanged();
            }
        });
    }
}