# Few methods to keep in minds while solving DSA question

Sorting 2D array (int) 
---

Scenario : {
    Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
    The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2)
}
```java
Arrays.sort(arr, Comparator.comparingInt(e->e[0]*e[1] + e[1]*e[1]));
```