package flipkart.gridlock.Database;

/**
 * Created by Sahitya on 6/16/2017.
 */

public class LocationData {

    String fromLoc;
    String toLoc;
    int timeRangeLeft;
    int timeRangeRight;
    int numVehicles;
    int numBuses;
    int numCommuters;

    public LocationData(String fromLoc, String toLoc, int timeRangeLeft, int timeRangeRight, int numVehicles, int numBuses, int numCommuters) {
        this.fromLoc = fromLoc;
        this.toLoc = toLoc;
        this.timeRangeLeft = timeRangeLeft;
        this.timeRangeRight = timeRangeRight;
        this.numVehicles = numVehicles;
        this.numBuses = numBuses;
        this.numCommuters = numCommuters;
    }

    public String getFromLoc() {
        return fromLoc;
    }

    public void setFromLoc(String fromLoc) {
        this.fromLoc = fromLoc;
    }

    public String getToLoc() {
        return toLoc;
    }

    public void setToLoc(String toLoc) {
        this.toLoc = toLoc;
    }

    public int getTimeRangeLeft() {
        return timeRangeLeft;
    }

    public void setTimeRangeLeft(int timeRangeLeft) {
        this.timeRangeLeft = timeRangeLeft;
    }

    public int getTimeRangeRight() {
        return timeRangeRight;
    }

    public void setTimeRangeRight(int timeRangeRight) {
        this.timeRangeRight = timeRangeRight;
    }

    public int getNumVehicles() {
        return numVehicles;
    }

    public void setNumVehicles(int numVehicles) {
        this.numVehicles = numVehicles;
    }

    public int getNumBuses() {
        return numBuses;
    }

    public void setNumBuses(int numBuses) {
        this.numBuses = numBuses;
    }

    public int getNumCommuters() {
        return numCommuters;
    }

    public void setNumCommuters(int numCommuters) {
        this.numCommuters = numCommuters;
    }
}
