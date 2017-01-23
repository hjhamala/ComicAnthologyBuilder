package com.hjhamala.comicbuilder;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;

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


import com.hjhamala.comicbuilder.model.Comic;
import com.hjhamala.comicbuilder.model.ComicRepository;
import com.hjhamala.comicbuilder.model.Story;
import com.hjhamala.comicbuilder.model.StoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class findStoriesTests {
	
	private static final Log log = LogFactory.getLog(ComicBuilderApplication.class);
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private StoryRepository storyRepository;
	
	@Test
	@Transactional
	public void findStoriesTest() {
		// String body = this.restTemplate.getForObject("/comic", String.class);
		// log.info(body);
		
		// Nadia has 8 parts
		assertEquals(storyRepository.findByNameContainsOrderByComicReleaseDateAscStartingPageAsc("Nadia").size(), 8);
	}
	
	
}
