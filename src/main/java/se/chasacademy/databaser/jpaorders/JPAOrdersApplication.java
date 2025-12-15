package se.chasacademy.databaser.jpaorders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.transaction.Transactional;
import se.chasacademy.databaser.jpaorders.models.Customer;
import se.chasacademy.databaser.jpaorders.models.Order;
import se.chasacademy.databaser.jpaorders.repositories.CustomerRepository;
import se.chasacademy.databaser.jpaorders.repositories.OrderRepository;

@SpringBootApplication
public class JPAOrdersApplication implements CommandLineRunner {

	private CustomerRepository customerRepository;
	private OrderRepository orderRepository;

	public JPAOrdersApplication(CustomerRepository customerRepository, OrderRepository orderRepository) {
		this.customerRepository = customerRepository;
		this.orderRepository = orderRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(JPAOrdersApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
        System.out.println("-----------------------------------");
        for (Customer customer : customerRepository.findAll()) {
			System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName() + ", created at: "
					+ customer.getCreatedAt());

			customer.getOrders().forEach(order -> {
				System.out.println(" Order: " + order.getNumber() + ", date: " +
						order.getOrderDate() + ", status: "
						+ order.getStatusCode());
			});
		}

        System.out.println("-----------------------------------");

        orderRepository.findAll().forEach( o -> {System.out.println(o); o.getOrder_entries().forEach(ol->System.out.println("  "+ol.getQuantity()+"x "+ol.getProduct()+ " " + ol.getTotal_Price_Cents()));  });

        System.out.println("-----------------------------------");

	}
}
