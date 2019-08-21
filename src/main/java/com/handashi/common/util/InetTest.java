package com.handashi.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String localHost = InetAddress.getLocalHost().toString();
			String getLoopbackAddress = InetAddress.getLoopbackAddress().toString();
			String getHostName = InetAddress.getLocalHost().getHostName();
			String getHostAddress = InetAddress.getLocalHost().getHostAddress();
			
			System.out.println("localHost : " + localHost);
			System.out.println("getLoopbackAddress : " + getLoopbackAddress);
			System.out.println("getHostName : " + getHostName);
			System.out.println("getHostAddress : " + getHostAddress);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
