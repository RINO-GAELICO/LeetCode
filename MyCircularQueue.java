package leetCode;

class MyCircularQueue {
	private int tailPointer = 0;
	private int headPointer = 0;
	private Integer[] intArray;

	public MyCircularQueue(int k) {
		intArray = new Integer[k];
	}

	public boolean enQueue(int value) {
		if (this.isEmpty()) {
			intArray[headPointer] = value;
			tailPointer = (tailPointer+1) % (intArray.length);
			return true;
		} else if (!this.isFull()) {
			intArray[tailPointer] = value;
			tailPointer = (tailPointer+1) % (intArray.length);
			return true;
		} else {
			return false;
		}

	}

	public boolean deQueue() {
		if (!this.isEmpty()) {

			intArray[headPointer] = null;
			headPointer = (headPointer+1) % (intArray.length);
			return true;

		} else {
			return false;
		}
	}

	public int Front() {
		if (!this.isEmpty()) {
			return intArray[headPointer];
		} else {
			return -1;
		}

	}

	public int Rear() {
		if (!this.isEmpty()) { 
			return intArray[(((tailPointer-1) % (intArray.length))+intArray.length) %(intArray.length)];
		} else {
			return -1;
		}
	}

	public boolean isEmpty() {
        if (tailPointer==headPointer&&intArray[headPointer]==null)
        {
            return true;
        }else
            return false;

	}

	public boolean isFull() {
		if (tailPointer==headPointer&&intArray[headPointer]!=null)
        {
            return true;
        }else
            return false;
	}
}