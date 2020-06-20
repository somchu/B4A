package anywheresoftware.b4a.samples.animation;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,28);
if (RapidSub.canDelegate("activity_create")) { return anywheresoftware.b4a.samples.animation.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _a1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.AnimationWrapper");
RemoteObject _a2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.AnimationWrapper");
RemoteObject _a3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.AnimationWrapper");
RemoteObject _a4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.AnimationWrapper");
RemoteObject _a5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.AnimationWrapper");
RemoteObject _animations = null;
int _i = 0;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 29;BA.debugLine="Dim a1, a2, a3, a4, a5 As Animation";
Debug.ShouldStop(268435456);
_a1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");Debug.locals.put("a1", _a1);
_a2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");Debug.locals.put("a2", _a2);
_a3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");Debug.locals.put("a3", _a3);
_a4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");Debug.locals.put("a4", _a4);
_a5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");Debug.locals.put("a5", _a5);
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"1\")";
Debug.ShouldStop(536870912);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="a1.InitializeAlpha(\"\", 1, 0)";
Debug.ShouldStop(1073741824);
_a1.runVoidMethod ("InitializeAlpha",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("")),(Object)(BA.numberCast(float.class, 1)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 32;BA.debugLine="Button1.Tag = a1";
Debug.ShouldStop(-2147483648);
main.mostCurrent._button1.runMethod(false,"setTag",(_a1.getObject()));
 BA.debugLineNum = 33;BA.debugLine="a2.InitializeRotate(\"\", 0, 180)";
Debug.ShouldStop(1);
_a2.runVoidMethod ("InitializeRotate",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("")),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 180)));
 BA.debugLineNum = 34;BA.debugLine="Button2.Tag = a2";
Debug.ShouldStop(2);
main.mostCurrent._button2.runMethod(false,"setTag",(_a2.getObject()));
 BA.debugLineNum = 35;BA.debugLine="a3.InitializeRotateCenter(\"\", 0, 180, Button3)";
Debug.ShouldStop(4);
_a3.runVoidMethod ("InitializeRotateCenter",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("")),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 180)),(Object)((main.mostCurrent._button3.getObject())));
 BA.debugLineNum = 36;BA.debugLine="Button3.Tag = a3";
Debug.ShouldStop(8);
main.mostCurrent._button3.runMethod(false,"setTag",(_a3.getObject()));
 BA.debugLineNum = 37;BA.debugLine="a4.InitializeScale(\"\", 1, 1, 0, 0)";
Debug.ShouldStop(16);
_a4.runVoidMethod ("InitializeScale",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("")),(Object)(BA.numberCast(float.class, 1)),(Object)(BA.numberCast(float.class, 1)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 38;BA.debugLine="Button4.Tag = a4";
Debug.ShouldStop(32);
main.mostCurrent._button4.runMethod(false,"setTag",(_a4.getObject()));
 BA.debugLineNum = 39;BA.debugLine="a5.InitializeScaleCenter(\"\", 1, 1, 0, 0, Button4)";
Debug.ShouldStop(64);
_a5.runVoidMethod ("InitializeScaleCenter",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("")),(Object)(BA.numberCast(float.class, 1)),(Object)(BA.numberCast(float.class, 1)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)((main.mostCurrent._button4.getObject())));
 BA.debugLineNum = 40;BA.debugLine="Button5.Tag = a5";
Debug.ShouldStop(128);
main.mostCurrent._button5.runMethod(false,"setTag",(_a5.getObject()));
 BA.debugLineNum = 41;BA.debugLine="Dim animations() As Animation";
Debug.ShouldStop(256);
_animations = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.AnimationWrapper", new int[] {0}, new Object[]{});Debug.locals.put("animations", _animations);
 BA.debugLineNum = 42;BA.debugLine="animations = Array As Animation(a1, a2, a3, a4, a";
Debug.ShouldStop(512);
_animations = RemoteObject.createNewArray("anywheresoftware.b4a.objects.AnimationWrapper",new int[] {5},new Object[] {_a1,_a2,_a3,_a4,_a5});Debug.locals.put("animations", _animations);
 BA.debugLineNum = 43;BA.debugLine="For i = 0 To animations.Length - 1";
Debug.ShouldStop(1024);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_animations.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 44;BA.debugLine="animations(i).Duration = 1000";
Debug.ShouldStop(2048);
_animations.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setDuration",BA.numberCast(long.class, 1000));
 BA.debugLineNum = 45;BA.debugLine="animations(i).RepeatCount = 1";
Debug.ShouldStop(4096);
_animations.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setRepeatCount",BA.numberCast(int.class, 1));
 BA.debugLineNum = 46;BA.debugLine="animations(i).RepeatMode = animations(i).REPEAT_";
