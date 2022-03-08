CREATE DATABASE fleetdb.notification;

CREATE TABLE notification.message (
	message_id SERIAL PRIMARY KEY,
	"content" varchar(255) NULL,
	"html_content" text null,
	"language" varchar(255) NULL,    -- "TH", "EN"
	status varchar(15) NULL DEFAULT 'ACTIVE',    -- "ACTIVE", "INACTIVE"
	subject varchar(255) NULL,
    create_by varchar(255) NULL,
    create_on timestamp NULL,
	update_by varchar(255) NULL,
	update_on timestamp NULL
);