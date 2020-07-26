package activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bladeofgod.flutter_origin_view.MainActivity;
import com.bladeofgod.flutter_origin_view.R;

import java.util.ArrayList;
import java.util.List;
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

    private FrameLayout.LayoutParams buildLayoutParams(double ratio) {
        FrameLayout.LayoutParams params;
        params = new FrameLayout.LayoutParams(
                dp2px(this, (float) (200*ratio)), dp2px(this, (float) (200*ratio)));
        params.setMargins(dp2px(this, 10), dp2px(this, 100),
                dp2px(this, 10), dp2px(this, 10));

        return params;
    }

    private int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    List<Integer> list = new ArrayList<>();

    Activity activity;
    @Override
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        PlatformViewRegistry registry = flutterEngine.getPlatformViewsController().getRegistry();
        registry.registerViewFactory("platform_text_view",
                new AndroidTextViewFactory(StandardMessageCodec.INSTANCE));
        activity = this;
//
//        for (int i=0; i < 30 ;i++){
//            list.add(i);
//        }
//
//
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tv();

                    }
                },2000);
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.java_main_activity);
//
//    }

    private FrameLayout.LayoutParams buildListP(double ratio) {
        FrameLayout.LayoutParams params;
        params = new FrameLayout.LayoutParams(
                dp2px(this, (float) (200*ratio)), dp2px(this, (float) (400*ratio)));
        params.setMargins(dp2px(this, 10), dp2px(this, 10),
                dp2px(this, 10), dp2px(this, 10));

        return params;
    }

    private void initListView(){
        ImageAdapter adapter = new ImageAdapter(activity, 1,list);
        ListView listView = new ListView(activity);
        listView.setAdapter(adapter);
        activity.addContentView(listView, buildListP(2));
    }

    private void iv(){
        ImageView iv = new ImageView(activity);
        iv.setImageResource(R.drawable.svg_devil);
        addContentView(iv,buildLayoutParams(1));
    }
    private void lv(){

    }

    private void tv(){
        TextView tv = new TextView(activity);
        tv.setText("我是原生view");
        tv.setTextColor(0xFFFF8C00);
        tv.setBackgroundColor(0xFF1E90FF);
        addContentView(tv,buildLayoutParams(1));
    }

    class ImageAdapter extends ArrayAdapter<Integer>{


        public ImageAdapter(@NonNull Context context, int resource, @NonNull List<Integer> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ImageView iv = new ImageView(getContext());
            iv.setImageResource(R.drawable.svg_devil);
            iv.setLayoutParams(buildLayoutParams(1));
            return iv;
        }
    }
}


