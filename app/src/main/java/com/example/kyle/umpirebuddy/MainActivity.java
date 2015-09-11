package com.example.kyle.umpirebuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener {

    public int strike_count = 0;
    public int ball_count = 0;
    public int total_outs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View ballButton = findViewById(R.id.ball_button);
        View strikeButton = findViewById(R.id.strike_button);
        ballButton.setOnClickListener(this);
        strikeButton.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onClick(View v){
        TextView tv = (TextView)findViewById(R.id.strike_count);
        TextView tv2 = (TextView)findViewById(R.id.ball_count);
        switch(v.getId()){
            case R.id.ball_button:
                increment_ball(tv2);
                break;
            case R.id.strike_button:
                increment_strike(tv);
                break;

        }
    }

    public void increment_strike(TextView tv2)
    {
        String text;
        strike_count++;
        if(strike_count==3)
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Out!").setTitle("3 Strikes");
            AlertDialog alert = builder.create();
            alert.show();
            strike_count = 0;
            ball_count = 0;
        }
        updateText();
    }

    public void increment_ball(TextView tv)
    {
        String text;
        ball_count++;
        if(ball_count==4)
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Walk!").setTitle("4 Balls");
            AlertDialog alert = builder.create();
            alert.show();
            strike_count = 0;
            ball_count = 0;
        }
        updateText();
    }

    public void updateText()
    {
        TextView tv = (TextView)findViewById(R.id.strike_count);
        TextView tv2 = (TextView)findViewById(R.id.ball_count);
        tv.setText(strike_count + "");
        tv2.setText(ball_count + "");
    }
}
