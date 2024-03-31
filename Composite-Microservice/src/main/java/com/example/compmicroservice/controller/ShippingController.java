package com.example.compmicroservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.compmicroservice.Entity.Customer;
import com.example.compmicroservice.Entity.CustomerCart;
import com.example.compmicroservice.Entity.CustomerOrder;
import com.example.compmicroservice.Entity.CustomerOrderDetails;
import com.example.compmicroservice.Entity.Inventory;
import com.example.compmicroservice.Entity.Lineitem;
import com.example.compmicroservice.Entity.Orderinfo;
import com.example.compmicroservice.Entity.Product;
import com.example.compmicroservice.Entity.ProductInventory;
import com.example.compmicroservice.Entity.cart;
import com.example.compmicroservice.Exception.Exception_class;
import com.example.compmicroservice.clients.InventoryProxy;
import com.example.compmicroservice.clients.OrderProxy;
import com.example.compmicroservice.clients.ProductProxy;
import com.example.compmicroservice.clients.cartProxy;
import com.example.compmicroservice.clients.customerProxy;
import com.example.compmicroservice.repository.CustomerCart_Repo;
import com.example.compmicroservice.repository.Customer_Repo;
import com.example.compmicroservice.repository.ProductInventory_Repo;
import com.example.compmicroservice.service.CustomerCartService;
import com.example.compmicroservice.service.CustomerOrderService;


@RestController
public class ShippingController {

	@Autowired
	ProductProxy prodProxy;
	
	@Autowired
	InventoryProxy invenProxy;
	
	@Autowired
	cartProxy cartProxy;
	
	@Autowired
	customerProxy custProxy;
	
	@Autowired
	OrderProxy orderProxy;
	
	@Autowired
	CustomerCartService service;
	
	@Autowired
	CustomerOrderService orderservice;
	
	@Autowired
	ProductInventory_Repo repo;
	
	@Autowired
	CustomerCart_Repo repos;
	
	@Autowired
	Customer_Repo custrepo;
	
	private static Integer orderId=1;
	
	@PostMapping("/api/shoppingservice/products")
	public String shop(@RequestBody ProductInventory product)
	{
		if(product.getProductname().equals(repo.getProductInventoryByProductname(product.getProductname()))) {
			throw new Exception_class("Product name is Already Present - "+product.getProductname() +
					"So create a new product name");
		}
		
		if(product.getProductdes().equals(repo.getProductInventoryByProductdes(product.getProductdes()))) {
			throw new Exception_class("Product des is already present - "+product.getProductdes()+
					"so describe a new product Desc!!");
		}
		
		System.out.println("request body -- > "+product.getProductname());
		System.out.println("server side "+repo.getProductInventoryByProductname(product.getProductname()));
		
		//creating a new tableProductInventory to keep the details of both product and inventory..
		//then by using prodProxy method to call product ms create product
		
		ProductInventory products = prodProxy.createProduct(product);
		
		//calling an inventory table to create inventory details like quantity and product id
		//now getting productid from above created and also quantity
		//store it using inventory object, now this object has productid and quantity
		
		Inventory inventory=new Inventory(products.getProductId(),product.getQuantity());
		
		//now getting inventory object we gonna to send it inventory ms to create quantity and productdetails
		
		Inventory inventorys=invenProxy.createInventory(inventory);
		
		repo.save(products);
		
		return "Products added Successfully";
		}

