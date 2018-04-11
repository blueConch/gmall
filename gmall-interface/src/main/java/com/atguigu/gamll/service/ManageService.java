package com.atguigu.gamll.service;

import com.atguigu.gamll.bean.*;

import java.util.List;

/**
 * @param
 * @return
 */
public interface ManageService {


    public List<BaseCatalog1> getCatalog1();

    public List<BaseCatalog2> getCatalog2(String catalog1Id);

    public List<BaseCatalog3> getCatalog3(String catalog2Id);

    public List<BaseAttrInfo> getAttrList(String catalog3Id);

    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) ;


    public BaseAttrInfo getAttrInfo(String id) ;


    public List<SpuInfo> getSpuInfoList(SpuInfo spuInfo);
}
