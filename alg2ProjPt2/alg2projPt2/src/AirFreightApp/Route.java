package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

public class Route extends Edge {
//data field
private int LLength;

//constructor
public Route(Vertex Source ,Vertex Target ,int weight) {
    super(Source ,Target ,weight);
    this.LLength= weight*5; }


//--------------------------------------------------
//DisplayInfo method 
@Override
public void displayInfo(){ System.out.print(" : line length: "+ LLength); }

} 
