package com.turkcell.productservice.repositories;

import com.turkcell.productservice.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product,String> {

    //DERİVED QUARY METHOD
        Product  findByInventoryCode(String inventoryCode);//BİRBİRİNE ALTARNETİF ÇÖZÜMLEMELER.
        @Query("{'inventoryCode':?0}") //?0 Demek parametlerden 0 indeksli olanı al demek.BİRBİRİNE ALTARNETİF ÇÖZÜMLEMELER.
        Product  findByInventoryCodeQuery(String invCode);



}
