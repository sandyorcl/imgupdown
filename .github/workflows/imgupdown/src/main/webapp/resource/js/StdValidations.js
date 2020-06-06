
var errfound=false ;
 function error(elem, text)
 {
                if (errfound)
				 return;
                window.alert(text); 
                elem.select(); 
               //elem.focus(); 
                errfound = true;
 }
  function error1(elem, text)
 {
                if (errfound)
				 return;
                window.alert(text); 
				if(eval(elem+".type") != 'select-one' && eval(elem+".type") != 'select-multiple'){
				 eval(elem+".select()"); }
                eval(elem+".focus()"); 
                errfound = true;
 }
/* THIS FUNCTION VALIDATES THAT FIELD IS NULL */
 function isNull(item){
 		if(eval(item=="")) {
					return false;
		}
		return true;
 }

 /* THIS FUNCTION VALIDATES IP ADDRESSESS */
 
function ValidIp(item)
{
	
		var countDots=0;
                if (item == 0)
                 return false;
                var str="1234567890.";
                var l = item.length;
                for (i=0; i < l; i++){
					if (str.indexOf(item.charAt(i)) == -1)
                    	return false;
					else if(item.charAt(i)=='.' )
						countDots = countDots+1;
				
				}
				if (item.indexOf('.')== -1)
					return false;
				if(countDots !=3)
					return false;
				if (item.charAt(0)=='.'||item.charAt(l-1)=='.')
					return false;

				
			    return true;
}

 /* THIS FUNCTION VALIDATES LEADING/TRAILING BLANKS   */
 	 function ValidateLeadTrailBlanks(item){

	 	 var l = parseInt(item.length);
		
	 	if(item.charAt(0)==' '||item.charAt(l-1)==' '){
			
			return false;
		}
		 return true;
	 }
 
  
/* THIS FUNCTION VALIDATES STRINGS WITHOUT SPECIAL CHARACTERS */
 
 function ValidName(item)
{
 var str="\\:qwertyiuposadfghjklxzcvbmnQEWRTYUOIPLKJHGFDSAMNBVCXZ1234567890- ";
                var l = item.length;
/*			if( item.indexOf(' ') == 0 ) {
			       	return false;
			}*/
/*			else if(item.indexOf(' ') == l-1||eval(item.charAt(l-1))==' '){
			       	return false;			
			}
*/
                  for (i=0; i < l; i++){
                     if (str.indexOf(item.charAt(i)) == -1){
					// alert("chintu")
                       return false;
					 }
				  }	   
                return true;
}


/* THIS FUNCTION VALIDATES STRINGS WITHOUT NUMBERS */
 
 function ValidNameOnly(item)
{
 var str="\\:qwertyiuposadfghjklxzcvbmnQEWRTYUOIPLKJHGFDSAMNBVCXZ-";
                var l = item.length;
/*			if( item.indexOf(' ') == 0 ) {
			       	return false;
			}*/
/*			else if(item.indexOf(' ') == l-1||eval(item.charAt(l-1))==' '){
			       	return false;			
			}
*/
                  for (i=0; i < l; i++){
                     if (str.indexOf(item.charAt(i)) == -1){
					// alert("chintu")
                       return false;
					 }
				  }	   
                return true;
}



/* THIS FUNCTION VALIDATES STRINGS WITHOUT SPACES */
 
 function ValidId(item)
{
 var str="\\:qwertyiuposadfghjklxzcvbmnQEWRTYUOIPLKJHGFDSAMNBVCXZ1234567890-";
                var l = item.length;
/*			if( item.indexOf(' ') == 0 ) {
			       	return false;
			}*/
/*			else if(item.indexOf(' ') == l-1||eval(item.charAt(l-1))==' '){
			       	return false;			
			}
*/
                  for (i=0; i < l; i++){
                     if (str.indexOf(item.charAt(i)) == -1){
					// alert("chintu")
                       return false;
					 }
				  }	   
                return true;
}

/* THIS FUNCTION VALIDATES STRINGS CONTAINS ONLY NAME AND NUMBERS.*/
 
 function ValidNameNo(item)
{
 var str="qwertyiuposadfghjklxzcvbmnQEWRTYUOIPLKJHGFDSAMNBVCXZ1234567890";
                var l = item.length;

                  for (i=0; i < l; i++){
                     if (str.indexOf(item.charAt(i)) == -1){
					
                       return false;
					 }
				  }	   
                return true;
}

/* THIS FUNCTION VALIDATES POSITIVE NON ZERO INTEGERS */
 
function ValidPositiveNonZeroInt(item)
{
                if (item == 0)
                 return false;
                var str="1234567890";
                var l = item.length;
                for (i=0; i < l; i++){
				if (str.indexOf(item.charAt(i)) == -1)
                    return false;
				
				}
               return true;
}

