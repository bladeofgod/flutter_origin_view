package activity;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import io.flutter.plugin.platform.PlatformView;

/**
 * @author LiJiaqi
 * @date 2020/5/10
 * Description:
 */
public class AndroidTextView implements PlatformView {

    public TextView textView ;

    public AndroidTextView(Context context) {
        this.textView = new TextView(context);
    }

    @Override
    public View getView() {
        return textView;
    }

    @Override
    public void dispose() {

    }
}
