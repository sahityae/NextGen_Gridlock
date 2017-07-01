package flipkart.gridlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import flipkart.gridlock.Database.SessionDetails;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);





        Button proceed = (Button) findViewById(R.id.customer);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionDetails.instance();
            Intent nextScreen = new Intent(HomeScreen.this, MapsActivity.class);
            startActivity(nextScreen);

            }
        });

        Button assign = (Button) findViewById(R.id.assign);
        assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionDetails.instance();
                Intent nextScreen = new Intent(HomeScreen.this, AssignBussesActivity.class);
                startActivity(nextScreen);

            }
        });

    }
}
