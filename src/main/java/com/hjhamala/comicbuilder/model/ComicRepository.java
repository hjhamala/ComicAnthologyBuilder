package com.hjhamala.comicbuilder.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "comic", path = "comic")
public interface ComicRepository extends JpaRepository<Comic, Long>{
	
	List<Comic> findByName(@Param("name") String name);
	
	Comic findOneByIssue(@Param("issue") String issue);
	
}
