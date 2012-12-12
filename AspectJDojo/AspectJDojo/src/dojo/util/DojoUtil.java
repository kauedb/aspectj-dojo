package dojo.util;

public class DojoUtil {
	
	public static void simulateProcessing(){
		
			Long time = new Double(Math.random() * 1000 * 10).longValue();
			try{
				Thread.sleep(time);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(time > 5000){
				throw new RuntimeException("Timout");
			}
			
		
	}
	
}
