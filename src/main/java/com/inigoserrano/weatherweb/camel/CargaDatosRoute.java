package com.inigoserrano.weatherweb.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.csv.CsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.csv.writer.CSVConfig;
import org.apache.commons.csv.writer.CSVField;

public class CargaDatosRoute extends RouteBuilder {

	public static final String GUST_LEVEL = "Gust_Level";
	public static final String WIND_LEVEL = "Wind_Level";
	public static final String TOTAL_RAINFALL = "Total_Rainfall";
	public static final String MONTH_RAINFALL = "Month_Rainfall";
	public static final String WEEK_RAINFALL = "Week_Rainfall";
	public static final String DAY_HOUR_RAINFALL = "Day_hour_Rainfall";
	public static final String HOUR_RAINFALL = "Hour_Rainfall";
	public static final String WINDCHILL = "Windchill";
	public static final String DEWPOINT = "Dewpoint";
	public static final String RELATIVE_PRESSURE = "Relative_Pressure";
	public static final String DIRECTION = "Direction";
	public static final String GUST = "Gust";
	public static final String WIND = "Wind";
	public static final String ABSOLUTE_PRESSURE = "Absolute_Pressure";
	public static final String OUTDOOR_TEMPERATURE = "Outdoor_Temperature";
	public static final String OUTDOOR_HUMIDITY = "Outdoor_Humidity";
	public static final String INDOOR_TEMPERATURE = "Indoor_Temperature";
	public static final String INDOOR_HUMIDITY = "Indoor_Humidity";
	public static final String INTERVAL = "Interval";
	public static final String TIME = "Time";
	public static final String NO = "No";
	private final String uriFrom;
	private final String uriTo;

	public CargaDatosRoute(String uriFrom, String uriTo) {
		super();
		this.uriFrom = uriFrom;
		this.uriTo = uriTo;
	}

	public CargaDatosRoute(String uriFrom) {
		super();
		this.uriFrom = uriFrom;
		this.uriTo = "file:///Users/inigo/workspace/pruebaFuse/datos/salida?fileExist=Append";
	}

	public CargaDatosRoute() {
		this.uriFrom = "file:///Users/inigo/workspace/pruebaFuse/datos/entrada?noop=true";
		this.uriTo = "file:///Users/inigo/workspace/pruebaFuse/datos/salida?fileExist=Append";
	}

	@Override
	public void configure() throws Exception {
		String uriMongo = "mongodb:conexion?database=weatherweb&collection=weatherweb&operation=insert";
		from(uriFrom).unmarshal(config()).split().body().parallelProcessing().bean(AjusteFormato.class)
				.to(uriMongo).marshal().json(JsonLibrary.Jackson).to(uriTo);

	}

	private CsvDataFormat config() {

		CSVConfig config = new CSVConfig();
		config.setDelimiter('\t');
		config.addField(new CSVField(NO));
		config.addField(new CSVField(TIME));
		config.addField(new CSVField(INTERVAL));
		config.addField(new CSVField(INDOOR_HUMIDITY));
		config.addField(new CSVField(INDOOR_TEMPERATURE));
		config.addField(new CSVField(OUTDOOR_HUMIDITY));
		config.addField(new CSVField(OUTDOOR_TEMPERATURE));
		config.addField(new CSVField(ABSOLUTE_PRESSURE));
		config.addField(new CSVField(WIND));
		config.addField(new CSVField(GUST));
		config.addField(new CSVField(DIRECTION));
		config.addField(new CSVField(RELATIVE_PRESSURE));
		config.addField(new CSVField(DEWPOINT));
		config.addField(new CSVField(WINDCHILL));
		config.addField(new CSVField(HOUR_RAINFALL));
		config.addField(new CSVField(DAY_HOUR_RAINFALL));
		config.addField(new CSVField(WEEK_RAINFALL));
		config.addField(new CSVField(MONTH_RAINFALL));
		config.addField(new CSVField(TOTAL_RAINFALL));
		config.addField(new CSVField(WIND_LEVEL));
		config.addField(new CSVField(GUST_LEVEL));

		CsvDataFormat formato = new CsvDataFormat();
		formato.setConfig(config);
		formato.setAutogenColumns(true);
		formato.setUseMaps(true);
		formato.setSkipFirstLine(true);
		return formato;

	}

}
