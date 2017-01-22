package ua.nure.jernovaya.SummaryTask4.tags;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class ImagePaths {
	/**
	 * Logger.
	 */
	final static Logger LOGGER = Logger.getLogger(ImagePaths.class);
	public static String parentPath;

	/**
	 * returns the list of the names of files , which are consisted in {@code
	 * <folderPath>}
	 * 
	 * @param folderPath
	 * @return
	 */
	public static List<String> getPaths(String folderPath) {
		List<String> list = new ArrayList<>();
		File folder = new File(parentPath, folderPath);
		if (folder.isDirectory()) {
			File[] images = folder.listFiles();
			for (int i = 0; i < images.length; i++) {
				list.add(images[i].getName());
			}
		}
		return list;
	}
}
