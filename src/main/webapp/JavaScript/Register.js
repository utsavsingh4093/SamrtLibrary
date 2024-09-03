function emailcheker()
{
    const emai = document.getElementById('email').value;
	if(emai!=""){
    const emailRegex =  /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,3}$/;;
    if(!emai.match(emailRegex))
    {
       document.getElementById('error').innerHTML=`<label style="color: red;" id="error" for="uname"><b>Wrong Email : </b></label>`;
        return false;
    }else{
        document.getElementById('error').innerHTML=`<span style="color: black;" id="error" for="uname"><b>Enter a Email : </b></span>`;
        return true;
    }
	}	else{
	        document.getElementById('error').innerHTML=`<label style="color: black;" id="error" for="uname"><b>Enter a Email : </b></label>`;
	        return true;
	    }
}

function passwordValidation()
{
    const password=document.getElementById('password').value;
    //const errorSpan = document.getElementById('errorpass');
    const specialSymbolRegex = /[!@#$%^&*(),.?":{}|<>]/;
    if(password!=""){
    if(password.length >= 8 && specialSymbolRegex.test(password)){
        document.getElementById('errorpass').innerHTML=`<span id="errorpass" class="details">Password</span>`;
    }
    else {
        document.getElementById('errorpass').innerHTML=`<span style="color:red" id="errorpass" class="details"> PassWord at least 8 characters with special symbol</span>`;
    }
}
else{
    document.getElementById('errorpass').innerHTML=`<span id="errorpass" class="details">Password</span>`;
    return true;
}
}