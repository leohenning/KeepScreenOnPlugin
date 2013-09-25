var keepScreenOn = {
    CancelKeepScreenOn: function () {
            cordova.exec(null, null, "KeepScreenOn", "CancelKeepScreenOn", [""]);
    },
    
    KeepScreenOn: function () {
            cordova.exec(null, null, "KeepScreenOn", "KeepScreenOn", [""]);
    }
};
module.exports = keepScreenOn;
