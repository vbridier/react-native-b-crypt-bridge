"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.multiply = multiply;

var _reactNative = require("react-native");

const LINKING_ERROR = `The package 'react-native-b-crypt-bridge' doesn't seem to be linked. Make sure: \n\n` + _reactNative.Platform.select({
  ios: "- You have run 'pod install'\n",
  default: ''
}) + '- You rebuilt the app after installing the package\n' + '- You are not using Expo managed workflow\n';
const BCryptBridge = _reactNative.NativeModules.BCryptBridge ? _reactNative.NativeModules.BCryptBridge : new Proxy({}, {
  get() {
    throw new Error(LINKING_ERROR);
  }

});

function multiply(a, b) {
  return BCryptBridge.multiply(a, b);
}
//# sourceMappingURL=index.js.map