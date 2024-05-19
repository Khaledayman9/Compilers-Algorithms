package csen1002.main.task2;

import java.util.*;
/**
 * Write your info here
 * 
 * @name Khaled Ayman Anwar Khalil Eissa
 * @id 49-3005
 * @labNumber 21
 */

public class NfaToDfa {

	/**
	 * Constructs a DFA corresponding to an NFA
	 * 
	 * @param input A formatted string representation of the NFA for which an
	 *              equivalent DFA is to be constructed. The string representation
	 *              follows the one in the task description
	 */
	 public String statesString;
	 public String alphabetOfTheNFA;
	 public String[] alphabetArray;
	 public String transitionsString;
	 public String startState;
	 public String acceptStates;
	 public ArrayList<ArrayList<Integer>> eClosureArrayListForStates;
	 public boolean arrayChangedLastTime = true;
	 public boolean changedBoolValue = false;
	 public boolean stringChangedLastTime = true;
	 public String[] stateCharacters;
	 public int[] intArray;
	 public String[] transitionsSplitted;
	 public Set<String> allStatesEncountered;
	 public Set<String> goalStates;
	 public String initialState;
	 public Queue<String> helperStateQueue;
	 public String transitionFinalStringForDFA;
	 
	public NfaToDfa(String input) {
		String[] inputExpressionSegmentedParts = input.split("#");
		statesString = inputExpressionSegmentedParts[0];
		alphabetOfTheNFA = inputExpressionSegmentedParts[1];
		alphabetArray = alphabetOfTheNFA.split(";");
		transitionsString = inputExpressionSegmentedParts[2];
		startState = inputExpressionSegmentedParts[3];
		acceptStates = inputExpressionSegmentedParts[4];
		eClosureArrayListForStates = new ArrayList<>();
		stateCharacters = statesString.split(";");
	    intArray = new int[stateCharacters.length];
	    transitionsSplitted = transitionsString.split(";");
	    allStatesEncountered = new HashSet<>();
	    goalStates = new HashSet<>();
	    initialState = "";
	    helperStateQueue = new LinkedList<String>();
	    transitionFinalStringForDFA = "";
		initializeTheClosureArray();
		findTheEpsilonClosureForAllStates();
		buildNewDFAFromOldNFA();
	}
	
	public void initializeTheClosureArray() {
	    for (int i = 0; i < stateCharacters.length; i++) {
	        intArray[i] = Integer.parseInt(stateCharacters[i]);
	    }	    
	    for(int i = 0;i < stateCharacters.length;i++) {
	    	ArrayList<Integer> temp = new ArrayList<>();
	    	temp.add(intArray[i]);
	        eClosureArrayListForStates.add(intArray[i], temp);
	    }
	    String[] tempArrayForEveryTransition;
	    for(int i = 0 ;i < intArray.length; i++) {
	    	for(int j = 0; j < transitionsSplitted.length;j++) {
	    		tempArrayForEveryTransition = transitionsSplitted[j].split(",");
	    		if(Integer.parseInt(tempArrayForEveryTransition[0]) == intArray[i] && tempArrayForEveryTransition[1].charAt(0) == 'e') {
	    		    ArrayList<Integer> temp = eClosureArrayListForStates.get(intArray[i]);
	    		    if(!temp.contains(Integer.parseInt(tempArrayForEveryTransition[2]))) {
	    		    	temp.add(Integer.parseInt(tempArrayForEveryTransition[2]));
		    		    eClosureArrayListForStates.remove(intArray[i]);
		    		    eClosureArrayListForStates.add(intArray[i], temp);
	    		    }
	    		}
	    	}
	    }
	}
	
	public void findTheEpsilonClosureForAllStates() {
		 while(arrayChangedLastTime){
			 arrayChangedLastTime = false;
			 for(int i = 0; i < intArray.length;i++) {
				 ArrayList<Integer> temp = eClosureArrayListForStates.get(intArray[i]);
				 for(int j = 0; j < temp.size();j++) {
					 if(temp.get(j) != intArray[i]) {
						 ArrayList<Integer> temp2 = eClosureArrayListForStates.get(temp.get(j));
						 moveAndSortTwoArrays(temp,temp2);
						 eClosureArrayListForStates.set(intArray[i], temp);
					 }
				 }
			 }
		 }
	}
	
	public void moveAndSortTwoArrays(ArrayList<Integer> temp1, ArrayList<Integer> temp2) {
	        for (Integer stateElement : temp2) {
	            if (!temp1.contains(stateElement)) {
	                temp1.add(stateElement);
	                if(!changedBoolValue && !arrayChangedLastTime) {
	                	arrayChangedLastTime = true;
	                	changedBoolValue = true;
	                }
	            }
	        }
	        Collections.sort(temp1);
	}
	
	public String buildAnyDFATransitionString(int k) {
		String stateString = "";
		for(int i = 0; i < eClosureArrayListForStates.get(intArray[k]).size() ; i++) {
			if(i != eClosureArrayListForStates.get(intArray[k]).size()-1) {
				stateString += eClosureArrayListForStates.get(intArray[k]).get(i) + "/";
			}
			else {
				stateString += eClosureArrayListForStates.get(intArray[k]).get(i);
			}
		}
		return stateString;
	}
	
