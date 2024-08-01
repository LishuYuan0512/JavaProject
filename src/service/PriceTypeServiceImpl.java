package service;

import dao.PriceTypeDAO;
import dao.PriceTypeDAOImpl;
import utils.DbUtil;

public class PriceTypeServiceImpl implements PriceTypeService{
    PriceTypeDAO priceTypeDAO = new PriceTypeDAOImpl();
    @Override
    public String showPriceType(int priceTypeId) {
        try {
            DbUtil.begin();
            String priceType = priceTypeDAO.getPriceTypeBYID(priceTypeId);
            DbUtil.commit();
            return priceType;
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
    }
}
