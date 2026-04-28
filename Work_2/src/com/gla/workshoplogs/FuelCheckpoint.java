package com.gla.workshoplogs;

public class FuelCheckpoint extends Checkpoint {

    private static final double FLAT_PENALTY = 10.0;

    public FuelCheckpoint(String checkpointId, String locationName,
                           double distanceFromLast, double expectedDuration, double actualDuration) {
        super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
    }

    /**
     * Penalty = flat 10 if delayed, else 0.
     */
    @Override
    public double calculatePenalty() {
        return isDelayed() ? FLAT_PENALTY : 0.0;
    }

    @Override
    public String getType() {
        return "FuelCheckpoint";
    }

    /**
     * Fuel stops are critical — missing one creates a consistency failure.
     */
    @Override
    public boolean isCritical() {
        return true;
    }
}
