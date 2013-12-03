package ar.com.donpepe.awardmanagement.daos;

import java.util.List;

import ar.com.donpepe.awardmanagement.domain.SaleCommission;

public interface SaleCommissionDao extends EntityWithIdDao<SaleCommission> {
List<SaleCommission> getByAmmount(Integer salesAmount);
SaleCommission getCommission(Integer salesAmount);
}
