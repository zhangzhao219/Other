package com.example.LOVE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.LOVE.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView LoveDuring;
    private TextView LoveDuring2;
    private TextView LoveDate;
    private ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoveDuring = (TextView) findViewById(R.id.number_of_days);
        LoveDuring2 = (TextView) findViewById(R.id.number_of_days2);
        picture = (ImageView) findViewById(R.id.mainpicture);

        try {
            SimpleDateFormat dft = new SimpleDateFormat("yyyy.MM.dd");
            SimpleDateFormat dft2 = new SimpleDateFormat("MM.dd");

            Date datebegin = dft.parse("2019.09.13");

            Date date = new Date();
            // System.out.println(dft.format(date));
            Date datenow = dft.parse(dft.format(date));
//            datenow = dft.parse("2021.09.13");
            Calendar cld1 = Calendar.getInstance();
            cld1.setTime(datenow);
            cld1.add(Calendar.DATE, 1);
            Date datetomorrow = cld1.getTime();

            if (dft2.format(datenow).equals("09.13")) {
                picture.setImageDrawable(getResources().getDrawable((R.drawable.a2)));
            }
            else if ((dft2.format(datenow).equals("02.19")) || (dft2.format(datenow).equals("02.29"))) {
                picture.setImageDrawable(getResources().getDrawable((R.drawable.a1)));
            }
            else if((dft2.format(datenow).equals("02.28")) && (dft2.format(datetomorrow).equals("03.01"))){
                picture.setImageDrawable(getResources().getDrawable((R.drawable.a1)));
            }

            Date nextDay = datebegin;

            int year = 0;
            int yearday = 0;
            int actualday = 0;
            while (nextDay.before(datenow)) {
                Calendar cld = Calendar.getInstance();
                cld.setTime(datebegin);
                cld.add(Calendar.DATE, 1);
                datebegin = cld.getTime();
                nextDay = datebegin;
                if (dft2.format(nextDay).equals("09.13")) {
                    year++;
                    yearday = -1;
                }
                yearday++;
                actualday++;
            }
            if (year > 0) {
                if (yearday > 0) {
                    LoveDuring.setText(year + "年" + yearday + "天");
                } else {
                    LoveDuring.setText(year + "年");
                }
            } else {
                LoveDuring.setText(actualday + "天");
            }

            LoveDuring2.setText(actualday + "天");

            LoveDate = (TextView) findViewById(R.id.ymd);
            LoveDate.setText("2019.09.13-" + dft.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}