package com.apple.design;

import java.util.Observable;

public abstract class Department extends Observable {
	Department next;

	public Department(Department next) {
		this.next = next;
	}

	abstract void process(Widget w);
}
