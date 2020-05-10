package activity;

import android.content.Context;
import android.util.Log;

import java.util.Map;

import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

/**
 * @author LiJiaqi
 * @date 2020/5/10
 * Description:
 */
public class AndroidTextViewFactory extends PlatformViewFactory {
    /**
     * @param createArgsCodec the codec used to decode the args parameter of {@link #create}.
     */
    public AndroidTextViewFactory(MessageCodec<Object> createArgsCodec) {
        super(createArgsCodec);
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        AndroidTextView androidTextView = new AndroidTextView(context);
        androidTextView.textView.setId(viewId);
        if(args instanceof Map){
            Log.i("android view factory", "args is map");
            Map map = (Map) args;
            String text = "null text";
            if(map.get("text") != null){
                text = map.get("text").toString();
            }
            androidTextView.textView.setText(text);
        }
        androidTextView.textView.setBackgroundColor(0xFF1E90FF);
        androidTextView.textView.setTextColor(0xFFFF8C00);
        return androidTextView;
    }
}
