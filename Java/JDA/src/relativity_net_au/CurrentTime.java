 
package relativity_net_au;

 
public class CurrentTime {
    public static void main(String[] args) {
        long currenttime = System.currentTimeMillis();
        
        long second =  currenttime / 1000;
        System.out.println("current Time = " + currenttime + " second " + second);
        
        
       // Interval 
        
       long start  =  System.nanoTime();
       long unixtime = System.currentTimeMillis();
       
       
       
         // display the value in unixTime
        System.out.println("Unix time = " + unixtime);
        
        long intervaltime =  System.nanoTime() - start;
        
        long out =  intervaltime / 1000;
        
        System.out.println("program execution " + intervaltime + " nanoseconds "+ " mili sec"  + out);
    }
}
