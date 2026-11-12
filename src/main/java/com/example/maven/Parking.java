
package com.example.maven;

public class Parking {

    public double calculateFee(String vehicleType, double hours) {

        if (hours <= 0) {
            throw new IllegalArgumentException("Invalid parking duration");
        }

        if (vehicleType == null) {
            throw new IllegalArgumentException("Invalid vehicle type");
        }

        // Round partial hours upward
        int totalHours = (int) Math.ceil(hours);

        if (vehicleType.equalsIgnoreCase("two-wheeler")) {
            return totalHours * 10;
        }
        else if (vehicleType.equalsIgnoreCase("four-wheeler")) {
            return totalHours * 20;
        }
        else {
            throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }

    public void displayDetails(String vehicleType, double hours) {
        double fee = calculateFee(vehicleType, hours);

        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Parking Duration: " + hours + " hours");
        System.out.println("Total Parking Fee: Rs. " + fee);
    }
}

