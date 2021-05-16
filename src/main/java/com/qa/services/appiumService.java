package com.qa.services;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

import com.qa.utility.setUp;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appiumService 
{
	public AppiumDriverLocalService server;
	Properties prop = setUp.envSetUp();
	
	public void startAppiumServer()
	{
		
		try
		{
		AppiumServiceBuilder serviceBuilder=new AppiumServiceBuilder();
		serviceBuilder.usingPort(Integer.parseInt(prop.getProperty("port")));
		serviceBuilder.usingDriverExecutable(new File(prop.getProperty("nodePath")));
		serviceBuilder.withAppiumJS(new File(prop.getProperty("appiumPath")));
		 // The XCUITest driver requires that a path to the Carthage binary is in the PATH variable. I have this set for my shell, but the Java process does not see it. It can be inserted here.
       // HashMap<String, String> environment = new HashMap();
       // environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        //serviceBuilder.withEnvironment(environment);
		server = AppiumDriverLocalService.buildService(serviceBuilder);
		if(!checkIfServerIsRunnning(Integer.parseInt(prop.getProperty("port"))))
		{
        server.start();
        System.out.println("Appium Server Started");
		}
		else
		{
			System.out.println("Appium Server already Running");
		}
		}
		catch(Exception e)
		{
			System.out.println("AutoStart  Appium Server Failed " +e.getMessage());
		}
		
	}
	public boolean checkIfServerIsRunnning(int port) {

	    boolean isServerRunning = false;
	    ServerSocket serverSocket;
	    try {
	        serverSocket = new ServerSocket(port);
	        serverSocket.close();
	    } catch (IOException e) {
	        
	        isServerRunning = true;
	    } finally {
	        serverSocket = null;
	    }
	    return isServerRunning;
	}
	public void stopAppiumServer()
	{
		server.stop();
	}

}
