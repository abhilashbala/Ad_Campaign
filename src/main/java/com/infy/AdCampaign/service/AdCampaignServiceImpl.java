package com.infy.AdCampaign.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infy.AdCampaign.entity.AdCampaign;
import com.infy.AdCampaign.repository.copy.AdCampaignRepository;

/* Actual business Logic*/
@Service
@Transactional(propagation = Propagation.SUPPORTS,
readOnly = true)
public class AdCampaignServiceImpl implements AdCampaignService {
	
	@Autowired
	AdCampaignRepository adRepo;

	@Override
	public Collection<AdCampaign> findAll() {
		Collection<AdCampaign> ads = adRepo.findAll();
		return ads;
	}

	@Override
	public AdCampaign findOne(String partnerId) {
		Collection<AdCampaign> allAds = findAll();
		for(AdCampaign ad: allAds){
			if(ad.getPartnerId().equals(partnerId)){
				return ad;
			}
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,
	readOnly=false)
	public AdCampaign create(AdCampaign ad) {
		//Since PartnerId is AutoGenerated 
		if(ad.getPartnerId() == null){
			return null;
		}
		AdCampaign adCreate = adRepo.save(ad);
		return adCreate;
	} 

	@Override
	@Transactional(propagation = Propagation.REQUIRED,
	readOnly=false) 
	public AdCampaign update(AdCampaign ad) {
		//Differentiate between create and update
		AdCampaign adPersisted = findOne(ad.getPartnerId());
		if(adPersisted == null){
				return null;
		}
		adPersisted.setCampaignDuration(2323);
		AdCampaign adUpdate = adRepo.save(adPersisted);
		return adUpdate;
	}
	
	@Override
	public void delete(String partnerId) {
		adRepo.delete(partnerId);
	}

	@Override
	public void evictCache() {
		
		adRepo.deleteAll();
		
	}


	
}