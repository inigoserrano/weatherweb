package com.inigoserrano.weatherweb.camel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class AjusteFormato {

	public void ajutarFormato(Map<String, Object> datos) throws ParseException {
		toInt(CargaDatosRoute.NO, datos);
		toDecimal(CargaDatosRoute.WIND, datos);
		toInt(CargaDatosRoute.INDOOR_HUMIDITY, datos);
		toDecimal(CargaDatosRoute.RELATIVE_PRESSURE, datos);
		toDecimal(CargaDatosRoute.DAY_HOUR_RAINFALL, datos);
		toTime(CargaDatosRoute.TIME, datos);
		toDecimal(CargaDatosRoute.OUTDOOR_TEMPERATURE, datos);
		toDecimal(CargaDatosRoute.GUST, datos);
		toDecimal(CargaDatosRoute.HOUR_RAINFALL, datos);
		toDecimal(CargaDatosRoute.WEEK_RAINFALL, datos);
		toDecimal(CargaDatosRoute.DEWPOINT, datos);
		toDecimal(CargaDatosRoute.GUST_LEVEL, datos);
		toDecimal(CargaDatosRoute.WINDCHILL, datos);
		toDecimal(CargaDatosRoute.TOTAL_RAINFALL, datos);
		toDecimal(CargaDatosRoute.MONTH_RAINFALL, datos);
		toInt(CargaDatosRoute.OUTDOOR_HUMIDITY, datos);
		toDecimal(CargaDatosRoute.INDOOR_TEMPERATURE, datos);
		toDecimal(CargaDatosRoute.ABSOLUTE_PRESSURE, datos);
		toInt(CargaDatosRoute.INTERVAL, datos);
		toInt(CargaDatosRoute.WIND_LEVEL, datos);
	}

	private void toInt(String key, Map<String, Object> datos) {
		String s = (String) datos.get(key);
		datos.replace(key, Integer.parseInt(s));
	}

	private void toDecimal(String key, Map<String, Object> datos) {
		String s = (String) datos.get(key);
		datos.replace(key, Float.parseFloat(s));
	}

	private void toTime(String key, Map<String, Object> datos) throws ParseException {
		String s = (String) datos.get(key);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		sdf.parse(s);
		datos.replace(key, sdf.parse(s));
	}

}
