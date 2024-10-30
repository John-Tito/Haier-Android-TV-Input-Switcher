// MainActivity.java
package com.johntito.tvinputswitcher;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.KeyEvent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static int KEYCODE_HAIER_SOURCE = 2002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static Intent getHaierIntent() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        // 设置目标应用的包名和Activity
        intent.setComponent(new ComponentName("com.haier.tv.menusetting", "com.haier.tv.menusetting.RootActivity"));
        return intent;
    }

    public void switchInputSource(Intent intent) {

        PackageManager packageManager = getPackageManager();

        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        if (resolveInfos != null && !resolveInfos.isEmpty()) {
            this.startActivity(intent);
        } else {
            Toast.makeText(this, "目标应用未找到或不可访问", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(event.getKeyCode()==KEYCODE_HAIER_SOURCE) {
            switchInputSource(getHaierIntent());
        }
        return super.dispatchKeyEvent(event);
    }

    public void tv_switch(View view) {
        switchInputSource(getHaierIntent());
    }
}
