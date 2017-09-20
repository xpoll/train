$.msg = {
		_show:function(){
			$('#RBmsgBox').animate({
				right: 0,
			    opacity: 1
			},'slow');
		},
		_hide:function(){
			$('#RBmsgBox').animate({
				right: -300,
			    opacity: 0
			},'slow');
		},
		showMsg:function(msg,time){
			var _time = time || 3000;
			var _this = this;
			$('#RBmsgBox p').html(msg);
			this._show();
			setTimeout(function(){
				_this._hide();
			},_time);
		}
}
/**
 * @param $msg 显示提示
 * @param $time 多长时间隐藏
 * @param $e vue事件
 * @param $reload 是否刷新页面（刷新等待时间为1s）
 * @param $function 调用函数
 */
function emsg($msg, $time, $e, $reload, $function) {
	$e.msg = $msg
	if ($reload) {
		$time = 1000
	}
	setTimeout(function(){
		$e.msg = null
		if ($reload) {
			$function()
			window.location.reload()
		}
	}, $time)
}

function trimToNull(str) {
	if (str == null
			|| str == undefined
			|| typeof (str) == 'undefined'
			|| str == '') {
		return null
	} else if (typeof (str) == 'string') {
		str = str.replace(/(^\s*)|(\s*$)/g, '')
		if (str == "")
			return null
	}
	return str
}

// 与java文件RegUtil对应
var USERNAME = /^\w{5,16}$/;

// TODO 要去掉
//(function($){
//	$.fn.serializeObject = function () {
//		var result = {};
//		var extend = function (i, element) {
//			var node = result[element.name];
//			if ('undefined' !== typeof node && node !== null) {
//				if ($.isArray(node)) {
//					node.push(element.value);
//				} else {
//					result[element.name] = [node, element.value];
//				}
//			} else {
//				result[element.name] = element.value;
//			}
//		};
//		$.each(this.serializeArray(), extend);
//		return result;
//	};
//})(jQuery);


$(function () {
  /**
   * 请严格按照格式
   * <div class="lmpagination"></div>
   * <div id="page" data-total="100" data-size="10" data-current="99"></div>
   * 第一个标签为固定, data-total为总数, data-size为每页大小, data-current为当前显示起始位数
   *
   * 调用
   * $('#page').lmpagination()
   * $('.lmpagination').click(function(){
   * })
   *
   **/
  $.fn.lmpagination = function($total, $size, $current) {
    if (!(typeof $total === 'number' && $total%1 === 0)
      || !(typeof $size === 'number' && $size%1 === 0)
      || !(typeof $current === 'number' && $current%1 === 0)
      || $total < 0 || $size <= 0 || $current < 0) {
      console.error("分页数据格式不正确")
      $(this).html('')
      return false
    }
    if ($total <= $size) {$(this).html('');return false}
    var size = $total%$size > 0 ? (parseInt($total/$size) + 1) : parseInt($total/$size)
    var current = $current
    var temp = ""

    if (size <= 5) {
      for (var i = 1; i <= size; i++) {
        temp += '<li data-num="' + i + '"><a>' + i + '</a></li>'
      }
    } else {
      if (current <= 3) {
        temp = ''
          + '<li data-num="1"><a>1</a></li>'
          + '<li data-num="2"><a>2</a></li>'
          + '<li data-num="3"><a>3</a></li>'
          + '<li class="disabled"><a>...</a></li>'
          + '<li data-num="' + size + '"><a>' + size + '</a></li>'
      } else if (current > (size - 3)) {
        temp = ''
        + '<li data-num="1"><a>1</a></li>'
        + '<li class="disabled"><a>...</a></li>'
        + '<li data-num="' + (size - 2) + '"><a>' + (size - 2) + '</a></li>'
        + '<li data-num="' + (size - 1) + '"><a>' + (size - 1) + '</a></li>'
        + '<li data-num="' + size + '"><a>' + size + '</a></li>'
      } else {
        temp = ''
          + '<li data-num="1"><a>1</a></li>'
          + '<li class="disabled"><a>...</a></li>'
          + '<li data-num="' + (current - 1) + '"><a>' + (current - 1) + '</a></li>'
          + '<li data-num="' + current + '"><a>' + current + '</a></li>'
          + '<li data-num="' + (current + 1) + '"><a>' + (current + 1) + '</a></li>'
          + '<li class="disabled"><a>...</a></li>'
          + '<li data-num="' + size + '"><a>' + size + '</a></li>'
      }
    }
    $content = ''
    + '<ul class="pagination pull-right margin0">'
      + '<li data-num="' + ((current - 1) > 0 ? (current - 1) : current) + '" class="lmpagination-bz"><a>&laquo;</a></li>'
      + temp
      + '<li data-num="' + ((current + 1) > size ? current : (current + 1)) + '" class="lmpagination-bz"><a>&raquo;</a></li>'
    + '</ul>'
    $(this).html($content)
    $.each($(this).find('li'), function(){
      if ($(this).data('num') == current) {
        if ($(this).hasClass('lmpagination-bz')) {
          $(this).addClass("disabled")
        } else {
          $(this).addClass("active")
        }
      }
    })
    $(this).find('li').click(function(){
      if ($(this).data("num") == current || $(this).hasClass("disabled")) return
      $('.lmpagination').data("go", $(this).data("num"))
      $('.lmpagination').click()
    })
  }
});
