package cn.dc.commodity.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.commodity.domain.Bill;
import cn.dc.commodity.domain.BillRepository;

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

	@RequestMapping("find_by_userId_and_isPay")
	public String findByUserIdAndIsPay(HttpServletRequest request) {
		billDao.findByUserIdAndIsPay("1", false);
		return "1";
	}
}
