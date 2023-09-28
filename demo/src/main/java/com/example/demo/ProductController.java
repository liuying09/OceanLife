package com.example.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bean.ProductImgModel;
import com.example.demo.bean.ProductInfo;
import com.example.demo.bean.ProductModel;
import com.example.demo.dao.ProductImgRepository;
import com.example.demo.dao.ProductRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "商品") //swagger api標題
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductImgRepository productImgRepository;
	
	@Autowired
	DataSource dataSource;
	
	
	
	
    @Operation(summary = "取得所有商品", description = "取得所有商品資料")
	//撈取所有商品資料回傳給前端
//	@RequestMapping("/productPage")
	@GetMapping("/findProducts") //使用get方法
	public Map<String, Map<String,Object>> productPage() {
		logger.info("==進入傳回全部商品==");
		List<ProductModel> list = new ArrayList<ProductModel>();
		Map<String,Map<String,Object>> map = new HashMap<>();
		
		list = productRepository.findAll();
		for(int i = 0 ; i < list.size(); i++) {
			Map<String,Object> mapOne = new HashMap<>();
			System.out.println("id= "+list.get(i).getProductId());
			System.out.println("name= "+list.get(i).getProductName());
			
			mapOne.put("productId",list.get(i).getProductId());
			mapOne.put("productName",list.get(i).getProductName());
			mapOne.put("productPrice",list.get(i).getProductPrice());
			mapOne.put("productPriceSale",list.get(i).getProductPriceSale());
			mapOne.put("productType",list.get(i).getProductType());
			mapOne.put("productNum",list.get(i).getProductNum());
			mapOne.put("productContent",list.get(i).getProductContent());
			mapOne.put("productSpenMaterial",list.get(i).getProductSpenMaterial());
			mapOne.put("productSpenSize",list.get(i).getProductSpenSize());
			mapOne.put("productSpenMF",list.get(i).getProductSpenMF());
			mapOne.put("productRemark",list.get(i).getProductRemark());
			mapOne.put("productStatus", list.get(i).getProductStatus());
			mapOne.put("createDate", list.get(i).getCreateDate());
			mapOne.put("updateDate", list.get(i).getUpdateDate());
			
			List<Object> imgObjects = new ArrayList<Object>();
			List<ProductImgModel> pList = productImgRepository.findByProductID(String.valueOf(list.get(i).getProductId()));
			if(pList.size() != 0) {
				for(int j = 0; j < pList.size(); j++) {
					imgObjects.add(pList.get(j).getProductImgBlob());
				}
			}
			
			
			mapOne.put("productImg", imgObjects);
			map.put(String.valueOf(i), mapOne);
		}
		
		return map;
	}
	
	
	/*回傳 ResponseEntity 物件時，可以用它的方法選擇常見的 HTTP 狀態，
	 * 例如200（OK）、201（Created）、204（No Content）、404（Not Found）等，
	 * 或者用 status 方法直接自行指定。
	 * 最後將要回傳的產品資料放在回應主體（body）中。*/
	
    
    @Operation(summary = "以商品id取得商品", description = "以商品id取得商品")
