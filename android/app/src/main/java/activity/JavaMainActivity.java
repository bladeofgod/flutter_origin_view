package activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bladeofgod.flutter_origin_view.MainActivity;
import com.bladeofgod.flutter_origin_view.R;

import java.util.Map;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

/**
 * @author LiJiaqi
 * @date 2020/5/10
 * Description:
 */
public class JavaMainActivity extends FlutterActivity {

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.java_main_activity);
//    }

    private FrameLayout.LayoutParams buildLayoutParams(MethodCall call) {
        FrameLayout.LayoutParams params;
        params = new FrameLayout.LayoutParams(
                dp2px(this, 200), dp2px(this, 200));
        params.setMargins(dp2px(this, 200), dp2px(this, 200),
                dp2px(this, 200), dp2px(this, 200));

        return params;
    }

    private int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    Activity activity;
    @Override
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        PlatformViewRegistry registry = flutterEngine.getPlatformViewsController().getRegistry();
        registry.registerViewFactory("platform_text_view",
                new AndroidTextViewFactory(StandardMessageCodec.INSTANCE));
        activity = this;
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        iv();
                    }
                },2000);
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.java_main_activity);
//
//    }

    private void iv(){
        ImageView iv = new ImageView(activity);
        iv.setImageResource(R.drawable.svg_devil);
        addContentView(iv,buildLayoutParams(null));
    }

    private void tv(){
        TextView tv = new TextView(activity);
        tv.setText("asldkjasdklj");
        tv.setTextColor(0xFFFF8C00);
        tv.setBackgroundColor(0xFF1E90FF);
        addContentView(tv,buildLayoutParams(null));
    }
}
