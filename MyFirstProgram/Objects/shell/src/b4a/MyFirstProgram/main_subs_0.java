package b4a.MyFirstProgram;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,34);
if (RapidSub.canDelegate("activity_create")) { return b4a.MyFirstProgram.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 37;BA.debugLine="Activity.LoadLayout(\"Mail\")";
Debug.ShouldStop(16);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Mail")),main.mostCurrent.activityBA);
 BA.debugLineNum = 38;BA.debugLine="NewProblem";
Debug.ShouldStop(32);
_newproblem();
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,53);
if (RapidSub.canDelegate("activity_pause")) { return b4a.MyFirstProgram.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,49);
if (RapidSub.canDelegate("activity_resume")) { return b4a.MyFirstProgram.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 49;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(65536);
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnaction_click() throws Exception{
try {
		Debug.PushSubsStack("BtnAction_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,58);
if (RapidSub.canDelegate("btnaction_click")) { return b4a.MyFirstProgram.main.remoteMe.runUserSub(false, "main","btnaction_click");}
 BA.debugLineNum = 58;BA.debugLine="Sub BtnAction_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="If BtnAction.Text = \"O K\" Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",main.mostCurrent._btnaction.runMethod(true,"getText"),BA.ObjectToString("O K"))) { 
 BA.debugLineNum = 60;BA.debugLine="If EdtResult.Text = \"\" Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main.mostCurrent._edtresult.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 61;BA.debugLine="Msgbox(\"No result entered\",\"E R R O R\")";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("No result entered")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("E R R O R"))),main.mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 63;BA.debugLine="CheckResult";
Debug.ShouldStop(1073741824);
_checkresult();
 };
 }else {
 BA.debugLineNum = 66;BA.debugLine="NewProblem";
Debug.ShouldStop(2);
_newproblem();
 BA.debugLineNum = 67;BA.debugLine="BtnAction.Text = \"O K\"";
Debug.ShouldStop(4);
main.mostCurrent._btnaction.runMethod(true,"setText",BA.ObjectToCharSequence("O K"));
 };
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _checkresult() throws Exception{
try {
		Debug.PushSubsStack("CheckResult (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,71);
if (RapidSub.canDelegate("checkresult")) { return b4a.MyFirstProgram.main.remoteMe.runUserSub(false, "main","checkresult");}
 BA.debugLineNum = 71;BA.debugLine="Sub CheckResult";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="If EdtResult.Text = Number1+Number2 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",main.mostCurrent._edtresult.runMethod(true,"getText"),BA.NumberToString(RemoteObject.solve(new RemoteObject[] {main._number1,main._number2}, "+",1, 1)))) { 
 BA.debugLineNum = 73;BA.debugLine="LblComment.Text = \"G o o d....Result \"& CRLF & \"";
Debug.ShouldStop(256);
main.mostCurrent._lblcomment.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("G o o d....Result "),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Click on NEW"))));
 BA.debugLineNum = 74;BA.debugLine="BtnAction.Text = \"N E W\"";
Debug.ShouldStop(512);
main.mostCurrent._btnaction.runMethod(true,"setText",BA.ObjectToCharSequence("N E W"));
 }else {
 BA.debugLineNum = 76;BA.debugLine="LblComment.Text = \"W R O N G result\" & CRLF & \"E";
Debug.ShouldStop(2048);
main.mostCurrent._lblcomment.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("W R O N G result"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Enter a new result"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("and click OK"))));
 };
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private BtnAction As Button";
main.mostCurrent._btnaction = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private EdtResult As EditText";
main.mostCurrent._edtresult = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private LblComment As Label";
main.mostCurrent._lblcomment = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private LblMathSign As Label";
main.mostCurrent._lblmathsign = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private LblNumber1 As Label";
main.mostCurrent._lblnumber1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private LblNumber2 As Label";
main.mostCurrent._lblnumber2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Public Number1,Number2 As Int";
main._number1 = RemoteObject.createImmutable(0);
main._number2 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _newproblem() throws Exception{
try {
		Debug.PushSubsStack("NewProblem (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,41);
if (RapidSub.canDelegate("newproblem")) { return b4a.MyFirstProgram.main.remoteMe.runUserSub(false, "main","newproblem");}
 BA.debugLineNum = 41;BA.debugLine="Sub NewProblem";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="Number1 = Rnd(1,10)";
Debug.ShouldStop(512);
main._number1 = main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 43;BA.debugLine="Number2 = Rnd(1,10)";
Debug.ShouldStop(1024);
main._number2 = main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 44;BA.debugLine="LblNumber1.Text  = Number1";
Debug.ShouldStop(2048);
main.mostCurrent._lblnumber1.runMethod(true,"setText",BA.ObjectToCharSequence(main._number1));
 BA.debugLineNum = 45;BA.debugLine="LblNumber2.Text = Number2";
Debug.ShouldStop(4096);
main.mostCurrent._lblnumber2.runMethod(true,"setText",BA.ObjectToCharSequence(main._number2));
 BA.debugLineNum = 46;BA.debugLine="LblComment.Text = \"Enter the Result \" & CRLF & \"";
Debug.ShouldStop(8192);
main.mostCurrent._lblcomment.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Enter the Result "),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable(" and click OK"))));
 BA.debugLineNum = 47;BA.debugLine="EdtResult.Text = \"\"";
Debug.ShouldStop(16384);
main.mostCurrent._edtresult.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.MyFirstProgram.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}