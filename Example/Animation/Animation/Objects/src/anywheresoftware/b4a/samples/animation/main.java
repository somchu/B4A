package anywheresoftware.b4a.samples.animation;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "anywheresoftware.b4a.samples.animation", "anywheresoftware.b4a.samples.animation.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, true))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "anywheresoftware.b4a.samples.animation", "anywheresoftware.b4a.samples.animation.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "anywheresoftware.b4a.samples.animation.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button3 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button4 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button5 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button6 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button7 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button8 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button9 = null;
public anywheresoftware.b4a.objects.AnimationWrapper _a6 = null;
public anywheresoftware.b4a.objects.AnimationWrapper _a7 = null;
public anywheresoftware.b4a.objects.AnimationWrapper _a8 = null;
public anywheresoftware.b4a.objects.AnimationWrapper _a9 = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.AnimationWrapper _a1 = null;
anywheresoftware.b4a.objects.AnimationWrapper _a2 = null;
anywheresoftware.b4a.objects.AnimationWrapper _a3 = null;
anywheresoftware.b4a.objects.AnimationWrapper _a4 = null;
anywheresoftware.b4a.objects.AnimationWrapper _a5 = null;
anywheresoftware.b4a.objects.AnimationWrapper[] _animations = null;
int _i = 0;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Dim a1, a2, a3, a4, a5 As Animation";
_a1 = new anywheresoftware.b4a.objects.AnimationWrapper();
_a2 = new anywheresoftware.b4a.objects.AnimationWrapper();
_a3 = new anywheresoftware.b4a.objects.AnimationWrapper();
_a4 = new anywheresoftware.b4a.objects.AnimationWrapper();
_a5 = new anywheresoftware.b4a.objects.AnimationWrapper();
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Activity.LoadLayout(\"1\")";
mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="a1.InitializeAlpha(\"\", 1, 0)";
_a1.InitializeAlpha(mostCurrent.activityBA,"",(float) (1),(float) (0));
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Button1.Tag = a1";
mostCurrent._button1.setTag((Object)(_a1.getObject()));
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="a2.InitializeRotate(\"\", 0, 180)";
_a2.InitializeRotate(mostCurrent.activityBA,"",(float) (0),(float) (180));
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="Button2.Tag = a2";
mostCurrent._button2.setTag((Object)(_a2.getObject()));
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="a3.InitializeRotateCenter(\"\", 0, 180, Button3)";
_a3.InitializeRotateCenter(mostCurrent.activityBA,"",(float) (0),(float) (180),(android.view.View)(mostCurrent._button3.getObject()));
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="Button3.Tag = a3";
mostCurrent._button3.setTag((Object)(_a3.getObject()));
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="a4.InitializeScale(\"\", 1, 1, 0, 0)";
_a4.InitializeScale(mostCurrent.activityBA,"",(float) (1),(float) (1),(float) (0),(float) (0));
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="Button4.Tag = a4";
mostCurrent._button4.setTag((Object)(_a4.getObject()));
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="a5.InitializeScaleCenter(\"\", 1, 1, 0, 0, Button4)";
_a5.InitializeScaleCenter(mostCurrent.activityBA,"",(float) (1),(float) (1),(float) (0),(float) (0),(android.view.View)(mostCurrent._button4.getObject()));
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="Button5.Tag = a5";
mostCurrent._button5.setTag((Object)(_a5.getObject()));
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="Dim animations() As Animation";
_animations = new anywheresoftware.b4a.objects.AnimationWrapper[(int) (0)];
{
int d0 = _animations.length;
for (int i0 = 0;i0 < d0;i0++) {
_animations[i0] = new anywheresoftware.b4a.objects.AnimationWrapper();
}
}
;
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="animations = Array As Animation(a1, a2, a3, a4, a";
_animations = new anywheresoftware.b4a.objects.AnimationWrapper[]{_a1,_a2,_a3,_a4,_a5};
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="For i = 0 To animations.Length - 1";
{
final int step15 = 1;
final int limit15 = (int) (_animations.length-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="animations(i).Duration = 1000";
_animations[_i].setDuration((long) (1000));
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="animations(i).RepeatCount = 1";
_animations[_i].setRepeatCount((int) (1));
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="animations(i).RepeatMode = animations(i).REPEAT_";
_animations[_i].setRepeatMode(_animations[_i].REPEAT_REVERSE);
 }
};
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="a6.InitializeTranslate(\"Animation\", 0, 0, 0dip, 2";
mostCurrent._a6.InitializeTranslate(mostCurrent.activityBA,"Animation",(float) (0),(float) (0),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))));
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="a7.InitializeTranslate(\"Animation\", 0dip, 200dip,";
mostCurrent._a7.InitializeTranslate(mostCurrent.activityBA,"Animation",(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))),(float) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))));
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="a8.InitializeTranslate(\"Animation\", -200dip, 200d";
mostCurrent._a8.InitializeTranslate(mostCurrent.activityBA,"Animation",(float) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))),(float) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0))));
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="a9.InitializeTranslate(\"Animation\", -200dip, 0dip";
mostCurrent._a9.InitializeTranslate(mostCurrent.activityBA,"Animation",(float) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0))));
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="Button6.Tag = a6";
mostCurrent._button6.setTag((Object)(mostCurrent._a6.getObject()));
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="animations = Array As Animation(a6, a7, a8, a9)";
_animations = new anywheresoftware.b4a.objects.AnimationWrapper[]{mostCurrent._a6,mostCurrent._a7,mostCurrent._a8,mostCurrent._a9};
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="For i = 0 To animations.Length - 1";
{
final int step26 = 1;
final int limit26 = (int) (_animations.length-1);
_i = (int) (0) ;
for (;_i <= limit26 ;_i = _i + step26 ) {
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="animations(i).Duration = 500";
_animations[_i].setDuration((long) (500));
 }
};
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="End Sub";
return "";
}
public static String  _animation_animationend() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "animation_animationend", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "animation_animationend", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Animation_AnimationEnd";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="If Sender = a6 Then";
if ((anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)).equals((Object)(mostCurrent._a6.getObject()))) { 
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="a7.Start(Button6)";
mostCurrent._a7.Start((android.view.View)(mostCurrent._button6.getObject()));
 }else 
{RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="Else If Sender = a7 Then";
if ((anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)).equals((Object)(mostCurrent._a7.getObject()))) { 
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="a8.Start(Button6)";
mostCurrent._a8.Start((android.view.View)(mostCurrent._button6.getObject()));
 }else 
{RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Else If Sender = a8 Then";
if ((anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)).equals((Object)(mostCurrent._a8.getObject()))) { 
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="a9.Start(Button6)";
mostCurrent._a9.Start((android.view.View)(mostCurrent._button6.getObject()));
 }}}
;
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="End Sub";
return "";
}
public static String  _button_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _b = null;
anywheresoftware.b4a.objects.AnimationWrapper _a = null;
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub Button_Click";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Dim b As Button";
_b = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="b = Sender";
_b = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="If Not(b.Tag Is Animation) Then Return";
if (anywheresoftware.b4a.keywords.Common.Not(_b.getTag() instanceof android.view.animation.Animation)) { 
if (true) return "";};
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="Dim a As Animation";
_a = new anywheresoftware.b4a.objects.AnimationWrapper();
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="a = b.Tag";
_a = (anywheresoftware.b4a.objects.AnimationWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.AnimationWrapper(), (android.view.animation.Animation)(_b.getTag()));
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="a.Start(b)";
_a.Start((android.view.View)(_b.getObject()));
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="End Sub";
return "";
}
}