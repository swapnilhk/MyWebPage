function validateLogin(){	
	var input = document.getElementById("username").value;
	if(input == null || input == ""){
		document.getElementById("loginError").innerHTML = "Username should not be blank";
		document.getElementById("username").style.borderColor = "red";
		document.getElementById("password").style.borderColor = "";
		return false;
	}
	var input = document.getElementById("password").value;
	if(input == null || input == ""){
		document.getElementById("loginError").innerHTML = "Password should not be blank";
		document.getElementById("username").style.borderColor = "";
		document.getElementById("password").style.borderColor = "red";
		return false;
	}
	return true;
}

function validateRegister(){	
	var input = document.getElementById("username2").value;
	if(input == null || input == ""){
		document.getElementById("registerError").innerHTML = "Username should not be blank";
		document.getElementById("username2").style.borderColor = "red";
		document.getElementById("password2").style.borderColor = "";
		document.getElementById("confirmPassword2").style.borderColor = "";
		document.getElementById("fullName").style.borderColor = "";		
		document.getElementById("answer").style.borderColor = "";
		return false;
	}
	var pass1 = document.getElementById("password2").value;
	if(pass1 == null || pass1 == ""){
		document.getElementById("registerError").innerHTML = "Password should not be blank";
		document.getElementById("username2").style.borderColor = "";
		document.getElementById("password2").style.borderColor = "red";
		document.getElementById("confirmPassword2").style.borderColor = "";
		document.getElementById("fullName").style.borderColor = "";	
		document.getElementById("answer").style.borderColor = "";	
		return false;
	}
	var pass2 = document.getElementById("confirmPassword2").value;
	if(pass2 == null || pass2 == ""){
		document.getElementById("registerError").innerHTML = "Confirm Password field should not be blank";
		document.getElementById("username2").style.borderColor = "";
		document.getElementById("password2").style.borderColor = "";
		document.getElementById("confirmPassword2").style.borderColor = "red";
		document.getElementById("fullName").style.borderColor = "";
		document.getElementById("answer").style.borderColor = "";	
		return false;
	}
	if(pass1 != pass2){
		document.getElementById("registerError").innerHTML = "Passwords do not match";
		document.getElementById("username2").style.borderColor = "";
		document.getElementById("password2").style.borderColor = "red";
		document.getElementById("confirmPassword2").style.borderColor = "red";
		document.getElementById("fullName").style.borderColor = "";
		document.getElementById("answer").style.borderColor = "";	
		return false;
	}
	var input = document.getElementById("fullName").value;
	if(input == null || input == ""){
		document.getElementById("registerError").innerHTML = "Full name should not be blank";
		document.getElementById("username2").style.borderColor = "";
		document.getElementById("password2").style.borderColor = "";
		document.getElementById("confirmPassword2").style.borderColor = "";
		document.getElementById("fullName").style.borderColor = "red";
		document.getElementById("answer").style.borderColor = "";	
		return false;
	}
	var input = document.getElementById("answer").value;
	if(input == null || input == ""){
		document.getElementById("registerError").innerHTML = "Answer should not be blank";
		document.getElementById("username2").style.borderColor = "";
		document.getElementById("password2").style.borderColor = "";
		document.getElementById("confirmPassword2").style.borderColor = "";
		document.getElementById("fullName").style.borderColor = "";
		document.getElementById("answer").style.borderColor = "red";	
		return false;
	}
	return true;
}

function validateChangePassword() {
	var pass1 = document.getElementById("newPassword").value;
	if(pass1 == null || pass1 == ""){		
		document.getElementById("errorMessage").innerHTML = "Password should not be blank";
		document.getElementById("newPassword").style.borderColor = "red";
		document.getElementById("confirmPassword").style.borderColor = "";			
		return false;
	}
	var pass2 = document.getElementById("confirmPassword").value;
	if(pass2 == null || pass2 == ""){		
		document.getElementById("errorMessage").innerHTML = "Confirm Password field should not be blank";
		document.getElementById("newPassword").style.borderColor = "";
		document.getElementById("confirmPassword").style.borderColor = "red";			
		return false;
	}
	if(pass1 != pass2){
		document.getElementById("errorMessage").innerHTML = "Passwords do not match";
		document.getElementById("newPassword").style.borderColor = "red";
		document.getElementById("confirmPassword").style.borderColor = "red";
		return false;
	}
	return true;
}

function validateChangePassword2() {
	var pass = document.getElementById("oldPassword").value;
	if(pass == null || pass == ""){		
		document.getElementById("errorMessage").innerHTML = "Old Password field should not be blank";
		document.getElementById("oldPassword").style.borderColor = "red";
		document.getElementById("newPassword").style.borderColor = "";
		document.getElementById("confirmPassword").style.borderColor = "";			
		return false;
	}
	var pass1 = document.getElementById("newPassword").value;
	if(pass1 == null || pass1 == ""){		
		document.getElementById("errorMessage").innerHTML = "Password should not be blank";
		document.getElementById("oldPassword").style.borderColor = "";
		document.getElementById("newPassword").style.borderColor = "red";
		document.getElementById("confirmPassword").style.borderColor = "";			
		return false;
	}
	var pass2 = document.getElementById("confirmPassword").value;
	if(pass2 == null || pass2 == ""){		
		document.getElementById("errorMessage").innerHTML = "Confirm Password field should not be blank";
		document.getElementById("oldPassword").style.borderColor = "";
		document.getElementById("newPassword").style.borderColor = "";
		document.getElementById("confirmPassword").style.borderColor = "red";			
		return false;
	}
	if(pass1 != pass2){
		document.getElementById("errorMessage").innerHTML = "Passwords do not match";
		document.getElementById("oldPassword").style.borderColor = "";
		document.getElementById("newPassword").style.borderColor = "red";
		document.getElementById("confirmPassword").style.borderColor = "red";
		return false;
	}
	return true;
}