package edge_detection;


/**
 * @author conanz
 * 
 * Class for Written Assignment to implement for loop code and analyze run time.
 */
public class ForLoopTimeAnalysis 
{
    /**MAIN METHOD TO INITIALIZE CODE**/
    public static void main(String args[])
    {
        /**Initialize Necessary Variables**/
        //Time
        long start = System.nanoTime();//return time in nano seconds as a starting point to reference
        
        //Loop Variables
        int n = 250000000;//n iterations of for loop; time function takes increases as n increases
        int sum = 0;//sum variable for the for loop to alter; DOES NOT AFFECT big O analysis
        
        //print sum so we are "using" it, ugh; causes warning/error otherwise
        System.out.println("Printing " + sum + " (sum) because Eclipse is annoying");
        
        /**For Loops**/
        //Fragment 1
        for (int i=0; i<n; i++)
        {
            sum++;
        }
        
//        //Fragment 2 
//        for (int i=0; i<n; i+=2)
//        {
//            sum++;
//        }
        
//        //Fragment 3 
//        for (int i=0; i<n; i++)
//        {
//            for (int j=0; j<n; j++)
//            {
//                sum++;
//            }
//        }
        
//        //Fragment 4
//        for (int i=0; i<n; i++)
//        {
//            sum++;
//        }
//        for (int j=0; j<n; j++) 
//        {
//            sum++;
//        }
        
//        //Fragment 5 
//        for (int i=0; i<n; i++)
//        {
//            for (int j=0; j<n*n; j++)
//            {
//                sum++;
//            }
//        }
        
//        //Fragment 6 
//        for (int i=0; i<n; i++)
//        {
//            for (int j=0; j<i; j++) 
//            {
//                sum++;
//            }
//        }
        
//        //Fragment 7 
//        for (int i=0; i<n; i++)
//        {
//            for (int j=0; j<n*n; j++)
//            {
//                for (int k=0; k<j; k++)
//                {
//                    sum++;
//                }
//            }
//        }

//        //Fragment 8 
//        for (int i=1; i<n; i=i*2)
//        {
//            sum++;
//        }

//        /**QUESTION 4**/
//        for (int i=1; i<=n; i++)
//        {
//            for (int j=1; j<=i*i; j++) 
//            {
//                if  (j%i == 0)
//                {
//                    for (int k=0; k<j; k++) 
//                    {
//                        sum++;
//                    }
//                }
//            }
//        }

        /**Print Time**/
        long stop   = System.nanoTime();//return time in nano seconds as a stopping point to reference
        long total = stop - start;//calculate the amount of time that has passed
        
        System.out.println("Time: " + total + " nanoseconds");
    }
}
