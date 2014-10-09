package com.suseda.androidprocess;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("loggg","--------- Service Tak Aktif bro --------");
		Intent iSMS2 = new Intent(this, checking_process.class);
		PendingIntent piSMS2 = PendingIntent.getService(this, 0, iSMS2,
				PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager2 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		alarmManager2.cancel(piSMS2);
		alarmManager2.setRepeating(AlarmManager.RTC_WAKEUP,
				System.currentTimeMillis(), 5000, piSMS2);//AlarmManager.INTERVAL_FIFTEEN_MINUTES
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
