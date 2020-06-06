function validateForm() {
	
	 if (!isFilled(document.addform.email)) {
		alert("Please Enter Email ID in the format mail@domain.com");
		document.addform.email.select();
	} else if (!isEmailValid(document.addform.email.value)) {
		alert("Enter Email ID in the format mail@domain.com");
		document.addform.email.select();
	} else if (!isFilled(document.addform.oldpassword)) {
		alert("Old Password can not be blank.");
		document.addform.oldpassword.focus();
	} else if (!isFilled(document.addform.newpassword)) {
		alert("New Password can not be blank.");
		document.addform.newpassword.focus();
	} else if (!strongValidPassword(document.addform.newpassword.value)) {
		alert ("New Password should be 8 to 15 characters which contain at least one lower-case letter" +
			", one upper-case letter, one numeric digit, and one special character");
		document.addform.newpassword.focus();
	} else if (!isFilled(document.addform.repassword)) {
		alert("Re-Password can not be blank.");
		document.addform.repassword.focus();
	} else if (document.addform.newpassword.value != document.addform.repassword.value) { 
        alert ("New Password and Re Password did not match: Please try again...") 
		document.addform.repassword.focus();
	} else if (document.addform.oldpassword.value == document.addform.newpassword.value) { 
        alert ("Old Password and New Password can not be same.") 
		document.addform.newpassword.focus();
	} else {
		document.addform.submit();
	}
}
