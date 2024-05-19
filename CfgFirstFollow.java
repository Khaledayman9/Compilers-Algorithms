package csen1002.main.task6;

import java.util.*;

/**
 * Write your info here
 * 
 * @name Khaled Ayman Anwar Khalil Eissa
 * @id 49-3005
 * @labNumber 21
 */

public class CfgFirstFollow {

	/**
	 * Constructs a Context Free Grammar
	 * 
	 * @param cfg A formatted string representation of the CFG. The string
	 *            representation follows the one in the task description
	 */ 
	String variableSetOfTheCFG;
	String[] variableArraySetOfTheCFG;
	String terminalSetOfTheCFG;
	String[] terminalArraySetOfTheCFG;
	String[] productionRulesSetOfTheCFG;
	LinkedHashMap<String, ArrayList<String>> variableSetMappingToProductionRules;
	HashMap<String, ArrayList<String>> firstSetMapping;
	HashMap<String, ArrayList<String>> followSetMapping;
	boolean containsFirstTerminals;
	int oldSize;
	int newSize;
	boolean thereIsAnotherFirstRule;
	int counterForProductionRule;
    
	public CfgFirstFollow(String cfg) {
		String[] splittedCFGString = cfg.split("#");
		variableSetOfTheCFG = splittedCFGString[0];
		variableArraySetOfTheCFG = variableSetOfTheCFG.split(";");
		terminalSetOfTheCFG = splittedCFGString[1];
		terminalArraySetOfTheCFG = terminalSetOfTheCFG.split(";");
		productionRulesSetOfTheCFG = splittedCFGString[2].split(";");
		variableSetMappingToProductionRules = new LinkedHashMap<>();
		firstSetMapping = new HashMap<>();
		followSetMapping = new HashMap<>();
		containsFirstTerminals = true;
		oldSize = -100;
		newSize = -200;
		thereIsAnotherFirstRule = false;
		counterForProductionRule = 0;
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
	
	public int calculateHashMapLength(HashMap<String, ArrayList<String>> hashMapToKnowLength) {
		int totalLengthOfFirstRules = 0;
		for (Map.Entry<String, ArrayList<String>> hashMapFirstEntry : hashMapToKnowLength.entrySet()) {
            for (String firstRule : hashMapFirstEntry.getValue()) {
            	totalLengthOfFirstRules++;
            }
        }
		return totalLengthOfFirstRules;
	}

	
	public void introduceFirstOrFollowRuleForVariable(String variableLetter, String symbolCharacter, int IsItFirstOrFollow) {
		if(IsItFirstOrFollow == 0) {
			if (!firstSetMapping.containsKey(variableLetter)) {
	        	ArrayList<String> newSetOfRules = new ArrayList<>();
	        	newSetOfRules.add(symbolCharacter);
	        	firstSetMapping.put(variableLetter, newSetOfRules);
	        } else {
	        	if(!firstSetMapping.get(variableLetter).contains(symbolCharacter)) {
	        		firstSetMapping.get(variableLetter).add(symbolCharacter);
	        	}
	        }
		}
		else if(IsItFirstOrFollow == 1)  {
			if (!followSetMapping.containsKey(variableLetter)) {
	        	ArrayList<String> newSetOfRules = new ArrayList<>();
	        	newSetOfRules.add(symbolCharacter);
	        	followSetMapping.put(variableLetter, newSetOfRules);
	        } else {
	        	if(!followSetMapping.get(variableLetter).contains(symbolCharacter)) {
	        		followSetMapping.get(variableLetter).add(symbolCharacter);
	        	}
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
	
	public boolean checkFirstCharacterIfTheyAreAllTheSame(String variableLetter) {
		for(int i = 0; i < variableSetMappingToProductionRules.get(variableLetter).size(); i++) {
			if(variableSetMappingToProductionRules.get(variableLetter).get(1).charAt(0) != variableLetter.charAt(0)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean firstCharacterIsATerminal(char characterToCheck) {
		for(int i = 0; i < terminalArraySetOfTheCFG.length; i++) {
			if(terminalArraySetOfTheCFG[i].charAt(0) == characterToCheck) {
				return true;
			}
		}
		return false;
	}
	
	public boolean firstCharacterIsAVariable(char variableLetter) {
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			if(variableArraySetOfTheCFG[i].charAt(0) == variableLetter) {
				return true;
			}
		}
		return false;
	}
	
	public void performVariableSubstitution(String variableLetter, String OtherSecondLetter, int conditionFirstType) {
		if(conditionFirstType == 0 && !firstSetMapping.get(OtherSecondLetter).isEmpty()) {
			for(int d = 0; d < firstSetMapping.get(OtherSecondLetter).size(); d++) {
				if(!firstSetMapping.get(OtherSecondLetter).get(d).equals("e")) {
					introduceFirstOrFollowRuleForVariable(variableLetter, firstSetMapping.get(OtherSecondLetter).get(d), 0);
				}
			}
		}
		else if(conditionFirstType == 1 && !firstSetMapping.get(OtherSecondLetter).isEmpty())  {
			for(int d = 0; d < firstSetMapping.get(OtherSecondLetter).size(); d++) {
				introduceFirstOrFollowRuleForVariable(variableLetter, firstSetMapping.get(OtherSecondLetter).get(d), 0);
			}			
		}
		else if(conditionFirstType == 2) {
			for(int d = 0; d < firstSetMapping.get(OtherSecondLetter).size(); d++) {
				if(!firstSetMapping.get(OtherSecondLetter).get(d).equals("e")) {
					introduceFirstOrFollowRuleForVariable(variableLetter, firstSetMapping.get(OtherSecondLetter).get(d), 1);
				}
			}
		}
		else if(conditionFirstType == 3)  {
			for(int d = 0; d < firstSetMapping.get(OtherSecondLetter).size(); d++) {
				introduceFirstOrFollowRuleForVariable(variableLetter, firstSetMapping.get(OtherSecondLetter).get(d), 1);
			}			
		}
		else if(conditionFirstType == 4)  {
			for(int d = 0; d < followSetMapping.get(OtherSecondLetter).size(); d++) {
				introduceFirstOrFollowRuleForVariable(variableLetter, followSetMapping.get(OtherSecondLetter).get(d), 1);
			}			
		}
	}
	
	public void fillTheStartingAndNonStartingFirstVariables() {
		oldSize = -100;
		newSize = -200;
		while(oldSize != newSize) {
			oldSize = calculateHashMapLength(firstSetMapping);
			for(int i = variableArraySetOfTheCFG.length-1; i >= 0; i--) {
				for(int j = 0; j < variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).size(); j++) {
					if(firstCharacterIsATerminal(variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).charAt(0))
							|| variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).charAt(0) == 'e'){
						introduceFirstOrFollowRuleForVariable(variableArraySetOfTheCFG[i], String.valueOf(variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).charAt(0)), 0);
					}
					else if(firstCharacterIsAVariable(variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).charAt(0))) {	
						String StringValuealueOfChar = String.valueOf(variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).charAt(0)); 
						if(!StringValuealueOfChar.equals(variableArraySetOfTheCFG[i]) && firstSetMapping.containsKey(StringValuealueOfChar)) {	
							if(variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).length() == 1) {
								performVariableSubstitution(variableArraySetOfTheCFG[i], StringValuealueOfChar, 1);
							}
							else {
								performVariableSubstitution(variableArraySetOfTheCFG[i], StringValuealueOfChar, 0);
							}
						}
				 	  }
				   }
			  }
			newSize = calculateHashMapLength(firstSetMapping);
	     }
	}
	
	public void fillTheSubstitutionFirstVariables() {
		String currentProductRule = "";
		oldSize = -100;
		newSize = -200;
		while(oldSize != newSize) {
			oldSize = calculateHashMapLength(firstSetMapping);
			for(int i = variableArraySetOfTheCFG.length-1; i >= 0; i--) {
				for(int j = 0; j < variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).size(); j++) {
					if(firstCharacterIsAVariable(variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).charAt(0))) {
						currentProductRule = variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j);
						if(currentProductRule.length() == 1 && currentProductRule.charAt(0) != variableArraySetOfTheCFG[i].charAt(0) && firstSetMapping.get(String.valueOf(currentProductRule.charAt(0))) != null) {
							performVariableSubstitution(variableArraySetOfTheCFG[i], currentProductRule, 1);
						}
						else if(currentProductRule.length() == 1 && currentProductRule.charAt(0) == variableArraySetOfTheCFG[i].charAt(0)) {
							continue;
						}
						else {
							while(!thereIsAnotherFirstRule) {
								if(firstCharacterIsAVariable(currentProductRule.charAt(0)) && currentProductRule.charAt(0) != variableArraySetOfTheCFG[i].charAt(0) && currentProductRule.length() > 1 && firstSetMapping.get(String.valueOf(currentProductRule.charAt(0))) != null) {
									performVariableSubstitution(variableArraySetOfTheCFG[i], String.valueOf(currentProductRule.charAt(0)), 0);	
								}
								else if(firstCharacterIsAVariable(currentProductRule.charAt(0)) && currentProductRule.charAt(0) != variableArraySetOfTheCFG[i].charAt(0) && currentProductRule.length() == 1 && firstSetMapping.get(String.valueOf(currentProductRule.charAt(0))) != null) {
									performVariableSubstitution(variableArraySetOfTheCFG[i], String.valueOf(currentProductRule.charAt(0)), 1);
								}
								else if(firstCharacterIsAVariable(currentProductRule.charAt(0)) && firstSetMapping.get(String.valueOf(currentProductRule.charAt(0))) == null) {
									break;
								}
								if(firstCharacterIsAVariable(currentProductRule.charAt(0)) && firstSetMapping.get(String.valueOf(currentProductRule.charAt(0))).contains("e")){
									currentProductRule = currentProductRule.substring(1, currentProductRule.length());
									if(currentProductRule.isEmpty()) {
										break;
									}
								}
								else if(firstCharacterIsAVariable(currentProductRule.charAt(0)) && !firstSetMapping.get(String.valueOf(currentProductRule.charAt(0))).contains("e")) {
									thereIsAnotherFirstRule = true;
								}
								else if(firstCharacterIsATerminal(currentProductRule.charAt(0))) {
									introduceFirstOrFollowRuleForVariable(variableArraySetOfTheCFG[i], String.valueOf(currentProductRule.charAt(0)), 0);
									thereIsAnotherFirstRule = true;
								}				
							}	
							thereIsAnotherFirstRule = false;
						}
					}
				}
			}
			newSize = calculateHashMapLength(firstSetMapping);
		}
	}
	
	public String findFinalFirstString() {
		String finalFirstConcatenatedString = "";
		if(firstSetMapping.isEmpty()) {
			for (String hashMapFirstEntry : variableArraySetOfTheCFG) {
				finalFirstConcatenatedString += hashMapFirstEntry + "/";
				finalFirstConcatenatedString += ";";         
	        } 
		}
		else {
			for (String hashMapFirstEntry : variableArraySetOfTheCFG) {
				finalFirstConcatenatedString += hashMapFirstEntry + "/";
				if(firstSetMapping.get(hashMapFirstEntry) == null) {
					finalFirstConcatenatedString += ";";
				} 
				else {
					ArrayList<String> hashMapFirstEntryArrayList = firstSetMapping.get(hashMapFirstEntry);
		            Collections.sort(hashMapFirstEntryArrayList);
		            for (String hashMapFirstEntryData : hashMapFirstEntryArrayList) {
		                finalFirstConcatenatedString += hashMapFirstEntryData;
		            }
		            finalFirstConcatenatedString += ";";
				}
	        }

		}
		finalFirstConcatenatedString = finalFirstConcatenatedString.substring(0,finalFirstConcatenatedString.length()-1);
		return finalFirstConcatenatedString;
	  }
	

	/**
	 * Calculates the First Set of each variable in the CFG.
	 * 
	 * @return A string representation of the First of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String first() {
		fillTheStartingAndNonStartingFirstVariables();
		if(!firstSetMapping.isEmpty()) {
			fillTheSubstitutionFirstVariables();
		}
		return findFinalFirstString();
	}
	
	
	public void fillTheStartingAndNonStartingFollowVariables() {
		oldSize = -100;
		newSize = -200;
		while(oldSize != newSize) {
			oldSize = calculateHashMapLength(followSetMapping);
			for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
				loopToFindAllPossibleFollowPlaces(variableArraySetOfTheCFG[i]);

			}
			newSize = calculateHashMapLength(followSetMapping);
	     }
	}
	
	
	public void loopToFindAllPossibleFollowPlaces(String variableLetter) {
		int currentLocationOfVariable;
		for(int i = 0; i < variableArraySetOfTheCFG.length; i++) {
			for(int j = 0; j < variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).size(); j++) {
				if(variableLetter.equals(variableArraySetOfTheCFG[0])) {
					introduceFirstOrFollowRuleForVariable(variableLetter, "$", 1);
				}
				if(productionRuleContainsVariableLetter(variableLetter,variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j))) {
					ArrayList<Integer> locationsOfVariableLetter = findingTheLocationsOfAVariableLetterInAProductionRule(variableLetter, variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j));
					for(int k = 0; k < locationsOfVariableLetter.size(); k++) {
						currentLocationOfVariable = locationsOfVariableLetter.get(k);
						if(currentLocationOfVariable == (variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).length()-1) && followSetMapping.get(variableArraySetOfTheCFG[i]) != null) {
							performVariableSubstitution(variableLetter, variableArraySetOfTheCFG[i], 4);
						}
						else if(currentLocationOfVariable != (variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).length()-1) && firstCharacterIsATerminal(variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).charAt(currentLocationOfVariable+1))) {
							introduceFirstOrFollowRuleForVariable(variableLetter, String.valueOf(variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).charAt(currentLocationOfVariable+1)), 1);
						}
						else if(currentLocationOfVariable != (variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).length()-1) && firstCharacterIsAVariable(variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).charAt(currentLocationOfVariable+1))) {
							performFollowTraverseOnRemainingString(variableLetter, variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).substring(currentLocationOfVariable + 1, variableSetMappingToProductionRules.get(variableArraySetOfTheCFG[i]).get(j).length()), variableArraySetOfTheCFG[i]);
						}
					}
				}
			}			
		}
	}
	
	public void performFollowTraverseOnRemainingString(String variableLetter, String remainingProductionRule, String OtherSecondLetter) {
		counterForProductionRule = 0;
		while(true) {
			if(firstCharacterIsATerminal(remainingProductionRule.charAt(counterForProductionRule))) {
				introduceFirstOrFollowRuleForVariable(variableLetter, String.valueOf(remainingProductionRule.charAt(counterForProductionRule)), 2);
				break;
			}
			else if(firstCharacterIsAVariable(remainingProductionRule.charAt(counterForProductionRule)) && firstSetMapping.get(String.valueOf(remainingProductionRule.charAt(counterForProductionRule))) != null){
				performVariableSubstitution(variableLetter, String.valueOf(remainingProductionRule.charAt(counterForProductionRule)), 2);
				if((firstSetMapping.get(String.valueOf(remainingProductionRule.charAt(counterForProductionRule))).contains("e") 
						&& counterForProductionRule == (remainingProductionRule.length() - 1)
						&& followSetMapping.get(OtherSecondLetter) != null)
						|| (String.valueOf(remainingProductionRule.charAt(counterForProductionRule)).equals(variableLetter)
						&& counterForProductionRule == (remainingProductionRule.length() - 1))
						&& followSetMapping.get(OtherSecondLetter) != null){
					performVariableSubstitution(variableLetter, OtherSecondLetter, 4);
					break;	
			    }
				else if((firstSetMapping.get(String.valueOf(remainingProductionRule.charAt(counterForProductionRule))).contains("e") 
						&& counterForProductionRule == (remainingProductionRule.length() - 1)
						&& followSetMapping.get(OtherSecondLetter) == null) 
						|| (!firstSetMapping.get(String.valueOf(remainingProductionRule.charAt(counterForProductionRule))).contains("e"))) {
					break;
				}
				
		}
			else if(firstCharacterIsAVariable(remainingProductionRule.charAt(counterForProductionRule)) && firstSetMapping.get(String.valueOf(remainingProductionRule.charAt(counterForProductionRule))) == null){
				break;
		}
			
	    counterForProductionRule++;
		}
	}
	
	public ArrayList<Integer> findingTheLocationsOfAVariableLetterInAProductionRule(String variableLetter, String productionRule) {
		ArrayList<Integer> locationsOfVariableLetter = new ArrayList<>();
		for(int i = 0;i < productionRule.length(); i++) {
			if(variableLetter.charAt(0) == productionRule.charAt(i)) {
				locationsOfVariableLetter.add(i);
			}
		}
		return locationsOfVariableLetter;
	}
	
	public boolean productionRuleContainsVariableLetter(String variableLetter, String productionRule) {
		for(int i = 0; i < productionRule.length(); i++) {
			if(productionRule.charAt(i) == variableLetter.charAt(0)) {
				return true;
			}
		}
		return false;
	}
	
	public String findFinalFollowString() {
		String finalFollowConcatenatedString = "";
		for (String hashMapFirstEntry : variableArraySetOfTheCFG) {
			finalFollowConcatenatedString += hashMapFirstEntry + "/";
			if(followSetMapping.get(hashMapFirstEntry) == null) {
				finalFollowConcatenatedString += ";";
			} 
			else {
				ArrayList<String> hashMapFirstEntryArrayList = followSetMapping.get(hashMapFirstEntry);
	            Collections.sort(hashMapFirstEntryArrayList);
	            for (String hashMapFirstEntryData : hashMapFirstEntryArrayList) {
	            	finalFollowConcatenatedString += hashMapFirstEntryData;
	            }
	            finalFollowConcatenatedString += ";";
			}
        }	
		finalFollowConcatenatedString = finalFollowConcatenatedString.substring(0,finalFollowConcatenatedString.length()-1);
		return finalFollowConcatenatedString;
	  }
	
	/**
	 * Calculates the Follow Set of each variable in the CFG.
	 * 
	 * @return A string representation of the Follow of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String follow() {
		fillTheStartingAndNonStartingFirstVariables();
		if(!firstSetMapping.isEmpty()) {
			fillTheSubstitutionFirstVariables();
		}
		fillTheStartingAndNonStartingFollowVariables();
		return findFinalFollowString();
	}
	
}
