package es.upm.aled.lab2.utils;

import java.io.*;
import java.util.*;

/**
 * Class that provides methods to load/save to/from a file the motion data for
 * an 10-Segment exoskeleton in which the last 8 Segments can be animated:
 * LeftUpperArm, RightUpperArm, LeftForearm, RightForearm, LeftThigh,
 * RightThigh, LeftCalf, RightCalf. The file follows a CSV format in which the
 * first column is the frame index (modulo 256) and the next 8 store the
 * Segments movements in degrees.
 * 
 * @author rgarciacarmona
 */
public class FileUtils {

	/**
	 * Loads motion data from a file.
	 * 
	 * @param filename The path to the file.
	 * @return A List of double[] which contains the contents of every column except
	 *         the first.
	 * @throws IOException If the file can't be accessed.
	 */
	public static List<double[]> loadMotion(String filename) throws IOException {
		List<double[]> frames = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				// Skip comments
				if (line.isEmpty() || line.startsWith("#"))
					continue;

				String[] parts = line.split(",");
				// Ignore the frame index
				double[] angles = new double[parts.length - 1];
				for (int i = 1; i < parts.length; i++) {
					// Convert the angles to radians
					angles[i - 1] = Math.toRadians(Double.parseDouble(parts[i]));
				}
				frames.add(angles);
			}
		}
		return frames;
	}

	/**
	 * Saves motion data from a file.
	 * 
	 * @param filename The path to the file.
	 * @param frames   A List of double[] which contains the movements of every
	 *                 Segment.
	 * @throws IOException If the file can't be accessed or written.
	 */
	public static void saveMotion(String filename, List<double[]> frames) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
			// Write the comment line
			pw.println(
					"# Frame, LeftUpperArm, RightUpperArm, LeftForearm, RightForearm, LeftThigh, RightThigh, LeftCalf, RightCalf");
			for (int i = 0; i < frames.size(); i++) {
				pw.print(i);
				for (double angle : frames.get(i)) {
					// Convert the angles to degrees
					pw.print("," + Math.toDegrees(angle));
				}
				pw.println();
			}
		}
	}
}
