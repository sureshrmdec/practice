package com.apple.design;

public class AppleFactory {

	private Department assembly;
	private Department qc;
	private Department shipping;
	private FactoryManager mgr;

	public AppleFactory(FactoryManager mgr) {
		this.mgr = mgr;
		shipping = new Shipping(mgr, null);
		qc = new QC(mgr, shipping);
		assembly = new AssemblyDepartment(mgr, qc);

	}

	public void startFactory() {
		assembly.process(null);
	}

	public void shutdownFactory() {

	}

}
