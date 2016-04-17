package com.joelvasallo.chicagoevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.joelvasallo.chicagoevents.MESSAGE";

    ImageButton brewtobewild_imagebutton;
    ImageButton tasteofchicago_imagebutton;
    ImageButton lollapalooza_imagebutton;
    ImageButton airandwatershow_imagebutton;
    ImageButton riotfest_imagebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brewtobewild_imagebutton = (ImageButton) findViewById(R.id.brewtobewild_imagebutton);
        tasteofchicago_imagebutton = (ImageButton) findViewById(R.id.tasteofchicago_imagebutton);
        lollapalooza_imagebutton = (ImageButton) findViewById(R.id.lollapalooza_imagebutton);
        airandwatershow_imagebutton = (ImageButton) findViewById(R.id.airandwatershow_imagebutton);
        riotfest_imagebutton = (ImageButton) findViewById(R.id.riotfest_imagebutton);

        brewtobewild_imagebutton.setOnClickListener(launchDescription);
        tasteofchicago_imagebutton.setOnClickListener(launchDescription);
        lollapalooza_imagebutton.setOnClickListener(launchDescription);
        airandwatershow_imagebutton.setOnClickListener(launchDescription);
        riotfest_imagebutton.setOnClickListener(launchDescription);
    }

    View.OnClickListener launchDescription = new View.OnClickListener() {
        public void onClick(View view) {
            int id = view.getId();
            String resourceName = getResources().getResourceEntryName(id);

            Intent intent = new Intent(MainActivity.this, DisplayDescriptionActivity.class);
            intent.putExtra(EXTRA_MESSAGE, resourceName);
            startActivity(intent);
        }
    };
}
