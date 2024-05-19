package csen1002.main.task4;

import java.util.*;
/**
 * Write your info here
 * 
 * @name Khaled Ayman Anwar Khalil Eissa
 * @id 49-3005
 * @labNumber 21
 */

public class CfgEpsUnitElim {

	/**
	 * Constructs a Context Free Grammar
	 * 
	 * @param cfg A formatted string representation of the CFG. The string
	 *             representation follows the one in the task description
	 */
	String variableSetOfTheCFG;
	String[] variableArraySetOfTheCFG;
	String terminalSetOfTheCFG;
	String[] productionRulesSetOfTheCFG;
	HashMap<Character, ArrayList<String>> variableSetMappingToProductionRules;
	HashMap<Character, Boolean> alreadyEpsilonEliminatedVariable;
	String finalCleanedCFGString;
	HashMap<Character, ArrayList<String>> uniqueSingleVariables;
	
	public CfgEpsUnitElim(String cfg) {
		String[] splittedCFGString = cfg.split("#");
		variableSetOfTheCFG = splittedCFGString[0];
		variableArraySetOfTheCFG = variableSetOfTheCFG.split(";");
		terminalSetOfTheCFG = splittedCFGString[1];
		productionRulesSetOfTheCFG = splittedCFGString[2].split(";");
		variableSetMappingToProductionRules = new HashMap<>();
		alreadyEpsilonEliminatedVariable = new HashMap<>();
		uniqueSingleVariables =  new HashMap<>();
		finalCleanedCFGString = "";
		fillTheProductionRules();
	}
	
	public void introduceNewProductionRuleForVariable(char variableLetter, String productionRule) {
        if (!variableSetMappingToProductionRules.containsKey(variableLetter)) {
        	ArrayList<String> newSetOfRules = new ArrayList<>();
        	newSetOfRules.add(productionRule);
        	variableSetMappingToProductionRules.put(variableLetter, newSetOfRules);
        } else {
        	variableSetMappingToProductionRules.get(variableLetter).add(productionRule);
        }
    }
	
	public void removeProductionRuleForVariable(char variableLetter, String productionRule) {
        if (variableSetMappingToProductionRules.containsKey(variableLetter)) {
            ArrayList<String> newSetOfRules = variableSetMappingToProductionRules.get(variableLetter);
            newSetOfRules.remove(productionRule);
            variableSetMappingToProductionRules.put(variableLetter, newSetOfRules);
        }
    }
	
	public void fillTheProductionRules() {
		String[] tempProdRules1;
		String[] tempProdRules2;
		for(int i = 0; i < productionRulesSetOfTheCFG.length; i++) {
			tempProdRules1 = productionRulesSetOfTheCFG[i].split("/");
			tempProdRules2 = tempProdRules1[1].split(",");
			for(int j = 0; j < tempProdRules2.length; j++) {
				introduceNewProductionRuleForVariable(tempProdRules1[0].charAt(0), tempProdRules2[j]);
				alreadyEpsilonEliminatedVariable.put(tempProdRules1[0].charAt(0), false);
			}
		}
	}
	
	/**
	 * Eliminates Epsilon Rules from the grammar
	 */
	public void eliminateEpsilonRules() {
		while(CheckEpsilonInVariableSetHashMap()) {
			performEpsilonElimination(findVariableThatContainsEpsilon());
		}
	}
	