    @PostMapping("/api/shoppingservice/customer")
    public String customercart(@RequestBody Customer customer)
    {
    	//creating a customer using custProxy method to call customer ms
    	
    	if(customer.getCustomername().equals(custrepo.getCustomerByCustomerName(customer.getCustomername()))) {
    		throw new Exception_class("Customer name is already present "+ customer.getCustomername()+" so create a new customer name !!");
    	}
    	
    	if(customer.getCustomeremail().equals(custrepo.getCustomerByCustomerEmail(customer.getCustomeremail()))) {
    		throw new Exception_class("Customer name is already present "+customer.getCustomeremail()+" so create a new customer name !!");
    	}
    	
    	Customer customers=custProxy.createCustomer(customer);
    	
    	//creating object for cart
    	cart car=new cart();

    	//creating a new cart by using cart object created above
    	cart carts=cartProxy.createCart(car);
    	
    	//creating customercart table to get both customer and cart id
    	//to maintain relationship for if customer created at the same way need to create cart like.. 1.Customer 1.cart
    	
    	CustomerCart deatils=new CustomerCart(carts.getId(),customers.getCustomerid());
    	
    	service.saveCart(deatils);
    	
    	custrepo.save(customers);
    	
    	return "created customer and mapped to CustomerCart table";
  
}
    @PutMapping("/api/shoppingservice/customer/{customerId}/cart")
    public String addProducts(@RequestBody cart car, @PathVariable("customerId") int id)
    {
    	//getting customer id to check that customer id is available in customer-cart table
    	//if its not then it get to exception
    	
    	Optional<CustomerCart> findcart = service.findById(id);
    	//System.out.println("findcart "+findcart);
    	if(findcart.isEmpty())
    	{
    		throw new Exception_class("Customer id doesnot exists "+id);
    	}
    	
    	//getting cartid by using customer_id from customercart table
    	CustomerCart cartdetail=findcart.get();
    	
    	//original cart table will updates based on the customercart..
    	car.setId(cartdetail.getCartId());
    	
    	for(Lineitem line:car.getItem()) {
    		System.out.println(line.getProductId()+" id for the product ");
    		Inventory inventorydetails=invenProxy.getInventory(line.getProductId());
    		Product productdetails=prodProxy.getProduct(inventorydetails.getProductId());
    		System.out.println("product data "+productdetails);
    		
    		System.out.println(inventorydetails.getQuantity()+"Quantity details");
    		
    		if(inventorydetails.getProductId()!=line.getProductId()) {
    			throw new Exception_class(" Product and Inventory Details is not created yet with product id "+line.getProductId());
    		}
    		
    		if(inventorydetails.getQuantity()<=0 || line.getQuantity()>inventorydetails.getQuantity()) {
    			throw new Exception_class("Stock is not available because the quantity as enough product only "+inventorydetails.getQuantity()+" with "
    		     +"Product name --> "+line.getProductname());
    		}
    		
    		System.out.println("linee -> "+line.getProductname());
    		System.out.println("deeeeee "+productdetails.getProductname());
    		System.out.println("comapring "+line.getProductname().compareTo(productdetails.getProductname()));
    		boolean a=productdetails.getProductname().equals(line.getProductname());
    		if(!a)
    		{
    			throw new Exception_class("Product name is wrong "+line.getProductname()+
    					"excepted "+productdetails.getProductname()+" for the product id "+productdetails.getProductId());
    		}
    	}
    	     
		//after getting cartdetails and cartid
		//then upadate the product based customerid given in path variable.
    		cartProxy.updateCart(cartdetail.getCartId(), car);
    		
    		return "product added to cart successfully";    	
    }
    
