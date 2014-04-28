
$( document ).ready(function() {
	getAddMySchoolForm();
	hideShowMairrageInfo();
	$(".personalDetailsForm").bindEditUpdateFunctionality({callback:submitPersonalDetails});
	$(".schoolDetailsForm").bindEditUpdateFunctionality();
});

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
	form.submitFormThroughAjax(formEl);
};