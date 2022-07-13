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

https://refactoring.guru/design-patterns/java

## Java Streams

```java
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        //stream operations on list
        List<Integer> list = List.of(1,34,33,2,4,34,333);
        //sort them in ascending order with distinct elements
        System.out.println("List: \n"+list.stream().sorted().distinct().collect(Collectors.toList()));
        //sort them in descending order with distinct elements
        System.out.println(list.stream().sorted(Collections.reverseOrder()).distinct().collect(Collectors.toList()));
        //filtering the list based on some values
        System.out.println(list.stream().filter(e->e>34).collect(Collectors.toList()));
        //sum up all the values of the list
        System.out.println(list.stream().reduce(0,(a,b)->a+b));
        
        
        // stream operation on set
        Set<Integer> set  = Set.of(2,78,3,12,34,45);
        // sort them in ascending order
        System.out.println("Set: \n"+set.stream().sorted().collect(Collectors.toList()) +" it is stored in list because set will not maintain the order" );
        // sort them in descending order
        System.out.println(set.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));
        //filter
        System.out.println(set.stream().filter(e->e>45).collect(Collectors.toList()));
        //reduce
        System.out.println(set.stream().reduce(0,(a,b)->a+b));
        
        //map operations using stream
        Map<Integer,Integer> map = Map.of(1,2,3,5,6,7,22,34,23,12,34,34,36,44);
        //sorting map in ascending order of key
        System.out.println(map.entrySet().stream().sorted((a,b)->a.getKey()-b.getKey()).collect(Collectors.toList()));
        // sorting map in descending order of the value
        System.out.println(map.entrySet().stream().sorted((a,b)->b.getValue()-a.getValue()).collect(Collectors.toList()));
        
        //Sort treeMap by reverseOrder of Kye
        TreeMap<Integer,Integer> tMap = new TreeMap<>(Collections.reverseOrder());
        // we can't sort the treeMap based on values as it will defy the general rule of sorting based on key
        // but we can always use an external map to sort them based on value in ascending or descending order
        
        /////////////////////////////////general methods that we can apply ////////////////
        //using iterate in stream
        // generate 10 numbes from 1 to 10 
       Stream.iterate(1,i->i<=10,i->i+1).forEach(System.out::println);
        // we can also modify the object that we are printing
list.stream().filter(e->e%2==0).distinct().map(e->e+" ").forEach(System.out::print) ;
// getting total cost of the books 
List<Books> listOfBook = new ArrayList<>();
listOfBook.add(new Books(34.34));
listOfBook.add(new Books(56.67));
double totalCost = listOfBook.stream().mapToDouble(Books::getPrice).reduce(0,(sum,price)->sum+price);
System.out.println((totalCost));
        
    }
}
class Books{
    public Books(){}
    public Books(double p){this.price = p;}
    private double price;
    public double getPrice(){
        return this.price;
    }
    
}
```
Output: 
> List: 
[1, 2, 4, 33, 34, 333]
[333, 34, 33, 4, 2, 1]
[333]
441
Set: 
[2, 3, 12, 34, 45, 78] it is stored in list because set will not maintain the order
[78, 45, 34, 12, 3, 2]
[78]
174
[1=2, 3=5, 6=7, 22=34, 23=12, 34=34, 36=44]
[36=44, 22=34, 34=34, 23=12, 6=7, 3=5, 1=2]1
2
34
5
6
7
8
9
10
34 2 4 
91.01


## Design Pattern in java

Creational design pattern
Structural Design pattern
Behavioural design patten

# Creational design pattern

1. Factory Pattern (or factory design pattern)

We will have factory class that will return the object that we need without letting the end user know 
how the object got created. 

```java
public class OsFactory {
	public OS getInstanceOfOs(String  str){
		if(str.equals("open")) return new Android();
		if(str.equals("secure")) return new IOS();
		if(str.equals("widelyUser")) return new Windows();
		else {
			return null;
		}
	}
}

public class MainClass{
	public static void main(String arg[]){
		OsFactroy fact = new OsFactory();
		OS os = fact.getInstanceOf("open");// we just have to as the user for the os that he want from the market lile open source, secure , or widelyUser os'
		os.getSpecsOfOs(); // this will get the info of that os , work done user doesn't know how the object got created.
	}
}
interface OS{
	public void getSpecsOfOs();
}
class Android implements OS{
	public void getSpecsOfOs(){
		System.out.println("Android phones are the best");
	}
}
class IOS implements OS{
	public void getSpecsOfOs(){
		System.out.println("IOS phones are the best");
	}
}
class Windows implements OS{
	public void getSpecsOfOs(){
		System.out.println("Windows phones are the best");
	}
}
```
2. Builder design Pattern

