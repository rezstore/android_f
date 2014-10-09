package com.serverpulsa.rez;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Act1 extends Activity {

	private void awal() {
		TextView text = (TextView) findViewById(R.id.textView1);
		String nomor = getNumber();
		// System.out.print(nomor);
		// text.setText("asd");
		Toast.makeText(getApplicationContext(), "nomor", Toast.LENGTH_SHORT);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		awal();
		setContentView(R.layout.activity_act1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act1, menu);
		return true;
	}

	public String getNumber() {
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		String n = tm.getLine1Number();
		return n;
		/*
		 * TelephonyManager telMgr =
		 * (TelephonyManager)context.getSystemService(Context
		 * .TELEPHONY_SERVICE);
		 * 
		 * String deviceID = telMgr.getDeviceId(); String simSerialNumber =
		 * telMgr.getSimSerialNumber(); String simLineNumber =
		 * telMgr.getLine1Number();
		 */
	}

}
