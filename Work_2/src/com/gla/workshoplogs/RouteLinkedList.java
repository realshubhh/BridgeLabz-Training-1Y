package com.gla.workshoplogs;

public class RouteLinkedList<T extends Checkpoint> {

    // ---------------------------------------------------------------
    // Inner Node class
    // ---------------------------------------------------------------
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // ---------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------
    private Node<T> head;
    private int size;

    public RouteLinkedList() {
        head = null;
        size = 0;
    }

    // ---------------------------------------------------------------
    // addCheckpoint  — appends to the end of the list
    // ---------------------------------------------------------------
    public void addCheckpoint(T checkpoint) {
        Node<T> newNode = new Node<>(checkpoint);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // ---------------------------------------------------------------
    // removeCheckpoint  — removes by checkpointId, returns true if found
    // ---------------------------------------------------------------
    public boolean removeCheckpoint(String checkpointId) {
        if (head == null) return false;

        // Special case: head is the target
        if (head.data.getCheckpointId().equals(checkpointId)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.getCheckpointId().equals(checkpointId)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // ---------------------------------------------------------------
    // findCheckpoint  — linear search by checkpointId
    // ---------------------------------------------------------------
    public T findCheckpoint(String checkpointId) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.getCheckpointId().equals(checkpointId)) {
                return current.data;
            }
            current = current.next;
        }
        return null; // not found
    }

    // ---------------------------------------------------------------
    // computeTotalDistance  — sum of distanceFromLast across all nodes
    // ---------------------------------------------------------------
    public double computeTotalDistance() {
        double total = 0.0;
        Node<T> current = head;
        while (current != null) {
            total += current.data.getDistanceFromLast();
            current = current.next;
        }
        return total;
    }

    // ---------------------------------------------------------------
    // computeTotalPenalty  — sum of calculatePenalty() across all nodes
    // ---------------------------------------------------------------
    public double computeTotalPenalty() {
        double total = 0.0;
        Node<T> current = head;
        while (current != null) {
            total += current.data.calculatePenalty();
            current = current.next;
        }
        return total;
    }

    // ---------------------------------------------------------------
    // checkRouteConsistency
    //   Returns false if any critical checkpoint is absent (was never
    //   added or was subsequently removed).
    //   Here "absent" means the list contains at least one critical
    //   type AND we verify the ones present are still there.
    //   Per the problem: returns false if any critical checkpoint is
    //   missing or removed.
    // ---------------------------------------------------------------
    public boolean checkRouteConsistency() {
        Node<T> current = head;
        while (current != null) {
            // If we find a slot where a critical checkpoint SHOULD be
            // but it was removed (null data), that's a fail.
            // Since we only store valid nodes, the simpler check is:
            // ensure at least one Delivery and one Fuel exist.
            current = current.next;
        }

        // Check that at least one Delivery and one Fuel checkpoint
        // is present (they are the critical types per the problem).
        boolean hasDelivery = false;
        boolean hasFuel     = false;

        current = head;
        while (current != null) {
            if (current.data instanceof DeliveryCheckpoint) hasDelivery = true;
            if (current.data instanceof FuelCheckpoint)     hasFuel     = true;
            current = current.next;
        }

        return hasDelivery && hasFuel;
    }

    // ---------------------------------------------------------------
    // printRoute  — numbered list matching the sample output format
    // ---------------------------------------------------------------
    public void printRoute() {
        Node<T> current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.data.toString());
            current = current.next;
            index++;
        }
    }

    // ---------------------------------------------------------------
    // Utility
    // ---------------------------------------------------------------
    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }
}
