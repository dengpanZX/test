package com.example.service;

import com.example.service.IServiceCallBack;

interface ITestService {
	void setCallBackListener(IServiceCallBack listener);
	void printfTestService();
}