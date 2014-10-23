package com.example.testaidl;

import com.example.service.IServiceCallBack;
import com.example.service.ITestService;
import com.example.service.TestService;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity implements ServiceConnection{
	private ITestService mService;
	private IServiceCallBack mListener = new CallBackListener();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.e("MainActivity", "start");
		Intent service = new Intent(this, TestService.class);
		startService(service);
		bindService(service, this, Context.BIND_AUTO_CREATE);
		/*yulihznyulihznyulihznyulihznyulihznyulihznyulihznyulihzn*/
		Log.d("yuli", "yulihzn");
	}
	
	@Override
	public void onServiceConnected(ComponentName arg0, IBinder arg1) {
		mService = ITestService.Stub.asInterface(arg1);
	
		try {
			mService.setCallBackListener(mListener);
			mService.printfTestService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void onServiceDisconnected(ComponentName arg0) {
		// TODO Auto-generated method stub
		
	}
	
	class CallBackListener extends IServiceCallBack.Stub {

		@Override
		public void printCallBack() throws RemoteException {
			// TODO Auto-generated method stub
			Log.d("testAidlConnect", "testAidlConnect");
		}
		
	}
}

