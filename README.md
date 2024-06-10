# Compilers-Algorithms
A series of tasks and projects related to compiler construction and automata theory, implemented using Java and ANTLR. The tasks cover various fundamental concepts and practical implementations in the field of compilers and formal languages.


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
 
 • toString returns a string describing the NFA resulting from Thompson’s construction.
 
 A string describing the NFA resulting from Thompson’s construction is of the form Q#A#T#I#F.– Qis a string representation of the set of states; a semicolon-separated sequence of sorted integer literals.
 
– A is a string representation of the input alphabet; a semicolon-separated sequence of alphabetically sorted symbols

– T is a string representation of the transition function. T is a semicolon-separated sequence of triples. Each triple is a string representing a single transition; a comma separated sequence i,a,j where i is a state of Q, a a symbol of A or e, and j a state of Q representing a transition from i to j on input a. These triples are sorted bythe source state i, then (if the same state has more than one outgoing transition) by the input a, and then (if multiple triples share the same source state and input, due to non-determinism) by the destination state j.

– I is an integer literal representing the initial state.– F is a string representation of the set of accept states; a semicolon-separated sequence of sorted integer literals.
 
– For example, toString, being invoked on a RegExToNfa object representing the regular expression a;b#ab|, should return the string 0;1;2;3;4;5#a;b#0,a,1;1,e,5;2,b,3;3,e,5;4,e,0;4,e,2#4#5

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
 0;1;2;3#a;b#0,a,0;0,b,0;0,b,1;1,a,2;1,e,2;2,b,3;3,a,3;3,b,3#0#3
![DFA](https://github.com/Khaledayman9/Compilers-Algorithms/assets/105018459/50d7f699-6634-4bab-8643-ee4b7ea96a6d)

 • toString returns a string representation of the constructed DFA. A string representation of a DFA returned by toString is similar to that of an NFA—a string of the form Q#A#T#I#F.
 
 – However, states of such DFA are sets of states of the original NFA. Hence, only the representation of states in the string encoding of DFA is different from that ofNFA. A DFA state is represented as a /- separated sequence of numerals, with the numerals representing NFA states.

 – These sequences are sorted by their first numerals (assuming the natural order of numerals). Two sequences starting with the same numeral are sorted according tothe order of their respective suffixes resulting from dropping the first numeral. The empty sequence precedes any sequence.
 
 – A DFA state corresponding to the empty set of NFA states is represented by-1.
 
 – Thus, following the classical construction, the following is a (split for readability) string representing a DFA equivalent to the NFA in the above figure.
 0;0/1/2;0/1/2/3;0/2;0/2/3;0/3#a;b#0,a,0;0,b,0/1/2;0/1/2,a,0/2;0/1/2,b,0/1/2/3;0/1/2/3,a,0/2/3;0/1/2/3,b,0/1/2/3;0/2,a,0;0/2,b,0/1/2/3;0/2/3,a,0/3;0/2/3,b,0/1/2/3;0/3,a,0/3;0/3,b,0/1/2/3#0#0/1/2/3;0/2/3;0/3
</details>



# 2. FallbackDfa
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
 0;1;2;3#a;b#0,a,0;0,b,1;1,a,2;1,b,1;2,a,0;2,b,3;3,a,3;3,b,3#0#1;2
![FDFA](https://github.com/Khaledayman9/Compilers-Algorithms/assets/105018459/d2d79e0e-a562-4520-a6a3-30f8f56c4277)

 • **run** simulates the operation of the constructed FDFA on a given string, and returns a semicolon-separated sequence of tokens. For example, running the above FDFA on the string baababb produces the output = baaba,2;bb,1.
</details>
