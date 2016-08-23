package edge_detection;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 
 
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
 
/**
 * Description:
 *      Image altering class that can change a specified image to greyscale, binary, and grey gradient. You can also tack on a negative filter that works with each other filter.
 * 
 * Use: 
 *      Alter image file names in CONSTRUCTOR/ EdgeDetection()/try/img && img2
 * 
 * Applying Filters: 
 *      Uncomment/comment function calls in FUNCTION TO DRAW IMAGE ONTO JFRAME/paint/changeImageGreyScale() || changeImageBinary() || changeImageGreyGradient() || changeImageNegative();
 * 
 * Result Description:
 *      No functions called: Original Image
 *      changeImageGreyScale: Alter colors into a "black and white" photograph
 *      changeImageBinary: Alter colors so the ONLY colors are black and white, edges of picture are in white while everything else will be black
 *      changeImageGreyGradient: Alter colors to a gradient of black and white on each edge (gives a sketchy lead pencil on black paper look)
 *      changeImageNegative: Alter colors to their negative values
 * 
 * Artistic Expression/Extra:
 *      changeImageNegative can be used in combination with the other three filters. Their results are as follows:
 *          changeImageNegative w/ changeImageGreyScale: Gives the same look as a normal changeImageNegative, just with a "black and white" photograph look
 *          changeImageNegative w/ changeImageBinary: Gives a sketchy black pencil on white paper look
 *          changeImageNegative w/ changeImageGreyGradient: Looks like the combination changeImageNegative w/ changeImageBinary, but with more detail
 */
public class EdgeDetection extends Component 
{
    /**Class Member Variables**/
    BufferedImage img;//Original image (for reference)
    BufferedImage img2;//Altered image
    File chosenFile;
    boolean changeImageCalled;//boolean hack to only call changeImage() function once
 
    /**MAIN METHOD TO RUN CLASS**/
    public static void main(String[] args) 
    {
        //Create JFrame window to load class
        JFrame f = new JFrame("Load Image Sample");
        
        //Add exit button to JFrame
        f.addWindowListener( new WindowAdapter()
            {
                public void windowClosing(WindowEvent e) 
                {
                    System.exit(0);
                }
            }
        );
        f.add(new EdgeDetection() );//Call constructor
        f.pack();
        f.setVisible(true);
    }
    
    /**CONSTRUCTOR**/
    public EdgeDetection() 
    {
       //Assign values to class member variables
       changeImageCalled = false;
       
       
    try 
       {
//           loadImage();//call to bring user to a "select file" window
           //Assign a specified image file
           img = ImageIO.read( new File("Okami.jpg") );
           img2 = ImageIO.read( new File("Okami.jpg") );
       } 
       catch (IOException e) 
       {
           //File doesn't exist where specified, don't crash program and print warning
           System.out.println("File not found");
       }
    }
    
    /**FUNCTION TO DRAW IMAGE ONTO JFRAME**/
    public void paint(Graphics g) 
    {
        //hack check to only call changeImage() once
        if(changeImageCalled == false)
        {
//            changeImageGreyScale();
//            changeImageBinary();
            changeImageGreyGradient();
            changeImageNegative();
            changeImageCalled = true;
        }
        //draw image 2 (altered image)
        g.drawImage(img2, 0, 0, null);
        
//        repaint();//paint image every frame
    }
    
    /**FUNCTION TO ALTER IMAGE TO GRAYSCALE**/
    void changeImageGreyScale()
    {
        //Scroll through every row of pixels
        for(int row = 1; row < (img.getWidth() - 1 );row++)
        {
            //Scroll through every column of pixels
            for(int col = 1; col < (img.getHeight() - 1) ; col++)
            {
                //Make new color out of current pixel scrolling on
                Color c = new Color( img.getRGB(row, col) );
            
                //Separate color by RGB values
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                
                /**Grey Scaling**/
                //Average values for grey scaling
                int avg = (r+g+b)/3;

                //Create a new black/white color based on averaged values
                Color c2 = new Color(avg,avg,avg);
                int rgbFinal = c2.getRGB();//put the color into a reference
                
                //Alter actual image
                img2.setRGB(row,col,rgbFinal);
                
            }
        }
        
    }
    
