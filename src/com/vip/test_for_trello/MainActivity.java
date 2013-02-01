package com.vip.test_for_trello;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button addRock, updateRock;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addRock = (Button) findViewById(R.id.addRock);
		updateRock = (Button) findViewById(R.id.updateRock);
		
		addRock.setOnClickListener(this);
		updateRock.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.addRock){
			Log.d("Test Trello", "Adding rock pressed");
			//Send intent to add rock
			Intent sendIntent = new Intent();
			Bundle extras = new Bundle();
			
			extras.putString("Test1", "this is test 1");
			extras.putString("Test2", "this is test number 2");
			sendIntent.setAction(Intent.ACTION_SEND);
			sendIntent.setPackage("com.vip.trello");
			sendIntent.putExtras(extras);
			//sendIntent.setType("text/plain");
			//sendIntent.addCategory("trello");
			startService(sendIntent);
			
			
		} else if(v.getId() == R.id.updateRock){
			Log.d("Test Trello", "update rock pressed");
			if(isPackageExists("com.vip.trello")){
				Log.d("Test Trello", "com.vip.trello exists");
			} else  {
				Log.d("Test Trello", "com.vip.trello not installed");
			}
			
		}
		
	}
	public boolean isPackageExists(String targetPackage){
        List<ApplicationInfo> packages;
        PackageManager pm = getPackageManager();        
        packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            	if(packageInfo.packageName.equals(targetPackage)) return true;
        }        
        return false;
    }

}
