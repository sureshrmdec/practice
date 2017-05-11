package com.practice.algo.and.ds.implementation;

public enum Occupancy {
	 ONE(1), TWO(2), THREE(3), FOUR(4);
	 
	 private int value;
	 
	 private Occupancy(int value) {
	  this.value = value;
	 }
	 
	  public int getValue() {
	   return value;
	  }
	 
	  public static Integer getMaxOcupancy(){
		  return FOUR.getValue();
	  }
	 }

