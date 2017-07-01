package flipkart.gridlock.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sahitya on 6/15/2017.
 */

public class trafficData {

    HashMap<String,List<LocationData>> traffic = new HashMap<String,List<LocationData>>();
    List<LocationData> temp = new ArrayList<LocationData>();
    HashMap<String, List<String>> routes = new HashMap<String, List<String>>();

    public trafficData() {
        assignRoutes();
        createDummyTrafficData();
    }

    private void assignRoutes() {
        List<String> depoList = new ArrayList<>();
        depoList.add("Kadugodi");
        depoList.add("hopefarm");
        depoList.add("itpl");
        depoList.add("vydehi");
        depoList.add("cmrit");
        depoList.add("kundalahalli");
        depoList.add("marathahalli");
        depoList.add("domlur");
        depoList.add("richmond circle");
        depoList.add("majestic");
        routes.put("kadugodi",depoList);
        depoList.clear();



    }

    private void createDummyTrafficData() {
        String from ="itpl";
        populateTrafficData(from, "majestic", 17, 18, 1000, 15, 3000 ); //case1
        traffic.put(from, temp);
        temp.clear();

        from = "majestic";
        populateTrafficData(from, "itpl", 17, 18, 500, 15, 1000 ); //case 1

        traffic.put(from, temp);
        temp.clear();



    }

    private void populateTrafficData(String fromLoc, String toLoc, int timeRangeLeft, int timeRangeRight,
                                     int numVehicles, int numBuses, int numCommuters) {


        LocationData datapoint = new LocationData(fromLoc, toLoc, timeRangeLeft, timeRangeRight, numVehicles, numBuses, numCommuters);
        temp.add(datapoint);

//
//
//        HashMap<String,ArrayList<Integer>> destInfo = new HashMap<String,ArrayList<Integer>>();
//        List<String> fromLocs = new ArrayList<String>(Arrays.asList("Electronic city","koramangala","marathahalli","jp nagar", "silk board", "itpl", "majestic", "kr puram"));
//
//        List<String> toLocs = new ArrayList<String>(Arrays.asList("Electronic city","koramangala","marathahalli","jp nagar", "silk board", "itpl", "majestic", "kr puram"));
//
//        //set 1
//        fromLoc = "electronic city";


    }
}
