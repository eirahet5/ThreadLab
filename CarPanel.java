import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	               for(int i=0;i<30;i++)
	               {
	            	   direction = carQueue.deleteQueue();
	            	 //  x = x+10;
	            	   int y2 = y;
	            	   int x2 = x;
	            	   int otherx = 10;
	            	   int othery = 10;
	            	   // Adds 0,1,2 or 3 to queue

//                       switch(direction) 
//                       {
//                           case(0): y = !(y > 380) ? y + 10 : 0; break;
//                           case(1): y = !(y < 20) ? y - 10 : 0; break;
//                           case(2): x = !(x > 280) ? x + 10 : 0; break;
//                           case(3): x = !(x < 20) ? x - 10 : 0; break;
//                       }
	            	   switch(direction) 
	            	   {
	            	     case 0: y2 = y2 - othery;
	            	            break;
	            	     case 1: y2 = y2 + othery;
	            	     		break;
	            	     case 2: x2 = x2 + otherx;
	            	     		break;
	            	     case 3: x2 = x2 - otherx;
	            	   
	            	   }
                       if((x2 < 0 ) || (x2 > 300))
                    	   otherx = otherx*-1;
                       else if((y2 < 0) || (y2 > 400))
                    	   othery = othery *-1;
                       switch(direction) 
	            	   {
	            	     case 0: y = y - othery;
	            	            break;
	            	     case 1: y = y + othery;
	            	     		break;
	            	     case 2: x = x + otherx;
	            	     		break;
	            	     case 3: x = x - otherx;
	            	   
	            	   }
                    	   
                    	   

	            	   repaint();
	            	   Thread.sleep((int)delay*1000);
	            	   
	               }
	            }
	            catch (InterruptedException exception)
	            {
	            	 
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}