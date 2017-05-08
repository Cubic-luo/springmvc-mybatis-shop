package shop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.entity.Discuss;
import shop.entity.ProductsType;
import shop.service.impl.IndexInitServiceImpl;

@Controller
@RequestMapping("/")
public class InitController {

	@Autowired
	private IndexInitServiceImpl initService;

	/**
	 * 
	 * @return 返回index.jsp页面
	 *
	 **/
	@RequestMapping()
	public String home(Model model) {
		List<ProductsType> productsTypeList = initService.queryAllProducts();// 所有商品
		List<Discuss> discussList = initService.queryAllDiscsss();// 所有评论
		model.addAttribute("productsTypeList", productsTypeList);
		model.addAttribute("discussList", discussList);
		return "index";
	}

	@RequestMapping("aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}

}