//	@RequestMapping("/findByProductID")
	@GetMapping("/findProducts/{id}") //使用get方法
	public ResponseEntity<ProductInfo> findByProductID(@PathVariable("id") String id ){
		
		ProductModel productModel = productRepository.findByProductId(id);
		List<ProductImgModel> productImgs = productImgRepository.findByProductID(id);
	    if (productModel != null) {
	        // 將 ProductModel 和 ProductImg 數據封裝成 ProductInfo
	        ProductInfo productInfo = new ProductInfo();
	        productInfo.setProductModel(productModel);
	        productInfo.setProductImgModel(productImgs);

	        return ResponseEntity.ok(productInfo);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	
	}
	
	
//	@RequestMapping("/findByProductID")
//	@GetMapping("/products/{id}") //使用get方法
//	public Map<String,Object> findByProductID(@RequestBody ProductModel productModel ){
//		
////		String id = "13";
//		
//		Map<String,Object> map = new HashMap<>();
////		Map<ProductModel,List<ProductImgModel>> map = new HashMap<>();
////		ProductModel p = productRepository.findByProductId(String.valueOf(productModel.getProductId()));
//		ProductModel p = productRepository.findByProductId(String.valueOf(productModel.getProductId()));
//		System.out.println("name= "+ p.getProductName());
//		
//		map.put("productId",p.getProductId());
//		map.put("productName",p.getProductName());
//		map.put("productPrice",p.getProductPrice());
//		map.put("productPriceSale",p.getProductPriceSale());
//		map.put("productType",p.getProductType());
//		map.put("productNum",p.getProductNum());
//		map.put("productContent",p.getProductContent());
//		map.put("productSpenMaterial",p.getProductSpenMaterial());
//		map.put("productSpenSize",p.getProductSpenSize());
//		map.put("productSpenMF",p.getProductSpenMF());
//		map.put("productRemark",p.getProductRemark());
//		map.put("productStatus", p.getProductStatus());
//		map.put("createDate", p.getCreateDate());
//		map.put("updateDate", p.getUpdateDate());
//		
//		List<Object> listObjects = new ArrayList<Object>();
//		List<ProductImgModel> pList = productImgRepository.findByProductID(String.valueOf(productModel.getProductId()));
//		for(int i = 0; i < pList.size(); i++) {
//			listObjects.add(pList.get(i).getProductImgBlob());
//		}
//		map.put("productImg", listObjects);
////		map.put(productRepository.findByProductId(String.valueOf(productModel.getProductId())), 
////				productImgRepository.findByProductID(String.valueOf(productModel.getProductId())));
//		
//		return map;
//	
//	}
	
	
	//新增商品
    @Operation(summary = "新增商品", description = "新增商品")
	 @PostMapping("/addProduct") //設置url路徑對應到此方法上，並限制只能使用Post方法,
	 public void create(@RequestParam(name="name",required = false)String name ,
				@RequestParam(name="price",required = false)String price
				,@RequestParam(name="priceSale",required = false)String priceSale
				,@RequestParam(name="type",required = false)String type
				,@RequestParam(name="num",required = false)String num
				,@RequestParam(name="content",required = false)String content
				,@RequestParam(name="meterial",required = false)String meterial
				,@RequestParam(name="size",required = false)String size
				,@RequestParam(name="mf",required = false)String mf
				,@RequestParam(name="remark",required = false)String remark
				,@RequestParam(name="status",required = false)String status
				,@RequestParam(name="file-to-upload",required = false) MultipartFile[] fileField) throws IOException{ 
		 
		 	logger.info("==進入新增商品==");
		 
		 	SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
			Date date = new Date();
			String thisDate = ft.format(date);
			
			ProductModel productModel = new ProductModel();
			productModel.setProductName(name);
			productModel.setProductPrice(price);
			productModel.setProductPriceSale(priceSale);
			productModel.setProductType(type);
			productModel.setProductNum(num);
			productModel.setProductContent(content.replace("\n","<br>"));
			productModel.setProductSpenMaterial(meterial);
			productModel.setProductSpenSize(size);
			productModel.setProductSpenMF(mf);
			productModel.setProductRemark(remark.replace("\n","<br>"));
			productModel.setProductStatus(status);
			productModel.setCreateDate(thisDate);
			productModel= productRepository.save(productModel);

			
			if(fileField == null) {
				System.out.println("file == null");
				
			}else {
				System.out.println("file != null");
				System.out.println("fileField.length= "+ fileField.length);
				for(int i = 0; i < fileField.length; i++) {
					byte[] image;
					image=fileField[i].getBytes();
					String filename = fileField[i].getOriginalFilename();
					
					System.out.println("filename= "+filename);
					productImgRepository.addProductImg(String.valueOf(productModel.getProductId()),filename, image, thisDate, null);

				}
				
			}
	 }
	 
	 
    @Operation(summary = "更新商品", description = "更新商品")
//	 @PostMapping("/updateProduct") //設置url路徑對應到此方法上，並限制只能使用Post方法,
	 @PutMapping("/updateProduct/{id}")
	 public void updateProduct(@RequestParam(name="productId",required = false)int id ,
			 @RequestParam(name="name",required = false)String name ,
				@RequestParam(name="price",required = false)String price
				,@RequestParam(name="priceSale",required = false)String priceSale
				,@RequestParam(name="type",required = false)String type
				,@RequestParam(name="num",required = false)String num
				,@RequestParam(name="content",required = false)String content
				,@RequestParam(name="meterial",required = false)String meterial
				,@RequestParam(name="size",required = false)String size
				,@RequestParam(name="mf",required = false)String mf
				,@RequestParam(name="remark",required = false)String remark
				,@RequestParam(name="status",required = false)String status
				,@RequestParam(name="file-to-upload",required = false) MultipartFile[] fileField) throws IOException{
		 
		 	logger.info("==進入更新商品==");
		 
		 	SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
			Date date = new Date();
			String thisDate = ft.format(date);
			
			ProductModel productModel = productRepository.findByProductId(String.valueOf(id));
			productModel.setProductName(name);
			productModel.setProductPrice(price);
			productModel.setProductPriceSale(priceSale);
			productModel.setProductType(type);
			productModel.setProductNum(num);
			productModel.setProductContent(content.replace("\n","<br>"));
			productModel.setProductSpenMaterial(meterial);
			productModel.setProductSpenSize(size);
			productModel.setProductSpenMF(mf);
			productModel.setProductRemark(remark.replace("\n","<br>"));
			productModel.setProductStatus(status);
			productModel.setUpdateDate(thisDate);
			productModel= productRepository.save(productModel);

			
			if(fileField == null) {
				System.out.println("file == null");
				
			}else {
				System.out.println("file != null");
				productImgRepository.deleteProductImg(id);
				
				for(int i = 0; i < fileField.length; i++) {
					if(fileField[i] != null) {
						byte[] image;
						image=fileField[i].getBytes();
						String filename = fileField[i].getOriginalFilename();
						
						System.out.println("filename= "+filename);
						productImgRepository.addProductImg(String.valueOf(productModel.getProductId()),filename, image, thisDate, null);
					}
				}
				
			}
	 }

	 
    @Operation(summary = "刪除商品", description = "刪除商品")
//	 @RequestMapping("/deleteProduct")
	 @DeleteMapping("/deleteProduct")
		public void deleteProduct(@RequestParam(name="idList",required = false) Integer[] ids ) {
			
			for(int i = 0; i < ids.length; i++) {
				if(productRepository.findByProductId(String.valueOf(ids[i])) != null) {
					productImgRepository.deleteProductImg(ids[i]);
					productRepository.deleteProduct(ids[i]);
				}
			}
			
		}
	 
}
