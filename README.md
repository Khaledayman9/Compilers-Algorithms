# Compilers-Algorithms
A series of tasks and projects related to compiler construction and automata theory, implemented using Java and ANTLR. The tasks cover various fundamental concepts and practical implementations in the field of compilers and formal languages.

# Description

**TASKS**:
1. RegExToNfa
2. Nfa To Dfa
3. FallbackDfa
4. CfgEpsUnitElim
5. CfgLeftRecElim
6. CfgFirstFollow
7. Task 7: ANTLR Lexical Analysis
8. CfgLl1Parser
9. Task 9: ANTLR Parsing I
10. Task 10: ANTLR Parsing II

# 1. RegExToNfa
<details><summary>Explanation</summary> 
For this task, we need to implement Thompson’s construction for converting a regular expression to an equivalent NFA. Description of Thompson’s construction can be found in Chapter 3 of the textbook and at https://en.wikipedia.org/wiki/Thompson’s_construction
- We make the following assumptions for simplicity.
 a) The alphabet Σ of the regular expression is always a subset of the Latin alphabet,
 not including e.

 b) Regular expressions do not include ∅.
 
 c) The empty string ε is represented by e.
 
 d) ◦ is represented by . and ∪ by |.
 
 e) Regular expressions are represented in postfix notation.
 
 f) States of the resulting NFA are numbers.
 
 g) For a postfix regular expression R, states introduced by NFA equivalent to a prefix of R are smaller (as numbers) than states introduced by NFA equivalent to longer prefixes of R. For operators (such as union and *) which introduce a start and an accept state, the start state is smaller (as a number) than the accept state.
 
 h) Following Thompson’s construction, concatenation involves merging the accept state of the first (left) NFA and the start state of the second (right) NFA; the resulting merged state is the accept state of the first NFA.
 
 • You should implement a class constructor RegExToNfa and a method toString.
 
 • RegExToNfa takes one parameter which is a string of the form A#R. A is a string representation of an alphabet Σ, a semicolon-separated sequence of alphabetically sorted symbols, and R is a postfix regular expression over Σ. RegExToNfa constructs the NFA to R as per Thompson’s construction.
 
 • toString returns a string describing the NFA resulting from Thompson’s construction. A string describing the NFA resulting from Thompson’s construction is of the form Q#A#T#I#F.
 
– Qis a string representation of the set of states; a semicolon-separated sequence of sorted integer literals.
 
– A is a string representation of the input alphabet; a semicolon-separated sequence of alphabetically sorted symbols

– T is a string representation of the transition function. T is a semicolon-separated sequence of triples. Each triple is a string representing a single transition; a comma separated sequence i,a,j where i is a state of Q, a a symbol of A or e, and j a state of Q representing a transition from i to j on input a. These triples are sorted bythe source state i, then (if the same state has more than one outgoing transition) by the input a, and then (if multiple triples share the same source state and input, due to non-determinism) by the destination state j.

– I is an integer literal representing the initial state.– F is a string representation of the set of accept states; a semicolon-separated sequence of sorted integer literals.
 
– For example, toString, being invoked on a RegExToNfa object representing the regular expression a;b#ab|, should return the string
```plaintext
0;1;2;3;4;5#a;b#0,a,1;1,e,5;2,b,3;3,e,5;4,e,0;4,e,2#4#5
```
</details>




# 2. Nfa To Dfa
<details><summary>Explanation</summary> 
For this task, you need to implement the classical algorithm for constructing a deterministic finite automaton (DFA) equivalent to a given non-deterministic finite automaton (NFA). Recall that an NFA is a quintuple (Q,Σ,δ,q0,F): Q is a non-empty, finite set of states; Σ is non-empty, finite set of symbols (an alphabet); δ : Q × (Σ ∪ {ε}) −→ P(Q) is the transition function; q0 ∈ Q is the start state; and F ⊆ Q is the set of accept states. Given a description of an NFA, you need to construct an equivalent DFA.

