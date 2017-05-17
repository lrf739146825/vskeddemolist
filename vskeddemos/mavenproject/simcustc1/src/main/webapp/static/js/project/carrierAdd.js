
$(function(){
    $.parser.parse();//重新加载样式
    $('#carrierName').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var carrierName=$('#carrierName').val();
	var carrierNick=$('#carrierNick').val();
	var carrierShortName=$('#carrierShortName').val();
	var officialWebSite=$('#officialWebSite').val();
	var hotline=$('#hotline').val();
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		carrierName: carrierName,
		carrierNick:carrierNick,
		carrierShortName:carrierShortName,
		officialWebSite:officialWebSite,
		hotline:hotline
		
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	}
		    );
}