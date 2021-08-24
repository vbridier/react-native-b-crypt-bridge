package com.vbridier.bcrypt;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class BCryptBridgeModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public BCryptBridgeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "BCryptBridge";
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
