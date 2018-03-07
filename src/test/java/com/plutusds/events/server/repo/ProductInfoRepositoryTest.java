package com.plutusds.events.server.repo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.plutusds.events.server.Server;
import com.plutusds.events.server.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Server.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = {
        "amazon.dynamodb.endpoint=http://localhost:8000/",
        "amazon.aws.accesskey=test1",
        "amazon.aws.secretkey=test231" })
public class ProductInfoRepositoryTest {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private CustomerRepository customerRepository;

    private static final String EXPECTED_COST = "20";
    private static final String EXPECTED_PRICE = "50";

    @Before
    public void setup() throws Exception {

        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        System.out.println("hello-----");

//        CreateTableRequest tableRequest = dynamoDBMapper
//                .generateCreateTableRequest(Customer.class);
//        tableRequest.setProvisionedThroughput(
//                new ProvisionedThroughput(1L, 1L));
//        amazonDynamoDB.createTable(tableRequest);
//
//        //...

        dynamoDBMapper.batchDelete(
                (List<Customer>)customerRepository.findAll());
    }

    @Test
    public void sampleTestCase() {
//        ProductInfo dave = new ProductInfo(EXPECTED_COST, EXPECTED_PRICE);
//        productInfoRepository.save(dave);
//
//        List<ProductInfo> result
//                = (List<ProductInfo>) productInfoRepository.findAll();
//
//        assertTrue("Not empty", result.size() > 0);
//        assertTrue("Contains item with expected cost",
//                result.get(0).getCost().equals(EXPECTED_COST));
    }

}