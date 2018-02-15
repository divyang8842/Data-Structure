package random;

import java.util.Deque;
import java.util.LinkedList;

public class Random_Test {
	static boolean alert(int[] inputs, int windowSize, float allowedIncrease) {
		int length = inputs.length;
		double previous = Integer.MAX_VALUE;
		double previousMin = Integer.MAX_VALUE;
		int previousMax = Integer.MIN_VALUE;
		int nCommonMax = 0;

		for (int i = windowSize; i < length; i++) {
			double avg = 0.0d;
			int sum = 0;
			int max = Integer.MIN_VALUE;
			for (int index = windowSize; index > 0; index--) {
				sum += inputs[i - index];
				if (max < inputs[i - index]) {
					max = inputs[i - index];
				}
			}
			avg = sum / windowSize;
			double d = max / avg;
			if (max == previousMax && d <= allowedIncrease) {
				nCommonMax = -1 * windowSize;
			} else if (max == previousMax && d > allowedIncrease) {
				nCommonMax++;
			} else {
				if (nCommonMax > 0) {
					return true;
				}
				if (d > allowedIncrease) {
					nCommonMax = 1;
				}
			}
			if (avg / previous > allowedIncrease) {
				return true;
			}
			previous = avg;
			if (avg < previousMin) {
				previousMin = avg;
			}

			if (avg / previousMin > allowedIncrease) {
				return true;
			}
		}

		// if(nCommonMax>0)
		// return true;

		return false;
	}
	
	
	static boolean alert1(int[] inputs, int windowSize, float allowedIncrease) {
		//created queue to keep track of max element in window
        Deque<Integer> maxQueue = new LinkedList<Integer>();

		/* Process first window elements of array */
		int nLength = inputs.length;
		
		double dCurrentSum = 0;// keeps track of current window sum
		double dCurrentAvg = 0;//keeps track of current window avg
		double dPreviousMinAvg = Integer.MAX_VALUE;//used to keep previous min avg
		int nPreviousMaxElementInQueue = Integer.MIN_VALUE;//max element of previous window
		int nConsecutiveMaxTrue = 0;//track consecutive max value condition for current max
		
		int i;
		for (i = 0; i < windowSize; i++) {
			dCurrentSum += inputs[i];
			// For very element, removing previous smaller element from the queue
			while (!maxQueue.isEmpty() && inputs[i] >= inputs[maxQueue.peekLast()]){
				maxQueue.removeLast(); // Removing element from rear
			}
			// Adding new element in front
			maxQueue.addLast(i);
		}
		
		//the front element is the max element in the window
		int nCurrentMax = inputs[maxQueue.peek()];
		
		// Process rest of the elements, inputs[k] to inputs[n-1]
		for (; i <= nLength; i++) {
			// finding current avg
			dCurrentAvg = dCurrentSum / windowSize;
			
			//current ratio of max/avg
			double dCurrentRatio = nCurrentMax / dCurrentAvg;
			
			//if current max element is the last max elemebt
			if (nPreviousMaxElementInQueue == nCurrentMax) {
				if (dCurrentRatio <= allowedIncrease) {//ration is less then allowed increase
					nConsecutiveMaxTrue = Integer.MIN_VALUE; // giving least value to elemenate
				} else if (dCurrentRatio > allowedIncrease) {
					nConsecutiveMaxTrue++;
				}
			} else {
				if (nConsecutiveMaxTrue > 0) {
					return true;
				}
				if (dCurrentRatio > allowedIncrease) {
					nConsecutiveMaxTrue = 1;
				}
				nPreviousMaxElementInQueue = nCurrentMax;
			}

			if (dCurrentAvg / dPreviousMinAvg > allowedIncrease ) {
				return true;
			}
			if (dCurrentAvg < dPreviousMinAvg) {
				dPreviousMinAvg = dCurrentAvg;
			}
			if(i<nLength){
				// Remove the elements which are out of this window
				while ((!maxQueue.isEmpty()) && maxQueue.peek() <= i - windowSize) {
					maxQueue.removeFirst();
				}
				//removing from current sum
				dCurrentSum -= inputs[i - windowSize];

				// Remove all elements smaller than the element going to be adeed
				while ((!maxQueue.isEmpty()) && inputs[i] >= inputs[maxQueue.peekLast()])
					maxQueue.removeLast();

				//Adding current element to rear
				maxQueue.addLast(i);
				
				//adding current element in current sum
				dCurrentSum += inputs[i];
                
                // The element at the front of the queue is the largest element of window
				//current element is largest element in the window
				nCurrentMax = inputs[maxQueue.peek()];
				
			}
		}
        if (nConsecutiveMaxTrue > 0) {
					return true;
				}

		return false;}
}
