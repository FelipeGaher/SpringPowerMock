package com.everis.junitCourse.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class NetworkReader {
    
	/**
	 * METODO ESTATICO
	 * @return
	 */
	public static String getLocalHostname() {
        String hostname = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch ( UnknownHostException e ) {
        }
        return hostname;
    }
}