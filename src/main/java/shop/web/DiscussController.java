package shop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.dto.EasyUiJson;
import shop.entity.Discuss;
import shop.service.impl.DiscussServiceImpl;

import java.util.List;


/**
 * Created by Administrator on 2017/3/17.
 *评论管理
 */
@Controller
@RequestMapping("/manage/discuss")
public class DiscussController {
    @Autowired
    private DiscussServiceImpl mp;
//    跳转到评论管理页面
    @RequestMapping()
    public String toDiscuss(){
        return "discuss";
    }

    //传评论json数据到前台
    @RequestMapping(value = "/show", method = RequestMethod.POST, produces = {
            "application/json;charset=utf-8" })
    @ResponseBody
    public EasyUiJson<List<Discuss>> getDiscuss(@RequestParam(value = "page",defaultValue = "1",required = false) int pageNum, @RequestParam(value = "rows",defaultValue = "5",required = false) int pageSize,
                                                @RequestParam(value = "username",required = false) String username  ) {
        if(username==null||username==""){
            //如果用户名为空，执行查询所有的操作
            PageInfo<Discuss> pageInfo=mp.queryAllDiscsss(pageNum,pageSize);
            EasyUiJson<List<Discuss>> ey=new EasyUiJson<>();
            ey.setRows(pageInfo.getList());
            ey.setTotal(pageInfo.getTotal());
            return ey;
        }else{
            PageInfo<Discuss> pageInfo=mp.queryByUsername(username,pageNum,pageSize);
            EasyUiJson<List<Discuss>> ey=new EasyUiJson<>();
            ey.setRows(pageInfo.getList());
            ey.setTotal(pageInfo.getTotal());
            return ey;
        }

    }
//    删除评论
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {
            "application/json;charset=utf-8" })
    @ResponseBody
    public void deleteDiscuss(@RequestParam(value = "ids") int[] ids){
        for (int i=0;i<ids.length;i++){
           int id= ids[i];
        mp.deleteDiscuss(id);
        }

    }
    //    审核评论
    @RequestMapping(value = "/check", method = RequestMethod.POST, produces = {
            "application/json;charset=utf-8" })
    @ResponseBody
    public void checkDiscuss(@RequestParam(value = "ids") int[] ids,@RequestParam(value = "state") int state ){
        for (int i=0;i<ids.length;i++){
            int id= ids[i];
            mp.checkDiscuss(id,state);
        }

    }

}

