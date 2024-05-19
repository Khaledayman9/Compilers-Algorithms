/**
 * Write your info here
 *
 * @name Khaled Ayman Anwar Khalil Eissa
 * @id 49-3005
 * @labNumber 21
 */

grammar Task10;

s returns [int val]
@init {
    $val = 0;
}: seq { $val = $seq.val; };

seq returns [int val]
@init {
    $val = 0;
    int _prev = -1;
    int _count = 1;
}
    : first=number[-1, 0, 0] {
        $val = $first.nVal;
        _prev = $first.nPrev;
        _count = $first.nCount;
    } (',' next=number[_prev, _count, $val] {
        $val = $next.nVal;
        _prev = $next.nPrev;
        _count = $next.nCount;
    })*;

number[int prev, int count, int plateauCount] returns [int nVal, int nPrev, int nCount]
@init {
    $nVal = $plateauCount;
    $nPrev = $prev;
    $nCount = $count;
}
    :DIGIT+ {
        int current = Integer.parseInt($text);
        if (current == $prev) {
            $nCount++;
            if ($nCount == 2) {
                $nVal++;
            }
        } else {
            $nCount = 1;
        }
        $nPrev = current;
    };

DIGIT: '0'..'9';

WS: [\t\r\n]+ -> skip;