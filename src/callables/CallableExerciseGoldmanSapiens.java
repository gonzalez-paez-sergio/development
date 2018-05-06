package callables;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import callables.CallableExerciseGoldmanSapiens.Job;

class CallableExerciseGoldmanSapiens {

	interface Job {

		int setJob(Callable<BigInteger> job);

		int getJob(int job);

	}

	class JobImplementation implements Job {

		@SuppressWarnings("unused")
		private ConcurrentHashMap<Integer, Callable<BigInteger>> hashMap = new ConcurrentHashMap<>();
		private ExecutorService es = Executors.newSingleThreadScheduledExecutor();

		@SuppressWarnings("unused")
		@Override
		public int setJob(Callable<BigInteger> task) {

			// int intJob = job.hashCode();
			Future<BigInteger> f = es.submit(task);
			// hashMap.put(f., job);
			return 0;
		}

		@Override
		public int getJob(int job) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	public static void main(String[] string) {

	}
}

class TestCallable {

	Job job = new Job() {

		@Override
		public int setJob(Callable<BigInteger> job) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getJob(int job) {
			// TODO Auto-generated method stub
			return 0;
		}
	};
}

// que usa internamente el hashmap en java 8
// decorator pattern
// template pattern