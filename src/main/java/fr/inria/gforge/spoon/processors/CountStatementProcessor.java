package fr.inria.gforge.spoon.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtStatement;

import java.io.File;
import java.io.PrintWriter;

/**
 * Created by gerard on 21/10/2014.
 */
public class CountStatementProcessor extends AbstractProcessor<CtStatement> {

	private int count = 0;

	@Override
	public void process(CtStatement element) {
		count++;
	}

	@Override
	public void processingDone() {
		super.processingDone();
		PrintWriter writer = null;
		try {
			// Creates output file for performance.
			final String directories =
					"target" + File.separator + "spoon-maven-plugin";
			final String file =
					directories + File.separator + "spoon-nb-statement.txt";
			final File directoryForPerformanceFile = new File(directories);
			final File nbStatementFile = new File(file);
			if (!directoryForPerformanceFile.exists()) {
				directoryForPerformanceFile.mkdirs();
			}
			if (!nbStatementFile.exists()) {
				nbStatementFile.createNewFile();
			}
			writer = new PrintWriter(nbStatementFile, "UTF-8");

			// Saves number of statement.
			writer.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
