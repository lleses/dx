package cn.dc.bill.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.bill.domain.Bill;
import cn.dc.bill.domain.BillRepository;

/**
 * 账单
 */
@RestController
@RequestMapping("bill")
public class BillController {

	@Autowired
	private BillRepository billDao;

	@RequestMapping("save")
	public String save(HttpServletRequest request, Bill bill) {
		billDao.save(bill);
		return "1";
	}

}
