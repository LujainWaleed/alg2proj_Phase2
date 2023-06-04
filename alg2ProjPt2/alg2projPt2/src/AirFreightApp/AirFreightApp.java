/*
- algorthim project part'2'
- group 13
- members:
- Raghad Ahmed "B8"
- Manar Alnahdi	"B0B"
- Lujain Aljahdali "B0B"
- Alanood Alotaibi "B0A"
*/


package AirFreightApp;

import GraphFramework.DBAllSourcesSPAlg;
import GraphFramework.Graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AirFreightApp {
public static void main(String[] args) throws FileNotFoundException {

    //print header stetments
    System.out.println("\t--------------------------------------------------------------------------\n"
                      +"\t|  implementation of dijkstra algorithm for source shortest path problem |\n"
                      +"\t--------------------------------------------------------------------------");
    System.out.println("\t1. Requirement 1: Read gragh from file\n"
                      +"\t2. Requirement 2: Make gragh\n");

    //create Scanner object to read from user
    Scanner input= new Scanner(System.in); 

    //ask user to enter his\her choice
    System.out.print("\t> Enter your choice: ");
    int userChoice= input.nextInt();

    //if user enter wrong choice ask him\her to enter again
    while( userChoice!=2 && userChoice!=1){
        System.out.println("\t  Wrong choice!");
        System.out.print("\t> Enter your choice: ");
        userChoice= input.nextInt(); }

    //create object for dijkstra algorithms
    DBAllSourcesSPAlg dijkstra;  

    //if user choose requirement'1' 
    if( userChoice==1 ){
        System.out.println("\n\n\t***** Requirement 1: Read gragh from file *****");

        //create file object
        File graphFile= new File("graph.txt");

        //check if file exist or not
        if( !graphFile.exists() ){
            System.out.println("The file does not exist!");
            System.exit(0); }

        //create AFRouteMap object then call readGraphFromFile method
        Graph Airfreight= new AFRouteMap();
        Airfreight.readGraphFromFile(graphFile);

       //find source shortest path using dijkstra algorthim  
       //read graph in dijkstra Algoirthm then display pathes & compute runninig time
       dijkstra= new DBAllSourcesSPAlg(Airfreight);
       long djksStart= System.currentTimeMillis();
       dijkstra.computeDijkstraBasedSPAlg(true);
       long djksEnd= System.currentTimeMillis(); 
       System.out.println("\n------------------------------------------");
       System.out.println("Running time for dijkstra Algorithm is: "+ ( djksEnd-djksStart ) );
       System.out.println("------------------------------------------");       
    }



    //if user choose requirement'2' 
    else if( userChoice==2 ){
        //print header of requirement'2'
        System.out.println("\n\n\t***** Requirement 2: Make gragh  *****\n");
        System.out.println("Choice one of the Cases to test (Vertcies(n) and Edges(m)):");
        System.out.println("1. n=2000 , m=10000\n2. n=3000 , m=15000\n3. n=4000 , m=20000"
                          +"\n4. n=5000 , m=25000\n5. n=6000 , m=30000");

        //create 2 variables for number of edges &vertices
        int numOfVertices= 0;
        int numOfEdges= 0; 

        //ask user to enter his\her choice the make do-while for choices
        System.out.print("\n> Enter your choice: ");
        do {//read from user
          userChoice= input.nextInt();
          if ( userChoice==1 ){	         
                numOfVertices= 2000;
                numOfEdges= 10000; }

          else if( userChoice==2 ){
                numOfVertices= 3000;
                numOfEdges= 15000; }

          else if( userChoice==3 ){
                numOfVertices= 4000;
                numOfEdges= 20000; }

          else if( userChoice==4 ){
                numOfVertices= 5000;
                numOfEdges= 25000; }

          else if( userChoice==5 ){
                numOfVertices= 6000;
                numOfEdges= 30000; }

          else{//if user enter wrong choice ask him\her to enter again
               System.out.println("  incorrecet choice!");
               System.out.print("> Enter your choice: "); }

        }while( userChoice<1 || userChoice>5 );


        //create AFRouteMap Object then call makeGraph method
        Graph Airfreight= new AFRouteMap(numOfVertices ,numOfEdges ,false);  
        Airfreight.makeGraph(numOfVertices ,numOfEdges);

        //make graph dijkstra algorithm then display pathes & compute runninig time
        dijkstra= new DBAllSourcesSPAlg(Airfreight); 
        long djksStart= System.currentTimeMillis();   
        dijkstra.computeDijkstraBasedSPAlg(false);  
        long djksEnd= System.currentTimeMillis(); 
        System.out.println("\n-------------------------------------------");
        System.out.println("Running time for dijkstra Algorithm: "+ ( djksEnd-djksStart ) );
        System.out.println("-------------------------------------------");
        
    }

    
    //close file
    input.close();
    System.out.println("\n\nThank you :)");       
}


}
