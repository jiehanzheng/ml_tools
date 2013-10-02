package org.jiehan.ml_tools.converters;

import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.SVMLightLoader;

public class SVMLightToArff {
	/**
	 * takes 2 arguments:
	 * - SVMLight input file
	 * - ARFF output file
	 */
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("\nUsage: SVMLightToArff <input.train> <output.arff>\n");
			System.exit(1);
		}

		// load CSV
		SVMLightLoader loader = new SVMLightLoader();
		loader.setSource(new File(args[0]));
		Instances data = loader.getDataSet();

		// save ARFF
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File(args[1]));
		saver.setDestination(new File(args[1]));
		saver.writeBatch();
	}
}