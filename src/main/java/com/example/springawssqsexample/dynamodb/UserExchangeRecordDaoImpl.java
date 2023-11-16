package com.example.springawssqsexample.dynamodb;

import com.example.springawssqsexample.dynamodb.entity.UserExchangeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

import java.time.Instant;
import java.util.Date;

@Repository
public class UserExchangeRecordDaoImpl implements UserExchangeRecordDao {
	
	private static final String CREATED = "CREATED";

	@Autowired
	private DynamoDbEnhancedClient enhancedClient;

	@Override
	public UserExchangeEntity createUserExchangeRecord() {

		DynamoDbTable<UserExchangeEntity> userExchangeTable = enhancedClient.table("test",
				TableSchema.fromBean(UserExchangeEntity.class));
		UserExchangeEntity user = new UserExchangeEntity();
		user.setCreatedOn(Instant.now());
		user.setPK(new Date().getTime()+"");
		user.setSK(Instant.now()+"");
		user.setPayload("json");
		user.setUpdatedOn(Instant.now());
		user.setStatus(CREATED);
		// Retry count need to be modified when retry is introduced.
		user.setRetryCount(0);

		userExchangeTable.putItem(user);

		return user;
	}

}
