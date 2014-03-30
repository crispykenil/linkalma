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
		registerNewSchool();

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

function registerNewSchool() {
	$("#registerSchoolForm").submit(function(e) {
		e.preventDefault();
		if (validateForm($(this))) {
			$(this).submit();
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
	var errContainer = $("<div class='errorMsg'></div>");
	$(".errorMsg", form).remove();
	var isFormValidate = true;
	
	$(".required", form).each(function() {
		if ($.trim($(this).val()).length == 0) {
			$(this).addClass("vError");
		} else {
			$(this).removeClass("vError");
		}
	});

	//password match validation
	if($("input[type='password']", form).length > 1){
		var errMsg = "Your password does not match";
		var pwdField1 = $("input[type='password']", form).eq(0);
		var pwdField2 = $("input[type='password']", form).eq(1);

		if (pwdField1.val() != pwdField2.val()){
			$(pwdField2).addClass("vError");
			errContainer.html(errMsg);
			$(pwdField2).after(errContainer);
			
		} else {
			$(pwdField2).removeClass("vError");
			
		}
		
	}
	//email validation
	var emailFields = $(".emailField", form);
	if(emailFields.length > 0){
		// if any value then only validate email pattern
		if($.trim(emailFields.val()).length > 0){
			var errMsg = "Pleae enter a valid email address";
			var reg = /^\w.+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/ ;
			
			if (reg.test(emailFields.val())){
				emailFields.removeClass("vError");
				emailFields.next("div").remove();
				
			} else {
				emailFields.addClass("vError");
				errContainer.html(errMsg);
				emailFields.after(errContainer);
			
			}
		}
		
		//if ($(email).attr("errMsg") == udefined || $.trim($(email).attr("errMsg"))) 
		
	}

	if($(".vError",form)){
		isFormValidate = false;
	}
	
	return isFormValidate;

}