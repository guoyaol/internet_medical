package org.linlinjava.internetmedical.db.dao;

import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalOrder;
import org.linlinjava.internetmedical.db.domain.OrderVo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int updateWithOptimisticLocker(@Param("lastUpdateTime") LocalDateTime lastUpdateTime, @Param("order") InternetmedicalOrder order);
    List<Map> getOrderIds(@Param("query") String query, @Param("orderByClause") String orderByClause);
    List<OrderVo> getOrderList(@Param("query") String query, @Param("orderByClause") String orderByClause);
}