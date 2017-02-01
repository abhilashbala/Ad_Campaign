package com.infy.AdCampaign.repository.copy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infy.AdCampaign.entity.AdCampaign;



@Repository
public interface AdCampaignRepository extends JpaRepository<AdCampaign, String> {
/* 
 * Implements Spring Data JPA Repository which handles the CRUD operations 
 * src/main/resources/application.properties is used to specify the dialect of sql 
 * data.sql has the data required
 * schema.sql has the table definitions
 * 
 * */
}
  