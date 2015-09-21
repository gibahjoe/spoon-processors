package fr.inria.gforge.spoon.processors;

import org.apache.log4j.Level;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCatch;

/**
 * Reports warnings when empty catch blocks are found.
 */
public class CatchProcessor extends AbstractProcessor<CtCatch> {
	@Override
	public boolean isToBeProcessed(CtCatch candidate) {
		return candidate.getBody().getStatements().size() == 0;
	}

	public void process(CtCatch element) {
		getEnvironment().report(this, Level.WARN, element, "empty catch clause");
	}
}