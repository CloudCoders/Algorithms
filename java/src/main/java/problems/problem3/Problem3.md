Hey!!

In this problem we must check that in the graph all vertex have 1 inward edge except 1 vertex that have 0 inward edges.
All these must be done with a temporal cost of O(|V|+|E|) being |V| the number of vertices and |E| the number of edges.

The way that graphs are now implemented is the next: 

We keep a List for all vertices in our graph called "vertices".
We keep a map that link each vertex with a list of PairVertexDistance, one per each adjacent vertex. Each PairVertexDistance contains 
the adjacent vertex and the distance between the original vertex and the adjacent vertex.

We no longer can work with arrays to keep information about visited etc now that we are working with genericiti. Instead
we can use maps. For example if you want to keep information about what vertices you have visited you create a map, put 
for each vertices a false value. Whean you want to know if you've already visited that vertices you chek it with map.get(vertex) == true (== true is redundant)

FOR IMPLEMENTING THE PROBLEM:

The way to proceed is extending DirectedGraph and implementing a method "public boolean checkProblem3()"


To take care: 
There is a very simple test while implementig a in-depth test. 
Altough there are methods like getInwardsEdges etc the idea is to make it without that methods.
