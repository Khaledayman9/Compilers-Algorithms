package csen1002.main.task5;

import java.util.*;

/**
 * Write your info here
 * 
 * @name Khaled Ayman Anwar Khalil Eissa
 * @id 49-3005
 * @labNumber 21
 */

public class CfgLeftRecElim {

	/**
	 * Constructs a Context Free Grammar
	 * 
	 * @param cfg A formatted string representation of the CFG. The string
	 *            representation follows the one in the task description
	 */
	String variableSetOfTheCFG;
	String[] variableArraySetOfTheCFG;
	String terminalSetOfTheCFG;
	String[] productionRulesSetOfTheCFG;
	LinkedHashMap<String, ArrayList<String>> variableSetMappingToProductionRules;
	public CfgLeftRecElim(String cfg) {
		String[] splittedCFGString = cfg.split("#");
		variableSetOfTheCFG = splittedCFGString[0];
		variableArraySetOfTheCFG = variableSetOfTheCFG.split(";");
		terminalSetOfTheCFG = splittedCFGString[1];
		productionRulesSetOfTheCFG = splittedCFGString[2].split(";");
		variableSetMappingToProductionRules = new LinkedHashMap<>();
		fillTheProductionRules();
	}
	
	public void introduceNewProductionRuleForVariable(String variableLetter, String productionRule) {
        if (!variableSetMappingToProductionRules.containsKey(variableLetter)) {
        	ArrayList<String> newSetOfRules = new ArrayList<>();
        	newSetOfRules.add(productionRule);
        	variableSetMappingToProductionRules.put(variableLetter, newSetOfRules);
        } else {
        	if(!variableSetMappingToProductionRules.get(variableLetter).contains(productionRule)) {
        		variableSetMappingToProductionRules.get(variableLetter).add(productionRule);
        	}
        }
    }
	
	
	public void fillTheProductionRules() {
		String[] tempProdRules1;
		String[] tempProdRules2;
		for(int i = 0; i < productionRulesSetOfTheCFG.length; i++) {
			tempProdRules1 = productionRulesSetOfTheCFG[i].split("/");
			tempProdRules2 = tempProdRules1[1].split(",");
			for(int j = 0; j < tempProdRules2.length; j++) {
				introduceNewProductionRuleForVariable(tempProdRules1[0], tempProdRules2[j]);
			}
		}
	}
	
