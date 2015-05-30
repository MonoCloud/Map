package com.example.android.websitetest;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.content.SharedPreferences;



import android.widget.CheckBox;





public class Seite2 extends ActionBarActivity  {

    CheckBox cb1,cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seite2);

        cb1 = (CheckBox)findViewById(R.id.checkBox);
        cb1.setChecked(getFromSP("cb1"));
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        cb2.setChecked(getFromSP("cb2"));
    }

    private boolean getFromSP(String key){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("WebsiteTest", android.content.Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }
    private void saveInSp(String key,boolean value){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("WebsiteTest", android.content.Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

   
    public void onCheckboxClicked(View view){
        super.onPause();
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkBox:
                if(checked) saveInSp("cb1",true);
                else saveInSp("cb1",false);
                break;
            case R.id.checkBox2:
                if(checked) saveInSp("cb2",true);
                    else  saveInSp("cb2",false);
                break;

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seite2, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
