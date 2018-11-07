/*Dashboard4 Init*/
 
"use strict"; 

/*****Load function start*****/
$(window).load(function(){
	window.setTimeout(function(){
		$.toast({
			heading: 'Welcome to kenny',
			text: 'Use the predefined ones, or specify a custom position object.',
			position: 'top-right',
			loaderBg:'#ea65a2',
			icon: 'success',
			hideAfter: 3000, 
			stack: 6
		});
	}, 3000);
});
/*****Load function* end*****/

 var sparklineLogin = function() { 
	if( $('#sparkline_1').length > 0 ){
		$("#sparkline_1").sparkline([2,4,4,6,8,5,6,4,8,6,6,2 ], {
			type: 'line',
			width: '100%',
			height: '45',
			lineColor: '#566FC9',
			fillColor: '#566FC9',
			maxSpotColor: '#566FC9',
			highlightLineColor: 'rgba(0, 0, 0, 0.2)',
			highlightSpotColor: '#566FC9'
		});
	}	
	if( $('#sparkline_2').length > 0 ){
		$("#sparkline_2").sparkline([0,2,8,6,8], {
			type: 'bar',
			width: '100%',
			height: '45',
			barWidth: '10',
			resize: true,
			barSpacing: '10',
			barColor: '#3cb878',
			highlightSpotColor: '#3cb878'
		});
	}	
	if( $('#sparkline_6').length > 0 ){
		$("#sparkline_6").sparkline([0, 23, 43, 35, 44, 45, 56, 37, 40, 45, 56, 7, 10], {
			type: 'line',
			width: '100%',
			height: '45',
			lineColor: '#fcb03b',
			fillColor: 'transparent',
			spotColor: '#fff',
			minSpotColor: undefined,
			maxSpotColor: undefined,
			highlightSpotColor: undefined,
			highlightLineColor: undefined
		});
	}
	if( $('#sparkline_7').length > 0 ){
		$('#sparkline_7').sparkline([15, 23, 55, 35, 54, 45, 66, 47, 30], {
			type: 'line',
			width: '100%',
			height: '45',
			chartRangeMax: 50,
			resize: true,
			lineColor: 'rgba(234,101,162, 0.6)',
			fillColor: 'rgba(234,101,162, 0.6)',
			highlightLineColor: 'rgba(0,0,0,0)',
			highlightSpotColor: 'rgba(0,0,0,0)',
		});
		$('#sparkline_7').sparkline([0, 13, 10, 14, 15, 10, 18, 20, 0], {
			type: 'line',
			width: '100%',
			height: '45',
			chartRangeMax: 40,
			lineColor: 'rgba(252,176,59, 0.6)',
			fillColor: 'rgba(252,176,59, 0.6)',
			composite: true,
			resize: true,
			highlightLineColor: 'rgba(0,0,0,0)',
			highlightSpotColor: 'rgba(0,0,0,0)',
		});
	}	
}
var sparkResize;

$(window).resize(function(e) {
	clearTimeout(sparkResize);
	sparkResize = setTimeout(sparklineLogin, 200);
});
sparklineLogin();
