/**
 * 
 */
package com.test.grads;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoqishun Nov 17, 2014 4:27:59 PM
 */
public class DeleteDuplicateData {

	public static void main(String[] args) {
		DeleteDuplicateData ddd = new DeleteDuplicateData();
		String dir = "D:\\SWAP_TMP\\TEMP_PRJ\\";
		String endfix = ".DHI";
		ddd.deleteOldData(dir, endfix);
	}

	/**
	 * @param dir
	 * @param endfix
	 */
	private void deleteOldData(String dir, final String endfix) {

		File file = new File(dir);
		File[] files = file.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				if (!pathname.isFile()) {
					return false;
				}
				String fileName = pathname.getName();
				if (fileName.endsWith(endfix))
					return true;
				else {
					return false;
				}
			}
		});
		Map<String, Long> seedMap = new HashMap<String, Long>();
		String fileName = null;
		String hdfName = null;
		long timeLong = 0;
		for (File f : files) {
			fileName = f.getName();
			if (fileName.endsWith("CN.DHI")) {
				deleteDhiFiles(f);
				continue;
			}
			// find same name files and leave the latest data then
			// delete others.
			hdfName = fileName.substring(0, fileName.lastIndexOf("_"));
			timeLong = Long.parseLong(fileName.substring(
					fileName.lastIndexOf("_") + 1, fileName.indexOf(".")));
			if (seedMap.containsKey(hdfName)) {
				long oldTime = seedMap.get(hdfName);
				if (oldTime > timeLong) {
					seedMap.put(hdfName, timeLong);
					File oldFile = new File(f.getParent() + File.separator
							+ hdfName + "_" + oldTime + endfix);
					deleteDhiFiles(oldFile);
				} else {
					deleteDhiFiles(f);
				}
			} else {
				seedMap.put(hdfName, timeLong);
			}
		}
	}

	/**
	 * delete dhi files that contains CAL, PRJ and LDF
	 * @param f
	 */
	private void deleteDhiFiles(File f) {
		String hdfName = f.getName().substring(0, f.getName().lastIndexOf("."));
		File dirFile = new File(f.getParent());
		for (File file : dirFile.listFiles()) {
			String fileName = file.getName();
			if (fileName.contains(hdfName)) {
				System.out.println("Delete: " + fileName);
				file.delete();
			}
		}
	}

}
