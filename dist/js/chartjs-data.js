/*Chartjs Init*/

$( document ).ready(function() {
    "use strict";
	
	if( $('#chart_1').length > 0 ){
		var ctx1 = document.getElementById("chart_1").getContext("2d");
		var data1 = {
			labels: ["14", "15", "16", "17", "18", "19", "20", "21", "22"],
			datasets: [
			{
				label: "高危",
				data: [122, 154, 166, 138, 146, 114, 117, 57, 42]
			},
			{
				label: "中危",
				data: [1257, 825, 1025, 734, 690, 687, 523, 761, 721]
			},
			{
				label: "低危",
				backgroundColor: "rgba(252,176,59,0.4)",
				borderColor: "rgba(252,176,59,0.4)",
				pointBorderColor: "rgb(252,176,59)",
				pointBackgroundColor: "rgba(252,176,59,0.4)",
				data: [1014, 799, 827, 815, 783, 682, 612, 619, 566]
			},
			{
				label: "警告",
				backgroundColor: "rgba(252,176,59,0.4)",
				borderColor: "rgba(252,176,59,0.4)",
				pointBorderColor: "rgb(252,176,59)",
				pointBackgroundColor: "rgba(252,176,59,0.4)",
				data: [1418, 1017, 781, 738, 626, 740, 640, 653, 631]
			}
			
		]
		};
		
		var areaChart = new Chart(ctx1, {
			type:"line",
			data:data1,
			
			options: {
				tooltips: {
					mode:"label"
				},
				elements:{
					point: {
						hitRadius:5
					}
				},
				
				scales: {
					yAxes: [{
						stacked: false,
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
					}]
				},
				animation: {
					duration:	3000
				},
				responsive: true,
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
    
	if( $('#chart_2').length > 0 ){
		var ctx2 = document.getElementById("chart_2").getContext("2d");
		var data2 = {
			labels: ["R1/敏感信息检测", "R4/组件导出风险", "R4/implicit service", "R1/Webview密码明文保存", 
			"R4/证书弱校验", "R3/Intent-Based攻击风险", "R1/Provider: granted-url-permission", 
			"R1/Webview远程执行", "R1/日志泄露风险","R1/密钥硬编码"],
			datasets: [
				{
					label: "总数(单位/%)",
					backgroundColor: "rgba(252,176,59,.8)",
					borderColor: "rgba(252,176,59,.8)",
					data: [5.8, 5.6, 5.3, 4.8, 4.4, 4.3, 4.1, 4.1, 3.9, 3.8]
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

	if( $('#chart_4').length > 0 ){
		var ctx4 = document.getElementById("chart_4").getContext("2d");
		var data4 = {
			datasets: [{
				data: [
					11,
					16,
					7,
					3,
					14
				],
				backgroundColor: [
					"rgba(86,111,201,.8)",
					"rgba(60,184,120,.8)",
					"rgba(241,91,38,.8)",
					"rgba(252,176,59,.8)",
					"rgba(234,101,162,.8)"
				],
				label: 'My dataset' // for legend
			}],
			labels: [
				"lab 1",
				"lab 2",
				"lab 3",
				"lab 4",
				"lab 5"
			]
		};
		var polarChart = new Chart(ctx4, {
			type: "polarArea",
			data: data4,
			options: {
				elements: {
					arc: {
						borderColor: "#fff"
					}
				},
				scale: {
					ticks: {
						beginAtZero: true,
						fontFamily: "Varela Round",
						
					},
					gridLines: {
						color: "#eee",
					}
				},
				animation: {
					duration:	3000
				},
				responsive: true,
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

	if( $('#chart_5').length > 0 ){
		var ctx5 = document.getElementById("chart_5").getContext("2d");
		var data5 = {
			datasets: [
				{
					label: 'First Dataset',
					data: [
						{
							x: 80,
							y: 60,
							r: 10
						},
						{
							x: 40,
							y: 40,
							r: 10
						},
						{
							x: 30,
							y: 40,
							r: 20
						},
						{
							x: 20,
							y: 10,
							r: 10
						},
						{
							x: 50,
							y: 30,
							r: 10
						}
					],
					backgroundColor:"rgba(86,111,201,.8)",
					hoverBackgroundColor: "rgba(86,111,201,.8)",
				},
				{
					label: 'Second Dataset',
					data: [
						{
							x: 40,
							y: 30,
							r: 10
						},
						{
							x: 25,
							y: 20,
							r: 10
						},
						{
							x: 35,
							y: 30,
							r: 10
						}
					],
					backgroundColor:"rgba(60,184,120,.8)",
					hoverBackgroundColor: "rgba(60,184,120,.8)",
				}]
		};
		
		var bubbleChart = new Chart(ctx5,{
			type:"bubble",
			data:data5,
			options: {
				elements: {
					points: {
						borderWidth: 1,
						borderColor: 'rgb(0, 0, 0)'
					}
				},
				scales: {
					xAxes: [
					{
						ticks: {
							min: -10,
							max: 100,
							fontFamily: "Varela Round",
							fontColor:"#2f2c2c"
						},
						gridLines: {
							color: "#eee",
						}
					}],
					yAxes: [
					{
						ticks: {
							fontFamily: "Varela Round",
							fontColor:"#2f2c2c"
						},
						gridLines: {
							color: "#eee",
						}
					}]
				},
				animation: {
					duration:	3000
				},
				responsive: true,
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

	if( $('#chart_6').length > 0 ){
		var ctx6 = document.getElementById("chart_6").getContext("2d");
		var data6 = {
			 labels: [
			"lab 1",
			"lab 2",
			"lab 3"
		],
		datasets: [
			{
				data: [300, 50, 100],
				backgroundColor: [
					"rgba(234,101,162,.8)",
					"rgba(241,91,38,.8)",
					"rgba(252,176,59,.8)"
				],
				hoverBackgroundColor: [
					"rgba(234,101,162,.8)",
					"rgba(241,91,38,.8)",
					"rgba(252,176,59,.8)"
				]
			}]
		};
		
		var pieChart  = new Chart(ctx6,{
			type: 'pie',
			data: data6,
			options: {
				animation: {
					duration:	3000
				},
				responsive: true,
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

	if( $('#chart_7').length > 0 ){
		var ctx7 = document.getElementById("chart_7").getContext("2d");
		var data7 = {
			 labels: [
			"lab 1",
			"lab 2",
			"lab 3"
		],
		datasets: [
			{
				data: [300, 50, 100],
				backgroundColor: [
					"rgba(60,184,120,.8)",
					"rgba(241,91,38,.8)",
					"rgba(252,176,59,.8)"
				],
				hoverBackgroundColor: [
					"rgba(60,184,120,.8)",
					"rgba(241,91,38,.8)",
					"rgba(252,176,59,.8)"
				]
			}]
		};
		
		var doughnutChart = new Chart(ctx7, {
			type: 'doughnut',
			data: data7,
			options: {
				animation: {
					duration:	3000
				},
				responsive: true,
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
});