package com.handashi.test.rabbitmq;

public class Producer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*// RabbitMq 에 연결
		CachingConnectionFactory cf = new CachingConnectionFactory("127.0.0.1", 5672);
		
		cf.setUsername("guest");
		cf.setPassword("guest");
		
		// 메시지 보내기
		RabbitTemplate template = new RabbitTemplate(cf	);
		
		template.setExchange("amq.direct");
		template.setQueue("myQueue");
		template.convertAndSend("foo.bar", "Hello, world!");
		cf.destroy();*/
		
		
		
	}

}