• Wemake the following assumptions for simplicity.
 a) The alphabet Σ is always a subset of the Latin alphabet, not including e.
 
 b) The letter “e” represents ε.
 
 c) The set of NFA states Q is always of the form {0,...,n}, for some n ∈ N.
 
 • You should implement a class constructor NfaToDfa and a method toString.
 
 • NfaToDfa takes one parameter which is a string description of an NFA and constructs an equivalent DFA. A string describing an NFA is of the form Q#A#T#I#F.
 
 – Q is a string representation of the set of states; a semicolon-separated sequence of sorted integer literals.
 
 – A is a string representation of the input alphabet; a semicolon-separated sequence of alphabetically sorted symbols.
 
 – T is a string representation of the transition function. T is a semicolon-separated sequence of triples. Each triple is a string representing a single transition; a comma separated sequence i,a,j where i is a state of Q, a a symbol of A or e, and j a state of Q representing a transition from i to j on input a. These triples are sorted by the source state i, then (if the same state has more than one outgoing transition) by the input a, and then (if multiple triples share the same source state and input, due to non-determinism) by the destination state j.
 
 – I is an integer literal representing the initial state.
 
 – F is a string representation of the set of accept states; a semicolon-separated sequence of sorted integer literals.

– For example, the NFA for which the state diagram appears below may have the following string representation.
 ```plaintext
 0;1;2;3#a;b#0,a,0;0,b,0;0,b,1;1,a,2;1,e,2;2,b,3;3,a,3;3,b,3#0#3
 ```
![DFA](https://github.com/Khaledayman9/Compilers-Algorithms/assets/105018459/50d7f699-6634-4bab-8643-ee4b7ea96a6d)

 • toString returns a string representation of the constructed DFA. A string representation of a DFA returned by toString is similar to that of an NFA—a string of the form Q#A#T#I#F.
 
 – However, states of such DFA are sets of states of the original NFA. Hence, only the representation of states in the string encoding of DFA is different from that ofNFA. A DFA state is represented as a /- separated sequence of numerals, with the numerals representing NFA states.

 – These sequences are sorted by their first numerals (assuming the natural order of numerals). Two sequences starting with the same numeral are sorted according tothe order of their respective suffixes resulting from dropping the first numeral. The empty sequence precedes any sequence.
 
 – A DFA state corresponding to the empty set of NFA states is represented by-1.
 
 – Thus, following the classical construction, the following is a (split for readability) string representing a DFA equivalent to the NFA in the above figure.
 ```plaintext
  0;0/1/2;0/1/2/3;0/2;0/2/3;0/3#a;b#0,a,0;0,b,0/1/2;0/1/2,a,0/2;
 0/1/2,b,0/1/2/3;0/1/2/3,a,0/2/3;0/1/2/3,b,0/1/2/3;0/2,a,0;0/2,b,0/1/2/3;
 0/2/3,a,0/3;0/2/3,b,0/1/2/3;0/3,a,0/3;0/3,b,0/1/2/3#0#0/1/2/3;0/2/3;0/3
```
</details>



# 3. FallbackDfa
<details><summary>Explanation</summary> 
For this task, you need to implement a fallback deterministic finite automaton with actions (FDFA) abstract data type. Recall that an FDFA is a sextuple (Q,Σ,δ,q0,F,A): Q is a non-empty, finite set of states; Σ is a non-empty, finite set of symbols (an alphabet); δ : Q×Σ −→ Q is the transition function; q0 ∈ Q is the start state; F ⊆ Q is the set of accept states; and A is function that maps every state in Q to an action. 

 • We make the following assumptions about FDFA for simplicity.
 
 a) The set of states Q is always of the form {0,...,n}, for some n ∈ N.
 
 b) The alphabet Σ is always a subset of the Latin alphabet, not including e.
 
 c) q0 / ∈ F.
 
 d) A(q) is the action which appends the token “lex,q” to a list, and q is the state name.
 
 • You should implement a class constructor FallbackDfa and a method run.
 
 • FallbackDfa, a class constructor, takes one parameter which is a string description of an FDFA and constructs an FDFA instance as per the description. A string describing an FDFA is of the form Q#A#T#I#F.
 
 – Q is a string representation of the set of states; a semicolon-separated sequence of sorted integer literals.
 
 – A is a string representation of the input alphabet; a semicolon-separated sequence of alphabetically sorted symbols.
 
 – T is a string representation of the transition function. T is a semicolon-separated sequence of triples. Each triple is a string representing a single transition; a comma separated sequence i,a,j where i is a state of Q, a a symbol of A, and j a state of Q representing a transition from i to j on input a. These triples are sorted by the source state i and then by the input a.
 
 – I is an integer literal representing the initial state.
 
 – F is a string representation of the set of accept states; a semicolon-separated sequence of sorted integer literals.
 
 – Note that the function A is not encoded in the string representation since it is fixed for all FDFA as indicated in the simplifying assumptions above.
 
 – Forexample, the following string represents the FDFA whose state diagram appears in the figure below.
  ```plaintext
 0;1;2;3#a;b#0,a,0;0,b,1;1,a,2;1,b,1;2,a,0;2,b,3;3,a,3;3,b,3#0#1;2
  ```