/* THIS FUNCTION VALIDATES POSITIVE INTEGERS INCLUDING ZERO  */
function ValidPositiveWithZeroInt(item)
{
                if (item == 0)
                 return true;
                var str="1234567890";
                var l = item.length;
				for (i=0; i < l; i++){
				if (str.indexOf(item.charAt(i)) == -1){
				   return false;
				}
				
				}
               return true;
}
/* THIS FUNCTION VALIDATES NEGATIVE INCLUDING ZERO INTEGERS */
function ValidNegativeWithZeroInt(item)
{				
                if (item == 0)
                 return true;
				 /*if (item > 0)
                 return false; */
                var str="1234567890";
                var l = item.length;
				if(!(isNaN(item))){
					var item1=parseInt(item);
					var result=eval(item==item1);
					if(!result)
					return false;
				}
				if(item<0){
				return true;
				} else{
                for (i=0; i < l; i++)
                 if (str.indexOf(item.charAt(i)) == -1)
                    return false;
				}
               		return true;

}

/* THIS FUNCTION VALIDATES NEGATIVE NON ZERO INTEGERS */
function ValidNegativeNonZeroInt(item)
{				
                if (item == 0)
                 return false;
				if (item > 0)
                 return false; 
                var str="1234567890";
                var l = item.length;
				if(!(isNaN(item))){
					var item1=parseInt(item);
					var result=eval(item==item1);
					if(!result)
					return false;
				}
				if(item<0){
				return true;
				} else{
                for (i=0; i < l; i++)
                 if (str.indexOf(item.charAt(i)) == -1)
                    return false;
				}
               		return true;
			
}
/* THIS FUNCTION VALIDATES ALL NUMBERS */
function ValidAllNum(item)
{				
				 var l = item.length;
				if(eval(item=="") || (item.indexOf(' ') == 0) || (item.indexOf(' ') == l-1)) {
       			return false;
				 }
                if (item == 0){
					return true;
				 }
				 
                var str="1234567890";
               	if(!(isNaN(item))){
					var item1=parseInt(item);
					var result=eval(item==item1);
					var temp=eval(item.charAt(l-1)==".");
					if(result && temp){
						return true;
					}
					if(!(result))
						return true;
				}
				if(item<0){
				return true;
				} else {
                for (i=0; i < l; i++)
                 if (str.indexOf(item.charAt(i)) == -1)
                    return false;
				}
               		return true;
			
}

//FUNCTION TO VALIDATE DECIMAL-WITH-ZERO-POSITIVE NUMBER

function ValidDesimalWithZeroPosNum(item)
{				 if (item == 0)
                 return true;
                var str="1234567890";
                var l = item.length;
				if(!(isNaN(item))){
					var item1=parseInt(item);
					var result=eval(item==item1);
					var temp=eval(item.charAt(l-1)==".");
				if(result && temp && item>0  ){
					return true;
					}
					if(!(result)&& item>0 ){
						return true;
					}
				}
				if(item<0){
				return false;
				} else{
                for (i=0; i < l; i++)
                 if (str.indexOf(item.charAt(i)) == -1)
                    return false;
				}
               		return true;
  }

// FUNCTION TO VALIDATE DECIMAL-WITH-ZERO-NEGATIVE-NUMBER

function ValidDesimalWithZeroNegativeNum(item)
{				 if (item == 0)
                 return true;
				 
                var str="1234567890";
                var l = item.length;
				if(!(isNaN(item))){
					var item1=parseInt(item);
					var result=eval(item==item1);
					var temp=eval(item.charAt(l-1)==".");
				if(result && temp && item<0){
						return true;
					}
					if(!(result)&& item<0){
						return true;
					}
				}
				if(item<0){
				return true;
				} else if(!(isNaN(item)&& item>0)){
					return false;
				} else {
                for (i=0; i < l; i++)
                 if (str.indexOf(item.charAt(i)) == -1)
                    return false;
				}
               		return true;
  }
// FUNCTION TO VALIDATE DECIMAL-NONZERO-POSITIVE-NUMBER  
  
function ValidDesimalNonZeroPosNum(item)
{				
				if (item == 0)
                 return false;
                var str="1234567890";
                var l = item.length;
				if(!(isNaN(item))){
					var item1=parseInt(item);
					var result=eval(item==item1);
					var temp=eval(item.charAt(l-1)==".");
				if(result && !temp && item>0  ){
					return true;
				}
					if(!(result)&& item>0 ){
						return true;
					}
				}
				if(item<0){
				return false;
				} else{
                for (i=0; i < l; i++)
                 if (str.indexOf(item.charAt(i)) == -1)
                    return false;
				}
               		return true;
  }
  
