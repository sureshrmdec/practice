package com.apple.design;

import java.util.LinkedList;
import java.util.List;

public class AssemblyDepartment extends Department {
	private List<AssemblyLine> assemblyLines = new LinkedList<>();

	private FactoryManager fm;

	public AssemblyDepartment(FactoryManager fm, Department qc) {
		super(qc);
		this.fm = fm;
		assemblyLines.add(new AssemblyLine.TanAssemblyLine(qc, fm));
		assemblyLines.add(new AssemblyLine.IndigoAssemblyLine(qc, fm));
		assemblyLines.add(new AssemblyLine.MauveAssemblyLine(qc, fm));

	}

	public void startAssembling() {
		while (true) {
			for (AssemblyLine line : assemblyLines) {
				line.start();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	void process(Widget w) {
		startAssembling();
	}

}
