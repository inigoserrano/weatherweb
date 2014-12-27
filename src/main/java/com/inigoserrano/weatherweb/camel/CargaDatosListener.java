package com.inigoserrano.weatherweb.camel;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CargaDatosListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		CamelContext context = new DefaultCamelContext();
		try {
			context.addRoutes(new CargaDatosRoute());
			context.addRoutes(new CargaDatosRoute("servlet:///tsv"));
			context.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		CamelContext context = new DefaultCamelContext();
		try {
			context.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