// FUNCTION TO VALIDATE DECIMAL-NONZERO-NEGATIVENUM
  
    function ValidDesimalNonZeroNegativeNum(item)
            {	if (item == 0)
                 return false;
				 
                var str="1234567890";
                var l = item.length;
				if(!(isNaN(item))){
					var item1=parseInt(item);
					var result=eval(item==item1);
					var temp=eval(item.charAt(l-1)==".");
				if(result && temp && item<0){
						return true;
					}
					if(!(result)&& item<0){
						return true;
					}
				}
				if(item<0){
				return true;
				} else if(!(isNaN(item)&& item>0)){
					return false;
				} else {
                for (i=0; i < l; i++)
                 if (str.indexOf(item.charAt(i)) == -1)
                    return false;
				}
               		return true;
  }
  
// FUNCTION TO VALIDATE DATE USING FORMAT DD/MM/YYYY.
 function ValidDate(item, fieldName) {
	var slash1 = item.indexOf("/",0); 
    var slash2 = item.indexOf("/",slash1+1);
    var l = item.length; 
	if(item.indexOf(" ")!=-1)
	{ 
		return false;
	}
    if ((slash1==1 && slash2==3))
    {
		var month1 = item.substring(0,slash1);
		month1  ="0"+month1;
		var day1 = item.substring(slash1+1,slash2);
		day1="0"+day1;
		var year1 =item.substring(slash2+1,l);
	
     }
	
	 if ((slash1==2 && slash2==4))
	 {
		var month1 = item.substring(0,slash1);
		month1  =month1;
    	
		var day1 = item.substring(slash1+1,slash2);
		day1="0"+day1;
		
		var  year1 =item.substring(slash2+1,l);

	 }

	 if ((slash1==1 && slash2==4))
	 {
		var month1 = item.substring(0,slash1);
		month1  ="0"+month1;
          
		var day1 = item.substring(slash1+1,slash2);
		day1=day1;

		var year1 =item.substring(slash2+1,l);

	 }
	 if ((slash1==2 && slash2==5))
	 {
		var month1 = item.substring(0,slash1);
	
    	var day1 = item.substring(slash1+1,slash2);
	
		var year1 =item.substring(slash2+1,l);

	 }	
	 item = month1+"/"+day1+"/"+year1;

	 var slash1 = item.indexOf("/",0); 
     var slash2 = item.indexOf("/",slash1+1);
     var l = item.length; 
     if(l>10|| l<10)
	    return false;
     if(!(slash1==2 && slash2==5)) {
     	return false;
	 }
	
	 var day = parseInt(item.substring(0,slash1), 10);
				
 	 var month = parseInt(item.substring(slash1+1,slash2), 10);
                
 	 var year1 = item.substring(slash2+1,l);       
	    	
	 var year = parseInt(item.substring(slash2+1,l), 10);
     
	 var date = new Date();
     if ((slash1 == -1)||(slash2 == -1)) return false;
     if (((isNaN(month))||(isNaN(day)))||(isNaN(year))) return false;
     if ((day < 1)||(day > 31)) { 
		 return false;
     }                                             
	 if ((month < 1)||(month > 12)) {
		return false;
     }
	 if (((((month == 4)||(month == 6))||(month == 9))||(month == 11))&&(day >30)){                  
		return false;
	 }
     if (month == 2) {
     	if (((year % 4 == 0)&&(year % 100 != 0))||(year % 400 == 0)) {
        	if (day > 29){
				 return false;
			}
		}
        else
		{
        	if (day > 28)
			{ 
				 return false;
			}
        }     
	 }
	if(fieldName!='0') {                      
		fieldName.value = item;
	}
	return true;	
  }
 


