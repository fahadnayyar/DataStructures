
public class GraphMatrix {
	private int adjMat[][];
	private int vertexNo;
	public GraphMatrix(int size) {
		this.vertexNo=size;
		adjMat=new int[size][size];
	}
	public void Add(int i,int j) {
		if (i>=0 && i<vertexNo && j<vertexNo && j>=0) {
			adjMat[i][j]=1;
		}
	}
	public void remove(int i, int j) {
		if (i>=0 && i<vertexNo && j<vertexNo && j>=0) {
			adjMat[i][j]=0;
		}
	}
	public boolean isEdgePresent(int i, int j) {
		if (i>=0 && i<vertexNo && j<vertexNo && j>=0) {
			return adjMat[i][j]==1;
		}
		return false;
		
	}
}
