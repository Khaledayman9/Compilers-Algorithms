package csen1002.main.task1;

import java.util.*;
/**
 * Write your info here
 * 
 * @name Khaled Ayman Anwar Khalil Eissa
 * @id 49-3005
 * @labNumber 21
 */

public class RegExToNfa {

	/**
	 * Constructs an NFA corresponding to a regular expression based on Thompson's
	 * construction
	 * 
	 * @param input The alphabet and the regular expression in postfix notation for
	 *              which the NFA is to be constructed
	 */
	public String alphabetOfTheRegularExpression;
	public String regularExpressionGiven;
	public Set<Integer> allStatesEncountered;
	public int initialStateFinal;
	public int acceptStateFinal;
	public String transitionFinalStringForNFA;

	public RegExToNfa(String input) {
		// TODO Auto-generated constructor stub
		String[] inputExpressionSegmentedParts = input.split("#");
		alphabetOfTheRegularExpression = inputExpressionSegmentedParts[0];
        regularExpressionGiven = inputExpressionSegmentedParts[1];
        allStatesEncountered = new HashSet<>();
        initialStateFinal = 0;
        acceptStateFinal = 0;
        transitionFinalStringForNFA = "";
        buildANewNFAFromScratch();
	}

	
	public void conductTheStarOperation(int oldStartState, int oldAcceptState, int newStartState, int newAcceptState, Stack<Integer> stackForTheThompsonAlgorithm) {
		transitionFinalStringForNFA = transitionFinalStringForNFA + newStartState + ",e,"+ oldStartState +";";
		transitionFinalStringForNFA = transitionFinalStringForNFA + oldAcceptState + ",e,"+ newAcceptState +";";
		transitionFinalStringForNFA = transitionFinalStringForNFA + oldAcceptState + ",e,"+ oldStartState +";";
		transitionFinalStringForNFA = transitionFinalStringForNFA + newStartState + ",e,"+ newAcceptState +";";
        allStatesEncountered.add(newStartState);
        allStatesEncountered.add(newAcceptState);
        initialStateFinal = newStartState;
        stackForTheThompsonAlgorithm.push(newStartState);
        stackForTheThompsonAlgorithm.push(newAcceptState);
	}
	
	public void conductTheConcatenationOperation(int firstStartState, int firstAcceptState,int lastStartState, int lastAcceptState, Stack<Integer> stackForTheThompsonAlgorithm) {
		transitionFinalStringForNFA = transitionFinalStringForNFA.replace(lastStartState+"", firstAcceptState+"");
		allStatesEncountered.remove(lastStartState);
		initialStateFinal = firstStartState;
        allStatesEncountered.add(firstStartState);
        allStatesEncountered.add(lastAcceptState);
        stackForTheThompsonAlgorithm.push(firstStartState);
        stackForTheThompsonAlgorithm.push(lastAcceptState);
	}
	
	public void conductTheUnionOperation(int firstStartState, int firstAcceptState,int lastStartState, int lastAcceptState,int newStartState, int newAcceptState, Stack<Integer> stackForTheThompsonAlgorithm) {
		transitionFinalStringForNFA =transitionFinalStringForNFA + newStartState + ",e,"+ firstStartState +";";
		transitionFinalStringForNFA = transitionFinalStringForNFA + newStartState + ",e,"+ lastStartState +";";
		transitionFinalStringForNFA = transitionFinalStringForNFA + firstAcceptState + ",e,"+ newAcceptState +";";
		transitionFinalStringForNFA = transitionFinalStringForNFA + lastAcceptState + ",e,"+ newAcceptState +";";
        allStatesEncountered.add(newStartState);
        allStatesEncountered.add(newAcceptState);
        initialStateFinal = newStartState;
        stackForTheThompsonAlgorithm.push(newStartState);
        stackForTheThompsonAlgorithm.push(newAcceptState);
	}
	
