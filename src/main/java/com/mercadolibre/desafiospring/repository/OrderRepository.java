package com.mercadolibre.desafiospring.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.desafiospring.model.Order;
import com.mercadolibre.desafiospring.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepository {

	private static List<Order> orders = new ArrayList<>();
	private static final String PATH = "src/main/resources/order.json";
	private static FileUtils fileUtils = new FileUtils();
	private static ObjectMapper objectMapper = new ObjectMapper();

	public Order createOrder(Order order) {
		try {
			orders.add(order);
			fileUtils.writeFile(PATH, orders);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return order;
	}

	public List<Order> getOrders() {
		List<Order> result = new ArrayList<Order>();
		try {
			String jsonString = FileUtils.GetFileToString(PATH);
			Order[] arrOrder = objectMapper.readValue(jsonString, Order[].class);

			for (int i = 0; i < arrOrder.length; i++) {
				result.add(arrOrder[i]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;

	}

}