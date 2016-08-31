package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {
	@Autowired(required=true)
	private SupplierDAO supplierDAO;
	@Autowired(required=true)
	@Qualifier(value="supplierDAO")
	public void setSupplierDAO(SupplierDAO ps)
	{
		this.supplierDAO=ps;
	}
	@RequestMapping(value = "/suppliers",method =RequestMethod.GET)
	public String listSuppliers(Model model)
	{
		model.addAttribute("supplier",new Supplier());
		model.addAttribute("supplierList", this.supplierDAO.list());
		return "supplier";
	}
	@RequestMapping(value="/supplier/add",method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier)
	{
		supplierDAO.save(supplier);
		supplierDAO.update(supplier);
		return "redirect:/suppliers";
	}
	/*@RequestMapping("supplier/remove/{id}")
	public String removeSupplier(@PathVariable("id") String id,ModelMap model) throws Exception
	{
		try{
			supplierDAO.delete(id);
			model.addAttribute("message","successfully added");
		}
		catch(Exception e){
			model.addAttribute("message",e.getMessage());
			e.printStackTrace();
			}
		return "redirect:/suppliers";
	}*/
	@RequestMapping("supplier/edit/{id}")
	public String editSupplier(@PathVariable("id")String id,Model model)
	{
		System.out.println("editsupplier");
		model.addAttribute("supplier",this.supplierDAO.get(id));
		model.addAttribute("listsuppliers",this.supplierDAO.list());
		return "supplier";
	}
	
}
