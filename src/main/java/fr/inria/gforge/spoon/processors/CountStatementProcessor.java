package fr.inria.gforge.spoon.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtStatement;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.UUID;

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
			final String performancePath =
					"target" + File.separator + "spoon-maven-plugin"
							+ File.separator + "spoon-nb-statement.txt";
			final File performanceFile = new File(performancePath);

			if (!performanceFile.getParentFile().exists()) {
				performanceFile.getParentFile().mkdirs();
			}
			if (!performanceFile.exists()) {
				performanceFile.createNewFile();
			}
			writer = new PrintWriter(new FileWriter(performanceFile, true));

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
