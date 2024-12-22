package com.example.demo;
public interface RobotInterface {
    void moveTo(Point destination);
    double getBatteryLevel();
    void recharge();
}
