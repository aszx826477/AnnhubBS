/*Dashboard2 Init*/
"use strict"; 

/*****Ready function start*****/
$(document).ready(function(){
	if( $('#chart_2').length > 0 ){
		var ctx2 = document.getElementById("chart_2").getContext("2d");
		var data2 = {
			labels: ["威胁类别1", "威胁类别2", "威胁类别3", "威胁类别4", "威胁类别5", "威胁类别6", "威胁类别7"],
			datasets: [
				{
					label: "低危",
					backgroundColor: "rgba(60,184,120,.8)",
					borderColor: "rgba(60,184,120,.8)",
					data: [10, 30, 80, 61, 26, 75, 40]
				},
				{
					label: "高危",
					backgroundColor: "rgba(252,176,59,.8)",
					borderColor: "rgba(252,176,59,.8)",
					data: [28, 48, 40, 19, 86, 27, 90]
				}
			]
		};
		
		var hBar = new Chart(ctx2, {
			type:"horizontalBar",
			data:data2,
			
			options: {
				tooltips: {
					mode:"label"
				},
				scales: {
					yAxes: [{
						stacked: true,
						gridLines: {
							color: "#eee",
						},
						ticks: {
							fontFamily: "Varela Round",
							fontColor:"#2f2c2c"
						}
					}],
					xAxes: [{
						stacked: true,
						gridLines: {
							color: "#eee",
						},
						ticks: {
							fontFamily: "Varela Round",
							fontColor:"#2f2c2c"
						}
					}],
					
				},
				elements:{
					point: {
						hitRadius:40
					}
				},
				animation: {
					duration:	3000
				},
				responsive: true,
				maintainAspectRatio:false,
				legend: {
					display: false,
				},
				tooltips: {
					backgroundColor:'rgba(47,44,44,.9)',
					cornerRadius:0,
					footerFontFamily:"'Varela Round'"
				}
				
			}
		});
	}
	if( $('#chart_3').length > 0 ){
		var ctx3 = document.getElementById("chart_3").getContext("2d");
		var data3 = {
			labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
			datasets: [
				{
					label: "My First dataset",
					backgroundColor: "rgba(252,176,59,0.8)",
					borderColor: "rgba(252,176,59,0.8)",
					pointBackgroundColor: "rgba(252,176,59,1)",
					pointBorderColor: "#fff",
					pointHoverBackgroundColor: "#fff",
					pointHoverBorderColor: "rgba(252,176,59,1)",
					data: [65, 59, 90, 81, 56, 55, 40]
				},
				{
					label: "My Second dataset",
					backgroundColor: "rgba(86,111,201,0.8)",
					borderColor: "rgba(86,111,201,0.8)",
					pointBackgroundColor: "rgba(86,111,201,1)",
					pointBorderColor: "#fff",
					pointHoverBackgroundColor: "#fff",
					pointHoverBorderColor: "rgba(86,111,201,1)",
					data: [28, 48, 40, 19, 96, 27, 100]
				}
			]
		};
		var radarChart = new Chart(ctx3, {
			type: "radar",
			data: data3,
			options: {
					scale: {
						ticks: {
							beginAtZero: true,
							fontFamily: "Varela Round",
							
						},
						gridLines: {
							color: "#eee",
						},
						pointLabels:{
							fontFamily: "Varela Round",
							fontColor:"#2f2c2c"
						},
					},
					
					animation: {
						duration:	3000
					},
					responsive: true,
					maintainAspectRatio:false,
					legend: {
							labels: {
							fontFamily: "Varela Round",
							fontColor:"#2f2c2c"
							}
						},
						tooltips: {
						backgroundColor:'rgba(47,44,44,.9)',
						cornerRadius:0,
						footerFontFamily:"'Varela Round'"
					}
			}
		});
	}
	if( $('#world_map_marker_1').length > 0 ){
		$('#world_map_marker_1').vectorMap(
		{
			map: 'world_mill_en',
			backgroundColor: '#fff',
			borderColor: '#fff',
			borderOpacity: 0.25,
			borderWidth: 0,
			color: '#e6e6e6',
			regionStyle : {
				initial : {
				  fill : 'rgba(86,111,201,.4)'
				}
			  },

			markerStyle: {
			  initial: {
							r: 10,
							'fill': '#fff',
							'fill-opacity':1,
							'stroke': '#000',
							'stroke-width' : 1,
							'stroke-opacity': 0.4
						},
				},
		   
			markers : [{
				latLng : [21.00, 78.00],
				name : 'INDIA : 350'
			  
			  },
			  {
				latLng : [-33.00, 151.00],
				name : 'Australia : 250'
				
			  },
			  {
				latLng : [36.77, -119.41],
				name : 'USA : 250'
			  
			  },
			  {
				latLng : [55.37, -3.41],
				name : 'UK   : 250'
			  
			  },
			  {
				latLng : [25.20, 55.27],
				name : 'UAE : 250'
			  
			  }],
			
			hoverOpacity: null,
			normalizeFunction: 'linear',
			zoomOnScroll: false,
			scaleColors: ['#000000', '#000000'],
			selectedColor: '#000000',
			selectedRegions: [],
			enableZoom: false,
			hoverColor: '#fff',
		});
	}
});
/*****Ready function end*****/

/*****Load function start*****/
$(window).load(function(){
	window.setTimeout(function(){
		$.toast({
			heading: '欢迎使用Annhub加固平台',
			text: '您可以点击左侧导航栏的选项，上传您的应用，进行加固',
			position: 'top-right',
			loaderBg:'#ea65a2',
			icon: 'success',
			hideAfter: 6000, 
			stack: 6
		});
	}, 1000);
});
/*****Load function* end*****/

/*****Sparkline function start*****/
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
/*****Sparkline function end*****/

$(window).resize(function(e) {
	clearTimeout(sparkResize);
	sparkResize = setTimeout(sparklineLogin, 200);
});
sparklineLogin();