    @PostMapping("/api/shoppingservice/customer/{customerId}/order")
    public CustomerOrder customerOrderdetails(@PathVariable("customerId") Integer id) {
    	
    	//getting customerid to check that customer id is available in customer-cart table
    	//if its not then it throws error and invokes exception
    	
    	Optional<CustomerCart> findcart=service.findById(id);
    	
    	//checking customer is mapping to cart whether customer id is available or not
    	if(findcart.isEmpty()) {
    		throw new Exception_class("Customerid doesnot exists "+id);
    	}
    	
    	//getting all the details from cart ms
    	Integer cartId=findcart.get().getCartId();
    	
    	//getting cart from cartservice ms
    	cart cartproducts = cartProxy.getCart(cartId);
    	System.out.println("cart data "+cartproducts);
    	
    	//getting line items from by using list in cart
    	List<Lineitem> items=cartproducts.getItem();
    	System.out.println("items data "+items);
    	
    	//pass all line items to order ms to create the order
    	//setting the value to table by using setter function
    	Orderinfo order = new Orderinfo();
    	order.setId(orderId++);
    	order.setItem(items);
    	
    	//using orderProxy we are gonna to call order ms to createthe order
    	ResponseEntity<Orderinfo> orderdetails = orderProxy.createOrder(order);
    	System.out.println(" order data "+orderdetails);
    	
    	//getting cart id to empty the cart
    	//setting cart to empty by using cartProducts
    	//creating new object for cart
    	
    	cart emptycart = new cart();
    	
    	//setting the object  cartid which already from cart ms
    	emptycart.setId(cartproducts.getId());
    	
    	//and also setting the lineitem details
    	emptycart.setItem(null);
    	
    	//now creating object for lineitem
    	Lineitem line =new Lineitem();
    	
    	//by using to above object created we are gonna to set lineitem productid to 0..
    	line.setProductId(0);
    	
    	//now creating again object for lineitem
    	//but this time we are using list and arrayList
    	List<Lineitem> list = new ArrayList<>();
    	
    	//adding the above line object in this new object list
    	list.add(line);//here we have productid-->0..
    	
    	//empty the cart list method setproduct to 0
    	//so we arre sending the 0 value from  list to all line items to make null value
    	//so we are sendint the value 0 from list to all line items to make null value
    	//beacuse of string type.
    	
    	emptycart.setItem(null);
    	
    	//after the cart list it will gona to update in cart item ms
    	//because no duplicates after order is placed
    	//after that we updating cart ms
    	//to empty  the cart line items only and not to delete the cart
    	cartProxy.updateCart(cartId, emptycart);
    	
    	
    	//using for loop to iterate over lineitem
    	//to update the quantity of product after the customer order the product
    	
    	for(int  i=0;i<items.size();i++)
    	{
    		
    		System.out.println("items idd "+items.get(i).getProductId());
    		
    		//based on the id we get all inventory because it used in the list
    		Inventory inventorydetails=invenProxy.getInventory(items.get(i).getProductId());
    		
    		//checking the quantity
    		//then updated in inventory ms
    		//getting quantity details
    		int quantity = inventorydetails.getQuantity();
    		
    		//these step execute after the customer successfully order the product 
    		//and then update in inventory ms
    		int reducedQuantity= quantity-items.get(i).getQuantity();
    		System.out.println("reduced Quantity" +reducedQuantity);
    		
    		//after the the setting reducequantity in inventory details which get from  above api call
    		inventorydetails.setQuantity(reducedQuantity);
    		
    		//and then finnaly updating the inventorydetails
    		
    		invenProxy.updateInventory(items.get(i).getProductId(), inventorydetails);
    	}
    	
    	//then we have customertable which has both customer , order id to maintain
    	//how particular customer ordered product details
    	//like customer with id-- 1 had two order id like 1,2...
    	
    	CustomerOrder customerOrder  = new CustomerOrder(order.getId(),id);
    	
    	//to save it database
    	return orderservice.saveCustomerOrder(customerOrder);
    	
    }
    
    @GetMapping("/api/shoppingservice/customer/{customerId}/orders")
    public CustomerOrderDetails customerorder(@PathVariable("customerId") Integer id)
    {
    	
    	//getting customer id from customerorder table
    	List<CustomerOrder> customerorder= orderservice.findById(id);
    	
    	//checking customer is mapping to cart whether customer id is available or not
    	//then it go to exception 
    	if(customerorder.isEmpty())
    	{
    		throw new Exception_class("no id found"); 
    	}
    	
    	//getiign customerdetails by using customer ms
    	Customer customer = custProxy.getCustomer(id);
    	
    	//creating an object for orders
    	//to access orderinfo table to get the orders by using orderid
    	List<Orderinfo> orders = new ArrayList<Orderinfo>();
    	
    	//using for loop to iterate over customer order table length
    	for(CustomerOrder result: customerorder)
    	{
    		// now based on orderdetails counting in the customerorder table
    		//we are gonna to  get those order details value by using customer id
    		Orderinfo getorders=orderProxy.getOrder(result.getOrderId());
    		
    		//using add method to save in the list
    		orders.add(getorders);
    	}
    	
    	//customerdetails contain both customer and order details
    	//by using constructor we can access that
    	// then finally get both customer and order details..
    	CustomerOrderDetails newcustomerorder = new CustomerOrderDetails(customer , orders);
    	 return newcustomerorder;
    	
    }
    
    
    //getting from config server 
    //message from config server
    @GetMapping("/api/shoppingservice/message")
    public String getMessageFromConfig() {
    	return cartProxy.getMessage();
    }
}