    /**FUNCTION TO ALTER IMAGE TO BINARY (PURE BLACK & WHITE)**/
    void changeImageBinary()
    {
        //Scroll through every row of pixels
        for(int row = 1; row < (img.getWidth() - 1 );row++)
        {
            //Scroll through every column of pixels
            for(int col = 1; col < (img.getHeight() - 1) ; col++)
            {
                /**Edge Detection**/
                //Look at pixels' colors around current pixel
                Color top = new Color(img.getRGB(row, col-1));
                Color bottom = new Color(img.getRGB(row, col+1));
                Color right = new Color(img.getRGB(row+1, col));
                Color left = new Color(img.getRGB(row-1, col));
                
                //Separate colors by RGB values, but since we gray scaled it, each value is the same so we only need to take one (red)
                int topRGB = top.getRed();
                int bottomRGB = bottom.getRed();
                int rightRGB = right.getRed();
                int leftRGB = left.getRed();

                //Calculate gradient by values
                int grad = Math.abs( (rightRGB  - leftRGB ) ) + Math.abs( (bottomRGB - topRGB) );
                
                /**Binary**/
                //Compare gradient to threshold to determine what value is needed to constitute an edge
                if(grad > 100 )
                {
                    //Is edge
                    img2.setRGB(row, col, Color.WHITE.getRGB() );
                }
                else
                {
                    //Not edge
                    img2.setRGB(row, col, Color.BLACK.getRGB() );
                }
                
            }
        }
        
    }
    
    /**FUNCTION TO ALTER IMAGE TO A GREYSCALE GRADIENT**/
    void changeImageGreyGradient()
    {
        //Scroll through every row of pixels
        for(int row = 1; row < (img.getWidth() - 1 );row++)
        {
            //Scroll through every column of pixels
            for(int col = 1; col < (img.getHeight() - 1) ; col++)
            {
                /**Edge Detection**/
                //Look at pixels' colors around current pixel
                Color top = new Color(img.getRGB(row, col-1));
                Color bottom = new Color(img.getRGB(row, col+1));
                Color right = new Color(img.getRGB(row+1, col));
                Color left = new Color(img.getRGB(row-1, col));
                
                //Separate colors by RGB values, but since we gray scaled it, each value is the same so we only need to take one (red)
                int topRGB = top.getRed();
                int bottomRGB = bottom.getRed();
                int rightRGB = right.getRed();
                int leftRGB = left.getRed();

                //Calculate gradient by values
                int grad =  ( Math.abs( (rightRGB  - leftRGB ) ) + Math.abs( (bottomRGB - topRGB) ) );
                
                /**Grey Scale Gradient**/
                //Compare gradient to threshold to determine what value is needed to constitute an edge
                if(grad > 255 )
                {
                    grad = 255;
                }
                
                //Create a new black/white color based on grad values
                Color cGrad = new Color(grad,grad,grad);
                int rgbGrad = cGrad.getRGB();//put the color into a reference

                //Alter actual image
                img2.setRGB(row, col, rgbGrad );

            }
        }
        
    }
    
    /**FUNCTION TO MAKE IMAGE NEGATIVE**/
    void changeImageNegative()
    {
      //Scroll through every row of pixels
        for(int row = 1; row < (img2.getWidth() - 1 );row++)
        {
            //Scroll through every column of pixels
            for(int col = 1; col < (img2.getHeight() - 1) ; col++)
            {
                //Make new color out of current pixel scrolling on
                Color c = new Color( img2.getRGB(row, col) );
            
                //Separate color by RGB values and subtract from white to calculate negatives
                int r = 255 - c.getRed();
                int g = 255 - c.getGreen();
                int b = 255 - c.getBlue();
        


                //Create a new negative color based on values
                Color c2 = new Color(r,g,b);
                int rgbFinal = c2.getRGB();//put the color into a reference
                
                //Alter actual image
                img2.setRGB(row,col,rgbFinal);
                
            }
        }
        
    }
    /**FUNCTION TO BRING UP FILE SELECT WINDOW**/
    void loadImage()
    {
        //Create file chooser
        JFileChooser chooser= new JFileChooser();
        //When clicked
        int choice = chooser.showOpenDialog(this);

        if (choice != JFileChooser.APPROVE_OPTION) return;

        chosenFile = chooser.getSelectedFile();

    }
    
    /**FUNCTION TO SET SIZE OF IMAGE**/
    public Dimension getPreferredSize() 
    {
        if (img == null) 
        {
             return new Dimension(100,100);
        } 
        else 
        {
           return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }
 
    
}