package com.luka.bzj.goods.entitypros;

import com.luka.bzj.goods.entity.Goods;
import com.luka.bzj.goods.entity.Supplier;
import com.luka.bzj.goods.mapper.SupplierMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.HashMap;
import java.util.Map;

public class GoodsModelPepeline implements PageModelPipeline<Goods> {
    static volatile Map<String,Object> map = new HashMap<String,Object>();
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public void process(Goods goods, Task task) {
        Supplier supplier = new Supplier ();
        supplier.setLocation(parseString(goods.getSpllocation()));
        supplier.setModel(parseString(goods.getSplmodel()));
        supplier.setName(parseString(goods.getSplname()));
        supplier.setPhone(parseString(goods.getSplphone()));
        supplier.setDetails(parseString(goods.getSpldetails()));
        supplier.setBrandName(parseString(goods.getBrandName()));
        supplier.setContactName(parseString(goods.getContactName()));
        supplier.setContactTel(parseString(goods.getContactTel()));

        supplierMapper.insert(supplier);
        //品牌id
        Integer supplierId = supplier.getId();
        System.out.println("===========================");


        System.out.println(ToStringBuilder.reflectionToString(goods));
    }



    public String parseString (Object o){
        if (o == null){
            return "";
        }else{
            String[] split = o.toString().split(":");
            if (split.length > 1){
                return split[1];
            }else{
                return "";
            }
        }
    }
}
