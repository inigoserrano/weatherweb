package com.inigoserrano.weatherweb.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CmdLine {

	public static void main(String[] args) {
		try {
			CamelContext context = new DefaultCamelContext();
			context.addRoutes(new CargaDatosRoute());
			context.start();
			for (int i = 60; i > 0; i--) {
				Thread.sleep(1000);
				System.out.println(i + " seg.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
