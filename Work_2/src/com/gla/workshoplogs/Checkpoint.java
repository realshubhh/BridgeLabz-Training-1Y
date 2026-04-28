package com.gla.workshoplogs;

public abstract class Checkpoint {

    protected String checkpointId;
    protected String locationName;
    protected double distanceFromLast; // in kilometers
    protected double expectedDuration; // in minutes
    protected double actualDuration;   // in minutes

    public Checkpoint(String checkpointId, String locationName,
                      double distanceFromLast, double expectedDuration, double actualDuration) {
        this.checkpointId    = checkpointId;
        this.locationName    = locationName;
        this.distanceFromLast = distanceFromLast;
        this.expectedDuration = expectedDuration;
        this.actualDuration   = actualDuration;
    }

    // Getters
    public String getCheckpointId()     { return checkpointId; }
    public String getLocationName()     { return locationName; }
    public double getDistanceFromLast() { return distanceFromLast; }
    public double getExpectedDuration() { return expectedDuration; }
    public double getActualDuration()   { return actualDuration; }

    /** True if actual time exceeded expected time */
    public boolean isDelayed() {
        return actualDuration > expectedDuration;
    }

    /** Subclasses define their penalty logic */
    public abstract double calculatePenalty();

    /** Subclasses define their type label */
    public abstract String getType();

    /** Critical checkpoints must always be present for route consistency */
    public abstract boolean isCritical();

    @Override
    public String toString() {
        double penalty = calculatePenalty();
        String status  = isDelayed() ? "Delayed" : "On Time";
        return getType() + " – " + locationName + " – " + status + " – Penalty: " + penalty;
    }
}
