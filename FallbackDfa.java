package csen1002.main.task3;

import java.util.*;
/**
 * Write your info here
 * 
 * @name Khaled Ayman Anwar Khalil Eissa
 * @id 49-3005
 * @labNumber 21
 */

public class FallbackDfa {

	/**
	 * Constructs a Fallback DFA
	 * 
	 * @param fdfa A formatted string representation of the Fallback DFA. The string
	 *             representation follows the one in the task description
	 */
	public String finalTokensString;
	public int counterLForStack;
	public int counterRForStack;
	public int currentStateNumber;
	public int nextStateNumber;
	public int headOfTheFallBackDFA;
	Stack<Integer> stackForTheFallbackDFAAlgorithm;
	public String[] transitionDFAStringForAllStates;
	public String[] acceptStatesNumbers; 
	public String startStateNumber;
	public boolean activateAlgorithm;
	public boolean reachedEndOfString;
	public boolean gotHeadOfTheStack;
	
	public FallbackDfa(String fdfa) {
		String[] splittedDFAString = fdfa.split("#");
		transitionDFAStringForAllStates = splittedDFAString[2].split(";");
		acceptStatesNumbers = splittedDFAString[4].split(";");
		startStateNumber = splittedDFAString[3];
		finalTokensString = "";
		counterLForStack = 0;
		counterRForStack = 0;
		currentStateNumber = 0;
		nextStateNumber = 0;
		headOfTheFallBackDFA = 0;
		stackForTheFallbackDFAAlgorithm = new Stack<>();
		activateAlgorithm = true;
		reachedEndOfString = false;
	}
	
	
	public int findNextTransition(char charToCheck, int currentStateNumber) {
		String[] currentTransitionString;
		int newStateNumber = 0;
		for(int i = 0; i < transitionDFAStringForAllStates.length; i++) {
			currentTransitionString = transitionDFAStringForAllStates[i].split(",");
			if(Integer.parseInt(currentTransitionString[0]) == currentStateNumber && charToCheck == currentTransitionString[1].charAt(0)) {
				newStateNumber = Integer.parseInt(currentTransitionString[2]);
				break;
			}
		}
		return newStateNumber;
	}

	public boolean checkIfStateNumIsAccept(int stateNumberToCheck) {
		boolean isAcceptState = false;
		for(int i = 0; i < acceptStatesNumbers.length; i++) {
			if(stateNumberToCheck == Integer.parseInt(acceptStatesNumbers[i])) {
				isAcceptState = true;
				break;
			}
		}
		return isAcceptState;
	}
	
	public String run(String input) {
		char currentChar;
		int numToCheck;
		nextStateNumber = Integer.parseInt(startStateNumber);
		while(activateAlgorithm) {
			 if(counterLForStack == input.length() && !reachedEndOfString) {
				 stackForTheFallbackDFAAlgorithm.push(nextStateNumber);
				 reachedEndOfString = true;
			 }
			 if(counterLForStack != input.length() && !reachedEndOfString) {
				 currentStateNumber = nextStateNumber;
			     currentChar = input.charAt(counterLForStack);
			     stackForTheFallbackDFAAlgorithm.push(currentStateNumber);
			     nextStateNumber = findNextTransition(currentChar, currentStateNumber);
			     counterLForStack++;
			 }
			 else if(counterLForStack != -1 && reachedEndOfString) {
				 if(!gotHeadOfTheStack) {
					 headOfTheFallBackDFA = stackForTheFallbackDFAAlgorithm.peek();
					 gotHeadOfTheStack = true;
				 }
				 if(stackForTheFallbackDFAAlgorithm.isEmpty()) {
					 activateAlgorithm = false;
					 finalTokensString += input.substring(counterLForStack+1, input.length()) + ","+ headOfTheFallBackDFA + ";";
				 }
				 else {
					 numToCheck = stackForTheFallbackDFAAlgorithm.pop();
					 counterLForStack--;
					 if(checkIfStateNumIsAccept(numToCheck)) {
						 finalTokensString += input.substring(counterRForStack, counterLForStack+1) + "," + numToCheck + ";";
						 if(counterLForStack == (input.length()-1)) {
							 activateAlgorithm = false;
						 }
						 else {
							 counterLForStack++;
							 counterRForStack = counterLForStack;
							 if(!stackForTheFallbackDFAAlgorithm.isEmpty()) {
								 stackForTheFallbackDFAAlgorithm.removeAllElements();
							 }
							 nextStateNumber = Integer.parseInt(startStateNumber);
							 reachedEndOfString = false;
							 gotHeadOfTheStack = false;
						 }
					 }
				 }
			 }
			 else if(counterLForStack == -1) {
				 finalTokensString += input + ","+ headOfTheFallBackDFA + ";";
				 activateAlgorithm = false;
			 }
		}
		return finalTokensString.substring(0,finalTokensString.length()-1);
	}
	
}