Debug.ShouldStop(8192);
_animations.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setRepeatMode",_animations.getArrayElement(false,BA.numberCast(int.class, _i)).getField(true,"REPEAT_REVERSE"));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 48;BA.debugLine="a6.InitializeTranslate(\"Animation\", 0, 0, 0dip, 2";
Debug.ShouldStop(32768);
main.mostCurrent._a6.runVoidMethod ("InitializeTranslate",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Animation")),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))))));
 BA.debugLineNum = 49;BA.debugLine="a7.InitializeTranslate(\"Animation\", 0dip, 200dip,";
Debug.ShouldStop(65536);
main.mostCurrent._a7.runVoidMethod ("InitializeTranslate",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Animation")),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))))),(Object)(BA.numberCast(float.class, -(double) (0 + main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))).<Integer>get().intValue()))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))))));
 BA.debugLineNum = 50;BA.debugLine="a8.InitializeTranslate(\"Animation\", -200dip, 200d";
Debug.ShouldStop(131072);
main.mostCurrent._a8.runVoidMethod ("InitializeTranslate",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Animation")),(Object)(BA.numberCast(float.class, -(double) (0 + main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))).<Integer>get().intValue()))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))))),(Object)(BA.numberCast(float.class, -(double) (0 + main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))).<Integer>get().intValue()))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0))))));
 BA.debugLineNum = 51;BA.debugLine="a9.InitializeTranslate(\"Animation\", -200dip, 0dip";
Debug.ShouldStop(262144);
main.mostCurrent._a9.runVoidMethod ("InitializeTranslate",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Animation")),(Object)(BA.numberCast(float.class, -(double) (0 + main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))).<Integer>get().intValue()))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0))))));
 BA.debugLineNum = 52;BA.debugLine="Button6.Tag = a6";
Debug.ShouldStop(524288);
main.mostCurrent._button6.runMethod(false,"setTag",(main.mostCurrent._a6.getObject()));
 BA.debugLineNum = 53;BA.debugLine="animations = Array As Animation(a6, a7, a8, a9)";
Debug.ShouldStop(1048576);
_animations = RemoteObject.createNewArray("anywheresoftware.b4a.objects.AnimationWrapper",new int[] {4},new Object[] {main.mostCurrent._a6,main.mostCurrent._a7,main.mostCurrent._a8,main.mostCurrent._a9});Debug.locals.put("animations", _animations);
 BA.debugLineNum = 54;BA.debugLine="For i = 0 To animations.Length - 1";
Debug.ShouldStop(2097152);
{
final int step26 = 1;
final int limit26 = RemoteObject.solve(new RemoteObject[] {_animations.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step26 > 0 && _i <= limit26) || (step26 < 0 && _i >= limit26) ;_i = ((int)(0 + _i + step26))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 55;BA.debugLine="animations(i).Duration = 500";
Debug.ShouldStop(4194304);
_animations.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setDuration",BA.numberCast(long.class, 500));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _animation_animationend() throws Exception{
try {
		Debug.PushSubsStack("Animation_AnimationEnd (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,58);
if (RapidSub.canDelegate("animation_animationend")) { return anywheresoftware.b4a.samples.animation.main.remoteMe.runUserSub(false, "main","animation_animationend");}
 BA.debugLineNum = 58;BA.debugLine="Sub Animation_AnimationEnd";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="If Sender = a6 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA),(main.mostCurrent._a6.getObject()))) { 
 BA.debugLineNum = 60;BA.debugLine="a7.Start(Button6)";
Debug.ShouldStop(134217728);
main.mostCurrent._a7.runVoidMethod ("Start",(Object)((main.mostCurrent._button6.getObject())));
 }else 
{ BA.debugLineNum = 61;BA.debugLine="Else If Sender = a7 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA),(main.mostCurrent._a7.getObject()))) { 
 BA.debugLineNum = 62;BA.debugLine="a8.Start(Button6)";
Debug.ShouldStop(536870912);
main.mostCurrent._a8.runVoidMethod ("Start",(Object)((main.mostCurrent._button6.getObject())));
 }else 
{ BA.debugLineNum = 63;BA.debugLine="Else If Sender = a8 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA),(main.mostCurrent._a8.getObject()))) { 
 BA.debugLineNum = 64;BA.debugLine="a9.Start(Button6)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._a9.runVoidMethod ("Start",(Object)((main.mostCurrent._button6.getObject())));
 }}}
;
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button_click() throws Exception{
try {
		Debug.PushSubsStack("Button_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,67);
if (RapidSub.canDelegate("button_click")) { return anywheresoftware.b4a.samples.animation.main.remoteMe.runUserSub(false, "main","button_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _a = RemoteObject.declareNull("anywheresoftware.b4a.objects.AnimationWrapper");
 BA.debugLineNum = 67;BA.debugLine="Sub Button_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="Dim b As Button";
Debug.ShouldStop(8);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 69;BA.debugLine="b = Sender";
Debug.ShouldStop(16);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 71;BA.debugLine="If Not(b.Tag Is Animation) Then Return";
Debug.ShouldStop(64);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(BA.ObjectToBoolean(RemoteObject.solveBoolean("i",_b.runMethod(false,"getTag"), RemoteObject.createImmutable("android.view.animation.Animation"))))).<Boolean>get().booleanValue()) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 72;BA.debugLine="Dim a As Animation";
Debug.ShouldStop(128);
_a = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");Debug.locals.put("a", _a);
 BA.debugLineNum = 73;BA.debugLine="a = b.Tag";
Debug.ShouldStop(256);
_a = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.AnimationWrapper"), _b.runMethod(false,"getTag"));
 BA.debugLineNum = 74;BA.debugLine="a.Start(b)";
Debug.ShouldStop(512);
_a.runVoidMethod ("Start",(Object)((_b.getObject())));
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim Button1 As Button";
main.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim Button2 As Button";
main.mostCurrent._button2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim Button3 As Button";
main.mostCurrent._button3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim Button4 As Button";
main.mostCurrent._button4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim Button5 As Button";
main.mostCurrent._button5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim Button6 As Button";
main.mostCurrent._button6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim Button7 As Button";
main.mostCurrent._button7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim Button8 As Button";
main.mostCurrent._button8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim Button9 As Button";
main.mostCurrent._button9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim a6, a7, a8, a9 As Animation";
main.mostCurrent._a6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");
main.mostCurrent._a7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");
main.mostCurrent._a8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");
main.mostCurrent._a9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("anywheresoftware.b4a.samples.animation.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}