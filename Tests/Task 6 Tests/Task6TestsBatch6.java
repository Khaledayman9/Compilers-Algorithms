package csen1002.tests.task6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task6.CfgFirstFollow;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task6TestsBatch6 {

	@Test
	public void testCfg1First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;M;O;Q;P;N;G#b;n;q;s;u;x#S/SxQnQ,bSuS;M/u,S,PNN,NMPNG,e;O/SQq,S;Q/GOnS,sNO;P/q,uGxS,e,M;N/nPbON,SM,S,O,M;G/PPN,bO,bOuN");
		assertEquals("S/b;M/benqu;O/b;Q/bnqsu;P/benqu;N/benqu;G/benqu", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg1Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;M;O;Q;P;N;G#b;n;q;s;u;x#S/SxQnQ,bSuS;M/u,S,PNN,NMPNG,e;O/SQq,S;Q/GOnS,sNO;P/q,uGxS,e,M;N/nPbON,SM,S,O,M;G/PPN,bO,bOuN");
		assertEquals("S/$bnqsux;M/bnqux;O/$bnqsux;Q/$bnqsux;P/bnqux;N/bnqux;G/bnqux", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg2First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;W;O;Z;Y;G;V#f;g;i;j;o#S/Of,Vf,SYGiW;W/WZ,gZfS,GZg,e,Z,O;O/f,VfSZ;Z/fZGZf,gOi,g,e;Y/SfY,GSS,G;G/ZSjO,GjYW,iW,iSoOY,W,WGSYV,G;V/VjZZo,Z");
		assertEquals("S/fgj;W/efgij;O/fgj;Z/efg;Y/efgij;G/efgij;V/efgj", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg2Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;W;O;Z;Y;G;V#f;g;i;j;o#S/Of,Vf,SYGiW;W/WZ,gZfS,GZg,e,Z,O;O/f,VfSZ;Z/fZGZf,gOi,g,e;Y/SfY,GSS,G;G/ZSjO,GjYW,iW,iSoOY,W,WGSYV,G;V/VjZZo,Z");
		assertEquals("S/$fgijo;W/$fgijo;O/$fgijo;Z/$fgijo;Y/fgij;G/fgij;V/fgij", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg3First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;M;K;C;A;D;R#c;h;i;m;x;y;z#S/RKCi,AR;M/mDS,xRSDm,cRS,iScR,e,S,M;K/KKmAR,mSS,i,e,K;C/zSxA,MS,Kh,SxR,e,D;A/iDm,My,KhRzC,D;D/KxA,hC,KSS,K;R/RyMSy,Mm,cRi,Rm,ADAc");
		assertEquals("S/chimxy;M/cehimxy;K/eim;C/cehimxyz;A/cehimxy;D/cehimxy;R/chimxy", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg3Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;M;K;C;A;D;R#c;h;i;m;x;y;z#S/RKCi,AR;M/mDS,xRSDm,cRS,iScR,e,S,M;K/KKmAR,mSS,i,e,K;C/zSxA,MS,Kh,SxR,e,D;A/iDm,My,KhRzC,D;D/KxA,hC,KSS,K;R/RyMSy,Mm,cRi,Rm,ADAc");
		assertEquals("S/$chimxyz;M/chimxy;K/chimxyz;C/chimxy;A/chimxy;D/chimxy;R/$chimxyz", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg4First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;F;N;V;R;W;H#b;f;n;o;w;y#S/SbVHV,VbSN;F/f,oH,HSyN,b,S,V,N;N/S,WNoH,oSfHf,e;V/oV,yFHFS,wRnH,V;R/fV,NWf,HNWw,e,W;W/N,Vo,W;H/RHFyN,wHo,nNFHf");
		assertEquals("S/owy;F/befnowy;N/eowy;V/owy;R/efnowy;W/eowy;H/fnowy", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg4Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;F;N;V;R;W;H#b;f;n;o;w;y#S/SbVHV,VbSN;F/f,oH,HSyN,b,S,V,N;N/S,WNoH,oSfHf,e;V/oV,yFHFS,wRnH,V;R/fV,NWf,HNWw,e,W;W/N,Vo,W;H/RHFyN,wHo,nNFHf");
		assertEquals("S/$bfnowy;F/fnowy;N/$bfnowy;V/$bfnowy;R/fnowy;W/fnowy;H/$bfnowy", cfgFirstFollow.follow());
	}

	@Test
	public void testCfg5First() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;M;Z;A;E;G#b;c;f;n;o;s;w#S/sZZ,cEM,Gs,Z,A,M;M/bMAMZ,ZoEn,M;Z/MwEMo,oSM,e,M;A/oSoZ,b,Z,MZEf,e;E/oMEZ,SMZMc,w,sSEZ,nM,M;G/S,nZb,wGGEZ,bEcS,AbZf");
		assertEquals("S/bcenosw;M/bo;Z/beo;A/beo;E/bcnosw;G/bcenosw", cfgFirstFollow.first());
	}
	
	@Test
	public void testCfg5Follow() {
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;M;Z;A;E;G#b;c;f;n;o;s;w#S/sZZ,cEM,Gs,Z,A,M;M/bMAMZ,ZoEn,M;Z/MwEMo,oSM,e,M;A/oSoZ,b,Z,MZEf,e;E/oMEZ,SMZMc,w,sSEZ,nM,M;G/S,nZb,wGGEZ,bEcS,AbZf");
		assertEquals("S/$bcnosw;M/$bcfnosw;Z/$bcfnosw;A/$bcnosw;E/bcfnosw;G/bcnosw", cfgFirstFollow.follow());
	}

}