// Semicolon (;) to ensure closing of earlier scripting
// Encapsulation
// $ is assigned to jQuery
(function($) {

	// DOM Ready
	$(function() {

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
		submitSignUpForm();

	});

})(jQuery);

function submitSignUpForm() {
	$("#signUpForm").submit(function(e) {
		e.preventDefault();
		if (validateForm($(this))) {
			submitFormThroughAjax($(this));
		}

	});
}

function submitFormThroughAjax(form) {
	var formData = form.serialize();
	$.ajax({
		type : "POST",
		url : "createProfile",
		data : formData

	}).done(function(data) {
		alert(data);
	});
}
function validateForm(form) {
	
	var isFormValidate = true;
	$(".required", form).each(function() {
		if ($(this).val().length == 0) {
			$(this).addClass("vError");
			isFormValidate = false;
		} else {
			$(this).removeClass("vError");
		}
	});
	if($(".vError"),form){
		isFormValidate = false;
		
	}
	//password match validation
	if($("input[type='password']", form).length > 1){
		var pwdField1 = $("input[type='password']", form).eq(0);
		var pwdField2 = $("input[type='password']", form).eq(1);
		alert(pwdField1.val() == pwdField2.val());
		if (pwdField1.val() != pwdField2.val()){
			$(pwdField1).addClass("vError");
			$(pwdField1).addClass("vError");
		} else {
			$(pwdField1).removeClass("vError");
			$(pwdField1).removeClass("vError");
		}
		
	}
	return isFormValidate;
	alert(isFormValidate);
}