	public boolean checkIfVariableContainsALeftRule(String variableLetter) {
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			for(int j = 0; j < variableSetMappingToProductionRules.get(variableLetter).size(); j++) {
				if(variableSetMappingToProductionRules.get(variableLetter).get(j).charAt(0) == variableLetter.charAt(0)) {
					return true;
				}
			}
		}
		return false;
	}
	

	public int currentIndexOfAVariableLetter(String variableLetter) {
		int resultIndexOfVariableCharacter;
		for(resultIndexOfVariableCharacter = 0 ; resultIndexOfVariableCharacter < variableArraySetOfTheCFG.length; resultIndexOfVariableCharacter++) {
			if(variableArraySetOfTheCFG[resultIndexOfVariableCharacter].equals(variableLetter)) {
				break;
			}
		}
		return resultIndexOfVariableCharacter;
	}
	
	
	public boolean checkIfCurrentVariableLetterNeedsSubstitution(String variableLetter, String referenceLetter) {
		for(int i = 0; i < variableSetMappingToProductionRules.get(variableLetter).size(); i++) {
			if(variableSetMappingToProductionRules.get(variableLetter).get(i).charAt(0) == referenceLetter.charAt(0)) {
				return true;
			}
		}
		return false;
	}
	
	public void substituteNewerRulesWithOlderRules(String variableLetter) {
		if(!variableLetter.equals(variableArraySetOfTheCFG[0])) {
			int currentVariableIndex = currentIndexOfAVariableLetter(variableLetter);
			for(int i = 0; i < currentVariableIndex; i++) {
				if(checkIfCurrentVariableLetterNeedsSubstitution(variableLetter, variableArraySetOfTheCFG[i])) {
					performSubstitution(variableLetter, variableArraySetOfTheCFG[i]);
				}
			}
		}
	}
	
	public void performSubstitution(String variableLetter, String referenceLetter) {
		ArrayList<String> newSetOfRules = new ArrayList<>();
		String newRule = "";
		for(int i = 0; i < variableSetMappingToProductionRules.get(variableLetter).size(); i++) {
			if(variableSetMappingToProductionRules.get(variableLetter).get(i).charAt(0) == referenceLetter.charAt(0)) {
				for(int p = 0; p < variableSetMappingToProductionRules.get(referenceLetter).size(); p++) {
					newRule = variableSetMappingToProductionRules.get(referenceLetter).get(p) + variableSetMappingToProductionRules.get(variableLetter).get(i).substring(1,variableSetMappingToProductionRules.get(variableLetter).get(i).length());
					newSetOfRules.add(newRule);
				}
				newRule = "";
			}
			else {
				newSetOfRules.add(variableSetMappingToProductionRules.get(variableLetter).get(i));
			}
		}
		variableSetMappingToProductionRules.put(variableLetter, newSetOfRules);
	}
	

	public void adjustOldRulesAndCreateNewOnes(String variableLetter) {
		String oldProductionRule = "";
		String newRuleToBeIntroducted = "";
		ArrayList<String> newSetOfRules = new ArrayList<>();
		String newVariableAdded = variableLetter + "'";
		for(int i = 0; i < variableSetMappingToProductionRules.get(variableLetter).size(); i++) {
			oldProductionRule = variableSetMappingToProductionRules.get(variableLetter).get(i);
			if(oldProductionRule.charAt(0) == variableLetter.charAt(0)) {
				newRuleToBeIntroducted = oldProductionRule.substring(1, oldProductionRule.length()) + newVariableAdded;
				introduceNewProductionRuleForVariable(newVariableAdded , newRuleToBeIntroducted);
			}
			else {
				newRuleToBeIntroducted = oldProductionRule + newVariableAdded;
				newSetOfRules.add(newRuleToBeIntroducted);
			}
		}
		if(!variableSetMappingToProductionRules.get(newVariableAdded).contains("e")) {
			variableSetMappingToProductionRules.get(newVariableAdded).add("e");
		}
		variableSetMappingToProductionRules.put(variableLetter, newSetOfRules);
	}
	
	public void performLeftElimination() {
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			substituteNewerRulesWithOlderRules(variableArraySetOfTheCFG[i]);
			if(checkIfVariableContainsALeftRule(variableArraySetOfTheCFG[i])) {
				adjustOldRulesAndCreateNewOnes(variableArraySetOfTheCFG[i]);
			}
		}
	}
	
	/**
	 * Eliminates Left Recursion from the grammar
	 */
	public void eliminateLeftRecursion() {
		performLeftElimination();
	}
	
	
	public String findFinalString() {
		String finalVariablesStringConcatenated = "";
		int counterForKeys = 0;
		for (String key : variableSetMappingToProductionRules.keySet()) {
			finalVariablesStringConcatenated += key;
			if(counterForKeys != variableSetMappingToProductionRules.keySet().size()-1) {
				finalVariablesStringConcatenated += ';';
			}
			else {
				finalVariablesStringConcatenated += "#";
			}
		    counterForKeys++;
        }
		finalVariablesStringConcatenated += terminalSetOfTheCFG + "#";
		for (Map.Entry<String, ArrayList<String>> entry : variableSetMappingToProductionRules.entrySet()) {
			 finalVariablesStringConcatenated += (entry.getKey()) + "/";
	         for (int i = 0; i < entry.getValue().size(); i++) {
	        	 finalVariablesStringConcatenated += entry.getValue().get(i);
	        	 if (i < entry.getValue().size() - 1) {
	        		 finalVariablesStringConcatenated += ",";
	             }         
	         }
	         finalVariablesStringConcatenated += ";";         
	         } 
		 finalVariablesStringConcatenated = finalVariablesStringConcatenated.substring(0,finalVariablesStringConcatenated.length()-1);
		 return finalVariablesStringConcatenated;
	  }
	
	public String toString() {
		return findFinalString();
	}
}
