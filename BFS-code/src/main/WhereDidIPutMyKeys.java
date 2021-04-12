package main;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/*-----------------------------------------------
Code created by: Mark Ekvall
E-mail: markekv@kth.se
Date: 2021-04-11

Further explanation on the code is provided in README-file
------------------------------------------------*/

public class WhereDidIPutMyKeys {


    LinkedList<Integer>[] adjList;              //adjacency list created. saves less space than adjacency matrix(since its symmetrical)
                                                //this would be changed if graph edges are weighted for example
    Set<String> nodeSet = new HashSet<>();      //Set of strings to save each vertex/node in the graph
    Set<String> nodePairs = new HashSet<>();    //Set of strings to save each node relationship (edge)


    public String userInputFileName() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter file name from resources map: ");
        return scanner.nextLine();
    }


    public int[] userInputStartAndEndLocation() {               //gets input data on user start position and desired end position

        Scanner scanner = new Scanner(System.in);
        int[] inputStartAndEndValue = new int[2];
        System.out.println("These are the provided objects:");
        System.out.println(nodeSet);

        while(true) {                                           //checking if the input value is valid
            System.out.println("Please state current location from the provided objects: ");
            inputStartAndEndValue[0] = getIndex(nodeSet, scanner.nextLine());
            if(inputStartAndEndValue[0]!=-1){break;}
            else{System.out.println("That is not a valid location");}
        }

        while(true) {                                           //checking if the input value is valid
            System.out.println("Which of the listed items do you wish to claim: ");
            inputStartAndEndValue[1] = getIndex(nodeSet, scanner.nextLine());
            if(inputStartAndEndValue[1]!=-1){break;}
            else{System.out.println("That is not a valid item");}
        }

        return inputStartAndEndValue;
    }


    public void addNode(int adjListSize) {            //adds a node/vertex to the adjacency list (
        adjList = new LinkedList[adjListSize];
        for(int i=0; i<adjListSize; i++) {
            adjList[i] = new LinkedList<>();         //linked list filled with each nodes neighbors
        }
    }


    public void addEdge(int nodeNumber, int edgeValue) {    //adds neighbors in each nodes linked list
        adjList[nodeNumber].add(edgeValue);
    }


    public static int getIndex(Set<String> set, Object value) {
        int result = 0;                                                    //gets index of word in nodeSet Set
        for (Object entry:set) {
            if (entry.equals(value)) return result;
            result++;
        }
        return -1;
    }


    public void getPathFromPositionToObject(int[] inputStartAndEndValue, int[] lastVisited) {

        String[] nodeArray = nodeSet.toArray(new String[0]);        //used to translate numbers to corresponding strings
        Stack<Integer> stack = new Stack<>();                       //used to get correct print order
        int i = inputStartAndEndValue[1];
        int amountOfPops=0;

        while(i!=inputStartAndEndValue[0]) {                        //will go through last visited array until it reaches start value
            i = lastVisited[i];
            stack.push(i);
            amountOfPops++;
        }

        amountOfPops--;
        System.out.println("You are currently located in the: " + nodeArray[stack.pop()]);
        for(int j=0; j<amountOfPops; j++) {
            System.out.println("Relocate to the: " + nodeArray[stack.pop()]);
        }
        System.out.println("Acquire the " + nodeArray[inputStartAndEndValue[1]]);
    }


    public void getConfigFileData() {

        while(true) {
            String fileName = userInputFileName();                  //get user input on file name
            try {
                File myObj = new File("resources/configdata/" + fileName);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] nodes = data.split(":| - ");    //takes out elements from the config file
                    Collections.addAll(nodeSet, nodes);               //takes unique elements and puts in Set
                    for (int i = 0; i < nodes.length; i++) {            //calculate adjacency
                        if (i != nodes.length - 1) {
                            nodePairs.add(nodes[i] + " " + nodes[i + 1]);       //save unique relationships between nodes
                        }
                    }
                }
                myReader.close();
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Filename that was entered was not found. Please try again.");
            }
        }
    }


    public void buildMatrixFromData() {

        addNode(nodeSet.size());                    //creates adjacency list with the same size as amount of nodes with a linked list in each element
        for (String nodePair : nodePairs) {
            String[] pairs = nodePair.split(" ");                                  //converts object to string and splits the space between the pairs
            addEdge(getIndex(nodeSet, pairs[0]), getIndex(nodeSet, pairs[1]));           //adds all relations between the nodes in a graph
            addEdge(getIndex(nodeSet, pairs[1]), getIndex(nodeSet, pairs[0]));          //This is added to enable us to move both was between nodes (can be modified if this where not the case)
        }
    }


    public int[] breadthsFistTraversal(int currentNode) {       //BFS is done since we assumed multiple paths

        boolean[] visited = new boolean[nodeSet.size()];    //mark all vertices not visited as not visited (false)
        LinkedList<Integer> queue = new LinkedList<>();     //creates queue for all neighbors of each node, that will get iterated though
        visited[currentNode] = true;                        //each node visited gets boolean value true, so that repetition does not happen
        queue.add(currentNode);
        int[] lastVisited = new int[nodeSet.size()];       //creates the array that saves each nodes shortest path to start node

        while(queue.size()!=0) {
            currentNode = queue.poll();
            for (int n : adjList[currentNode]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);                       //is adding the current node's neighbors to the queue
                    lastVisited[n] = currentNode;       //can sees knife as a room. which is wrong, but code works if the man only does after the objects
                }
            }
        }
        return lastVisited;
    }


    public static void main (String[] args) {
        WhereDidIPutMyKeys solution = new WhereDidIPutMyKeys();

        solution.getConfigFileData();                                                   //Is getting the input data from the config file
        solution.buildMatrixFromData();                                                 //Structures the data and builds a graph
        int[] inputStartAndEndValue = solution.userInputStartAndEndLocation();          //Asks user for start and end location in the graph. and saves it
        int[] lastVisited = solution.breadthsFistTraversal(inputStartAndEndValue[0]);   //Performs BTS and returns quickest path from each node to start node
        solution.getPathFromPositionToObject(inputStartAndEndValue, lastVisited);       //Prints results

    }
}