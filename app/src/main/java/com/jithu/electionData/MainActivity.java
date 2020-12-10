package com.jithu.electionData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAGgg";
    Map<String, String> boothInfo = new HashMap<>();
    List<SingleRow> members = new ArrayList<>();

    SearchResultAdapter searchResultAdapter;
    List<SingleRow> result = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText searchBar = findViewById(R.id.searchBar);
        Button search = findViewById(R.id.search);

        searchResultAdapter = new SearchResultAdapter(result);
        RecyclerView resultRV = findViewById(R.id.resultRV);

        resultRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        resultRV.setHasFixedSize(false);
        resultRV.setAdapter(searchResultAdapter);

        addBoothFromCSV();
        addElectionPeople();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchInList(searchBar.getText().toString());
            }
        });



    }

    private void searchInList(String data) {
        result.clear();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getName().toLowerCase().contains(data.toLowerCase())
                    || members.get(i).getIdCardNo().toLowerCase().contains(data.toLowerCase())){
                result.add(members.get(i));
                searchResultAdapter.notifyDataSetChanged();
                Log.i(TAG, "searchInList: ");
            }
        }
    }

    private void addElectionPeople() {
        InputStream inputStream = getResources().openRawResource(R.raw.election_people);
        CSVFile csvFile = new CSVFile(inputStream);
        List values = csvFile.read();

        for (int i = 0; i < values.size(); i++) {
            String[] rowData = (String[]) values.get(i);
            members.add(new SingleRow(rowData[0],rowData[1],rowData[2],rowData[3],rowData[4],rowData[5],rowData[6],rowData[7],boothInfo.get(rowData[7])));
        }

    }

    private void addBoothFromCSV() {
        InputStream inputStream = getResources().openRawResource(R.raw.booth_data);
        CSVFile csvFile = new CSVFile(inputStream);
        List values = csvFile.read();


        for (int i = 0; i < values.size(); i++) {
            String[] test = (String[]) values.get(i);
            StringBuilder booth = new StringBuilder();
            for (int j = 1; j < test.length; j++) {
                booth.append(test[j].replace('"',' '));
                if (j != test.length - 1){
                    booth.append(",");
                }
            }
            boothInfo.put(test[0], booth.toString());
        }
    }

}