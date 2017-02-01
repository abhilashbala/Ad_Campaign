package com.infy.AdCampaign.service;

import java.util.Collection;

import com.infy.AdCampaign.entity.AdCampaign;

public interface AdCampaignService {

	Collection<AdCampaign> findAll();

	AdCampaign findOne(String partnerId);

	AdCampaign create(AdCampaign ad);
 
	AdCampaign update(AdCampaign ad);
	
	void evictCache();

	void delete(String partnerId);

}