![FDFA](https://github.com/Khaledayman9/Compilers-Algorithms/assets/105018459/d2d79e0e-a562-4520-a6a3-30f8f56c4277)

 • **run** simulates the operation of the constructed FDFA on a given string, and returns a semicolon-separated sequence of tokens. For example, running the above FDFA on the string baababb produces the output:
 
 ```plaintext
 baaba,2;bb,1.
 ```
</details>



# 4. CfgEpsUnitElim
<details><summary>Explanation</summary> 
For this task, you will implement the algorithms for eliminating epsilon and unit rules from a given context-free grammar (CFG). Recall that a CFG is a quadruple (V,Σ,R,S) where V and Σ are disjoint alphabets (respectively, containing variables and terminals), R ⊆ V ×(V ∪Σ)∗ is a set of rules, and S ∈ V is the start variable.
 
 • We make the following assumptions about input CFGs for simplicity.
 
 a) The set V of variables consists of upper-case English letters.
 
 b) The start variable is the symbol S
 .
 c) The set Σ of terminals consists of lower-case English letters (except the letter e).
 
 d) The letter “e” represents ε.
 
 e) ε / ∈ L(G).
 
 • You should implement a class constructor CfgEpsUnitElim, and three methods; toString, eliminateEpsilonRules, and eliminateUnitRules.
 
 • CfgEpsUnitElim, a class constructor, takes one parameter which is a string description of a CFG and constructs a CFG instance. A string encoding a CFG is of the form V#T#R.
 
 – V is a string representation of the set of variables; a semicolon-separated sequence of upper-case English letters, starting with S.
 
 – T is a string representation of the set of terminals; a semicolon-separated sequence of alphabetically sorted lower-case English letters.
 
 – R is a string representation of the set of rules. R is a semicolon-separated sequence of pairs. Each pair represents the largest set of rules with the same left-hand side. Pairs are of the form i/j where i is a variable of V and j is a string representation of set of right-hand sides—a comma-separated sequence of lexicographically sorted strings[^1]. These pairs are sorted by the common left-hand side i based on the ordering of V.

