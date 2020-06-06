function validateForm() {
	
	if (!isFilled(document.addform.firstName)) {
		alert("First Name can not be blank.");
		document.addform.firstName.focus();
	} else if (!isFilled(document.addform.lastName)) {
		alert("Last Name can not be blank.");
		document.addform.lastName.focus();
	} else if (document.addform.mobile.value.length != 10) {
		alert("Enter valid 10 digit mobile number");
		document.addform.mobile.select();
	}  else if (!ValidMobileNo(document.addform.mobile.value)) {
		alert("Please Enter valid mobile number !");
		document.addform.mobile.select();
	} else if (!isFilled(document.addform.email)) {
		alert("Please Enter Email ID in the format mail@domain.com");
		document.addform.email.select();
	} else if (!isEmailValid(document.addform.email.value)) {
		alert("Enter Email ID in the format mail@domain.com");
		document.addform.email.select();
	} else if (!isFilled(document.addform.password)) {
		alert("Password can not be blank.");
		document.addform.password.focus();
	} else if (!strongValidPassword(document.addform.password.value)) {
		alert ("Password should be 8 to 15 characters which contain at least one lower-case letter" +
			", one upper-case letter, one numeric digit, and one special character");
		document.addform.password.focus();
	}
	else if (!isFilled(document.addform.repassword)) {
		alert("Re-Password can not be blank.");
		document.addform.repassword.focus();
	} else if (document.addform.password.value != document.addform.repassword.value) { 
        alert ("Password did not match: Please try again...") 
		document.addform.repassword.focus();
	} else if (document.addform.gender.selectedIndex == 0) {
		alert("Please Select Gender.");
		document.addform.gender.focus();
	} else {
		document.addform.submit();
	}
}
