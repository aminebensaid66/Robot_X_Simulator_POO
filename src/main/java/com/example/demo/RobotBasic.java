package com.example.demo;

public class RobotBasic extends Robot implements  RobotInterface {
    public RobotBasic(double batteryLevel,Point position) {
        super(batteryLevel,position);
        super.consommation=10;
    }
    public void moveTo(Point destination) {
        if((destination.x == position.x && Math.abs(destination.y - position.y) == 1) ||
                (destination.y == position.y && Math.abs(destination.x - position.x) == 1)) {
            System.out.println("Moving from( " + position.x +","+position.y + ") to (" +   destination.x +","+destination.y +")");
            batteryLevel-=10;
            position = destination;
        }
        else {
            System.out.println("Cette instruction n'est pas valide");
        }
    }
    @Override
    public void recharge() {
        System.out.println("Recharging...");
        batteryLevel = 100;
    }


}