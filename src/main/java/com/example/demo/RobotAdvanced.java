package com.example.demo;


public class RobotAdvanced extends Robot implements  RobotInterface {

    public RobotAdvanced( double batteryLevel,Point position) {
        super( batteryLevel,position);
        super.consommation=15;
    }
    public void moveTo(Point destination) {
        System.out.println("Moving from( " + position.x +","+position.y + ") to (" +   destination.x +","+destination.y +")");
        position = destination;
    }

    @Override
    public void recharge() {
        System.out.println("Recharging...");
        batteryLevel = 100;
    }

}
