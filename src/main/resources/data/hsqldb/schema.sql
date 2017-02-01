DROP TABLE AdCampaign IF EXISTS;

CREATE TABLE ad_campaign (
	partner_id VARCHAR(100) NOT NULL,
	campaign_duration INT NOT NULL,
	ad_content VARCHAR(100) NOT NULL,
	PRIMARY KEY(partner_id)
);