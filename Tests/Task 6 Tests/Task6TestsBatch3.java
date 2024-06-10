package csen1002.tests.task6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task6.CfgFirstFollow;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task6TestsBatch3 {

	@Test
	public void testCfg1First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;D;T;U;O;W;P#b;g;i;m;n;p#S/Oi,O;D/T,pOSUi,O;T/DgO,iDWS,g,PWWTP,iT,e,T;U/UmP,i,DWP,gDPUm,D;O/OpOTT,PiWS,S;W/gDWO,pTO,UO,WbPO,e,D;P/iSOn,Dp");
		assertEquals("S/gip;D/egip;T/egip;U/begimp;O/gip;W/begimp;P/gip", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg1Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;D;T;U;O;W;P#b;g;i;m;n;p#S/Oi,O;D/T,pOSUi,O;T/DgO,iDWS,g,PWWTP,iT,e,T;U/UmP,i,DWP,gDPUm,D;O/OpOTT,PiWS,S;W/gDWO,pTO,UO,WbPO,e,D;P/iSOn,Dp");
		assertEquals("S/$bgimnp;D/bgimp;T/$bgimnp;U/gimp;O/$bgimnp;W/bgimp;P/$bgimnp", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg2First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;H;L;P;V;R;J#g;p;q;w;y;z#S/VyHy,LySH,pH,g,w,L;H/PSL,VyHH,RVpJp,L,P;L/qH,wHH,HqL,pSy,e;P/pSSHp,PqHS;V/w,p,gHg,e;R/gLJ,VVyH,RLqP,e,P,R;J/Hy,LPSVV,RSgPy,zPPL,SyR,Vy");
		assertEquals("S/egpqwy;H/egpqwy;L/egpqwy;P/p;V/egpw;R/egpqwy;J/gpqwyz", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg2Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;H;L;P;V;R;J#g;p;q;w;y;z#S/VyHy,LySH,pH,g,w,L;H/PSL,VyHH,RVpJp,L,P;L/qH,wHH,HqL,pSy,e;P/pSSHp,PqHS;V/w,p,gHg,e;R/gLJ,VVyH,RLqP,e,P,R;J/Hy,LPSVV,RSgPy,zPPL,SyR,Vy");
		assertEquals("S/$gpqwyz;H/$gpqwyz;L/$gpqwyz;P/$gpqwyz;V/gpqwy;R/gpqwy;J/gpqwy", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg3First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;J;H;Q;Z;R#h;l;o;u;x;z#S/J,h,S;J/HQx,zJSh,Zu,e;H/xJlS,QJQZQ,ZoSHZ,ZSoRH,Z,J;Q/ZxZHz,uZ,ZoHh,ZSlS,e,H,J,Q;Z/ZZlZz,z,uRZ;R/lRHR,Z,l,x,ZRQ,SHS");
		assertEquals("S/ehuxz;J/euxz;H/euxz;Q/euxz;Z/uz;R/ehluxz", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg3Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;J;H;Q;Z;R#h;l;o;u;x;z#S/J,h,S;J/HQx,zJSh,Zu,e;H/xJlS,QJQZQ,ZoSHZ,ZSoRH,Z,J;Q/ZxZHz,uZ,ZoHh,ZSlS,e,H,J,Q;Z/ZZlZz,z,uRZ;R/lRHR,Z,l,x,ZRQ,SHS");
		assertEquals("S/$hlouxz;J/$hlouxz;H/hluxz;Q/hluxz;Z/hlouxz;R/hluxz", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg4First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;K;O;E;W;Z;L#f;n;q;r;t;v#S/SvE,v,n,Ln;K/fLrOK,fO,S,K;O/E,Wr,LrO,SfLf,e,K;E/fO,rKqWr;W/LZt,nLZ,rEvK,O,e,W;Z/fOtW,O,LW,E,v,Z;L/OWZ,Sq,ELZ,S");
		assertEquals("S/fnrtv;K/fnrtv;O/efnrtv;E/fr;W/efnrtv;Z/efnrtv;L/efnrtv", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg4Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;K;O;E;W;Z;L#f;n;q;r;t;v#S/SvE,v,n,Ln;K/fLrOK,fO,S,K;O/E,Wr,LrO,SfLf,e,K;E/fO,rKqWr;W/LZt,nLZ,rEvK,O,e,W;Z/fOtW,O,LW,E,v,Z;L/OWZ,Sq,ELZ,S");
		assertEquals("S/$fnqrtv;K/$fnqrtv;O/$fnqrtv;E/$fnqrtv;W/fnrtv;Z/fnrtv;L/fnrtv", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg5First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;L;H;T;J;I;Z#a;g;l;o;p;w;y#S/gLHL,gTL,o;L/Zg,TL,TTSy,TLoSL,S;H/IlZy,ZlH,l,S,e;T/JT,SZ,gL,JwSHS,IT,J;J/oTHTp,aTlSp,e;I/l,gJTgI,gIpJ,p,IJ,L,T,S;Z/ZwL,lHy,JZgHo,HHZL");
		assertEquals("S/go;L/aglopw;H/aeglopw;T/aeglopw;J/aeo;I/aeglopw;Z/aglopw", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg5Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;L;H;T;J;I;Z#a;g;l;o;p;w;y#S/gLHL,gTL,o;L/Zg,TL,TTSy,TLoSL,S;H/IlZy,ZlH,l,S,e;T/JT,SZ,gL,JwSHS,IT,J;J/oTHTp,aTlSp,e;I/l,gJTgI,gIpJ,p,IJ,L,T,S;Z/ZwL,lHy,JZgHo,HHZL");
		assertEquals("S/$aglopwy;L/$aglopwy;H/aglopwy;T/aglopw;J/aglopw;I/aglopw;Z/aglopwy", cfgFirstFollow.follow());
	}

}