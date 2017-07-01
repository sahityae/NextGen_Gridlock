package flipkart.gridlock.Database;

import android.graphics.Color;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sahitya on 6/18/2017.
 */

public class SessionDetails {
    private static SessionDetails self;
    private List<LatLng> changepoints = new ArrayList<LatLng>();
//    public static int distPerHr = 30;  //in km;
//    public static int costPerKm = 10;  //in km;
//    public static int fixedCost = 5000;
    public static String from ="";
    public static String to ="";
    public static LatLng start;
    public static LatLng end;
    public static List<String> transit= new ArrayList<>(Arrays.asList("itpl", "majestic","cmrit busstop", "kundalahalli signal", "domlur"));

    public static HashMap<Integer, ArrayList<String>> getTraffic() {
        return traffic;
    }

    public static void setTraffic(HashMap<Integer, ArrayList<String>> traffic) {
        SessionDetails.traffic = traffic;
    }

    public static HashMap<Integer, ArrayList< String> > traffic = new HashMap<Integer, ArrayList<String>>();

    public static List<Integer> getColors() {
        return colors;
    }

    public static void setColors(List<Integer> colors) {
        SessionDetails.colors = colors;
    }

    public static List<Integer> colors = new ArrayList<Integer>();



    public static int time;
    public static SessionDetails instance() {
        if (null == self) {
            self = new SessionDetails();
//            populateTrafficDatabase();
//            assignRouteColors();
        }
        return self;
    }

    public static void assignRouteColors() {
        int in = 50;
        int out = 0;
        ArrayList<String> list = traffic.get(18);
        for(int i=0; i<list.size(); i++)
        {
            String[] parts = list.get(i).split("_");
            in += Integer.parseInt(parts[2]);
            out += Integer.parseInt(parts[3]);
        }
        int leaving = 0;
        for(int i=0; i<list.size(); i++)
        {
            String[] parts = list.get(i).split("_");
            leaving += Integer.parseInt(parts[3]);
            if(leaving> (0.75*in))
            {
                colors.add(i);

            }
            else if(leaving> (0.5*in))
            {
                colors.add(i);
            }

        }
    }

    public static void populateTrafficDatabase() {
        String dummy1 = "itpl_12_600_50";
        String dummy2 = "cmrit busstop_12_250_300";
        String dummy3 = "kundalahalli signal_12_100_300";
        String dummy4 = "domlur_12_150_300";
        String dummy5 = "majestic_12_100_300";

        ArrayList<String> dummyList1 = new ArrayList<String>();

        dummyList1.add(dummy1);
        dummyList1.add(dummy2);
        dummyList1.add(dummy3);
        dummyList1.add(dummy4);
        dummyList1.add(dummy5);

        traffic.put(18, dummyList1);
    }


    public static void analyseTrafficDatabase() {
        String dummy1 = "itpl_15_300_25";
        String dummy2 = "cmrit busstop_15_125_50";
        String dummy3 = "kundalahalli signal_15_100_300";
        String dummy4 = "domlur_15_150_300";
        String dummy5 = "majestic_15_100_300";

        ArrayList<String> dummyList1 = new ArrayList<String>();

        dummyList1.add(dummy1);
        dummyList1.add(dummy2);
        dummyList1.add(dummy3);
        dummyList1.add(dummy4);
        dummyList1.add(dummy5);

        traffic.put(16, dummyList1);
    }


    public List<LatLng> getChangepoints() {
        return changepoints;
    }

    public void setChangepoints(List<LatLng> changepoints) {
        this.changepoints = changepoints;
    }

    public static String getFrom() {
        return from;
    }

    public static void setFrom(String from) {
        SessionDetails.from = from;
    }

    public static String getTo() {
        return to;
    }

    public static void setTo(String to) {
        SessionDetails.to = to;
    }

    public static LatLng getStart() {
        return start;
    }

    public static void setStart(LatLng start) {
        SessionDetails.start = start;
    }

    public static LatLng getEnd() {
        return end;
    }

    public static void setEnd(LatLng end) {
        SessionDetails.end = end;
    }

    public static List<String> getTransit() {
        return transit;
    }

    public static void setTransit(List<String> transit) {
        SessionDetails.transit = transit;
    }

    public static int getTime() {
        return time;
    }

    public static void setTime(int time) {
        SessionDetails.time = time;
    }


}

