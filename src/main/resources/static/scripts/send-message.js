$(document).ready(function(){

	$("#send-msg").click(function(e){
		$("#send-msg").hide().animate({opacity:0});
		$("#loader-col").show().animate({
			opacity : 1,
			
		});
		
		$name = $("#template-contactform-name").val();
		$email = $("#template-contactform-email").val();
		$phone = $("#template-contactform-phone").val();
		$subject = $("#template-contactform-subject").val();
		$msg = $("#template-contactform-message").val();
		
		message = {};
		message.name = $name;
		message.email = $email;
		message.phone = $phone;
		message.subject = $subject;
		message.message = $msg;
		
		console.log(message);
		
		 var json = JSON.stringify(message);
		
		$.ajax({
			url : "/send-msg",
			method : "POST",
			contentType: 'application/json; charset=utf-8',
		    dataType: 'json',
			data : json,
			success : function(data){
				$("#loader-col").attr("src","/images/check.gif").animate();
				var millisecondsToWait = 1500;
				setTimeout(function() {
					$("#loader-col").remove().animate({opacity: 0});
					$("#msg-sent").show().animate({opacity:1})
				}, millisecondsToWait);
				console.log(data);
			},
			error : function(err){
				console.log(err);
			}
		})
		
	    return false;
	});
});