[^1]: [Natural Ordering of Strings in Java](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html#compareTo(java.lang.String))

• Forexample, consider the CFG G1 = ({S,A,B,C},{a,b,c,d,x},R,S), where R is given by the following productions.
 ```plaintext
 S → aAb|xB
 A → Bc|C|c|d
 B → CACA|ε
 C → A|b|ε
 ```
 This CFG will have the following string encoding.
 ```plaintext
 S; A;B;C#a;b;c;d;x#S/aAb,xB;A/Bc,C,c,d;B/CACA,e;C/A,b,e
 ```
 • toString returns a string representation of a CFG. This string representation is the same as the one used for the input to the constructor.
 
 • eliminateEpsilonRules eliminates epsilon rules from the constructed CFG using the classical algorithm. For example, after invoking the method on G1, the string returned by toString is the following (split for readability)

```plaintext
 S;A;B;C#a;b;c;d;x#S/aAb,ab,x,xB;A/Bc,C,c,d;
 B/A,AA,AC,ACA,C,CA,CAA,CAC,CACA,CC,CCA;C/A,b
```
 


 • eliminateUnitRules eliminates unit rules from the constructed CFG using the classical algorithm. For example, after invoking the method on G1, the string returned by toString is the following
 ```plaintext
 S;A;B;C#a;b;c;d;x#S/aAb,xB;A/Bc,b,c,d,e;B/CACA,e;C/Bc,b,c,d,e
 ```
 • Additionally, the above two methods can be called sequentially. Thus the result of invoking toString after invoking eliminateEpsilonRules then eliminateUnitRules returns the following (split for readability)
 ```plaintext
 S;A;B;C#a;b;c;d;x#S/aAb,ab,x,xB;A/Bc,b,c,d;
 B/AA,AC,ACA,Bc,CA,CAA,CAC,CACA,CC,CCA,b,c,d;C/Bc,b,c,d
```
</details>


# 5. CfgLeftRecElim
<details><summary>Explanation</summary> 
For this task, you will implement context-free grammar (CFG) left-recursion elimination algorithm introduced in Lecture 3 of CSEN1003. Recall that a CFG is a quadruple (V,Σ,R,S) where V and Σ are disjoint alphabets (respectively, containing variables and terminals), R ⊆ V ×(V ∪Σ)∗ is a set of rules, and S ∈ V is the start variable.

 
 • We make the following assumptions about input CFGs for simplicity.
 
 a) The set V of variables consists of upper-case English letters.
 
 b) The start variable is the symbol S.
 
 c) The set Σ of terminals consists of lower-case English letters (except the letter e).
 
 d) The letter “e” represents ε.
 
 e) We only consider CFGs with no cycles and no ε-rules.
 
 • You should implement a class constructor CfgLeftRecElim, and two methods; toString, and eliminateLeftRecursion.
 
 • CfgLeftRecElim, a class constructor, takes one parameter which is a string description of a CFG and constructs a CFG instance. A string encoding a CFG is of the form V#T#R.
 
 – V is a string representation of the set of variables; a semicolon-separated sequence of upper-case English letters, starting with S.
 
 – T is a string representation of the set of terminals; a semicolon-separated sequence of alphabetically sorted lower-case English letters.
 
 – R is a string representation of the set of rules. R is a semicolon-separated sequence of pairs. Each pair represents the largest set of rules with the same left-hand side. Pairs are of the form i/j where i is a variable of V and j is a string representation of the set of right-hand sides—a comma-separated sequence of strings. These pairs are sorted by the common left-hand side i based on the ordering of V.
 
 • For example, consider the CFG G1 = ({S,T,L},{a,b,c,d,i},R,S), where R is given
 by the following productions.
 ```plaintext
 S → ScTi|La|T i|b
 T → aSb|LabS|i
 L → SdL|Si
 ```
This CFG will have the following string encoding.
```plaintext
S;T;L#a;b;c;d;i#S/ScTi,La,Ti,b;T/aSb,LabS,i;L/SdL,Si
```
 • toString returns a string representation of a CFG. This string representation is the same as the one used for the input to the constructor.

 • eliminateLeftRecursion eliminates left recursion in the constructed CFG where a newly-introduced variable, for the elimination of immediate left-recursion for variable A, is the string A′. The letter e denotes the empty string. For example, after invoking the method on G1, the string returned by toString is the following (split for readability)
 ```plaintext
        S;T;L;S';L'#a;b;c;d;i#S/LaS',TiS',bS';T/aSb,LabS,i;
 L/aSbiS'dLL',iiS'dLL',bS'dLL',aSbiS'iL',iiS'iL',bS'iL';S'/cTiS',e;
        L'/aS'dLL',abSiS'dLL',aS'iL',abSiS'iL',e
```
</details>



