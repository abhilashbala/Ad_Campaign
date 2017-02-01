package com.infy.AdCampaign.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.AdCampaign.entity.AdCampaign;
import com.infy.AdCampaign.service.AdCampaignService;

/* Controller class for Creating Ad, Finding Ads, Deleting Ads and Updating Ads*/
@RestController
public class AdCampaignController {

	@Autowired
	AdCampaignService adCampService;
	
@RequestMapping(value="/ad", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)	
public ResponseEntity<AdCampaign> createAd(@RequestBody AdCampaign ad){
	    
	AdCampaign createdAd = adCampService.create(ad);
		
		if(createdAd == null){
			return new ResponseEntity<AdCampaign>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<AdCampaign>(createdAd, HttpStatus.CREATED);
	}


@RequestMapping(value="/allAds", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Collection<AdCampaign>> listOfSavedAds(){
	
	Collection<AdCampaign> listOfSavedAds = adCampService.findAll();
	
	return new ResponseEntity<Collection<AdCampaign>>(listOfSavedAds, HttpStatus.OK);

}

@RequestMapping(value = "/ad/{partnerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<AdCampaign> getGreeting(@PathVariable("partnerId") String id) {

	AdCampaign findAd = adCampService.findOne(id);

	if (findAd == null) {
		return new ResponseEntity<AdCampaign>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<AdCampaign>(findAd, HttpStatus.OK);
}

@RequestMapping(value = "/ad", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<AdCampaign> updateGreeting(@RequestBody AdCampaign ad) {

	AdCampaign adUpdate = adCampService.update(ad);

	if (adUpdate == null) {
		return new ResponseEntity<AdCampaign>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<AdCampaign>(adUpdate, HttpStatus.OK);
}

@RequestMapping(value = "/ad/{partnerId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<AdCampaign> deleteGreeting(@PathVariable("partnerId") String partnerId) {

	adCampService.delete(partnerId);
	return new ResponseEntity<AdCampaign>(HttpStatus.NO_CONTENT);
 
}


}
