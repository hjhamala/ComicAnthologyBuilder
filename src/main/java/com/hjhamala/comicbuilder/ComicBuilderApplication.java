package com.hjhamala.comicbuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hjhamala.comicbuilder.model.Comic;
import com.hjhamala.comicbuilder.model.ComicRepository;
import com.hjhamala.comicbuilder.model.Story;
import com.hjhamala.comicbuilder.model.StoryRepository;

@SpringBootApplication
public class ComicBuilderApplication implements CommandLineRunner {
	
	private static final Log log = LogFactory.getLog(ComicBuilderApplication.class);
	@Autowired
	private ComicRepository comicRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ComicBuilderApplication.class, args);
	}
	
	
	private Comic prog;
	
	@Override
    @Transactional
    public void run(String... strings) throws Exception {
		
		prog = new Comic("2000AD", "PROG 1740", LocalDate.of(2011, 6, 28));
		Set<Story> stories = new HashSet<Story>(){{
			add(new Story("The Further Dasterdly Deeds of P.J.Maybe", "", 1,3,8,"Judge Dredd", prog));
			add(new Story("Charon's Crossing","Apocalypse Shtick",1,10,14,"Sinister Dexter", prog));
			add(new Story("Secret City ","Book 7",1,15,20,"Savage", prog));
			add(new Story("The Silver Tongued Exploits of Cosmo Nibs","", 1,21,25,"Tharg's 3rillers present", prog));
			add(new Story("The Day the Zombo Died", "", 1,26,30,"Zombo", prog));
		}};
		prog.setStories(stories);
		comicRepository.save(prog);
		
		prog = new Comic("2000AD", "PROG 1741", LocalDate.of(2011, 7, 8));
		stories = new HashSet<Story>(){{
			add(new Story("The Further Dasterdly Deeds of P.J.Maybe","", 2,3,8,"Judge Dredd", prog));
			add(new Story("Charon's Crossing","Apocalypse Shtick",2,10,14,"Sinister Dexter", prog));
			add(new Story("Secret City ","Book 7",2,15,20,"Savage", prog));
			add(new Story("The Silver Tongued Exploits of Cosmo Nibs","", 2,21,25,"Tharg's 3rillers present", prog));
			add(new Story("The Day the Zombo Died","", 2,26,30,"Zombo", prog));
		}};
		prog.setStories(stories);
		comicRepository.save(prog);
		
		prog = new Comic("2000AD", "PROG 1742", LocalDate.of(2011, 7, 13));
		stories = new HashSet<Story>(){{
			add(new Story("The Further Dasterdly Deeds of P.J.Maybe","",3,3,8,"Judge Dredd",prog));
	        add(new Story("Charon's Crossing","Apocalypse Shtick",3,10,14,"Sinister Dexter", prog));
	        add(new Story("Secret City ","Book 7",3,15,20,"Savage", prog));
	        add(new Story("The Silver Tongued Exploits of Cosmo Nibs","", 3,21,25,"Tharg's 3rillers present", prog)); 
	        add(new Story("The Day the Zombo Died","",3,26,30,"Zombo", prog));
		}};
		prog.setStories(stories);
		comicRepository.save(prog);
		
		
		prog = new Comic("2000AD", "PROG 1743", LocalDate.of(2011, 7, 20));
		stories = new HashSet<Story>(){{
			add(new Story("Nadia","Day of Chaos",1,3,8,"Judge Dredd", prog));
	        add(new Story("Six Brothers","",1,10,14,"Tharg's 3rillers present", prog));
	        add(new Story("Secret City ","Book 7",4,15,20,"Savage", prog));
	        add(new Story("Charon's Crossing","Apocalypse Shtick",4,21,25,"Sinister Dexter", prog));
	        add(new Story("The Day the Zombo Died","",4,26,30,"Zombo", prog));
		}};
		prog.setStories(stories);
		comicRepository.save(prog);
		
		prog = new Comic("2000AD", "PROG 1744", LocalDate.of(2011, 7, 27));
		stories = new HashSet<Story>(){{
			add(new Story("Nadia","Day of Chaos",2,3,8,"Judge Dredd", prog));
	        add(new Story("Secret City ","Book 7",5,9,14,"Savage", prog));
		    add(new Story("Six Brothers","",2,15,20,"Tharg's 3rillers present", prog));
		    add(new Story("Charon's Crossing","Apocalypse Shtick",5,21,25,"Sinister Dexter", prog));
		    add(new Story("The Day the Zombo Died","",5,26,30,"Zombo", prog));
		}};
		prog.setStories(stories);
		comicRepository.save(prog);
		
		prog = new Comic("2000AD", "PROG 1745", LocalDate.of(2011, 8, 3));
		stories = new HashSet<Story>(){{
			add(new Story("Nadia","Day of Chaos",3,3,8,"Judge Dredd", prog));
	        add(new Story("Six Brothers","",3,10,14,"Tharg's 3rillers present", prog));
			add(new Story("Secret City ","Book 7",6,15,20,"Savage", prog));
			add(new Story("Inverse Ninja Rules","Apocalypse Shtick",1,21,26,"Sinister Dexter", prog));
			add(new Story("The Day the Zombo Died",6,27,31,"Zombo", prog));
		}};
		prog.setStories(stories);
		comicRepository.save(prog);
		
		prog = new Comic("2000AD", "PROG 1746", LocalDate.of(2011, 8, 10));
		stories = new HashSet<Story>(){{
			add(new Story("Nadia", "Day of Chaos",4,3,8,"Judge Dredd", prog));
	        add(new Story("Wolves",1,10,14,"Tharg's 3rillers present", prog));
	        add(new Story("Secret City ","Book 7",7,15,20,"Savage", prog));
	        add(new Story("The Dead-End Job","Apocalypse Shtick",1,21,26,"Sinister Dexter", prog)); 
	        add(new Story("The Day the Zombo Died",7,27,31,"Zombo", prog));
		}};
		prog.setStories(stories);
		comicRepository.save(prog);
		
		prog = new Comic("2000AD", "PROG 1747", LocalDate.of(2011, 8, 17));
		stories = new HashSet<Story>(){{
			add(new Story("Nadia","Day of Chaos",5,3,8,"Judge Dredd", prog));
			add(new Story("Wolves",2,9,14,"Tharg's 3rillers present", prog));
			add(new Story("Secret City ","Book 7",8,15,20,"Savage", prog));
			add(new Story("The Dead-End Job","Apocalypse Shtick",2,21,26,"Sinister Dexter", prog));
			add(new Story("The Day the Zombo Died",8,27,31,"Zombo", prog));
		}};
		prog.setStories(stories);
		comicRepository.save(prog);
		
		prog = new Comic("2000AD", "PROG 1748", LocalDate.of(2011, 8, 25));
		stories = new HashSet<Story>(){{
			add(new Story("Nadia","Day of Chaos",6,3,8,"Judge Dredd", prog));
			add(new Story("Wolves",3,10,14,"Tharg's 3rillers present", prog));
			add(new Story("Secret City ","Book 7",9,15,20,"Savage", prog));
			add(new Story("The Dead-End Job","Apocalypse Shtick",3,21,26,"Sinister Dexter", prog));
			add(new Story("The Day the Zombo Died",9,27,31,"Zombo", prog));
		}};
		prog.setStories(stories);
		comicRepository.save(prog);
		
		prog = new Comic("2000AD", "PROG 1749", LocalDate.of(2011, 8, 31));
		stories = new HashSet<Story>(){{ 
			add(new Story("Nadia","Day of Chaos",7,3,9,"Judge Dredd", prog));
			add(new Story("Secret City ","Book 7",10,10,15,"Savage", prog));
			add(new Story("The Day the Zombo Died",10,16,20,"Zombo", prog));
			add(new Story("The Dead-End Job","Apocalypse Shtick",4,21,26,"Sinister Dexter", prog));
			add(new Story("Nadia","Day of Chaos",8,27,32,"Judge Dredd", prog));
		}};
		prog.setStories(stories);
		comicRepository.save(prog);
		
		
		for (Comic comic: comicRepository.findAll()) {
            log.info(comic.toString());
        }
	}
	
	
	
}
