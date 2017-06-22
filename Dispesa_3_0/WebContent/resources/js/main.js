function popUp(URL) {

	var width = 200;

	var height = 300;
	var left = 99;
	var top = 150;

	window
			.open(
					URL,
					'janela',
					'width='
							+ width
							+ ', height='
							+ height
							+ ', top='
							+ top
							+ ', left='
							+ left
							+ ', scrollbars=yes, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');

}

function showStatusPagamento() {
	statusDialogPagamento.show();
}
function showStatusInvestimento() {
	statusDialogInvestimento.show();
}
function showStatusPoupanca() {
	statusDialogPoupanca.show();
}

function showStatus() {
	statusDialog.show();
}
function hideStatus() {
	statusDialog.hide();
}

function reload() {

	window.opener.document.location.reload();

}

$(document).ready(function(){
	

	
	$('.numero').mask('0#', {maxlength: false});
	//$(".moeda").maskMoney();
	$(".moeda").maskMoney({prefix:'R$ ', allowNegative: true, thousands:'', decimal:'.', affixesStay: false});
});



	
	

