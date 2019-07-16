

$("#place-order").click(function(event){
	$("#place-order").prop("disabled",true);
	$formisValid = false;
	if($("#checkbox-10").is(":checked")){
		$("input").each(function(key,element){
			if($(element).is(":required") ){
				
	
				
				if( !validate(element)){
					
					$formisValid = false;
					$("#place-order").prop("disabled",false);
					return;
				}else{
					$formisValid = true;
				}
				
			
			}
		})
		
		if($formisValid){
			$("#place-order").hide().animate({opacity:0});
			$("#form-loader").show().animate({opacity:1});
			$("#order-form").submit();
		}
		else{
			$("#place-order").prop("disabled",false);
			console.log("not valid");
		}
	}
	else{
		console.log("not valid");
		$("#place-order").prop("disabled",false);
		$("#check-error").css("display","block");
	}
})



function validate(element){
	$elName = $(element).attr("name");
	$elValue = $(element).val();
	
	$valid = false;
	
	
	switch($elName){
		case 'firstName':
		case 'lastName':
			$valid = nameValidation($elValue,$elName);
			break;
		case 'email':
			$valid = emailValidation($elValue);
			break;
		case 'phoneNumber':
			$valid = phoneNumbValidation($elValue);
			break;
		case 'personalId':
			$valid = personalIdValidation($elValue);
			break;
		default:
			$valid = true;
			break;
			
	}
	
	
	return $valid;

}



function nameValidation(value,elName){
	if(value.length >= 2)
		{
			if(elName ==='firstName'){
				$("#error-f-name").css("display","none");
			}else{
				$("#error-l-name").css("display","none");
			}
			return true;
		}
	else {
		if(elName ==='firstName'){
			$("#error-f-name").css("display","block");
		}else{
			$("#error-l-name").css("display","block");
		}
		return false;
	}
}


function emailValidation(value){
	var regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	var valid = regex.test(String(value).toLowerCase());
	
	if(valid){
		$("#error-email").css("display","none");
		return valid;
	}
	
	$("#error-email").css("display","block");
	
	return valid;
  
}

function phoneNumbValidation(value){
	var regex = /^\+?([0-9]{3})\)?[-. ]?([0-9]{2})[-. ]?([0-9]{6,7})$/;
	var valid =  regex.test(String(value).toLowerCase());
	
	if(valid){
		$("#error-phone").css("display","none");
		return valid;
	}
	
	$("#error-phone").css("display","block");
	
	return valid;

	
}


function personalIdValidation(value){
	if(value.length >= 6){
		$("#error-id").css("display","none");
		return true;
	}
	else{
		$("#error-id").css("display","block");
		return false;
	}
}