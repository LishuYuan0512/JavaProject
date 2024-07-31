package service;

import dao.PurchaseDAO;
import dao.PurchaseDAOImpl;
import entity.Purchase;
import utils.DbUtil;


public class PurchaseServiceImpl implements PurchaseService {
    private PurchaseDAO purchaseDAO = new PurchaseDAOImpl();
    @Override
    public int recordPurchase(Purchase purchase) {
        int result = 0;
        try {
            DbUtil.begin();
            purchaseDAO.insertPurchaseRecord(purchase);
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return result;
    }
}
