package com.example.cwmobile;

public class Trip {
    private int tripId;
    private String tripName;
    private String tripDestination;
    private String tripDate;
    private String tripRisk;
    private String tripDescription;
    private int tripParticipants;

    public Trip(String tripName, String tripDestination,String tripDate, String tripRisk, String tripDescription, int tripParticipants) {
        this.tripName = tripName;
        this.tripDestination = tripDestination;
        this.tripDate = tripDate;
        this.tripRisk = tripRisk;
        this.tripDescription = tripDescription;
        this.tripParticipants = tripParticipants;
    }

    public String getTripName() {
        return tripName;
    }

    public String getTripDestination() {
        return tripDestination;
    }

    public int getTripParticipants() {
        return tripParticipants;
    }

    public String getTripRisk() {
        return tripRisk;
    }

    public String getTripDate() {
        return tripDate;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setTripDestination(String tripDestination) {
        this.tripDestination = tripDestination;
    }

    public void setTripParticipants(int tripParticipants) {
        this.tripParticipants = tripParticipants;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public void setTripRisk(String tripRisk) {
        this.tripRisk = tripRisk;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }
}
