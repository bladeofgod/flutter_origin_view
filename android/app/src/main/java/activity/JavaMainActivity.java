package activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

import com.bladeofgod.flutter_origin_view.R;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

/**
 * @author LiJiaqi
 * @date 2020/5/10
 * Description:
 */
public class JavaMainActivity extends FlutterActivity {

    @Override
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        PlatformViewRegistry registry = flutterEngine.getPlatformViewsController().getRegistry();
        registry.registerViewFactory("platform_text_view",
                new AndroidTextViewFactory(StandardMessageCodec.INSTANCE));
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.java_main_activity);
//
//    }
}
