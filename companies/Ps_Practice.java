package companies;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class Ps_Practice {
	public int check_log_history(String[] events) {
		int length = events.length;
		int current = 0;
		Set<String> setLocks =  new LinkedHashSet<>();
		Stack<String> stackLocks =  new Stack<>();
		while(current<length) {
			String strCurrentLock =  events[current];
			String[] lockdata =  strCurrentLock.split(" ");
			if("ACQUIRE".equals(lockdata[0])) {
				if(setLocks.contains(lockdata[1])) {
					return current+1;
				}else {
					setLocks.add(lockdata[1]);
					stackLocks.push(lockdata[1]);
				}
			}else if("RELEASE".equals(lockdata[0])) {
				if(!stackLocks.isEmpty() && setLocks.contains(lockdata[1]) && stackLocks.peek().equals(lockdata[1])) {
					stackLocks.pop();
					setLocks.remove(lockdata[1]);
				}else {
					return current+1;
				}
			}
			current++;
		}
		
		if(stackLocks.size()>0) {
			return current+1;
		}else {
			return 0;
		}
	}
}
