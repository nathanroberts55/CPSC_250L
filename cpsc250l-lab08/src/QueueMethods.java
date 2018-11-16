
public class QueueMethods {
	public static Queue<Candy> getCandyOrder(Queue<Candy> dispenser, int day) {
		Queue<Candy> newCandy = new Queue<Candy>();
		if (day == 0) {
			while (!(dispenser.isEmpty())) {
				newCandy.enqueue(dispenser.dequeue());
			}
		}
		if (day == 1) {
			while (!(dispenser.isEmpty())) {
				newCandy.enqueue(dispenser.dequeue());
				if (!(dispenser.isEmpty())) {
					dispenser.enqueue(dispenser.dequeue());
				}
			}
		}
		if (day == 2) {
			while (!(dispenser.isEmpty())) {
				newCandy.enqueue(dispenser.dequeue());
				if (!(dispenser.isEmpty())) {
					dispenser.enqueue(dispenser.dequeue());
					if (!(dispenser.isEmpty())) {
						dispenser.enqueue(dispenser.dequeue());
					}
				}
			}
		}
		if (day == 3) {
			while (!(dispenser.isEmpty())) {
				newCandy.enqueue(dispenser.dequeue());
				if (!(dispenser.isEmpty())) {
					dispenser.enqueue(dispenser.dequeue());
					if (!(dispenser.isEmpty())) {
						dispenser.enqueue(dispenser.dequeue());
						if (!(dispenser.isEmpty())) {
							dispenser.enqueue(dispenser.dequeue());
						}
					}
				}
			}
		}
		if (day == 4) {
			while (!(dispenser.isEmpty())) {
				newCandy.enqueue(dispenser.dequeue());
				if (!(dispenser.isEmpty())) {
					dispenser.enqueue(dispenser.dequeue());
					if (!(dispenser.isEmpty())) {
						dispenser.enqueue(dispenser.dequeue());
						if (!(dispenser.isEmpty())) {
							dispenser.enqueue(dispenser.dequeue());
							if (!(dispenser.isEmpty())) {
								dispenser.enqueue(dispenser.dequeue());
							}
						}
					}
				}
			}
		}
		if (day == 5) {
			while (!(dispenser.isEmpty())) {
				newCandy.enqueue(dispenser.dequeue());
				if (!(dispenser.isEmpty())) {
					dispenser.enqueue(dispenser.dequeue());
					if (!(dispenser.isEmpty())) {
						dispenser.enqueue(dispenser.dequeue());
						if (!(dispenser.isEmpty())) {
							dispenser.enqueue(dispenser.dequeue());
							if (!(dispenser.isEmpty())) {
								dispenser.enqueue(dispenser.dequeue());
								if (!(dispenser.isEmpty())) {
									dispenser.enqueue(dispenser.dequeue());
								}
							}
						}
					}
				}
			}
		}
		if (day == 6) {
			while (!(dispenser.isEmpty())) {
				newCandy.enqueue(dispenser.dequeue());
				if (!(dispenser.isEmpty())) {
					dispenser.enqueue(dispenser.dequeue());
					if (!(dispenser.isEmpty())) {
						dispenser.enqueue(dispenser.dequeue());
						if (!(dispenser.isEmpty())) {
							dispenser.enqueue(dispenser.dequeue());
							if (!(dispenser.isEmpty())) {
								dispenser.enqueue(dispenser.dequeue());
								if (!(dispenser.isEmpty())) {
									dispenser.enqueue(dispenser.dequeue());
									if (!(dispenser.isEmpty())) {
										dispenser.enqueue(dispenser.dequeue());
									}
								}
							}
						}
					}
				}
			}
		}
		
		

		return newCandy;
	}

	public static void getRemainingCandy(Queue<Candy> dispenser, Candy piece) {
		Queue<Candy> newCandy = new Queue<Candy>();
		
		while(!(dispenser.isEmpty())){
			newCandy.enqueue(dispenser.dequeue());
		}
		
		while(!(newCandy.isEmpty())) {
			Candy t = newCandy.dequeue();
			if(!(t.equals(piece))){
				dispenser.enqueue(t);
			}
		}
	}	
}
