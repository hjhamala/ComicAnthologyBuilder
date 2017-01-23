package com.hjhamala.comicbuilder.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ResourceUtils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ComicsBuilder {
	
	/**
	 * Extracts zip-files to destination path. Files are renamed numeric ascending order 
	 * 
	 * @param pathToFile
	 * @param destinationPath
	 * @param startingFile first file to extract - equate to page
	 * @param endingFile last file to extract - equate to page
	 * @param orderingNumber starting number for extraction
	 * @return last extracted number + 1
	 * @throws Exception
	 */
	public static int extractComic(String pathToFile, Path destinationPath, int startingFile, int endingFile,
			int orderingNumber) throws Exception {
		File file = ResourceUtils.getFile("classpath:" + pathToFile);
		if (!file.exists()){
			throw new FileNotFoundException("File not found!");
		}
		
		if (startingFile< 1 || endingFile <1 || startingFile>endingFile){
			throw new IllegalArgumentException("Start cannot be creater than end");
		}
		
		
		ZipFile zipFile = new ZipFile(file.getCanonicalPath());
		@SuppressWarnings("unchecked")
		List<FileHeader> files = zipFile.getFileHeaders();
		for (int i = startingFile - 1; i < endingFile; i++) {
			zipFile.extractFile(files.get(i), destinationPath.toString(), null, String.format("%05d", orderingNumber) + ".jpg");
			orderingNumber++;
		}
		return orderingNumber;
	}

	public static Path extractComics(List<Story> stories) {
		Path tempDirectory = null;
		try {
			tempDirectory = Files.createTempDirectory("comics");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int extCount = 1;
		Iterator<Story> i = stories.iterator();
		while (i.hasNext()) {
			Story story = i.next();
			String issueName = story.getComic().getIssue();
			int startingPage = story.getStartingPage();
			int endingPage = story.getEndingPage();
			String comicName = issueName + ".cbz";
			System.out.println(comicName + ":" + startingPage + ":" + endingPage);
			try {
				extCount = ComicsBuilder.extractComic(comicName, tempDirectory, startingPage, endingPage, extCount);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tempDirectory;

	}

	public static File buildCbz(String name, Path sourcePath, Path targetPath) throws ZipException {
		ZipFile zip = new ZipFile(targetPath.toString() + "/" + name + ".cbz");

		// set compression method to store compression
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		zip.createZipFileFromFolder(sourcePath.toString(), parameters, false, 0);
		return zip.getFile();

	}

}