	public String removeDuplicatesForNewBuiltTransitionString(String duplicatedString) {
		String uniqueString = "";
		String[] numbers = duplicatedString.split("/");
		List<Integer> uniqueNumbers = new ArrayList<>();
		for(String integerCharacter: numbers) {
			int num = Integer.parseInt(integerCharacter);
            if (!uniqueNumbers.contains(num)) {
                uniqueNumbers.add(num);
            }
		}
        for (int i = 0; i < uniqueNumbers.size(); i++) {
        	uniqueString += uniqueNumbers.get(i);
            if (i < uniqueNumbers.size() - 1) {
            	uniqueString += "/";
            }
        }
        return uniqueString;
    }
	
	public String sortNewBuiltStateString(String unsortedString) {
		String sortedString = "";
		String[] numbers = unsortedString.split("/");
        int[] intArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            intArray[i] = Integer.parseInt(numbers[i]);
        }
        Arrays.sort(intArray);
        for (int i = 0; i < intArray.length; i++) {
        	sortedString += intArray[i];
            if (i < intArray.length - 1) {
            	sortedString += "/";
            }
        }
        return sortedString;
	}
	public void checkIfCurrentStateIsGoalState(String currentState) {
		String[] currentStateNumbers = currentState.split("/");
		String[] acceptStatesSplitted = acceptStates.split(";");
		for(int i = 0; i < currentStateNumbers.length ;i++) {
			for(int j = 0; j < acceptStatesSplitted.length ;j++) {
			    if(Integer.parseInt(currentStateNumbers[i]) == Integer.parseInt(acceptStatesSplitted[j])) {
			    	goalStates.add(currentState);
			    	break;
			    }
			}
		}
	}
	public void reverseArrayOfAlphabet(String[] alphabetArray) {
		for(int i = 0; i <alphabetArray.length/2;i++) {
			String temp = alphabetArray[i];
			alphabetArray[i] = alphabetArray[alphabetArray.length-i-1];
			alphabetArray[alphabetArray.length-i-1] = temp;
		}
	}
	
	public void buildNewDFAFromOldNFA() {
		initialState = buildAnyDFATransitionString(Integer.parseInt(startState));
		allStatesEncountered.add(buildAnyDFATransitionString(Integer.parseInt(startState)));
		helperStateQueue.add(buildAnyDFATransitionString(Integer.parseInt(startState)));
		String currentState = "";
		String newState = "";
		String[] currentStateNumbers;
		String[] examineSingleNumbers;
		boolean negativeStateFlag = false;
		while(!helperStateQueue.isEmpty()) {
			currentState = helperStateQueue.remove();
			checkIfCurrentStateIsGoalState(currentState);
			currentStateNumbers = currentState.split("/");
			for(int k = 0; k < alphabetArray.length; k++) { 
			  newState = ""; 
			  for(int i = 0; i < currentStateNumbers.length; i++) { 
				for(int j = 0; j < transitionsSplitted.length; j++) {
					examineSingleNumbers = transitionsSplitted[j].split(",");
					if(Integer.parseInt(currentStateNumbers[i]) == Integer.parseInt(examineSingleNumbers[0]) 
							&& alphabetArray[k].charAt(0) == examineSingleNumbers[1].charAt(0)) {
						if(newState != "") {
							newState += "/" + buildAnyDFATransitionString(Integer.parseInt(examineSingleNumbers[2]));
						}
						else {
							newState += buildAnyDFATransitionString(Integer.parseInt(examineSingleNumbers[2]));
						}
						newState = removeDuplicatesForNewBuiltTransitionString(sortNewBuiltStateString(newState));
				 }
			   }
			 }
			  if(newState != "") {
				  transitionFinalStringForDFA += currentState + "," + alphabetArray[k].charAt(0) + "," + newState + ";";
				  if(!helperStateQueue.contains(newState) && !allStatesEncountered.contains(newState) &&  currentState != newState) {
					  helperStateQueue.add(newState);
				  }
			  }
			  else {				  
				  newState = "-1";	
				  negativeStateFlag = true;
				  transitionFinalStringForDFA +=  currentState + "," + alphabetArray[k].charAt(0) + "," + newState + ";" ;
			  }
			  if(!allStatesEncountered.contains(newState)) {
				  allStatesEncountered.add(newState);
			  }
		  }
		}
		if(negativeStateFlag) {
			reverseArrayOfAlphabet(alphabetArray);
			for(int p = 0; p < alphabetArray.length;p++) {
				transitionFinalStringForDFA =  "-1" + "," + alphabetArray[p].charAt(0) + "," + "-1"+';' + transitionFinalStringForDFA;
			}
		}
	}
	
	public String sortStatessString() {
		String statesStringForDFA = "";
		statesStringForDFA += (String.join(";", allStatesEncountered.stream().toArray(String[]::new)));
		String[] transitionStringArray = statesStringForDFA.split(";");
        for (int i = 0; i < transitionStringArray.length - 1; i++) {
            for (int j = 0; j < transitionStringArray.length - i - 1; j++) {
                if (numberComparisonBetweenStates(transitionStringArray[j],transitionStringArray[j + 1]) > 0) {
                    String temp = transitionStringArray[j];
                    transitionStringArray[j] = transitionStringArray[j + 1];
                    transitionStringArray[j + 1] = temp;
                }
            }
        }
        statesStringForDFA = "";
        for (int i = 0; i < transitionStringArray.length - 1; i++) {
        	statesStringForDFA += transitionStringArray[i] + ";";
        }
        statesStringForDFA += (transitionStringArray[transitionStringArray.length - 1]);
        return statesStringForDFA;
	}
	
	public String sortFinalDFATransitionsString() {
		String transitionsStringForDFA = "";
		String[] transitionsArrayForDFA = transitionFinalStringForDFA.split(";");
		 for (int i = 0; i < transitionsArrayForDFA.length - 1; i++) {
	            for (int j = 0; j < transitionsArrayForDFA.length - i - 1; j++) {
	                if (numberComparisonBetweenTransitions(transitionsArrayForDFA[j],transitionsArrayForDFA[j + 1]) > 0) {
	                    String temp = transitionsArrayForDFA[j];
	                    transitionsArrayForDFA[j] = transitionsArrayForDFA[j + 1];
	                    transitionsArrayForDFA[j + 1] = temp;
	                }
	           }
	     }
		 for (int i = 0; i < transitionsArrayForDFA.length - 1; i++) {
			 transitionsStringForDFA += transitionsArrayForDFA[i] + ";";
	        }
		 transitionsStringForDFA += (transitionsArrayForDFA[transitionsArrayForDFA.length -1]);
	     return transitionsStringForDFA;
	}
	
	public int numberComparisonBetweenTransitions(String transition1, String transition2) {
		String[] transition1Array = transition1.split(",");
		String[] transition2Array = transition2.split(",");
		int comparisonStateNumber = numberComparisonBetweenStates(transition1Array[0], transition2Array[0]); 
		int finalComparisonNumber = 0;
		if(comparisonStateNumber == 1) {
			finalComparisonNumber = 1;
		}
		else if(comparisonStateNumber == 0 && transition1Array[0].length() != transition2Array[0].length()) {
			if(transition1Array[0].length() > transition2Array[0].length()) {
				finalComparisonNumber = 1;
			}
			else {
				finalComparisonNumber = -1;
			}
		}
		else if(comparisonStateNumber == 0 && transition1Array[0].length() == transition2Array[0].length()) {
			comparisonStateNumber = transition1Array[1].compareTo(transition2Array[1]);
			if(comparisonStateNumber < 0) {
				finalComparisonNumber = -1;
			}
			else if(comparisonStateNumber > 0) {
				finalComparisonNumber = 1;
			}
			else {
				comparisonStateNumber = numberComparisonBetweenStates(transition1Array[2], transition2Array[2]);
				if(comparisonStateNumber == 1) {
					finalComparisonNumber = 1;
				}
				else {
					finalComparisonNumber = -1;
				}
			}
		}
		else if(comparisonStateNumber == -1){
			finalComparisonNumber = -1;
		}
		return finalComparisonNumber;
	}
		
	public int numberComparisonBetweenStates(String num1, String num2) {
        if (!num1.contains("/") && !num2.contains("/")) {
            return Integer.compare(Integer.parseInt(num1), Integer.parseInt(num2));
        } else if (!num1.contains("/")) {
            int firstNum2 = Integer.parseInt(num2.split("/")[0]);
            return Integer.compare(Integer.parseInt(num1), firstNum2);
        } else if (!num2.contains("/")) {
            int firstNum1 = Integer.parseInt(num1.split("/")[0]);
            return Integer.compare(firstNum1, Integer.parseInt(num2));
        } else {
            String[] parts1 = num1.split("/");
            String[] parts2 = num2.split("/");
            int minLength = Math.min(parts1.length, parts2.length);
            for (int i = 0; i < minLength; i++) {
                int num1Value = Integer.parseInt(parts1[i]);
                int num2Value = Integer.parseInt(parts2[i]);
                if (num1Value != num2Value) {
                    return Integer.compare(num1Value, num2Value);
                }
            }
            return Integer.compare(parts1.length, parts2.length);
        }
    }
	

	public String prepareFinalOutputString() {
    	String DFAStringFinalOutputResult = "";
    	DFAStringFinalOutputResult += sortStatessString() + "#";
    	DFAStringFinalOutputResult += alphabetOfTheNFA + "#";
		DFAStringFinalOutputResult += sortFinalDFATransitionsString() + "#";
		DFAStringFinalOutputResult += initialState + "#";
		DFAStringFinalOutputResult += (String.join(";", goalStates.stream().sorted().map(String::valueOf).toArray(String[]::new)));
		return DFAStringFinalOutputResult;
    }
	
	@Override
	public String toString() {
		return prepareFinalOutputString();
	}

}
