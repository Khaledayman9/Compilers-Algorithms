package csen1002.tests.task5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task5.CfgLeftRecElim;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task5TestsBatch3 {

	@Test
	public void testCfgLeftRecursionElimination1() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;P;J;N;F#b;c;o;q#S/oNJcJ,Fb,bSN,Jo,qSS;P/b,cNNP;J/bJN,Fo,JoPc,JSoSF,FSFN;N/qSFNb,Jb,qJFcF,SF;F/q,FbJ,FPqNq,PPP,SPJq");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;P;J;N;F;J';F'#b;c;o;q#S/oNJcJ,Fb,bSN,Jo,qSS;P/b,cNNP;J/bJNJ',FoJ',FSFNJ';N/qSFNb,bJNJ'b,FoJ'b,FSFNJ'b,qJFcF,oNJcJF,FbF,bSNF,bJNJ'oF,FoJ'oF,FSFNJ'oF,qSSF;F/qF',bPPF',cNNPPPF',oNJcJPJqF',bSNPJqF',bJNJ'oPJqF',qSSPJqF';J'/oPcJ',SoSFJ',e;F'/bJF',PqNqF',bPJqF',oJ'oPJqF',SFNJ'oPJqF',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination2() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;W;H;C;D#d;j;p#S/SSj,WSSj,SWdS,d,jS,dDj;W/dDW,CdC,WpDD,j,Wd;H/CW,HH,pCHjS,dC;C/pS,dC,WWHS,SjDd,jH;D/jWDC,pHSS,CHCC,dSpSW,SC,pSjS");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;W;H;C;D;S';W';H';C'#d;j;p#S/WSSjS',dS',jSS',dDjS';W/dDWW',CdCW',jW';H/CWH',pCHjSH',dCH';C/pSC',dCC',dDWW'WHSC',jW'WHSC',dDWW'SSjS'jDdC',jW'SSjS'jDdC',dS'jDdC',jSS'jDdC',dDjS'jDdC',jHC';D/jWDC,pHSS,pSC'HCC,dCC'HCC,dDWW'WHSC'HCC,jW'WHSC'HCC,dDWW'SSjS'jDdC'HCC,jW'SSjS'jDdC'HCC,dS'jDdC'HCC,jSS'jDdC'HCC,dDjS'jDdC'HCC,jHC'HCC,dSpSW,dDWW'SSjS'C,pSC'dCW'SSjS'C,dCC'dCW'SSjS'C,dDWW'WHSC'dCW'SSjS'C,jW'WHSC'dCW'SSjS'C,dDWW'SSjS'jDdC'dCW'SSjS'C,jW'SSjS'jDdC'dCW'SSjS'C,dS'jDdC'dCW'SSjS'C,jSS'jDdC'dCW'SSjS'C,dDjS'jDdC'dCW'SSjS'C,jHC'dCW'SSjS'C,jW'SSjS'C,dS'C,jSS'C,dDjS'C,pSjS;S'/SjS',WdSS',e;W'/pDDW',dW',e;H'/HH',e;C'/dCW'WHSC',dCW'SSjS'jDdC',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination3() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;U;M;J;W;I#h;i;o#S/iWiU,Wi,iJM;U/iShWM,oJM;M/SW,hUJ,JMhJi,SJ,UJSSS,IJ;J/oWoSi,JIWoW,JJiU;W/oJSi,JUiM;I/Uo,IM,ShU,IWI,h,SoJJ");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;U;M;J;W;I;J';I'#h;i;o#S/iWiU,Wi,iJM;U/iShWM,oJM;M/iWiUW,WiW,iJMW,hUJ,JMhJi,iWiUJ,WiJ,iJMJ,iShWMJSSS,oJMJSSS,IJ;J/oWoSiJ';W/oJSi,oWoSiJ'UiM;I/iShWMoI',oJMoI',iWiUhUI',oJSiihUI',oWoSiJ'UiMihUI',iJMhUI',hI',iWiUoJJI',oJSiioJJI',oWoSiJ'UiMioJJI',iJMoJJI';J'/IWoWJ',JiUJ',e;I'/MI',WII',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination4() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;A;U;K;V;E#d;m;n;r;w#S/dV,SVwE,UdUVE,SVVUS;A/nKUVK,nUEEK,wAd,mUA,w;U/dU,UwEV,VwSU,UU,ErV,nSU;K/rV,VnKSE,VdA,AUn;V/dKU,VU,dSnU,AVwA,SK;E/dSn,EV,SrE,Aw,nV,UK");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;A;U;K;V;E;S';U';V';E'#d;m;n;r;w#S/dVS',UdUVES';A/nKUVK,nUEEK,wAd,mUA,w;U/dUU',VwSUU',ErVU',nSUU';K/rV,VnKSE,VdA,nKUVKUn,nUEEKUn,wAdUn,mUAUn,wUn;V/dKUV',dSnUV',nKUVKVwAV',nUEEKVwAV',wAdVwAV',mUAVwAV',wVwAV',dVS'KV',dUU'dUVES'KV',ErVU'dUVES'KV',nSUU'dUVES'KV';E/dSnE',dVS'rEE',dUU'dUVES'rEE',dKUV'wSUU'dUVES'rEE',dSnUV'wSUU'dUVES'rEE',nKUVKVwAV'wSUU'dUVES'rEE',nUEEKVwAV'wSUU'dUVES'rEE',wAdVwAV'wSUU'dUVES'rEE',mUAVwAV'wSUU'dUVES'rEE',wVwAV'wSUU'dUVES'rEE',dVS'KV'wSUU'dUVES'rEE',dUU'dUVES'KV'wSUU'dUVES'rEE',nSUU'dUVES'KV'wSUU'dUVES'rEE',nSUU'dUVES'rEE',nKUVKwE',nUEEKwE',wAdwE',mUAwE',wwE',nVE',dUU'KE',dKUV'wSUU'KE',dSnUV'wSUU'KE',nKUVKVwAV'wSUU'KE',nUEEKVwAV'wSUU'KE',wAdVwAV'wSUU'KE',mUAVwAV'wSUU'KE',wVwAV'wSUU'KE',dVS'KV'wSUU'KE',dUU'dUVES'KV'wSUU'KE',nSUU'dUVES'KV'wSUU'KE',nSUU'KE';S'/VwES',VVUSS',e;U'/wEVU',UU',e;V'/UV',wSUU'dUVES'KV',e;E'/VE',rVU'dUVES'KV'wSUU'dUVES'rEE',rVU'dUVES'rEE',rVU'dUVES'KV'wSUU'KE',rVU'KE',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination5() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;W;Z;C;H#a;b;f;w#S/fCCS,wZaH,wCH,wSw;W/Wb,Sw,SfWC,fSfHw,WWCZ;Z/ZSaS,WSCa,ZfZ;C/w,fHaC,ZCS,fWSa,HZWZS;H/Wb,ZSaS,WHH,ZHwHS,aZW");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;W;Z;C;H;W';Z'#a;b;f;w#S/fCCS,wZaH,wCH,wSw;W/fCCSwW',wZaHwW',wCHwW',wSwwW',fCCSfWCW',wZaHfWCW',wCHfWCW',wSwfWCW',fSfHwW';Z/fCCSwW'SCaZ',wZaHwW'SCaZ',wCHwW'SCaZ',wSwwW'SCaZ',fCCSfWCW'SCaZ',wZaHfWCW'SCaZ',wCHfWCW'SCaZ',wSwfWCW'SCaZ',fSfHwW'SCaZ';C/w,fHaC,fCCSwW'SCaZ'CS,wZaHwW'SCaZ'CS,wCHwW'SCaZ'CS,wSwwW'SCaZ'CS,fCCSfWCW'SCaZ'CS,wZaHfWCW'SCaZ'CS,wCHfWCW'SCaZ'CS,wSwfWCW'SCaZ'CS,fSfHwW'SCaZ'CS,fWSa,HZWZS;H/fCCSwW'b,wZaHwW'b,wCHwW'b,wSwwW'b,fCCSfWCW'b,wZaHfWCW'b,wCHfWCW'b,wSwfWCW'b,fSfHwW'b,fCCSwW'SCaZ'SaS,wZaHwW'SCaZ'SaS,wCHwW'SCaZ'SaS,wSwwW'SCaZ'SaS,fCCSfWCW'SCaZ'SaS,wZaHfWCW'SCaZ'SaS,wCHfWCW'SCaZ'SaS,wSwfWCW'SCaZ'SaS,fSfHwW'SCaZ'SaS,fCCSwW'HH,wZaHwW'HH,wCHwW'HH,wSwwW'HH,fCCSfWCW'HH,wZaHfWCW'HH,wCHfWCW'HH,wSwfWCW'HH,fSfHwW'HH,fCCSwW'SCaZ'HwHS,wZaHwW'SCaZ'HwHS,wCHwW'SCaZ'HwHS,wSwwW'SCaZ'HwHS,fCCSfWCW'SCaZ'HwHS,wZaHfWCW'SCaZ'HwHS,wCHfWCW'SCaZ'HwHS,wSwfWCW'SCaZ'HwHS,fSfHwW'SCaZ'HwHS,aZW;W'/bW',WCZW',e;Z'/SaSZ',fZZ',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination6() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;Y;K;V;E;P#i;r;x;z#S/VPVx,YSVPx;Y/rYrPV,EzS;K/KPPr,zPrKE,rSY,KS;V/zKYPi,xV,Sx;E/KPPz,xVSS,KKPE;P/PYE,z,PzVE,VYYSV,EKrPr");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;Y;K;V;E;P;K';V';P'#i;r;x;z#S/VPVx,YSVPx;Y/rYrPV,EzS;K/zPrKEK',rSYK';V/zKYPiV',xVV',rYrPVSVPxxV',EzSSVPxxV';E/zPrKEK'PPz,rSYK'PPz,xVSS,zPrKEK'KPE,rSYK'KPE;P/zP',zKYPiV'YYSVP',xVV'YYSVP',rYrPVSVPxxV'YYSVP',zPrKEK'PPzzSSVPxxV'YYSVP',rSYK'PPzzSSVPxxV'YYSVP',xVSSzSSVPxxV'YYSVP',zPrKEK'KPEzSSVPxxV'YYSVP',rSYK'KPEzSSVPxxV'YYSVP',zPrKEK'PPzKrPrP',rSYK'PPzKrPrP',xVSSKrPrP',zPrKEK'KPEKrPrP',rSYK'KPEKrPrP';K'/PPrK',SK',e;V'/PVxxV',e;P'/YEP',zVEP',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination7() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;J;Y;B;I#d;g;u#S/d,uB,BdY,dSdI;J/Ju,IJ,JdB,gJJY;Y/SJJuS,JJJuI,JId;B/u,dJY,uIu;I/ISg,gYYS,YgIuS,YSd,JSuI,ISgY");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;J;Y;B;I;J';I'#d;g;u#S/d,uB,BdY,dSdI;J/IJJ',gJJYJ';Y/dJJuS,uBJJuS,BdYJJuS,dSdIJJuS,IJJ'JJuI,gJJYJ'JJuI,IJJ'Id,gJJYJ'Id;B/u,dJY,uIu;I/gYYSI',dJJuSgIuSI',uBJJuSgIuSI',udYJJuSgIuSI',dJYdYJJuSgIuSI',uIudYJJuSgIuSI',dSdIJJuSgIuSI',gJJYJ'JJuIgIuSI',gJJYJ'IdgIuSI',dJJuSSdI',uBJJuSSdI',udYJJuSSdI',dJYdYJJuSSdI',uIudYJJuSSdI',dSdIJJuSSdI',gJJYJ'JJuISdI',gJJYJ'IdSdI',gJJYJ'SuII';J'/uJ',dBJ',e;I'/SgI',JJ'JJuIgIuSI',JJ'IdgIuSI',JJ'JJuISdI',JJ'IdSdI',JJ'SuII',SgYI',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination8() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;F;J;G;M;E#d;l;o;t;y#S/EFGt,yS,tG;F/SySEy,SEoE;J/JES,JS,yMtSF,Md;G/tJMlG,FFyG,MJyMt,lSEJ;M/MFlJ,MFl,Ft,oMt,Fy;E/MSJFd,Et,oJFt");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;F;J;G;M;E;J';M';E'#d;l;o;t;y#S/EFGt,yS,tG;F/EFGtySEy,ySySEy,tGySEy,EFGtEoE,ySEoE,tGEoE;J/yMtSFJ',MdJ';G/tJMlG,EFGtySEyFyG,ySySEyFyG,tGySEyFyG,EFGtEoEFyG,ySEoEFyG,tGEoEFyG,MJyMt,lSEJ;M/EFGtySEytM',ySySEytM',tGySEytM',EFGtEoEtM',ySEoEtM',tGEoEtM',oMtM',EFGtySEyyM',ySySEyyM',tGySEyyM',EFGtEoEyM',ySEoEyM',tGEoEyM';E/ySySEytM'SJFdE',tGySEytM'SJFdE',ySEoEtM'SJFdE',tGEoEtM'SJFdE',oMtM'SJFdE',ySySEyyM'SJFdE',tGySEyyM'SJFdE',ySEoEyM'SJFdE',tGEoEyM'SJFdE',oJFtE';J'/ESJ',SJ',e;M'/FlJM',FlM',e;E'/FGtySEytM'SJFdE',FGtEoEtM'SJFdE',FGtySEyyM'SJFdE',FGtEoEyM'SJFdE',tE',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination9() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;X;O;A;K;W#c;j;l#S/jAWcS,Aj,l,WOAO;X/XW,KSSK;O/SWj,XXWSA,Wj,OX,OWXOK;A/lK,SKcX;K/KOcW,jOA,XlX,lSW,Sl;W/AcWj,AAjK,WXj,KcX,WlAKO,AjWcA");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;X;O;A;K;W;X';O';A';K';W'#c;j;l#S/jAWcS,Aj,l,WOAO;X/KSSKX';O/jAWcSWjO',AjWjO',lWjO',WOAOWjO',KSSKX'XWSAO',WjO';A/lKA',jAWcSKcXA',lKcXA',WOAOKcXA';K/jOAK',lSWK',jAWcSlK',lKA'jlK',jAWcSKcXA'jlK',lKcXA'jlK',WOAOKcXA'jlK',llK',WOAOlK';W/lKA'cWjW',jAWcSKcXA'cWjW',lKcXA'cWjW',lKA'AjKW',jAWcSKcXA'AjKW',lKcXA'AjKW',jOAK'cXW',lSWK'cXW',jAWcSlK'cXW',lKA'jlK'cXW',jAWcSKcXA'jlK'cXW',lKcXA'jlK'cXW',llK'cXW',lKA'jWcAW',jAWcSKcXA'jWcAW',lKcXA'jWcAW';X'/WX',e;O'/XO',WXOKO',e;A'/jKcXA',e;K'/OcWK',SSKX'lXK',e;W'/OAOKcXA'cWjW',OAOKcXA'AjKW',XjW',OAOKcXA'jlK'cXW',OAOlK'cXW',lAKOW',OAOKcXA'jWcAW',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination10() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;V;B;W;L#c;p;q;t#S/qLc,WqW,cBqLp,tLqBL,Vc;V/SBW,LpSc,VScVB,cVpVq,VVcSt,c;B/cBSL,BL,BVB;W/SSSpL,qW,qL,tVWc,VLc;L/VBqS,pL,pWVpS,BBVLq,qVVS,qL");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;V;B;W;L;V';B';W';L'#c;p;q;t#S/qLc,WqW,cBqLp,tLqBL,Vc;V/qLcBWV',WqWBWV',cBqLpBWV',tLqBLBWV',LpScV',cVpVqV',cV';B/cBSLB';W/qLcSSpLW',cBqLpSSpLW',tLqBLSSpLW',qLcBWV'cSSpLW',cBqLpBWV'cSSpLW',tLqBLBWV'cSSpLW',LpScV'cSSpLW',cVpVqV'cSSpLW',cV'cSSpLW',qWW',qLW',tVWcW',qLcBWV'LcW',cBqLpBWV'LcW',tLqBLBWV'LcW',LpScV'LcW',cVpVqV'LcW',cV'LcW';L/qLcBWV'BqSL',qLcSSpLW'qWBWV'BqSL',cBqLpSSpLW'qWBWV'BqSL',tLqBLSSpLW'qWBWV'BqSL',qLcBWV'cSSpLW'qWBWV'BqSL',cBqLpBWV'cSSpLW'qWBWV'BqSL',tLqBLBWV'cSSpLW'qWBWV'BqSL',cVpVqV'cSSpLW'qWBWV'BqSL',cV'cSSpLW'qWBWV'BqSL',qWW'qWBWV'BqSL',qLW'qWBWV'BqSL',tVWcW'qWBWV'BqSL',qLcBWV'LcW'qWBWV'BqSL',cBqLpBWV'LcW'qWBWV'BqSL',tLqBLBWV'LcW'qWBWV'BqSL',cVpVqV'LcW'qWBWV'BqSL',cV'LcW'qWBWV'BqSL',cBqLpBWV'BqSL',tLqBLBWV'BqSL',cVpVqV'BqSL',cV'BqSL',pLL',pWVpSL',cBSLB'BVLqL',qVVSL',qLL';V'/cBWV',ScVBV',VcStV',e;B'/LB',VBB',e;W'/qWSSpLW',qWBWV'cSSpLW',qWBWV'LcW',e;L'/pScV'cSSpLW'qWBWV'BqSL',pScV'LcW'qWBWV'BqSL',pScV'BqSL',e", cfgLeftRecElim.toString());
	}

}