package GraphFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import AirFreightApp.AFRouteMap;

public class Graph {
    //data fields 
    public Vertex[]Vertices; 
    Graph Map; 
    Boolean isDigraph;
    public int verticesNO;
    int edgeNO;

//constructors     
public Graph(){}

public Graph(int verticesNO ,int edgeNO ,boolean isDigraph){
    this.Vertices= new Vertex[verticesNO]; 
    this.isDigraph= isDigraph;
    this.verticesNO= verticesNO;
    this.edgeNO= edgeNO; }


//----------------------------------------------------------------------------------
//createVertex method
public Vertex createVertex(int label){ return new Vertex(label); }

//createEdge method   
public Edge createEdge(Vertex Source ,Vertex Target ,int weight){ return new Edge(Source ,Target ,weight); }


//addEdge method	
public Edge addEdge(int v, int u, int w){

    Graph Map= new AFRouteMap();

    //to remove duplication first increment number of vertices then create source vertex
    if( Vertices[v]==null ){ 			
        verticesNO++;
        Vertices[v]= Map.createVertex(v); }

    //to remove duplication first increment number of vertices then create target vertex
    if( Vertices[u]==null ){
        verticesNO++; 
        Vertices[u]= Map.createVertex(u); }      		

    //now we create new edge then increment number of edges       
    Edge NewEdge= Map.createEdge(Vertices[v] ,Vertices[u] ,w);
    edgeNO++; 

    //add edge with weight after access vertex AdjList     		 
    Vertices[v].AdjList.add(NewEdge);

    //if graph is undirected so add undirectad edge after this increment number of egdes by'1'
    //then add edge with weight after access vertex AdjList   
    if( !isDigraph ){	   
        NewEdge= Map.createEdge(Vertices[u] ,Vertices[v] ,w);    		 
        edgeNO++;
        Vertices[u].AdjList.add(NewEdge); }

    //return the new edge
    return NewEdge;

} 


//--------------------------------------------------------------------------------
//method to read the graph from file  	
public void readGraphFromFile(File fileName) throws FileNotFoundException {
    //create Scanner object
    Scanner input= new Scanner(fileName); 

    String TypeOfGraph= input.nextLine();

    //check if if the graph is undirect'0' or direct'1'
    if ( TypeOfGraph.equalsIgnoreCase("digraph 1") ){ isDigraph = true; } 
    else if( TypeOfGraph.equalsIgnoreCase("digraph 0") ){ isDigraph= false; }

    //read numbers from file in second line which represent number of vertices then number of edges
    int TotalVerticesNO ,TotalEdgeNO;
    TotalVerticesNO= input.nextInt();
    TotalEdgeNO= input.nextInt(); 

    //if graph is undirected so multiplay total number of egdes by'2'
    if( !isDigraph ){ TotalEdgeNO *= 2;}

    //initializing the array
    Vertices= new Vertex[TotalVerticesNO]; 

    while( TotalEdgeNO >edgeNO ){
        char Source= input.next().charAt(0);
        char Destination= input.next().charAt(0);
        int Weight = input.nextInt();
        addEdge(Source- 65 ,Destination- 65 ,Weight); }

    input.close();          
} 


//--------------------------------------------------------------------------------
//method to make graph    	
public void makeGraph(int numOfvertices ,int numOfEdge) {
    //store the vetices
    for(int i=0; i<numOfvertices ;i++) Vertices[i]= new Vertex(i); 

    //store edges inorder to sure that all vetices connect & generate random weight
    for(int i=0; i<numOfvertices -1 ;i++) addEdge( Vertices[i].label ,Vertices[i+1].label ,(int)(1+Math.random()*10) ); 

    //add the rest of edges randomly 
    int counter= 0;
    while( ( numOfEdge- (numOfvertices- 1) )> counter){
            int Vvertex= (int)(Math.random()*numOfvertices);
            int Uvertex= (int)(Math.random()*numOfvertices);

            //prevent self-looped vertex by skip it then make new  vertices randomly
            if( Uvertex==Vvertex ){ continue; }

            //pervent duplication of edgee with same target &source by breaking if Uvertex & Vvertex not edge
            for(int j=0 ; j<Vertices[Uvertex].AdjList.size() ;j++)
                if( Vvertex!= Vertices[Uvertex].AdjList.get(j).target.label )  break;	

            //when there's no self-loop vertex exist & none existing edge so add new edge then increment loop counter
            addEdge( Vertices[Uvertex].label ,Vertices[Vvertex].label ,(int)(1+Math.random()*10) );
            counter++; }
}


} 



