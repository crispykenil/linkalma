var form = {
	formFields : "input[type='text'],input[type='password']",

	makeFormReadonly : function(form) {
		$(this.formFields, form).each(function() {
			$(this).attr("readonly", true);
		});
		form.addClass("readOnlyForm");
	},
	makeFormEditable : function(form) {
		$(this.formFields, form).each(function() {
			$(this).attr("readonly", false);
		});
		form.removeClass("readOnlyForm");
	},
	validateForm : function(form) {

		$(".errorMsg", form).remove();
		var isFormValidate = true;

		$(".required", form).each(function() {
			if ($.trim($(this).val()).length == 0) {
				$(this).addClass("vError");
			} else {
				$(this).removeClass("vError");
			}
		});

		// password match validation
		if ($("input[type='password']", form).length > 1) {
			var errContainer = $("<div class='errorMsg'></div>");
			var errMsg = "Your password does not match";
			var pwdField1 = $("input[type='password']", form).eq(0);
			var pwdField2 = $("input[type='password']", form).eq(1);

			if (pwdField1.val() != pwdField2.val()) {
				$(pwdField2).addClass("vError");
				errContainer.html(errMsg);
				$(pwdField2).after(errContainer);

			} else {
				$(pwdField2).removeClass("vError");
			}

		}
		// email validation
		var emailFields = $(".emailField", form);
		if (emailFields.length > 0) {
			// if any value then only validate email pattern
			var errContainer = $("<div class='errorMsg'></div>");
			if ($.trim(emailFields.val()).length > 0) {
				var errMsg = "Pleae enter a valid email address";
				var reg = /^\w.+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;

				if (reg.test(emailFields.val())) {
					emailFields.removeClass("vError");
					emailFields.next("div").remove();

				} else {
					emailFields.addClass("vError");
					errContainer.html(errMsg);
					emailFields.after(errContainer);

				}
			}

			// if ($(email).attr("errMsg") == udefined ||
			// $.trim($(email).attr("errMsg")))

		}

		if ($(".vError", form).length > 0) {
			isFormValidate = false;
		}

		return isFormValidate;

	}

};

(function($) {
	$.fn.bindEditUpdateFunctionality = function(options) {
		var myForm = this;
		var beforeUpdateFormData = "", afterUpdateFormData = "";
		var editFormBtn = $(".editFormBtn", myForm);
		var cancelUpdateAction = $(".cancelUpdateAction", myForm);
		

		// This is the easiest way to have default options.
		// var settings = $.extend({
		// These are the defaults.
		// color : "#556b2f",
		// backgroundColor : "white"
		// }, options);
		
			editFormBtn.on("click",	function() {
				$(this).siblings("input[type='reset']").attr(
						"disabled", false);
				if ($(this).hasClass("editFormBtn")) {
					beforeUpdateFormData = myForm.serialize();
					$(this).val("Update");
					form.makeFormEditable(myForm);
				} else {
					afterUpdateFormData = myForm.serialize();
					if (beforeUpdateFormData != afterUpdateFormData) {
						alert("found some updation so please valid form and submit it");
						if (form.validateForm(myForm)) {
							alert("form is valid submit now");
						}

					} else {
						alert("please change something before update");
						return false;
					}
				}
				$(this).toggleClass("editFormBtn");
			});
			
			cancelUpdateAction.on("click", function() {
				var editUpdateBtn = editFormBtn;
				editUpdateBtn.toggleClass("editFormBtn");
				editUpdateBtn.val("Edit");
				form.makeFormReadonly(myForm);
				$(this).attr("disabled",true);
			});
	};
	
}(jQuery));