/**
 * 
 */
package edge_detection;

/**
 * @author conanz
 *
 * Class for Written Assignment to implement for loop code and analyze and verify values.
 */
public class ForLoopValue
{
    /**MAIN METHOD TO CALL TEST FUNCTIONS**/
    public static void main(String args[])
    {
        //Print values
//        fragmentOne();
//        fragmentTwo();
//        fragmentThree();
//        fragmentFour();
//        fragmentFive();
//        fragmentSix();
//        fragmentSeven();
//        fragmentEight();
        
        questionFour();
        
        //Print big O function guesses
//        verifyOne();
//        verifyTwo();
//        verifyThree();
//        verifyFour();
//        verifyFive();
//        verifySix();
//        verifySeven();
//        verifyEight();
        
        verifyQuestionFour();
    }

/**------------------------------------------------------------------------------VALUE PRINT-------------------------------------------------------------------------------------------------**/
    /**FUNCTION TO PRINT VALUES OF FOR LOOP FRAGMENT 1**/
    static void fragmentOne()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            //Create new sum for every value of n to print
            int sum = 0;
            
            /**Fragment 1**/
            for (int i=0; i<n; i++)
            {
                sum++;
            }
            
            System.out.println("Term " +n+" = "+sum);
        }
    }
    
    /**FUNCTION TO PRINT VALUES OF FOR LOOP FRAGMENT 2**/
    static void fragmentTwo()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            //Create new sum for every value of n to print
            int sum = 0;
            
            /**Fragment 2**/
            for (int i=0; i<n; i+=2)
            {
                sum++;
            }
            
            System.out.println("Term " +n+" = "+sum);
        }
    }
    
    /**FUNCTION TO PRINT VALUES OF FOR LOOP FRAGMENT 3**/
    static void fragmentThree()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            //Create new sum for every value of n to print
            int sum = 0;
            
            /**Fragment 3**/
            for (int i=0; i<n; i++)
            {
                for (int j=0; j<n; j++)
                {
                    sum++;
                }
            }
            
            System.out.println("Term " +n+" = "+sum);
        }
    }
    
    /**FUNCTION TO PRINT VALUES OF FOR LOOP FRAGMENT 4**/
    static void fragmentFour()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            //Create new sum for every value of n to print
            int sum = 0;
            
            /**Fragment 4**/
            for (int i=0; i<n; i++)
            {
                sum++;
            }
            for (int j=0; j<n; j++) 
            {
                sum++;
            }
            
            System.out.println("Term " +n+" = "+sum);
        }
    }
    
    /**FUNCTION TO PRINT VALUES OF FOR LOOP FRAGMENT 5**/
    static void fragmentFive()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            //Create new sum for every value of n to print
            int sum = 0;
            
            /**Fragment 5**/
            for (int i=0; i<n; i++)
            {
                for (int j=0; j<n*n; j++)
                {
                    sum++;
                }
            }
            
            System.out.println("Term " +n+" = "+sum);
        }
    }
    
    /**FUNCTION TO PRINT VALUES OF FOR LOOP FRAGMENT 6**/
    static void fragmentSix()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            //Create new sum for every value of n to print
            int sum = 0;
            
            /**Fragment 6**/
            for (int i=0; i<n; i++)
            {
                for (int j=0; j<i; j++) 
                {
                    sum++;
                }
            }
            
            System.out.println("Term " +n+" = "+sum);
        }
    }
    
    /**FUNCTION TO PRINT VALUES OF FOR LOOP FRAGMENT 7**/
    static void fragmentSeven()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            //Create new sum for every value of n to print
            int sum = 0;
            
            /**Fragment 7**/
            for (int i=0; i<n; i++)
            {
                for (int j=0; j<n*n; j++)
                {
                    for (int k=0; k<j; k++)
                    {
                        sum++;
                    }
                }
            }
            
            System.out.println("Term " +n+" = "+sum);
        }
    }
    
    /**FUNCTION TO PRINT VALUES OF FOR LOOP FRAGMENT 8**/
    static void fragmentEight()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            //Create new sum for every value of n to print
            int sum = 0;
            
            /**Fragment 8**/
            for (int i=1; i<n; i=i*2)
            {
                sum++;
            }

            System.out.println("Term " +n+" = "+sum);
        }
    }
    
    /**FUNCTION TO PRINT VALUES OF QUESTION 4**/
    static void questionFour()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            //Create new sum for every value of n to print
            int sum = 0;
            
            /**Question Four**/
            for (int i=1; i<=n; i++)
            {
                for (int j=1; j<=i*i; j++) 
                {
                    if  (j%i == 0)
                    {
                        for (int k=0; k<j; k++) 
                        {
                            sum++;
                        }
                    }
                }
            }

            System.out.println("Term " +n+" = "+sum);
        }
    }
    
/**------------------------------------------------------------------------------VERIFY-------------------------------------------------------------------------------------------------**/

    /**FUNCTION TO TEST VALUES OF FOR LOOP FRAGMENT 1 TO ITS BIG O FUNCTION**/
    static void verifyOne()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            System.out.println("Term "+n+" = "+ Math.ceil( n ) ) ;
        }
    }
    
    /**FUNCTION TO TEST VALUES OF FOR LOOP FRAGMENT 2 TO ITS BIG O FUNCTION**/
    static void verifyTwo()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            System.out.println("Term "+n+" = "+ Math.ceil( n*0.5 ) ) ;
        }
    }
    
    /**FUNCTION TO TEST VALUES OF FOR LOOP FRAGMENT 3 TO ITS BIG O FUNCTION**/
    static void verifyThree()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            System.out.println("Term "+n+" = "+ Math.ceil( n*n ) ) ;
        }
    }
    
    /**FUNCTION TO TEST VALUES OF FOR LOOP FRAGMENT 4 TO ITS BIG O FUNCTION**/
    static void verifyFour()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            System.out.println("Term "+n+" = "+ Math.ceil( 2*n ) ) ;
        }
    }

    /**FUNCTION TO TEST VALUES OF FOR LOOP FRAGMENT 5 TO ITS BIG O FUNCTION**/
    static void verifyFive()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            System.out.println("Term "+n+" = "+ Math.ceil( n*n*n ) ) ;
        }
    }
    
    /**FUNCTION TO TEST VALUES OF FOR LOOP FRAGMENT 6 TO ITS BIG O FUNCTION**/
    static void verifySix()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            System.out.println("Term "+n+" = "+ Math.ceil( (n*(n+1))/2 ) ) ;
        }
    }
    
    /**FUNCTION TO TEST VALUES OF FOR LOOP FRAGMENT 7 TO ITS BIG O FUNCTION**/
    static void verifySeven()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            System.out.println("Term "+n+" = "+ (n*n*n*(n*n-1)/2) ) ;
        }
    }
    
    /**FUNCTION TO TEST VALUES OF FOR LOOP FRAGMENT 8 TO ITS BIG O FUNCTION**/
    static void verifyEight()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            System.out.println("Term "+n+" = "+ Math.ceil( (Math.log(n)/Math.log(2) ) ) );//Math statement: Round up the value of log(n) base 2 (divide by log(2) to be in base 2)
        }
    }
    
    /**FUNCTION TO TEST VALUES OF QUESTION 4 TO ITS BIG O FUNCTION**/
    static void verifyQuestionFour()
    {
        //All values of n from 0-100
        for(int n = 0 ; n <= 100 ; n++)
        {
            System.out.println("Term "+n+" = "+ (n*(1+n)*(2+n)*(1+3*n)/24)   ) ;
        }
    }
}
