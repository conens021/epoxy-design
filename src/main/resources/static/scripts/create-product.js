$(document).ready(function(){
	

	
	$("#template-contactform-checked-switch").click(function(){
		if(this.checked){
			
			$("#saleAmount").prop("disabled",false);
		}else{
			
			$("#saleAmount").prop("disabled",true);
		}
	});
	
	$( '#create-product' )
	  .submit( function( e ) {
		  console.log("Sending req1");
		$("#submit-btn").prop("disabled",true);
	    $.ajax( {
	      url: '/djeke-djole/upload-product',
	      type: 'POST',
	      data: new FormData( this ),
	      processData: false,
	      contentType: false,
	      success : function(data,textCode){
	    	  window.location.replace("/djeke-djole/list-products");
	      },
	      error : function(data,errorCode){
	    	  $("#template-contactform-name").show();
	    	  $("#template-contactform-name").css("border-color","red");
	    	  $("#template-contactform-title").show();
	    	  $("#template-contactform-title").css("border-color","red");
	    	  $("#template-contactform-default-select").show();
	    	  $("#template-contactform-default-select").css("border-color","red");
	    	  $("#template-contactform-budget").show();
	    	  $("#template-contactform-budget").css("border-color","red");
	    	
	    	  
	    	  $("#submit-btn").prop("disabled",false);
	    	  $("#errors").show().animate("opacity","1");
	    	  console.log("ERROR");
	    	  console.log(data);
	    	  
	    	  var errorJson = data.responseJSON.msg;
	    	  
	    	  console.log(errorJson);
	    	  
	    	  $("#errors").text(errorJson);
	
	      }
	    } );
	    e.preventDefault();
	    
	    return false;
	  } );
});