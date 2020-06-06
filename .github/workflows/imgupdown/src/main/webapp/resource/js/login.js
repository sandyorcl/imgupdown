function validateForm() {
	 if (!isFilled(document.addform.userName)) {
		alert("Please Enter User Name");
		document.addform.userName.select();
	} else if (!isFilled(document.addform.password)) {
		alert("Password can not be blank.");
		document.addform.password.focus();
	} else {
		document.addform.submit();
	}
}
