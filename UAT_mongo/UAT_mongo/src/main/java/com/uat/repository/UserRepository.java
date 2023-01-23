package com.uat.repository;

//import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.uat.model.User;

public interface UserRepository extends MongoRepository<User, String>{


}
