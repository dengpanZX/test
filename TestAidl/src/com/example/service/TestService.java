package com.example.service;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class TestService extends Service{

	private IServiceCallBack mListener = null;
	private final ServiceStub mBinder = new ServiceStub();
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return new ServiceStub();
	}
	
	class ServiceStub extends ITestService.Stub {

		@Override
		public void setCallBackListener(IServiceCallBack listener)
				throws RemoteException {
			// TODO Auto-generated method stub
			mListener = listener;
		}

		@Override
		public void printfTestService() throws RemoteException {
			// TODO Auto-generated method stub
			Log.d("Service", "service");
			mListener.printCallBack();
		}		
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.e("service", "start");
//		Intent i = new Intent(this, TestAidlConnect.class);
//		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		startActivity(i);
		return super.onStartCommand(intent, flags, startId);
	}
	
	
}