Its related to creating the object of the Class without worring about the order of initialization of the properties of the class

since, normally we use constructor for initialization of the object which is fine but what if there are tons of properties in the class, then you will have to be careful while initialization of the object of that class.

Hence to avoid this overhead we can use builder design patterns

```java
public MainClass{
	public static void main(String args[]){
		// we can forget about the worry of order of setting the values we can even skip certain properties and default values will be applied to them.

		Phone = new PhoneBuilder().setOs("android").setRam(8).setProcessor("mediatech").setScreenSize(56.5).getPhone();
		System.out.println(p);
	}
}
public class Phone{
	private String os;
	private int ram;
	private String processor;
	private double screenSize;
	public class Phone();
	public class Phone(String os, itn ram, String processor, double screenSize){
		// setting all the properties
	}
}
public class PhoneBuilder {
	//copy all the properties
	private String os;
	private int ram;
	private String processor;
	private double screenSize;

	//create setters only
	public PhoneBuilder setOs(String os){
		this.os = os;
		return this; // return object of the PhoneBuilder itself
	}
	public PhoneBuilder setRam(int ram){
		this.ram = ram;
		return this;
	}
	public PhoneBuilder setProcessor(String processor){
		this.processor = processor;
		return this;
	}
	public PhoneBuilder setScreenSize(double screenSize){
		this.screenSize = screenSize;
		return this;
	}
	//finally
	public Phone getPhone(){
		return newPhone(os,ram,processor,screensize);
	}
}
```
3. Singleton Design Pattern

```java
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

## Structural design pattern

1. Adaptor design pattern 
Example : You use iphone6 , and your friend uses iphone4 you went to his place but your phone died. You asked for charger to your friend he gave you iphone4 charger but, you can't charge iphone6 with iphone4 charger then your friend gave you an `Adaptor` that you can use to connect the charger of iphone4 and then you can plug the `Adaptor` to iphone6 and it will charge.

```java
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class MainClass {
    public static void main(String[] args) {
        Iphone6Charger i6Charger = new ChargerAdaptor();// since it is implementing the Iphone6Charger inteface
        ChargePhone chargePhone = new ChargePhone();
        chargePhone.setI6Charger(i6Charger); // set the charger of iphone6 given by ChargerAdaptor that will help us connect iphone4 charger to i6
        chargePhone.charge("finally the iphone6 is getting charged with iphone4's charger with the help of a ChargerAdaptor");
        System.out.println("charging done");
    }
}
// class will be dedicated to charge the phone 
class ChargePhone{
    // this will have a propery of Iphone6Charger to charge Iphone6
    private Iphone6Charger i6Charger;
    public void setI6Charger(Iphone6Charger i6Charger){
        this.i6Charger = i6Charger;
    }
    public void charge(String chargeMessage){
        this.i6Charger.chargeIPhone6(chargeMessage);
    }
}
// this Adaptor will help us charge iphoone6 with iphone4 charger
class ChargerAdaptor implements Iphone6Charger{
    Iphone4Charger chargerOfIphone4 = new Iphone4Charger();
    @Override
    public void chargeIPhone6(String chargeMessage){
        chargerOfIphone4.chargeIphone4(chargeMessage);
    }
}

interface Iphone6Charger{
    public void chargeIPhone6(String chargeMessage);
}
class Iphone4Charger{
    public void chargeIphone4(String chargeMessage){
        System.out.println(chargeMessage);
    }
}
```
> finally the iphone6 is getting charged with iphone4's charger with the help of a ChargerAdaptor
charging done

## Behavioral Design pattern

1. [Observer design Pattern](https://www.youtube.com/watch?v=98DiwRp-KZk&list=PLsyeobzWxl7r2ZX1fl-7CKnayxHJA_1ol&index=11)



