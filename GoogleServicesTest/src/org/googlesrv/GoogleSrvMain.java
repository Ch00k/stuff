package org.googlesrv;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class GoogleSrvMain {

	public static void main (String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { GoogleSrvTest.class });
		testng.addListener(tla);
		testng.run();
		}
	
}
