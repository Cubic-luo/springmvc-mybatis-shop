package shop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.dto.EasyUiJson;
import shop.entity.Products;
import shop.service.impl.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/6.
 */
@Controller
@RequestMapping("/manage/product")
public class productController {
    @Autowired
    private ProductServiceImpl psi;

    /**
     * 跳转到商品管理页面
     * @return
     */
    @RequestMapping()
    public String toProcust(){
        return "product";
    }

    /**
     * 商品数据 json形式传送到前端
     * @param pageNum 页码
     * @param pageSize 每页显示条数
     * @return
     */
    @RequestMapping(value = "/show",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public EasyUiJson<List<Products>> getProduct(@RequestParam(value="page",defaultValue = "1",required = false) int pageNum,@RequestParam(value = "rows",defaultValue = "5",required = false
    ) int pageSize){
        PageInfo<Products> pageInfo=psi.queryAll(pageNum,pageSize);
        EasyUiJson<List<Products>> ey=new EasyUiJson<>();
        ey.setRows(pageInfo.getList());
        ey.setTotal(pageInfo.getTotal());
        return ey;
    }

    /**
     * 删除商品
     * @param ids
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public void deleteProduct(@RequestParam(value = "ids") int[] ids){
        for (int i=0;i<ids.length;i++){
            int id=ids[i];
            psi.deleteProduct(id);
        }
    }

    /**
     * 增加商品
     * @param p 商品对象
     */
    @RequestMapping(value = "add",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    @ResponseBody
    public void addProduct(Products p, @RequestPart("imgFile") MultipartFile imgFile, HttpServletRequest request) throws IOException{
        // 判断文件是否为空
        if (!imgFile.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/") + "img/"
                        + imgFile.getOriginalFilename();
                // 转存文件
                imgFile.transferTo(new File(filePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        p.setImgUrl(imgFile.getOriginalFilename());
        psi.addProduct(p);
    }

    /**
     *修改商品
     * @param p 商品对象
     */
    @RequestMapping(value = "modify",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public void modifyProduct(Products p){
        psi.modifyProduct(p);
    }
}
