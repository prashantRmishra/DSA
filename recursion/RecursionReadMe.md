# There could be two types of recursion
1. Parameterized recursion
2. Functional recursion

Print sum from 1 to n 

##### Parameterized Recursion

```java
f(int i ,int sum ){
    if(i <1) return sum ;
    return f(i-1,sum+i);
}
//call as f(3,0) // will give 6 
```
##### Functional Recusion

```java
f(int i ){
    if(i==0) return 0;
    return i + f(i-1);
}
//call as f(3); // this will also return 6;
```
    Note: Similary we can  calculate the factorial of the given number n (we can use both Parameterized as well as functional recursion approach)
