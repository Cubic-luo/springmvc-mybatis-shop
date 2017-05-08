/**
 * Created by Administrator on 2017/5/6.
 */
//数据加载和分页
$('#dg').datagrid({
    url:'manage/discuss/show',
    toolbar:$("#tb"),
    columns:[[
        {field:'id',title:'编号',checkbox:true,width:100,},
        {field:'user',title:'用户名',width:100,align:'center',formatter:function (value,row) {
            if(row.user){
                return row.user.username;
            }

        }},
        {field:'detail',title:'内容',resizable:true,align:'center',width:100,},
        {field:'creatTime',title:'时间',sortable:true,align:'center',width:100,},
        {field:'stars',title:'评论星级',align:'center,width:100,'},
        {field:'state',title:'审核状态', align:'center',width:100,formatter:function (value,row) {
            if(value==0){
                return "待审核"
            }else if(value==1){
                return "审核通过"
            }else if(value==2){
                return "审核不通过"
            }
        }}


    ]],
    pagination:true,
    pageList:[5,10,15,20],
    pageSize:5,
    remoteSort:false,
    fitColumns:true,
    striped:true,
    rownumbers:true,
    onLoadError:function(){
        alert("加载出错，请检查您输入的词是否有误")
    }
});
//根据用户名查询评论
obj={
    search:function(){
        $("#dg").datagrid('load',{
            'username':$.trim($('input[name="username"]').val())
        })
    }
}
// 删除评论
$(function(){
    $("#delete").click(function () {
        var ids=[];//所有选中行的id数组
        var rows= $('#dg').datagrid("getSelections");//获得所有选中的行
        for(var i=0; i<rows.length; i++){
            ids.push(rows[i].id);
        }
        if(ids.length>0){
            $.ajax( {
                url:'manage/discuss/delete',
                data:{
                    ids : ids,
                },
                type:'post',
                cache:false,
                dataType:'json',
                traditional:true,
            });
        }else {
            alert("您没有选择要删除的行")
        }
        $('#dg').datagrid("reload");//删除后，刷新表格数据
    })
})
// 批准评论
$(function(){
    $("#agree").click(function () {
        var ids=[];//所有选中行的id数组
        var rows= $('#dg').datagrid("getSelections");//获得所有选中的行
        for(var i=0; i<rows.length; i++){
            ids.push(rows[i].id);
        }
        if(ids.length>0){
            $.ajax( {
                url:'manage/discuss/check',
                data:{
                    ids : ids,
                    state:1,
                },
                type:'post',
                cache:false,
                dataType:'json',
                traditional:true,
            });
        }else {
            alert("您没有选择要批准的行")
        }
        $('#dg').datagrid("reload");//审核后，刷新表格数据
    })
})
// 驳回评论
$(function(){
    $("#cancel").click(function () {
        var ids=[];//所有选中行的id数组
        var rows= $('#dg').datagrid("getSelections");//获得所有选中的行
        for(var i=0; i<rows.length; i++){
            ids.push(rows[i].id);
        }
        if(ids.length>0){
            $.ajax( {
                url:'manage/discuss/check',
                data:{
                    ids : ids,
                    state:2,
                },
                type:'post',
                cache:false,
                dataType:'json',
                traditional:true,
            });
        }else {
            alert("您没有选择要驳回的行")
        }
        $('#dg').datagrid("reload");//审核后，刷新表格数据
    })
})