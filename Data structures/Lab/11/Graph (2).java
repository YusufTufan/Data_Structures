public class Graph<T extends Comparable> {
    private Vertex<T> graphHead;

    public void addVertex(T id) {
        Vertex<T> newVertex = new Vertex<>(id);
        if (graphHead == null) {
            graphHead = newVertex;
        }
        else {
            Vertex<T> iterator = graphHead;
            while (iterator.nextVertex != null) {
                iterator = iterator.nextVertex;
            }
            iterator.nextVertex = newVertex;
        }
    }
    public Vertex<T> findVertex(T id) {
        Vertex<T> iterator = graphHead;
        while (iterator != null) {
            if(iterator.vertexID.compareTo(id) == 0)
                return iterator;
            iterator = iterator.nextVertex;
        }
        return iterator;
    }
    public void addEdge(T startingVertexID, T endingVertexID) throws Exception {
        Vertex<T> startVertex = findVertex(startingVertexID);
        if(startVertex == null)
            throw new Exception("vertex bulunamadı");
        Edge<T> newEdge=new Edge(endingVertexID);
        if(startVertex.edgeLink == null)
            startVertex.edgeLink = newEdge;
        else{
            Edge<T> iterator = startVertex.edgeLink;
            while(iterator.nextEdge != null) {
                iterator = iterator.nextEdge;
            }
            iterator.nextEdge = newEdge;
        }

    }
    public void display(){
        Vertex<T> iterator = graphHead;
        while(iterator != null) {
            System.out.print(iterator.vertexID);
            Edge<T> iteratorEdge = iterator.edgeLink;
            if(iteratorEdge!=null) {
                while (iteratorEdge != null) {
                    System.out.print("--->" + iteratorEdge.vertexID);
                    iteratorEdge = iteratorEdge.nextEdge;
                }
            }
            iterator = iterator.nextVertex;
            System.out.println();
        }
    }
    public int outDegree(T vertexID){
        int count=0;
        Vertex<T> vertex = findVertex(vertexID);
        if(vertex!=null){
            Edge<T> iterator = vertex.edgeLink;
            while(iterator!=null){
                count++;
                iterator = iterator.nextEdge;
            }
        }
        return count;

    }
    public int inDegree(T vertexID){
        int count=0;
        Vertex<T> iterator=graphHead;
        while(iterator!=null){
            Edge<T> iteratorEdge = iterator.edgeLink;
            while(iteratorEdge!=null){
                if(iteratorEdge.vertexID.compareTo(vertexID) == 0)
                    count++;
                iteratorEdge = iteratorEdge.nextEdge;
            }
            iterator = iterator.nextVertex;
        }
        return count;
    }
    public int vertexCount(){
        Vertex<T> iterator = graphHead;
        int count=0;
        while(iterator!=null){
            count++;
            iterator = iterator.nextVertex;
        }
        return count;
    }
    //vertex id dizide index olacak şekilde ayarlanmıştır
    //aksi takdirde bu metod çalışmaz
    public int[][] adjacencyMatrix(){
        int [][] matrix=new int[vertexCount()][vertexCount()];
        Vertex<T> iterator = graphHead;
        //int'e cast etmek mümkün
        //matrix[(int)(iterator.vertexID)][(int)iterator.vertexID]=1;

        while(iterator!=null){
            Edge<T> iteratorEdge = iterator.edgeLink;
            while(iteratorEdge!=null){
                matrix[(int)(iterator.vertexID)][(int)(iteratorEdge.vertexID)]=1;
                iteratorEdge = iteratorEdge.nextEdge;
            }
            iterator = iterator.nextVertex;
        }
        return matrix;
    }




}
