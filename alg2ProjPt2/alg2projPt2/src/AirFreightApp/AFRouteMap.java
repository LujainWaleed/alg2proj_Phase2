package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;

public class AFRouteMap extends Graph {
    
//constructors
public AFRouteMap(){}

public AFRouteMap(int verticesNO ,int edgeNO ,boolean isDigraph){ super(verticesNO,edgeNO,isDigraph); }


//--------------------------------------------------
//overriding createVertex & createEdge methods
@Override
public Vertex createVertex(int label){ return new Location(label); }

@Override
public Edge createEdge(Vertex Source ,Vertex Target ,int weight){ return new Route(Source ,Target ,weight); }

}
