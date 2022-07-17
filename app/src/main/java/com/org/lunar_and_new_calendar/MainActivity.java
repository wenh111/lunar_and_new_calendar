package com.org.lunar_and_new_calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText new_et_calendar,lunar_et_calendar;
    private EditText new_tv_calendar,lunar_tv_calendar;
    private Button new_but_calendar,lunar_but_calendar;
    private int new_year,new_month,new_day,lunar_year,lunar_month,lunar_day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        findid();
        setlisten();
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        DatePickerDialog dg = new DatePickerDialog(MainActivity.this,AlertDialog.THEME_HOLO_LIGHT,null,c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        DatePicker datePicker = dg.getDatePicker();
        c1.add(Calendar.YEAR, -122);
        c2.add(Calendar.YEAR,78);
        datePicker.setMinDate(c1.getTime().getTime());
        datePicker.setMaxDate(c2.getTime().getTime());
        new_tv_calendar.setEnabled(false);
        lunar_tv_calendar.setEnabled(false);
        new_et_calendar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    new_et_calendar.setHint("");

                    dg.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int year = datePicker.getYear();
                            int month = datePicker.getMonth();
                            int day = datePicker.getDayOfMonth();
                            new_year = year;
                            new_month = month+1;
                            new_day = day;
                            new_et_calendar.setText(String.format("%s.%s.%s",year,month+1,day));
                            new_et_calendar.clearFocus();
                        }
                    });
                    dg.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            new_et_calendar.clearFocus();
                        }
                    });
                    dg.show();
                    new_et_calendar.clearFocus();
                }else {
                    new_et_calendar.setHint("请选择日期");
                }
            }
        });
        new_et_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_et_calendar.setHint("");
                /*Calendar c = Calendar.getInstance();
                DatePickerDialog dg = new DatePickerDialog(MainActivity.this,AlertDialog.THEME_HOLO_LIGHT,null,c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));*/
                dg.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //DatePicker datePicker = dg.getDatePicker();
                        int year = datePicker.getYear();
                        int month = datePicker.getMonth();
                        int day = datePicker.getDayOfMonth();
                        new_year = year;
                        new_month = month+1;
                        new_day = day;
                        new_et_calendar.setText(String.format("%s.%s.%s",year,month+1,day));
                        new_et_calendar.clearFocus();
                    }
                });
                dg.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new_et_calendar.clearFocus();
                    }
                });
                dg.show();
                new_et_calendar.clearFocus();
            }
        });
        lunar_et_calendar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    lunar_et_calendar.setHint("");
                    /*Calendar c = Calendar.getInstance();
                    DatePickerDialog dg = new DatePickerDialog(MainActivity.this,AlertDialog.THEME_HOLO_LIGHT,null,c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));*/
                    dg.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //DatePicker datePicker = dg.getDatePicker();
                            int year = datePicker.getYear();
                            int month = datePicker.getMonth();
                            int day = datePicker.getDayOfMonth();
                            lunar_year = year;
                            lunar_month = month+1;
                            lunar_day = day;
                            lunar_et_calendar.setText(String.format("%s.%s.%s",year,month+1,day));
                            lunar_et_calendar.clearFocus();
                        }
                    });
                    dg.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            lunar_et_calendar.clearFocus();
                        }
                    });
                    dg.show();
                    lunar_et_calendar.clearFocus();
                }else{
                    lunar_et_calendar.setHint("请选择日期");
                }

            }
        });
        lunar_et_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lunar_et_calendar.setHint("");
                /*Calendar c = Calendar.getInstance();
                DatePickerDialog dg = new DatePickerDialog(MainActivity.this,AlertDialog.THEME_HOLO_LIGHT,null,c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));*/
                dg.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //DatePicker datePicker = dg.getDatePicker();
                        int year = datePicker.getYear();
                        int month = datePicker.getMonth();
                        int day = datePicker.getDayOfMonth();
                        lunar_year = year;
                        lunar_month = month+1;
                        lunar_day = day;
                        lunar_et_calendar.setText(String.format("%s.%s.%s",year,month+1,day));
                        lunar_et_calendar.clearFocus();
                    }
                });
                dg.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        lunar_et_calendar.clearFocus();
                    }
                });
                dg.show();
                lunar_et_calendar.clearFocus();
            }
        });
    }

    private void setlisten() {
        Onclick onclick = new Onclick();
        new_but_calendar.setOnClickListener(onclick);
        lunar_but_calendar.setOnClickListener(onclick);
    }

    private void findid() {
        new_et_calendar = findViewById(R.id.new_et_calendar);
        new_tv_calendar = findViewById(R.id.new_tv_calendar);
        new_but_calendar = findViewById(R.id.new_but_calendar);
        lunar_et_calendar = findViewById(R.id.lunar_et_calendar);
        lunar_tv_calendar = findViewById(R.id.lunar_tv_calendar);
        lunar_but_calendar = findViewById(R.id.lunar_but_calendar);
    }
    class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.new_but_calendar:
                    new_to_lunar();
                    break;
                case R.id.lunar_but_calendar:
                    lunar_to_new();
                    break;
            }
        }
    }

    private void lunar_to_new() {
        String in = String.valueOf(lunar_et_calendar.getText());
        if(in.equals("")){
            Toast.makeText(MainActivity.this,"请输入日期" ,Toast.LENGTH_SHORT).show();
        }else{
            LunarCalendar ll = new LunarCalendar();
            boolean run = false;
            int yushu = lunar_year % 4;
            if(yushu==0){
                run = true;
            }else{
                run = false;
            }
            int[] jieguo = ll.lunarToSolar(lunar_year,lunar_month,lunar_day,run);
            lunar_tv_calendar.setText(jieguo[0] + "."  +jieguo[1] + "." + jieguo[2]);
        }

    }

    private void new_to_lunar() {
        String in = String.valueOf(new_et_calendar.getText());
        if(in.equals("")){
            Toast.makeText(MainActivity.this,"请输入日期" ,Toast.LENGTH_SHORT).show();
        }else{
            SolarToLunar sl = new SolarToLunar();
            new_tv_calendar.setText(sl.today(new_year,new_month,new_day));
        }

    }
}