package lab5.events;

import lab5.state.*;

public class PickingEvent extends Event {
	private StoreState state;
	private EventQueue eQueue;
	private CustomerQueue cQueue;

	/**
	 * @param Tar in 
	 */
	private pickingEvent(StoreState state) {
		super()
		this.state = state;
		this.eQueue = eQueue;
		this.cQueue = cQueue;
	}

	private void runEvent() {
		if (state.getFreeRegister() > 0) {
			eQueue.AddEvent(new PayingEvent());
			state.changeFreeRegisters(-1);
			state.changeCustomersPaying(+1);
		} else {
			cQueue.addToArray();
		}
	}
}
