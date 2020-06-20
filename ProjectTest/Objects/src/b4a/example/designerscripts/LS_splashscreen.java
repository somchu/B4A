package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_splashscreen{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[SplashScreen/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="Panel1.HorizontalCenter = 50%x"[SplashScreen/General script]
views.get("panel1").vw.setLeft((int)((50d / 100 * width) - (views.get("panel1").vw.getWidth() / 2)));
//BA.debugLineNum = 4;BA.debugLine="Panel1.VerticalCenter = 50%y"[SplashScreen/General script]
views.get("panel1").vw.setTop((int)((50d / 100 * height) - (views.get("panel1").vw.getHeight() / 2)));
//BA.debugLineNum = 5;BA.debugLine="ImageView1.Top = (Panel1.Height - ImageView1.Height)/2"[SplashScreen/General script]
views.get("imageview1").vw.setTop((int)(((views.get("panel1").vw.getHeight())-(views.get("imageview1").vw.getHeight()))/2d));
//BA.debugLineNum = 6;BA.debugLine="ImageView1.Left = (Panel1.Width - ImageView1.Width)/2"[SplashScreen/General script]
views.get("imageview1").vw.setLeft((int)(((views.get("panel1").vw.getWidth())-(views.get("imageview1").vw.getWidth()))/2d));

}
}