package com.joelvasallo.chicagoevents;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
        String title = "Joel Was Here";
        String date = "July 15th - July 16th";
        String price = "Free";
        String website = "http://joelvasallo.com";
        String body = "Lorum Ipsum...wait how did you get here?";

        switch (key) {
            case "brewtobewild_imagebutton":
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.brewtobewild_details, null);
                title = getResources().getString(R.string.event_1_name);
                date = getResources().getString(R.string.event_1_dates);
                price = getResources().getString(R.string.event_1_price);
                website = getResources().getString(R.string.event_1_website);
                body = getResources().getString(R.string.event_1_longdesc);
                break;
            case "tasteofchicago_imagebutton":
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.tasteofchicago_details, null);
                title = getResources().getString(R.string.event_2_name);
                date = getResources().getString(R.string.event_2_dates);
                price = getResources().getString(R.string.event_2_price);
                website = getResources().getString(R.string.event_2_website);
                body = getResources().getString(R.string.event_2_longdesc);
                break;
            case "lollapalooza_imagebutton":
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.lollapalooza_details, null);
                title = getResources().getString(R.string.event_3_name);
                date = getResources().getString(R.string.event_3_dates);
                price = getResources().getString(R.string.event_3_price);
                website = getResources().getString(R.string.event_3_website);
                body = getResources().getString(R.string.event_3_longdesc);
                break;
            case "airandwatershow_imagebutton":
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.airandwatershow_details, null);
                title = getResources().getString(R.string.event_4_name);
                date = getResources().getString(R.string.event_4_dates);
                price = getResources().getString(R.string.event_4_price);
                website = getResources().getString(R.string.event_4_website);
                body = getResources().getString(R.string.event_4_longdesc);
                break;
            case "riotfest_imagebutton":
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.riotfest_details, null);
                title = getResources().getString(R.string.event_5_name);
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

    private long dateToEpoch(String date) {
        // "06 13 2003 12:11 PM CST"
        SimpleDateFormat df = new SimpleDateFormat("MM dd yyyy hh:mm a", Locale.ENGLISH);
        df.setLenient(false);
        ParsePosition pos = new ParsePosition(0);
        Date dateObj = df.parse(date, pos);

        return dateObj.getTime();
    }

    public void addToCalendar(View view) {
        String title = getTitle().toString();
        String eventAddress = "";
        String eventWebsite = "";
        long startDate = 0;
        long endDate = 0;

        switch (title) {
            case "Brew to Be Wild":
                startDate = dateToEpoch(getResources().getString(R.string.event_1_startdate));
                endDate = dateToEpoch(getResources().getString(R.string.event_1_enddate));
                eventAddress = getResources().getString(R.string.event_1_location);
                eventWebsite = getResources().getString(R.string.event_1_website);
                break;
            case "Taste of Chicago":
                startDate = dateToEpoch(getResources().getString(R.string.event_2_startdate));
                endDate = dateToEpoch(getResources().getString(R.string.event_2_enddate));
                eventAddress = getResources().getString(R.string.event_2_location);
                eventWebsite = getResources().getString(R.string.event_2_website);
                break;
            case "Lollapalooza":
                startDate = dateToEpoch(getResources().getString(R.string.event_3_startdate));
                endDate = dateToEpoch(getResources().getString(R.string.event_3_enddate));
                eventAddress = getResources().getString(R.string.event_3_location);
                eventWebsite = getResources().getString(R.string.event_3_website);
                break;
            case "Chicago Air and Water Show":
                startDate = dateToEpoch(getResources().getString(R.string.event_4_startdate));
                endDate = dateToEpoch(getResources().getString(R.string.event_4_enddate));
                eventAddress = getResources().getString(R.string.event_4_location);
                eventWebsite = getResources().getString(R.string.event_4_website);
                break;
            case "Riot Fest":
                startDate = dateToEpoch(getResources().getString(R.string.event_5_startdate));
                endDate = dateToEpoch(getResources().getString(R.string.event_5_enddate));
                eventAddress = getResources().getString(R.string.event_5_location);
                eventWebsite = getResources().getString(R.string.event_5_website);
                break;
        }

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", startDate);
        intent.putExtra("endTime", endDate);
        intent.putExtra("eventLocation", eventAddress);
        intent.putExtra("description", eventWebsite);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
