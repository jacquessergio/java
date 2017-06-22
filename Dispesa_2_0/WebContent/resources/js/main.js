function popUp(URL){
	
		  var width = 200;
		  
		  var height = 300;
		  var left = 99;
		  var top = 150;
		 
		  window.open(URL,'janela', 'width='+width+', height='+height+', top='+top+', left='+left+', scrollbars=yes, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
		
			
}

function reload(){
	
	window.opener.document.location.reload();
	
}