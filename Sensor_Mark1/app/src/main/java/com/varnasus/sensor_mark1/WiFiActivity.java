package com.varnasus.sensor_mark1;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

public class WiFiActivity extends Activity {

    private static final String TAG = "VARNEY: WiFiActivity - ";

    ToggleButton toggleWiFi;
    TextView wifiName;
    TextView enableWifiTv;
    TextView bssidTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi);

        Log.v(TAG, "onCreate");

        wifiName = findViewById(R.id.wifi_name);
        enableWifiTv = findViewById(R.id.enable_wifi_tv);
        bssidTv = findViewById(R.id.bssid_name);

        toggleWiFi = findViewById(R.id.wifi_switch);

        getCurrentSsid(this);
        getCurrentBssid(bssidTv);

        toggleWiFi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    enableWifiTv.setText("WiFi is ON");
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);
                } else {
                    enableWifiTv.setText("WiFi is OFF");
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                }
            }
        });

        if (toggleWiFi.isChecked()) {
            enableWifiTv.setText("WiFi is ON");
            WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            wifi.setWifiEnabled(true);
        } else {
            enableWifiTv.setText("WiFi is OFF");
            WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//            wifi.setWifiEnabled(false);
        }
    }


    public String getCurrentSsid(Context context) {
        String ssid = null;
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo.isConnected()) {
            final WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            final WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID())) {
                ssid = connectionInfo.getSSID();
                wifiName.setText(ssid);
            }
        } else {
            wifiName.setText("No WiFi Connection");
        }
        return ssid;
    }

    public void getCurrentBssid (TextView tvWifiList) {
        WifiManager wifiManager = (WifiManager)
                getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> results = wifiManager.getScanResults();
        String message = "No results. Check wireless is on";

        if (results != null) {

            final int size = results.size();

            if (size == 0) {
                message = "No access points in range";
            } else {
                ScanResult bestSignal = results.get(0);
                tvWifiList.setText(""); // etWifiList is EditText
                int count = 1;
                for (ScanResult result : results) {
                    tvWifiList.append(count++ + ". " + result.SSID + " : "
                            + result.level + "\n" + result.BSSID + "\n"
                            + result.capabilities + "\n"
                            + "\n=======================\n");
                    if (WifiManager.compareSignalLevel(bestSignal.level,
                            result.level) < 0) {
                        bestSignal = result;
                    }
                }
                message = String.format(
                        "%s networks found. %s is the strongest.", size,
                        bestSignal.SSID + " : " + bestSignal.level);
            }
        }
        bssidTv.setText(message);
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
