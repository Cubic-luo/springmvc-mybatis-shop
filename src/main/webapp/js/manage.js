/**
 * Created by Administrator on 2017/3/17.
 */
//tab设置
$(function(){
$("#tabs").tabs({
    fit:true,
    border:false,
})
    // 导航条
$("#nav").tree({
    data: [{
        text: '评论管理',
        url:'manage/discuss',
    },{
        text: '商品管理',
        url:'manage/product',
    }],
    onClick:function(node){
        if(node.url){
            if($("#tabs").tabs('exists',node.text)){
                $("#tabs").tabs('select',node.text)
            }else{
                $("#tabs").tabs('add',{
                    title:node.text,
                    closable:true,
                    href:node.url,
                })
            }
        }
    }


})
})
