package com.serenegiant.glutils;
import android.opengl.*;
import android.util.*;

public class MyEglSurface {
	private final EGLBase mEgl;
	private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;
	private final int mWidth, mHeight;
	private static boolean DEBUG = true;
	private static String TAG = "MyeglSurface";
	MyEglSurface(final EGLBase egl, final Object surface) {
		mEgl = egl;
		
		mEglSurface = mEgl.createWindowSurface(surface);
		mWidth = mEgl.querySurface(mEglSurface, EGL14.EGL_WIDTH);
		mHeight = mEgl.querySurface(mEglSurface, EGL14.EGL_HEIGHT);
		if (DEBUG) Log.v(TAG, String.format("EglSurface:size(%d,%d)", mWidth, mHeight));
	}

	MyEglSurface(final EGLBase egl, final int width, final int height) {
		if (DEBUG) Log.v(TAG, "EglSurface:");
		mEgl = egl;
		mEglSurface = mEgl.createOffscreenSurface(width, height);
		mWidth = width;
		mHeight = height;
	}

	public void makeCurrent() {
		mEgl.makeCurrent(mEglSurface);
	}

	public void swap() {
		mEgl.swap(mEglSurface);
	}

	public EGLContext getContext() {
		return mEgl.getContext();
	}

	public void release() {
		if (DEBUG) Log.v(TAG, "EglSurface:release:");
		mEgl.makeDefault();
		mEgl.destroyWindowSurface(mEglSurface);
		mEglSurface = EGL14.EGL_NO_SURFACE;
	}

	public int getWidth() {
		return mWidth;
	}

	public int getHeight() {
		return mHeight;
	}
}
