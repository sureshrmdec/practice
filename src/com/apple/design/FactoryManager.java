package com.apple.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FactoryManager implements Observer {
	private AppleFactory factory = null;

	private Map<String, Long> assembledWidgets = new HashMap();
	private Map<String, Long> shippedWidgets = new HashMap();
	private Map<String, Long> defectiveWidgets = new HashMap();

	public FactoryManager() {
		factory = new AppleFactory(this);
	}

	public void startFactory() {
		factory.startFactory();
	}

	public void stopFactory() {
		factory.shutdownFactory();
	}

	public static FactoryManager getInstance() {
		return new FactoryManager();
	}

	@Override
	public void update(Observable o, Object arg) {
		// System.out.println(o + "--- " + arg);
		// if (o instanceof Widget) {
		// Widget w = (Widget) o;
		String category = (String) arg;
		if (category.equalsIgnoreCase("SHIPPED")) {
			Long c = shippedWidgets.get(o.getClass().getSimpleName());
			if (c == null)
				c = 0L;

			c++;
			shippedWidgets.put(o.getClass().getSimpleName(), c);
		}

		if (category.equalsIgnoreCase("DEFECT")) {
			Long c = defectiveWidgets.get(o.getClass().getSimpleName());
			if (c == null)
				c = 0L;

			c++;
			defectiveWidgets.put(o.getClass().getSimpleName(), c);
		}

		if (category.equalsIgnoreCase("ASSEMBLED")) {
			Long c = assembledWidgets.get(o.getClass().getSimpleName());
			if (c == null)
				c = 0L;

			c++;
			assembledWidgets.put(o.getClass().getSimpleName(), c);
		}

	}

	public static void main(String[] args) {
		final FactoryManager mgr = new FactoryManager();

		Runnable run = new Runnable() {

			@Override
			public void run() {
				mgr.print();
			}

		};

		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(run, 2, 1, TimeUnit.SECONDS);
		mgr.startFactory();

	}

	protected void print() {
		System.out.println("Data");
		for (Entry<String, Long> entry : assembledWidgets.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}

		for (Entry<String, Long> entry : shippedWidgets.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}

		for (Entry<String, Long> entry : defectiveWidgets.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}

		System.out.println("\n\n");
	}
}
