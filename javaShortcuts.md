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






String
--
**Check if two string are anagrams or not**

```java
public boolean isAnagram(String toCheck , String checkWith){
        return Arrays.
            equals(
            Arrays.sort(toCheck.toCharArray()),
            Arrays.sort(checkWith.toCharArray())
        ));
    }
```






List
--

**puting 1 to n value in list using steams**

`List<Integer> list  = Streams.iterate(1,temp->temp+1).limit(n).collect(Collectors.toList()))`

**OR**

`List<Integer> range = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());`


**Converting int array to List**

```java
int[] ints = {1,2,3};
List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());

//In Java 16 and later:

List<Integer> list = Arrays.stream(ints).boxed().toList();
```

**Adding all value of the list and storing it in one variable**

```java
List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
Integer sum = integers.stream()
  .reduce(0, (a, b) -> a + b);
In the same way, we can use an already existing Java method:

List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
Integer sum = integers.stream()
  .reduce(0, Integer::sum);
```

Math library in java
--
**Get Random number in a given range**

```java
(int)(Math.random() * range) + min; // range= max-min +1; min = 1;
```
**OR**
```java
List<Integer> list = Arrays.asList(1,2,3,42,33,34,333);
Random ran = new Random();
int index = ran.nextInt(list.size());
return list.get(index);
```