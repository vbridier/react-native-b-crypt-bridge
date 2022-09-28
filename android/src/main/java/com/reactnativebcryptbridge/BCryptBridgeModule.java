package com.reactnativebcryptbridge;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.bridge.Callback;

@ReactModule(name = BCryptBridgeModule.NAME)
public class BCryptBridgeModule extends ReactContextBaseJavaModule {
    public static final String NAME = "BCryptBridge";

    public BCryptBridgeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void verify(String text, String hash, Callback successCallback, Callback errorCallback) {
        try {
            BCrypt.Result result = BCrypt.verifyer(BCrypt.Version.VERSION_2Y).verifyStrict(text.toCharArray(), hash.toCharArray());
            successCallback.invoke(result.verified);
        }catch (IllegalArgumentException e){
            errorCallback.invoke(e.getMessage());
        }
    }
}
