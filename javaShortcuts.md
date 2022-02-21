Convert String to List of Characters
--

`str.chars().mapToObj(e->(char)e).collect(Collectors.toList());`

Sorting priorityqueue based in frequency of key in ascending order
--

```java

PriorityQueue<Pair<Character,Integer>> q = 
new PriorityQueue<>(
	(p,q)->p.getValue()- q.getValue());
	
```
Sorting the PriorityQueue based on the frequency of element using entrySet of HashMap
--

`PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());`

Calculating the frequency of the int or character in a string or array
using HashMap
-
`for(int code:barcodes) map.put(code,map.getOrDefault(code,0)+1);`

















Character
--
**convert char to int**

`Character.getNumericValue(number);`
