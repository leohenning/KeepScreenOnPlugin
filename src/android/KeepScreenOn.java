package com.Kidobi.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
//import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.view.WindowManager;

public class KeepScreenOn extends CordovaPlugin {
	
	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		System.out.println("Im in the plugin");
		if (action.equalsIgnoreCase("KeepScreenOn")) {
			System.out.println("Start KeepScreenOn");
			cordova.getActivity().runOnUiThread(new Runnable() {
	            public void run() {
	            	cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    				System.out.println("Screen will be kept on. KeepScreenOn");
	            }
	        });
            //cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            //callbackContext.success(action);
            return true;
        } else if (action.equalsIgnoreCase("CancelKeepScreenOn")){
			System.out.println("CancelKeepScreenOn");
			cordova.getActivity().runOnUiThread(new Runnable() {
	            public void run() {
	            	cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	            	System.out.println("Screen will not be kept on. Cancel KeepScreenOn");
	            }
	        });
            //cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            //callbackContext.success(action);
            return true;
        } else {
			System.out.println("UNKNOWN");
			callbackContext.error("unknown action" + action);
            return false;
        }
	}

}
