dateDistriOption=function(){
	var divisor=3;
	return {
	    backgroundColor: '#EEEEEE',
	    title: {
	        top: 30,
	        text: '2017年我公司每日成交量',
	        //subtext: '数据纯属虚构',
	        left: 'center',
	        textStyle: {
	            color: '#25b2f4'
	        }
	    },
	    tooltip : {
	        trigger: 'item'
	    },
	    legend: {
	        top: '30',
	        left: '100',
	        data:['成交量', 'Top 12'],
	        textStyle: {
	            color: '#0072C6'
	        }
	    },
	    calendar: [{
	        top: 100,
	        left: 'center',
	        range: ['2017-01-01', '2017-12-31'],
	        splitLine: {
	            show: false,
	            lineStyle: {
	                color: '#000',
	                width: 4,
	                type: 'solid'
	            }
	        },
	        yearLabel: {
	            formatter: '{start}',
	            textStyle: {
	            	fontSize:'50',
	                color: '#25b2f4'
	            }
	        },
	        itemStyle: {
	            normal: {
	                color: '#323c48',
	                borderWidth: 1,
	                borderColor: '#111'
	            }
	        }
	    }/*, {
	        top: 340,
	        left: 'center',
	        range: ['2017-07-01', '2017-12-31'],
	        splitLine: {
	            show: false,
	            lineStyle: {
	                color: '#000',
	                width: 4,
	                type: 'solid'
	            }
	        },
	        yearLabel: {
	            formatter: '{start}  2nd',
	            textStyle: {
	                color: '#fff'
	            }
	        },
	        itemStyle: {
	            normal: {
	                color: '#323c48',
	                borderWidth: 1,
	                borderColor: '#111'
	            }
	        }
	    }*/],
	    series : [
	        {
	            name: '成交量',
	            type: 'scatter',
	            coordinateSystem: 'calendar',
	            data: this,
	            symbolSize: function (val) {
	                return val[1] / divisor;
	            },
	            itemStyle: {
	                normal: {
	                    color: '#25b2f4'
	                }
	            }
	        },
	        {
	            name: '成交量',
	            type: 'scatter',
	            coordinateSystem: 'calendar',
	            calendarIndex: 1,
	            data: this,
	            symbolSize: function (val) {
	                return val[1] / divisor;
	            },
	            itemStyle: {
	                normal: {
	                    color: '#25b2f4'
	                }
	            }
	        },
	        {
	            name: 'Top 12',
	            type: 'effectScatter',
	            coordinateSystem: 'calendar',
	            calendarIndex: 1,
	            data: this.sort(function (a, b) {
	                return b[1] - a[1];
	            }).slice(0, 12),
	            symbolSize: function (val) {
	                return val[1] / divisor;
	            },
	            showEffectOn: 'render',
	            rippleEffect: {
	                brushType: 'stroke'
	            },
	            hoverAnimation: true,
	            itemStyle: {
	                normal: {
	                    color: '#25edf4',
	                    shadowBlur: 10,
	                    shadowColor: '#333'
	                }
	            },
	            zlevel: 1
	        },
	        {
	            name: 'Top 12',
	            type: 'effectScatter',
	            coordinateSystem: 'calendar',
	            data: this.sort(function (a, b) {
	                return b[1] - a[1];
	            }).slice(0, 12),
	            symbolSize: function (val) {
	                return val[1] / divisor;
	            },
	            showEffectOn: 'render',
	            rippleEffect: {
	                brushType: 'stroke'
	            },
	            hoverAnimation: true,
	            itemStyle: {
	                normal: {
	                    color: '#25edf4',
	                    shadowBlur: 10,
	                    shadowColor: '#333'
	                }
	            },
	            zlevel: 1
	        }
	    ]
	};
}