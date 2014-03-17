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
				
				fadeSpeed: 'slow', //can be a string ('slow'/'fast') or int
				followSpeed: 1500, //can be a string ('slow'/'fast') or int
				modalColor: 'black'
				});

            });

        });

    })(jQuery);