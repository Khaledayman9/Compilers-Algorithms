package csen1002.main.task8;

import java.util.*;

/**
 * Write your info here
 * 
 * @name Khaled Ayman Anwar Khalil Eissa
 * @id 49-3005
 * @labNumber 21
 */

public class CfgLl1Parser {

	/**
	 * Constructs a Context Free Grammar
	 * 
	 * @param cfg A formatted string representation of the CFG, the First sets of
	 *            each right-hand side, and the Follow sets of each variable. The
	 *            string representation follows the one in the task description
	 */
	String variableSetOfTheCFG;
	String[] variableArraySetOfTheCFG;
	String terminalSetOfTheCFG;
	String[] terminalArraySetOfTheCFG;
	String[] productionRulesSetOfTheCFG;
	String[] firstRulesSetOfTheCFG;
	String[] followRulesSetOfTheCFG;
	HashMap<String, ArrayList<String>> mainParsingTableMapping;
	Stack<String> mainParsingInputStack;
	String finalParsedString;
	ArrayList<String> finalParsedStringArrayList;
	String currentProductionRule;
	String nextProductionRuleToBePushed;
	public CfgLl1Parser(String input) {
		String[] splittedCFGString = input.split("#");
		variableSetOfTheCFG = splittedCFGString[0];
		variableArraySetOfTheCFG = variableSetOfTheCFG.split(";");
		terminalSetOfTheCFG = splittedCFGString[1];
		terminalArraySetOfTheCFG = terminalSetOfTheCFG.split(";");
		productionRulesSetOfTheCFG = splittedCFGString[2].split(";");
		firstRulesSetOfTheCFG = splittedCFGString[3].split(";");
		followRulesSetOfTheCFG = splittedCFGString[4].split(";");
		mainParsingTableMapping = new HashMap<>();
		mainParsingInputStack = new Stack<>();
		finalParsedString = "";
		finalParsedStringArrayList = new ArrayList<>();
		currentProductionRule = "";
		nextProductionRuleToBePushed = "";
		fillAllOfTheParsingTable();
	}
	
	public void introduceNewProductionRuleForVariable(String variableLetter, String productionRule) {
		if (!mainParsingTableMapping.containsKey(variableLetter)) {
			ArrayList<String> newSetOfRules = new ArrayList<>();
	    	newSetOfRules.add(productionRule);
	    	mainParsingTableMapping.put(variableLetter, newSetOfRules);
	    }
		else {
			if(!mainParsingTableMapping.get(variableLetter).contains(productionRule)) {
	    		mainParsingTableMapping.get(variableLetter).add(productionRule);
	    	}
	    } 	
	}
	
