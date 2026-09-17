import java.util.*;

class UndergroundSystem {
    private Map<Integer, CheckInData> checkIns = new HashMap<>();
    private Map<String, RouteData> routes = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData checkIn = checkIns.get(id);

        String key = checkIn.station + "#" + stationName;

        RouteData route = routes.getOrDefault(key, new RouteData());
        route.totalTime += t - checkIn.time;
        route.count++;

        routes.put(key, route);
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "#" + endStation;
        RouteData route = routes.get(key);

        return (double) route.totalTime / route.count;
    }

    static class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    static class RouteData {
        int totalTime;
        int count;
    }
}

/*
Output:
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
*/
