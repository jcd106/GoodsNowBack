package com.revature.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.*;
import com.revature.repositories.*;

/**
 * Implementation for CartItemService
 * @author Josh Dughi
 */
@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemRepository cartItemRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Autowired
	SellerRepository sellerRepo;
	
	@Override
	public CartItem addCartItem(CartItem newCartItem) {
		for (CartItem cartItem : findAllCartItems()) {
			if (cartItem.getCustomer().getCustomerId() == newCartItem.getCustomer().getCustomerId()
					&& cartItem.getItem().getItemId() == newCartItem.getItem().getItemId()) {
				int currQuant = cartItem.getQuantity();
				int newQuant = newCartItem.getQuantity();
				newCartItem.setQuantity(currQuant + newQuant);
			}
		}
		return cartItemRepo.save(newCartItem);
	}

	@Override
	public List<CartItem> findAllCartItems() {
		return cartItemRepo.findAll();
	}

	@Override
	public CartItem findCartItemByItemIdAndCustomerId(int itemId, int customerId) {
		return cartItemRepo.findCartItemByCartItemIdItemItemIdAndCartItemIdCustomerCustomerId(itemId, customerId);
	}

	@Override
	public List<CartItem> findCartItemsByCustomerId(int customerId) {
		return cartItemRepo.findCartItemsByCartItemIdCustomerCustomerId(customerId);
	}

	@Override
	public CartItem updateCartItemById(CartItem updatedCartItem) {
		return cartItemRepo.save(updatedCartItem);
	}

	@Override
	public void deleteCartItem(CartItem deleteCartItem) {
		cartItemRepo.delete(deleteCartItem);
	}
	
	@Override
	public Order checkout(Order newOrder) {
		Order order = orderRepo.save(newOrder);
		List<CartItem> cartItems = findCartItemsByCustomerId(order.getCustomer().getCustomerId());
		for (CartItem cartItem : cartItems) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItem(cartItem.getItem());
			orderItem.setOrder(order);
			orderItem.setQuantity(cartItem.getQuantity());
			Seller seller = cartItem.getItem().getSeller();
			System.out.println(seller.getMoney());
			seller.setMoney(seller.getMoney() + cartItem.getItem().getPrice() * cartItem.getQuantity());
			System.out.println(seller.getMoney());
			sellerRepo.save(seller);
			orderItemRepo.save(orderItem);
			cartItemRepo.delete(cartItem);
		}
		return order;
	}

}
