package com.linhnguyen.googleweatherthread;

public class WeatherUtil {

	private static final int[] SUNNY = { 113, 116 };
	private static final int[] CLOUD = { 119, 122, 143, 248, };
	private static final int[] FREEZING = { 182, 185, 260, 281, 284, 311, 314,
			317, 350, 362, 365, 374, 377 };
	private static final int[] SHOWER = { 176, 200, 263, 299, 302, 305, 308,
			356, 356, 86, 89 };
	private static final int[] SHOWER_DAY = { 266, 293, 296, 353 };
	private static final int[] STORM = { 389 };
	private static final int[] SNOW = { 179, 227, 230, 320, 323, 326, 329, 332,
			335, 338, 368, 371, 392, 395 };

	public static int getIconId(int weatherCode, String sizeIcon) {
		int sizeSunny = SUNNY.length;
		for (int i = 0; i < sizeSunny; i++) {
			if (SUNNY[i] == weatherCode) {
				if (sizeIcon == MainActivity.MEDIUM)
					return R.drawable.clear_icon;
				else if (sizeIcon == MainActivity.SMALL)
					return R.drawable.clear_icon_s;
			}
		}
		int sizeCloud = CLOUD.length;
		for (int i = 0; i < sizeCloud; i++) {
			if (CLOUD[i] == weatherCode) {
				if (sizeIcon == MainActivity.MEDIUM)
					return R.drawable.clouds_icon;
				else if (sizeIcon == MainActivity.SMALL)
					return R.drawable.clouds_icon_s;
			}
		}
		int sizeFreezing = FREEZING.length;
		for (int i = 0; i < sizeFreezing; i++) {
			if (FREEZING[i] == weatherCode) {
				if (sizeIcon == MainActivity.MEDIUM)
					return R.drawable.freezing_rain_icon;
				else if (sizeIcon == MainActivity.SMALL)
					return R.drawable.freezing_rain_icon_s;
			}
		}
		int sizeShower = SHOWER.length;
		for (int i = 0; i < sizeShower; i++) {
			if (SHOWER[i] == weatherCode) {
				if (sizeIcon == MainActivity.MEDIUM)
					return R.drawable.snow_scattered_icon;
				else if (sizeIcon == MainActivity.SMALL)
					return R.drawable.snow_scattered_icon_s;
			}
		}
		int sizeShowerD = SHOWER_DAY.length;
		for (int i = 0; i < sizeShowerD; i++) {
			if (SHOWER_DAY[i] == weatherCode) {
				if (sizeIcon == MainActivity.MEDIUM)
					return R.drawable.showers_day_icon;
				else if (sizeIcon == MainActivity.SMALL)
					return R.drawable.showers_day_icon_s;
			}
		}
		int sizeStorm = STORM.length;
		for (int i = 0; i < sizeStorm; i++) {
			if (STORM[i] == weatherCode) {
				if (sizeIcon == MainActivity.MEDIUM)
					return R.drawable.showers_icon;
				else if (sizeIcon == MainActivity.SMALL)
					return R.drawable.showers_icon_s;
			}
		}
		int sizeSnow = SNOW.length;
		for (int i = 0; i < sizeSnow; i++) {
			if (SNOW[i] == weatherCode) {
				if (sizeIcon == MainActivity.MEDIUM)
					return R.drawable.storm_icon;
				else if (sizeIcon == MainActivity.SMALL) {
					return R.drawable.storm_icon_s;
				}
			}
		}
		return 0;
	}
}
