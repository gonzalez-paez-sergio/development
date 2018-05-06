package mine.spliterator;

import java.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;

//static<T>void parEach(TaggedArray<T>a,Consumer<T>action){Spliterator<T>s=a.spliterator();long targetBatchSize=s.estimateSize()/(ForkJoinPool.getCommonPoolParallelism()*8);new ParEach(null,s,action,targetBatchSize).invoke();}

public class ParEach<T> extends CountedCompleter<Void> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1338162085420555792L;

	final Spliterator<T> spliterator;
	final Consumer<T> action;
	final long targetBatchSize;

	ParEach(ParEach<T> parent, Spliterator<T> spliterator, Consumer<T> action, long targetBatchSize) {
		super(parent);
		this.spliterator = spliterator;
		this.action = action;
		this.targetBatchSize = targetBatchSize;
	}

	public void compute() {
		Spliterator<T> sub;
		while (spliterator.estimateSize() > targetBatchSize && (sub = spliterator.trySplit()) != null) {
			addToPendingCount(1);
			new ParEach<>(this, sub, action, targetBatchSize).fork();
		}
		spliterator.forEachRemaining(action);
		propagateCompletion();
	}
}