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

Sorting HashMap using Colletion.sort();

```java

List<Map.Entry<Integer,String>> list = new ArrayList<>(map.entrySet());
Collections.sort(list, new Comparator<Map.Entry<Integer,String>>()
{
	public int compare(Map.Entry<Integer,String> a, 
	Map.Entry<Integer,String> b){
		return a.getKey() - b.getKey();
			}
		}
  );
Map<Integer,String> newMap = new LinkedHashMap<>(); // this is store the elements in inserted order
for(Entry<Integer,String> e : list) newMap.put(e.getKey(),e.getValue());
```

Creating singleton class in java

```java
// this is called lazy initialization
class SingletonExample {
	public static SingletonExample singleton = null;
	private SingletonExample(){
	}
	public static SingletonExample getInstance(){
		if(singleton==null){
			singleton = new SingletonExample();
		}
		return singleton;
	}
}

//lazy initialization with thread safe singleton class in java
class SingletonExample {
	public static SingletonExample singleton = null;
	private SingletonExample(){
	}
	public static SingletonExample getInstance(){
		if(singleton==null){ 
			synchronized(SingletonExample.class){
				if(singleton == null){
					singleton = new SingletonExample();
				}
			}
		}
		return singleton;
	}
}
```


Difference between `Comparable` and `Comparator`

```java
class Employee {
	private String id;
	private int age;
	private int salary;
	private String fullName;
}

List<Employees> list  = new ArrayList<>();
// Comparable
class Employee implements Comparable {
	@Override // sort in ascending order based on age of the employee
	public int compareTo(Employee e2){
		return this.getAge() - e2.getAge();
	}
}
Collection.sort(list); // we can sort list of Employee that are of Comparable Type.

//Comparator
//age comparator
Collection.sort(list new Comparator<Employee>(){
	public int compare(Employee a, Employee b){
		return a.getAge() - b.getAge();
	}
});

// salary comparator
Collection.sort(list new Comparator<Employee>(){
	public int compare(Employee a, Employee b){
		return a.getSalary() - b.getSalary();
	}
});

```




















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