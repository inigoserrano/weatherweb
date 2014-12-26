package com.inigoserrano.weatherweb.camel;

import java.math.BigDecimal;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = "\t")
public class RegistroMeteorologico {
	@DataField(pos = 1)
	private BigDecimal No;
	@DataField(pos = 2)
	private String Time;
	@DataField(pos = 3)
	private String Interval;
	@DataField(pos = 4)
	private String Indoor_Humidity;
	@DataField(pos = 5)
	private String Indoor_Temperature;
	@DataField(pos = 6)
	private String Outdoor_Humidity;
	@DataField(pos = 7)
	private String Outdoor_Temperature;
	@DataField(pos = 8)
	private String Absolute_Pressure;
	@DataField(pos = 9)
	private String Wind;
	@DataField(pos = 10)
	private String Gust;
	@DataField(pos = 11)
	private String Direction;
	@DataField(pos = 12)
	private String Relative_Pressure;
	@DataField(pos = 13)
	private String Dewpoint;
	@DataField(pos = 14)
	private String Windchill;
	@DataField(pos = 15)
	private String Hour_Rainfall;
	@DataField(pos = 16)
	private String Day_hour_Rainfall;
	@DataField(pos = 17)
	private String Week_Rainfall;
	@DataField(pos = 18)
	private String Month_Rainfall;
	@DataField(pos = 19)
	private String Total_Rainfall;
	@DataField(pos = 20)
	private String Wind_Level;
	@DataField(pos = 21)
	private String Gust_Level;

	public BigDecimal getNo() {
		return No;
	}

	public void setNo(BigDecimal no) {
		No = no;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getInterval() {
		return Interval;
	}

	public void setInterval(String interval) {
		Interval = interval;
	}

	public String getIndoor_Humidity() {
		return Indoor_Humidity;
	}

	public void setIndoor_Humidity(String indoor_Humidity) {
		Indoor_Humidity = indoor_Humidity;
	}

	public String getIndoor_Temperature() {
		return Indoor_Temperature;
	}

	public void setIndoor_Temperature(String indoor_Temperature) {
		Indoor_Temperature = indoor_Temperature;
	}

	public String getOutdoor_Humidity() {
		return Outdoor_Humidity;
	}

	public void setOutdoor_Humidity(String outdoor_Humidity) {
		Outdoor_Humidity = outdoor_Humidity;
	}

	public String getOutdoor_Temperature() {
		return Outdoor_Temperature;
	}

	public void setOutdoor_Temperature(String outdoor_Temperature) {
		Outdoor_Temperature = outdoor_Temperature;
	}

	public String getAbsolute_Pressure() {
		return Absolute_Pressure;
	}

	public void setAbsolute_Pressure(String absolute_Pressure) {
		Absolute_Pressure = absolute_Pressure;
	}

	public String getWind() {
		return Wind;
	}

	public void setWind(String wind) {
		Wind = wind;
	}

	public String getGust() {
		return Gust;
	}

	public void setGust(String gust) {
		Gust = gust;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String direction) {
		Direction = direction;
	}

	public String getRelative_Pressure() {
		return Relative_Pressure;
	}

	public void setRelative_Pressure(String relative_Pressure) {
		Relative_Pressure = relative_Pressure;
	}

	public String getDewpoint() {
		return Dewpoint;
	}

	public void setDewpoint(String dewpoint) {
		Dewpoint = dewpoint;
	}

	public String getWindchill() {
		return Windchill;
	}

	public void setWindchill(String windchill) {
		Windchill = windchill;
	}

	public String getHour_Rainfall() {
		return Hour_Rainfall;
	}

	public void setHour_Rainfall(String hour_Rainfall) {
		Hour_Rainfall = hour_Rainfall;
	}

	public String getDay_hour_Rainfall() {
		return Day_hour_Rainfall;
	}

	public void setDay_hour_Rainfall(String day_hour_Rainfall) {
		Day_hour_Rainfall = day_hour_Rainfall;
	}

	public String getWeek_Rainfall() {
		return Week_Rainfall;
	}

	public void setWeek_Rainfall(String week_Rainfall) {
		Week_Rainfall = week_Rainfall;
	}

	public String getMonth_Rainfall() {
		return Month_Rainfall;
	}

	public void setMonth_Rainfall(String month_Rainfall) {
		Month_Rainfall = month_Rainfall;
	}

	public String getTotal_Rainfall() {
		return Total_Rainfall;
	}

	public void setTotal_Rainfall(String total_Rainfall) {
		Total_Rainfall = total_Rainfall;
	}

	public String getWind_Level() {
		return Wind_Level;
	}

	public void setWind_Level(String wind_Level) {
		Wind_Level = wind_Level;
	}

	public String getGust_Level() {
		return Gust_Level;
	}

	public void setGust_Level(String gust_Level) {
		Gust_Level = gust_Level;
	}
}
