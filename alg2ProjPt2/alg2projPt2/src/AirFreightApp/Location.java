package AirFreightApp;

import GraphFramework.Vertex;

public class Location extends Vertex {
//data field   
private String city;

//constructor
public Location(int Label){
    super(Label);
    this.city= String.valueOf( (char)(Label+ 65) ); }


//--------------------------------------------------
//overriding displayInfo methods
@Override
public String displayInfo(){ return "loc."+ city +": city "+ (label+ 1); } 

}