/*
  function ValidDateDDMMYYYY(item){
    	 var slash1 = item.indexOf("/",0); 
         var slash2 = item.indexOf("/",slash1+1);
		
         var l = item.length; 
	       if(item.indexOf(" ")!=-1)
		     { return false;}
		   
		    if(l>10|| l<10)
		    return false;
           if(!(slash1==2 && slash2==5)) {
                      
				       // item.focus()
					  return false;
			 }
				 
		    	 
                 
			
			
			var day = parseInt(item.substring(0,slash1), 10);
						
			var month = parseInt(item.substring(slash1+1,slash2), 10);
                 
			var year1 = item.substring(slash2+1,l);       
	    	
			var year = parseInt(item.substring(slash2+1,l), 10);
             
            
			
			var date = new Date();
              if ((slash1 == -1)||(slash2 == -1)) return false;
                 if (((isNaN(month))||(isNaN(day)))||(isNaN(year))) return false;
                  if ((day < 1)||(day > 31)) { 
				          //item.focus()
							 return false;
                    }                                             
				    if ((month < 1)||(month > 12)) {
				           
								//item.focus();
				             return false;
                    }
		   if (((((month == 4)||(month == 6))||(month == 9))||(month == 11))&&(day >30)){                  
						 //item.focus()
						 return false;
		   }
            if (month == 2) {
                    if (((year % 4 == 0)&&(year % 100 != 0))||(year % 400 == 0)) {
                                if (day > 29){
								   
								     //item.focus()
									 return false;
								}
				    }
                    else{
                         if (day > 28){ 
						      //item.focus()
							  return false;
						 }
                    }     
			}                      
			
		     return true;			
  }
*/

  function ValidDateDDMMYYYY(item)
  {
		var str="/1234567890";
        var len = item.length;
        for (i=0; i < len; i++)
		{
			if (str.indexOf(item.charAt(i)) == -1)
			{
				return false;
			}
		}	   
        

    	 var slash1 = item.indexOf("/",0); 
         var slash2 = item.indexOf("/",slash1+1);
		
         var l = item.length; 
	       if(item.indexOf(" ")!=-1)
		     { return false;}
		   
		    if(l>10|| l<10)
		    return false;
           if(!(slash1==2 && slash2==5)) {
                      
				       // item.focus()
					  return false;
			 }
				 
		    	 
                 
			
			
			var day = parseInt(item.substring(0,slash1), 10);
						
			var month = parseInt(item.substring(slash1+1,slash2), 10);
                 
			var year1 = item.substring(slash2+1,l);       
	    	
			var year = parseInt(item.substring(slash2+1,l), 10);
             
            
			
			var date = new Date();
              if ((slash1 == -1)||(slash2 == -1)) return false;
                 if (((isNaN(month))||(isNaN(day)))||(isNaN(year))) return false;
                  if ((day < 1)||(day > 31)) { 
				          //item.focus()
							 return false;
                    }                                             
				    if ((month < 1)||(month > 12)) {
				           
								//item.focus();
				             return false;
                    }
		   if (((((month == 4)||(month == 6))||(month == 9))||(month == 11))&&(day >30)){                  
						 //item.focus()
						 return false;
		   }
            if (month == 2) {
                    if (((year % 4 == 0)&&(year % 100 != 0))||(year % 400 == 0)) {
                                if (day > 29){
								   
								     //item.focus()
									 return false;
								}
				    }
                    else{
                         if (day > 28){ 
						      //item.focus()
							  return false;
						 }
                    }     
			}                      
			
		     return true;			
  }


// To Data should be greater than From Date
function isDateDiffProper(item1,item2) {
        var frD=item1.value;
        var toD=item2.value;
	var lFD = frD.length, lTD = toD.length;
	var slash1FD = frD.indexOf("/",0), slash1TD = toD.indexOf("/",0); 
	var slash2FD = frD.indexOf("/",slash1FD+1), slash2TD = toD.indexOf("/",slash1TD+1);
	var dayFD = parseInt(frD.substring(0,slash1FD), 10), dayTD = parseInt(toD.substring(0,slash1TD), 10);
	var monthFD = parseInt(frD.substring(slash1FD+1,slash2FD), 10), monthTD = parseInt(toD.substring(slash1TD+1,slash2TD), 10);
	var yearFD = parseInt(frD.substring(slash2FD+1,lFD), 10), yearTD = parseInt(toD.substring(slash2TD+1,lTD), 10);
	var fromDate = new Date(), toDate = new Date();
	fromDate.setYear(yearFD); fromDate.setMonth(monthFD-1); fromDate.setDate(dayFD);
	toDate.setYear(yearTD); toDate.setMonth(monthTD-1); toDate.setDate(dayTD);
	if (fromDate.getTime() > toDate.getTime()) return false;
	return true;
}

