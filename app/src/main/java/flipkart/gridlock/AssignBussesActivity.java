package flipkart.gridlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import flipkart.gridlock.Database.SessionDetails;


public class AssignBussesActivity extends AppCompatActivity {
    private Spinner selectTime;
    String from ="";
    String to ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_assign_busses);
        addItemsToTime();

        Button proceed = (Button) findViewById(R.id.btnCheck);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txt1 = (TextView) findViewById(R.id.txt1);
                TextView txt2 = (TextView) findViewById(R.id.txt2);
                txt1.setText("Total num of busses = 12");
                txt2.setText("Suggested Assignment:");
                TextView txt3 = (TextView) findViewById(R.id.txt3);
                TextView txt4 = (TextView) findViewById(R.id.txt4);
                txt3.setText("Locations");
                txt4.setText("No. of Buses");
                from = String.valueOf(((EditText) findViewById(R.id.fromLoc)).getText());
                to = String.valueOf(((EditText) findViewById(R.id.toLoc)).getText());
                calculateOptimalAllocation();


            }
        });
    }

    private void calculateOptimalAllocation() {

        SessionDetails.instance().populateTrafficDatabase();
        HashMap<Integer, ArrayList< String> > traffic = SessionDetails.instance().getTraffic();


        int in = 50;
        int out = 0;
        ArrayList<String> list = traffic.get(18);
        for(int i=0; i<list.size(); i++)
        {
            String[] parts = list.get(i).split("_");
            in += Integer.parseInt(parts[2]);
            out += Integer.parseInt(parts[3]);
        }
        int leaving = 0;
        for(int i=0; i<list.size(); i++)
        {
            String[] parts = list.get(i).split("_");
            leaving += Integer.parseInt(parts[3]);
            if(leaving == in)
                ;
            else if(leaving> (0.75*in))
            {
                TextView cell1 = (TextView) findViewById(R.id.cell21);
                cell1.setText(from + "->" +parts[0]);
                TextView cell2 = (TextView) findViewById(R.id.cell22);
                cell2.setText("3");
                break;
            }
            else if(leaving> (0.5*in))
            {
                TextView cell1 = (TextView) findViewById(R.id.cell11);
                cell1.setText(from + "->" +parts[0]);
                TextView cell2 = (TextView) findViewById(R.id.cell12);
                cell2.setText("3");
            }

        }


        TextView cell1 = (TextView) findViewById(R.id.cell31);
        cell1.setText(from + "->" +to);
        TextView cell2 = (TextView) findViewById(R.id.cell32);
        cell2.setText("6");
    }

    private void addItemsToTime() {
        selectTime = (Spinner) findViewById(R.id.selTime);
        List<String> list = new ArrayList<String>();
        list.add("06:00");
        list.add("07:00");
        list.add("08:00");
        list.add("09:00");
        list.add("10:00");
        list.add("11:00");
        list.add("12:00");
        list.add("13:00");
        list.add("14:00");
        list.add("15:00");
        list.add("16:00");
        list.add("17:00");
        list.add("18:00");
        list.add("19:00");
        list.add("20:00");
        list.add("21:00");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectTime.setAdapter(dataAdapter);
    }
}
