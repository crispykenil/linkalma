// Semicolon (;) to ensure closing of earlier scripting
// Encapsulation
// $ is assigned to jQuery
;(function($) {

	// DOM Ready
	$(function() {
		getAddMySchoolForm();
		getAddMyWorkDetailsForm();
		hideShowMairrageInfo();
		$(".personalDetailsForm").bindEditUpdateFunctionality({callback:submitPersonalDetails});
		$(".schoolDetailsForm").bindEditUpdateFunctionality({callback:submitSchoolDetails});
		$(".workDetailsForm").bindEditUpdateFunctionality();

	});

})(jQuery);
function hideShowMairrageInfo(){
	if ($("#maritalStatus input[type='radio'].single:checked").length > 0) {
		$("#mairrageInfo").hide();
	} else {
		$("#mairrageInfo").show();
	}
	$("#maritalStatus input[type='radio']").on("click",function(){
		if($(this).hasClass("single")){
			$("#mairrageInfo").hide();
		} else {
			$("#mairrageInfo").show("slow");
		}
	});
}
var submitPersonalDetails = function(){
	var formEl = $('#personalDetailsForm');
	var formData = formEl.serialize();
	var url = formEl.attr("action");
	$.ajax({
		type : "POST",
		url : url,
		data : formData

	}).done(function(data) {
		html = $.parseHTML( data );
		
		
		formEl.html($(html).find('#personalDetailsForm'));
		$(".personalDetailsForm").bindEditUpdateFunctionality({callback:submitPersonalDetails});
		hideShowMairrageInfo();
	}).error(function(data) {
		alert("error");
	});
};

var submitSchoolDetails = function(){
	var form = $('#userSchoolDetailsForm');
	form.submitFormThroughAjax(form);
};

function getAddMyWorkDetailsForm(){
	$('.addMyWorkDetaitsBtn').bind('click', function() {
		$('#addMyWorkDetails').bPopup({
			fadeSpeed : 'slow', //can be a string ('slow'/'fast') or int
			followSpeed : 1500, //can be a string ('slow'/'fast') or int
			modalColor : 'black'
		});
	});
}

function getAddMySchoolForm(){
	$('.addMySchool').bind('click', function() {
		$('#addMySchool').bPopup({
			fadeSpeed : 'slow', //can be a string ('slow'/'fast') or int
			followSpeed : 1500, //can be a string ('slow'/'fast') or int
			modalColor : 'black'
		});
	});
}