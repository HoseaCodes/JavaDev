package com.example.java;

import org.joda.time.LocalTime;

public class Time {
  public static void main(String[] args) {
    LocalTime currentTime = new LocalTime();
    System.out.println("The current local time is: " + currentTime);
  }
}