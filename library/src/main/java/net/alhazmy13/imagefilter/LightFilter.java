
/*
 *
 *  Written by Alhazmy13  <alhazmy13.net>, 2016/2
 *
 *  LightFilter.java / LightFilter is part of ImageFilter
 *  Licensed under the Apache License, Version 2.0
 *
 */

package net.alhazmy13.imagefilter;

import android.graphics.Bitmap;

class LightFilter {
	
	static {
		System.loadLibrary("ImageFilter");
	}
	
	public static Bitmap changeToLight(Bitmap bitmap, int centerX, int centerY, int radius) {
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		
		int[] pixels = new int[width * height];
		bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
		
		int[] returnPixels = NativeFilterFunc.lightFilter(pixels, width, height, centerX, centerY, radius);
		Bitmap returnBitmap = Bitmap.createBitmap(returnPixels, width, height, Bitmap.Config.ARGB_8888);
		
		return returnBitmap;
	}
}
