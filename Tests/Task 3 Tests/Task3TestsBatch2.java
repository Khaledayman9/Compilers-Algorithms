package csen1002.tests.task3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task3.FallbackDfa;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task3TestsBatch2 {

	@Test
	public void testFallbackDfa1String1() {
		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9;10;11#h;v;x#0,h,4;0,v,7;0,x,3;1,h,10;1,v,7;1,x,11;2,h,2;2,v,9;2,x,2;3,h,9;3,v,7;3,x,10;4,h,2;4,v,2;4,x,5;5,h,11;5,v,0;5,x,5;6,h,1;6,v,5;6,x,7;7,h,6;7,v,4;7,x,3;8,h,2;8,v,10;8,x,6;9,h,5;9,v,1;9,x,3;10,h,10;10,v,6;10,x,8;11,h,7;11,v,9;11,x,11#5#2;8;9;11");
		assertEquals("h,11;h,11;hv,9;xvhxx,5", fallbackDfa.run("hhhvxvhxx"));
	}

	@Test
	public void testFallbackDfa1String2() {
		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9;10;11#h;v;x#0,h,4;0,v,7;0,x,3;1,h,10;1,v,7;1,x,11;2,h,2;2,v,9;2,x,2;3,h,9;3,v,7;3,x,10;4,h,2;4,v,2;4,x,5;5,h,11;5,v,0;5,x,5;6,h,1;6,v,5;6,x,7;7,h,6;7,v,4;7,x,3;8,h,2;8,v,10;8,x,6;9,h,5;9,v,1;9,x,3;10,h,10;10,v,6;10,x,8;11,h,7;11,v,9;11,x,11#5#2;8;9;11");
		assertEquals("hvhvhhvxhhxvxxhxxhx,11;h,11;h,11;h,11;h,11", fallbackDfa.run("hvhvhhvxhhxvxxhxxhxhhhh"));
	}

	@Test
	public void testFallbackDfa1String3() {
		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9;10;11#h;v;x#0,h,4;0,v,7;0,x,3;1,h,10;1,v,7;1,x,11;2,h,2;2,v,9;2,x,2;3,h,9;3,v,7;3,x,10;4,h,2;4,v,2;4,x,5;5,h,11;5,v,0;5,x,5;6,h,1;6,v,5;6,x,7;7,h,6;7,v,4;7,x,3;8,h,2;8,v,10;8,x,6;9,h,5;9,v,1;9,x,3;10,h,10;10,v,6;10,x,8;11,h,7;11,v,9;11,x,11#5#2;8;9;11");
		assertEquals("vxxx,8;xh,11;h,11;h,11", fallbackDfa.run("vxxxxhhh"));
	}

	@Test
	public void testFallbackDfa1String4() {
		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9;10;11#h;v;x#0,h,4;0,v,7;0,x,3;1,h,10;1,v,7;1,x,11;2,h,2;2,v,9;2,x,2;3,h,9;3,v,7;3,x,10;4,h,2;4,v,2;4,x,5;5,h,11;5,v,0;5,x,5;6,h,1;6,v,5;6,x,7;7,h,6;7,v,4;7,x,3;8,h,2;8,v,10;8,x,6;9,h,5;9,v,1;9,x,3;10,h,10;10,v,6;10,x,8;11,h,7;11,v,9;11,x,11#5#2;8;9;11");
		assertEquals("hhvhxxvvhhvvhv,9;vhvhhv,9;hv,9;v,0", fallbackDfa.run("hhvhxxvvhhvvhvvhvhhvhvv"));
	}

	@Test
	public void testFallbackDfa1String5() {
		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9;10;11#h;v;x#0,h,4;0,v,7;0,x,3;1,h,10;1,v,7;1,x,11;2,h,2;2,v,9;2,x,2;3,h,9;3,v,7;3,x,10;4,h,2;4,v,2;4,x,5;5,h,11;5,v,0;5,x,5;6,h,1;6,v,5;6,x,7;7,h,6;7,v,4;7,x,3;8,h,2;8,v,10;8,x,6;9,h,5;9,v,1;9,x,3;10,h,10;10,v,6;10,x,8;11,h,7;11,v,9;11,x,11#5#2;8;9;11");
		assertEquals("hxhxvhhxvhhvhh,11;h,11;h,11;h,11", fallbackDfa.run("hxhxvhhxvhhvhhhhh"));
	}

	@Test
	public void testFallbackDfa2String1() {
		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9#o;u#0,o,4;0,u,5;1,o,8;1,u,6;2,o,5;2,u,1;3,o,1;3,u,4;4,o,1;4,u,4;5,o,9;5,u,9;6,o,8;6,u,9;7,o,7;7,u,0;8,o,0;8,u,2;9,o,7;9,u,8#3#4;6;8");
		assertEquals("ouo,8;uouo,8;ou,6;u,4", fallbackDfa.run("ouououoouu"));
	}

	@Test
	public void testFallbackDfa2String2() {
		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9#o;u#0,o,4;0,u,5;1,o,8;1,u,6;2,o,5;2,u,1;3,o,1;3,u,4;4,o,1;4,u,4;5,o,9;5,u,9;6,o,8;6,u,9;7,o,7;7,u,0;8,o,0;8,u,2;9,o,7;9,u,8#3#4;6;8");
		assertEquals("ouuuoooooouuuuoouuo,8;ou,6;u,4;o,1", fallbackDfa.run("ouuuoooooouuuuoouuoouuo"));
	}

	@Test
	public void testFallbackDfa2String3() {
		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9#o;u#0,o,4;0,u,5;1,o,8;1,u,6;2,o,5;2,u,1;3,o,1;3,u,4;4,o,1;4,u,4;5,o,9;5,u,9;6,o,8;6,u,9;7,o,7;7,u,0;8,o,0;8,u,2;9,o,7;9,u,8#3#4;6;8");
		assertEquals("ouo,8;ou,6;u,4;o,1", fallbackDfa.run("ouoouuo"));
	}

	@Test
	public void testFallbackDfa2String4() {
		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9#o;u#0,o,4;0,u,5;1,o,8;1,u,6;2,o,5;2,u,1;3,o,1;3,u,4;4,o,1;4,u,4;5,o,9;5,u,9;6,o,8;6,u,9;7,o,7;7,u,0;8,o,0;8,u,2;9,o,7;9,u,8#3#4;6;8");
		assertEquals("ouooouuouo,8;ou,6;u,4;o,1", fallbackDfa.run("ouooouuouoouuo"));
	}

	@Test
	public void testFallbackDfa2String5() {
		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9#o;u#0,o,4;0,u,5;1,o,8;1,u,6;2,o,5;2,u,1;3,o,1;3,u,4;4,o,1;4,u,4;5,o,9;5,u,9;6,o,8;6,u,9;7,o,7;7,u,0;8,o,0;8,u,2;9,o,7;9,u,8#3#4;6;8");
		assertEquals("uouoooouuuooou,6;uou,6;u,4;o,1", fallbackDfa.run("uouoooouuuooouuouuo"));
	}

}