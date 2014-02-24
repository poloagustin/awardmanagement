	var serverUrl = null;

	$(document).ready(function() {
		initUtils();	
		setDateTexbox();
	});

	function initUtils() {
		serverUrl = $("#serverUrl").val();
	}

	function setDateTexbox(){			
	$('.datetimepickerFrom').datetimepicker({        
        pickTime: false, 
        weekStart: 1,        				
		startView: 2,
		minView: 2,
		forceParse: 1,
		todayHighlight:true,
		autoclose:true,
		todayBtn:true,
		endDate:new Date()		
    });
		$('.datetimepickerTo').datetimepicker({        
        pickTime: false, 
        weekStart: 1,        				
		startView: 2,
		minView: 2,
		forceParse: 1,
		todayHighlight:true,
		autoclose:true,
		todayBtn:true,
		endDate:new Date()		
    });

	}



