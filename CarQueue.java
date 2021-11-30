import java.util.ArrayDeque;
import java.util.Random;
/**
 * 
 * @author evelyn
 *
 */
public class CarQueue {

	private ArrayDeque<Integer> queue;
	Random ranNum = new Random();
	/**
	 * 
	 */
	public CarQueue()
	{
		queue = new ArrayDeque<Integer>();
		for(int i = 0; i<10; i++)
		{
			queue.add(ranNum.nextInt(4));
		}
	}
    /**
     * 
     */
	public void addToQueue() 
	{
		class MyRunnable implements Runnable
		{

			@Override
			public void run() 
			{
				while(true)
				{
					try {
					queue.add(ranNum.nextInt(4));
					Thread.sleep(500);
					
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					
				}
				
			}
			
		}
       MyRunnable r = new MyRunnable();
	   Thread t = new Thread(r);
		t.start();

		
	}
	/**
	 * 
	 * @return
	 */
	public int deleteQueue() 
	{
		
		return queue.remove();
	}

}
