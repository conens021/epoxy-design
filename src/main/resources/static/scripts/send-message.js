$(document).ready(function(){
	var hasErorrs = false;
	$("#send-msg").click(function(e){
		
		
		
		if(hasErorrs){
			$("#msg-sent").hide().animate({opacity:0});
			$("#send-msg").hide().animate({opacity:0});
			
		}
		
		$("#loader-col").show().animate({
			opacity : 1,
			
		});
		
		$name = $("#template-contactform-name").val();
		$email = $("#template-contactform-email").val();
		$phone = $("#template-contactform-phoneNumber").val();
		$subject = $("#template-contactform-subject").val();
		$msg = $("#template-contactform-message").val();
		
		message = {};
		message.name = $name;
		message.email = $email;
		message.phone = $phone;
		message.subject = $subject;
		message.message = $msg;

		
		 var json = JSON.stringify(message);
		
		$.ajax({
			url : "/send-msg",
			method : "POST",
			contentType: 'application/json; charset=utf-8',
		    dataType: 'json',
			data : json,
			success : function(data){
				if(hasErorrs){
					console.log("show loadr");
					$("#loader-col").show().animate({
						opacity : 1,
						
					});
				}
				$validation = data.validations;
				$.each($validation, function(key, value){
					   if(!value){
						   $("#template-contactform-"+key).css("border-color","#DDD");
					   }
					
				});
				$("#send-msg").hide().animate({opacity:0});
				$("#loader-col").attr("src","/images/check.gif").animate();
				var millisecondsToWait = 1500;
				setTimeout(function() {
					$("#loader-col").remove().animate({opacity: 0});
					$("#msg-sent").removeClass("error");
					$("#msg-sent").text("Message sent!")
					$("#msg-sent").show().animate({opacity:1})
				}, millisecondsToWait);
				console.log(data);
			},
			error : function(err){
				hasErorrs = true;
				$("#loader-col").remove().animate({opacity: 0});
				$("#msg-sent").addClass("error");
				$("#msg-sent").text("Please check that all input with * are valid.");
				$("#msg-sent").show().animate({opacity:1});
				
				$validation = err.responseJSON.validations;
				
				$.each($validation, function(key, value){
					   if(!value){
						   $("#template-contactform-"+key).css("border-color","red");
					   }else{
						 
						 $("#template-contactform-"+key).css("border-color","#DDD");
					
					   }
				
				});
				
			}
		})
		
	    return false;
	});
});