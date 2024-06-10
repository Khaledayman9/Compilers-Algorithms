package csen1002.tests.task5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task5.CfgLeftRecElim;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task5TestsBatch2 {

	@Test
	public void testCfgLeftRecursionElimination1() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;K;T;H;V#d;k;o#S/VHdS,oV,oSK;K/dVd,HSH,oV;T/KoVV,ToHHT,THkSd;H/TVS,HTHS,SSkHd,HT,Ho,oKo;V/o,HoV,KTd");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;K;T;H;V;T';H';V'#d;k;o#S/VHdS,oV,oSK;K/dVd,HSH,oV;T/dVdoVVT',HSHoVVT',oVoVVT';H/dVdoVVT'VSH',oVoVVT'VSH',VHdSSkHdH',oVSkHdH',oSKSkHdH',oKoH';V/oV',dVdoVVT'VSH'oVV',oVoVVT'VSH'oVV',oVSkHdH'oVV',oSKSkHdH'oVV',oKoH'oVV',dVdTdV',dVdoVVT'VSH'SHTdV',oVoVVT'VSH'SHTdV',oVSkHdH'SHTdV',oSKSkHdH'SHTdV',oKoH'SHTdV',oVTdV';T'/oHHTT',HkSdT',e;H'/SHoVVT'VSH',THSH',TH',oH',e;V'/HdSSkHdH'oVV',HdSSkHdH'SHTdV',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination2() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;X;R;B;F;W#c;j;l;n#S/j,nXR;X/WnW,cWFj,WcW,c,nXX;R/RSB,jWFRc,cWR,RRc,jWnW,RBjR;B/cWBRc,cSl;F/FXFc,FnFn,nRnR,cRlRX,XSXn,XXl;W/BcR,FlSS,cXRn,RX");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;X;R;B;F;W;R';F';W'#c;j;l;n#S/j,nXR;X/WnW,cWFj,WcW,c,nXX;R/jWFRcR',cWRR',jWnWR';B/cWBRc,cSl;F/nRnRF',cRlRXF',WnWSXnF',cWFjSXnF',WcWSXnF',cSXnF',nXXSXnF',WnWXlF',cWFjXlF',WcWXlF',cXlF',nXXXlF';W/cWBRccRW',cSlcRW',nRnRF'lSSW',cRlRXF'lSSW',cWFjSXnF'lSSW',cSXnF'lSSW',nXXSXnF'lSSW',cWFjXlF'lSSW',cXlF'lSSW',nXXXlF'lSSW',cXRnW',jWFRcR'XW',cWRR'XW',jWnWR'XW';R'/SBR',RcR',BjRR',e;F'/XFcF',nFnF',e;W'/nWSXnF'lSSW',cWSXnF'lSSW',nWXlF'lSSW',cWXlF'lSSW',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination3() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;W;C;U;B#s;w;z#S/SUwBS,CBCw,wBUWW;W/sCB,BUSC,SSs;C/CUBs,zBBz,CUSB;U/Cz,SsB,s,sUS;B/CCsUB,BWSzW,BzSz,Ww");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;W;C;U;B;S';C';B'#s;w;z#S/CBCwS',wBUWWS';W/sCB,BUSC,CBCwS'Ss,wBUWWS'Ss;C/zBBzC';U/zBBzC'z,zBBzC'BCwS'sB,wBUWWS'sB,s,sUS;B/zBBzC'CsUBB',sCBwB',zBBzC'BCwS'SswB',wBUWWS'SswB';S'/UwBSS',e;C'/UBsC',USBC',e;B'/WSzWB',zSzB',USCwB',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination4() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;H;E;V;I;J#b;m;x#S/SxI,mJHI,mIm,SII;H/mH,SbHH,mJVx,SSbV,JxI;E/JEEV,mIEH,xSS,b;V/x,bIV,Vx,IHVm,VSImH;I/VH,IHmV,b,ExIb;J/xSbE,xS");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;H;E;V;I;J;S';V';I'#b;m;x#S/mJHIS',mImS';H/mH,mJHIS'bHH,mImS'bHH,mJVx,mJHIS'SbV,mImS'SbV,JxI;E/JEEV,mIEH,xSS,b;V/xV',bIVV',IHVmV';I/xV'HI',bIVV'HI',bI',JEEVxIbI',mIEHxIbI',xSSxIbI',bxIbI';J/xSbE,xS;S'/xIS',IIS',e;V'/xV',SImHV',e;I'/HVmV'HI',HmVI',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination5() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;T;Y;F;H;K#d;l;o#S/SFFYT,d,Kd,SoSo;T/FlK,lSKd,dSl;Y/YHSlF,oYSS,YTS,FlY,Fd,oHl;F/dT,HlTF,KYSoF,oYTS,oH,YT;H/KT,SlY,Fo;K/KKT,SoSKK,o,YK,l");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;T;Y;F;H;K;S';Y';F';H';K'#d;l;o#S/dS',KdS';T/FlK,lSKd,dSl;Y/oYSSY',FlYY',FdY',oHlY';F/dTF',HlTFF',KYSoFF',oYTSF',oHF',oYSSY'TF',oHlY'TF';H/KTH',dS'lYH',KdS'lYH',dTF'oH',KYSoFF'oH',oYTSF'oH',oHF'oH',oYSSY'TF'oH',oHlY'TF'oH';K/dS'oSKKK',oK',oYSSY'KK',dTF'lYY'KK',dS'lYH'lTFF'lYY'KK',dTF'oH'lTFF'lYY'KK',oYTSF'oH'lTFF'lYY'KK',oHF'oH'lTFF'lYY'KK',oYSSY'TF'oH'lTFF'lYY'KK',oHlY'TF'oH'lTFF'lYY'KK',oYTSF'lYY'KK',oHF'lYY'KK',oYSSY'TF'lYY'KK',oHlY'TF'lYY'KK',dTF'dY'KK',dS'lYH'lTFF'dY'KK',dTF'oH'lTFF'dY'KK',oYTSF'oH'lTFF'dY'KK',oHF'oH'lTFF'dY'KK',oYSSY'TF'oH'lTFF'dY'KK',oHlY'TF'oH'lTFF'dY'KK',oYTSF'dY'KK',oHF'dY'KK',oYSSY'TF'dY'KK',oHlY'TF'dY'KK',oHlY'KK',lK';S'/FFYTS',oSoS',e;Y'/HSlFY',TSY',e;F'/lYY'TF',dY'TF',e;H'/lTFF'oH',e;K'/KTK',dS'oSKKK',TH'lTFF'lYY'KK',dS'lYH'lTFF'lYY'KK',YSoFF'oH'lTFF'lYY'KK',YSoFF'lYY'KK',TH'lTFF'dY'KK',dS'lYH'lTFF'dY'KK',YSoFF'oH'lTFF'dY'KK',YSoFF'dY'KK',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination6() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;M;U;N;E;A#g;r;t;y#S/UN,y;M/Uy,tMgME,UU,MUS,ANStE;U/ME,tEyS,SE;N/SUN,gS,NgN,NtAU,SMANE;E/AMr,SgUS,MyMAU;A/AUyAN,rMSg,gAE,tE,AtEM,ANt");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;M;U;N;E;A;M';U';N';A'#g;r;t;y#S/UN,y;M/UyM',tMgMEM',UUM',ANStEM';U/tMgMEM'EU',ANStEM'EU',tEySU',yEU';N/tMgMEM'EU'NUNN',ANStEM'EU'NUNN',tEySU'NUNN',yEU'NUNN',yUNN',gSN',tMgMEM'EU'NMANEN',ANStEM'EU'NMANEN',tEySU'NMANEN',yEU'NMANEN',yMANEN';E/AMr,tMgMEM'EU'NgUS,ANStEM'EU'NgUS,tEySU'NgUS,yEU'NgUS,ygUS,tMgMEM'EU'yM'yMAU,ANStEM'EU'yM'yMAU,tEySU'yM'yMAU,yEU'yM'yMAU,tMgMEM'yMAU,tMgMEM'EU'UM'yMAU,ANStEM'EU'UM'yMAU,tEySU'UM'yMAU,yEU'UM'yMAU,ANStEM'yMAU;A/rMSgA',gAEA',tEA';M'/USM',e;U'/yM'EU',UM'EU',NEU',e;N'/gNN',tAUN',e;A'/UyANA',tEMA',NtA',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination7() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;O;B;W;D;V#k;s;y#S/WV,DkDkV,WySV,ByBOy;O/OSBVO,ODkSW,kO,Vk;B/WB,yWsB,SBDB,VB,OsV,sV;W/y,WWB;D/Oy,Dy,ySOy,DDS,kVS;V/SBkDk,kV,Dk,yOkO");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;O;B;W;D;V;O';B';W';D';V'#k;s;y#S/WV,DkDkV,WySV,ByBOy;O/kOO',VkO';B/WBB',yWsBB',WVBDBB',DkDkVBDBB',WySVBDBB',VBB',kOO'sVB',VkO'sVB',sVB';W/yW';D/kOO'yD',VkO'yD',ySOyD',kVSD';V/yW'VBkDkV',kOO'yD'kDkVBkDkV',ySOyD'kDkVBkDkV',kVSD'kDkVBkDkV',yW'ySVBkDkV',yW'BB'yBOyBkDkV',yWsBB'yBOyBkDkV',yW'VBDBB'yBOyBkDkV',kOO'yD'kDkVBDBB'yBOyBkDkV',ySOyD'kDkVBDBB'yBOyBkDkV',kVSD'kDkVBDBB'yBOyBkDkV',yW'ySVBDBB'yBOyBkDkV',kOO'sVB'yBOyBkDkV',sVB'yBOyBkDkV',kVV',kOO'yD'kV',ySOyD'kV',kVSD'kV',yOkOV';O'/SBVOO',DkSWO',e;B'/yBOyBDBB',e;W'/WBW',e;D'/yD',DSD',e;V'/kO'yD'kDkVBkDkV',kO'yD'kDkVBDBB'yBOyBkDkV',BB'yBOyBkDkV',kO'sVB'yBOyBkDkV',kO'yD'kV',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination8() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;J;R;V;E#o;t;u;w;y#S/tRRo,Eu,VJSoV;J/tSVt,JuVJV,EyE,JS,wVw;R/tRSRE,JoES,SJt,VJwRu;V/RR,SJ;E/RtS,EJSu,VtV,u,EJyEu");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;J;R;V;E;J';V';E'#o;t;u;w;y#S/tRRo,Eu,VJSoV;J/tSVtJ',EyEJ',wVwJ';R/tRSRE,tSVtJ'oES,EyEJ'oES,wVwJ'oES,tRRoJt,EuJt,VJSoVJt,VJwRu;V/tRSRERV',tSVtJ'oESRV',EyEJ'oESRV',wVwJ'oESRV',tRRoJtRV',EuJtRV',tRRoJV',EuJV';E/tRSREtSE',tSVtJ'oEStSE',wVwJ'oEStSE',tRRoJttSE',tRSRERV'JSoVJttSE',tSVtJ'oESRV'JSoVJttSE',wVwJ'oESRV'JSoVJttSE',tRRoJtRV'JSoVJttSE',tRRoJV'JSoVJttSE',tRSRERV'JwRutSE',tSVtJ'oESRV'JwRutSE',wVwJ'oESRV'JwRutSE',tRRoJtRV'JwRutSE',tRRoJV'JwRutSE',tRSRERV'tVE',tSVtJ'oESRV'tVE',wVwJ'oESRV'tVE',tRRoJtRV'tVE',tRRoJV'tVE',uE';J'/uVJVJ',SJ',e;V'/JSoVJtRV',JwRuRV',JSoVJV',e;E'/yEJ'oEStSE',uJttSE',yEJ'oESRV'JSoVJttSE',uJtRV'JSoVJttSE',uJV'JSoVJttSE',yEJ'oESRV'JwRutSE',uJtRV'JwRutSE',uJV'JwRutSE',JSuE',yEJ'oESRV'tVE',uJtRV'tVE',uJV'tVE',JyEuE',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination9() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;K;W;X;F#b;c;g#S/gWW,SXbK,WSFc,SScKW,gXXX;K/c,KSSS,KbW,b,cF,bSgFX;W/SS,bSXFS,cF;X/SbFK,gW,KX,WFWg,FFbSS;F/XFg,SbWSg");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;K;W;X;F;S';K';W';F'#b;c;g#S/gWWS',WSFcS',gXXXS';K/cK',bK',cFK',bSgFXK';W/gWWS'SW',gXXXS'SW',bSXFSW',cFW';X/gWWS'bFK,gWWS'SW'SFcS'bFK,gXXXS'SW'SFcS'bFK,bSXFSW'SFcS'bFK,cFW'SFcS'bFK,gXXXS'bFK,gW,cK'X,bK'X,cFK'X,bSgFXK'X,gWWS'SW'FWg,gXXXS'SW'FWg,bSXFSW'FWg,cFW'FWg,FFbSS;F/gWWS'bFKFgF',gWWS'SW'SFcS'bFKFgF',gXXXS'SW'SFcS'bFKFgF',bSXFSW'SFcS'bFKFgF',cFW'SFcS'bFKFgF',gXXXS'bFKFgF',gWFgF',cK'XFgF',bK'XFgF',cFK'XFgF',bSgFXK'XFgF',gWWS'SW'FWgFgF',gXXXS'SW'FWgFgF',bSXFSW'FWgFgF',cFW'FWgFgF',gWWS'bWSgF',gWWS'SW'SFcS'bWSgF',gXXXS'SW'SFcS'bWSgF',bSXFSW'SFcS'bWSgF',cFW'SFcS'bWSgF',gXXXS'bWSgF';S'/XbKS',ScKWS',e;K'/SSSK',bWK',e;W'/SFcS'SW',e;F'/FbSSFgF',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination10() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;C;J;I;O;Z#c;n;t#S/CIc,InC,nStS;C/CcJJc,tZO;J/tISO,cOO;I/IOIC,CtCI,JSCn,tJSO,ZO,IJCtJ;O/n,OnZIZ,CCnC,tCt,On;Z/OJ,On,JcZSt,SOc,IO,COc");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;C;J;I;O;Z;C';I';O';Z'#c;n;t#S/CIc,InC,nStS;C/tZOC';J/tISO,cOO;I/tZOC'tCII',tISOSCnI',cOOSCnI',tJSOI',ZOI';O/nO',tZOC'CnCO',tCtO';Z/nO'JZ',tZOC'CnCO'JZ',tCtO'JZ',nO'nZ',tZOC'CnCO'nZ',tCtO'nZ',tISOcZStZ',cOOcZStZ',tZOC'IcOcZ',tZOC'tCII'nCOcZ',tISOSCnI'nCOcZ',cOOSCnI'nCOcZ',tJSOI'nCOcZ',nStSOcZ',tZOC'tCII'OZ',tISOSCnI'OZ',cOOSCnI'OZ',tJSOI'OZ',tZOC'OcZ';C'/cJJcC',e;I'/OICI',JCtJI',e;O'/nZIZO',nO',e;Z'/OI'nCOcZ',OI'OZ',e", cfgLeftRecElim.toString());
	}

}