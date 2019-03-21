package graph;
import java.awt.Point;


public class Node {

	
	public int []adj;
	private int numofnode;
	private Point point;
	public int cont =0;
	
	public Node() {
		
	
		point =new Point();
		adj=new int[200];
		for(int i=0 ;i<200;i++) {
			adj[i]=-1;
		}
	}
	
	public void setnumnode (int z) {
		numofnode=z;
	}
	public int getnumnode() {
		return numofnode;
	}
	public void setPoint(int x , int y){
		point.x = x;
		point.y = y;
	}
	
	public Point getPoint(){
		return point;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
