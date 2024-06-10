package csen1002.tests.task6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task6.CfgFirstFollow;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task6TestsBatch8 {

	@Test
	public void testCfg1First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;R;T;G;V;O#d;n;o;p;w;x;y#S/VnT,TdSo,o,dV,T;R/wTo,SxVnG,xTRp,SwRyS,Vo,yG,S,R;T/Tx,TS,e,S;G/nRnR,pVOSG;V/Gn,p,e;O/n,pGV,OG,GG,SpT");
		assertEquals("S/denopx;R/denopwxy;T/denopx;G/np;V/enp;O/dnopx", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg1Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;R;T;G;V;O#d;n;o;p;w;x;y#S/VnT,TdSo,o,dV,T;R/wTo,SxVnG,xTRp,SwRyS,Vo,yG,S,R;T/Tx,TS,e,S;G/nRnR,pVOSG;V/Gn,p,e;O/n,pGV,OG,GG,SpT");
		assertEquals("S/$dnopwxy;R/dnopxy;T/$dnopwxy;G/dnopxy;V/$dnopwxy;O/dnopx", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg2First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;Z;B;D;J;P;K#c;i;l;m;t;x#S/tK,cZlK,Z,S;Z/JSPlS,SmJ,BtZm,Z;B/x,Z;D/iDxZP,JDmPc,xDc,mJmB,JPZ,Z,P;J/ZxJBt,Jc,BlJl,e;P/cPmZt,BZmD,iBJ,e;K/SKJ,iZtPS,J,xJx");
		assertEquals("S/ctx;Z/ctx;B/ctx;D/ceimtx;J/cetx;P/ceitx;K/ceitx", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg2Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;Z;B;D;J;P;K#c;i;l;m;t;x#S/tK,cZlK,Z,S;Z/JSPlS,SmJ,BtZm,Z;B/x,Z;D/iDxZP,JDmPc,xDc,mJmB,JPZ,Z,P;J/ZxJBt,Jc,BlJl,e;P/cPmZt,BZmD,iBJ,e;K/SKJ,iZtPS,J,xJx");
		assertEquals("S/$cilmtx;Z/$cilmtx;B/clmtx;D/clmtx;J/$cilmtx;P/clmtx;K/$cilmtx", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg3First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;T;L;W;F;M;N#a;b;k;l;p;u;y#S/yF,TlFS,TT,T;T/F,SbMa,e;L/SMWk,k,FS,W,M,bWMLa,F,T;W/kNF,FlT,bS,FFT,lNNWa,e;F/aMu,kSpS;M/TM,MLa,TMyNu,l,e,W;N/W,Nk");
		assertEquals("S/abekly;T/abekly;L/abekly;W/abekl;F/ak;M/abekly;N/abekl", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg3Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;T;L;W;F;M;N#a;b;k;l;p;u;y#S/yF,TlFS,TT,T;T/F,SbMa,e;L/SMWk,k,FS,W,M,bWMLa,F,T;W/kNF,FlT,bS,FFT,lNNWa,e;F/aMu,kSpS;M/TM,MLa,TMyNu,l,e,W;N/W,Nk");
		assertEquals("S/$abklpuy;T/$abklpuy;L/a;W/abkluy;F/$abklpuy;M/abkluy;N/abklu", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg4First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;X;M;F;H;A;L#h;k;l;m;n;q;x#S/LLl,XXn,l,kF;X/MX,qFSxX,SAkAA,S;M/kSF,mX,lH,xFH,XS,kAF,e;F/lHS,kX,XAXnF,e,S;H/FkL,FMq,MMMMM,hAHq,lXMx,Sk,H,M;A/MFkAk,mS,S;L/Sl,Aq,M,nAn,LFl");
		assertEquals("S/klmnqx;X/klmnqx;M/eklmnqx;F/eklmnqx;H/ehklmnqx;A/klmnqx;L/eklmnqx", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg4Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;X;M;F;H;A;L#h;k;l;m;n;q;x#S/LLl,XXn,l,kF;X/MX,qFSxX,SAkAA,S;M/kSF,mX,lH,xFH,XS,kAF,e;F/lHS,kX,XAXnF,e,S;H/FkL,FMq,MMMMM,hAHq,lXMx,Sk,H,M;A/MFkAk,mS,S;L/Sl,Aq,M,nAn,LFl");
		assertEquals("S/$hklmnqx;X/$hklmnqx;M/klmnqx;F/$hklmnqx;H/klmnqx;A/$hklmnqx;L/klmnqx", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg5First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;Z;A;C;J;R;T#a;i;j;m;q;u;v#S/ZqT,j;Z/Ju,qRm,v,q,S,e;A/qST,AiCA,jJv,Z;C/a,aSAJ,e;J/A,qA,e,Z,J;R/JqS,jR,CqCuZ,TTZR,J;T/Sq,SAm");
		assertEquals("S/ijquv;Z/eijquv;A/eijquv;C/ae;J/eijquv;R/aeijquv;T/ijquv", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg5Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;Z;A;C;J;R;T#a;i;j;m;q;u;v#S/ZqT,j;Z/Ju,qRm,v,q,S,e;A/qST,AiCA,jJv,Z;C/a,aSAJ,e;J/A,qA,e,Z,J;R/JqS,jR,CqCuZ,TTZR,J;T/Sq,SAm");
		assertEquals("S/$aijmquv;Z/aijmquv;A/ijmquv;C/ijmquv;J/ijmquv;R/m;T/$aijmquv", cfgFirstFollow.follow());
	}

}