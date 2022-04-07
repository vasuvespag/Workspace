function myfunction()
{
if (document.MunchForm.cname.value == "") {alert("Please Enter The Customer Name");}
	else if (document.MunchForm.add.value == "") {alert("Please Enter Delivery Details");}
	else if (document.MunchForm.no.value == ""){alert("Please Enter the Contact Details");}
else{
var myWindow = window.open("", "_blank", "");
    myWindow.document.write("<h1>Registration successful</h1>");
	
}


	}