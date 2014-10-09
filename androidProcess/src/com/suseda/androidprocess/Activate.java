package com.suseda.androidprocess;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;

public class Activate extends Service{
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// SMSRun.run();
		Intent i = new Intent(Intent.ACTION_MAIN);
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage("com.rohman.suseda");
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		Log.d("tag","load");
		// Log.d("loggg","-----------------");
		return 0;
	}
}
