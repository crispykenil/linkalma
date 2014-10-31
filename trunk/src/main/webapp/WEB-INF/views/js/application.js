//created Utility obj and added all common and utility methods inti use(Utility.methodName)
var Utility = {
		init: function() {
			this.collapseExpandPanel();
		},
		collapseExpandPanel: function(){
			$(".collapse-expand-btn").on("click",function(){
				var collapseExpandElement = $(this).siblings(".collapse-expand-content");
				if(collapseExpandElement.length < 1) {
					collapseExpandElement = $(this).parent().siblings(".collapse-expand-content");
				} 
				collapseExpandElement.slideToggle();
				if ($(this).hasClass("fa-chevron-down")){
					$(this).removeClass("fa-chevron-down").addClass("fa-chevron-right");
				} else 
					$(this).removeClass("fa-chevron-right").addClass("fa-chevron-down");
			});
		}
};
// Semicolon (;) to ensure closing of earlier scripting
// Encapsulation
// $ is assigned to jQuery
;(function($) {

	// DOM Ready
	$(function() {

		getSignUpForm();
		submitSignUpForm();
		submitEmailInviteForm();
		registerNewSchool();
		getFullNewsAndEvents();
		addNewWorkPlace();
		resetPassword();
		emailResetLink();
		showHideMsges();
		Utility.init();
});

})(jQuery);


function showHideMsges()
{
	$('#successMsg').css('display', 'none');
}

function resetPassword(){
	$('#forgotPasswordBtn').on('click', function(e) {
		// Triggering bPopup when click event is fired
		getPopup($("#forgotPassword"));

	});
}
// Added by Kenil
function emailResetLink(){
	$("#emailPassword").submit(function(e) {
		e.preventDefault();
		if (form.validateForm($(this))) {
			form.submitFormThroughAjax({form:$(this)});
		}

	});
}
function sendFriendRequest(fromEmailAddress, toEmailAddress, index, status, targetBtn){
	if(toEmailAddress == '')
		{
		 toEmailAddress = $('#emailAddressesDelimited').val();
		}
	  $.ajax({
		  beforeSend:function(){
			 // $(targetBtn).addClass("disabled");
				$(targetBtn).append('<span class="fa fa-spinner fa-spin" style="color:#ff0000"></span>');
		  },
		  url:"invitefriends?emailAddressesDelimited="+toEmailAddress+"&fromEmailAddress="+fromEmailAddress+"&status="+status,
		  success:function(result){
		  
		  if(index != 999)
		  {
			  if(result == 0)
			  {
				  $('#friendRequestLink'+index).html('Friend Request Sent.');
			  }
			  else if(result == 1)
			  {
				  $('#friendRequestLink'+index).html('Accepted.');
			  }
			  else if(result == 2)
			  {
				  $('#friendRequestLink'+index).html('Rejected.');
			  }
			  else if(result == 3)
			  {
				  $('#friendRequestLink'+index).html('Blocked.');
			  }
		  }
		  else if(index == 999)
		  {
			  $('.message').html('Email Invitation Sent to the receiptients');
		  }
			  
	  }});
}
function getPopup(popUpElement){
	popUpElement.addClass("popupContent");
	popUpElement.append('<a class="close-bPopup fa fa-times"><a/>');
	
	popUpElement.bPopup({
		fadeSpeed : 'slow', //can be a string ('slow'/'fast') or int
		followSpeed : 1500, //can be a string ('slow'/'fast') or int
		modalColor : 'black',
		closeClass:'close-bPopup',

	});
}
function getFullNewsAndEvents(){
	$('.school-news-and-event .read-more').on('click', function(e) {
		// Triggering bPopup when click event is fired
		var popUpContent = $(this).parent().find(".description").clone().addClass("popupContent").css("width","500px");
	
		getPopup(popUpContent);


	});
}
function getSignUpForm (){
	// Binding a click event
	// From jQuery v.1.7.0 use .on() instead of .bind()
	$('#sign-up-button').bind('click', function(e) {
		// Triggering bPopup when click event is fired
		getPopup($("#sign-up"));
	});
}
function submitSignUpForm() {
	$("#signUpForm").submit(function(e) {
		e.preventDefault();
		if (form.validateForm($(this))) {
			form.submitFormThroughAjax({form:$(this)});
		}

	});
}

function submitEmailInviteForm() {
	$("#alumnusForm").submit(function(e) {
		e.preventDefault();
		/*if (form.validateForm($(this))) {
			form.submitFormThroughAjax({form:$(this)});
		}*/

	});
}
function registerNewSchool() {
	$("#registerSchoolBtn").on("click",function(e) {
		e.preventDefault();
		if(form.validateForm($("#registerSchoolForm"))){
			$("#registerSchoolForm").submit();
		}

	});
}

function addNewWorkPlace() {
	$("#saveWorkPlaceBtn").on("click",function(e) {
		e.preventDefault();
		if (form.validateForm($("#addWorkPlace"))) {
			/*alert($("#addWorkPlace input[name=fromMonthYear]").val());
			splitDate($("#addWorkPlace input[name=fromMonthYear]").val());
			splitDate($("#addWorkPlace input[name=toMonthYear]").val());*/
			alert(document.getElementById("fromMonthYear").value);
			
			splitDate(document.getElementById("fromMonthYear").value,"from");
			splitDate(document.getElementById("toMonthYear").value, "to");
			
			$("#addWorkPlaceForm").submit();
			
		}

	});
}


function addWorkDetails()
{
	// Need to add java script for splitting Month & Date.
}



