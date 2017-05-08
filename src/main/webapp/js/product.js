/**
 * Created by Administrator on 2017/5/6.
 */
/**
 * Created by Administrator on 2017/5/6.
 */
//数据加载和分页
$('#p_dg').datagrid({
    url:'manage/product/show',
    toolbar:$("#p_tb"),
    columns:[[
        {field:'id',title:'编号',checkbox:true,width:100,},
        {field:'name',title:'菜名',width:100,align:'center'},
        {field:'price',title:'价格',resizable:true,align:'center',width:100,},
        {field:'imgUrl',title:'图片路径',sortable:true,align:'center',width:100,},
        {field:'info',title:'描述',align:'center',width:100},
        {field:'number',title:'数量', align:'center',width:100},
        {field:'typeId',title:'菜类', align:'center',width:100,formatter: function(value,row,index){
        switch (row.typeId){
            case 1:
                return "今日推荐";
                break;
            case 2:
                return"江南小炒";
                break;
            case 3:
                return"东北特色";
                break;
            case 4:
                return"农家小菜";
                break;
            case 5:
                return"夏日特饮";
                break;
            case 6:
                return"凉菜";
                break;
        }

        }
        },
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
        $("#p_dg").datagrid('load',{
            'username':$.trim($('input[name="username"]').val())
        })
    }
}
// 删除商品
$(function(){
    $("#p_delete").click(function () {
        var ids=[];//所有选中行的id数组
        var rows= $('#p_dg').datagrid("getSelections");//获得所有选中的行
        for(var i=0; i<rows.length; i++){
            ids.push(rows[i].id);
        }
        if(ids.length>0){
            $.ajax( {
                url:'manage/product/delete',
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
        $('#p_dg').datagrid("reload");//删除后，刷新表格数据
    })
})
// 增加商品
$(function(){
    $("#p_add").click(function () {
        $("#p_addPro").dialog({
            title: '创建商品',
            width: 400,
            height: 300,
            closed: false,
            cache: false,
            modal: true,
            buttons:[{
                text:'提交',
                handler:function(){
                    $('#p_addForm').form('submit', {
                        url:'manage/product/add',
                        success:function(){
                            $("#p_addPro").dialog('close');//提交成功后关闭弹框
                            $('#p_dg').datagrid("reload");//刷新表格数据
                        }
                });
                }
            },{
                text:'重置',
                handler:function(){
                    $('#p_addForm').form('reset');
                }
            }],
        });
        $('#p_dg').datagrid("reload");//删除后，刷新表格数据
    })
})