package com.crm.filrouge;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crm.filrouge.dao.Client.Client;
import com.crm.filrouge.dao.Order.Order;
import com.crm.filrouge.service.CommandFlowService;

@SpringBootTest
class FilrougeApplicationTests {

	@Autowired
	private CommandFlowService commandFlowService;

	@Test
	void getAllClients() {
		List<Client> clients = commandFlowService.getAllClients();
		for (Client client : clients) {
			System.out.println(client);
		}
	}

	@Test
	void getAllOrders() {
		List<Order> orders = commandFlowService.getAllOrders();
		for (Order order : orders) {
			System.out.println(order);
		}
	}

}