function isDateDiffProper1(item1,item2) {
        var frD=item1;
        var toD=item2;
	var lFD = frD.length, lTD = toD.length;
	var slash1FD = frD.indexOf("/",0), slash1TD = toD.indexOf("/",0); 
	var slash2FD = frD.indexOf("/",slash1FD+1), slash2TD = toD.indexOf("/",slash1TD+1);
	var dayFD = parseInt(frD.substring(0,slash1FD), 10), dayTD = parseInt(toD.substring(0,slash1TD), 10);
	var monthFD = parseInt(frD.substring(slash1FD+1,slash2FD), 10), monthTD = parseInt(toD.substring(slash1TD+1,slash2TD), 10);
	var yearFD = parseInt(frD.substring(slash2FD+1,lFD), 10), yearTD = parseInt(toD.substring(slash2TD+1,lTD), 10);
	var fromDate = new Date(), toDate = new Date();
	fromDate.setYear(yearFD); fromDate.setMonth(monthFD-1); fromDate.setDate(dayFD);
	toDate.setYear(yearTD); toDate.setMonth(monthTD-1); toDate.setDate(dayTD);
	if (fromDate.getTime() > toDate.getTime()) return false;
	return true;
}

 // FUNCTION TO VALIDATE DATE USING FORMAT MM/DD/YYYY.
 
 function ValidDateMMDDYYYY(item)	{
       
	  if(item.indexOf(" ")!=-1)
		     { return false;}

	 var slash1 = item.indexOf("/",0); 
     var slash2 = item.indexOf("/",slash1+1);
     var l = item.length; 
        if(l>10|| l<10)
		  return false;
	
	    if (!(slash1==2 && slash2==5)) {
	       
            //item.focus()
			 return false;
		}
			var month1 = item.substring(0,slash1);
            
		  var day1 = item.substring(slash1+1,slash2);
            
		  var year1 =item.substring(slash2+1,l);
		  
          var month = parseInt(item.substring(0,slash1), 10);
            
		  var day = parseInt(item.substring(slash1+1,slash2), 10);
            
		  var year = parseInt(item.substring(slash2+1,l), 10);
            
		  var date = new Date();
		   if(day1.charAt(0)==" " || day1.charAt(1)==" ")
		     return false;     
				 
 if(month1.charAt(0)==" " || month1.charAt(1)==" ")
			     return false; 
if(year1.charAt(0)==" " || year1.charAt(1)==" "||year1.charAt(2)==" "||year1.charAt(3)==" ")
			     return false;
          if ((slash1 == -1)||(slash2 == -1)) return false;
                if (((isNaN(month))||(isNaN(day)))||(isNaN(year))) return false;
                if ((day < 1)||(day > 31)) {
				    
					   //item.focus()
					   return false;
			    }
                if ((month < 1)||(month > 12)){
				
				  //item.focus()
				  return false;
				 } 
                if (((((month == 4)||(month == 6))||(month == 9))||(month == 11))&&(day > 30)){
                       
						 //item.focus()
						 return false;
			    }
				if (month == 2) {
                      if (((year % 4 == 0)&&(year % 100 != 0))||(year % 400 == 0)){
                            if (day > 29){
							   
								 //item.focus()
								 return false;
							}
					  }
                      else{
                            if (day > 28) {
								
								 //item.focus()
								 return false;
						    }
		   		      }
                 }
	           
			return true;			
   }	

  // FUNCTION TO VALIDATE DATE USING FORMAT YYYY/MM/DD
  
    function ValidDateYYYYMMDD(item){
       
    	  if(item.indexOf(" ")!=-1)
	     	{ return false;}
 
	 var slash1 = item.indexOf("/",0); 
     var slash2 = item.indexOf("/",slash1+1);
     var l = item.length; 
        if(l>10|| l<10)
		  return false;
		  if(!(slash1==4 && slash2==7)){
				
				 //item.focus()
				 return false;
		  }
		  var month1 = item.substring(0,slash1);
            
		  var day1 = item.substring(slash1+1,slash2);
            
		  var year1 =item.substring(slash2+1,l);
		  
          var year = parseInt(item.substring(0,slash1), 10);
                
		  var month = parseInt(item.substring(slash1+1,slash2), 10);
                
		  var day = parseInt(item.substring(slash2+1,l), 10);
                
		  var date = new Date();
		   if(day1.charAt(0)==" " || day1.charAt(1)==" ")
		     return false;     
				 
 if(month1.charAt(0)==" " || month1.charAt(1)==" ")
			     return false; 
 if(year1.charAt(0)==" " || year1.charAt(1)==" "||year1.charAt(2)==" "||year1.charAt(3)==" ")
			     return false;
          if ((slash1 == -1)||(slash2 == -1)) return false;
             if (((isNaN(month))||(isNaN(day)))||(isNaN(year))) return false;
                 if ((day < 1)||(day > 31)) {
				       
					   //item.focus()
					   return false;
			     }
                if ((month < 1)||(month > 12)){
				     
				      //item.focus()
				      return false;
				} 
                if (((((month == 4)||(month == 6))||(month == 9))||(month == 11))&&(day > 30)){ 
                        
						 //item.focus()
						 return false;
				}
				if (month == 2) {
                     if (((year % 4 == 0)&&(year % 100 != 0))||(year % 400 == 0)){
                           if (day > 29){
							
									 //item.focus()
									 return false;
						   }
					 }
                    else{
                         if (day > 28){ 
							
							  //item.focus()
							  return false;
					     }
		   		    }
                }
				
			    return true;			
 }	
 
 ////FUNCTION TO VALIDATE FORM SUBMITTED OR NOT
  
function formValidate() { 
    errfound = false;
    if ((document.formName.formElement.value=="")||(!ValidNum(document.formName.formElement.value)))
       error(document.formName.formElement,"Enter No");
   return !errfound;
}

