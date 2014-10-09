package com.suseda.androidprocess;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class checking_process extends Service {
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Runnable SMSRun = new Runnable() {

		public void run() {
			// Do something
			SMSStart SMS = new SMSStart();
			SMS.execute();
		}
	};

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// SMSRun.run();
		getResult();
		// Log.d("loggg","-----------------");
		return 0;
	}

	public class SMSStart extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			getResult();
			return null;
		}

	}

	public void getResult() {

		int i = Service();

		if (i == 0) {
			Log.d("loggg", "====== whois Tidak aktif =======");
			activate();
		} else {
			Log.d("loggg", "====== whois masih Aktif =======");
		}
	}

	private int Service() {
		ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		for (RunningServiceInfo service : manager
				.getRunningServices(Integer.MAX_VALUE)) {
			if ("com.rohman.suseda.SMS".equals(service.service.getClassName())) {
				return 1;
			}
		}
		return 0;
	}

	private void activate() {
		Intent iSMS2 = new Intent(this, Activate.class);
		PendingIntent piSMS2 = PendingIntent.getService(this, 0, iSMS2,
				PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager2 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		alarmManager2.cancel(piSMS2);
		alarmManager2.setRepeating(AlarmManager.RTC_WAKEUP,
				System.currentTimeMillis(), 0, piSMS2);// AlarmManager.INTERVAL_FIFTEEN_MINUTES
		
	}

}