# 6. CfgFirstFollow
<details><summary>Explanation</summary> 
For this task, you will implement the algorithms computing the functions First and Follow, for the variables of a given context-free grammar. Recall that a CFG is a quadruple (V,Σ,R,S) where V and Σ are disjoint alphabets (respectively, containing variables and terminals), R ⊆ V ×(V ∪Σ)∗ is a set of rules, and S ∈ V is the start variable.

 • We make the following assumptions about input CFGs for simplicity.
 
 a) The set V of variables consists of upper-case English letters.

 b) The start variable is the symbol S.
 
 c) The set Σ of terminals consists of lower-case English letters (except the letter e).
 
 d) The letter “e” represents ε.
 
 • You should implement a class constructor CfgFirstFollow, and two methods; first, and follow.
 
 • CfgFirstFollow, a class constructor, takes one parameter which is a string description of a CFG and constructs a CFG instance. A string encoding a CFG is of the form V#T#R.
 
 – V is a string representation of the set of variables; a semicolon-separated sequence of upper-case English letters, starting with S.
 
 – T is a string representation of the set of terminals; a semicolon-separated sequence of alphabetically sorted lower-case English letters.
 
 – R is a string representation of the set of rules. R is a semicolon-separated sequence of pairs. Each pair represents the largest set of rules with the same left-hand side. Pairs are of the form i/j where i is a variable of V and j is a string representation of the set of right-hand sides—a comma-separated sequence of strings. These pairs are sorted by the common left-hand side i based on the ordering of V.
 
 • For example, consider the CFG G1 = ({S,T,L},{a,b,c,d,i},R,S), where R is given by the following productions.
 ```plaintext
 S −→ ScT |T
 T −→ aSb|iaLb|ε
 L −→ SdL |S
 ```
This CFG will have the following string encoding.
```plaintext
S; T;L#a;b;c;d;i#S/ScT,T;T/aSb,iaLb,e;L/SdL,S
```

 • The output of each of first and follow is a semi-colon-separated sequence of items, where each item is a /-separated pair. The first element of each pair is a variable of the grammar and the second element is a string representing the First or, respectively, the Follow set of that variable. The symbols in these strings should appear in alphabetical order. ($ always appears first.) The items themselves should appear in the order in which their respective variables appear in the input CFG.
 
 • For example, the result of calling first on G1 may have the following form
 ```plaintext
 S/acei;T/aei;L/acdei
 ```

 Similarly, the result of calling follow on G1 may be as follows
 ```plaintext
 S/$bcd;T/$bcd;L/b
 ```
</details>

