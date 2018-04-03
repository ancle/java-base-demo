package thread.instance.depot;

public class Depot {
	private int capacity;
	private int size;

	public Depot(int capacity) {
		this.capacity = capacity;
		this.size = 0;
	}

	public synchronized void produce(int value) throws InterruptedException {
		int left = value;

		while (left > 0) {
			// 仓库满时通知生产中停工待生产
			while (this.size >= this.capacity) {
				wait();
			}

			int inc = ((size + left > capacity) ? (capacity - size) : left);
			size += inc;
			left -= inc;

			System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n", Thread.currentThread().getName(),
					value, left, inc, size);

			// 通知消费者进行消费
			notifyAll();
		}
	}

	public synchronized void consume(int value) throws InterruptedException {
		int left = value;

		while (left > 0) {
			// 仓库产品为空时，消费者停止消费
			while (this.size <= 0) {
				wait();
			}

			int dec = (size < left ? size : left);
			size -= dec;
			left -= dec;

			System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n", Thread.currentThread().getName(),
					value, left, dec, size);

			// 通知生产者进行生产
			notifyAll();
		}
	}
}
