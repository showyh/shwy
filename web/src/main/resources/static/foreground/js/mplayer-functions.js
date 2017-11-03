/**
 * @authors 0936zz (zz5840@qq.com)
 * @date    2016-08-14 18:35
 */

function setEffects (player) {
	/*// 滑块改变音量的js与项目有有冲突 注释掉改变声音的功能
	player.dom.volRange.nstSlider({
		"left_grip_selector": ".mp-vol-circle",
		"value_changed_callback": function(cause, value) {
			player.dom.container.find('.mp-vol-current').width(value + '%');
			player.dom.volRange.trigger('change',[value]);
		}
	});*/
	player.dom.container.find('.mp-mode').click(function () {
		var dom = $(this);
		var mode = player.getPlayMode();
		dom.removeClass('mp-mode-'+mode);
		mode = mode == 3 ? 0 : mode + 1;
		player.changePlayMode(mode);
		dom.addClass('mp-mode-' + mode);
	});
	player.dom.container.find('.mp-list-toggle').click(function () {
		player.dom.container.find('.mp-list-box').toggleClass('mp-list-show');
	});
	player.dom.container.find('.mp-lrc-toggle').click(function () {
		player.dom.container.find('.mp-lrc-box').toggleClass('mp-lrc-show');
	});
	player.dom.container.find('.mp-toggle').click(function () {
		player.dom.container.toggleClass('mp-show');
	});
	player.dom.container.find('.mp-lrc-close').click(function () {
		player.dom.container.find('.mp-lrc-box').removeClass('mp-lrc-show');
	});
}
