package utils;

public class MinHeap {

	private double weight[];
	private Integer n;
	private int pos[];
	private int fp[];

	public MinHeap(double weight[], int vs[]) {
		this.weight = weight;
		this.fp = vs;
		this.n = this.fp.length - 1;
		this.pos = new int[this.n];
		for (int u = 0; u < this.n; u++) {
			this.pos[u] = u + 1;
		}
	}

	public void build() {
		Integer left = n / 2 + 1;
		while (left > 1) {
			left--;
			rebuild(left, n);
		}
	}

	public void rebuild(Integer left, Integer right) {
		int j = left * 2;
		int x = fp[left];
		while (j <= right) {
			boolean rightBigger = j < right;
			boolean weightAtFPLeftIsBigger = weight[fp[j]] > weight[fp[j + 1]];
			if (rightBigger && weightAtFPLeftIsBigger) {
				j++;
			}
			if (weight[x] <= weight[fp[j]]) {
				break;
			}
			fp[left] = fp[j];
			pos[fp[j]] = left;
			left = j;
			j = left * 2;
		}
		fp[left] = x;
		pos[x] = left;
	}

	public void changeKey(int i, double newKey) {
		i = pos[i];
		int x = fp[i];
		weight[x] = newKey;
		while ((i > 1) && (weight[x] <= weight[fp[i/2]])) {
			this.fp[i] = this.fp[i/2];
			pos[fp[i/2]] = i;
			i /= 2;
		}
		this.fp[i] = x; 
		pos[x] = i;
	}
	
	public Integer removeMin() throws Exception {
		int min;
		if(n < 1) {
			throw new Exception("Empty Heap");
		}else {
			min = fp[ 1]; 
			fp[1] = fp[n];
			pos[fp[n--]] = 1;
			rebuild(1, n);
		}
		return min;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}

}
