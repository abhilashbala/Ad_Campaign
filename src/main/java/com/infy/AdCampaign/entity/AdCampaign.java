package com.infy.AdCampaign.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/* Table Structure*/
@Entity
public class AdCampaign {	
	
	@Id
	private String partnerId;
	
	private int campaignDuration;
	 
	private String adContent;
	
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public int getCampaignDuration() {
		return campaignDuration;
	}
	public void setCampaignDuration(int campaignDuration) {
		this.campaignDuration = campaignDuration;
	}
	public String getAdContent() {
		return adContent;
	}
	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}
}
