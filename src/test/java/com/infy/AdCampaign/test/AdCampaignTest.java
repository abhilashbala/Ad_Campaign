package com.infy.AdCampaign.test;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.infy.AdCampaign.entity.AdCampaign;
import com.infy.AdCampaign.service.AdCampaignService;

/* Junit test cases */
public class AdCampaignTest extends AbstractTest {
	@Autowired
	AdCampaignService service;

	@Before
	public void setUp() { 
		System.out.println("Starting Unit Test Setup");
	}

	@After
	public void tearDown() {
		service.evictCache();
	}

	/* Get All Elements */
	@Test
	public void testFindAll() {

		Collection<AdCampaign> list = service.findAll();
		//Add 2 elements and test this
		Assert.assertNotNull("Failure for - List is Not Null", list);
		Assert.assertEquals("Failure for - Expected List size 2", 4, list.size());
	}

	/* Create/Post test case */
	@Test
	public void testCreate(){
		AdCampaign adCreate = new AdCampaign();
		adCreate.setPartnerId("Abhi81");
		adCreate.setAdContent("This is a test case");
		adCreate.setCampaignDuration(445);
		
		AdCampaign createdAd = service.create(adCreate);
		Assert.assertNotNull("Ad Not Created", createdAd);
		Assert.assertNotNull("Ad Not Created", createdAd.getPartnerId());
		
	}
	
	 /* Finding one test case */
	@Test
	public void findAd(){
		
		AdCampaign adCreate = new AdCampaign();
		adCreate.setPartnerId("Abhi81");
		adCreate.setAdContent("This is a test case");
		adCreate.setCampaignDuration(485);
		service.create(adCreate);
		AdCampaign findOne = service.findOne(adCreate.getPartnerId());
		Assert.assertEquals("Both objects are Equal", findOne.getPartnerId(), adCreate.getPartnerId());
		
	}
	
	/* UPdate test case */
	@Test
	public void testUpdate(){
		AdCampaign adCreate = new AdCampaign();
		adCreate.setPartnerId("Abhi83");
		adCreate.setAdContent("This is a test case");
		adCreate.setCampaignDuration(445);
		service.create(adCreate);
		
		AdCampaign createdAd = service.update(adCreate);
		Assert.assertEquals("Both objects are Equal", 2323,createdAd.getCampaignDuration());		
	}
	
	
	/* Delete test case */
	@Test
	public void testDelete(){
		AdCampaign adCreate = new AdCampaign();
		adCreate.setPartnerId("Abhi84");
		adCreate.setAdContent("This is a test case");
		adCreate.setCampaignDuration(445);
		service.create(adCreate);
		service.delete(adCreate.getPartnerId());
			
	}
}
