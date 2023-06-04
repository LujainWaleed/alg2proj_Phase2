package GraphFramework;

public class DBAllSourcesSPAlg extends ShortestPathAlgorithm {
    
//create SingleSourceSPAlg object    
SingleSourceSPAlg singleSrc= new SingleSourceSPAlg(graph);

//constructor
public DBAllSourcesSPAlg(Graph graph){ this.graph= graph; }


//method to compute shortest path for all source using dijkstra algorthim
public void computeDijkstraBasedSPAlg(boolean printFlag){
    
   //call computeDijkstraAlg method that compute shortest path for single source 
   //inside for-loop to go through all vertices and compute shortest path for everyone of them  
  for (int i = 0; i < graph.verticesNO; i++) {
      //create source vertex then call computeDijkstraAlg method after that print all
      //pathes for requirement'1' but not for requirement'2',this's the reasoen we using for 'printFlag'
      Vertex source =  graph.Vertices[i];
      singleSrc.computeDijkstraAlg(graph,source);
      if (printFlag)
        singleSrc.printResult(source);
   }

}
   
    
     
}  