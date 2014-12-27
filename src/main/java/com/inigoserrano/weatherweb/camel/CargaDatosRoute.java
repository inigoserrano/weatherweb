package com.inigoserrano.weatherweb.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.csv.CsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.csv.writer.CSVConfig;
import org.apache.commons.csv.writer.CSVField;

public class CargaDatosRoute extends RouteBuilder {

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
		from(uriFrom).unmarshal(config()).split().body().parallelProcessing().marshal().json(JsonLibrary.Jackson).to(uriTo);

	}

	private CsvDataFormat config() {

		CSVConfig config = new CSVConfig();
		config.setDelimiter('\t');
		config.addField(new CSVField("No"));
		config.addField(new CSVField("Time"));
		config.addField(new CSVField("Interval"));
		config.addField(new CSVField("Indoor_Humidity"));
		config.addField(new CSVField("Indoor_Temperature"));
		config.addField(new CSVField("Outdoor_Humidity"));
		config.addField(new CSVField("Outdoor_Temperature"));
		config.addField(new CSVField("Absolute_Pressure"));
		config.addField(new CSVField("Wind"));
		config.addField(new CSVField("Gust"));
		config.addField(new CSVField("Direction"));
		config.addField(new CSVField("Relative_Pressure"));
		config.addField(new CSVField("Dewpoint"));
		config.addField(new CSVField("Windchill"));
		config.addField(new CSVField("Hour_Rainfall"));
		config.addField(new CSVField("Day_hour_Rainfall"));
		config.addField(new CSVField("Week_Rainfall"));
		config.addField(new CSVField("Month_Rainfall"));
		config.addField(new CSVField("Total_Rainfall"));
		config.addField(new CSVField("Wind_Level"));
		config.addField(new CSVField("Gust_Level"));

		CsvDataFormat formato = new CsvDataFormat();
		formato.setConfig(config);
		formato.setAutogenColumns(true);
		formato.setUseMaps(true);
		formato.setSkipFirstLine(true);
		return formato;

	}

}
