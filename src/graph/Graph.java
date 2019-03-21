package graph;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.EOFException;
import java.util.*;

public class Graph extends JFrame {

	
	private JButton addb,deleteb,linkb,quit;
	private JPanel p1 ,p2;
	private Node node;
	private ArrayList list;
	public int f ;
	boolean flag =false ;
	
	public Graph() {
		super("Graph");
		addb= new JButton("Add Node");
		deleteb=new JButton("Delete Node");
		linkb=new JButton("Linked Node");
		quit=new JButton("exit");
		list =new ArrayList();
		addb.setFont(new Font("serise",Font.BOLD,15));
		deleteb.setFont(new Font("serise",Font.BOLD,15));
		linkb.setFont(new Font("serise",Font.BOLD,15));
		quit.setFont(new Font("serise",Font.BOLD,15));
		quit.setBackground(Color.LIGHT_GRAY);
		linkb.setBackground(Color.YELLOW);
		addb.setBackground(Color.WHITE);
		deleteb.setBackground(Color.PINK);
		p1=new JPanel();
		p1.add(addb);p1.add(linkb);p1.add(deleteb);p1.add(quit);
		p2=new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Node n1 =new Node();
				Node n2 =new Node();
				Point p1 ,p2 ;
				for (int i=0 ;i<list.size();i++) {
					n1=(Node)list.get(i);
					p1=new Point(n1.getPoint());
					g.setColor(Color.LIGHT_GRAY);
					g.fillOval(p1.x,p1.y, 40, 40);
					g.setColor(Color.red);
					g.drawString(""+n1.getnumnode(), p1.x+17, p1.y+25);
					g.setColor(Color.BLACK);
					g.drawOval(p1.x, p1.y, 40, 40);
				}
				
				for (int i=0 ;i<list.size();i++) {
					n1=(Node)list.get(i);
					p1=new Point(n1.getPoint());
					for(int j=i+1;j<list.size();j++) {
						n2=(Node)list.get(j);
						p2=new Point(n2.getPoint());
						for(int k = 0 ; k < 200; k++){
						if(n2.getnumnode()==n1.adj[k]&&n1.adj[k]!=-1) {
							g.setColor(Color.BLACK);
							 g.drawLine(p1.x+40 , p1.y+20 ,p2.x , p2.y+20 );
						}
						}
					}
				}
					
					if(flag){
						
						g.setColor(Color.LIGHT_GRAY);
						g.fillOval(node.getPoint().x , node.getPoint().y , 40 , 40);
						g.setColor(Color.RED);
						g.drawString("" + node.getnumnode() , node.getPoint().x + 17, node.getPoint().y + 25);
						g.setColor(Color.BLACK);
						g.drawOval(node.getPoint().x , node.getPoint().y , 40 , 40);
			      
					}

			}
		};
		add(p1 ,BorderLayout.SOUTH);
		add(p2,BorderLayout.CENTER);
		
		
		Ghundler hundler =new Ghundler();
		addb.addActionListener(hundler);
		deleteb.addActionListener(hundler);
		linkb.addActionListener(hundler);
		quit.addActionListener(hundler);
		
		
		
		p2.setBackground(Color.WHITE);
		p2.addMouseListener(new MouseAdapter() {
			@Override 
			public void mousePressed(MouseEvent e) {
				Node node1 =new Node();
				Node node2 =new Node();
				String Numofnode;
				
				for(int i=0 ;i<list.size();i++) {
				node1=(Node)list.get(i);
				if(((e.getX() < node1.getPoint().x + 40 )&&(e.getX() > node1.getPoint().x))
						 &&((e.getY() < node1.getPoint().y + 40 )&&(e.getY() > node1.getPoint().y))){
							
					            	f = node1.getnumnode();
				
				}
				if(e.isMetaDown()) {
					
					  int x =e.getX();
					  int y=e.getY();
					 node1.setPoint(x, y);
					 
					 
				}
				
				
				flag=false;
				repaint();
				
			}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Node n =new Node();
				for(int i=0 ;i<list.size();i++) {
					n=(Node)list.get(i);
					
					
					if(n.getnumnode()==f)
					
					
						 
						n.setPoint(e.getX(), e.getY());
					 
						flag=false;
					
					
					
					
					
					
					
					
				}
				repaint();
				
			}
		});
		
		p2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Node n=new Node();
				for(int i=0; i<list.size();i++) {
					n=(Node) list.get(i);
					if(n.getnumnode()==f)
						n.setPoint(e.getX(), e.getY());
					 
						flag=true;
					
					
					
					
					
					
					
					
				}
				repaint();
				
			}
			
			
			
			
		});
		
		
		
		
	}
	
	private class Ghundler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==addb) {
		      node=new Node();
		      String n;
		      int x = (int)(400*Math.random());
		      int y= (int)(400*Math.random());
		      try {
		    	  n=JOptionPane.showInputDialog(Graph.this,"Enter Your Node");
		    	  if(Integer.parseInt(n)<0) {
		    		  throw new IllegalArgumentException();
		    	  }
		    	  Node n1=new Node();
		    	  for(int i=0 ;i<list.size();i++) {
		    		  n1=(Node)list.get(i);
		    		  if(n1.getnumnode()==(Integer.parseInt(n))) {
		    		  throw new exception1();
		    	  }
		    	  }
		    	  node.setnumnode(Integer.parseInt(n));
		    	  node.setPoint(x, y);
		    		list.add(node);
		    		repaint();
		    	  }
		    	  
		      catch (NumberFormatException ex) {
		    	  JOptionPane.showMessageDialog(Graph.this, "The Number of node Must be Integer");

		      }
		      catch(IllegalArgumentException ex) {
		    	  JOptionPane.showMessageDialog(Graph.this, "Number of vertices must be nonnegative");  
		      }
		
				catch (exception1 ex) {
					JOptionPane.showMessageDialog(Graph.this, "Try One With Different Numofnode");
					
					
				}
		      
				
				
				
				
				
				
				
			}
			else if(e.getSource()==quit) {
				System.exit(0);
			}
			else if(e.getSource()==linkb) {
				String s ,s1;
				Node temp1=new Node();
				Node temp2=new Node();
				
			try {
				boolean flag1=false;
				boolean flag2=false;
				boolean flag3=false;
				 s=JOptionPane.showInputDialog(Graph.this,"Enter Your First Node");
				 if(Integer.parseInt(s)<0) {
		    		  throw new IllegalArgumentException();
		    	  }
				 for(int i=0 ;i<list.size();i++) {
					 temp1 = (Node)list.get(i);
					 if(temp1.getnumnode()==(Integer.parseInt(s))) {
						flag1 =true; 
					 }
				 }
					 if(!flag1) 
						 throw new exception2();
					 
					 s1=JOptionPane.showInputDialog(Graph.this,"Enter Your sec Node");
					 if(Integer.parseInt(s1)<0) {
			    		  throw new IllegalArgumentException();
			    	  }
					 for(int j=0 ;j<list.size();j++) {
						 temp2 = (Node)list.get(j);
						 if(temp2.getnumnode()==(Integer.parseInt(s1))) {
							flag2 =true; 
						 }
					 }
						 if(!flag2) 
							 throw new exception2();
						 
					if((Integer.parseInt(s))==(Integer.parseInt(s1))) {
						throw new exception1();
					}
					for(int k=0;k<200;k++) {
						if(temp1.adj[k] == Integer.parseInt(s1))
							flag3 = true;
				    	 }
					if(flag3)
				    throw new exception3();
					Node link=new Node();
					for(int i = 0 ; i < list.size() ; i++){
						 link = (Node)list.get(i);
						 
						  if(link.getnumnode()== Integer.parseInt(s1))
							 link.adj[link.cont++] = Integer.parseInt(s); 
						  
						  if(link.getnumnode() == Integer.parseInt(s))
							 link.adj[link.cont++]=Integer.parseInt(s1); 
				}
					 
					 repaint();
					
					
					
					
					
					
					}
					
					
					
					
					
					
				 
			
				catch(exception2 ex) {
					JOptionPane.showMessageDialog(Graph.this, "This Node  not Found");
					
				}
				catch(exception1 ex1) {
					JOptionPane.showMessageDialog(Graph.this , "Can't Link A Node To It Self");	
			}
			catch(exception3 ex2) {
				JOptionPane.showMessageDialog(Graph.this , "The Link Is Already Added");
			}
			 catch (NumberFormatException ex3) {
		    	  JOptionPane.showMessageDialog(Graph.this, "The Number of node Must be Integer");

		      }
                catch(ArrayIndexOutOfBoundsException ex4){
				
				JOptionPane.showMessageDialog(Graph.this , "You Can Only Make A Link With 100 Node");
    		}
			catch(IllegalArgumentException ex) {
		    	  JOptionPane.showMessageDialog(Graph.this, "Number of vertices must be nonnegative");  
		      }
			
			
			
			
			
			
			
		}
			if(e.getSource()==deleteb) {
				
				
			
				boolean flag1 =false ;
			
				try {
					String num=JOptionPane.showInputDialog(Graph.this,"Enter the Number Node");
					if(Integer.parseInt(num)<0) {
			    		  throw new IllegalArgumentException();
			    	  }
					
					for(int i=0;i<list.size();i++) {
						node=(Node)list.get(i);
						if(node.getnumnode()==Integer.parseInt(num)) {
							flag1=true;
						}
					}
						if(!flag1)
							throw new exception1();
						for(int k=0 ;k<list.size();k++) {
							node=(Node)list.get(k);
							if(node.getnumnode()==Integer.parseInt(num)) {
								for(int j = 0 ; j < 200 ; j++){
									node.adj[j]=-1;
									
								}
								
										list.remove(k);
										repaint();
							}
						}
						
						
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				}
				catch (NumberFormatException ex) {
			    	  JOptionPane.showMessageDialog(Graph.this, "The Number of node Must be Integer");

			      }
				catch(IllegalArgumentException ex) {
			    	  JOptionPane.showMessageDialog(Graph.this, "Number of vertices must be nonnegative");  
			      }
				catch(exception1 ex) {
					JOptionPane.showMessageDialog(Graph.this, "This Node  not Found");
					
					
				}
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
	}
	
	
	class exception1 extends Exception {
		
		public exception1(){
			
			super();
		}
	}

	class exception2 extends Exception {
		
		public exception2(){
			
			super();
		}
	}

	class exception3 extends Exception {
		
		public exception3(){
			
			super();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