	public void conductAddingTheAlphabetCharacter(int newStartState, int newAcceptState, char alphabetInsertedChar, Stack<Integer> stackForTheThompsonAlgorithm) {
		transitionFinalStringForNFA = transitionFinalStringForNFA + newStartState + ","+alphabetInsertedChar+","+ newAcceptState +";";
        allStatesEncountered.add(newStartState);
        allStatesEncountered.add(newAcceptState);
        stackForTheThompsonAlgorithm.push(newStartState);
        stackForTheThompsonAlgorithm.push(newAcceptState);
	}
	
	public void buildANewNFAFromScratch() {
	    Stack<Integer> stackForTheThompsonAlgorithm = new Stack<>();
	    int stateCounter = 0;
	    int oldAcceptState = 0;
	    int oldStartState = 0;
	    int newStartState = 0;
	    int newAcceptState = 0;
	    int lastAcceptState = 0;
	    int lastStartState = 0;
	    int firstAcceptState = 0;
	    int firstStartState = 0;
	    for (char c : regularExpressionGiven.toCharArray()) {
	    	 if (c == '*') { 
	        	oldAcceptState = stackForTheThompsonAlgorithm.pop();
	            oldStartState = stackForTheThompsonAlgorithm.pop();
	            newStartState = stateCounter++;
	            newAcceptState = stateCounter++;
	            conductTheStarOperation(oldStartState,oldAcceptState,newStartState,newAcceptState,stackForTheThompsonAlgorithm);
	        } else if (c == '.') { 
	        	lastAcceptState = stackForTheThompsonAlgorithm.pop();
	            lastStartState = stackForTheThompsonAlgorithm.pop();
	            firstAcceptState = stackForTheThompsonAlgorithm.pop();
	            firstStartState = stackForTheThompsonAlgorithm.pop();
	            conductTheConcatenationOperation(firstStartState, firstAcceptState, lastStartState, lastAcceptState, stackForTheThompsonAlgorithm);
	        } else if (c == '|') { 
	        	lastAcceptState = stackForTheThompsonAlgorithm.pop();
	            lastStartState = stackForTheThompsonAlgorithm.pop();
	            firstAcceptState = stackForTheThompsonAlgorithm.pop();
	            firstStartState = stackForTheThompsonAlgorithm.pop();
	            newStartState = stateCounter++;
	            newAcceptState = stateCounter++;
	            conductTheUnionOperation(firstStartState, firstAcceptState, lastStartState, lastAcceptState, newStartState, newAcceptState, stackForTheThompsonAlgorithm);
	        } else {
	            newStartState = stateCounter++;
	            newAcceptState = stateCounter++;
	            conductAddingTheAlphabetCharacter(newStartState,newAcceptState,c,stackForTheThompsonAlgorithm);
	        }
	    }
	    acceptStateFinal = stackForTheThompsonAlgorithm.pop();
	}

    public String prepareFinalOutputString() {
    	String NFAStringFinalOutputResult = "";
		NFAStringFinalOutputResult += (String.join(";", allStatesEncountered.stream().sorted().map(String::valueOf).toArray(String[]::new))) + "#";
		NFAStringFinalOutputResult += alphabetOfTheRegularExpression + "#";
		String[] transitions = transitionFinalStringForNFA.toString().split(";");
		Arrays.sort(transitions, Comparator
		            .comparing((String s) -> Integer.parseInt(s.split(",")[0]))
		            .thenComparing((String s) -> Integer.parseInt(s.split(",")[2]))
		            .thenComparing((String s) -> s.split(",")[1]));
		NFAStringFinalOutputResult += (String.join(";", transitions)) + "#";
		NFAStringFinalOutputResult += initialStateFinal + "#";
		NFAStringFinalOutputResult += acceptStateFinal;
		return NFAStringFinalOutputResult;
    }

	public String toString() {
		return prepareFinalOutputString();
	}
}
