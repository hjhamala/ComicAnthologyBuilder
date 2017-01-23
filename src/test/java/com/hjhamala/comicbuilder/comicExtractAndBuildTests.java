package com.hjhamala.comicbuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hjhamala.comicbuilder.model.ComicRepository;
import com.hjhamala.comicbuilder.model.ComicsBuilder;
import com.hjhamala.comicbuilder.model.Story;
import com.hjhamala.comicbuilder.model.StoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class comicExtractAndBuildTests {
	
	private static final Log log = LogFactory.getLog(ComicBuilderApplication.class);
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private StoryRepository storyRepository;
	
	@Test
	@Transactional
	public void extractSingleComicTest() throws Exception {
		// String body = this.restTemplate.getForObject("/comic", String.class);
		// log.info(body);
		
		Path temp = Files.createTempDirectory("comics");
		
		boolean thrown = false;
		try {
			ComicsBuilder.extractComic("Prog abc", temp, 3, 1, 1);
		} catch (FileNotFoundException e) {
			thrown = true;
		}
		// File not found exception should be catched 
		assertTrue(thrown);
		
		ComicsBuilder.extractComic("PROG 1740.cbz", temp, 1, 3, 1);
		// There should be three files in temporary directory
		assertEquals(3, temp.toFile().list().length);
		
		thrown = false;
		try {
			ComicsBuilder.extractComic("PROG 1740.cbz", temp, 3, 1, 1);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}
		// IllegalArgumentException should be catched
		assertTrue(thrown);
		
		thrown = false;
		try {
			ComicsBuilder.extractComic("PROG 1740.cbz", temp, -1, 1, 1);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}
		// IllegalArgumentException should be catched
		assertTrue(thrown);
		
	}
	
	@Test
	@Transactional
	public void extractComicTest() throws Exception {
		List<Story> stories = storyRepository.findByNameContainsOrderByComicReleaseDateAscStartingPageAsc("Nadia");
		Path temp = ComicsBuilder.extractComics(stories);
		// Nadia story is 49 pages long
		assertEquals(49, temp.toFile().list().length);
		
	}
	


}
