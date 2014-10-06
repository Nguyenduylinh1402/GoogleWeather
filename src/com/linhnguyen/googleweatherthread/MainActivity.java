package com.linhnguyen.googleweatherthread;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	String urls = "http://api.worldweatheronline.com/free/v1/weather.ashx?q=VietNam&format=json&num_of_days=5&key=9ee5cd598c0309e0e1cae6aaae8671c8a3035773";
	String result;
	TextView txtCountry, txtCurrent, txtTemp, txtHumidity;
	TextView txtDate1, txtDate2, txtDate3, txtDate4, txtDate5;
	TextView txtHtemp1, txtHtemp2, txtHtemp3, txtHtemp4, txtHtemp5;
	TextView txtLtemp1, txtLtemp2, txtLtemp3, txtLtemp4, txtLtemp5;
	ImageView ima, ima1, ima2, ima3, ima4, ima5;
	private ProgressDialog dialog;

	public static final String BIG = "BIG_ICON";
	public static final String MEDIUM = "MEDIUM_ICON";
	public static final String SMALL = "SMALL_ICON";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather);

		dialog = new ProgressDialog(this);
		dialog.setTitle("Loading");
		dialog.setMessage("Please wait ...");
		dialog.show();

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				result = readJSONURL(urls);

				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						try {

							JSONObject jsonObject = new JSONObject(result);

							JSONObject data = jsonObject.getJSONObject("data");

							// Current Condition
							JSONArray current_condition = data
									.getJSONArray("current_condition");
							JSONObject jO = current_condition.getJSONObject(0);
							String temp_C = jO.getString("temp_C");
							String humidity = jO.getString("humidity");
							Integer weatherCode = jO.getInt("weatherCode");

							JSONArray request = data.getJSONArray("request");
							JSONObject jORequest = request.getJSONObject(0);
							String query = jORequest.getString("query");

							JSONArray weatherCurrent = data
									.getJSONArray("weather");
							JSONObject jOWeather = weatherCurrent
									.getJSONObject(0);
							JSONArray weatherDesc = jOWeather
									.getJSONArray("weatherDesc");
							JSONObject jOWeatherDesc = weatherDesc
									.getJSONObject(0);
							String value = jOWeatherDesc.getString("value");

							// Weather
							JSONArray weather = data.getJSONArray("weather");

							// Weather0
							JSONObject jOWeather0 = weather.getJSONObject(0);
							String date0 = jOWeather0.getString("date");
							String date00 = parseDate(date0);
							String tempMaxC0 = jOWeather0.getString("tempMaxC");
							String tempMinC0 = jOWeather0.getString("tempMinC");
							Integer weatherCode0 = jOWeather0
									.getInt("weatherCode");

							// Weather1
							JSONObject jOWeather1 = weather.getJSONObject(1);
							String date1 = jOWeather1.getString("date");
							String date11 = parseDate(date1);
							String tempMaxC1 = jOWeather1.getString("tempMaxC");
							String tempMinC1 = jOWeather1.getString("tempMinC");
							Integer weatherCode1 = jOWeather1
									.getInt("weatherCode");

							// Weather2
							JSONObject jOWeather2 = weather.getJSONObject(2);
							String date2 = jOWeather2.getString("date");
							String date22 = parseDate(date2);
							String tempMaxC2 = jOWeather2.getString("tempMaxC");
							String tempMinC2 = jOWeather2.getString("tempMinC");
							Integer weatherCode2 = jOWeather2
									.getInt("weatherCode");

							// Weather3
							JSONObject jOWeather3 = weather.getJSONObject(3);
							String date3 = jOWeather3.getString("date");
							String date33 = parseDate(date3);
							String tempMaxC3 = jOWeather3.getString("tempMaxC");
							String tempMinC3 = jOWeather3.getString("tempMinC");
							Integer weatherCode3 = jOWeather3
									.getInt("weatherCode");

							// Weather4
							JSONObject jOWeather4 = weather.getJSONObject(4);
							String date4 = jOWeather4.getString("date");
							String date44 = parseDate(date4);
							String tempMaxC4 = jOWeather4.getString("tempMaxC");
							String tempMinC4 = jOWeather4.getString("tempMinC");
							Integer weatherCode4 = jOWeather4
									.getInt("weatherCode");

							txtCountry = (TextView) findViewById(R.id.txtCountry);
							txtCountry.setText(query);
							txtTemp = (TextView) findViewById(R.id.txtTemp);
							txtTemp.setText(temp_C + "\u2103");
							txtCurrent = (TextView) findViewById(R.id.txtCurrent);
							txtCurrent.setText(value);
							txtHumidity = (TextView) findViewById(R.id.txtHumidity);
							txtHumidity.setText("Humidity: " + humidity);
							ima = (ImageView) findViewById(R.id.ima);
							ima.setImageResource(WeatherUtil.getIconId(
									weatherCode, MEDIUM));
							// Weather1
							txtDate1 = (TextView) findViewById(R.id.txtDate1);
							txtDate1.setText(date00);
							txtHtemp1 = (TextView) findViewById(R.id.txtHtemp1);
							txtHtemp1.setText(tempMaxC0);
							txtLtemp1 = (TextView) findViewById(R.id.txtLtemp1);
							txtLtemp1.setText(tempMinC0);
							ima1 = (ImageView) findViewById(R.id.ima1);
							ima1.setImageResource(WeatherUtil.getIconId(
									weatherCode0, SMALL));

							// Weather2
							txtDate2 = (TextView) findViewById(R.id.txtDate2);
							txtDate2.setText(date11);
							txtHtemp2 = (TextView) findViewById(R.id.txtHtemp2);
							txtHtemp2.setText(tempMaxC1);
							txtLtemp2 = (TextView) findViewById(R.id.txtLtemp2);
							txtLtemp2.setText(tempMinC1);
							ima2 = (ImageView) findViewById(R.id.ima2);
							ima2.setImageResource(WeatherUtil.getIconId(
									weatherCode1, SMALL));

							// Weather3
							txtDate3 = (TextView) findViewById(R.id.txtDate3);
							txtDate3.setText(date22);
							txtHtemp3 = (TextView) findViewById(R.id.txtHtemp3);
							txtHtemp3.setText(tempMaxC2);
							txtLtemp3 = (TextView) findViewById(R.id.txtLtemp3);
							txtLtemp3.setText(tempMinC2);
							ima3 = (ImageView) findViewById(R.id.ima3);
							ima3.setImageResource(WeatherUtil.getIconId(
									weatherCode2, SMALL));

							// Weather4
							txtDate4 = (TextView) findViewById(R.id.txtDate4);
							txtDate4.setText(date33);
							txtHtemp4 = (TextView) findViewById(R.id.txtHtemp4);
							txtHtemp4.setText(tempMaxC3);
							txtLtemp4 = (TextView) findViewById(R.id.txtLtemp4);
							txtLtemp4.setText(tempMinC3);
							ima4 = (ImageView) findViewById(R.id.ima4);
							ima4.setImageResource(WeatherUtil.getIconId(
									weatherCode3, SMALL));

							// Weather5
							txtDate5 = (TextView) findViewById(R.id.txtDate5);
							txtDate5.setText(date44);
							txtHtemp5 = (TextView) findViewById(R.id.txtHtemp5);
							txtHtemp5.setText(tempMaxC4);
							txtLtemp5 = (TextView) findViewById(R.id.txtLtemp5);
							txtLtemp5.setText(tempMinC4);
							ima5 = (ImageView) findViewById(R.id.ima5);
							ima5.setImageResource(WeatherUtil.getIconId(
									weatherCode4, SMALL));

							dialog.dismiss();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				// threadMsg(result);
			}

		});

		thread.start();

	}

	public String readJSONURL(String URL) {
		StringBuilder stringBuilder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					stringBuilder.append(line);
				}
			} else {
				Log.e("JSON", "Failed to download file");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// qua trinh doc du lieu ve xong thi dong dialog lai
		return stringBuilder.toString();
	}

	private String parseDate(String inputDate) {
		// String inputDate = "2014-08-25";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(inputDate);
			DateFormat dateFormat = new SimpleDateFormat("E");
			String finalDay = dateFormat.format(date);
			return finalDay;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputDate;

	}

}
