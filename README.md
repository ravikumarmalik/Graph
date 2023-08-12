# Graph

# Java Graph
In Java, the Graph is a data structure that stores a certain of data. The concept of the graph has been stolen from the mathematics that fulfills the need of the computer science field. It represents a network that connects multiple points to each other. In this section, we will learn Java Graph data structure in detail. Also, we will learn the types of Graph, their implementation, and traversal over the graph.

# Graph
A graph is a data structure that stores connected data. In other words, a graph G (or g) is defined as a set of vertices (V) and edges (E) that connects vertices. The examples of graph are a social media network, computer network, Google Maps, etc.

Each graph consists of edges and vertices (also called nodes). Each vertex and edge have a relation. Where vertex represents the data and edge represents the relation between them. Vertex is denoted by a circle with a label on them. Edges are denoted by a line that connects nodes (vertices).

# Graph Terminology
Vertex: Vertices are the point that joints edges. It represents the data. It is also known as a node. It is denoted by a circle and it must be labeled. To construct a graph there must be at least a node. For example, house, bus stop, etc.

# Edge:
An edge is a line that connects two vertices. It represents the relation between the vertices. Edges are denoted by a line. For example, a path to the bus stop from your house.

# Weight:
It is labeled to edge. For example, the distance between two cities is 100 km, then the distance is called weight for the edge.

# Path:
The path is a way to reach a destination from the initial point in a sequence.

# Types of Graph
# Weighted Graph:
In a weighted graph, each edge contains some data (weight) such as distance, weight, height, etc. It denoted as w(e). It is used to calculate the cost of traversing from one vertex to another. The following figure represents a weighted graph.


# Unweighted Graph: 
A graph in which edges are not associated with any value is called an unweighted graph. The following figure represents an unweighted graph.



# Directed Graph:
A graph in which edges represent direction is called a directed graph. In a directed graph, we use arrows instead of lines (edges). Direction denotes the way to reach from one node to another node. Note that in a directed graph, we can move either in one direction or in both directions. The following figure represents a directed graph.

# Undirected Graph: 
A graph in which edges are bidirectional is called an undirected graph. In an undirected graph, we can traverse in any direction. Note that we can use the same path for return through which we have traversed. While in the directed graph we cannot return from the same path.

# Connected Graph:
A graph is said to be connected if there exists at least one path between every pair of vertices. Note that a graph with only a vertex is a connected graph.

# There are two types of connected graphs.
Weekly Connected Graph: A graph in which nodes cannot be visited by a single path is called a weekly connected graph.

# Strongly Connected Graph: 
A graph in which nodes can be visited by a single path is called a strongly connected graph.

# Disconnected Graph:
A graph is said to be disconnected if there is no path between a pair of vertices is called a disconnected graph. A disconnected graph may consist of two or more connected graphs.

# Multi Graph: 
A graph that has multiple edges connecting the same pair of nodes. The following figure represents a multi-graph.


# Java Graph Implementation
For the implementation of graphs in Java we will use the Generic class. To create an object of Java Generic class, we use the following syntax:

BaseType <ParameterType> obj = new BaseType <ParameterType>();  

Remember that, we cannot use primitive type for parameter type.


# Graph Traversal
Traversal over the graph means visit each and every vertex and edge at least once. To traverse over the graph, Graph data structure provides two algorithms:

# Depth-First Search (DFS)
# Breadth-First Search (DFS)

# Depth-First Search (DFS)
DFS algorithm is a recursive algorithm that is based on the backtracking concept. The algorithm starts from the initial node and searches in depth until it finds the goal node (a node that has no child). Backtracking allows us to move in the backward direction on the same path from which we have traversed in the forward direction.



# Breadth First Search (BFS)
BFS algorithm is the most common approach to traverse over the graph. The traversal starts from the source node and scans its neighboring nodes (child of the current node). In short, traverse horizontally and visit all the nodes of the current layer. After that, move to the next layer and perform the same.


