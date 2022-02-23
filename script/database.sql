CREATE DATABASE fleetnotification;

-- Drop table

-- DROP TABLE public.message;

CREATE TABLE message (
	message_id varchar(10) NOT NULL,
	"content" varchar(255) NULL,
	"language" varchar(255) NULL,    -- "TH", "EN"
	status varchar(15) NULL DEFAULT 'ACTIVE',    -- "ACTIVE", "INACTIVE"
	subject varchar(255) NULL,
  create_by varchar(255) NULL,
  create_on timestamp NULL,
	update_by varchar(255) NULL,
	update_on timestamp NULL,
	CONSTRAINT message_pkey PRIMARY KEY (message_id)
);
