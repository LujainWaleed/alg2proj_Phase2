package GraphFramework;

public class Edge {
    
//data fields
Vertex parent;
Vertex target;
Vertex source;	
int weight;

//constructors
public Edge() {
    parent= new Vertex();
    target= new Vertex();
    source= new Vertex(); }

public Edge(Vertex source ,Vertex target ,int weight) {
    parent= new Vertex();
    this.target= target;
    this.source= source;
    this.weight= weight; }


//--------------------------------------------------
//displayInfo method 
public void displayInfo(){ System.out.println("-------------------------------------------------\n--- route length: "+ weight); }

    
}
