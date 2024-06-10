package csen1002.tests.task6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task6.CfgFirstFollow;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task6TestsBatch4 {

	@Test
	public void testCfg1First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;K;H;W;Z;X#i;l;p;t;x;z#S/XxW,SlKz,pKX,pXX;K/iSH,iWzHX,S,Z;H/HiHXW,Xi,X,Z,W;W/WKt,lWpWX,lWp,e,W;Z/tHKi,XtZZ,e,K;X/zS,S,ZKt");
		assertEquals("S/iptz;K/eiptz;H/eilptz;W/eilptz;Z/eiptz;X/iptz", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg1Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;K;H;W;Z;X#i;l;p;t;x;z#S/XxW,SlKz,pKX,pXX;K/iSH,iWzHX,S,Z;H/HiHXW,Xi,X,Z,W;W/WKt,lWpWX,lWp,e,W;Z/tHKi,XtZZ,e,K;X/zS,S,ZKt");
		assertEquals("S/$ilptxz;K/iptz;H/iptz;W/$ilptxz;Z/iptz;X/$ilptxz", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg2First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;K;L;U;V;E;A#a;f;k;m;p;q#S/EaVKK,KL,V;K/aALKf,L;L/pAaK,VUpV,e,K,L;U/V,SKV,fKm,e,U;V/fLpV,fS;E/LLUSU,V,fUp,ASm,qAVUE,e;A/mSk,EE");
		assertEquals("S/aefmpq;K/aefp;L/aefp;U/aefmpq;V/f;E/aefmpq;A/aefmpq", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg2Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;K;L;U;V;E;A#a;f;k;m;p;q#S/EaVKK,KL,V;K/aALKf,L;L/pAaK,VUpV,e,K,L;U/V,SKV,fKm,e,U;V/fLpV,fS;E/LLUSU,V,fUp,ASm,qAVUE,e;A/mSk,EE");
		assertEquals("S/$afkmpq;K/$afkmpq;L/$afkmpq;U/afmpq;V/$afkmpq;E/afmpq;A/afmpq", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg3First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;L;X;I;G;D;Q#g;i;m;t;u;z#S/mQzD,tXm,I,GIm,L;L/GGD,m,LzII,e;X/It,QuLS,z,GQzQ,D,iIG,e,X,S;I/m,Si,L,I;G/iLgX,LuL,e,G;D/uQSD,LzGm;Q/I,GIXG");
		assertEquals("S/eimtuz;L/eimuz;X/eimtuz;I/eimtuz;G/eimuz;D/imuz;Q/eimtuz", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg3Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;L;X;I;G;D;Q#g;i;m;t;u;z#S/mQzD,tXm,I,GIm,L;L/GGD,m,LzII,e;X/It,QuLS,z,GQzQ,D,iIG,e,X,S;I/m,Si,L,I;G/iLgX,LuL,e,G;D/uQSD,LzGm;Q/I,GIXG");
		assertEquals("S/$imtuz;L/$gimtuz;X/imtuz;I/$gimtuz;G/imtuz;D/$gimtuz;Q/imtuz", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg4First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;C;X;E;F;M;K#c;i;j;l;o;q;x#S/MCx,cE,X;C/X,XxS,MS,EC,cSX,CMlSM;X/c,E,xFSj,EcFj,S;E/iXS,X,XMiFi,e,S;F/K,SoKXq,e,C;M/jKi,MXSjE;K/oECS,Fq");
		assertEquals("S/ceijx;C/ceijx;X/ceijx;E/ceijx;F/ceijoqx;M/j;K/cijoqx", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg4Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;C;X;E;F;M;K#c;i;j;l;o;q;x#S/MCx,cE,X;C/X,XxS,MS,EC,cSX,CMlSM;X/c,E,xFSj,EcFj,S;E/iXS,X,XMiFi,e,S;F/K,SoKXq,e,C;M/jKi,MXSjE;K/oECS,Fq");
		assertEquals("S/$cijloqx;C/cijqx;X/$cijloqx;E/$cijloqx;F/cijqx;M/cijlqx;K/cijqx", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg5First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;O;N;A;F;B;P#g;i;k;t;u;v;w#S/Fu,OOPkF,F;O/F,FtSw,St,B,e,A,N;N/FgSi,t,NPwN;A/uAvNA,BAvS,wABA,AOtN,O;F/g,BgP,e;B/t,P;P/NS,BN,F");
		assertEquals("S/egktuvw;O/egktuvw;N/gt;A/egktuvw;F/egt;B/egt;P/egt", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg5Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;O;N;A;F;B;P#g;i;k;t;u;v;w#S/Fu,OOPkF,F;O/F,FtSw,St,B,e,A,N;N/FgSi,t,NPwN;A/uAvNA,BAvS,wABA,AOtN,O;F/g,BgP,e;B/t,P;P/NS,BN,F");
		assertEquals("S/$giktuvw;O/gktuvw;N/$giktuvw;A/gktuvw;F/$giktuvw;B/gktuvw;P/$giktuvw", cfgFirstFollow.follow());
	}

}