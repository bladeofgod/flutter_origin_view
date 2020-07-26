package activity;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bladeofgod.flutter_origin_view.R;

import io.flutter.plugin.platform.PlatformView;

/**
 * @author LiJiaqi
 * @date 2020/7/26
 * Description:
 */
public class AndroidImageView  implements PlatformView {

    public Context context;
    public ImageView imageView;
    AndroidImageView(Context context){
        this.context = context;
        this.imageView = buildIV();
    }

    @Override
    public View getView() {
        return imageView;
    }

    private ImageView buildIV(){
        ImageView iv = new ImageView(context);

        //iv.setLayoutParams(buildLayoutParams(1));
        return iv;
    }

    private FrameLayout.LayoutParams buildLayoutParams(double ratio) {
        FrameLayout.LayoutParams params;
        params = new FrameLayout.LayoutParams(
                dp2px(context, (float) (200*ratio)), dp2px(context, (float) (200*ratio)));
        params.setMargins(dp2px(context, 10), dp2px(context, 10),
                dp2px(context, 10), dp2px(context, 10));

        return params;
    }
    private int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    @Override
    public void dispose() {

    }
}