# 7. Task 7: ANTLR Lexical Analysis
<details><summary>Explanation</summary> 
For this task, you are urged to prepare by taking a look at the ANTLR documentation: [ANTLR4 Documentation](https://github.com/antlr/antlr4/blob/master/doc/index.md).

[^2]: [What is ANTLR?](https://www.antlr.org) 
 
You need to implement a simple lexical analyzer using ANTLR[^2]. Using ANTLR, you will implement a lexical analyzer with the following specifications. Given an input of a non-empty string of bits, the string should be split into segments and the outputs for consecutive segments should be produced in sequence. A segment is a string of length three, but if fewer than three symbols are what is available then the segment is the string of available symbols. If the segment is the string **000**, then the corresponding output is **ONE**. If the segment is any other string of length three, then the corresponding output is the result of ANDing the last two bits of the segment. If the segment is a string of length less than three, then the output is **ERROR**. Here are some illustrative examples.

![table](https://github.com/Khaledayman9/Compilers-Algorithms/assets/105018459/89d8a716-3eb7-47df-84cd-18b5d7cee792)

</details>

# 8. CfgLl1Parser
<details><summary>Explanation</summary> 
For this task you will implement an LL(1) parser using pushdown automata (PDA) and predictive parsing tables. Given an input context-free grammar G = (V,Σ,R,S), along with the First and Follow sets for all rules, you need to (i) construct the predictive parsing table for G, (ii) construct the PDA equivalent to G, and (iii) implement an LL(1) parser for G which makes use of the table and the PDA to direct its decisions. Given an input string w, the parser should signal an error if w / ∈ L(G) and produce a derivation of w from S if w ∈ L(G).

• We make the following assumptions about input CFGs for simplicity.

 a) The set V of variables consists of upper-case English letters.
 
 b) The start variable is the symbol S.
 
 c) The set Σ of terminals consists of lower-case English letters (except the letter e).
 
 d) The letter “e” represents ε.
 
 e) We only consider LL(1) CFGs.
 
 • You should implement a class constructor CfgLl1Parser and a method parse.
 
 • CfgLl1Parser, a class constructor, takes one parameter which is a string description of a CFG, together with First and Follow sets for its rules, and constructs a CFG instance. A string encoding a CFG is of the form V#T#R#I#O.
 
 – V is a string representation of the set of variables; a semicolon-separated sequence of upper-case English letters, starting with S.
 
 – T is a string representation of the set of terminals; a semicolon-separated sequence of alphabetically sorted lower-case English letters.
 
 – R is a string representation of the set of rules. R is a semicolon-separated sequence of pairs. Each pair represents the largest set of rules with the same left-hand side. Pairs are of the form i/j where i is a variable of V and j is a string representation of the set of right-hand sides—a comma-separated sequence of strings. These pairs are sorted by the common left-hand side i based on the ordering of V.

 – I is a string representation of the First set of each rule. I is a semicolon-separated sequence of pairs. Pairs are of the form i/j where i is a variable of V and j is the string representation of the First sets of each right-hand side of a rule for i—a comma-separated sequence of strings. These sets appear in the same order of the corresponding rules and are concatenations of the symbols making up the represented set. These pairs are sorted by the common left-hand side i based on the ordering of V.

 – O is a string representation of the Follow set of each variable. O is a semicolon-separated sequence of pairs. Pairs are of the form i/j where i is a variable of V and j is the string representation of the Follow set of i. These sets are encoded by concatenations of the symbols making up the represented set. These pairs are sorted by the common left-hand side i based on the ordering of V.

 • For example, consider the CFG G1 = ({S,T},{a,c,i},R,S), where R is given by the following productions.
 ```plaintext
 S −→ iST|ε
 T −→ cS|a
 ```
 This CFG will have the following string encoding.
 ```plaintext
 S;T#a;c;i#S/iST,e;T/cS,a#S/i,e;T/c,a#S/$ac;T/$ac
 ```
 • **parse** takes an input string w and returns a string encoding a left-most derivation of w in G; in case w / ∈ L(G), this derivation ends with “ERROR.” The parse method should construct a PDA equivalent to G and use the PDA together with the LL(1) parsing table to reach its decision. Note that we will be testing parse using only LL(1) grammars. Hence, you do not need to include a search algorithm in your implementation; w either has no derivation in G or has exactly one.
 
 • A string encoding a derivation is a semicolon-separated sequence of items. Each item is a sentential form representing a step in the derivation. The first item is S. If w ∈ L(G) the last item is w; otherwise, it is ERROR. For example, given G1, on input string iiac, parse should return the following string.
 ```plaintext
 S;iST;iiSTT;iiTT;iiaT;iiacS;iiac
 ```
 On the other hand, on input string iia, parse should return the following.
 ```plaintext
 S;iST;iiSTT;iiTT;iiaT;ERROR
```
</details>


