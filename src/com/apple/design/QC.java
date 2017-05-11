package com.apple.design;

public class QC extends Department {

	public QC(FactoryManager mgr, Department next) {
		super(next);
		addObserver(mgr);
	}

	@Override
	void process(Widget w) {

		boolean defective = false;
		if (w instanceof Shakeable) {
			int s = ((Shakeable) w).shake();
			if (s == -1) {
				defective = true;
			}
		}

		if (w instanceof Draggable) {
			int s = ((Draggable) w).drag();
			if (s == -1) {
				defective = true;
			}
		}

		if (!defective) {
			qcPass(w);
		} else {
			qcFail(w);
		}

	}

	private void qcPass(Widget w) {
		next.process(w);

	}

	private void qcFail(Widget w) {
		this.setChanged();
		notifyObservers("DEFECT");
	}

}
