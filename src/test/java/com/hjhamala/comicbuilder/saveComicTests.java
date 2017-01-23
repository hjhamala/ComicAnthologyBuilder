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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class saveComicTests {
	
	private static final Log log = LogFactory.getLog(ComicBuilderApplication.class);
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private ComicRepository comicRepository;
	
	@Test
	@Transactional
	public void saveAndDeleteComicTest() {
		// String body = this.restTemplate.getForObject("/comic", String.class);
		// log.info(body);
		Comic prog = new Comic("2000AD", "PROG 1750", LocalDate.of(2011, 9, 7));
		Set<Story>stories = new HashSet<Story>(){{
			add(new Story("The Fourth Faction"," Day of Chaos",1,3,8,"Judge Dredd",prog));
	        add(new Story("The English Assassin",1,10,14,"Ampney Crucis Investigates", prog));
	        add(new Story("Everything and More",1,15,20,"Indigo Prime", prog));
	        add(new Story("The Deal",1,26,30,"Low Life", prog));
		}};
		prog.setStories(stories);
		comicRepository.save(prog);
		assertNotNull("Saved item must have id", prog.getId());
		
		Comic savedProg = comicRepository.findOneByIssue("PROG 1750");
		// Test that comic has been saved
		assertEquals(prog, savedProg);
		comicRepository.delete(prog);
		// Test deleting
		assertNull(comicRepository.findOneByIssue("PROG 1750"));
	}
	
	@Test
	public void comicMustHaveStoriesTest(){
		Comic prog = new Comic("2000AD", "PROG 1750", LocalDate.of(2011, 9, 7));
		exception.expect(Exception.class);
		comicRepository.save(prog);
		
	}
	
	@Test
	public void comicMustHaveNameTest(){
		Comic prog = new Comic("", "PROG 1750", LocalDate.of(2011, 9, 7));
		exception.expect(Exception.class);
		comicRepository.save(prog);
	}

}
