package csen1002.tests.task4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task4.CfgEpsUnitElim;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task4TestsBatch2 {

	@Test
	public void testCfgEpsilonRuleElimination1() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;E;X;R;K#d;h;n;w#S/Kh,KhR,RhSXX,nSKSn;E/RdR,SnXE,X,e,n;X/E,R,XRw,e;R/Sd,X,XSR,e;K/KX,XSE,dX,wRdXh");
		cfgEpsUnitElim.eliminateEpsilonRules();
		assertEquals("S;E;X;R;K#d;h;n;w#S/Kh,KhR,RhS,RhSX,RhSXX,hS,hSX,hSXX,nSKSn;E/Rd,RdR,Sn,SnE,SnX,SnXE,X,d,dR,n;X/E,R,Rw,XRw,Xw,w;R/S,SR,Sd,X,XS,XSR;K/K,KX,S,SE,XS,XSE,d,dX,wRdXh,wRdh,wdXh,wdh", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonRuleElimination2() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;I;K;X;A;T;C#c;d;l;n;q#S/ISICS,SKXXX,STcT,cAc;I/CXq,T,TcXCI,X,n;K/TScId,q;X/SSTlS,SnK,XA,e;A/I,In,Tl;T/I,TqT,dK,e;C/TKl,n");
		cfgEpsUnitElim.eliminateEpsilonRules();
		assertEquals("S;I;K;X;A;T;C#c;d;l;n;q#S/ISCS,ISICS,SCS,SICS,SK,SKX,SKXX,SKXXX,STc,STcT,Sc,ScT,cAc,cc;I/CXq,Cq,T,TcC,TcCI,TcXC,TcXCI,X,cC,cCI,cXC,cXCI,n;K/ScId,Scd,TScId,TScd,q;X/A,SSTlS,SSlS,SnK,X,XA;A/I,In,Tl,l,n;T/I,Tq,TqT,dK,q,qT;C/Kl,TKl,n", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonRuleElimination3() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;K;W;X;P;N#b;h;l#S/NXlK,Sb,Xl;K/NlSW,P,bKNS,e;W/K,N,W,hPKh;X/P,W,X,bSPlS;P/K,NXhN,SXNK,WhSS,e;N/KN,h");
		cfgEpsUnitElim.eliminateEpsilonRules();
		assertEquals("S;K;W;X;P;N#b;h;l#S/NXl,NXlK,Nl,NlK,Sb,Xl,l;K/NlS,NlSW,P,bKNS,bNS;W/K,N,W,hKh,hPKh,hPh,hh;X/P,W,X,bSPlS,bSlS;P/K,NXhN,NhN,SN,SNK,SXN,SXNK,WhSS,hSS;N/KN,N,h", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgUnitRuleElimination1() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;N;C;H;E;I#h;n;r;t#S/CtI,H,HE,NSt,SrESS;N/C,CnH,H,NHNIS,SSHNN;C/N,NhSSI,NtE,ShI;H/CH,E,S,nE;E/CIC,Ih,NNNt;I/HItES,NC,h");
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;N;C;H;E;I#h;n;r;t#S/CH,CIC,CtI,HE,Ih,NNNt,NSt,SrESS,nE;N/CH,CIC,CnH,CtI,HE,Ih,NHNIS,NNNt,NSt,NhSSI,NtE,SSHNN,ShI,SrESS,nE;C/CH,CIC,CnH,CtI,HE,Ih,NHNIS,NNNt,NSt,NhSSI,NtE,SSHNN,ShI,SrESS,nE;H/CH,CIC,CtI,HE,Ih,NNNt,NSt,SrESS,nE;E/CIC,Ih,NNNt;I/HItES,NC,h", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgUnitRuleElimination2() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;Q;M;I;J;R#j;r;u#S/J,Q,Ru,j,jQRjI,rRSr;Q/I,M,MR,rSj,uMIr;M/I,J,Qr,SSr;I/JQ,S,jSJ,r,rJ;J/Qu,SuSQ,r,uJjIS;R/MJ,Rr,jSI,r");
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;Q;M;I;J;R#j;r;u#S/JQ,MR,Qr,Qu,Ru,SSr,SuSQ,j,jQRjI,jSJ,r,rJ,rRSr,rSj,uJjIS,uMIr;Q/JQ,MR,Qr,Qu,Ru,SSr,SuSQ,j,jQRjI,jSJ,r,rJ,rRSr,rSj,uJjIS,uMIr;M/JQ,MR,Qr,Qu,Ru,SSr,SuSQ,j,jQRjI,jSJ,r,rJ,rRSr,rSj,uJjIS,uMIr;I/JQ,MR,Qr,Qu,Ru,SSr,SuSQ,j,jQRjI,jSJ,r,rJ,rRSr,rSj,uJjIS,uMIr;J/Qu,SuSQ,r,uJjIS;R/MJ,Rr,jSI,r", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgUnitRuleElimination3() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;L;U;Y;I#d;f;h;l#S/IfIf,L,U,UhY;L/LfUI,Y;U/IYfYh,dSL,f;Y/L,S,f,h;I/LlId,SYhSS,ShLd");
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;L;U;Y;I#d;f;h;l#S/IYfYh,IfIf,LfUI,UhY,dSL,f,h;L/IYfYh,IfIf,LfUI,UhY,dSL,f,h;U/IYfYh,dSL,f;Y/IYfYh,IfIf,LfUI,UhY,dSL,f,h;I/LlId,SYhSS,ShLd", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination1() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;A;H;G;X#a;d;f;p#S/XaHdH,dHpAH,pX;A/G,H,e,fXdH,pA;H/A,S,SGHA,XaGG,d,e,f;G/G,aAdAS,aGAd,e;X/HGdSA,a,pG");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;A;H;G;X#a;d;f;p#S/XaHd,XaHdH,Xad,XadH,dHp,dHpA,dHpAH,dHpH,dp,dpA,dpAH,dpH,pX;A/SA,SG,SGA,SGH,SGHA,SH,SHA,Xa,XaG,XaGG,XaHd,XaHdH,Xad,XadH,aAd,aAdAS,aAdS,aGAd,aGd,ad,adAS,adS,d,dHp,dHpA,dHpAH,dHpH,dp,dpA,dpAH,dpH,f,fXd,fXdH,p,pA,pX;H/SA,SG,SGA,SGH,SGHA,SH,SHA,Xa,XaG,XaGG,XaHd,XaHdH,Xad,XadH,aAd,aAdAS,aAdS,aGAd,aGd,ad,adAS,adS,d,dHp,dHpA,dHpAH,dHpH,dp,dpA,dpAH,dpH,f,fXd,fXdH,p,pA,pX;G/aAd,aAdAS,aAdS,aGAd,aGd,ad,adAS,adS;X/GdS,GdSA,HGdS,HGdSA,HdS,HdSA,a,dS,dSA,p,pG", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination2() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;L;O;Y;B;T;I#c;i;j;n;u#S/IiIO,SuYS,Tc,uI;L/cL,jTBn;O/B,BBuTj,O,TIn,cL,e,iBcSL;Y/OTLTY,cYSuI,e,jBuBc;B/S,iLj;T/OIY,SSO,Y,e;I/LjS,SST,Y,uTnB");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;L;O;Y;B;T;I#c;i;j;n;u#S/Ii,IiI,IiIO,IiO,SuS,SuYS,Tc,c,i,iI,iIO,iO,u,uI;L/cL,jBn,jTBn;O/BBuTj,BBuj,Ii,IiI,IiIO,IiO,In,SuS,SuYS,TIn,Tc,Tn,c,cL,i,iBcSL,iI,iIO,iLj,iO,n,u,uI;Y/LT,LTY,LY,OL,OLT,OLTY,OLY,OTL,OTLT,OTLTY,OTLY,TL,TLT,TLTY,TLY,cL,cSu,cSuI,cYSu,cYSuI,jBn,jBuBc,jTBn;B/Ii,IiI,IiIO,IiO,SuS,SuYS,Tc,c,i,iI,iIO,iLj,iO,u,uI;T/BBuTj,BBuj,IY,Ii,IiI,IiIO,IiO,In,LT,LTY,LY,LjS,OI,OIY,OL,OLT,OLTY,OLY,OTL,OTLT,OTLTY,OTLY,OY,SS,SSO,SST,SuS,SuYS,TIn,TL,TLT,TLTY,TLY,Tc,Tn,c,cL,cSu,cSuI,cYSu,cYSuI,i,iBcSL,iI,iIO,iLj,iO,jBn,jBuBc,jTBn,n,u,uI,uTnB,unB;I/LT,LTY,LY,LjS,OL,OLT,OLTY,OLY,OTL,OTLT,OTLTY,OTLY,SS,SST,TL,TLT,TLTY,TLY,cL,cSu,cSuI,cYSu,cYSuI,jBn,jBuBc,jTBn,uTnB,unB", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination3() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;K;G;J;A;C;O#b;c;s;w#S/G,S,bK,cOK;K/G,JA,SOc,bOJ,sGwO;G/GJ,KcCc,KwAA;J/A,AwC,S,e,sK;A/J,K,bACJw,e,wCcAb,wSA;C/C,G,b,cK,e;O/CKcO,bA,w");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;K;G;J;A;C;O#b;c;s;w#S/GJ,KcCc,Kcc,Kw,KwA,KwAA,b,bK,cCc,cO,cOK,cc,w,wA,wAA;K/Aw,AwC,GJ,JA,KcCc,Kcc,Kw,KwA,KwAA,SOc,b,bACJw,bACw,bAJw,bAw,bCJw,bCw,bJw,bK,bO,bOJ,bw,cCc,cO,cOK,cc,s,sGwO,sK,w,wA,wAA,wC,wCcAb,wCcb,wS,wSA,wcAb,wcb;G/GJ,KcCc,Kcc,Kw,KwA,KwAA,cCc,cc,w,wA,wAA;J/Aw,AwC,GJ,JA,KcCc,Kcc,Kw,KwA,KwAA,SOc,b,bACJw,bACw,bAJw,bAw,bCJw,bCw,bJw,bK,bO,bOJ,bw,cCc,cO,cOK,cc,s,sGwO,sK,w,wA,wAA,wC,wCcAb,wCcb,wS,wSA,wcAb,wcb;A/Aw,AwC,GJ,JA,KcCc,Kcc,Kw,KwA,KwAA,SOc,b,bACJw,bACw,bAJw,bAw,bCJw,bCw,bJw,bK,bO,bOJ,bw,cCc,cO,cOK,cc,s,sGwO,sK,w,wA,wAA,wC,wCcAb,wCcb,wS,wSA,wcAb,wcb;C/GJ,KcCc,Kcc,Kw,KwA,KwAA,b,c,cCc,cK,cc,w,wA,wAA;O/CKcO,CcO,KcO,b,bA,cO,w", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination4() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;Z;H;L;J;W#o;r;x#S/HxZWx,WJxH,rHLJ;Z/S,Z,ZHxS,ZrH,r;H/H,J,LHx,SxZ,WJZ,e,rZZ;L/LHZ,Wx;J/H,e,oZJZ,xJ;W/H,SLLr,SSxL,o");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;Z;H;L;J;W#o;r;x#S/HxZWx,HxZx,Jx,JxH,WJx,WJxH,Wx,WxH,rHL,rHLJ,rL,rLJ,x,xH,xZWx,xZx;Z/HxZWx,HxZx,Jx,JxH,WJx,WJxH,Wx,WxH,ZHxS,Zr,ZrH,ZxS,r,rHL,rHLJ,rL,rLJ,x,xH,xZWx,xZx;H/HxZWx,HxZx,JZ,Jx,JxH,LHx,Lx,SxZ,WJZ,WJx,WJxH,WZ,Wx,WxH,ZHxS,Zr,ZrH,ZxS,oZJZ,oZZ,r,rHL,rHLJ,rL,rLJ,rZZ,x,xH,xJ,xZWx,xZx;L/LHZ,LZ,Wx,x;J/HxZWx,HxZx,JZ,Jx,JxH,LHx,Lx,SxZ,WJZ,WJx,WJxH,WZ,Wx,WxH,ZHxS,Zr,ZrH,ZxS,oZJZ,oZZ,r,rHL,rHLJ,rL,rLJ,rZZ,x,xH,xJ,xZWx,xZx;W/HxZWx,HxZx,JZ,Jx,JxH,LHx,Lx,SLLr,SSxL,SxZ,WJZ,WJx,WJxH,WZ,Wx,WxH,ZHxS,Zr,ZrH,ZxS,o,oZJZ,oZZ,r,rHL,rHLJ,rL,rLJ,rZZ,x,xH,xJ,xZWx,xZx", cfgEpsUnitElim.toString());
	}

}