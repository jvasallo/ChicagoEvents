package com.joelvasallo.chicagoevents;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

public class DisplayDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_description);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        updateView(message);
    }

    private void updateView(String key) {
        Drawable image = ResourcesCompat.getDrawable(getResources(), R.drawable.brewtobewild, null);
        String title = "";
        String date = "July 15th - July 16th";
        String price = "Free";
        String website = "http://joelvasallo.com";
        String body = "";
        switch (key) {
            case "brewtobewild_imagebutton":
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.brewtobewild, null);
                title += getResources().getString(R.string.event_1_name);
                date = getResources().getString(R.string.event_1_dates);
                price = getResources().getString(R.string.event_1_price);
                website = getResources().getString(R.string.event_1_website);
                body = getResources().getString(R.string.event_1_longdesc);
                break;
            case "tasteofchicago_imagebutton":
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.tasteofchicago, null);
                title += getResources().getString(R.string.event_2_name);
                date = getResources().getString(R.string.event_2_dates);
                price = getResources().getString(R.string.event_2_price);
                website = getResources().getString(R.string.event_2_website);
                body = getResources().getString(R.string.event_2_longdesc);
                break;
            case "lollapalooza_imagebutton":
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.lollapalooza, null);
                title += getResources().getString(R.string.event_3_name);
                date = getResources().getString(R.string.event_3_dates);
                price = getResources().getString(R.string.event_3_price);
                website = getResources().getString(R.string.event_3_website);
                body = getResources().getString(R.string.event_3_longdesc);
                break;
            case "airandwatershow_imagebutton":
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.airandwatershow, null);
                title += getResources().getString(R.string.event_4_name);
                date = getResources().getString(R.string.event_4_dates);
                price = getResources().getString(R.string.event_4_price);
                website = getResources().getString(R.string.event_4_website);
                body = getResources().getString(R.string.event_4_longdesc);
                break;
            case "riotfest_imagebutton":
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.riotfest, null);
                title += getResources().getString(R.string.event_5_name);
                date = getResources().getString(R.string.event_5_dates);
                price = getResources().getString(R.string.event_5_price);
                website = getResources().getString(R.string.event_5_website);
                body = getResources().getString(R.string.event_5_longdesc);
                break;
        }
        setTitle(title);

        ImageView eventImage = (ImageView) findViewById(R.id.event_image);
        TextView eventDate = (TextView) findViewById(R.id.event_date);
        TextView eventBody = (TextView) findViewById(R.id.event_body);
        TextView eventPrice = (TextView) findViewById(R.id.event_price);
        TextView eventWebsite = (TextView) findViewById(R.id.event_website);

        eventImage.setImageDrawable(image);
        eventDate.setText(date);
        eventPrice.setText(price);
        eventWebsite.setText(website);
        eventBody.setText(body);
    }

    public void addToCalendar(View view) {
        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", cal.getTimeInMillis());
        intent.putExtra("allDay", true);
        intent.putExtra("rrule", "FREQ=YEARLY");
        intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
        intent.putExtra("title", "A Test Event from android app");
        startActivity(intent);
    }
}
