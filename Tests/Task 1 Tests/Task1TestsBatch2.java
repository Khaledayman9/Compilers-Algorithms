package csen1002.tests.task1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task1.RegExToNfa;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task1TestsBatch2 {

	@Test
	public void testRegEx1() {
		RegExToNfa regExToNfa= new RegExToNfa("c;r#ccr*r.||");
		assertEquals("0;1;2;3;4;5;6;7;9;10;11;12;13#c;r#0,c,1;1,e,13;2,c,3;3,e,11;4,r,5;5,e,4;5,e,7;6,e,4;6,e,7;7,r,9;9,e,11;10,e,2;10,e,6;11,e,13;12,e,0;12,e,10#12#13", regExToNfa.toString());
	}

	@Test
	public void testRegEx2() {
		RegExToNfa regExToNfa= new RegExToNfa("f;g;o;s;v#gvs*|.f.o.");
		assertEquals("0;1;2;3;4;5;6;7;9;11;13#f;g;o;s;v#0,g,1;1,e,2;1,e,6;2,v,3;3,e,9;4,s,5;5,e,4;5,e,7;6,e,4;6,e,7;7,e,9;9,f,11;11,o,13#0#13", regExToNfa.toString());
	}

	@Test
	public void testRegEx3() {
		RegExToNfa regExToNfa= new RegExToNfa("n;o;x#nx*o|.**");
		assertEquals("0;1;2;3;4;5;6;7;9;10;11;12;13#n;o;x#0,n,1;1,e,4;1,e,6;2,x,3;3,e,2;3,e,5;4,e,2;4,e,5;5,e,9;6,o,7;7,e,9;9,e,0;9,e,11;10,e,0;10,e,11;11,e,10;11,e,13;12,e,10;12,e,13#12#13", regExToNfa.toString());
	}

	@Test
	public void testRegEx4() {
		RegExToNfa regExToNfa= new RegExToNfa("h;z#zz*z*.h.|");
		assertEquals("0;1;2;3;4;5;6;7;9;11;12;13#h;z#0,z,1;1,e,13;2,z,3;3,e,2;3,e,5;4,e,2;4,e,5;5,e,6;5,e,9;6,z,7;7,e,6;7,e,9;9,h,11;11,e,13;12,e,0;12,e,4#12#13", regExToNfa.toString());
	}

	@Test
	public void testRegEx5() {
		RegExToNfa regExToNfa= new RegExToNfa("i;n;o;r;w#eno||i|r|w.");
		assertEquals("0;1;2;3;4;5;6;7;8;9;10;11;12;13;14;15;16;17;19#i;n;o;r;w#0,e,1;1,e,9;2,n,3;3,e,7;4,o,5;5,e,7;6,e,2;6,e,4;7,e,9;8,e,0;8,e,6;9,e,13;10,i,11;11,e,13;12,e,8;12,e,10;13,e,17;14,r,15;15,e,17;16,e,12;16,e,14;17,w,19#16#19", regExToNfa.toString());
	}

	@Test
	public void testRegEx6() {
		RegExToNfa regExToNfa= new RegExToNfa("p;y#pyp*p..*|");
		assertEquals("0;1;2;3;4;5;7;9;10;11;12;13#p;y#0,p,1;1,e,13;2,y,3;3,e,4;3,e,7;4,p,5;5,e,4;5,e,7;7,p,9;9,e,2;9,e,11;10,e,2;10,e,11;11,e,13;12,e,0;12,e,10#12#13", regExToNfa.toString());
	}

	@Test
	public void testRegEx7() {
		RegExToNfa regExToNfa= new RegExToNfa("g;j#ej|g|*");
		assertEquals("0;1;2;3;4;5;6;7;8;9;10;11#g;j#0,e,1;1,e,5;2,j,3;3,e,5;4,e,0;4,e,2;5,e,9;6,g,7;7,e,9;8,e,4;8,e,6;9,e,8;9,e,11;10,e,8;10,e,11#10#11", regExToNfa.toString());
	}

	@Test
	public void testRegEx8() {
		RegExToNfa regExToNfa= new RegExToNfa("m;x#e**e|me||x.");
		assertEquals("0;1;2;3;4;5;6;7;8;9;10;11;12;13;14;15;16;17;19#m;x#0,e,1;1,e,0;1,e,3;2,e,0;2,e,3;3,e,2;3,e,5;4,e,2;4,e,5;5,e,9;6,e,7;7,e,9;8,e,4;8,e,6;9,e,17;10,m,11;11,e,15;12,e,13;13,e,15;14,e,10;14,e,12;15,e,17;16,e,8;16,e,14;17,x,19#16#19", regExToNfa.toString());
	}

	@Test
	public void testRegEx9() {
		RegExToNfa regExToNfa= new RegExToNfa("a;k#ka.*a|");
		assertEquals("0;1;3;4;5;6;7;8;9#a;k#0,k,1;1,a,3;3,e,0;3,e,5;4,e,0;4,e,5;5,e,9;6,a,7;7,e,9;8,e,4;8,e,6#8#9", regExToNfa.toString());
	}

	@Test
	public void testRegEx10() {
		RegExToNfa regExToNfa= new RegExToNfa("k;q;t;x#tqk.x.k|.");
		assertEquals("0;1;2;3;5;7;8;9;11#k;q;t;x#0,t,1;1,e,2;1,e,8;2,q,3;3,k,5;5,x,7;7,e,11;8,k,9;9,e,11#0#11", regExToNfa.toString());
	}

}