//FUNCTION TO VALIDATE STRING

function isFilled(item) 
    {
	if ((item.value==null)||(item.value==""))
	{
		return false;
	}
	else
	{
		var filled = false;
		var i = 0;
		for (i = 0; i < item.value.length; i++)
		{
			if (item.value.charAt(i) != " ")
			{
				filled = true;
			}
		}
		return filled;
	}		
}
//FUNCTION TO VALIDATE E-MAIL ADDRESS

function isEmailValid(item) 
{
	var l = item.value.length;
	var at = item.value.indexOf("@");
	var dot = item.value.indexOf(".",at+1);
	if (((at < 1)||(dot <= at+1))||(dot == l-1)) 
		return false;
	return true;
}
//FUNCTION TO VALIDATE SINGLEQUOTE WITH TWO SINGLEQUOTES.

function ValidQuotedText(item)
     {          
	         var c=""
      		    for(i=0; i<item.length; i++)
                  { 
				     var p=item.charAt(i);     
        	  	         if(p=='\'' ){   
						     p =p+ "\'"
						     c+=p; 
                           }
						 else{   
						         if(c!=""){ 
								  		       c+=p; 
				                 }
							     else{			  
						             c=item.charAt(0);     
				  		         }      
				         }
				  }
				item=c;
				alert(item);
				return true;
     }
	 
	 function ValidEmail(item) {
       
           var count=0;
     var j="";
     var c="";
     while(item.indexOf('@') != -1){
              if (item.indexOf ('@', 0) == -1)
       {
  
    return false;
       }
    else{  
       j = eval(item.indexOf('@'));  
       c = item.substring(eval(j+1),eval(item.length));
       item = c;
       count++;
       }
   }
      if(count>1){
          return false;
      } else{
        
           return true;
		}
     }

// Function to check that at least one check box should be checked for modification or deletion

	function validateChkBox()
	{
		var i=0;
		var flag=0;
		if(document.fnm.checkbox.length) {
			var chkBoxOnScreen=parseInt(document.fnm.checkbox.length);
    		while(i<chkBoxOnScreen){
				if(eval("document.fnm.checkbox["+i+"].checked")){
				   flag=1;
				}
				i++;
			}
		}
		else{
   	 		if(eval("document.fnm.checkbox.checked"))
				flag=1;
 		}
		if( eval(flag==1)){
				return true;
		}
		else{
				alert("At least one check box  to be checked for Modification/Deletion");
				return false;
		}
	}

function isValidString(item)
{
	var str="'";
	var l = item.value.length;
	var i;
	if (l==0)
	{
		return false;
	}
	for (i=0; i < l; i++)
	{
		if (str.indexOf(item.value.charAt(i)) != -1)
		{
			return false;
		}
	}
	return true;
}

function isValidEnch(item)
{
	var str="\"";
	var l = item.value.length;
	if (l==0)
	{
		return true;
	}
	for (i=0; i < l; i++)
	{
		if (str.indexOf(item.value.charAt(i)) != -1)
		{
			return false;
		}
	}
	return true;
}

function isValidKeyCut(item)
{
	var str="123";
	var l = item.value.length;
	if (l==0)
	{
		return false;
	}
	for (i=0; i < l; i++)
	{
		if (str.indexOf(item.value.charAt(i)) == -1)
		{
			return false;
		}
	}
	return true;
}

function isValidStringNoComma(item)
{
	var str=",";
	var l = item.value.length;
	if (l==0)
	{
		return false;
	}
	for (i=0; i < l; i++)
	{
		if (str.indexOf(item.value.charAt(i)) != -1)
		{
			return false;
		}
	}
	return true;
}

//Function To validate Space
function chkSpace(valnum)
{
	var strlen = valnum.length;
	var i;
	for (i=0;i<strlen;++i){
		if(valnum.charCodeAt(i)!=32 && valnum.charCodeAt(i)!=10 && valnum.charCodeAt(i)!=13){
			return true;
	    } 
	} 
    return false; 
}

//FUNCTION TO VALIDATE MULTIPLE E-MAIL ADDRESSES 
function multiEmail(item)
{
  var email_array =item.value.split(';');
  for (var i = 0; i < email_array.length; i++) 
  {
	var temp_email=email_array[i];
	if (isEmailValid1(temp_email)==false) 
	{	
		return false;	
	}
  }
  return true;
}

// This Function is Used in multiEmail function
function isEmailValid1(item) 
{
	re = /^[a-zA-Z][a-zA-Z]*[a-zA-Z0-9](@)[a-zA-Z]+[\.](com)$/;
	myArray = item.match(re);
	if (myArray == null)
	{
	  return false;
	}
	else
	{
	  return true;
	}
}

