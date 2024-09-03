function datavalue(){
	let bookquantity = document.getElementById('getvalue').value;
		let first=parseInt(bookquantity)
		
		
	let bookvalue=document.getElementById('bookvalue').value;
	let second=parseInt(bookvalue);
	let dpbtn=document.getElementById('hidingbutton')
	
	if (second <= 0) {
	    document.getElementById('geting').innerHTML = '<label style="color:red;" for="booksquantity">Your Quantity is too small</label>';
	    dpbtn.style.display = 'none';
	} 
	else if (first < second) {
	    document.getElementById('geting').innerHTML = '<label style="color:red;" for="booksquantity">Your Quantity is greater than the book Quantity</label>';
	    dpbtn.style.display = 'none';
	} 
	else {
	    document.getElementById('geting').innerHTML = '<label style="color:black;" for="booksquantity">How Many Book Quantity You want</label>';
	    dpbtn.style.display = 'block';
	}

	

	
	
}