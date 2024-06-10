package csen1002.tests.task7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task7.Task7Lexer;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task7TestsBatch0{
	
	/**
	 * Returns a string of tokenized lexemes.
	 *
	 * @param input is the string to be tokenized.
	 * @return Returns a formatted string representation of the list of tokens. The
	 *         string representation follows the one in the task description
	 */
	public static String tokenStream(String input) {
		// In case Task7Lexer is not defined correctly:
		// 1- If you modified the grammar in the g4 file, regenerate the ANTLR
		// recognizer to make sure that the latest grammar is generated
		// 2- Make sure that the location and the package are configured properly
		Task7Lexer lexer = new Task7Lexer(CharStreams.fromString(input));
		Vocabulary vocabulary = lexer.getVocabulary();
		List<? extends Token> tokens = lexer.getAllTokens();
		StringJoiner stringJoiner = new StringJoiner(";");
		for (Token token : tokens) {
			stringJoiner.add(token.getText() + "," + vocabulary.getSymbolicName(token.getType()));
		}
		return stringJoiner.toString();
	}


	@Test
	public void testString1() {
		assertEquals("101,ZERO;110,ZERO;100,ZERO;010,ZERO;001,ZERO;000,ONE;001,ZERO;111,ONE;111,ONE;011,ONE;101,ZERO;111,ONE;011,ONE;000,ONE;111,ONE;101,ZERO;000,ONE;111,ONE;000,ONE;110,ZERO;110,ZERO;001,ZERO;001,ZERO;110,ZERO;100,ZERO;010,ZERO;110,ZERO;001,ZERO;000,ONE;100,ZERO;111,ONE;100,ZERO;000,ONE;000,ONE;110,ZERO;001,ZERO;110,ZERO;100,ZERO;011,ONE;110,ZERO;100,ZERO;001,ZERO;100,ZERO;011,ONE;101,ZERO;010,ZERO;101,ZERO;110,ZERO;111,ONE;100,ZERO;010,ZERO;011,ONE;011,ONE;011,ONE;000,ONE;110,ZERO;110,ZERO;101,ZERO;010,ZERO;010,ZERO;000,ONE;011,ONE;101,ZERO;100,ZERO;111,ONE;111,ONE;010,ZERO;100,ZERO;001,ZERO;000,ONE;100,ZERO;010,ZERO;100,ZERO;011,ONE;010,ZERO;001,ZERO;111,ONE;001,ZERO;101,ZERO;000,ONE;000,ONE;000,ONE;000,ONE;011,ONE;111,ONE;111,ONE;110,ZERO;101,ZERO;010,ZERO;010,ZERO;010,ZERO;110,ZERO;011,ONE;110,ZERO;011,ONE;101,ZERO;100,ZERO;111,ONE;000,ONE;000,ONE;110,ZERO;001,ZERO;110,ZERO;011,ONE;011,ONE;111,ONE;000,ONE;011,ONE;000,ONE;001,ZERO;001,ZERO;101,ZERO;100,ZERO;010,ZERO;000,ONE;0,ERROR", 
        tokenStream("1011101000100010000011111110111011110110001111010001110001101100010011101000101100010001001111000000001100011101000111101000011000111010101011101111000100110110110001101101010100100000111011001111110101000010001000101000110100011110011010000000000000111111111101010100100101100111100111011001110000001100011100110111110000110000010011011000100000"));
	}

	@Test
	public void testString2() {
		assertEquals("110,ZERO;000,ONE;011,ONE;100,ZERO;011,ONE;001,ZERO;001,ZERO;101,ZERO;001,ZERO;010,ZERO;000,ONE;011,ONE;001,ZERO;010,ZERO;011,ONE;011,ONE;001,ZERO;101,ZERO;101,ZERO;111,ONE;010,ZERO;010,ZERO;110,ZERO;010,ZERO;011,ONE;011,ONE;011,ONE;110,ZERO;100,ZERO;001,ZERO;001,ZERO;111,ONE;111,ONE;110,ZERO;000,ONE;011,ONE", 
        tokenStream("110000011100011001001101001010000011001010011011001101101111010010110010011011011110100001001111111110000011"));
	}

	@Test
	public void testString3() {
		assertEquals("010,ZERO;000,ONE;101,ZERO;000,ONE;010,ZERO;100,ZERO;110,ZERO;100,ZERO;001,ZERO;010,ZERO;000,ONE;110,ZERO;000,ONE;000,ONE;010,ZERO;101,ZERO;000,ONE;100,ZERO;000,ONE;101,ZERO;101,ZERO;110,ZERO;011,ONE;111,ONE;101,ZERO;101,ZERO;011,ONE;110,ZERO;011,ONE;001,ZERO;010,ZERO;101,ZERO;100,ZERO;110,ZERO;011,ONE;110,ZERO;010,ZERO;000,ONE;101,ZERO;000,ONE;100,ZERO;001,ZERO;011,ONE;110,ZERO;011,ONE;011,ONE;011,ONE;011,ONE;000,ONE;110,ZERO;011,ONE;111,ONE;101,ZERO;001,ZERO;001,ZERO;110,ZERO;011,ONE;100,ZERO;11,ERROR", 
        tokenStream("01000010100001010011010000101000011000000001010100010000010110111001111110110101111001100101010110011001111001000010100010000101111001101101101100011001111110100100111001110011"));
	}

	@Test
	public void testString4() {
		assertEquals("110,ZERO;010,ZERO;111,ONE;010,ZERO;011,ONE;111,ONE;001,ZERO;100,ZERO;101,ZERO;110,ZERO;000,ONE;110,ZERO;111,ONE;010,ZERO;010,ZERO;011,ONE;011,ONE;111,ONE;001,ZERO;111,ONE;011,ONE;111,ONE;000,ONE;110,ZERO;101,ZERO;001,ZERO;000,ONE;110,ZERO;110,ZERO;101,ZERO;101,ZERO;111,ONE;110,ZERO;111,ONE;100,ZERO;100,ZERO;101,ZERO;000,ONE;111,ONE;011,ONE;101,ZERO;101,ZERO;111,ONE;111,ONE;010,ZERO;100,ZERO;001,ZERO;010,ZERO;011,ONE;011,ONE;100,ZERO;100,ZERO;010,ZERO;101,ZERO;11,ERROR", 
        tokenStream("11001011101001111100110010111000011011101001001101111100111101111100011010100100011011010110111111011110010010100011101110110111111101010000101001101110010001010111"));
	}

	@Test
	public void testString5() {
		assertEquals("0,ERROR", 
        tokenStream("0"));
	}

	@Test
	public void testString6() {
		assertEquals("101,ZERO;111,ONE;010,ZERO;011,ONE;011,ONE;011,ONE;100,ZERO;101,ZERO;101,ZERO;001,ZERO;110,ZERO;010,ZERO;001,ZERO;011,ONE;100,ZERO;101,ZERO;101,ZERO;010,ZERO;010,ZERO;000,ONE;001,ZERO;110,ZERO;001,ZERO;010,ZERO;100,ZERO;010,ZERO;111,ONE;011,ONE;000,ONE;100,ZERO;011,ONE;001,ZERO;100,ZERO;111,ONE;110,ZERO;100,ZERO;110,ZERO;101,ZERO;001,ZERO;110,ZERO;111,ONE;010,ZERO;100,ZERO;100,ZERO;101,ZERO;110,ZERO;110,ZERO;000,ONE;101,ZERO;010,ZERO;010,ZERO;100,ZERO;000,ONE;101,ZERO;101,ZERO;001,ZERO;100,ZERO;110,ZERO;100,ZERO;001,ZERO;000,ONE;010,ZERO;011,ONE;110,ZERO;000,ONE;101,ZERO;011,ONE;101,ZERO;010,ZERO;011,ONE;110,ZERO;011,ONE;110,ZERO;001,ZERO;110,ZERO;011,ONE;011,ONE;001,ZERO;010,ZERO;110,ZERO;000,ONE;100,ZERO;011,ONE;111,ONE;011,ONE;111,ONE;110,ZERO;111,ONE;111,ONE;001,ZERO;111,ONE;010,ZERO;111,ONE;010,ZERO;100,ZERO;010,ZERO;111,ONE;101,ZERO;111,ONE;011,ONE;011,ONE;001,ZERO;010,ZERO", 
        tokenStream("101111010011011011100101101001110010001011100101101010010000001110001010100010111011000100011001100111110100110101001110111010100100101110110000101010010100000101101001100110100001000010011110000101011101010011110011110001110011011001010110000100011111011111110111111001111010111010100010111101111011011001010"));
	}

	@Test
	public void testString7() {
		assertEquals("110,ZERO;111,ONE;111,ONE;110,ZERO;001,ZERO;100,ZERO;000,ONE;101,ZERO;110,ZERO;110,ZERO;000,ONE;101,ZERO;110,ZERO;101,ZERO;100,ZERO;011,ONE;010,ZERO;101,ZERO;100,ZERO;100,ZERO;010,ZERO;110,ZERO;110,ZERO;110,ZERO;101,ZERO;011,ONE;001,ZERO;100,ZERO;010,ZERO;001,ZERO;111,ONE;101,ZERO;101,ZERO;011,ONE;110,ZERO;110,ZERO;110,ZERO;010,ZERO;000,ONE;111,ONE;101,ZERO;000,ONE;000,ONE;000,ONE;001,ZERO;001,ZERO;100,ZERO;110,ZERO;001,ZERO;101,ZERO;101,ZERO;010,ZERO;010,ZERO;001,ZERO;011,ONE;110,ZERO;011,ONE;100,ZERO;110,ZERO;010,ZERO;010,ZERO;100,ZERO;101,ZERO;1,ERROR", 
        tokenStream("1101111111100011000001011101100001011101011000110101011001000101101101101010110011000100011111011010111101101100100001111010000000000010011001100011011010100100010111100111001100100101001011"));
	}

	@Test
	public void testString8() {
		assertEquals("001,ZERO;110,ZERO;111,ONE;000,ONE;100,ZERO;001,ZERO;001,ZERO;000,ONE;101,ZERO;100,ZERO;000,ONE;011,ONE;001,ZERO;001,ZERO;000,ONE;001,ZERO;010,ZERO;000,ONE;000,ONE;010,ZERO;011,ONE;000,ONE;111,ONE;111,ONE;110,ZERO;110,ZERO;000,ONE;110,ZERO;011,ONE;011,ONE;001,ZERO;010,ZERO;110,ZERO;111,ONE;011,ONE;011,ONE;101,ZERO;100,ZERO;111,ONE;000,ONE;100,ZERO", 
        tokenStream("001110111000100001001000101100000011001001000001010000000010011000111111110110000110011011001010110111011011101100111000100"));
	}

	@Test
	public void testString9() {
		assertEquals("001,ZERO;101,ZERO;111,ONE;110,ZERO;111,ONE;011,ONE;101,ZERO;110,ZERO;101,ZERO;111,ONE;000,ONE;110,ZERO;101,ZERO;100,ZERO;101,ZERO;001,ZERO;100,ZERO;011,ONE;110,ZERO;110,ZERO;011,ONE;010,ZERO;111,ONE;000,ONE;110,ZERO;110,ZERO;001,ZERO;101,ZERO;000,ONE;111,ONE;101,ZERO;111,ONE;001,ZERO;101,ZERO;011,ONE;001,ZERO;100,ZERO;001,ZERO;010,ZERO;100,ZERO;101,ZERO;000,ONE;000,ONE;110,ZERO;101,ZERO;110,ZERO;010,ZERO;101,ZERO;110,ZERO;110,ZERO;011,ONE;000,ONE;100,ZERO;010,ZERO;000,ONE;100,ZERO;000,ONE;000,ONE;001,ZERO;110,ZERO;000,ONE;011,ONE;011,ONE;100,ZERO;011,ONE;010,ZERO;001,ZERO;010,ZERO;001,ZERO;000,ONE;000,ONE;111,ONE;111,ONE;101,ZERO;001,ZERO;011,ONE;011,ONE;110,ZERO;001,ZERO;010,ZERO;101,ZERO;111,ONE;101,ZERO;101,ZERO;101,ZERO;010,ZERO;111,ONE;011,ONE;110,ZERO;010,ZERO;111,ONE;101,ZERO;111,ONE;001,ZERO;001,ZERO;010,ZERO;000,ONE;011,ONE;100,ZERO;010,ZERO;011,ONE;001,ZERO;010,ZERO;100,ZERO;100,ZERO;001,ZERO;000,ONE;111,ONE;000,ONE;100,ZERO;100,ZERO;100,ZERO;101,ZERO;000,ONE;100,ZERO;011,ONE;110,ZERO;001,ZERO;010,ZERO;111,ONE;001,ZERO;101,ZERO;101,ZERO;110,ZERO;000,ONE;011,ONE;011,ONE;001,ZERO;000,ONE;111,ONE;010,ZERO;101,ZERO;100,ZERO;010,ZERO", 
        tokenStream("001101111110111011101110101111000110101100101001100011110110011010111000110110001101000111101111001101011001100001010100101000000110101110010101110110011000100010000100000000001110000011011100011010001010001000000111111101001011011110001010101111101101101010111011110010111101111001001010000011100010011001010100100001000111000100100100101000100011110001010111001101101110000011011001000111010101100010"));
	}

	@Test
	public void testString10() {
		assertEquals("011,ONE;011,ONE;111,ONE;001,ZERO;101,ZERO;101,ZERO;011,ONE;000,ONE;010,ZERO;011,ONE;011,ONE;011,ONE;011,ONE;111,ONE;110,ZERO;110,ZERO;001,ZERO;000,ONE;001,ZERO;011,ONE;101,ZERO;010,ZERO;101,ZERO;011,ONE;010,ZERO;101,ZERO;011,ONE;000,ONE;111,ONE;011,ONE;011,ONE;111,ONE;000,ONE;010,ZERO;111,ONE;0,ERROR", 
        tokenStream("0110111110011011010110000100110110110111111101100010000010111010101010110101010110001110110111110000101110"));
	}

}