	public void fillAllOfTheParsingTable() {
		String[] tempProdRules1;
		String[] tempProdRules2;
		String[] tempProdRules3;
		String[] tempProdRules4;
		String[] tempProdRules5;
		String[] tempProdRules6;
		String currentProductionRule;
		String currentFirstRule;
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			tempProdRules1 = firstRulesSetOfTheCFG[i].split("/");
			tempProdRules2 = tempProdRules1[1].split(",");
			tempProdRules3 = productionRulesSetOfTheCFG[i].split("/");
			tempProdRules4 = tempProdRules3[1].split(",");
			tempProdRules5 = followRulesSetOfTheCFG[i].split("/");
			tempProdRules6 = tempProdRules5[1].split(",");
			for(int k = 0; k < tempProdRules2.length; k++) {
				currentFirstRule = tempProdRules2[k];
				if(!currentFirstRule.equals("e")) {
					for(int l = 0; l < currentFirstRule.length(); l++) {
						introduceNewProductionRuleForVariable(tempProdRules1[0], String.valueOf(currentFirstRule.charAt(l)) + ";" + tempProdRules4[k]);
					}
				}
				else if(currentFirstRule.equals("e")) {
					for(int m = 0; m < tempProdRules6.length; m++) {
						currentProductionRule = tempProdRules6[m];
						for(int l = 0; l < currentProductionRule.length(); l++) {
							introduceNewProductionRuleForVariable(tempProdRules1[0], String.valueOf(currentProductionRule.charAt(l)) + ";" + "e");
						}
					}
				}
		   }
		}
	}
	
	public String findNextRuleToAddToParsingStack(String currentProductionRule, String currentParsedCharacter) {
		for(int i = 0; i < mainParsingTableMapping.get(currentProductionRule).size(); i++) {
			if(mainParsingTableMapping.get(currentProductionRule).get(i).charAt(0) == currentParsedCharacter.charAt(0)) {
				return mainParsingTableMapping.get(currentProductionRule).get(i).split(";")[1];
			}
		}
		return "ERROR";
	}
	
	public boolean isCharacterIsATerminal(String characterToCheck) {
		for(int i = 0; i < terminalArraySetOfTheCFG.length; i++) {
			if(terminalArraySetOfTheCFG[i].equals(characterToCheck)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isCharacterIsAVariable(String variableLetter) {
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			if(variableArraySetOfTheCFG[i].equals(variableLetter)) {
				return true;
			}
		}
		return false;
	}
	
	public void performStackTraversalOnInput(String stringToBeParsed) {
		mainParsingInputStack.push("$");
		mainParsingInputStack.push("S");
		stringToBeParsed += "$";
		finalParsedStringArrayList.add("S");
		while(true) {
			if(stringToBeParsed.equals("")) {
				break;
			}
			else if(isCharacterIsATerminal(mainParsingInputStack.peek()) || mainParsingInputStack.peek().equals("$")) {
				if(String.valueOf(stringToBeParsed.charAt(0)).equals(mainParsingInputStack.peek())) {
					currentProductionRule = mainParsingInputStack.pop();
					stringToBeParsed = stringToBeParsed.substring(1,stringToBeParsed.length());
				}
				else {
					finalParsedStringArrayList.add("ERROR");
					break;
				}
			}
			else if(isCharacterIsAVariable(mainParsingInputStack.peek())) {
				currentProductionRule = mainParsingInputStack.pop();
				nextProductionRuleToBePushed = findNextRuleToAddToParsingStack(currentProductionRule, String.valueOf(stringToBeParsed.charAt(0)));
				if(nextProductionRuleToBePushed.equals("ERROR")) {
					finalParsedStringArrayList.add("ERROR");
					break;
				}
				else {
					if(nextProductionRuleToBePushed.equals("e")) {
						int locationOfFirstVariable = finalParsedStringArrayList.get(finalParsedStringArrayList.size()-1).indexOf(currentProductionRule);
					    if (locationOfFirstVariable != -1) { // If 'z' is found in the string
					    	   finalParsedStringArrayList.add(finalParsedStringArrayList.get(finalParsedStringArrayList.size()-1).substring(0, locationOfFirstVariable) + finalParsedStringArrayList.get(finalParsedStringArrayList.size()-1).substring(locationOfFirstVariable + 1));
					    }
					}
					else {
						for(int i = nextProductionRuleToBePushed.length()-1; i >= 0; i--) {
							mainParsingInputStack.push(String.valueOf(nextProductionRuleToBePushed.charAt(i)));
						}
						int locationOfFirstVariable = finalParsedStringArrayList.get(finalParsedStringArrayList.size()-1).indexOf(currentProductionRule);
					    if (locationOfFirstVariable != -1) { // If 'z' is found in the string
					    	   finalParsedStringArrayList.add(finalParsedStringArrayList.get(finalParsedStringArrayList.size()-1).substring(0, locationOfFirstVariable) + nextProductionRuleToBePushed + finalParsedStringArrayList.get(finalParsedStringArrayList.size()-1).substring(locationOfFirstVariable + 1));
					    }
					}
				}
			}
		}
	}
	
	
	/**
	 * @param input The string to be parsed by the LL(1) CFG.
	 * 
	 * @return A string encoding a left-most derivation.
	 */
	public String parse(String input) {
		performStackTraversalOnInput(input);
		for(int i = 0; i < finalParsedStringArrayList.size(); i++) {
			if(i == finalParsedStringArrayList.size()-1) {
				finalParsedString += finalParsedStringArrayList.get(i);
			}
			else {
				finalParsedString += finalParsedStringArrayList.get(i) + ";";
			}
		}
		return finalParsedString;
	}

}