function formatNumber(a,b,c){

	if(a.indexOf(".")==-1) { // if input is an Integer
		a+=".0";
	}

	var preDigitPad=0;
	var prePadStr="";
	var postPadStr="";
	var postDigitPad=c;
	var padZero=false;
	var strT1="";
	var strT2="";
	if (b.indexOf("0") == 0){
			padZero=true;
			preDigitPad=parseInt(b);
	}
	multiplier=Math.pow(10,(parseInt(c)+1));
	t1=parseInt(a*multiplier);
	strT1=t1+"";

	if(strT1=="0"){ // special case of input being 0 or 0.0, etc.
		for(ijkl=0;ijkl<parseInt(c);ijkl++) {
			strT1+="0";
		}
	}

	lastDigit=strT1.substring(strT1.length-1);
	if(parseInt(lastDigit)>5){
		t2=parseInt(t1/10)+1;
		t3=parseFloat(t2/parseFloat(Math.pow(10,parseInt(c))));
		strT3=t3+"";
		if(strT3.indexOf(".") == "-1"){
			if(padZero){
				if (strT3.length < preDigitPad){
					for (jk=0;jk<(preDigitPad-strT3.length);jk++){
						prePadStr=prePadStr+"0"
					}
					preDotDigit=prePadStr+strT3;
					for (jk=0;jk<postDigitPad;jk++){
						postPadStr=postPadStr+"0";
					}
					strToReturn=preDotDigit+"."+postPadStr;
//						alert(strToReturn);
					return strToReturn;
				}else{
					for (jk=0;jk<postDigitPad;jk++){
						postPadStr=postPadStr+"0";
					}
					strToReturn=strT3+"."+postPadStr;
//						alert(strToReturn);
					return strToReturn;
				}
			}else{
					for (jk=0;jk<postDigitPad;jk++){
						postPadStr=postPadStr+"0";
					}
					strToReturn=strT3+"."+postPadStr;
//						alert(strToReturn);
					return strToReturn;
			}
		}else{
			if (parseInt(strT3.length-(strT3.indexOf(".")+1))>c){
				postPadStr=strT3.substring((strT3.indexOf(".")+1),(strT3.indexOf(".")+2));
			}else{
				for (jk=0;jk<(c-parseInt(strT3.length-(strT3.indexOf(".")+1)));jk++){
					postPadStr=postPadStr+"0";
				}
				postPadStr=strT3.substring(strT3.indexOf(".")+1,strT3.length)+postPadStr;
			}
			if(padZero){
				if (strT3.substring(0,strT3.indexOf(".")).length < preDigitPad){
					for (jk=0;jk<(preDigitPad-strT3.substring(0,strT3.indexOf(".")).length);jk++){
						prePadStr=prePadStr+"0"
					}
					preDotDigit=prePadStr+strT3.substring(0,strT3.indexOf("."));
					strToReturn=preDotDigit+"."+postPadStr;
//						alert(strToReturn);
					return strToReturn;
				}else{
					strToReturn=strT3.substring(0,strT3.indexOf("."))+"."+postPadStr;
//						alert(strToReturn);
					return strToReturn;
				}
			}else{
					strToReturn=strT3.substring(0,strT3.indexOf("."))+"."+postPadStr;
//						alert(strToReturn);
					return strToReturn;
			}
		}
	}else{ // < 5 (no overrounding reqd)
		if (padZero){
			strT2=a.substring(0,a.indexOf(".")+1+parseInt(c));
			if (strT2.indexOf(".") < preDigitPad){
				for (jk=0;jk<(preDigitPad-strT2.indexOf("."));jk++){
					prePadStr=prePadStr+"0";
				}
			}else{
				prePadStr="";
			}			
			if (a>1){
				strToReturn=prePadStr+a.substring(0,a.indexOf("."))+"."+strT1.substring(a.indexOf("."),strT1.length-1);
			}else{
				strToReturn=prePadStr+a.substring(0,a.indexOf("."))+"."+strT1.substring(0,strT1.length-1);
			}
			return strToReturn;
		}else{
			if (a>=1){
				strToReturn=a.substring(0,a.indexOf("."))+"."+strT1.substring(a.indexOf("."),strT1.length-1);
			}else{
				strToReturn=a.substring(0,a.indexOf("."))+"."+strT1.substring(0,strT1.length-1);
			}
			return strToReturn;
		}
	}
}

function callPopAttach(table,key,keyValue){
	NewWin999= window.open("PopAttachment.jsp?tableName="+table+"&key="+key+"&keyValue="+keyValue,"NewWin999","toolbar=no,scrollbars=yes,width=475,height=390");
	NewWin999.focus();
}

