/*
 * Detects if a point hits any of two circles.
 * 
 * Usage:
 * 
 * The purpose of this program is to determine whether a point chosen by the user hits at least 
 * one of the circles described by the user's input. 
 * 
 * The user inputs a list of eight floating point values: the first six describe the two circles 
 * (x- and y-coordinates of their centers in the 2D Cartesian system and the radii). The last two 
 * input values represent the chosen point's x- and y-coordinates.
 * 
 * Afterwards, the program detects whether the point hits the first circle, the second one, both, 
 * or neither by calculating the distance to the circles' centers. A point hits a circle when this
 * distance is less than or equal to the circle's radius. This calculation works even when a circle 
 * has a radius equal to 0, meaning it is a point. Depending on the user's input, the program can 
 * output one of the following statements:
    ■ "The point hits the first circle" when the point hits the first circle
    ■ "The point hits the second circle" when the point hits the second circle
    ■ "The point does not hit either circle" when the point hits neither circle
    ■ "input error" when either circle has a negative radius.
 * 
 * @author Horia-George Duna
 * @ID 1949284
 * @author Radu-Cristian Sarău
 * @ID 1939149
 * 
 */

import java.util.Scanner;

class HitDetection {
    
    static Scanner scanner = new Scanner(System.in);
    
    /**
     * Prints.
     * @param hitsFirst is a boolean variable which stores the value TRUE
      if the point hits the first circle
     * @param hitsSecond is a boolean variable which stores the value TRUE 
     if the point hits the first circle
     */
    public void result(boolean hitsFirst, boolean hitsSecond) {
        if (hitsFirst && hitsSecond) {
            System.out.println("The point hits both circles");
        } else if (hitsFirst) {
            System.out.println("The point hits the first circle");
        } else if (hitsSecond) {
            System.out.println("The point hits the second circle");
        } else {
            System.out.println("The point does not hit either circle");
        }
    }

    public void run() {
        // Hit detection

        //Declaration of variables used for the circles and the chosen point
        double xCenter1;
        double yCenter1;
        double radiusFirst;
        
        double xCenter2;
        double yCenter2;
        double radiusSecond;
        
        double xPoint;
        double yPoint;

        boolean hitsFirst = false;
        boolean hitsSecond = false;

        //Reading the first circle's coordinates and radius
        xCenter1 = scanner.nextDouble();
        yCenter1 = scanner.nextDouble();
        radiusFirst = scanner.nextDouble();
        
        //Checks for negative radius input and stops the program if so
        if (radiusFirst < 0) {
            System.out.println("input error");
            System.exit(0);
        }
        
        //Reading the second circle's coordinates and radius
        xCenter2 = scanner.nextDouble();
        yCenter2 = scanner.nextDouble();
        radiusSecond = scanner.nextDouble();
        
        //Checks for negative radius input and stops the program if so
        if (radiusSecond < 0) {
            System.out.println("input error");
            System.exit(0);
        }
        
        //Reading the chosen point's coordinates
        xPoint = scanner.nextDouble();
        yPoint = scanner.nextDouble();
        
        //Declaration of the variables used for calculating the distances to the circle's centers
        double distanceToFirst;
        double distanceToSecond;
        
        /*Calculation of the distances from the cosen point to the circle's center using the
         * pythagorean theorem 
         */
        distanceToFirst = Math.sqrt(Math.pow((xPoint - xCenter1), 2) 
        + Math.pow((yPoint - yCenter1), 2));
        
        distanceToSecond = Math.sqrt(Math.pow((xPoint - xCenter2), 2)
        + Math.pow((yPoint - yCenter2), 2));

        //Checking if the chosen point hits the first circle
        if (distanceToFirst <= radiusFirst) {
            hitsFirst = true;
        }
        
        //Checking if the chosen point hits the second circle
        if (distanceToSecond <= radiusSecond) {
            hitsSecond = true;
        }

        result(hitsFirst, hitsSecond);
        
    }

    public static void main(String[] args) {
        new HitDetection().run();
    }
}