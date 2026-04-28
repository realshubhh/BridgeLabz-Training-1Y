package com.gla.workshoplogs;

public class Driver {

    private String driverId;
    private String name;
    private RouteLinkedList<Checkpoint> routeHistory;

    public Driver(String driverId, String name) {
        this.driverId     = driverId;
        this.name         = name;
        this.routeHistory = new RouteLinkedList<>();
    }

    // ---------------------------------------------------------------
    // Getters
    // ---------------------------------------------------------------
    public String getDriverId() { return driverId; }
    public String getName()     { return name; }
    public RouteLinkedList<Checkpoint> getRouteHistory() { return routeHistory; }

    // ---------------------------------------------------------------
    // Delegate convenience methods
    // ---------------------------------------------------------------
    public void addCheckpoint(Checkpoint checkpoint) {
        routeHistory.addCheckpoint(checkpoint);
    }

    public boolean removeCheckpoint(String checkpointId) {
        return routeHistory.removeCheckpoint(checkpointId);
    }

    public Checkpoint findCheckpoint(String checkpointId) {
        return routeHistory.findCheckpoint(checkpointId);
    }

    // ---------------------------------------------------------------
    // routeScore = totalDistance - totalPenalty
    // ---------------------------------------------------------------
    public double computeRouteScore() {
        double totalDistance = routeHistory.computeTotalDistance();
        double totalPenalty  = routeHistory.computeTotalPenalty();
        return totalDistance - totalPenalty;
    }

    // ---------------------------------------------------------------
    // Full formatted summary matching the sample output
    // ---------------------------------------------------------------
    public void printRouteSummary() {
        System.out.println("Driver: " + driverId + " – " + name);
        System.out.println("Route Summary:");

        routeHistory.printRoute();

        double totalDistance = routeHistory.computeTotalDistance();
        double totalPenalty  = routeHistory.computeTotalPenalty();
        double routeScore    = computeRouteScore();

        System.out.printf("Total Distance: %.1f km%n", totalDistance);
        System.out.printf("Total Penalty: %.1f%n", totalPenalty);
        System.out.printf("Route Score: %.1f%n", routeScore);

        boolean consistent = routeHistory.checkRouteConsistency();
        if (consistent) {
            System.out.println("Critical Route Check: All required checkpoints present");
        } else {
            System.out.println("Critical Route Check: FAILED – one or more critical checkpoints are missing");
        }
    }
}
