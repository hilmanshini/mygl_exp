package com.serenegiant.glutils;
import static android.opengl.EGL14.*;
import android.opengl.*;
public class EGLWrapper
{
	private EGLConfig mEglConfig = null;
	private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;
	private EGLDisplay mEglDisplay = EGL14.EGL_NO_DISPLAY;
	private EGLContext mDefaultContext = EGL14.EGL_NO_CONTEXT;
	public void checkAlreadySettedUp(){
		if (mEglDisplay != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
	}
	public void checkAlreadyDisplayed(){
		mEglDisplay = EGL14.eglGetDisplay(EGL14.EGL_DEFAULT_DISPLAY);
        if (mEglDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetDisplay failed");
        }
	}
	public void destroy(){
		
	}
}
