package flipkart.gridlock.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sahitya on 6/30/2017.
 */

public class trafficInfo {

    HashMap<Integer, ArrayList<Integer>> vehicles = new HashMap<Integer, ArrayList<Integer>>();
    private Integer time;

    public trafficInfo() {
        
        mapVehiclesInfo();
    }

    private void mapVehiclesInfo() {

        ArrayList<Integer> numVehicles1 = new ArrayList<Integer>();
        //At 8:00 am
        numVehicles1.add(3000);
        numVehicles1.add(1000);
        numVehicles1.add(2000);
        numVehicles1.add(500);

        vehicles.put(9,numVehicles1);

        ArrayList<Integer> numVehicles2 = new ArrayList<Integer>();
        //At 8:00 am
        numVehicles2.add(800);
        numVehicles2.add(3000);
        numVehicles2.add(1000);
        numVehicles2.add(1500);

        vehicles.put(16,numVehicles2);

        ArrayList<Integer> numVehicles3 = new ArrayList<Integer>();
        //At 8:00 am
        numVehicles3.add(2000);
        numVehicles3.add(500);
        numVehicles3.add(1000);
        numVehicles3.add(3000);

        vehicles.put(20,numVehicles3);
    }

    private void calculateSignalTimes() {
        ArrayList<Integer> signalTime = new ArrayList<Integer>();
        ArrayList<Integer> numVeh = vehicles.get(time);
        int totalVeh = numVeh.get(0) + numVeh.get(1) + numVeh.get(2) + numVeh.get(3);
        for(int i=0; i<numVeh.size();i++)
        {
            if(numVeh.get(i)<0.25*totalVeh)
                signalTime.add(i,180);
            else if(numVeh.get(i)<0.5*totalVeh)
                signalTime.add(i,120);
            else if(numVeh.get(i)<0.75*totalVeh)
                signalTime.add(i,60);
            else
                signalTime.add(i,30);
        }



    }

    public HashMap<Integer, ArrayList<Integer>> getVehicles() {
        return vehicles;
    }

    public void setVehicles(HashMap<Integer, ArrayList<Integer>> vehicles) {
        this.vehicles = vehicles;
    }
}
