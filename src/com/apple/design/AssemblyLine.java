package com.apple.design;

import java.util.Observable;

public abstract class AssemblyLine extends Observable {
	private Department next;
	private FactoryManager mgr;

	public abstract Widget assemble();

	public AssemblyLine(Department next, FactoryManager mgr) {
		this.next = next;
		this.mgr = mgr;
		addObserver(mgr);
	}

	public void start() {
		Widget w = assemble();
		next.process(w);
	}

	public void stop() {

	}

	public static class TanAssemblyLine extends AssemblyLine {

		public TanAssemblyLine(Department qc, FactoryManager fm) {
			super(qc, fm);
		}

		@Override
		public Widget assemble() {
			Tan t = new Tan();
			this.setChanged();
			notifyObservers("ASSEMBLED");
			return t;
		}

	}

	public static class MauveAssemblyLine extends AssemblyLine {
		public MauveAssemblyLine(Department qc, FactoryManager fm) {
			super(qc, fm);
		}

		@Override
		public Widget assemble() {
			Mauve m = new Mauve();
			this.setChanged();
			notifyObservers("ASSEMBLED");
			return m;
		}

	}

	public static class IndigoAssemblyLine extends AssemblyLine {
		public IndigoAssemblyLine(Department qc, FactoryManager fm) {
			super(qc, fm);
		}

		@Override
		public Widget assemble() {
			Indigo i = new Indigo();
			this.setChanged();
			notifyObservers("ASSEMBLED");
			return i;
		}

	}

}
