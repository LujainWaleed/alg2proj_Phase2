package GraphFramework;

import java.util.LinkedList;

public class Vertex {
//data fields
LinkedList<Edge> AdjList;
Boolean isVisited;
public int label; 

//constructors
public Vertex(){ AdjList= new LinkedList<>(); }

public Vertex(int label){
    AdjList= new LinkedList<>();
    this.isVisited= false;
    this.label= label; }


//-------------------------------------------------
//method to Display info.
public String displayInfo(){ return null; }

    
}
