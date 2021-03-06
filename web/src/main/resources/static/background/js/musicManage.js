﻿layui.define(['element', 'laypage', 'layer', 'form', 'pagesize'], function (exports) {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form();
    var laypage = layui.laypage;
    var element = layui.element();
    var laypageId = 'pageNav';


    initilData(1, 8);
    //页数据初始化
    //currentIndex：当前页面
    //pageSize：页容量（每页显示的条数）
    function initilData(currentIndex, pageSize) {
        var index = layer.load(1);
        //模拟数据加载
        setTimeout(function () {
            layer.close(index);
            $.ajax({
                url: "/admin/musicManage/list/" + currentIndex,
                type: "GET",
                data: {
                    pageSize: pageSize
                },
                success: function (musicList) {
                    var html = '';
                    html += '<table style="table-layout: fixed" class="layui-table" lay-even>';
                    html += '<colgroup><col width="40"><col width="60"><col width="60"><col width="60"><col width="200"><col width="200"><col width="50"><col width="40"><col width="40"><col width="40"></colgroup>';
                    html += '<thead><tr><th>编号</th><th>歌名</th><th>歌手</th><th>歌单</th><th>歌曲地址</th><th>歌词</th><th>封面</th><th>时间</th><th colspan="2">操作</th></tr></thead>';
                    html += '<tbody>';
                    for (var i in musicList) {
                        var item = musicList[i];
                        html += '<tr>';
                        html += '<td>' + item.id + '</td>';
                        html += '<td>' + item.name + '</td>';
                        html += '<td>' + item.singer + '</td>';
                        html += '<td>' + item.musicListPO.musicListName + '</td>';
                        html += '<td>'+'<audio src="'+ item.src +'" controls="controls"/>'+ '</td>';
                        html += '<td>' + item.lrc + '</td>';
                        html += '<td>'+'<img src="'+ item.musicImg +'" width="75px"/>'+ '</td>';
                        html += '<td>' + item.time + '</td>';
                        html += '<td><button class="layui-btn layui-btn-small layui-btn-normal" onclick="layui.datalist.editData(' + item.id + ')"><i class="layui-icon">&#xe642;</i></button></td>';
                        html += '<td><button class="layui-btn layui-btn-small layui-btn-danger" onclick="layui.datalist.deleteData(' + item.id + ')"><i class="layui-icon">&#xe640;</i></button></td>';
                        html += '</tr>';
                    }
                    html += '</tbody></table>';
                    $('#dataContent').html(html);
                    element.init();

                }
            });

            form.render('checkbox');  //重新渲染CheckBox，编辑和添加的时候
            $('#dataConsole,#dataList').attr('style', 'display:block'); //显示FiledBox
            laypage({
                cont: laypageId,
                pages: musicNum / pageSize == 0 ? musicNum / pageSize : musicNum / pageSize + 1,
                groups: 5,
                skip: true,
                curr: currentIndex,
                jump: function (obj, first) {
                    var currentIndex = obj.curr;
                    if (!first) {
                        initilData(currentIndex, pageSize);
                    }
                }
            });

            //laypageId:laypage对象的id同laypage({})里面的cont属性
            //pagesize当前页容量，用于显示当前页容量
            //callback用于设置pagesize确定按钮点击时的回掉函数，返回新的页容量
            layui.pagesize(laypageId, pageSize).callback(function (newPageSize) {
                initilData(1, newPageSize);
            });

        }, 500);
    }


    //输出接口，主要是两个函数，一个删除一个编辑
    var datalist = {
        deleteData: function (id) {
            layer.confirm('删除歌曲后不能恢复，确定删除？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                $.ajax({
                    url: '/admin/music/' + id,
                    data: {},
                    type: 'DELETE',
                    success: function (result) {
                        var result = eval("(" + result + ")");
                        if (result.success) {
                            layer.alert('删除成功!', {
                                closeBtn: 0,
                                icon: 1
                            }, function () {
                                window.location.href = "/admin/musicManage"
                            });
                        } else {
                            layer.alert('删除失败!', {icon: 5});
                        }
                    }
                });
            }, function () {

            });
        },
        editData: function (id) {
            parent.switchTab(parent.$, parent.element, '修改歌曲', '/admin/writeMusic?id=' + id, 'Music' + id);
        }
    };
    exports('datalist', datalist);
});
