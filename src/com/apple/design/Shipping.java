package com.apple.design;

public class Shipping extends Department {

	public Shipping(FactoryManager mgr, Department next) {
		super(next);
		addObserver(mgr);
	}

	@Override
	void process(Widget w) {
		ship(w);
	}

	private void ship(Widget w) {
		this.setChanged();
		notifyObservers("ReceivedInShipping");
	//	System.out.println("Shipped: " + w.getClass().getSimpleName());
		notifyShipped(w);
	}

	public void notifyShipped(Widget w) {
		this.setChanged();
		notifyObservers("SHIPPED");
	}

}