function getChangedDate(convDate,factor){
		var DueDate=convDate;
		var firstConcat = "";
		var zeroConcat = "";
		if (DueDate != ""){
			a = DueDate.indexOf("/");
			dd = DueDate.substring(0,a);
			rest = DueDate.substring(a+1);
			a = rest.indexOf("/");
			mm = rest.substring(0,a);
			rest = rest.substring(a+1);
			day = parseInt(dd,10);
			month = parseInt(mm,10);
			year = parseInt(rest,10);
			var cal = new Date();
			var newCal = new Date();
			cal.setYear(year);
			cal.setMonth(month-1);
			cal.setDate(day);
			msPerDay = 24 * 60 * 60 * 1000 ;
			var newTimeInMillis = cal.getTime() - factor*msPerDay;
			newCal.setTime(newTimeInMillis);
			if ((newCal.getMonth()+1) < 10){ //take care of making it 12/8/2003 to 12/08/2003.
				firstConcat = "/0";
			}else{
				firstConcat = "/";	
			}
			if (newCal.getDate() < 10){ //take care of making it 12/8/2003 to 12/08/2003.
				zeroConcat = "0";
			}else{
				zeroConcat = "";	
			}
			var toReturn= zeroConcat+newCal.getDate()+firstConcat+(newCal.getMonth()+1)+"/"+newCal.getFullYear();
			return toReturn;
		}else{
			return convDate;
		}
	}

//Complete Email Validations
function isValidEmail(item)
{
	var len = item.length;
	var at = item.indexOf("@");
	var dot = item.indexOf(".",at+1);
	var str = "qwertyiuposadfghjklxzcvbmnQEWRTYUOIPLKJHGFDSAMNBVCXZ1234567890._";

	//To check if last character is a dot
	if ( item.charAt(len-1) == "." )
	{
		alert("Last character of Email ID Cannot be a dot");
		return false;
	}

	//To check if @ exists, dot exists, and dot exists after @
	if ( ( (at < 1) || (dot <= at+1) ) || (dot == len-1) )
	{
		alert("Enter Valid Email ID");
		return false;
	}

	for (i = 0 ; i < at ; i++ )
	{
		//Characters before @ are valid
		if ( str.indexOf(item.charAt(i)) == -1 )
		{
			alert("The character no "+(i+1)+" is not accepted in Email ID");
			return false;
		}
	}
	for (i = at+1 ; i < dot ; i++ )
	{
		//Characters after @ are valid
		if ( str.indexOf(item.charAt(i)) == -1 )
		{
			alert("The character no "+(i+1)+" is not accepted in Email ID");
			return false;
		}
	}	 
	for (i = dot+1 ; i < len ; i++ )
	{
		//Characters after . are valid
		if ( str.indexOf(item.charAt(i)) == -1 )
		{
			alert("The character no "+(i+1)+" is not accepted in Email ID");
			return false;
		}
	}	 
	return true;
}

// Function to validate file name
function ValidFileName(item)
{
 var str="\\:qwertyiuposadfghjklxzcvbmnQEWRTYUOIPLKJHGFDSAMNBVCXZ1234567890-_ .";
                var l = item.length;
/*			if( item.indexOf(' ') == 0 ) {
			       	return false;
			}*/
/*			else if(item.indexOf(' ') == l-1||eval(item.charAt(l-1))==' '){
			       	return false;			
			}
*/
                  for (i=0; i < l; i++){
                     if (str.indexOf(item.charAt(i)) == -1){
					 //alert(item.charAt(i))
                       return false;
					 }
				  }	   
                return true;
}

// Function to find difference between two dates in days. Date should be in dd/mm/yyyy form.
function dateDiffInDays(date1, date2) 
{
	var oneMinute = 60 * 1000;
	var oneHour = oneMinute * 60;
	var oneDay = oneHour * 24;
	var dateTo = new Date();
	var dateFrom = new Date();
	dateFrom.setYear(date1.substring(6,10));
	dateFrom.setMonth(parseInt(date1.substring(3,5),10)-1);
	dateFrom.setDate(date1.substring(0,2));

	dateTo.setYear(date2.substring(6,10));
	dateTo.setMonth(parseInt(date2.substring(3,5),10)-1);
	dateTo.setDate(date2.substring(0,2));

	var diff = dateTo.getTime() - dateFrom.getTime();
	diff = Math.floor(diff/oneDay);
	return diff;
}

function ValidMobileNo(item) {
    var regex = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
    if(!regex.test(item)){
    	return false;
    }
    return true;
 
}

function isEmailValid(item) {
var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(!item.match(regex)){
		return false;
	}
	return true;
}


function strongValidPassword(item){
	//Input Password : 8 to 15 characters which contain at least one lower-case letter
	//, one upper-case letter, one numeric digit, and one special character
	var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
	if(!item.match(regex)){
		return false;
	}
	return true;
}