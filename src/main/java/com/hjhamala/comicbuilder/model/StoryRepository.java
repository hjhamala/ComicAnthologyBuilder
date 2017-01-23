package com.hjhamala.comicbuilder.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "story", path = "story")
public interface StoryRepository extends JpaRepository<Story, Long>{
	
	List<Story> findByName(@Param("name") String name);
	
	List<Story> findByNameContainsOrderByComicReleaseDateAscStartingPageAsc(@Param("name") String name);
	
}
