// Semicolon (;) to ensure closing of earlier scripting
// Encapsulation
// $ is assigned to jQuery
;(function($) {

	// DOM Ready
	$(function() {

		getSignUpForm();
		submitSignUpForm();
		registerNewSchool();
		getFullNewsAndEvents();
		resetPassword();
		
	});

})(jQuery);

function resetPassword(){
	$('#forgotPasswordBtn').on('click', function(e) {
		// Triggering bPopup when click event is fired
		getPopup($("#forgotPassword"));

	});
}
function getPopup(popUpElement){
	popUpElement.addClass("popupContent");
	popUpElement.bPopup({
		fadeSpeed : 'slow', //can be a string ('slow'/'fast') or int
		followSpeed : 1500, //can be a string ('slow'/'fast') or int
		modalColor : 'black'
	});
}
function getFullNewsAndEvents(){
	$('.school-news-and-event .read-more').on('click', function(e) {
		// Triggering bPopup when click event is fired
		var popUpContent = $(this).parent().find(".description").clone().addClass("popupContent").css("width","500px");
	
	
		popUpContent.bPopup({
			fadeSpeed : 'slow', //can be a string ('slow'/'fast') or int
			followSpeed : 1500, //can be a string ('slow'/'fast') or int
			modalColor : 'black'
		});

	});
}
function getSignUpForm (){
	// Binding a click event
	// From jQuery v.1.7.0 use .on() instead of .bind()
	$('#sign-up-button').bind('click', function(e) {
		// Triggering bPopup when click event is fired
		$('#sign-up').bPopup({
			fadeSpeed : 'slow', //can be a string ('slow'/'fast') or int
			followSpeed : 1500, //can be a string ('slow'/'fast') or int
			modalColor : 'black'
		});

	});
	
}
function submitSignUpForm() {
	$("#signUpForm").submit(function(e) {
		e.preventDefault();
		if (form.validateForm($(this))) {
			form.submitFormThroughAjax($(this));
		}

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







