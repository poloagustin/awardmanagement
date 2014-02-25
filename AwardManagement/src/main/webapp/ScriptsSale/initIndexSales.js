	var serverUrl = null;

	$(document).ready(function() {
		initUtils();	
		setDateTexbox();
		
		$("#selectTime").change(function(){			
		 var selectTime = $("#selectTime").val();
		 var date = new Date();

		 switch(selectTime){
		 	case "1": 	
		 		var firstDay = date;
				var lastDay = date;
		 		break;
		 	case "2": 	
		 		var firstDay = new Date(date.getFullYear(), date.getMonth(), date.getDate()-1);
				var lastDay = new Date(date.getFullYear(), date.getMonth(), date.getDate());
		 		break;

		 	case "3": 	
		 		var firstDay = new Date(date.setDate(date.getDate() - date.getDay()));
				var lastDay = new Date(date.setDate(date.getDate() - date.getDay() + 6));
		 		break;
			
			case "4": 	
		 		var firstDay = new Date(date.setDate(date.getDate() - date.getDay() - 6));
				var lastDay = new Date(date.setDate(date.getDate() - date.getDay() + 6));
		 		break;
		 	
		 	case "5": 	
				var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
				var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
				break;

			case "6": 	
				var firstDay = new Date(date.getFullYear(), date.getMonth()- 1, 1);
				var lastDay = new Date(date.getFullYear(), date.getMonth() , 0);
				break;

		 	case "7": 	
		 		var firstDay = new Date(date.getFullYear(),0,1);
				var lastDay = new Date(date.getFullYear(),12, 0);
		 		break;

		 }
		 //Set input date
		 $('.datetimepickerFrom').datetimepicker('update', firstDay);
		 $('.datetimepickerTo').datetimepicker('update', lastDay);			
		});

		//tag select => Custom
		$('.datetimepickerFrom').datetimepicker().on('changeDate',function(ev){
			$('#selectTime option[value=8]').attr('selected', 'selected');			
		});
		$('.datetimepickerTo').datetimepicker().on('changeDate',function(ev){
			$('#selectTime option[value=8]').attr('selected', 'selected');			
		});
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

        $('.datetimepickerFrom').datetimepicker('update',new Date());
        $('.datetimepickerTo').datetimepicker('update',new Date());
	}

	$(document).on('click','#schSale',function(){				
		
});