# 9. Task 9: ANTLR Parsing I
<details><summary>Explanation</summary> 
For this task, you are urged to prepare by taking a look at the ANTLR documentation: [ANTLR4 Documentation](https://github.com/antlr/antlr4/blob/master/doc/index.md). 
 
 • You are required to use ANTLR to implement the SDD appearing below for a CFG
 that generates {0,1,#}+.

  ```plaintext
 S −→ F             S.check=F.check∗F.m
 F −→ DT             D.r=1; D.c=1
 T.r = 2;            T.l =D.l
                     F.check = D.check ∗T.check; F.m = T.m
 T −→ #N             N.r=T.r; N.c=1 N.l=T.l
 T.check = N.check;  T.m = N.m
 T −→ ε T.check=1;   T.m=1
 N −→ DT D.r=N.r;    D.c=1
 T.l = N.l;          T.r = N.r+1
                     N.check = D.check ∗T.check; N.m = equals(D.l,N.l)∗T.m
 D −→ 0D1            D1.r=D.r; D1.c=D.c+1
                     D.l = D1.l; D.check = (1−equals(D.c,D.r))∗D1.check
 D −→ 1D1            D1.r=D.r; D1.c=D.c+1
                     D.l = D1.l; D.check = equals(D.c,D.r)∗D1.check
 D −→ 0              D.l=D.c; D.check=1−equals(D.c,D.r)
 D −→ 1              D.l=D.c; D.check=equals(D.c,D.r)
```
 • The start variable S has an attribute check whose value is 1 if the generated string is a diagonal boolean matrix; otherwise, the value of Check is 0. A string over {0,1,#} represents a boolean matrix if it is of the form r1#r2#...#rn, where ri ∈ {0,1}+ and |ri| = |rj|, for every 1 ≤ i,j ≤ n; the matrix is diagonal if, in addition, the jth bit of ri, 1 ≤j ≤|ri|, is 1 if and only if j = i, for every 1 ≤ i ≤ n.

• **The only operations allowed on attributes are assignments, additions, subtraction, multiplications, and equality checks; an equality check is an expression of the form** equals(x,y) **whose value is 1 if x is equal to y and is 0 otherwise.**
• The provided method sCheckValue uses the ANTLR grammar to get the value of S.check for a given input string. 

• For example, for the string, sCheckValue returns 1
 ```plaintext
10#01
```
; and returns 0 for the string 
 ```plaintext
11#01
```
</details>


# 10. Task 10: ANTLR Parsing II
<details><summary>Explanation</summary> 
For this task you will use ANTLR to implement an SDT or an SDD to count the number of plateaus in a sequence of non-negative integers. A plateau in a sequence of non-negative integers is a contiguous sub-sequence of two or more identical integers.
 
 • The grammar of your SDT/SDD should generate all strings representing sequences of
 integers.
 
 • Asequence of non-negative integers is represented by a (possibly empty) string of the form a1,a2,...,an, where ai is a sequence of digits.
 
 • For example, the following are representations of sequences of non-negative integers.
 ```plaintext
 – 1, 4, 4, 4, 2, 2, 3
 – 23, 24, 25
 – 1
 – 546, 0, 0, 7
 ```
 • In your SDT/SDD, the start variable s should have an attribute val whose value is the  number of plateaus in the input sequence.
 
 • In the example sequences above, **val** should be 2 for sequence (a), 0 for sequences (b) and (c), and 1 for sequence (d).
 
 • **The only operations allowed on attributes are assignments, logical operations (&&, ||, !), equality checks (==, !=), and relational checks (<,>, <=, >=)**.

</details>


# Tests:
We have 2 tests for each task named TestsBatch0 and TestsBatch1 respectively, where TestsBatch0 accomodates for Public Test Cases and TestsBatch1 accomodates for Private Test Cases.

# Technologies:
- Java
- Eclipse 2022 Edition
- ANTLR
- intelliJ IDEA 2024.1
