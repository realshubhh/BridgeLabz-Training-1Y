package com.gla.workshoplogs;

public class DeliveryCheckpoint extends Checkpoint {

    public DeliveryCheckpoint(String checkpointId, String locationName,
                               double distanceFromLast, double expectedDuration, double actualDuration) {
        super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
    }

    /**
     * Penalty = (actual - expected) * 2  if delayed, else 0.
     */
    @Override
    public double calculatePenalty() {
        if (isDelayed()) {
            return (actualDuration - expectedDuration) * 2.0;
        }
        return 0.0;
    }

    @Override
    public String getType() {
        return "DeliveryCheckpoint";
    }

    /**
     * Delivery stops are critical — must always be present for a consistent route.
     */
    @Override
    public boolean isCritical() {
        return true;
    }
}
