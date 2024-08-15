package problems;

import java.util.Arrays;

public class BestMeetingPoint {
    
    public void getBestMeetingPoint(int [][] locations) {

        int numLoc = locations.length;
        int [] allX = new int[numLoc];
        int [] allY = new int[numLoc];

        for (int i = 1; i < locations.length; i++) {
            allX[i] = locations[i][0];
            allY[i] = locations[i][1];
        }

        Arrays.sort(allX);
        Arrays.sort(allY);
        int mpX = allX[numLoc / 2];
        int mpY = allY[numLoc / 2];
        System.out.println("center = " + mpX + "," + mpY);

        int sumDist = 0;
        for (int i = 1; i < locations.length; i++) {
            int d = dist(mpX, mpY, locations[i][0], locations[i][1]);
            sumDist += d;
            System.out.println(String.format("Distance of (%d, %d) from center (%d, %d) is %d", locations[i][0], locations[i][1], mpX, mpY, d));
        }
        System.out.println("total dist traveled = " + sumDist);
    }


    private int dist(int mpX, int mpY, int i, int j) {
        return (Math.abs(mpX - i) + Math.abs(mpY - j));
    }


    public static void main (String ar[]) {

        int [][] locations = {{2, 2}, {7, 2}, {3, 4}, {3, 5}, {2, 7}};

        BestMeetingPoint b = new BestMeetingPoint();
        System.out.println(locations);
        b.getBestMeetingPoint(locations);

        System.out.println("also, dists from 3,3");
        int sumDist = 0;
        for (int i = 1; i < locations.length; i++) {
            int d = b.dist(3, 3, locations[i][0], locations[i][1]);
            sumDist += d;
            System.out.println(String.format("Distance of (%d, %d) from center (%d, %d) is %d", locations[i][0], locations[i][1], 3, 3, d));
        }
        System.out.println("total dist traveled = " + sumDist);
    }
}
