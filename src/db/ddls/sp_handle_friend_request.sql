-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_handle_friend_request`(
	IN  in_fromEmailID     	VARCHAR(255) ,
	IN  in_toEmailID			VARCHAR(1024),
	IN  new_status			int(2), /* Valid Status: 0-Pending, 1-Accepted, 2-Rejected, 3-Blocked */
	out out_status			int(2)
)
BEGIN

	declare current_status int;

	select status into current_status 
	from friendrequest
	where FromUserID = in_fromEmailID and ToUserID = in_toEmailID;

	CASE 
		when current_status = '0' then
			update friendrequest set status=new_status, RequestSentDTTM = now() 
			where FromUserID = in_fromEmailID and ToUserID = in_toEmailID;
			set out_status = new_status;

		when current_status = '2' then
			update friendrequest set status=new_status, RequestSentDTTM = now() 
			where FromUserID = in_fromEmailID and ToUserID = in_toEmailID;
			set out_status=new_status;

		when current_status = '3' then
			/* Dont update, since the to_user has blocked from_user */
			set out_status=current_status;
		else
			insert into friendrequest(FromUserID, ToUserID, Status, RequestSentDTTM) 
			values(in_fromEmailID, in_toEmailID, new_status, now());
			set out_status = new_status;
	END CASE;
END