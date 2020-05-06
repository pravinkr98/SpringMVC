function validate(frm){
	alert("Intruption...")
	//empty error messages
	document.getElementById("patNameErr").innerHTML="";
	document.getElementById("patAddErr").innerHTML="";
	document.getElementById("ageErr").innerHTML="";
	document.getElementById("hospitalErr").innerHTML="";
	
	//read form data
	let name=frm.patName.value;
	let add=frm.patAdd.value;
	let page=frm.age.value;
	let hsptl=frm.hospital.value;
	let flag=false;
	
	//client side form validations
	if(name==""){
		document.getElementById("patNameErr").innerHTML="<b>person name is mandatory</b>";
		frm.patName.focus();
		flag=true;
	}
	
	if(add==""){
		document.getElementById("patAddErr").innerHTML="<b>person address is mandatory</b>";
		frm.patAdd.focus();
		flag=true;
	}
	
	if(page==""){
		document.getElementById("ageErr").innerHTML="<b>person age is mandatory</b>";
		frm.age.focus();
		flag=true;
	}
	else if(isNaN(page)){
		document.getElementById("ageErr").innerHTML="<b>person age must be numeric</b>";
		frm.age.focus();
		flag=true;
	}
	else if(page<1 || page>100){
		document.getElementById("ageErr").innerHTML="<b>person age must be ther between 1 through 100</b>";
		frm.age.focus();
		flag=true;
	}
	
	if(hsptl==""){
		document.getElementById("hospitalErr").innerHTML="<b>hospital name is mandatory</b>";
		frm.hospital.focus();
		flag=true;
	}
	else if(hsptl.length<3 || hsptl.length>15){
		document.getElementById("hospitalErr").innerHTML="<b>hospital name must have min 3 chars and max of 15 chars</b>";
		frm.hospital.focus();
		flag=true;
	}
	
	//set vflag value to "yes" 
	frm.vflag.value="yes";
	
	
	if(flag)
		return false;
	else
		return true;
	
}