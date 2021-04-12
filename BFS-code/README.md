# Home assignment

Code created to solve formulated problem. Takes multiple paths into consideration.

##Bonus question 1:

I decided to answer this question by already assuming multiple paths.
This is solved by the breadths first search algorithm (BFS) further explained in the code comments.

To get code that do not solve for multiple paths, modify/remove BFS step.

##Bonus question 2:

If we would assume that different paths are harder to take than others, or maybe that some paths can only be traversed
one-way. Then we do not have a symmetrical relationship matrix anymore, and thus we cannot use a adjacency list.
If we instead have a relationship matrix, we can easily state the weight of all the edges in the graph.

This problem formulation can be solved with Dijkstra's algorithm.

##Assumptions

This is what the assumptions made when constructing the code.

####Assumes user pics a location and then object

No differentiation between objects and locations in the code.
And the user is not hindered in any way from picking that their start location is an object for example.

Therefore situations can arise where the user is told to go via an object to get to a room,
it they have entered the wrong input data.

####Assumes correct config file

The code has no way of knowing if the input information in the config file is jibberish or not.
So it assumes that it is structured like example given in the assignment description.
Separated by either a ":" or " - ".

####Assumes no "graph islands"

The code assumes that all the nodes in the constructed graph are connected in some way.
That there are just one solid graph.





