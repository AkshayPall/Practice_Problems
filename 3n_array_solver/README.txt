This is a solution to a problem in which you must find if the sum k
exists in from the addition of one element each from 3 unsorted
integer arrays of size n in O(n^2) time. 

ex. let k = 0 and n = 5

Array 1 {1, -6, 6, 7, 3}
Array 2 {0, 2, 65, 23, 6}
Array 3 {1, 68, -1, 54, 2}

The sum of k DOES exist from the addition of 1, 0, and -1 from the
respective arrays. 

Procedure:
1) Sort the two arrays low to high using quicksort, an O(n lgn) algorithm.
2) Form a 2D array or matrix of the two sorted arrays and their sums,
   going in increasing order "down to up" and left to right"
3) Iterate through the third list of size n comparing it to the values
   matrix, starting with the first column and row. If a greater value
   is needed to reach the appropriate sum, the integer to the right
   is looked at. If a lower one is required, the integer below is
   looked at.


Matrix)

 -- -6	1		3		6		7--
|

65	59	66	68	71	72

23	17	24	26	29	30

6		0		9		11	14	15

2		-4	3		5		8		9

0		-6	1		3		6		7
|

Iteration of the -1 interger from the third array through the matrix
to find the sum of 1 so that the -1 + the sums of two values from
the first two arrays (ex. 1 and 0) to reach a combined
sum of k = 0.

1)
 -- -6	1		3		6		7--
|

65	(59)	66	68	71	72

23	17	24	26	29	30

6		0		9		11	14	15		//Too high, move down (lower value)

2		-4	3		5		8		9

0		-6	1		3		6		7
| 

2)
 -- -6	1		3		6		7--
|

65	59	66	68	71	72

23	(17)	24	26	29	30

6		0		9		11	14	15		//Too high, move down again

2		-4	3		5		8		9

0		-6	1		3		6		7

3)
 -- -6	1		3		6		7--
|

65	59	66	68	71	72

23	17	24	26	29	30

6		(0)		9		11	14	15	//Too low, move right (higher)

2		-4	3		5		8		9

0		-6	1		3		6		7
|
|

4)
 -- -6	1		3		6		7--
|

65	59	66	68	71	72

23	17	24	26	29	30

6		0		(9)		11	14	15	//Too high, move down

2		-4	3		5		8		9

0		-6	1		3		6		7
|
|

5)
 -- -6	1		3		6		7--
|

65	59	66	68	71	72

23	17	24	26	29	30

6		0		9		11	14	15	//Too high, move down

2		-4	(3)		5		8		9

0		-6	1		3		6		7
|
|

6)
 -- -6	1		3		6		7--
|

65	59	66	68	71	72

23	17	24	26	29	30

6		0		9		11	14	15	//SUCCESS! 

2		-4	3		5		8		9

0		-6	(1)		3		6		7
|
|