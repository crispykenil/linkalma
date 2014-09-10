-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pwd_reset_link_insert`(
        IN  p_emailAddress     	VARCHAR(255) ,
		IN  p_newCode			VARCHAR(1024),
		IN  p_operation			varchar(20), /* Valid Operations: VERIFY, GENERATE */
		out out_code			VARCHAR(1024),
		out isExpired			VARCHAR(1)
     )
BEGIN 
	declare count_emailid int;
	declare timediff int;
	declare no_of_days int;

	if (p_operation = 'VERIFY') then

		select count(EmailAddress) into count_emailid 
		from verificationlinks 
		where EmailAddress = p_emailAddress;

		IF(count_emailid > 0) THEN

			select (unix_timestamp(now()) - unix_timestamp(createdttm)) / (3600*24) into timediff 
			from verificationlinks where EmailAddress = p_emailAddress;

			select PrimaryDecode into no_of_days 
			from staticcodes 
			where CategoryID = 4;

			IF (timediff > no_of_days) THEN
				set isExpired = 'Y';
			ELSE
				set isExpired = 'N';
			END IF;
		
		ELSE
			set isExpired = 'N';
		END IF;

	ELSE
		select count(EmailAddress) into count_emailid 
		from verificationlinks 
		where EmailAddress = p_emailAddress;

		IF(count_emailid > 0) THEN

			select (unix_timestamp(now()) - unix_timestamp(createdttm)) / (3600*24) into timediff 
			from verificationlinks where EmailAddress = p_emailAddress;

			select PrimaryDecode into no_of_days 
			from staticcodes 
			where CategoryID = 4;

			IF (timediff > no_of_days) THEN
				update verificationlinks set code = p_newCode where EmailAddress = p_emailAddress;
				set out_code = p_newCode;
				set isExpired = 'Y';
			ELSE
				select code into out_code from verificationlinks where EmailAddress = p_emailAddress;
				set isExpired = 'N';
			END IF;
		
		ELSE
			INSERT INTO verificationlinks (EmailAddress, CODE) VALUES (p_emailAddress, p_newCode) ; 
			set isExpired = 'N';
		END IF;
	END IF;
END