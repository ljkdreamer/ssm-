package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.PostDao;
import com.dao.TransferDao;
import com.po.Transfer;
@Service("transferService")
@Transactional
public class TransferServiceImpl implements TransferService{
	@Autowired
	private PostDao postDao;
	@Autowired
	private TransferDao transferDao;
	@Override
	public String toTransferStaff(Model model) {
		String ttype[] = {"��ְ","��ְ","����¼�����"};
		model.addAttribute("afterpost",  postDao.selectAllPost());
		model.addAttribute("ttype",  ttype);
		model.addAttribute("transfer", new Transfer());
		return "transfer/addTransferStaff";
	}

	@Override
	public String addTransferStaff(Model model, Transfer transfer) {
		if("init".equals(transfer.getAct())) {
			Transfer atransfer = transferDao.selectATransfer(transfer);
			if(atransfer != null) {
				return atransfer.getSname()  + "|" + atransfer.getBeforepost_id() + "|" + atransfer.getBeforepost_name();
			}else {
				return "no";
			}
		}else {
			transferDao.addTransferStaff(transfer);
			transferDao.updateStaff(transfer);
			//�˴�����JSON�ַ���������Ҫʹ��forward
			return "transfer/selectTransferStaff";//ת����ѯ����
		}
	}

	@Override
	public String selectTransferStaff(Model model) {
		String ttype[] = {"��ְ","��ְ","����¼�����"};
		model.addAttribute("ttype",  ttype);
		model.addAttribute("transfer", new Transfer());
		model.addAttribute("transfers", transferDao.selectTransferStaff());
		return "transfer/selectTransferStaff";
	}

	@Override
	public String selectTransferCon(Model model, Transfer transfer) {
		String ttype[] = {"��ְ","��ְ","����¼�����"};
		model.addAttribute("ttype",  ttype);
		model.addAttribute("transfer", transfer);
		model.addAttribute("transfers", transferDao.selectTransferCon(transfer));
		return "transfer/selectTransferStaff";
	}

}
