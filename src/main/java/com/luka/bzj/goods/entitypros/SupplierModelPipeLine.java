package com.luka.bzj.goods.entitypros;

import com.luka.bzj.goods.entity.Goods;
import com.luka.bzj.goods.entity.Supplier;
import org.apache.commons.lang3.builder.ToStringBuilder;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.HashMap;
import java.util.Map;

public class SupplierModelPipeLine implements PageModelPipeline<Supplier> {
    static {
        Map<String,Object> map = new HashMap<String,Object>();
    }
    @Override
    public void process(Supplier supplier, Task task) {

        ToStringBuilder.reflectionToString(supplier);
    }
}
