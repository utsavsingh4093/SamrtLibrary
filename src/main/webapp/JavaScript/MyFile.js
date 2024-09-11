function datavalue(){
	let bookquantity = document.getElementById('getvalue').value;
		let first=parseInt(bookquantity);
		
		
	let bookvalue=document.getElementById('bookvalue').value;
	let second=parseInt(bookvalue);
	let submit=document.getElementById('hidingbutton');
	
	if (second <= 0) {
	    document.getElementById('geting').innerHTML = '<label style="color:red;" for="booksquantity">Your Quantity is too small</label>';
	    submit.style.display = 'none';
	} 
	else if (first < second) {
	    document.getElementById('geting').innerHTML = '<label style="color:red;" for="booksquantity">Your Quantity is greater than the book Quantity</label>';
	    submit.style.display = 'none';
	} 
	else {
	    document.getElementById('geting').innerHTML = '<label style="color:black;" for="booksquantity">How Many Book Quantity You want</label>';
	    submit.style.display = 'block';
	}	
}

function fetchData(){
	let bookQuantity=document.getElementById('quantityy').value;
	let fetchQuantity=parseInt(bookQuantity);
	console.log(fetchQuantity);
	let submit=document.getElementById('hidingbutton')
	if(fetchQuantity<=0)
		{
			document.getElementById('message').innerHTML='<label style="color:red;" id="message" for="quantity">Your Quantity is to Small</label>';
			submit.style.display = 'none';
		}
		else{
			document.getElementById('message').innerHTML='<label id="message" for="quantity">Quantity</label>';
			submit.style.display='block';
		}
}
