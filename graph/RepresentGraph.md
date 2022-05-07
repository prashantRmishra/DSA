

```java
    /*
    1. ADJACENCY MATRIX
    for undirected graph we can store the values in adjacency matrix,
    matrix of nxn.
    Disadvantage of using adjacency matrix:
        if no of edges are in 10^5 the we can not have matrix of that size as
        it will give memory problem.
        
    */

// representing graph using adjacency matrix
int n =3;
int m = 4;
int adj[][] = new int [n+1][n+1];
// and we can store values as 
//edge between 1 and 2
adj[1][2] = 1;
adj[2][1] = 1;
//similary
//edge between 2 and 3
adj[2][3] = 1;
adj[3][2] = 1;
//and so on ;
//adj[u][v]  =1;
//adj[v][u] = 1;

/*
2.ADJACENCY LIST
It is used to overcome the disadvantages of adjacency matrix

*/
ArrayList<ArrayList<Integer>> list = new ArrayList<>();
int n = 6;
for(int i =0;i<n;i++){
    list.add(new ArrayList<>());
}
//edge between 1 and 2
list.get(1).add(2);
list.get(2).add(1);
// similary we can do for all the nodes and their respective edges that they share with each other in undirected graph.

//IMPORTANT
//If weight is also present in the edge like u,v,w where u and v node have the edge and the w is the weight.
// we can store teh edge and teh weight in the pair of integer format.
List<ArrayList<Pair<Integer,Integer>>> list = new ArrayList<>();
```
