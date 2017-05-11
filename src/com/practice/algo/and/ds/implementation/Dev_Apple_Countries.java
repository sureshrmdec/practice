package com.practice.algo.and.ds.implementation;

import java.util.*;

public class Dev_Apple_Countries {

	public static void main(String[] args) {
		List<Country> availableCountries = new ArrayList<>();
		List<Country> specialCountries = new ArrayList<>();
		
		
		availableCountries.add(new Country("CE"));
		availableCountries.add(new Country("SD"));
		availableCountries.add(new Country("CA"));
		availableCountries.add(new Country("CC"));
		availableCountries.add(new Country("SB"));
		availableCountries.add(new Country("CB"));
		availableCountries.add(new Country("SA"));
		availableCountries.add(new Country("CD"));

		specialCountries.add(new Country("SA"));
		specialCountries.add(new Country("SC"));
		specialCountries.add(new Country("SD"));
		specialCountries.add(new Country("SB"));
		specialCountries.add(new Country("SE"));
		Dev_Apple_Countries o = new Dev_Apple_Countries();
		System.out.println(o.sortCountries(availableCountries, specialCountries));
	}

	public List<Country> sortCountries(List<Country> availableCountries,
			List<Country> specialCountries){
		List<Country> result = new LinkedList<Dev_Apple_Countries.Country>();
		
		Collections.sort(availableCountries,new Comparator<Country>() {

			@Override
			public int compare(Country o1, Country o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name);
			}
		});

		
		for(Country c: specialCountries){
			if(availableCountries.contains(c))
				result.add(c);
		}
		for(Country c: availableCountries){
			if(!result.contains(c))
				result.add(c);
		}
		
		return result;
		
		
	}
	static class Country{
		private String name;

		public Country(String name) {
			super();
			this.name = name;
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Country c = (Country)obj;
			return this.name.equals(c.name);
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name;
		}
		
	}
}
