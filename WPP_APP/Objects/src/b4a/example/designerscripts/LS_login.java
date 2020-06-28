package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_login{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[Login/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="Panel1.Width = 100%x"[Login/General script]
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 4;BA.debugLine="Panel1.Height = 100%y"[Login/General script]
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 6;BA.debugLine="LblUserName.Top = ((Panel1.Height - LblUserName.Width)/2)-140dip"[Login/General script]
views.get("lblusername").vw.setTop((int)((((views.get("panel1").vw.getHeight())-(views.get("lblusername").vw.getWidth()))/2d)-(140d * scale)));
//BA.debugLineNum = 7;BA.debugLine="LblUserName.Left = ((Panel1.Width - LblUserName.Width)/2)- 140dip"[Login/General script]
views.get("lblusername").vw.setLeft((int)((((views.get("panel1").vw.getWidth())-(views.get("lblusername").vw.getWidth()))/2d)-(140d * scale)));
//BA.debugLineNum = 9;BA.debugLine="TxtUserName.Top = LblUserName.Bottom + 15dip"[Login/General script]
views.get("txtusername").vw.setTop((int)((views.get("lblusername").vw.getTop() + views.get("lblusername").vw.getHeight())+(15d * scale)));
//BA.debugLineNum = 10;BA.debugLine="TxtUserName.Left = LblUserName.Left"[Login/General script]
views.get("txtusername").vw.setLeft((int)((views.get("lblusername").vw.getLeft())));
//BA.debugLineNum = 12;BA.debugLine="LblPassword.Top = TxtUserName.Bottom + 30dip"[Login/General script]
views.get("lblpassword").vw.setTop((int)((views.get("txtusername").vw.getTop() + views.get("txtusername").vw.getHeight())+(30d * scale)));
//BA.debugLineNum = 13;BA.debugLine="LblPassword.Left = LblUserName.Left"[Login/General script]
views.get("lblpassword").vw.setLeft((int)((views.get("lblusername").vw.getLeft())));
//BA.debugLineNum = 15;BA.debugLine="TxtPassword.Top = LblPassword.Bottom + 15dip"[Login/General script]
views.get("txtpassword").vw.setTop((int)((views.get("lblpassword").vw.getTop() + views.get("lblpassword").vw.getHeight())+(15d * scale)));
//BA.debugLineNum = 16;BA.debugLine="TxtPassword.Left = LblPassword.Left"[Login/General script]
views.get("txtpassword").vw.setLeft((int)((views.get("lblpassword").vw.getLeft())));

}
}