	public void performEpsilonElimination(char variableLetter) {
		removeProductionRuleForVariable(variableLetter, "e");
		alreadyEpsilonEliminatedVariable.put(variableLetter, true);
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			if(checkIfVariableContainsCurrentVariable(variableArraySetOfTheCFG[i].charAt(0), variableLetter)) {
				removeEpsilonHistoryOnVariable(variableArraySetOfTheCFG[i].charAt(0), variableLetter);
			}
		}
	}
	
	
	public void removeEpsilonHistoryOnVariable(char variableUpdating, char variableLetter) {
		ArrayList<String> tempSetOfRules = variableSetMappingToProductionRules.get(variableUpdating);
		ArrayList<String> newProductRules = new ArrayList<>();
		for(int i = 0; i < tempSetOfRules.size(); i++) {			
			if(tempSetOfRules.get(i).contains(String.valueOf(variableLetter))) {
				addProductRulesPermutations(tempSetOfRules.get(i), variableUpdating, variableLetter, newProductRules);	
		    }
		}
		for(int i = 0; i < newProductRules.size(); i++) {
			if(!tempSetOfRules.contains(newProductRules.get(i))) {
				tempSetOfRules.add(newProductRules.get(i));
		   }
		}
		variableSetMappingToProductionRules.put(variableUpdating, tempSetOfRules);
	}
	

	public boolean checkIfVariableContainsCurrentVariable(char newVariable, char currentVariable) {
		for(int i = 0; i < variableSetMappingToProductionRules.get(newVariable).size(); i++) {
			if(variableSetMappingToProductionRules.get(newVariable).get(i).contains(String.valueOf(currentVariable))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsSingleChar(String productString, char variableLetter) {
        int similarityVariableCounter = 0;
        for (int i = 0; i < productString.length(); i++) {
            if (productString.charAt(i) == variableLetter) {
            	similarityVariableCounter++;
            }
        }
        return similarityVariableCounter == productString.length();
    }
	
	
	public void addProductRulesPermutations(String productRuleString, char variableUpdating, char variableLetter, ArrayList<String> newProductRules) {
		if(containsSingleChar(productRuleString, variableLetter) && !alreadyEpsilonEliminatedVariable.get(variableUpdating)) {
	    	newProductRules.add("e");
	    }
	    String removingAllVariableEncounters = productRuleString.replace(String.valueOf(variableLetter), "");
	    if(removingAllVariableEncounters != "" && !newProductRules.contains(removingAllVariableEncounters)) {
	    	newProductRules.add(removingAllVariableEncounters);
	    }
	    int builderCount = 0;
	    for (int i = 0; i < productRuleString.length(); i++) {
	        if (productRuleString.charAt(i) == variableLetter) {
	        	builderCount++;
	        }
	    }
        int allProductPermutationsForNewRuleString = (int) Math.pow(2, builderCount);
        String finalNewRuleString = "";
        for (int i = 0; i < allProductPermutationsForNewRuleString; i++) {
        	finalNewRuleString = "";
            int currentCounter = i;
            for (int j = 0; j < productRuleString.length(); j++) {
                if (productRuleString.charAt(j) == variableLetter) {
                    if (currentCounter % 2 == 0) {
                    	finalNewRuleString += "";
                    } else {
                    	finalNewRuleString += variableLetter;
                    }
                    currentCounter /= 2;
                } else {
                	finalNewRuleString += productRuleString.charAt(j);
                }
            }
            if(!newProductRules.contains(finalNewRuleString) && finalNewRuleString != "") {
            	newProductRules.add(finalNewRuleString);
            }
        }
    }

	public char findVariableThatContainsEpsilon() {
		char resultVariable = 'S';
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			if(variableContainsAnEpsilon(variableArraySetOfTheCFG[i].charAt(0))) {
				resultVariable = variableArraySetOfTheCFG[i].charAt(0);
			}
		}
		return resultVariable;
	}
	
	public boolean CheckEpsilonInVariableSetHashMap() {
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			if(variableContainsAnEpsilon(variableArraySetOfTheCFG[i].charAt(0))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean variableContainsAnEpsilon(char variableLetter) {
		if (variableSetMappingToProductionRules.containsKey(variableLetter)) {
            if(variableSetMappingToProductionRules.get(variableLetter).contains("e")) {
            	return true;
            }
            else {
            	return false;
            }
        }
	    return false;
	}
	
	/**
	 * Eliminates Unit Rules from the grammar
	 */
	public void eliminateUnitRules() {
		while(CheckUnitInVariableSetHashMap()) {
			eliminateInnerLoops();
			fillTheSingleProductionRules();
		    performUnitElimination(findVariableThatContainsUnit());	
		}
	}
	
	public void fillTheSingleProductionRules() {
		String singleVariableToCheck;
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {	
			for(int j = 0; j < variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i].charAt(0)).size(); j++) {
				singleVariableToCheck = variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i].charAt(0)).get(j);
				if(singleVariableToCheck.length() == 1 && Character.isUpperCase(singleVariableToCheck.charAt(0))) {
				       if (!uniqueSingleVariables.containsKey(variableArraySetOfTheCFG[i].charAt(0))) {
				        	ArrayList<String> newSetOfRules = new ArrayList<>();
				        	newSetOfRules.add(singleVariableToCheck);
				        	uniqueSingleVariables.put(variableArraySetOfTheCFG[i].charAt(0), newSetOfRules);
				        } else {
				        	uniqueSingleVariables.get(variableArraySetOfTheCFG[i].charAt(0)).add(singleVariableToCheck);
				        }
				}
			}
		}
	}
	
	public void eliminateInnerLoops() {
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			removeProductionRuleForVariable(variableArraySetOfTheCFG[i].charAt(0), variableArraySetOfTheCFG[i]);
		}
	}
	
	public void performUnitElimination(char variableLetter) {
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			if(variableArraySetOfTheCFG[i].charAt(0) != variableLetter && containsAUnitRule(variableArraySetOfTheCFG[i].charAt(0), variableLetter)) {
				addElementsFromTargetVarToVar(variableArraySetOfTheCFG[i].charAt(0), variableLetter);
			}
		}
	}
	
	public void addElementsFromTargetVarToVar(char targetLetter, char variableLetter) {
		for(int i = 0; i < variableSetMappingToProductionRules.get(targetLetter).size(); i++) {
			if(!variableSetMappingToProductionRules.get(variableLetter).contains(variableSetMappingToProductionRules.get(targetLetter).get(i))
					&& !(variableSetMappingToProductionRules.get(targetLetter).get(i).equals(String.valueOf(variableLetter)))
					&& !uniqueSingleVariables.get(variableLetter).contains(variableSetMappingToProductionRules.get(targetLetter).get(i))) {
				introduceNewProductionRuleForVariable(variableLetter, variableSetMappingToProductionRules.get(targetLetter).get(i));
			}
		}
	   removeProductionRuleForVariable(variableLetter, String.valueOf(targetLetter));
	}
	
	public boolean containsAUnitRule(char targetLetter, char variableLetter) {
		for(int i = 0; i < variableSetMappingToProductionRules.get(variableLetter).size(); i++) {
			if(variableSetMappingToProductionRules.get(variableLetter).get(i).equals(String.valueOf(targetLetter))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean CheckUnitInVariableSetHashMap() {
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			if(variableContainsAUnit(variableArraySetOfTheCFG[i].charAt(0))) {
				return true;
			}
	    }
		return false;
	}
	
	public boolean variableContainsAUnit(char variableLetter) {
		if (variableSetMappingToProductionRules.containsKey(variableLetter)) {
			for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
				if(variableSetMappingToProductionRules.get(variableLetter).contains(variableArraySetOfTheCFG[i]) && variableLetter != variableArraySetOfTheCFG[i].charAt(0)) {
					return true;
				}
			}
		}
	    return false;
	}
	
	public char findVariableThatContainsUnit() {
		char resultVariable = 'S';
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			if(variableContainsAUnit(variableArraySetOfTheCFG[i].charAt(0))) {
				resultVariable = variableArraySetOfTheCFG[i].charAt(0);
			}
		}
		return resultVariable;
		
	}
	
	public String findFinalString() {
		ArrayList<String> tempNewSetOfRules;
		String finalResultStringWithOutEpsilonAndUnitRules = "";
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			finalResultStringWithOutEpsilonAndUnitRules += variableArraySetOfTheCFG[i] +"/";
			tempNewSetOfRules = variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i].charAt(0));
			finalResultStringWithOutEpsilonAndUnitRules += (String.join(",", tempNewSetOfRules.stream().sorted().map(String::valueOf).toArray(String[]::new)));
			if(i != variableArraySetOfTheCFG.length-1) {
				finalResultStringWithOutEpsilonAndUnitRules += ";";
			}
		}
		return finalResultStringWithOutEpsilonAndUnitRules;
	}

	public String toString() {
		finalCleanedCFGString += variableSetOfTheCFG + "#";
		finalCleanedCFGString += terminalSetOfTheCFG + "#";
		finalCleanedCFGString += findFinalString();
		return finalCleanedCFGString;
	}

}
