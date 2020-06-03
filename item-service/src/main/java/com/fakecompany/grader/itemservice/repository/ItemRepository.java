package com.fakecompany.grader.itemservice.repository;

import com.fakecompany.grader.common.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String>
{
}
