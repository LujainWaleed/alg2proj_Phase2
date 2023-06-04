
package GraphFramework;

public class SingleSourceSPAlg {  
    //data fields
    int INFINITY= Integer.MAX_VALUE;
    Graph graph;
    String[]Path;
    int[]Distance;
		
//constructor
public SingleSourceSPAlg(Graph graph){ this.graph= graph; }


//--------------------------------------------------------------------
//computeDijkstraAlg method to compute shortest path for single source
public void computeDijkstraAlg(Graph graph ,Vertex Source) {
    this.graph= graph;

    //create 2 array to holds sshortest path with distance from source to evry vetrex
    Path= new String[graph.Vertices.length];
    Distance= new int[graph.Vertices.length];

    //first set infinity to all vertices distance
    for (int i=0; i<graph.Vertices.length; i++){
        Distance[i]= INFINITY;
        graph.Vertices[i].isVisited= false; }

    //set distance from source to itself is '0' then get source and hold it in path
    Distance[Source.label]= 0;
    Vertex soureV= graph.Vertices[Source.label];
    Path[Source.label]= soureV.displayInfo();

    //for-loop to go though array 
    for (int i=0; i<graph.Vertices.length-1 ;i++){
        //get min distance vertex among unvisited vertices and change this vertex to 'visit'
        int U= MinDistance(Distance);
        graph.Vertices[U].isVisited= true;


        //for-loop to go though edges 
        for (Edge edge:graph.Vertices[U].AdjList){
            Vertex V= edge.target;

            //if vertex unvisited & weight not equal '0' and not infinity
            if ( V.isVisited==false && edge.weight!=0 && edge.weight!=INFINITY ){
                //if traget distance greater than current distance plus current iterated edge so update distance & path arries
                //target location to new min distance then add it to path array
                if ( Distance[V.label] > Distance[U]+edge.weight ){
                    Distance[V.label]= Distance[U]+ edge.weight; 
                    Path[V.label]= Path[U] +" -> "+ V.displayInfo(); } 
            }//end of if-statment 
        }//end of inner-loop 
    }//end of outer-loop 
} 


//--------------------------------------------------------------------
//MinDistance method to compute minimum distance           
public int MinDistance(int[]SmallDis){
    int U= 0;
    int minDis= INFINITY;

    //for-loop to go though all vertices
    for (int i=0; i<graph.Vertices.length ;i++){
        //if vertex unvisited and smaller than minimum distance then update index of min vertex &min distance
        if ( graph.Vertices[i].isVisited==false && minDis>SmallDis[i] ) {
            U= i;
            minDis= SmallDis[i]; }          
    }
    
    //return index of minimum vertex
    return U;
}


//--------------------------------------------------------------------
//printResult method to display info. in required format
public void printResult(Vertex Source){
    String locationName= String.valueOf( (char)(Source.label+65) );
    System.out.println("\nThe starting point location is "+ locationName);
    System.out.println("The routes from location " +locationName +" to the rest of the locations are: ");

    //for-loop to go though all vertices
    for (int i=0; i<graph.verticesNO ;i++){
        
        //if distance negative or equal infinity or path equal null ,so display no path
        if(Distance[i]==INFINITY || Path[i]==null || Distance[i]<0)
            System.out.println(Source.displayInfo()+ " -> " + graph.Vertices[i].displayInfo()+" : There is no path");
        
        //else if distance not equal '0' means all paths exept path vertex to it-self, so diplay path with its length
        else if ( Distance[i]!=0 )
            System.out.println( Path[i] +" ~~ route length: "+ Distance[i]);
    }
    
    System.out.println("--------------------------------------------------");

} 
    
}

