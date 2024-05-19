/**
 * Write your info here
 *
 * @name Khaled Ayman Anwar Khalil Eissa
 * @id 49-3005
 * @labNumber 21
 */

grammar Task7;

test: (ONE|ZERO|ERROR);

ONE: '111' | '000' | '011';
ZERO: '001' | '010' | '100' | '101' | '110';
ERROR: DIGIT DIGIT?;

fragment DIGIT: [0,1];