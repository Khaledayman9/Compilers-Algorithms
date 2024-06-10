package csen1002.tests.task8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task8.CfgLl1Parser;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task8TestsBatch8 {

	@Test
	public void testCfg1String1() {
		CfgLl1Parser cfgLl1Parser= new CfgLl1Parser("S;F;J;L;C;B;T#b;d;j;k;q;z#S/bJd,kT;F/jTzF,zF,e;J/jLj,bFbT;L/zB,T;C/k,bCd,e;B/dJS,bC,jCdS;T/bS,kTq#S/b,k;F/j,z,e;J/j,b;L/z,bk;C/k,b,e;B/d,b,j;T/b,k#S/$bdjkqz;F/b;J/bdk;L/j;C/dj;B/j;T/$bdjkqz");
		assertEquals("S;bJd;bjLjd;bjzBjd;bjzjCdSjd;bjzjbCddSjd;bjzjbbCdddSjd;bjzjbbdddSjd;ERROR", cfgLl1Parser.parse("bjzjbbjq"));
	}

	@Test
	public void testCfg1String2() {
		CfgLl1Parser cfgLl1Parser= new CfgLl1Parser("S;F;J;L;C;B;T#b;d;j;k;q;z#S/bJd,kT;F/jTzF,zF,e;J/jLj,bFbT;L/zB,T;C/k,bCd,e;B/dJS,bC,jCdS;T/bS,kTq#S/b,k;F/j,z,e;J/j,b;L/z,bk;C/k,b,e;B/d,b,j;T/b,k#S/$bdjkqz;F/b;J/bdk;L/j;C/dj;B/j;T/$bdjkqz");
		assertEquals("S;kT;kbS;kbbJd;kbbjLjd;kbbjzBjd;kbbjzbCjd;kbbjzbbCdjd;kbbjzbbkdjd", cfgLl1Parser.parse("kbbjzbbkdjd"));
	}

	@Test
	public void testCfg1String3() {
		CfgLl1Parser cfgLl1Parser= new CfgLl1Parser("S;F;J;L;C;B;T#b;d;j;k;q;z#S/bJd,kT;F/jTzF,zF,e;J/jLj,bFbT;L/zB,T;C/k,bCd,e;B/dJS,bC,jCdS;T/bS,kTq#S/b,k;F/j,z,e;J/j,b;L/z,bk;C/k,b,e;B/d,b,j;T/b,k#S/$bdjkqz;F/b;J/bdk;L/j;C/dj;B/j;T/$bdjkqz");
		assertEquals("S;bJd;bjLjd;bjTjd;bjbSjd;bjbkTjd;bjbkkTqjd;ERROR", cfgLl1Parser.parse("bjbkkzdb"));
	}

	@Test
	public void testCfg1String4() {
		CfgLl1Parser cfgLl1Parser= new CfgLl1Parser("S;F;J;L;C;B;T#b;d;j;k;q;z#S/bJd,kT;F/jTzF,zF,e;J/jLj,bFbT;L/zB,T;C/k,bCd,e;B/dJS,bC,jCdS;T/bS,kTq#S/b,k;F/j,z,e;J/j,b;L/z,bk;C/k,b,e;B/d,b,j;T/b,k#S/$bdjkqz;F/b;J/bdk;L/j;C/dj;B/j;T/$bdjkqz");
		assertEquals("S;bJd;bbFbTd;bbjTzFbTd;bbjkTqzFbTd;bbjkkTqqzFbTd;bbjkkbSqqzFbTd;ERROR", cfgLl1Parser.parse("bbjkkbj"));
	}

	@Test
	public void testCfg1String5() {
		CfgLl1Parser cfgLl1Parser= new CfgLl1Parser("S;F;J;L;C;B;T#b;d;j;k;q;z#S/bJd,kT;F/jTzF,zF,e;J/jLj,bFbT;L/zB,T;C/k,bCd,e;B/dJS,bC,jCdS;T/bS,kTq#S/b,k;F/j,z,e;J/j,b;L/z,bk;C/k,b,e;B/d,b,j;T/b,k#S/$bdjkqz;F/b;J/bdk;L/j;C/dj;B/j;T/$bdjkqz");
		assertEquals("S;bJd;bjLjd;bjTjd;bjkTqjd;bjkbSqjd;bjkbkTqjd;bjkbkbSqjd;ERROR", cfgLl1Parser.parse("bjkbkbqz"));
	}

	@Test
	public void testCfg2String1() {
		CfgLl1Parser cfgLl1Parser= new CfgLl1Parser("S;Z;G;H;E;X#a;b;d;k;l;o#S/kEX,dH;Z/l,b;G/X,oZa,e;H/dHZd,kG,e;E/lHl,kZdE;X/dZdS,k#S/k,d;Z/l,b;G/dk,o,e;H/d,k,e;E/l,k;X/d,k#S/$bl;Z/ad;G/$bl;H/$bl;E/dk;X/$bl");
		assertEquals("S;kEX;klHlX;kllX;klldZdS;klldbdS;klldbddH;klldbddkG;klldbddkoZa;klldbddkola", cfgLl1Parser.parse("klldbddkola"));
	}

	@Test
	public void testCfg2String2() {
		CfgLl1Parser cfgLl1Parser= new CfgLl1Parser("S;Z;G;H;E;X#a;b;d;k;l;o#S/kEX,dH;Z/l,b;G/X,oZa,e;H/dHZd,kG,e;E/lHl,kZdE;X/dZdS,k#S/k,d;Z/l,b;G/dk,o,e;H/d,k,e;E/l,k;X/d,k#S/$bl;Z/ad;G/$bl;H/$bl;E/dk;X/$bl");
		assertEquals("S;kEX;klHlX;klkGlX;klkXlX;klkdZdSlX;klkdldSlX;ERROR", cfgLl1Parser.parse("klkdldo"));
	}

	@Test
	public void testCfg2String3() {
		CfgLl1Parser cfgLl1Parser= new CfgLl1Parser("S;Z;G;H;E;X#a;b;d;k;l;o#S/kEX,dH;Z/l,b;G/X,oZa,e;H/dHZd,kG,e;E/lHl,kZdE;X/dZdS,k#S/k,d;Z/l,b;G/dk,o,e;H/d,k,e;E/l,k;X/d,k#S/$bl;Z/ad;G/$bl;H/$bl;E/dk;X/$bl");
		assertEquals("S;kEX;klHlX;kllX;klldZdS;klldldS;klldlddH;klldldd", cfgLl1Parser.parse("klldldd"));
	}

	@Test
	public void testCfg2String4() {
		CfgLl1Parser cfgLl1Parser= new CfgLl1Parser("S;Z;G;H;E;X#a;b;d;k;l;o#S/kEX,dH;Z/l,b;G/X,oZa,e;H/dHZd,kG,e;E/lHl,kZdE;X/dZdS,k#S/k,d;Z/l,b;G/dk,o,e;H/d,k,e;E/l,k;X/d,k#S/$bl;Z/ad;G/$bl;H/$bl;E/dk;X/$bl");
		assertEquals("S;dH;ddHZd;dddHZdZd;ddddHZdZdZd;ddddkGZdZdZd;ddddkZdZdZd;ddddkbdZdZd;ERROR", cfgLl1Parser.parse("ddddkbbd"));
	}

	@Test
	public void testCfg2String5() {
		CfgLl1Parser cfgLl1Parser= new CfgLl1Parser("S;Z;G;H;E;X#a;b;d;k;l;o#S/kEX,dH;Z/l,b;G/X,oZa,e;H/dHZd,kG,e;E/lHl,kZdE;X/dZdS,k#S/k,d;Z/l,b;G/dk,o,e;H/d,k,e;E/l,k;X/d,k#S/$bl;Z/ad;G/$bl;H/$bl;E/dk;X/$bl");
		assertEquals("S;kEX;kkZdEX;kkbdEX;kkbdlHlX;kkbdlkGlX;kkbdlklX;kkbdlklk", cfgLl1Parser.parse("kkbdlklk"));
	}

}